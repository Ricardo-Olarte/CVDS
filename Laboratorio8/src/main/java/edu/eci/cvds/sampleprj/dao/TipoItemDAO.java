package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

import java.util.List;

public interface TipoItemDAO {

    public void save(String tipoItem) throws PersistenceException;

    public List<TipoItem> load() throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;
}
