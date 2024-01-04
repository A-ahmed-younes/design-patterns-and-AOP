package org.example.util;

import org.example.util.Utilitaire;

public class UtilitaireImpl2 extends Utilitaire {
    @Override
    protected double filtre1(String str) {
        return Math.pow(str.length(),2);
    }

    @Override
    protected double filtre2(double x) {
        return x*5;
    }
}
