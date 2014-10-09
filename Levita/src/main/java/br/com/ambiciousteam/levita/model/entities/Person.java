/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ambiciousteam.levita.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Wilde Arruda <wildearruda@gmail.com>
 */

@Entity
@Table(name = "person")
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdPessoa", nullable = false)
    private Long ID;
    
    @Column(name = "Nome", nullable = false, length = 100)
    private String personName;
    
    @Column(name = "CPF", nullable = false, length = 14)
    private String personCPF;
    
    @Column(name = "RG", nullable = false, length = 15)
    private String personRG;
    
    @Column(name = "Sexo", unique = true, nullable = false, length = 1)
    private char personSex;
    
    @Column(name = "Data Nascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date personBirthDate;
    
    @Column(name = "Data Membrasia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date personMembershipDate;
    
    @Column(name = "Data Batismo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date personBaptismDate;
    
    @Column(name = "Batismo Espiritual")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date personBaptismHolySpiritDate;
    
    @Column(name = "Cidade", nullable = false, length = 40)
    private String personCity;
    
    @Column(name = "Rua", length = 100)
    private String personStreet;
    
    @Column(name = "UF", nullable = false, length = 2)
    private String personUF;
    
    @Column(name = "C.E.P.", length = 9)
    private String personCEP;
    
    @Column(name = "Cidade de Nascimento", nullable = false, length = 40)
    private String personBirthCity;
    
    @Column(name = "UF Nascimento", nullable = false, length = 2)
    private String personBirthUF;
    
    
    @ManyToOne(optional = true)
    @ForeignKey(name = "FKPersonAdministrator")
    private Person person;
    
    
    //################################################################# 
    
    public Person() {}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonCPF() {
        return personCPF;
    }

    public void setPersonCPF(String personCPF) {
        this.personCPF = personCPF;
    }

    public String getPersonRG() {
        return personRG;
    }

    public void setPersonRG(String personRG) {
        this.personRG = personRG;
    }

    public char getPersonSex() {
        return personSex;
    }

    public void setPersonSex(char personSex) {
        this.personSex = personSex;
    }

    public Date getPersonBirthDate() {
        return personBirthDate;
    }

    public void setPersonBirthDate(Date personBirthDate) {
        this.personBirthDate = personBirthDate;
    }

    public Date getPersonMembershipDate() {
        return personMembershipDate;
    }

    public void setPersonMembershipDate(Date personMembershipDate) {
        this.personMembershipDate = personMembershipDate;
    }

    public Date getPersonBaptismDate() {
        return personBaptismDate;
    }

    public void setPersonBaptismDate(Date personBaptismDate) {
        this.personBaptismDate = personBaptismDate;
    }

    public Date getPersonBaptismHolySpiritDate() {
        return personBaptismHolySpiritDate;
    }

    public void setPersonBaptismHolySpiritDate(Date personBaptismHolySpiritDate) {
        this.personBaptismHolySpiritDate = personBaptismHolySpiritDate;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String personCity) {
        this.personCity = personCity;
    }

    public String getPersonStreet() {
        return personStreet;
    }

    public void setPersonStreet(String personStreet) {
        this.personStreet = personStreet;
    }

    public String getPersonUF() {
        return personUF;
    }

    public void setPersonUF(String personUF) {
        this.personUF = personUF;
    }

    public String getPersonCEP() {
        return personCEP;
    }

    public void setPersonCEP(String personCEP) {
        this.personCEP = personCEP;
    }

    public String getPersonBirthCity() {
        return personBirthCity;
    }

    public void setPersonBirthCity(String personBirthCity) {
        this.personBirthCity = personBirthCity;
    }

    public String getPersonBirthUF() {
        return personBirthUF;
    }

    public void setPersonBirthUF(String personBirthUF) {
        this.personBirthUF = personBirthUF;
    }

    //##################################################################
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.ID);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
    
    
}
