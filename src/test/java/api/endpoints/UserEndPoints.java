package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.postUrl);
		return response;
	}

	public static Response readUser(String userName) {
		Response response = given().pathParam("username", userName).when().get(Routes.getUrl);
		return response;
	}

	public static Response updateUser(User payload, String userName) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.pathParam("username", userName).when().put(Routes.updateUrl);
		return response;
	}

	public static Response deleteUser(String userName) {
		Response response = given().pathParam("username", userName).when().delete(Routes.deleteUrl);
		return response;

	}
}