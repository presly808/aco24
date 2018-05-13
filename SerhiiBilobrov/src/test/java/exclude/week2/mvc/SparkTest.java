package exclude.week2.mvc;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import exclude.week2.mvc.model.Contact;
import exclude.week2.mvc.model.User;
import exclude.week2.mvc.server.MyServer;
import exclude.week2.mvc.utils.ObjectHolder;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

/**
 * Created by serhii on 13.05.18.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SparkTest {

    private static Gson gson = ObjectHolder.getBean("gson");
    private static String host = "localhost";
    private static String port = "8090";
    private static String accessToken;

    @BeforeClass
    public static void beforeClass(){
        MyServer.main(new String[]{port});
    }

    @Test
    public void _01register() throws UnirestException {

        User user = new User();
        user.setName("presly");
        user.setPass("12345");

        HttpResponse<String> response = Unirest.post(String.format("http://%s:%s/register", host, port))
                .body(gson.toJson(user)).asString();

        User actual = gson.fromJson(response.getBody(),User.class);

        Assert.assertNotNull(actual.getId());
        System.out.println("REGISTER PASSED");
    }

    @Test
    public void _02login() throws UnirestException, JSONException {

        User user = new User();
        user.setName("presly");
        user.setPass("12345");

        HttpResponse<JsonNode> response = Unirest.post(String.format("http://%s:%s/login", host, port))
                .body(gson.toJson(user)).asJson();

        String actual = response.getBody().getObject().get("accessToken").toString();

        Assert.assertNotNull(actual);

        accessToken = actual;
    }

    @Test
    public void _03allContacts() throws UnirestException, JSONException {



        HttpResponse<String> response = Unirest
                .get(String.format("http://%s:%s/contact/all", host, port))
                .header("accessToken", accessToken)
                .asString();

        Contact[] actual = gson.fromJson(response.getBody(), Contact[].class);
        Assert.assertEquals(200, response.getCode());
        Arrays.stream(actual).forEach(System.out::println);
    }



}
