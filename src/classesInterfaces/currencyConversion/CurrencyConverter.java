package classesInterfaces.currencyConversion;

public class CurrencyConverter implements CurrencyConversion {
    @Override
    public double convertDollarToReal(double valueDollar) {
        return valueDollar * 5.13;
    }
}
