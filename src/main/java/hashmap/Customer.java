package hashmap;

public class Customer implements Comparable<Customer> {

    //  // Using the code from a previous assignment ( Comparable - BST-2)

    private String lastName;
    private String firstName;
    private String streetAddress;
    private String zipCode;
    private Account account;

    //    A constructor that initializes the last name, first name, address, and zip code.
    public Customer(String lastName, String firstName, String streetAddress, String zipCode) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
    }

    //    getLastName() - Returns a String that is the customer’s last name
    public String getLastName() {
        return lastName;
    }

    //    getFirstName() - Returns a String that is the customer’s first name
    public String getFirstName() {
        return firstName;
    }

    //    getStreetAddress() - Returns a String indicating the customer’s street address
    public String getStreetAddress() {
        return this.streetAddress;
    }

    //    getZipCode() - Returns a String indicating the customer’s zip code
    public String getZipCode() {
        return this.zipCode;
    }

    //    setAccount(Account a) - Sets the Account for this customer
    public void setAccount(Account account) {
        this.account = account;
    }

    //    getAccount() - Returns a reference to the Account object associated with this customer
    public Account getAccount() {
        return this.account;
    }

    // Method required by the interface
    @Override
    public int compareTo (Customer cust) {
        int lastCompare = this.lastName.compareTo(cust.lastName);
        int firstCompare = this.firstName.compareTo(cust.firstName);
        int accCompare = this.account.compareTo(cust.account);

        //same last name
        if (lastCompare < 0) {
            return -1;
        } else if (lastCompare > 0) {
            return 1;
        }
        // same first name
        if (firstCompare < 0) {
            return -1;
        } else if (firstCompare > 0) {
            return 1;
        }
        // same last and first name
        if (accCompare < 0) {
            return -1;
        } else if (accCompare > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
