package hashmap;

public interface TaxableNy {

    // Add constant for NY State tax rate of 8%
    final double taxNy= .08;

    // Add required getSalesTaxNy(double) method
    public double getSalesTaxNy(double taxRate);
}
