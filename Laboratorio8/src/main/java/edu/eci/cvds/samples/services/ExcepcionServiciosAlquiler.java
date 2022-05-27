package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception{

    public ExcepcionServiciosAlquiler(String message) {
        super(message);
    }

    public ExcepcionServiciosAlquiler(String message, Exception e){
        super(message, e);
    }

}
