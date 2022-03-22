package edu.eci.cvds.tdd.aerodescuentos;

/**
 Las pruebas de validateDiasAntelacionErroneo, validateEdadErronea01 y
 validateEdadErronea02 generan un error, sin embargo esto es debido a
 un problema desde el ejecutable de java
 **/

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest{

    @Test
    public void DeberiaValidarEdad(){
        double tarifaBase = 50000;
        int diasAntelacion = 0;
        int edad = -10;

        double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals("ExcepcionParametrosInvalidos",tarifa);
    }

    @Test
    public void DeberiaValidarEdad01(){
        double tarifaBase = 50000;
        int diasAntelacion = 0;
        int edad = 1000;

        double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals("ExcepcionParametrosInvalidos",tarifa);
    }

    @Test
    public void DeberiaValidarEdad02(){
        double tarifaBase = 50000;
        int diasAntelacion = 21;
        int edad = 50;
        double ans = 42500.0;

        double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertTrue(ans==tarifa);
    }

    @Test
    public void DeberiaValidarDias(){
        double tarifaBase = 3000;
        int diasAntelacion = -47;
        int edad = 20;

        double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals("ExcepcionParametrosInvalidos",tarifa);
    }

    @Test
    public void DeberiaValidarDias01(){
        double tarifaBase = 80000;
        int diasAntelacion = 0;
        int edad = 20;
        double ans = 80000.0;

        double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertTrue(tarifa==ans);
    }

    @Test
    public void DeberiaValidarDias02(){
        double tarifaBase = 65000;
        int diasAntelacion = 35;
        int edad = 80;
        double ans = 50050.0;

        double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertTrue(tarifa==ans);
    }
}