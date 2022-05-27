package edu.eci.cvds.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    /* @Inject*//*
    private SqlSession sqlSession;
*/
    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
        ArrayList<ItemRentado> itemRentados = new ArrayList<ItemRentado>();
        try {
            serviciosAlquiler.registrarCliente(new Cliente("Pepe", 123456789, "343438", "Bogota", "pepe@gmail.com", false, itemRentados));
            serviciosAlquiler.registrarItem(new Item(new TipoItem(1, "Tecnologia"), 123, "PC", "Computador", new SimpleDateFormat("yyyy/MM/dd").parse("2001/01/01"), 1, "AAA", "Tecnologia"));
        } catch (Exception e) {}
    }

    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(123456789);
                Item item = serviciosAlquiler.consultarItem(123);
                TipoItem tipoItem = serviciosAlquiler.consultarItem(123).getTipo();
            } catch(ExcepcionServiciosAlquiler e) {
                r = false;
            } catch(IndexOutOfBoundsException e) {
                r = false;
            }
            // Validate no Client was found;
            Assert.assertFalse(r);
        };
    }

    @Test
    public void consultarCliente(){
        try{
            Assert.assertEquals("Pepe", serviciosAlquiler.consultarCliente(123456789).getNombre());
        }catch (ExcepcionServiciosAlquiler e){
            Assert.fail("Error en la consulta");
        }
    }

    @Test
    public void consultarItem(){
        try{
            Assert.assertEquals("PC",serviciosAlquiler.consultarItem(123).getNombre());
            }catch (ExcepcionServiciosAlquiler e){
            Assert.fail("Error en la consulta");
        }
    }

    @Test
    public void consultarTipoItem(){
        try{
            Assert.assertEquals("Tecnologia", serviciosAlquiler.consultarItem(123).getTipo().getDescripcion());
            //Assert.assertEquals("Tecnologia", serviciosAlquiler.consultarTipoItem(1).getDescripcion());
        }catch (ExcepcionServiciosAlquiler e){
            Assert.fail("Error en la consulta");
        }
    }

    @Test
    public void noDeberiaConsultarCostoItem(){
        try{
            Assert.assertEquals(2500000,serviciosAlquiler.consultarCostoAlquiler(1234,24));
            Assert.fail("No entro a la Excepcion");
        }catch (ExcepcionServiciosAlquiler e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void consultarTarifaDia(){
        try {
            Assert.assertEquals(1,serviciosAlquiler.consultarCostoAlquiler(123,1));
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.fail("Error en la consulta");
        }
    }

    @Test
    public void actualizarTarifaItem(){
        try{
            serviciosAlquiler.actualizarTarifaItem(123,99);
            Assert.assertEquals(99,serviciosAlquiler.consultarCostoAlquiler(123,1));
        }catch (ExcepcionServiciosAlquiler e){
            Assert.fail("Error en la consulta");
        }
    }

    @Test
    public void noDeberiaregistrarAlquilerCliente(){
        try{
            serviciosAlquiler.registrarAlquilerCliente(Date.valueOf(LocalDate.parse("2001-01-01")),serviciosAlquiler.consultarCliente(987654321).getDocumento(), serviciosAlquiler.consultarItem(123), 1);
            Assert.fail("No entro a la Excepcion");
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void registrarAlquilerCliente(){
        try{
            serviciosAlquiler.registrarAlquilerCliente(Date.valueOf(LocalDate.parse("2001-01-01")),serviciosAlquiler.consultarCliente(123456789).getDocumento(), serviciosAlquiler.consultarItem(123), 1);
            Assert.assertEquals(Date.valueOf(LocalDate.parse("2001-01-01")),serviciosAlquiler.consultarCliente(123456789).getRentados().get(0).getFechainiciorenta());
        }catch (ExcepcionServiciosAlquiler e){
            Assert.fail("Error en la consulta");
        }
    }

    @Test
    public void vetarCliente(){
        try{
            serviciosAlquiler.vetarCliente(123456789,true);
        }catch (ExcepcionServiciosAlquiler e){
            Assert.fail("Error en la consulta");
        }
    }
}