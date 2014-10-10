/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ambiciousteam.levita.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Wilde Arruda <wildearruda@gmail.com>
 */


@Entity
@Table(name = "cashFlow")
public class CashFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idCashFlow")
    private Long ID;
    
    @Column(name = "Data do Movimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cfDateOfMovement;
    
    @Column(name = "Hora do Movimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date cfHourOfMovement;
    
    @Column(name = "Entrada", nullable = false)
    private Double cfEntry;
    
    @Column(name = "Saída", nullable = false)
    private Double cfOutput;
    
    @Column(name = "Saldo", nullable = false)
    private Double cfBalance;
    
    @Column(name = "Razão", nullable = false, length = 30)
    private String cfReasonOfMovement;
    
    @OneToMany(mappedBy = "cashFlow", fetch = FetchType.LAZY)
    @ForeignKey(name = "FKAdministratorCashFlow")
    private List<Administrator> administrators;
    
    //###################################################
    
    public CashFlow() {}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getCfDateOfMovement() {
        return cfDateOfMovement;
    }

    public void setCfDateOfMovement(Date cfDateOfMovement) {
        this.cfDateOfMovement = cfDateOfMovement;
    }

    public Date getCfHourOfMovement() {
        return cfHourOfMovement;
    }

    public void setCfHourOfMovement(Date cfHourOfMovement) {
        this.cfHourOfMovement = cfHourOfMovement;
    }

    public Double getCfEntry() {
        return cfEntry;
    }

    public void setCfEntry(Double cfEntry) {
        this.cfEntry = cfEntry;
    }

    public Double getCfOutput() {
        return cfOutput;
    }

    public void setCfOutput(Double cfOutput) {
        this.cfOutput = cfOutput;
    }

    public Double getCfBalance() {
        return cfBalance;
    }

    public void setCfBalance(Double cfBalance) {
        this.cfBalance = cfBalance;
    }

    public String getCfReasonOfMovement() {
        return cfReasonOfMovement;
    }

    public void setCfReasonOfMovement(String cfReasonOfMovement) {
        this.cfReasonOfMovement = cfReasonOfMovement;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }
    
    
    
    //######################################################

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CashFlow other = (CashFlow) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
    
}
