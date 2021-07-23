package be.vdab.frituur_frieda.domain;

import java.math.BigDecimal;

public final class Sauzen {
    private final long nummer;
    private final String naam;
    private final String[] ingredienten;
    private final BigDecimal prijs;

    public Sauzen(long nummer, String naam, String[] ingredienten, BigDecimal prijs) {
        this.nummer = nummer;
        this.naam = naam;
        this.ingredienten = ingredienten;
        this.prijs = prijs;
    }

    public long getNummer() {
        return nummer;
    }

    public String getNaam() {
        return naam;
    }

    public String[] getIngredienten() {
        return ingredienten;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }
}
