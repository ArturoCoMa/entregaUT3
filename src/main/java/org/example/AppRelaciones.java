/*
Relación
*/


package org.example;

import org.example.entidades.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppRelaciones {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        JuegoTripeA j1 = new JuegoTripeA("Nier",2017, "Aventuras", null, 10000);
        JuegoTripeA j2 = new JuegoTripeA("Dark Souls",2010, "Souls-Like", null, 20000);
        JuegoTripeA j3 = new JuegoTripeA("Kingdom Hearts", 2001, "Action JRPG", null, 3000);

        JuegoIndi j4 = new JuegoIndi("Vampire Survivor", 2022, "BulletHell inverso", null, 1000);
        JuegoIndi j5 = new JuegoIndi("Celeste", 2021, "Plataformas", null, 2000);
        JuegoIndi j6 = new JuegoIndi("Input Adventura", 2023, "JRPG", null, 3000);

        Director d1 = new Director("Yokotaro", j1, new ArrayList<Desarrollador>());
        Director d2 = new Director("Miyazaki", j2, new ArrayList<Desarrollador>());
        Director d3 = new Director("Nomura", j3, new ArrayList<Desarrollador>());
        Director d4 = new Director("Poncle", j4, new ArrayList<Desarrollador>());
        Director d5 = new Director("Maddy Thorson", j5, new ArrayList<Desarrollador>());
        Director d6 = new Director("Artemo", j6, new ArrayList<Desarrollador>());
        j1.setDirector(d1);
        j2.setDirector(d2);
        j3.setDirector(d3);
        j4.setDirector(d4);
        j5.setDirector(d5);
        j6.setDirector(d6);



        List<Desarrollador> listD = new ArrayList<>();
        listD.add(new Desarrollador("Arturo",38, 1500, d1,null));
        listD.add(new Desarrollador("Diego", 25, 1500, d2,null));
        listD.add(new Desarrollador("Fernando", 30, 1500, d3,null));
        listD.add(new Desarrollador("Javier", 29, 1500, d1,null));
        listD.add(new Desarrollador("Ricardo", 50, 2000, d1,null));
        listD.add(new Desarrollador("Ramon", 31, 2000, d2,null));
        listD.add(new Desarrollador("Emilio", 25, 2000, d3,null));
        listD.add(new Desarrollador("Jonathan", 50, 2000, d4,null));
        listD.add(new Desarrollador("Samuel", 32, 2000, d5,null));
        listD.add(new Desarrollador("Alberto", 25, 2000, d5,null));
        listD.add(new Desarrollador("Ian", 50, 2000, d6,null));
        listD.add(new Desarrollador("Israel", 32, 2000, d4,null));
        listD.add(new Desarrollador("Nacho", 25, 2000, d6,null));

        for(Desarrollador d : listD)
            ss.persist(d);

        List<Herramienta> listH = new ArrayList<>();
        listH.add(new Herramienta("InteliJIdea", listD));
        listH.add(new Herramienta("VisualStudio", listD));
        listH.add(new Herramienta("Godot", listD));

        for(Desarrollador d : listD)
            d.setHerramientas(listH);

        for(Herramienta hd : listH)
            ss.persist(hd);

        tr.commit();
        ss.close();
    }
}
