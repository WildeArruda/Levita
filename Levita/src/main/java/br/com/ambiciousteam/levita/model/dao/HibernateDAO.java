/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ambiciousteam.levita.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Wilde Arruda <wildearruda@gmail.com>
 */
public class HibernateDAO<T> implements DAOInterface<T>, Serializable {
    
    private static final long serialVersionUID = 1l;
    
    private Class<T> myClass;
    private Session session;

    public HibernateDAO(Class<T> myClass, Session session) {
        super();
        this.myClass = myClass;
        this.session = session;
    }
    
    

    @Override
    public void save(T entity) {

        session.save(entity);
        
    }

    @Override
    public void update(T entity) {

        session.update(entity);
        
    }

    @Override
    public void remove(T entity) {
        
        session.delete(entity);
    
    }

    @Override
    public void merge(T entity) {

        session.merge(entity);
    
    }

    @Override
    public T getEntity(Serializable id) {
        
        T entity = (T)session.get(myClass, id);
        return entity;
        
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria detachedCriteria) {
        
        T entity = (T)detachedCriteria.getExecutableCriteria(session).uniqueResult();
        return entity;
        
    }

    @Override
    public List<T> getEntities() {
        
        List<T> entities = (List<T>)session.createCriteria(myClass).list();
        return entities;
        
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria detachedCriteria) {
        
        return detachedCriteria.getExecutableCriteria(session).list();
        
    }

}
