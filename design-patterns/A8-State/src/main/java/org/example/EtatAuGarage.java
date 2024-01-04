package org.example;


public class EtatAuGarage extends State {

    public EtatAuGarage(AvionImpl avion) {
        super(avion);
    }

    @Override
    void executeSortirDuGarage() {
        System.out.println("Transition d'état de Garage => En piste");
        avion.setState(new EtatEnPiste(avion));

    }

    @Override
    void executeEntrerAuGarage() {
        System.out.println("Impossible, je suis déjà au garage");

    }

    @Override
    void executeDecoller() {
        System.out.println("Impossible de décoller, je suis déjà au garage");


    }

    @Override
    void executeAtterrir() {
        System.out.println("Impossible d'atterir, je suis déjà au garage");


    }

    @Override
    void executeDoActivity() {
        System.out.println("Activité de l'état au garage");


    }
}
