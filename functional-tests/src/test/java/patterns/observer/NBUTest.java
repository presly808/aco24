package patterns.observer;

import static org.junit.Assert.*;

/**
 * Created by serhii on 31.03.18.
 */
public class NBUTest {


    public void test1(){
        NBU nbu = new NBU();
        nbu.addObserver(new PrivatBank());
        nbu.addObserver(new Ukrsib());
        nbu.addObserver(new AlfaBank());


        nbu.notifyObservers(25.6);
    }

}