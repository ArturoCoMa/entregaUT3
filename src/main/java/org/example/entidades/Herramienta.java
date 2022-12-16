package org.example.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Herramientas")
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Herramienta-Desarrollador",
            joinColumns = {@JoinColumn(name = "Herramienta", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Desarrollador", referencedColumnName = "id")}
    )
    private List<Desarrollador> desarrolladores;

    public Herramienta() {
    }

    public Herramienta(String nombre, List<Desarrollador> desarrolladores) {
        this.nombre = nombre;
        this.desarrolladores = desarrolladores;
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

    public List<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(List<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    @Override
    public String toString() {
        return "Herramienta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                //", desarrolladores=" + desarrolladores +
                '}';
    }
}
