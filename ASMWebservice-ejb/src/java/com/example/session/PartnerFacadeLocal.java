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
import javax.ejb.Local;

/**
 *
 * @author apple
 */
@Local
public interface PartnerFacadeLocal {

    void create(Partner partner);

    void edit(Partner partner);

    void remove(Partner partner);

    Partner find(Object id);

    List<Partner> findAll();

    List<Partner> findRange(int[] range);

    int count();
    
    Partner  checkAccountPartner(String id, String password);
    
    String test();
    
    Client checkClient(String user, String password);
    
    boolean updateClientMoney(String clientID, int money);
    
    boolean updatePartnerMoney(String partnerID, int money);
    boolean partnerHistory(String transname,int money, int fee,String partnerid);
    boolean clientHistory(String transname,int money, int fee,String client);
    List<Partnerhistory> getPartnerHis(String partnerId, String startDate, String endDate );
}
