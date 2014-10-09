/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ambiciousteam.levita.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Wilde Arruda
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {
            System.out.println("Tentando abrir a Session Factory (SF)!");
            Cofiguration cofiguration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(cofiguration.getProperties()).buildServiceRegistry();
            sessionFactory = cofiguration.buildSessionFactory(serviceRegistry);
            System.out.println("SF criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro"+e);
            throw new ExceptionInInitializerError(e);
        }
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
