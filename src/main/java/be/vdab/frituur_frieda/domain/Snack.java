package be.vdab.frituur_frieda.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Snack {
    private final long id;
    private final String name;
    private final BigDecimal price;

    public Snack(String name, BigDecimal price){
        id = 0L;
        this.name = name;
        this.price = price;
    }

    public Snack(long id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getPrice(){ return price; }

    @Override
    public String toString(){
        return "{snack: "+name+", id: "+id+", price: "+price+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return getId() == snack.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
