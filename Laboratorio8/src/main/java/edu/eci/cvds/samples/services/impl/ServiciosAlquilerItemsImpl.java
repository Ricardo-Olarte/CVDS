package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import org.mybatis.guice.transactional.Transactional;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ServiciosAlquilerItemsImpl implements ServiciosAlquiler {

    @Inject
    private ItemDAO itemDAO;

    @Inject
    private ClienteDAO clienteDAO;

    @Inject
    private TipoItemDAO tipoItemDAO;

    @Override
    public int valorMultaRetrasoxDia(int itemId) {
        try {
            return (int) itemDAO.load(itemId).getTarifaxDia();
        }catch (PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        try{
         return clienteDAO.load((int) docu);
        }catch (PersistenceException e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try{
         return clienteDAO.clientes();
        }catch (PersistenceException e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        try {
            return itemDAO.items();
        }catch (PersistenceException e) {
            throw new UnsupportedOperationException("Not supported yet.", e);
        }
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        try {
            List<Cliente> clientes = consultarClientes();
            for (int i=0 ; i<clientes.size() ; i++) {
                ArrayList<ItemRentado> rentados = clientes.get(i).getRentados();
                for (int j=0 ; j<rentados.size() ; j++) {
                    if(rentados.get(j).getItem()!=null){
                        if (rentados.get(j).getItem().getId() == iditem) {
                            long diasRetraso = ChronoUnit.DAYS.between(rentados.get(j).getFechafinrenta().toLocalDate(), fechaDevolucion.toLocalDate());
                            if (diasRetraso < 0) {
                                return 0;
                            }
                            return diasRetraso * valorMultaRetrasoxDia(rentados.get(j).getId());
                        }
                    }
                }
            }
            return iditem;
        } catch (Exception e) {
            throw  new ExcepcionServiciosAlquiler("Error al consultar multa de item con id: "+iditem);
        }
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.load(id);
        }catch (PersistenceException e) {
            throw new UnsupportedOperationException("Not supported yet.", e);
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.load();
        }catch (PersistenceException e) {
            throw new UnsupportedOperationException("Not supported yet.", e);
        }
    }

    @Transactional
    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
        try{
            if (numdias <=0 ) throw new ExcepcionServiciosAlquiler("los dias son invalidos");
            consultarCliente(docu); consultarItem(item.getId());
            clienteDAO.save((int)docu, item.getId(), date, Date.valueOf(date.toLocalDate().plusDays(numdias)));
        } catch (org.apache.ibatis.exceptions.PersistenceException | PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al registrar alquiler al cliente.");
        }
    }

    @Transactional
    @Override
    public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
        try{
            clienteDAO.saveCliente(c);
        }catch (PersistenceException e) {
            throw new UnsupportedOperationException("None.", e);
        }
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        try {
            itemDAO.registrarItem(i);
        }catch (PersistenceException e) {
            throw new UnsupportedOperationException("Not supported yet.", e); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}