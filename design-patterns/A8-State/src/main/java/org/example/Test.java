package org.example;

public class Test {
    public static void main(String[] args) {
        Avion avion = new AvionImpl();
        avion.doActivity();
        System.out.println("------------------");
        avion.sortirDuGarage();
        System.out.println("------------------");
        avion.doActivity();
        System.out.println("------------------");
        avion.entrerAuGarage();
        System.out.println("------------------");
        avion.doActivity();
        System.out.println("------------------");
        avion.decoller();
        avion.atterrir();
        avion.sortirDuGarage();
        avion.doActivity();
        avion.decoller();
        avion.doActivity();
        avion.entrerAuGarage();
        avion.decoller();
        avion.atterrir();
        avion.doActivity();

    }
}
