/*
Consulta para saber cuantos tipos de juego hay de cada
 */

package org.example.consultas;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consulta5 {
    public static void main(String[] args) {
        String query = "SELECT count(J.id), TYPE(J) FROM Juego J GROUP BY TYPE(J)";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Object[]> q = ss.createQuery(query);
        List<Object[]> lista = q.list();
        System.out.println("\nTipos de juegos:");
        for(Object[] o: lista){
           if(String.valueOf(o[1]).equals("class org.example.entidades.JuegoIndi"))
                System.out.println("Hay "+o[0]+" que son Juegos Indi.");
            else
                System.out.println("Hay "+o[0]+" que son Tripe A.");
        }

        ss.close();
    }
}
