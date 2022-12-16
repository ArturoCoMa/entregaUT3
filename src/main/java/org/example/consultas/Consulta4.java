/*
Consulta para saber cuantos Desarrolladores hay que cobran igual
*/

package org.example.consultas;

import org.example.HibernateUtil;
import org.example.entidades.Desarrollador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consulta4 {
    public static void main(String[] args) {
        String query = "SELECT count (D.id),D.sueldo FROM Desarrollador D group by D.sueldo";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Object []> q  = ss.createQuery(query);
        List<Object[]> list = q.list();

        System.out.println("\nCantidad de desarrolladores y su sueldo: ");
        for(Object[] o : list){
            System.out.println("Hay "+o[0]+" desarrolladores que cobran "+o[1]);
        }
    }
}
