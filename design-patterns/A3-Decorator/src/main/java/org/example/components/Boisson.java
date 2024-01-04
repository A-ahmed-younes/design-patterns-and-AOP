package org.example.components;

public abstract class Boisson {
    protected String description;

    public Boisson(){

    }

    public String getDescription() {
        return description;
    }

    public abstract double cout();
}
