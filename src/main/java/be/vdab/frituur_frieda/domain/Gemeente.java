package be.vdab.frituur_frieda.domain;

public final class Gemeente {
    private final String gemeente;
    private final int postCode;

    public Gemeente(String gemeente, int postCode) {
        this.gemeente = gemeente;
        this.postCode = postCode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public int getPostCode() {
        return postCode;
    }
}
