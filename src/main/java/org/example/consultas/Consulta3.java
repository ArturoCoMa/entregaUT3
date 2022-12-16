/*
Juegos con un genero que empieza por A
*/


package org.example.consultas;

import org.example.HibernateUtil;
import org.example.entidades.Juego;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consulta3 {
    public static void main(String[] args) {
        String query = "FROM Juego A WHERE A.Genero like 'A%'";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Juego> q = ss.createQuery(query, Juego.class);
        List<Juego> lista = q.list();

        System.out.println("\nEstos son los juegos cuyo género empieza por A: ");
        for(Juego j : lista){
            System.out.println(j.nombre+" "+j.Genero);
        }

        ss.close();
    }
}
