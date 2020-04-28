package hashmap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

public class XmlHandler extends DefaultHandler {

    private HashMap<String, Account> accounts = new HashMap();
    private HashMap<String,Product> products = new HashMap();
    private Account currentAccount;
    private Customer currentCustomr;
    private Product currentProduct;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Start element:" + qName);

            // Handle the account element
            // Handle the customer element
            // Hamdle the product element
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element:" + qName);
            // Handle account element
            // Handle customer element
            // Handle product element
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


