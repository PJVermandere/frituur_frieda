package be.vdab.frituur_frieda.domain;

public final class Adres {
    private final String straat, huisNr;
    private final Gemeente gemeente;

    public Adres(String straat, String huisNr, Gemeente gemeente) {
        this.straat = straat;
        this.huisNr = huisNr;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }
}
