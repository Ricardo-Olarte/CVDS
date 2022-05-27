package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;

import java.util.Date;
import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO {

    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public Cliente load(int docu) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(docu);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente" + docu, e);
        }
    }

    @Override
    public List<Cliente> clientes() throws PersistenceException {
        try{
            return clienteMapper.consultarClientes();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar la lista de clientes", e);
        }
    }

    @Override
    public void save(int id, int idit, Date fechainicio, Date fechafin) throws PersistenceException {
        try {
            clienteMapper.agregarItemRentadoACliente(id,idit,fechainicio,fechafin);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al añadir el cliente" + id, e);
        }
    }

    @Override
    public void saveCliente(Cliente cliente) throws org.apache.ibatis.exceptions.PersistenceException {
        try{
            clienteMapper.agregarCliente(cliente);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar la lista de clientes", e);
        }
    }

}
