/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ambiciousteam.levita.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author Wilde Arruda <wildearruda@gmail.com>
 */
public class PhaseListenerLevita implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        if (phaseEvent.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            
            Session session = FacesContextUtil.getRequestSession();
            try {
                
                session.getTransaction().commit();
                
            } catch (Exception e) {
                
                if (session.getTransaction().isActive()) {
                    
                    session.getTransaction().rollback();
                    
                }
            } finally {
            
                session.close();
                
            }
            
        }
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        if (phaseEvent.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
            
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
