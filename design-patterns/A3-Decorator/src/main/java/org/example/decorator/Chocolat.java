package org.example.decorator;

import org.example.components.Boisson;

public class Chocolat extends DecoratorBoisson {
    public Chocolat(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au chocolat";
    }

    @Override
    public double cout() {
        return 0.3 + boisson.cout();
    }
}
