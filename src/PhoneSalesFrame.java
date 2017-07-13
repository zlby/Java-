import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PhoneSalesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtStaffName;
	private JTextField txtPhoneCode;
	private JTextField txtQuantity;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PhoneSalesFrame frame = new PhoneSalesFrame();
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
	public PhoneSalesFrame() {
		setTitle("Phones Sale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtArea = new JTextArea();
		
		txtArea.setText("序号\t编号\t名称\t销售员\t数量\t单价\t总价\n");;
		txtArea.setEditable(false);
		txtArea.setBounds(14, 67, 586, 236);
		contentPane.add(txtArea);
		
		JButton btnShowPhones = new JButton("Show Phones");
		btnShowPhones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PhoneFrame frame2 = new PhoneFrame();
				frame2.setVisible(true);
			}
		});
		btnShowPhones.setBounds(14, 13, 146, 40);
		contentPane.add(btnShowPhones);
		
		JButton btnShowChart = new JButton("Show Chart");
		btnShowChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChartFrame frame3 = new ChartFrame();
				frame3.setVisible(true);
			}
		});
		btnShowChart.setBounds(236, 13, 146, 40);
		contentPane.add(btnShowChart);
		
		JButton btnSaveAndExit = new JButton("Save and Exit");
		btnSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> arr = new ArrayList<String>();
				int totalNum = 0;
				arr.add("手机销售统计");
				arr.add("");
				arr.add("=========================================================");
				arr.add("001号 iPhone6:单价 6800");
				arr.add("");
				for (Sale sale : TestProg.sl.getList()) {
					if (sale.getPhoneCode().equals("001")) {
						arr.add(sale.getSaleCode() + "\t" + sale.getStaff() + "\t\t" + sale.getNumber() + " @ ￥ 6800 = ￥" + sale.getNumber() * 6800);
						totalNum += sale.getNumber();
					}
				}
				arr.add("=========================================================");
				arr.add("总销量：" + totalNum + "\t\t￥" + totalNum*6800);
				arr.add("=========================================================");
				arr.add("");
				arr.add("");
				totalNum = 0;
				
				arr.add("=========================================================");
				arr.add("002号 Samsung5s:单价 4000");
				arr.add("");
				for (Sale sale : TestProg.sl.getList()) {
					if (sale.getPhoneCode().equals("002")) {
						arr.add(sale.getSaleCode() + "\t" + sale.getStaff() + "\t\t" + sale.getNumber() + " @ ￥ 4000 = ￥" + sale.getNumber() * 4000);
						totalNum += sale.getNumber();
					}
				}
				arr.add("=========================================================");
				arr.add("总销量：" + totalNum + "\t\t￥" + totalNum*4000);
				arr.add("=========================================================");
				arr.add("");
				arr.add("");
				totalNum = 0;
				
				arr.add("=========================================================");
				arr.add("003号 HuaweiHonor8:单价 2800");
				arr.add("");
				for (Sale sale : TestProg.sl.getList()) {
					if (sale.getPhoneCode().equals("003")) {
						arr.add(sale.getSaleCode() + "\t" + sale.getStaff() + "\t\t" + sale.getNumber() + " @ ￥ 2800 = ￥" + sale.getNumber() * 2800);
						totalNum += sale.getNumber();
					}
				}
				arr.add("=========================================================");
				arr.add("总销量：" + totalNum + "\t\t￥" + totalNum*2800);
				arr.add("=========================================================");
				arr.add("");
				arr.add("");
				totalNum = 0;
				
				
				FileWriter fw = null;
				try {
				File f=new File("Sales.txt");
				fw = new FileWriter(f, false);
				} catch (IOException ee) {
				ee.printStackTrace();
				}
				PrintWriter pw = new PrintWriter(fw);
				for (String s : arr) {
					pw.println(s);
				}
				pw.flush();
				try {
				fw.flush();
				pw.close();
				fw.close();
				} catch (IOException ee) {
				ee.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnSaveAndExit.setBounds(454, 13, 146, 40);
		contentPane.add(btnSaveAndExit);
		
		JButton btnProcessSale = new JButton("Process Sale");
		btnProcessSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPhoneCode.getText().equals("") || txtQuantity.getText().equals("") || txtStaffName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all the information!", "error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if (txtPhoneCode.getText().equals("001") || txtPhoneCode.getText().equals("002") || txtPhoneCode.getText().equals("003")) {
						int number = 0;
						try {
							number = Integer.parseInt(txtQuantity.getText());
							if (number > 0) {
								Sale sale = new Sale(Integer.toString(TestProg.sl.getSize() + 1), txtPhoneCode.getText(), number, txtStaffName.getText());
								TestProg.sl.addSale(sale);
								for (int i = 0; i < number; i++) {
									TestProg.pl.removePhone(sale.getPhoneCode());
								}
								String s = txtArea.getText();
								String phoneName = "";
								int phonePrice = 0;
								for (Phone p : TestProg.pl.getList()) {
									if (sale.getPhoneCode().equals(p.getPhoneCode())) {
										phoneName = p.getPhoneName();
										phonePrice = p.getPrice();
										break;
									}
								}
								s = s + sale.getSaleCode() + "\t" + sale.getPhoneCode() + "\t" + phoneName + "\t" 
										+ sale.getStaff() + "\t" + sale.getNumber() + "\t" + phonePrice + "\t" + sale.getNumber() * phonePrice + "\n";
								txtArea.setText(s);
							}
							else {
								JOptionPane.showMessageDialog(null, "Please enter the correct quantity!", "error", JOptionPane.INFORMATION_MESSAGE);
							}
						}catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(null, "Please enter the correct quantity!", "error", JOptionPane.INFORMATION_MESSAGE);
						} finally {
							txtPhoneCode.setText("");
							txtStaffName.setText("");
							txtQuantity.setText("");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter the correct phone code!", "error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnProcessSale.setBounds(73, 341, 146, 40);
		contentPane.add(btnProcessSale);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPhoneCode.setText("");
				txtStaffName.setText("");
				txtQuantity.setText("");
			}
		});
		btnClear.setBounds(73, 415, 146, 40);
		contentPane.add(btnClear);
		
		JLabel lblStaff = new JLabel("Staff Name");
		lblStaff.setBounds(280, 341, 88, 18);
		contentPane.add(lblStaff);
		
		JLabel lblPhoneCode = new JLabel("Phone Code");
		lblPhoneCode.setBounds(280, 389, 102, 18);
		contentPane.add(lblPhoneCode);
		
		JLabel lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setBounds(280, 437, 72, 18);
		contentPane.add(lblNewLabel);
		
		txtStaffName = new JTextField();
		txtStaffName.setBounds(371, 341, 229, 24);
		contentPane.add(txtStaffName);
		txtStaffName.setColumns(10);
		
		txtPhoneCode = new JTextField();
		txtPhoneCode.setColumns(10);
		txtPhoneCode.setBounds(371, 386, 229, 24);
		contentPane.add(txtPhoneCode);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(371, 431, 229, 24);
		contentPane.add(txtQuantity);
	}
}
