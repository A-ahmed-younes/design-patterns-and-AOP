package org.example;

public interface Avion {
    void sortirDuGarage(); // Opération de transition d'état
    void entrerAuGarage();
    void decoller();
    void atterrir();
    void doActivity(); // Activité
}
