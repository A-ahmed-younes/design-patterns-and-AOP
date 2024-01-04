package org.example;

public class EtatEnLair extends State {

    public EtatEnLair(AvionImpl avion) {
        super(avion);
    }

    @Override
    void executeSortirDuGarage() {
        System.out.println("Impossible de sortir du garage, je suis déjà en l'air");
    }

    @Override
    void executeEntrerAuGarage() {
        System.out.println("Impossible d'entrer au garage, je suis déjà en l'air");
    }

    @Override
    void executeDecoller() {
        System.out.println("Impossible de décoller, je suis déjà en l'air");


    }

    @Override
    void executeAtterrir() {
        System.out.println("Transition d'état: En l'air => Piste");
        avion.setState(new EtatEnPiste(avion));
    }

    @Override
    void executeDoActivity() {
        System.out.println("Activité de l'état en l'air....");
    }
}
