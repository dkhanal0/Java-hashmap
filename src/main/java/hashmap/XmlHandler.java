package hashmap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

public class XmlHandler extends DefaultHandler {

    private HashMap<String, Account> accounts = new HashMap();
    private HashMap<String,Product> products = new HashMap();
    private Account currentAccount;
    private Customer currentCustomer;
    private Product currentProduct;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
       // System.out.println("Start element:" + qName);


        // Handle the account element
        if (qName.equals("account")) {
            //Get account attributes
            String type = attributes.getValue("commercial");
            String taxId = attributes.getValue("taxId");
            String accountNumber = attributes.getValue("accountNumber");

            //Instantiate the current account based on commercial attribute
            if (attributes.getValue("commercial") != null && type.contentEquals("true")) {
                currentAccount = new CommercialAccount(accountNumber, currentCustomer, taxId);
            } else {
                currentAccount = new NonCommercialAccount(accountNumber, currentCustomer);
            }
        }

            // Handle the customer element
        if (qName.equals("customer")){
            // Get customer  attributes
            String lastName = attributes.getValue("lastName");
            String firstName = attributes.getValue("firstName");
            String streetAddress = attributes.getValue("streetAddress");
            String zipCode = attributes.getValue("zipCode");

            currentCustomer= new Customer(lastName, firstName, streetAddress, zipCode);

        }

            // Handle the product element
            if (qName.equals("product")) {
                // Get product attributes
                String name = attributes.getValue("name");
                String isbn = attributes.getValue("isbn");
                String price = attributes.getValue("unitPrice");
                String type = attributes.getValue("taxable");

                // Instantiate the current Product based on taxable attribute
                if (attributes.getValue("taxable") != null && type.contentEquals("true")) {
                    currentProduct = new TaxableProduct(name, isbn, Double.parseDouble(price));

                } else {
                    currentProduct = new NonTaxableProduct(name, isbn, Double.parseDouble(price));
                }
            }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       // System.out.println("End element:" + qName);
            // Handle account element
        if (qName.equals("account")){
            accounts.put(currentAccount.getAccountNumber(), currentAccount);

        }
         // Handle customer element
        if (qName.equals("customer")){
            currentCustomer.setAccount(currentAccount);
        }
            // Handle product element
        if (qName.equals("product")){
          products.put(currentProduct.getIsbn(), currentProduct);
        }

    }

    // Return a reference to the account hashmap
    public HashMap<String,Account> getAccounts() {
        return accounts;
    }

    // Return a reference to the product hashmap
    public HashMap<String, Product> getProducts() {
        return products;
    }

}


