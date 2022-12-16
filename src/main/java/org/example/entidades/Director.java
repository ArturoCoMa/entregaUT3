package org.example.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "directores")
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_director", referencedColumnName = "id")
    private Juego juego;

    @OneToMany(mappedBy = "director")
    private List<Desarrollador> desarrolladores;

    public Director() {
    }

    public Director(String nombre, Juego juego, List<Desarrollador> desarrolladores) {
        this.nombre = nombre;
        this.juego = juego;
        this.desarrolladores = desarrolladores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public List<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(List<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", juego=" + juego +
                ", desarrolladores=" + desarrolladores +
                '}';
    }
}
