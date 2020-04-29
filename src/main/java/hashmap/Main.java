package hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        XmlReader myXmlReader = new XmlReader("data.xml");

        // Get Accounts
        HashMap<String, Account> accounts = myXmlReader.getAccounts();

        //Create a scanner
        Scanner scanner= new Scanner(System.in);


        System.out.println("--== All account in the database ==--");
        for ( String accountNum: accounts.keySet()){
            System.out.println(accountNum);
        }

        System.out.println("--== Account lookup ==--");
        String myAcc=" ";
        do {
            //Prompt the user
            System.out.println("Enter the Account Number:");
            myAcc= scanner.nextLine();
            Account myaccount= accounts.get(myAcc);
            if (myaccount==null){
                System.out.println("account not found");
            }else {
                System.out.println("Account NUmber: " + myaccount.getAccountNumber());
                // Examine account type -- JPE
                if (myaccount instanceof CommercialAccount) {
                    System.out.println("Account Type: Commercial");
                } else {
                    System.out.println("Account Type: Non-Commercial");
                }
                System.out.println("Customer Last Name: " + myaccount.getCustomer().getLastName());
                System.out.println("Customer First Name: " + myaccount.getCustomer().getFirstName());

            }

        } while (!myAcc.equals("exit"));


        //Get Products
        HashMap<String, Product> products = myXmlReader.getProducts();

        System.out.println("---=== All Product ISBNs in the Database ===---");
        for (String productIsbn: products.keySet()){
            System.out.println(productIsbn);
        }
        System.out.println("--==Product Lookup==--");
        String myProduct=" ";
        do {
            //Prompt the user
            System.out.println("Enter the product ISBN Number:");
            myProduct= scanner.nextLine();
            Product product= products.get(myProduct);
            if (product==null){
                System.out.println("product not found");
            }else {
                System.out.println("ISBN: " + product.getIsbn());
                if (product instanceof TaxableProduct) {
                    System.out.println("Product Type: Taxable");
                } else {
                    System.out.println("Product Type: Non-Taxable");
                }
                System.out.println("Product Type: " + product.getProductName());
                System.out.println("Price: "+ product.getUnitPrice());
            }

        } while (!myProduct.equals("exit"));

    }
}
