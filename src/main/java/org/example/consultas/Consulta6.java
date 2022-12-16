package org.example.consultas;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consulta6 {
    public static void main(String[] args) {
        String hql = "SELECT COUNT(D.id), H.nombre FROM Desarrollador D INNER JOIN D.herramientas H GROUP BY H.nombre";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Object[]> query = ss.createQuery(hql);
        List<Object[]> lista = query.list();
        System.out.println("\nCuántos desarrolladores usan cada herramienta: ");
        for(Object[] o : lista){
            System.out.println("La herramienta "+o[1]+" es usada por "+o[0]+" desarrolladores.");
        }
    }
}
