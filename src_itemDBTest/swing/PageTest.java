package swing;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import itemDB.JTables;

import java.awt.Color;
import javax.swing.JRadioButton;

public class PageTest extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private String value;

	// �������� �ΰ� ��ư
	ImageIcon icon = new ImageIcon("C:\\Users\\admin\\Desktop\\usedItemCombined\\src\\swing/Logo.jpg");
	Image img = icon.getImage();
	Image imgChange = img.getScaledInstance(180, 60, Image.SCALE_SMOOTH);
	ImageIcon updateIcon = new ImageIcon(imgChange);

	// �˻��� ������ ��ư
	ImageIcon icon2 = new ImageIcon("C:\\Users\\admin\\Desktop\\usedItemCombined\\src\\swing/Icon.png");
	Image img2 = icon2.getImage();
	Image imgChange2 = img2.getScaledInstance(28, 23, Image.SCALE_SMOOTH);
	ImageIcon updateIcon2 = new ImageIcon(imgChange2);

	// ���� �޼ҵ�
	public static void main(String[] args) {
		run();
	}

	// ���� �޼ҵ�
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageTest window = new PageTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ���ΰ�ħ �޼ҵ�
	public static void run2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageTest window = new PageTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ������ �޼ҵ�
	public PageTest() throws ClassNotFoundException, SQLException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, SQLException {
		// ������
		frame = new JFrame();
		frame.setBounds(100, 100, 1012, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
////////////////////�г� ���
		
		// ��� �г�
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 109);
		frame.getContentPane().add(panel);

		// �������� �ΰ� ��ư + ���������� �̵�
		JButton bt1 = new JButton(updateIcon);
		bt1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt1.setBorderPainted(false);
		bt1.setBounds(12, 10, 180, 60);
		panel.add(bt1);
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
		JButton bt2 = new JButton(updateIcon2);
		bt2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bt2.setBounds(574, 30, 28, 23);
		panel.add(bt2);

////////////////////�г� �ϴ�
		
		// �ϴ� �г� �κ�
		JPanel panel12 = new JPanel();
		panel12.setBounds(0, 108, 995, 533);
		frame.getContentPane().add(panel12);
		panel12.setLayout(null);

		JButton btnNewButton11 = new JButton("��Ȯ����");
		btnNewButton11.setBounds(646, 12, 88, 23);
		panel12.add(btnNewButton11);

		JButton btnNewButton12 = new JButton("�ֽż�");
		btnNewButton12.setBounds(740, 12, 74, 23);
		panel12.add(btnNewButton12);

		JButton btnNewButton13 = new JButton("������");
		btnNewButton13.setBounds(819, 12, 75, 23);
		panel12.add(btnNewButton13);

		JButton btnNewButton14 = new JButton("����");
		btnNewButton14.setBounds(898, 12, 74, 23);
		panel12.add(btnNewButton14);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 54, 971, 469);
		panel12.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		//���̺�����
				JPanel table = new JPanel();
				
				table.setBounds(200,200,0,0);
				table.setSize(500,400);
				frame.getContentPane().add(table);
				
				JTables t = new JTables();
				table.add(t.tableAction());
				
			JTables tt= new JTables();
			table.add(tt.tableAction("price"));
			
				
				//���콺�̺�Ʈ
				
//				btnNewButton13.addActionListener(new ActionListener() {
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						t.setVisible(false);
//						tt.setVisible(true);
//					}
//
//					
//					});
				
				
				};
				
				
	}

