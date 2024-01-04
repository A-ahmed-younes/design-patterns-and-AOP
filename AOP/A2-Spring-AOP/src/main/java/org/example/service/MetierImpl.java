package org.example.service;

import org.example.aspects.Log;
import org.example.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles = {"USER", "ADMIN"}) // both USER and ADMIN have access to this method
    public void process() {
        System.out.println("Business Process ...");

    }

    @Override
    @Log
    @SecuredByAspect(roles = {"ADMIN"}) // ADMIN is the only one who can access this method
    public double compute() {
        double x = 56;
        System.out.println("Business Compute ...");
        return x;
    }
}
