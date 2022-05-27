package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;

import java.util.List;

public interface ItemDAO {

    public void save(Item it) throws PersistenceException;

    public Item load(int id) throws PersistenceException;

    List<Item> items() throws  PersistenceException;

    void registrarItem(Item i) throws PersistenceException;
}