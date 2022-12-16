/*
Consulta que nos devuelve todos los desarrolladores.
*/

package org.example.consultas;

import org.example.HibernateUtil;
import org.example.entidades.Desarrollador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consulta1 {
    public static void main(String[] args) {
        String query = "FROM Desarrollador";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Desarrollador> q = ss.createQuery(query, Desarrollador.class);
        List<Desarrollador> listaDesa = q.list();

        System.out.println("\nEsto es la lista de todos los desarrolladores: ");

        for(Desarrollador d : listaDesa){
            System.out.println(d);
        }

        ss.close();
    }
}
