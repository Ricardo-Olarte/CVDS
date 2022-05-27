package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception{

    public PersistenceException(String message, Exception persistenceException){
        super(message, persistenceException);
    }
}
