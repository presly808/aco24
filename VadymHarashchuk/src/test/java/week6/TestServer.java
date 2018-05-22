package week6;

import io.restassured.parsing.Parser;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServer {


    @BeforeClass
    public static void setUp() {
        StartServer.main(null);
    }


    @Test
    public void test1_LoginSuccesful() {
        given().body("{\"user\" :\"presly\", \"pass\":\"12345\"}")
                .post("/login")
                .then().assertThat()
                .statusCode(200)
                .body(containsString("accessKey"));
    }


    @Test
    public void test2_GetUserSuccesful() {
        given().header("accessKey", "cHJlc2x5MTIzNDU=")
                .get("/username/?maxxis")
                .then().assertThat()
                .statusCode(200)
                .using().defaultParser(Parser.JSON)
                .body("name", equalTo("Max Makar"));
    }


    @Test
    public void test3_GetPostSuccesful() {
        given().header("accessKey", "cHJlc2x5MTIzNDU=")
                .get("/posts/?2")
                .then().assertThat()
                .statusCode(200)
                .using().defaultParser(Parser.JSON)
                .body("id", equalTo(2));
    }

    @Test
    public void test4_CreateNewPost(){
        given().header("accessKey", "cHJlc2x5MTIzNDU=")
                .body("{\"title\":\"Title\", \"body\":\"Message Body\"}")
                .get("/post/new")
                .then().assertThat()
                .statusCode(200)
                .using().defaultParser(Parser.JSON)
                .body("body", equalTo("Message Body"));
    }


    @Test()
    public void test5_LoginWithIncorrectName() {
        given().body("{\"user\" :\"YES\", \"pass\":\"12345\"}")
                .post("/login")
                .then().assertThat()
                .statusCode(400)
                .body(not(containsString("accessKey")));
    }

    @Test
    public void test6_GetUserUnsuccesful() {
        given().header("accessKey", "cHJlc2x5MTIzNDU=")
                .get("/username/?van")
                .then().assertThat()
                .statusCode(400)
                .body(containsString("There is no such registered user!"));
    }

    @Test
    public void test7_GetPostUnsuccesful() {
        given().header("accessKey", "cHJlc2x5MTIzNDU=")
                .get("/posts/?-1")
                .then().assertThat()
                .statusCode(400)
                .body(containsString("There is no post with such id"));
    }

}
