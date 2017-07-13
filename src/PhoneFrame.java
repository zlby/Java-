import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PlainDocument;
import javax.swing.JTable;

public class PhoneFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PhoneFrame frame = new PhoneFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public PhoneFrame() {
		setTitle("Phones Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnNames = { "±àºÅ", "Ãû³Æ", "¿â´æ" };
		
		Object[][] obj = new Object[4][3];
		obj[0][0] = "±àºÅ";
		obj[0][1] = "Ãû³Æ";
		obj[0][2] = "¿â´æ";
		ArrayList<String> arr = TestProg.readFile("Phones.txt");
		for (int i = 0; i < arr.size(); i++) {
			String[] ss = arr.get(i).split("\\s+");
			obj[i+1][0] = ss[0];
			obj[i+1][1] = ss[1];
		}
		for (int i = 1; i < 4; i++) {
			obj[i][2] = TestProg.pl.getNumRemain(obj[i][0].toString());
		}

		table = new JTable(obj, columnNames);
		table.setRowHeight(57);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(14, 13, 404, 227);
		contentPane.add(table);
	}

}
