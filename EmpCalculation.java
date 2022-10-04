package javagui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpCalculation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmpId;
	private JTextField txtEmpName;
	private JTextField txtSalary;
	private JTextField txtTax;
	private JTextField txtNetSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpCalculation frame = new EmpCalculation();
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
	public EmpCalculation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 918, 633);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(144, 209, 172, 43);
		panel.add(lblNewLabel);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSalary.setBounds(144, 263, 172, 43);
		panel.add(lblSalary);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTax.setBounds(144, 317, 172, 43);
		panel.add(lblTax);
		
		JLabel lblNetsalary = new JLabel("NetSalary");
		lblNetsalary.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNetsalary.setBounds(144, 371, 172, 43);
		panel.add(lblNetsalary);
		
		JLabel lblEmpId = new JLabel("Employee ID");
		lblEmpId.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblEmpId.setBounds(144, 155, 172, 43);
		panel.add(lblEmpId);
		
		txtEmpId = new JTextField();
		txtEmpId.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int Empid = 10;
				System.out.println("\nEnter Employee ID :   ");
				double EmployeeId = Double.parseDouble(txtEmpId.getText());
				if(Empid > 10)
				{
					System.out.println("print");
				}
				else 
				{
					System.out.println("error");
				}
				
				
			}
				
		});
		txtEmpId.setBounds(420, 164, 208, 33);
		panel.add(txtEmpId);
		txtEmpId.setColumns(10);
		
		txtEmpName = new JTextField();
		txtEmpName.setColumns(10);
		txtEmpName.setBounds(420, 218, 208, 33);
		panel.add(txtEmpName);
		
		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(420, 272, 208, 33);
		panel.add(txtSalary);
		
		txtTax = new JTextField();
		txtTax.setColumns(10);
		txtTax.setBounds(420, 326, 208, 33);
		panel.add(txtTax);
		
		txtNetSalary = new JTextField();
		txtNetSalary.setColumns(10);
		txtNetSalary.setBounds(420, 380, 208, 33);
		panel.add(txtNetSalary);
		
		JButton btnNewButton = new JButton("Cal\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				double salary = Double.parseDouble(txtSalary.getText());
				double tax;
				
				if(salary > 60000)
				{
					tax = salary * 10/100;
				}
				else if(salary > 350000)
				{
					tax = salary * 5/100;
				}
				else
				{
					tax = 0;
				}
				txtTax.setText(String.valueOf(tax));
				double NetSalary = salary - tax;
				txtNetSalary.setText(String.valueOf(NetSalary));
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(176, 478, 120, 61);
		panel.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtEmpId.setText("");
				txtEmpName.setText("");
				txtSalary.setText("");
				txtTax.setText("");
				txtNetSalary.setText("");
				txtEmpId.requestFocus();
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnClear.setBounds(364, 478, 126, 61);
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnExit.setBounds(553, 478, 137, 61);
		panel.add(btnExit);
		
		JLabel lblEmployeeSalaryCalculation = new JLabel("Employee Salary Calculation");
		lblEmployeeSalaryCalculation.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblEmployeeSalaryCalculation.setBounds(250, 33, 460, 43);
		panel.add(lblEmployeeSalaryCalculation);
	}
}
