package rogerscompany;

public class Customer {

      @Override
    public String toString() {
        return "Name: " + firstName + " | " + "Last Name: " + lastName + " | " + " Address: " + address + " | " + " Credit Card: " + card; 
    }

    
    private String firstName, lastName, address, card;
    

    public Customer(String firstName, String lastName, String address, String card) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.card= card;

    }
    
    
    
    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setCard(String card) {
        this.card = card;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }    
    
    public String getCard() {
        return card;
    }


}
