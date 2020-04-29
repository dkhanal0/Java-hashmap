package hashmap;


public class CommercialAccount extends Account {

    //  // Using the code from a previous assignment ( Comparable - BST-2)
    private String taxId;

    // Constructor
    public CommercialAccount(String accountNumber, Customer customer, String taxId) {
        // Initialize parent variables
        super(accountNumber, customer);
        // Initialize tax id
        this.taxId = taxId;
    }

    public String getTaxId() {
        return (this.taxId);
    }
}
