import java.util.ArrayList;

public class SaleList {
	private ArrayList<Sale> saleList;

    public SaleList() {
        saleList = new ArrayList<Sale>();
    }

    public int addSale(Sale s){
        saleList.add(s);
        return 0;
    }

    public int removeSale(String saleCode) {
        //if the return value is 0, remove successfully
        //if the return value is 1, there are no required sales found
        //if the return value is 2, the saleList is empty
        if (saleList.size() == 0)
            return 2;
        for (int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i).getSaleCode() == saleCode) {
                saleList.remove(i);
                return 0;
            }
        }
        return 1;
    }
    
    public int getSize(){
    	return saleList.size();
    }
    
    public ArrayList<Sale> getList() {
    	return saleList;
    }
}
