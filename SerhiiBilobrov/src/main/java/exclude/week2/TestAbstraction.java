package exclude.week2;

public class TestAbstraction {


    public static void main(String[] args) {


        User workable = new Developer();


    }

    public static String showUserInfo(User user){
        return String.format("age %d, name %s, salary %.2f",
                user.age, user.name, user.salary);
    }

    public static void forceUserToWork(Workable user){
        // log
        user.work();
        // take result
        // pass the result to other place
    }

    // todo before implement equals
    public static boolean areEqual(Object u1, Object u2){
        return u1.equals(u2);
    }

}

interface Workable {
    void work();
}


abstract class User implements Workable {
    public int age;
    public double salary;
    public String name;

    public abstract void work();
}


class Developer extends User{

    @Override
    public void work() {
        System.out.println("Dev is working");
    }
}