import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestProg {
	public static PhoneList pl = new PhoneList();
	public static SaleList sl = new SaleList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = readFile("Phones.txt");
		
		for(String ss : arr) {
			String[] s = ss.split("\\s+");
			for (int i = 0; i < 10; i++) {
				int price = 0;
				try {
				price = Integer.parseInt(s[2]);
				} catch(NumberFormatException e)
				{
					e.printStackTrace();
				}
				Phone p = new Phone(s[0], s[1], price);
				pl.addPhone(p);
			}
		}
//		System.out.println(pl.getSize());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneSalesFrame frame = new PhoneSalesFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ArrayList<String> readFile(String s)
    {
        File file = new File(s);
        FileInputStream fileName = null;
        try{
            fileName = new FileInputStream(file);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> strarr = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(fileName));
        String temp = "";
        try {
            for(;;)
            {
                temp = br.readLine();
                if (temp == null)
                    break;
                strarr.add(temp);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return strarr;
    }

}
