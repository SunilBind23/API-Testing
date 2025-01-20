package getResponse;

import java.util.List;

import com.eva.agilecrm.utils.ApiUtil;

import ResponsePOJO.ContactsResponseRoot;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getContactsResponse {
	public static void main(String[] args) {
		ApiUtil api = new ApiUtil();
		Response res = api.getRequest("dev/api/contacts");
		res.getStatusCode();
		// System.out.println(res.getBody().asPrettyString());
		String jsonresp = res.getBody().asPrettyString();
		JsonPath jsonPath = new JsonPath(jsonresp);

		List<Object> ids = jsonPath.getList("id");
		// int id = jsonPath.getInt("id");
		System.out.println(ids);

//		ContactsResponseRoot cr=	new ContactsResponseRoot();

		// dev/api/contacts
	}
}
