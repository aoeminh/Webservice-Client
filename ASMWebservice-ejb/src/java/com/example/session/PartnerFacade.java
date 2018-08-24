/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.session;

import com.example.model.Client;
import com.example.model.Partner;
import com.example.model.Partnerhistory;
import com.example.model.Userhistory;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author apple
 */
@Stateless
public class PartnerFacade extends AbstractFacade<Partner> implements PartnerFacadeLocal {

    @PersistenceContext(unitName = "ASMWebservice-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartnerFacade() {
        super(Partner.class);
    }

    @Override
    public Partner checkAccountPartner(String id, String password) {
        Query query = em.createNamedQuery("Partner.checkPartner");
        query.setParameter("partnerid", id);
        query.setParameter("partnerpassword", password);
        Partner p = new Partner();
        try {
            p = (Partner) query.getSingleResult();

            return p;
        } catch (Exception ex) {

        }
        return p;

    }

    @Override
    public String test() {
        return "test";
    }

    @Override
    public Client checkClient(String user, String password) {
        Query query = em.createNamedQuery("Client.checkClient", Client.class);
        query.setParameter("clienid", user);
        query.setParameter("password", password);
        Client client = new Client();
        try {
            client = (Client) query.getSingleResult();
            return client;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return client;
    }

    @Override
    public boolean updateClientMoney(String clientID, int money) {
        Query query = em.createNamedQuery("Client.updateMoney", Client.class);
        query.setParameter("clienid", clientID);
        query.setParameter("money", money);
        try {
            query.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updatePartnerMoney(String partnerID, int money) {
        Query query = em.createNamedQuery("Partner.updateMoney", Partner.class);
        query.setParameter("partneraccount", partnerID);
        query.setParameter("money", money);
        try {
            query.executeUpdate();
            return true;
        } catch (Exception ex) {

        }
        return false;

    }

    @Override
    public boolean partnerHistory(String transname, int money, int fee, String partnerid) {
        Date date = new Date();
        Query  query = em.createNamedQuery("Partner.findByPartnerid",Partner.class);
        query.setParameter("partnerid", partnerid);
        
        Partner partner = (Partner)query.getSingleResult();
        
          Partnerhistory partnerhistory = new Partnerhistory(transname,money,fee,date,partner);
          em.persist(partnerhistory);
            return true;
    }

    @Override
    public boolean clientHistory(String transname, int money, int fee, String clientid) {
    Date date = new Date();
    
        Query  query = em.createNamedQuery("Client.findByClienid",Client.class);
        query.setParameter("clienid", clientid);
        
        Client client = (Client) query.getSingleResult();
        
          Userhistory userhistory = new Userhistory(transname,money,fee,date,client);
          em.persist(userhistory);
            return true;
    }

    @Override
    public List<Partnerhistory> getPartnerHis(String partnerId, String startDate, String endDate) {
        Query query1 = em.createNamedQuery("Partner.findByPartnerid");
        query1.setParameter("partnerid", partnerId);
        Partner partner = (Partner) query1.getSingleResult();
              
        
        Query query = em.createNamedQuery("Partnerhistory.findByParterId");
        query.setParameter("tpartnerid", partner);
        
        List<Partnerhistory> list = query.getResultList();
        return list;

    }


  

}
