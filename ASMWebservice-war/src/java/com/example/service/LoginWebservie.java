/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.account.AccountFacadeLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author apple
 */
@WebService(serviceName = "LoginWebservie")
public class LoginWebservie {
    
    @EJB
    private AccountFacadeLocal accountFacadeLocal;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "checkLogin")
    public boolean checkLogin(@WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {
        return  accountFacadeLocal.checkLogin(username, password);
    }
}

