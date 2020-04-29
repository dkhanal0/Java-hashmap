package hashmap;

// Use code from "associations" assignment

public abstract class Product {

    private String productName;
    private String ISBNNum;
    public double price;

    // A constructor method that initializes the product name, ISBN number, and unit price
    public Product(String productName, String ISBNNum, double price){
        this.productName= productName;
        this.ISBNNum= ISBNNum;
        this.price=price;
    }
    // getProductName() - Returns a String that is the name of the product
    public String getProductName(){
        return productName;
    }

    // getIsbn() - Returns a String representing the ISBN (barcode) number
    public String getIsbn (){
        return ISBNNum;
    }

    // getUnitPrice() - Returns a possible decimal value indicating the unit price for each product
    public double getUnitPrice(){
        return price;
    }

    // Implement values() method
    public abstract String values();
}

