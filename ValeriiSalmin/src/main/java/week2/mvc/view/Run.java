package week2.mvc.view;

public class Run {

    public static void main(String[] args) throws Exception {
        ContactView contactView = new ContactView();
        contactView.initData();
        contactView.runController();
    }
}
