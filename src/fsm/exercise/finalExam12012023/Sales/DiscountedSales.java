package fsm.exercise.finalExam12012023.Sales;

public class DiscountedSales extends Sales {
    private String reason;
    private int specialDiscount;

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public void setSpecialDiscount(int specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    @Override
    public int getPrice() {
        return super.getPrice()-getSpecialDiscount();
    }
}
