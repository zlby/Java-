
public class Sale {
	private String saleCode;
    private String phoneCode;
    private int number;
    private String staff;

    public Sale(String saleCode, String phoneCode, int number, String staff) {
        this.saleCode = saleCode;
        this.phoneCode = phoneCode;
        this.number = number;
        this.staff = staff;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }
}
