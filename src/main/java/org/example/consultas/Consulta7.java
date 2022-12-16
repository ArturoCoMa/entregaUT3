package org.example.consultas;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Scanner;

public class Consulta7 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String hql = "SELECT COUNT (D.id) FROM Desarrollador D WHERE D.edad = :edad";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        System.out.println("\nIntroduce una edad para saber cuantos alumnos hay con ella.\nEdad:");
        int edad = tec.nextInt();

        Query<Long> query = ss.createQuery(hql, Long.class);
        query.setParameter("edad", edad);
        long result = query.uniqueResult();
        if(result != 0){
            System.out.println("\nHay "+result+" alumnos de "+edad+" años.");
        }else{
            System.out.println("No hay ningún alumno de esa edad.");
        }
    }
}
