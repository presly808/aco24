package patterns.proxy;

/**
 * Created by serhii on 31.03.18.
 */
public class Calculator implements ICalculator {


    @Override
    public double sum(double a, double b){
        return a + b;
    }

    @Override
    public double minus(double a, double b){
        return a - b;
    }

    @Override
    public double div(double a, double b){
        return a / b;
    }

    @Override
    public double mult(double a, double b){
        return a * b;
    }


}
