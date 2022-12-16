/*
Consulta juegos que salen después del 2010
*/


package org.example.consultas;

import org.example.HibernateUtil;
import org.example.entidades.Juego;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.List;

public class Consulta2 {
    public static void main(String[] args) {
        String query = "FROM Juego WHERE anyo > 2010";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Juego> q = ss.createQuery(query);
        List<Juego> lista = q.list();


        System.out.println("\nJuegos que salen después del 2010:");
        for(Juego j : lista){
            System.out.println(j.nombre);
        }
    }
}
