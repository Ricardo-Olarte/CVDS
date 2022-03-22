package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("Pepe",123456789,25,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    // TODO Complete with more test cases
    @Test
    public void validatePersonDEAD(){

        Person person = new Person("Pepe",1000000000,25,Gender.MALE,false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validatePersonINVALID_AGE(){

        Person person = new Person("Pepe",1000000000,-25,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validatePersonUNDERRAGE(){

        Person person = new Person("Pepe",1000000000,0,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validatePersonDUPLICATED(){

        Person person = new Person("Pepe",1000000000,25,Gender.MALE,true);
        Person personSame = new Person("Pepe",1000000000,25,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);
        RegisterResult result2 = registry.registerVoter(personSame);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }

    @Test
    public void validatePerson(){

        Person person = new Person("Pepe",1000000000,25,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
}