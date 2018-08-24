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
@Table(name = "PARTNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p")
    , @NamedQuery(name = "Partner.findByPartnerid", query = "SELECT p FROM Partner p WHERE p.partnerid = :partnerid")
    , @NamedQuery(name = "Partner.findByPartnerpassword", query = "SELECT p FROM Partner p WHERE p.partnerpassword = :partnerpassword")
    , @NamedQuery(name = "Partner.findByPartneraccount", query = "SELECT p FROM Partner p WHERE p.partneraccount = :partneraccount")
    , @NamedQuery(name = "Partner.findByPartnermoney", query = "SELECT p FROM Partner p WHERE p.partnermoney = :partnermoney")
    , @NamedQuery(name = "Partner.checkPartner", query = "SELECT p FROM Partner p WHERE p.partnerid = :partnerid AND p.partnerpassword = :partnerpassword")
    , @NamedQuery(name = "Partner.updateMoney", query = "UPDATE Partner  SET partnermoney = :money where partneraccount = :partneraccount")})
public class Partner implements Serializable {

    @OneToMany(mappedBy = "tpartnerid")
    private Collection<Partnerhistory> partnerhistoryCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PARTNERID")
    private String partnerid;
    @Size(max = 100)
    @Column(name = "PARTNERPASSWORD")
    private String partnerpassword;
    @Size(max = 100)
    @Column(name = "PARTNERACCOUNT")
    private String partneraccount;
    @Column(name = "PARTNERMONEY")
    private Integer partnermoney;

    public Partner() {
    }

    public Partner(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPartnerpassword() {
        return partnerpassword;
    }

    public void setPartnerpassword(String partnerpassword) {
        this.partnerpassword = partnerpassword;
    }

    public String getPartneraccount() {
        return partneraccount;
    }

    public void setPartneraccount(String partneraccount) {
        this.partneraccount = partneraccount;
    }

    public Integer getPartnermoney() {
        return partnermoney;
    }

    public void setPartnermoney(Integer partnermoney) {
        this.partnermoney = partnermoney;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partnerid != null ? partnerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.partnerid == null && other.partnerid != null) || (this.partnerid != null && !this.partnerid.equals(other.partnerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.Partner[ partnerid=" + partnerid + " ]";
    }

    @XmlTransient
    public Collection<Partnerhistory> getPartnerhistoryCollection() {
        return partnerhistoryCollection;
    }

    public void setPartnerhistoryCollection(Collection<Partnerhistory> partnerhistoryCollection) {
        this.partnerhistoryCollection = partnerhistoryCollection;
    }
    
}
