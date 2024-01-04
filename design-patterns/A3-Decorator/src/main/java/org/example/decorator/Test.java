package org.example.decorator;

import org.example.components.Boisson;
import org.example.components.Sumatra;

public class Test {
    public static void main(String[] args) {

        Boisson boisson;
        boisson = new Sumatra();
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("----------------------------");
        boisson = new Chocolat(new Caramel(new Chocolat(new Caramel(boisson))));
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
    }
}
