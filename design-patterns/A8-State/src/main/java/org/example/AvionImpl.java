package org.example;

public class AvionImpl implements Avion {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public AvionImpl() {
        state = new EtatEnPiste(this);
    }

    @Override
    public void sortirDuGarage() {
        state.executeSortirDuGarage();
    }

    @Override
    public void entrerAuGarage() {
        state.executeEntrerAuGarage();
    }

    @Override
    public void decoller() {
        state.executeDecoller();
    }

    @Override
    public void atterrir() {
        state.executeAtterrir();
    }

    @Override
    public void doActivity() {
        state.executeDoActivity();
    }

}
