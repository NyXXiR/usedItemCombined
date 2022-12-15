package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

interface ActionListener {
	public void actionPerformed(ActionEvent e);
}

public class Page3 extends JFrame {
	private JFrame frame;
	private JTextField textField;
	private String value;
	public JTextField textField1;
	public JTextField textField2;
	public JTextField textField3;
	public JTextField textField4;
	public JTextField textField5;
	boolean run = true;
	public JPanel[] arr1 = new JPanel[5];
	public JButton[] arr2 = new JButton[5];
	public Object[][] arr3 = new Object[5][2];

	// �������� �ΰ� ��ư
	ImageIcon icon = new ImageIcon("C:\\\\_dev\\\\team\\\\src\\\\team12/Logo.jpg");
	Image img = icon.getImage();
	Image imgChange = img.getScaledInstance(180, 60, Image.SCALE_SMOOTH);
	ImageIcon updateIcon = new ImageIcon(imgChange);

	// �˻��� ������ ��ư
	ImageIcon icon2 = new ImageIcon("C:\\\\_dev\\\\team\\\\src\\\\team12/Icon.png");
	Image img2 = icon2.getImage();
	Image imgChange2 = img2.getScaledInstance(28, 23, Image.SCALE_SMOOTH);
	ImageIcon updateIcon2 = new ImageIcon(imgChange2);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page3 window = new Page3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ������ �޼ҵ�
	public Page3() {
		top();
	}

	// ��� ���� �޼ҵ�
	private void top() {
		// ������
		frame = new JFrame();
		frame.setBounds(100, 100, 1012, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// ��� �г�
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 109);
		frame.getContentPane().add(panel);

		//�ϴ� �г� ����
		JPanel panel1 = new JPanel();
		arr1[0] = panel1;
		panel1.setBounds(0, 239, 995, 402);
		frame.getContentPane().add(panel1);
		panel1.setVisible(true);
		
		JPanel panel2 = new JPanel();
		arr1[1] = panel2;
		panel2.setBounds(0, 239, 995, 402);
		frame.getContentPane().add(panel2);
		panel2.setVisible(false);
		
		JPanel panel3 = new JPanel();
		arr1[2] = panel3;
		panel3.setBounds(0, 239, 995, 402);
		frame.getContentPane().add(panel3);
		panel3.setVisible(false);
		
		JPanel panel4 = new JPanel();
		arr1[3] = panel4;
		panel4.setBounds(0, 239, 995, 402);
		frame.getContentPane().add(panel4);
		panel4.setVisible(false);
		
		JPanel panel5 = new JPanel();
		arr1[4] = panel5;
		panel5.setBounds(0, 239, 995, 402);
		frame.getContentPane().add(panel5);
		panel5.setVisible(false);
		
		
		//�ϴ��г� Ȯ�ο� �ؽ�Ʈ �ʵ�
		textField1 = new JTextField("��");
		textField1.setBounds(162, 94, 232, 117);
		panel1.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField("�Ǹ�");
		textField2.setBounds(162, 94, 232, 117);
		panel2.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField("����");
		textField3.setBounds(162, 94, 232, 117);
		panel3.add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField("����");
		textField4.setBounds(162, 94, 232, 117);
		panel4.add(textField4);
		textField4.setColumns(10);
		
		textField5 = new JTextField("��������");
		textField5.setBounds(162, 94, 232, 117);
		panel5.add(textField5);
		textField5.setColumns(10);
		
		//��ư
		JButton bt1 = new JButton("1��");
		arr2[0] = bt1;
		bt1.setBounds(-1, 140, 199, 89);
		frame.getContentPane().add(bt1);
		
		JButton bt2 = new JButton("2��");
		arr2[1] = bt2;
		bt2.setBounds(197, 140, 199, 89);
		frame.getContentPane().add(bt2);
		
		JButton bt3 = new JButton("3��");
		arr2[2] = bt3;
		bt3.setBounds(397, 140, 199, 89);
		frame.getContentPane().add(bt3);
		
		JButton bt4 = new JButton("4��");
		arr2[3] = bt4;
		bt4.setBounds(597, 140, 199, 89);
		frame.getContentPane().add(bt4);
		
		JButton bt5 = new JButton("5��");
		arr2[4] = bt5;
		bt5.setBounds(796, 140, 199, 89);
		frame.getContentPane().add(bt5);
		
		//Ŭ�� �̺�Ʈ
		arr3[0][0]=panel1;
		arr3[0][1]=bt1;
		
		arr3[1][0]=panel2;
		arr3[1][1]=bt2;
		
		arr3[2][0]=panel3;
		arr3[2][1]=bt3;
		
		arr3[3][0]=panel4;
		arr3[3][1]=bt4;
		
		arr3[4][0]=panel5;
		arr3[4][1]=bt5;
		
		for(Object[] object : arr3) {
			((JButton)object[1]).addActionListener((e)-> {
				
				//�ʱ�ȭ
				for(Object[] object2 : arr3) {
					((JPanel)object2[0]).setVisible(false);
				}
				
				//���ϴ� �κ� �����ֱ�
				((JPanel)object[0]).setVisible(true);
			});
		}

		// �������� �ΰ� ��ư + ���������� �̵�
		JButton bt11 = new JButton(updateIcon);
		bt11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.setVisible(true);
			}
		});
		bt11.setBorderPainted(false);
		bt11.setBounds(12, 10, 180, 60);
		panel.add(bt11);
		panel.setLayout(null);

		// �˻���
		textField = new JTextField("  �˻�");
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
				value = textField.getText();
			}

			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		textField.setBounds(234, 25, 333, 34);
		textField.setBorder(BorderFactory.createLineBorder(Color.decode("#ff0000")));
		panel.add(textField);
		textField.setColumns(10);

		// ��� ���� ��ư��
		JButton btnNewButton = new JButton("�α׾ƿ�");
		btnNewButton.setBounds(887, 23, 85, 42);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("�� ����");
		btnNewButton_1.setBounds(790, 24, 85, 42);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("�Ǹ��ϱ�");
		btnNewButton_2.setBounds(693, 24, 85, 42);
		panel.add(btnNewButton_2);

		// ������ ��ư
		JButton bt12 = new JButton(updateIcon2);
		bt12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bt12.setBounds(574, 30, 28, 23);
		panel.add(bt12);
	}

}
