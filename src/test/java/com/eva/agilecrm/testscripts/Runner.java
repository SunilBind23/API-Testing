package com.eva.agilecrm.testscripts;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Runner {

	public static void main(String[] args) throws JsonProcessingException {
		VerifyContactScenarios vcs=new VerifyContactScenarios();
        vcs.verifyCreateContact();
        //vcs.verifyGetContacts();
        System.out.println("run successfull");
     
	}

}
