package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    ArrayList<Integer> ids = new ArrayList<Integer>();
    public RegisterResult registerVoter(Person p) {
        RegisterResult registerResult = null;
        if(!p.isAlive()) {
            registerResult = RegisterResult.DEAD;
        } else if (p.getAge() < 0 || p.getAge() > 150) {
            registerResult = RegisterResult.INVALID_AGE;
        } else if (0<= p.getAge() && p.getAge() < 18) {
            registerResult = RegisterResult.UNDERAGE;
        } else if(ids.contains(p.getId())) {
            registerResult = RegisterResult.DUPLICATED;
        } else{
            ids.add(p.getId());
            registerResult = RegisterResult.VALID;
        }
        // TODO Validate person and return real result.
        return registerResult;
    }
}