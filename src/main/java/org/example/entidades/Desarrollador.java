package org.example.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "desarrolladores")
public class Desarrollador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int edad;
    @Column
    private double sueldo;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PK_director", referencedColumnName = "id")
    private Director director;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "desarrolladores")
    private List<Herramienta> herramientas;

    public Desarrollador() {
    }

    public Desarrollador(String nombre, int edad, double sueldo, Director director, List<Herramienta> herramientas) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.director = director;
        this.herramientas = herramientas;
    }

    public int getId() {
        return id;
    }
/*
    public void setId(int id) {
        this.id = id;
    }
*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Herramienta> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(List<Herramienta> herramientas) {
        this.herramientas = herramientas;
    }

    @Override
    public String toString() {
        return "Desarrollador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sueldo=" + sueldo +
                //", director=" + director +
                //", herramientas=" + herramientas +
                '}';
    }
}
