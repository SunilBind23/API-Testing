package com.eva.agilecrm.testscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

import com.eva.agilecrm.utils.ApiUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import RequestPojo.RootRequest;
import ResponsePOJO.ContactsResponseRoot;
import commonValues.CommonProperty;
import io.restassured.response.Response;

public class VerifyContactScenarios {

	public void verifyCreateContact() throws JsonProcessingException {

		RootRequest crRequest = new RootRequest();
		
		String randomString = UUID.randomUUID().toString();
		String email =randomString.concat("@gmail.com");
		
		
		crRequest.setLead_score("85");
		crRequest.setStar_value("4");
		crRequest.setLead_score("90");

		List<String> tagList = new ArrayList<String>();
		tagList.add("MyLead");
		tagList.add("YourLead");

		crRequest.setTags(tagList);

		List<CommonProperty> propList = new ArrayList<CommonProperty>();
		CommonProperty cProp1 = new CommonProperty();
		cProp1.setName("first_name");
		cProp1.setType("SYSTEM");
		cProp1.setValue(randomString);

		CommonProperty cProp2 = new CommonProperty();
		cProp2.setName("last_name");
		cProp2.setType("SYSTEM");
		cProp2.setValue("Kumar");
		

		CommonProperty cProp3 = new CommonProperty();
		
		cProp3.setType("SYSTEM");
		cProp3.setName("email");
		cProp3.setSubtype("work");
		cProp3.setValue(email);
		
		CommonProperty cProp4 = new CommonProperty();
		cProp4.setType("SYSTEM");
		cProp4.setName("address");
		cProp4.setValue("{\"address\":\"225 George Street\",\"city\":\"NSW\",\"state\":\"Sydney\",\"zip\":\"2000\",\"country\":\"Australia\"}");
		
		CommonProperty cProp5 = new CommonProperty();
		cProp5.setName("phone");
		cProp5.setValue("777777777");
		cProp5.setSubtype("work");
		
		CommonProperty cProp6 = new CommonProperty();
		cProp6.setName("website");
		cProp6.setValue("www.youtube.com");
		cProp6.setSubtype("YOUTUBE");
		
		CommonProperty cProp7 = new CommonProperty();
		cProp7.setName("website");
		cProp7.setValue("www.linkedin.com");
		cProp7.setSubtype("Linkedin");
		
		CommonProperty cProp8 = new CommonProperty();
		cProp8.setName("website");
		cProp8.setValue("www.linkedin.com");
		cProp8.setSubtype("Linkedin");
		
		CommonProperty cProp9 = new CommonProperty();
		cProp9.setName("website");
		cProp9.setValue("www.mywebsite.com");
		cProp9.setSubtype("URL");
		
		CommonProperty cProp10 = new CommonProperty();
		cProp10.setName("website");
		cProp10.setType("CUSTOM");
		cProp10.setValue("My name is SunilKumar");
		
		CommonProperty cProp11 = new CommonProperty();
		cProp11.setName("My custom field of type date");
		cProp11.setType("CUSTOM");
		cProp11.setValue(1479580200);
		
		CommonProperty cProp12 = new CommonProperty();
		cProp12.setName("My custom field of type checkbox");
		cProp12.setType("CUSTOM");
		cProp12.setValue("on");
		
		CommonProperty cProp13 = new CommonProperty();
		cProp13.setName("My custom field of type list");
		cProp13.setType("CUSTOM");
		cProp13.setValue("lemon");
		
		CommonProperty cProp14 = new CommonProperty();
		cProp14.setName("My custom field of type companies");
		cProp14.setType("CUSTOM");
		cProp14.setValue("[\"5767466600890368\",\"5114076984246272\",\"5746725247516672\"]");
		
		
		
		propList.add(cProp1);
		propList.add(cProp2);
		propList.add(cProp4);
		propList.add(cProp5);
		propList.add(cProp6);
		propList.add(cProp7);
		propList.add(cProp9);
		propList.add(cProp8);
		propList.add(cProp9);
		propList.add(cProp10);
		propList.add(cProp11);
		propList.add(cProp12);
		propList.add(cProp13);
		propList.add(cProp14);
		
		

		crRequest.setProperties(propList);

		ObjectMapper om = new ObjectMapper();
		String ContactjsonRequest = om.writeValueAsString(crRequest);
		
		ApiUtil au = new ApiUtil();
		Response res = au.postRequest("dev/api/contacts", ContactjsonRequest);
		String jsonresp = res.getBody().asPrettyString();
		System.out.println(res.getStatusCode());
		System.out.println(jsonresp);
		
		ContactsResponseRoot crp = om.readValue(jsonresp, ContactsResponseRoot.class);
		
		
		long id = crp.getId();
		int sv = crp.getStar_value();
		int actualStatusCode = res.getStatusCode();
		if (actualStatusCode == 200) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
		

	}

	public void verifyGetContacts() {
		ApiUtil au = new ApiUtil();
		Response res = au.getRequest("dev/api/contacts");

		int actualStatusCode = res.getStatusCode();
		if (actualStatusCode == 200) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
		String jsonResponse = res.getBody().asPrettyString();

		JSONArray jsonArr = new JSONArray(jsonResponse);
		JSONObject jsonObj1 = jsonArr.getJSONObject(0);
		Number actualContactId = jsonObj1.getNumber("id");
		if (actualContactId.toString().length() == 16) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

		String actualContactType = jsonObj1.getString("type");

		int actualStarValue = jsonObj1.getInt("star_value");
		if (actualStarValue == 4) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

		JSONObject viewedJsonObj = jsonObj1.getJSONObject("viewed");
		int viewedTimeValue = viewedJsonObj.getInt("viewed_time");
		if (viewedTimeValue == 0) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

	}

}
