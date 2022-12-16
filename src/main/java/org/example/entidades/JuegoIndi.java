package org.example.entidades;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "I")
public class JuegoIndi  extends Juego{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int ventas;

    public JuegoIndi() {
    }

    public JuegoIndi(String nombre, int anyo, String genero, Director director, int ventas) {
        super(nombre, anyo, genero, director);
        this.ventas = ventas;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "JuegoIndi{" +
                "nombre='" + nombre + '\'' +
                ", anyo=" + anyo +
                ", Genero='" + Genero + '\'' +
                '}';
    }
}
