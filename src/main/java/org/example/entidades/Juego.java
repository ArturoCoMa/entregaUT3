package org.example.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Juegos")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "J")
public class Juego implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String nombre;

    @Column
    public int anyo;

    @Column
    public String Genero;
    @OneToOne(mappedBy = "juego", cascade = CascadeType.PERSIST)
    public Director director;

    public Juego() {
    }

    public Juego(String nombre, int anyo, String genero, Director director) {
        this.nombre = nombre;
        this.anyo = anyo;
        Genero = genero;
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anyo=" + anyo +
                ", Genero='" + Genero + '\'' +
                ", director=" + director +
                '}';
    }
}
