package com.eva.agilecrm.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtil {
	private String userName = "bindsunil9336@agilecrm.com";
	private String password = "sunil@2004";
	private String baseUrl = "https://sunil23.agilecrm.com/";
	private String contentType = "application/json";
	private String accept = "application/json";

	public Response getRequest(String endPoint) {
		Response res = RestAssured.given().accept(accept).auth().basic(userName, password).get(baseUrl + endPoint);
		return res;
	}

	public Response postRequest(String endPoint, String json) {
		Response res = RestAssured.given().contentType(contentType).accept(accept).auth().basic(userName, password)
				.body(json).post(baseUrl + endPoint);
		return res;
	}

	public Response putRequest(String endPoint, String json) {
		Response res = RestAssured.given().contentType(contentType).accept(accept).auth().basic(userName, password)
				.body(json).put(baseUrl + endPoint);
		return res;
	}

	public Response patchRequest(String endPoint, String json) {
		Response res = RestAssured.given().contentType(contentType).accept(accept).auth().basic(userName, password)
				.body(json).patch(baseUrl + endPoint);
		return res;
	}

	public Response deleteRequest(String endPoint) {
		Response res = RestAssured.given().accept(accept).auth().basic(userName, password).delete(baseUrl + endPoint);
		return res;
	}
}
