package fsm.exercise.finalExam12012023.Company;

import fsm.exercise.finalExam12012023.Sales.DiscountedSales;
import fsm.exercise.finalExam12012023.Sales.Sales;

public class Customer {
    private Sales[] sales;
    private String firstName;
    private String secondName;

    public Sales[] getSales() {
        return sales;
    }

    public void setSales(Sales[] sales) {
        this.sales = sales;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public static int getTotalPrice(Sales[] sales){
        int total = 0;
        for (Sales sale : sales) {
            if(sale instanceof DiscountedSales){
                total += ((DiscountedSales) sale).getSpecialDiscount();
            }
        }
        return total;
    }
}
