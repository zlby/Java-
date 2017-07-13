
public class Phone {
	private String phoneCode;
    private String phoneName;
    private int price;

    public Phone(String phoneCode, String phoneName, int price) {
        this.phoneCode = phoneCode;
        this.phoneName = phoneName;
        this.price = price;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
