package org.example;

public class EtatEnPiste extends State {

    public EtatEnPiste(AvionImpl avion) {
        super(avion);
    }

    @Override
    void executeSortirDuGarage() {
        System.out.println("Impossible de Sortir du garage, je suis déjà en piste.");
    }

    @Override
    void executeEntrerAuGarage() {
        System.out.println("Transition d'état: En piste => Au garage");
        avion.setState(new EtatAuGarage(avion));
    }

    @Override
    void executeDecoller() {
        System.out.println("Transition d'état: En piste => Décollage");
        avion.setState(new EtatEnLair(avion));

    }

    @Override
    void executeAtterrir() {
        System.out.println("Impossible, je suis déjà en piste.");

    }

    @Override
    void executeDoActivity() {
        System.out.println("Activité de l'état en piste....");
    }
}

