import java.util.ArrayList;

public class PhoneList {
	private ArrayList<Phone> phoneList;

    public PhoneList() {
        phoneList = new ArrayList<Phone>();
    }

    public int addPhone(Phone p){
        phoneList.add(p);
        return 5;
    }

    public int removePhone(String phoneCode) {
        //if the return value is 0, remove successfully
        //if the return value is 1, there are no required phones found
        //if the return value is 2, the phonelist is empty
        if (phoneList.size() == 0)
            return 2;
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getPhoneCode().equals(phoneCode)) {
                phoneList.remove(i);
                return 0;
            }
        }
        return 1;
    }
    
    public int getSize() {
    	return phoneList.size();
    }
    
    public int getNumRemain(String phoneCode) {
    	int counter = 0;
    	for (Phone p : phoneList){
    		if (p.getPhoneCode().equals(phoneCode))
    			counter++;
    	}
    	return counter;
    }
    
    public ArrayList<Phone> getList() {
    	return phoneList;
    }
}
