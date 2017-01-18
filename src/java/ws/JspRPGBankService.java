/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Beans.Transaction;
import Classes.DataStorage;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author User
 */
@WebService(serviceName = "JspRPGBankService")
public class JspRPGBankService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "makePayments")
    public String makePayments(@WebParam(name = "creditcard") String creditcard, @WebParam(name = "amount") String amount) {
        DataStorage.getInstance().createAccounts();
        Transaction transaction = new Transaction();
        int valid = transaction.CheckFunds(creditcard, Float.parseFloat(amount));
        if(valid == 0){
            return "Not enough funds cash on the creditcard";
        }else if(valid == 1){
            
            transaction.MakePayment(creditcard, Float.parseFloat(amount));
            return "The transaction was successful, " + amount + "was drawn";
        }
        return null;
    }

    /**
     * This is a sample web service operation
     */
    
    
    
}
