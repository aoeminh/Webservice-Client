/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.account.AccountFacadeLocal;
import com.example.model.Client;
import com.example.model.Partner;
import com.example.model.Partnerhistory;
import com.example.model.Userhistory;
import com.example.session.PartnerFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author apple
 */
@WebService(serviceName = "CheckPartnerService")
public class CheckPartnerService {
    @EJB
    private PartnerFacadeLocal partnerFacadeLocal;

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "checkPartner")
    public Partner checkPartner(@WebParam(name = "id")String id,
            @WebParam(name = "password") String password){
        return partnerFacadeLocal.checkAccountPartner(id, password);
       
    }
    
    @WebMethod(operationName = "checkClient")
    public Client checkClient(@WebParam(name = "id") String id,@WebParam(name ="password") String password){
        
        return partnerFacadeLocal.checkClient(id, password);
    }
     
    @WebMethod(operationName = "test")
    public String test(){
        return partnerFacadeLocal.test();
       
    }
    
    @WebMethod(operationName = "updateCLientMoney")
    public boolean updateCLientMoney(@WebParam(name = "clienid") String id,
            @WebParam(name ="money") int money){
        return partnerFacadeLocal.updateClientMoney(id, money);
    }
     @WebMethod(operationName = "updatePartnerMoney")
    public boolean updatePartnerMoney(@WebParam(name = "partnerid") String id,
            @WebParam(name ="money") int money){
        return partnerFacadeLocal.updatePartnerMoney(id, money);
    }
    
      @WebMethod(operationName = "partnerHis")
    public boolean partnerHis(@WebParam(name = "transname") String transname,
            @WebParam(name = "money") int  money,
            @WebParam(name = "fee") int fee,
            @WebParam(name = "partnerid") String partner){
        return partnerFacadeLocal.partnerHistory(transname,money,fee,partner);
    }
    
      @WebMethod(operationName = "userHis")
    public boolean userHis(@WebParam(name = "transname") String transname,
            @WebParam(name = "money") int  money,
            @WebParam(name = "fee") int fee,
            @WebParam(name = "clientid") String clientid){
        return partnerFacadeLocal.clientHistory(transname,money,fee,clientid);
    }
    
     @WebMethod(operationName = "getPartnerHis")
     public List<Partnerhistory> getPartnerHis(@WebParam(name="partnerid") String partnerId,
             @WebParam(name = "startDate") String startDate,
             @WebParam(name="endDate") String endDate)
     {
         return partnerFacadeLocal.getPartnerHis(partnerId, startDate, endDate);
         
     }
}

