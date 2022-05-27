package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

import java.util.Date;
import java.util.List;

public interface ClienteDAO {
    public Cliente load(int docu) throws PersistenceException;

    public List<Cliente> clientes() throws PersistenceException;

    public void save(int id, int idit, java.util.Date fechainicio, Date fechafin) throws PersistenceException;

    public void saveCliente(Cliente c) throws PersistenceException;
}
