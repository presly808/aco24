package week6.spark;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class TestSparkServer {

    private static Map<String,Product> productMap = new HashMap<>();
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        productMap.put("1", new Product("1","ananas",50));
        productMap.put("2", new Product("2","apple",10));

        port(8080);

        get("/hello",(request,response)-> "Hello");

        get("/hello",(request,response)-> {
            return "Hello";
        });

        post("/product/add",(request,response)-> {
            String jsonStr = request.body();
            Product product = gson.fromJson(jsonStr,Product.class);
            productMap.put(product.id,product);
            return new Message("okey");
        });

        get("/product/all",(request, response) -> {
            return gson.toJson(productMap.values());
        });
    }

    private static class Message {
        String text;


        public Message(String text) {
            this.text = text;
        }

    }

    private static class Product {
        String id;
        String name;
        int price;

        public Product(){
        }

        public Product(String id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
