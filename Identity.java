package javagui;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;

public class Identity extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtxtEmployeeId;
	private JTable table;
	private JTextField jtxtEmpName;
	private JTextField jtxtNoofDays;
	private JTextField jtxtSalary;
	private JTextField jtxtTax;
	private JTextField jtxtNetSalary;
	
	Connection conn= null;
	  PreparedStatement pst = null;
	  ResultSet rs = null;
	  
	   DefaultTableModel model = new DefaultTableModel();
	  /**
	   * Launch the application.
	   */
	private String sql;
	  
	   public void updateTable()
	   {
		   conn = Emp.ConnectDB();
		   if(conn != null)
		   {
		   String sql = "Select EmpID, EmpName, NoofDays, Salary, Tax, NetSalary";
		   }
		   try
		   {
			   pst =conn.prepareStatement(sql);
			   rs = pst.executeQuery();
			   Object[] ColumnData = new Object[8];
			   
			   while (rs.next())
			   {
				   ColumnData [0] = rs.getString("EmpID");
				   ColumnData [1] = rs.getString("EmpName");
				   ColumnData [2] = rs.getString("NoofDays");
				   ColumnData [3] = rs.getString("Salary");
				   ColumnData [6] = rs.getString("Tax");
				   ColumnData [7] = rs.getString("NetSalary");
				   
				model.addRow(ColumnData);
			   }
		   }
		   catch(Exception e)
		   {
			   JOptionPane.showMessageDialog(null, e);
		   }
	   }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identity frame = new Identity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Identity() 
	{
		initialize();
		
		conn = Emp.ConnectDB();
		Object col[] = {"EmpID", "EmpName", "NoofDays", "Salary", "Tax", "NetSalary"};
		model.setColumnIdentifiers(col);
	}
		private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(46, 97, 108, 33);
		contentPane.add(lblNewLabel);
		
		jtxtEmployeeId = new JTextField();
		jtxtEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jtxtEmployeeId.setBounds(173, 99, 159, 33);
		contentPane.add(jtxtEmployeeId);
		jtxtEmployeeId.setColumns(10);
		
		JButton jtxtTotal = new JButton("New ");
		jtxtTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			String sql ="Insert INTO Identity(EmpID, EmpName, NoofDays, Salary, Tax, NetSalary)VALUES(?,?,?,?,?,?)";
				try
				{	
					pst = conn.prepareStatement(sql);
					pst.setString(1, jtxtEmployeeId.getText());
					pst.setString(2,jtxtEmpName.getText());
					pst.setString(3,jtxtNoofDays.getText());
					pst.setString(4,jtxtSalary.getText());
					pst.setString(5,jtxtTax.getText());
					pst.setString(8,jtxtNetSalary.getText());
					
					pst.execute();
					rs.close();
					pst.close();				
				}
			
			catch(Exception ev)
			   {
				   JOptionPane.showMessageDialog(null, "System Update completed");
			   }
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{
					
					jtxtEmployeeId.getText(),
					jtxtEmpName.getText(),
					jtxtNoofDays.getText(),
					jtxtSalary.getText(),
					jtxtTax.getText(),
					jtxtNetSalary.getText(),
				});
			if (table.getSelectedRow() == -1)
			{
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Membership update confirmed",
					"Generation of Salary slip", JOptionPane.OK_OPTION);
				}
			}
		}
		});
		jtxtTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jtxtTotal.setBounds(115, 481, 131, 46);
		contentPane.add(jtxtTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 101, 697, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] 
			{
				"EmpID", "Emp Name", "No of Days", "Salary", "Tax", "Net Salary"
			}
		));
		table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Emp Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(46, 159, 108, 33);
		contentPane.add(lblNewLabel_1);
		
		jtxtEmpName = new JTextField();
		jtxtEmpName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jtxtEmpName.setBounds(173, 159, 159, 33);
		contentPane.add(jtxtEmpName);
		jtxtEmpName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("No of Days");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(46, 216, 108, 33);
		contentPane.add(lblNewLabel_1_1);
		
		jtxtNoofDays = new JTextField();
		jtxtNoofDays.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jtxtNoofDays.setColumns(10);
		jtxtNoofDays.setBounds(173, 216, 159, 33);
		contentPane.add(jtxtNoofDays);
		
		JLabel lblNewLabel_1_2 = new JLabel("Salary");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(46, 275, 108, 33);
		contentPane.add(lblNewLabel_1_2);
		
		jtxtSalary = new JTextField();
		jtxtSalary.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jtxtSalary.setColumns(10);
		jtxtSalary.setBounds(173, 275, 159, 33);
		contentPane.add(jtxtSalary);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tax");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(46, 332, 108, 33);
		contentPane.add(lblNewLabel_1_3);
		
		jtxtTax = new JTextField();
		jtxtTax .setFont(new Font("Times New Roman", Font.BOLD, 18));
		jtxtTax .setColumns(10);
		jtxtTax .setBounds(173, 332, 159, 33);
		contentPane.add(jtxtTax );
		
		JLabel lblNewLabel_1_6 = new JLabel("NetSalary");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_6.setBounds(46, 388, 108, 33);
		contentPane.add(lblNewLabel_1_6);
		
		jtxtNetSalary = new JTextField();
		jtxtNetSalary.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jtxtNetSalary.setColumns(10);
		jtxtNetSalary.setBounds(173, 388, 159, 33);
		contentPane.add(jtxtNetSalary);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MessageFormat header=new MessageFormat("Printing in Progress");
				MessageFormat footer=new MessageFormat("Page {0, number, integer}");
				
				try 
				{
					table.print();
				}
				catch(java.awt.print.PrinterException ev)
				{
					System.err.format("No Printer found", ev.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnPrint.setBounds(351, 481, 131, 46);
		contentPane.add(btnPrint);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jtxtEmployeeId.setText(null);
				jtxtEmpName.setText(null);
				jtxtNoofDays.setText(null);
				jtxtSalary.setText(null);
				jtxtTax.setText(null);
				jtxtNetSalary.setText(null);
				
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(582, 481, 131, 46);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			JFrame frame = new JFrame("Exit");
			if(JOptionPane.showConfirmDialog(frame, "Confirm if you wants to exit",
			"Generation of Salary slip",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
			{
				System.exit(0);
			}
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBounds(818, 481, 131, 46);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("Generation of Salary slip");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel_2.setBounds(351, 30, 410, 39);
		contentPane.add(lblNewLabel_2);
	}
}
