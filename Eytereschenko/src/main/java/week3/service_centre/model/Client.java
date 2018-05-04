package week3.service_centre.model;

public class Client {

    private int id;
    private String name;
    private String email;
    private String phone;

    private static int lastClientId;

    public Client(String name, String email, String phone) {
        this.id = lastClientId++;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public static void setLastClientId(int lastClientId) {
        Client.lastClientId = lastClientId;
    }

    public int getId() {
        return id;
    }

    public static int getLastClientId() {
        return lastClientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
