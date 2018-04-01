package patterns.proxy;

/**
 * round all results with precisions 2 numbers after point
 */
public class FormatRoundProxyCalculator implements ICalculator {

    public FormatRoundProxyCalculator(ICalculator iCalculator) {
    }

    @Override
    public double sum(double a, double b) {
        return 0;
    }

    @Override
    public double minus(double a, double b) {
        return 0;
    }

    @Override
    public double div(double a, double b) {
        return 0;
    }

    @Override
    public double mult(double a, double b) {
        return 0;
    }
}
