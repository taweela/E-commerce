package com.example.demo.CustomExceptions.Exception;

public class StorePolicyViolatedException extends Exception{

    /**
     * @param policyId - policyId violated
     */
    public  StorePolicyViolatedException (String policyId){
        super(policyId);
    }
}
