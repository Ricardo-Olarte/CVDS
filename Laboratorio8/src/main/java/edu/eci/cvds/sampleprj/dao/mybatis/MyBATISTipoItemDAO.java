package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBATISTipoItemDAO implements TipoItemDAO {

    @Inject
    private TipoItemMapper tipoItemMapper;

    @Override
    public void save(String tipoItem) throws org.apache.ibatis.exceptions.PersistenceException {
        try {
            tipoItemMapper.addTipoItem(tipoItem);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al agregar el item");
        }
    }

    @Override
    public TipoItem load(int id) throws org.apache.ibatis.exceptions.PersistenceException {
        try {
            return tipoItemMapper.getTipoItem(id);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar el tipo de item");
        }
    }


    @Override
    public List<TipoItem> load() throws org.apache.ibatis.exceptions.PersistenceException {
        try{
            return tipoItemMapper.getTiposItems();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el tipo de los items");
        }
    }
}
