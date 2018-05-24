//have the account object have parametrs: customer, each 3 types of. (easer to do that rather than have plan and that have 3 plans.. already ahve methods that create the objects so just pass those into the account
//****important: to dispaly, chekc it those parametsr of plans tehy dont have::: if all 0 (no value was inputed, so it is that preset object that must exist), dont display it just
//for givin them an account number: juts go up from 1 to infinity (no need no clock or counter
package rogerscompany;

public class Account {
    
  
    @Override
    public String toString() {
        return "PERSONAL INFORMATION \t" + customer + "\n" + "INTERNET PLAN \t" + internet + "\n" + "CELLPHONE PLAN \t"+ cell + "\n" + "TV PLAN \t"+ tv + "\n" ; 
    }

    private Customer customer;
    private InternetPlan internet;
    private CellPhonePlan cell;
    private TVPlan tv;

    public Account(Customer customer, InternetPlan internet, CellPhonePlan cell, TVPlan tv) {
        this.customer = customer;
        this.internet = internet;
        this.cell = cell;
        this.tv = tv;
    }

    public Customer getCustomer() {
        return customer;
    }

    public InternetPlan getInternet() {
        return internet;
    }

    public CellPhonePlan getCell() {
        return cell;
    }

    public TVPlan getTv() {
        return tv;
    }

    
    
    public void setCustomer (Customer customer){
        this.customer = customer;
    }
    
    public void setInternet(InternetPlan internet) {
        this.internet = internet;
    }

    public void setCell(CellPhonePlan cell) {
        this.cell = cell;
    }

    public void setTv(TVPlan tv) {
        this.tv = tv;
    }
    
    
    
}
