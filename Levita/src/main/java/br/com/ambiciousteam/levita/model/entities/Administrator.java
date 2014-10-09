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
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Wilde Arruda <wildearruda@gmail.com>
 */

@Entity
@Table(name = "administrator")
public class Administrator implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idAdministrator", nullable = false)
    private Long ID;
    
    @Column(name = "E-mail", nullable = false, length = 100, updatable = true)
    private String adminEmail;
    
    @Column(name = "Senha", nullable = false, length = 20)
    private String adminPassword;
    
    @Column(name = "Usuário", nullable = false, length = 20)
    private String adminUserName;
    
    @Column(name = "Cargo", nullable = false, length = 15)
    private String adminTitle;
    
    @Column(name = "Data da Nomeação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date adminTitleDate;
    
    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY)
    @ForeignKey(name = "FKPersonAdministrator")
    private List<Person> persons;
    
    
    //###############################################

    public Administrator() {}
    
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminTitle() {
        return adminTitle;
    }

    public void setAdminTitle(String adminTitle) {
        this.adminTitle = adminTitle;
    }

    public Date getAdminTitleDate() {
        return adminTitleDate;
    }

    public void setAdminTitleDate(Date adminTitleDate) {
        this.adminTitleDate = adminTitleDate;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    
    

    //###############################################

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.ID);
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
}
