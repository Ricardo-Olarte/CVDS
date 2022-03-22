package edu.eci.cvds.guess;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@SessionScoped

public class Guess {




    private int numaadivinar =(int) (Math.random() * 10);
    private int intentos;
    private String numingresado;
    private int premio;
    private String status;

    public Guess(){
    }

    public void guess(String numero){
        numingresado = numero;
        if (numaadivinar == Integer.parseInt(numero)){
            premio += 100000;
            status = "Ganó 100000 puntos";
        }
        else{
            premio -= 10000;
            status = "No ganó";
            intentos += 1;
        }
    }

    public void restart(){
        setPremio(0);
        setNumaadivinar((int) (Math.random() * 10));
        setIntentos(0);
        setStatus("no a ganado");
    }

    public int getNumaadivinar() {
        return numaadivinar;
    }

    public int getIntentos() {
        return intentos;
    }

    public String getNumingresado() {
        return numingresado;
    }

    public int getPremio() {
        return premio;
    }

    public String getStatus() {
        return status;
    }

    public void setNumaadivinar(int numaadivinar) {
        this.numaadivinar = numaadivinar;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void setNumingresado(String numingresado) {
        this.numingresado = numingresado;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
