/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author apple
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByClienid", query = "SELECT c FROM Client c WHERE c.clienid = :clienid")
    , @NamedQuery(name = "Client.findByCpassword", query = "SELECT c FROM Client c WHERE c.cpassword = :cpassword")
    , @NamedQuery(name = "Client.findByCmoney", query = "SELECT c.cmoney FROM Client c WHERE c.cmoney = :cmoney")
    
    , @NamedQuery(name = "Client.checkClient", query = "SELECT c FROM Client c WHERE c.clienid = :clienid and c.cpassword = :password")
    ,@NamedQuery(name = "Client.updateMoney", query = "UPDATE Client  SET cmoney = :money where clienid = :clienid")})
public class Client implements Serializable {

    @OneToMany(mappedBy = "uclientid")
    private Collection<Userhistory> userhistoryCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CLIENID")
    private String clienid;
    @Size(max = 100)
    @Column(name = "CPASSWORD")
    private String cpassword;
    @Column(name = "CMONEY")
    private Integer cmoney;

    public Client() {
    }

    public Client(String clienid) {
        this.clienid = clienid;
    }

    public String getClienid() {
        return clienid;
    }

    public void setClienid(String clienid) {
        this.clienid = clienid;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public Integer getCmoney() {
        return cmoney;
    }

    public void setCmoney(Integer cmoney) {
        this.cmoney = cmoney;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienid != null ? clienid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clienid == null && other.clienid != null) || (this.clienid != null && !this.clienid.equals(other.clienid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.Client[ clienid=" + clienid + " ]";
    }

    @XmlTransient
    public Collection<Userhistory> getUserhistoryCollection() {
        return userhistoryCollection;
    }

    public void setUserhistoryCollection(Collection<Userhistory> userhistoryCollection) {
        this.userhistoryCollection = userhistoryCollection;
    }
    
}
