package org.example;

abstract class State {
    protected AvionImpl avion;

    public State(AvionImpl avion) {
        this.avion = avion;
    }

    abstract void executeSortirDuGarage();

    abstract void executeEntrerAuGarage();

    abstract void executeDecoller();

    abstract void executeAtterrir();

    abstract void executeDoActivity();
}
