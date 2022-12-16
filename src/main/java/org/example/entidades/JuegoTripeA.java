package org.example.entidades;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "A")
public class JuegoTripeA extends Juego{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private double presupuesto;

    public JuegoTripeA() {
    }

    public JuegoTripeA(String nombre, int anyo, String genero, Director director, double presupuesto) {
        super(nombre, anyo, genero, director);
        this.presupuesto = presupuesto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "JuegoTripeA{" +
                "nombre='" + nombre + '\'' +
                ", anyo=" + anyo +
                ", Genero='" + Genero + '\'' +
                '}';
    }
}
