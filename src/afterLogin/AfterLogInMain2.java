package afterLogin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import beforeLogin.BeforeLogInMain;
import beforeLogin.LogInPage;
import itemDB.ItemDB;
import itemDB.ItemList;
import itemDB.JTables;
import userDB.User;

public class AfterLogInMain2 extends JFrame {
	public static JFrame frame;
	public JTextField textField;
	public String value;
	ItemDB itemDB = new ItemDB();

	// 번개장터 로고 버튼
	ImageIcon icon = new ImageIcon("C:\\Users\\admin\\Desktop\\usedItemCombined\\src\\swing/Logo.jpg");
	Image img = icon.getImage();
	Image imgChange = img.getScaledInstance(180, 60, Image.SCALE_SMOOTH);
	ImageIcon updateIcon = new ImageIcon(imgChange);

	// 검색바 돋보기 버튼
	ImageIcon icon2 = new ImageIcon("C:\\Users\\admin\\Desktop\\usedItemCombined\\src\\swing/Icon.png");
	Image img2 = icon2.getImage();
	Image imgChange2 = img2.getScaledInstance(28, 23, Image.SCALE_SMOOTH);
	ImageIcon updateIcon2 = new ImageIcon(imgChange2);

	 //메인 메소드
		public static void main(String[] args) {	
			run();
		}

	// 실행 메소드
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLogInMain2 window = new AfterLogInMain2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 새로고침 메소드
	public static void run2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLogInMain2 window = new AfterLogInMain2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 생성자 메소드
	public AfterLogInMain2() throws ClassNotFoundException, SQLException {
		initialize();
	}

	//----------------------------------------------------기본 뼈대 메소드 --------------------------------------------------//
	private void initialize() throws ClassNotFoundException, SQLException {
		// 프레임
		frame = new JFrame();
		frame.setBounds(100, 100, 1012, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		

		// 상단 패널
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 109);
		frame.getContentPane().add(panel);

		// 번개장터 로고 버튼 + 메인페이지 이동
		JButton bt1 = new JButton(updateIcon);
		bt1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("로그인 유저 아이디: " + LogInPage.logInUser.getId());
			}
		});
		bt1.setBorderPainted(false);
		bt1.setBounds(12, 10, 180, 60);
		panel.add(bt1);
		panel.setLayout(null);

		// 검색바
		textField = new JTextField("  검색");
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

		// 상단 우측 버튼들
		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.setBounds(887, 23, 85, 42);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("내 상점");
		btnNewButton_1.setBounds(790, 24, 85, 42);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("판매하기");
		btnNewButton_2.setBounds(693, 24, 85, 42);
		panel.add(btnNewButton_2);
		
		// --> 상단 우측 버튼 기능
		// 로그아웃
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			User logout = new User();
			LogInPage.logInUser = logout; //로그인한 유저 끊기
			
			 BeforeLogInMain.frame.setVisible(true);
			 frame.dispose();
			 MyStorePage.frame.dispose();
			 SellPage.frame.dispose();
			}
		});
		// 내상점
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyStorePage.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		//판매하기
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SellPage.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		


		// 하단 패널 부분
		JPanel panel12 = new JPanel();
		panel12.setBounds(0, 108, 995, 533);
		frame.getContentPane().add(panel12);
		panel12.setLayout(null);

		JButton btnNewButton11 = new JButton("번호순");
		btnNewButton11.setBounds(646, 12, 88, 23);
		panel12.add(btnNewButton11);

		JButton btnNewButton12 = new JButton("최신순");
		btnNewButton12.setBounds(740, 12, 74, 23);
		panel12.add(btnNewButton12);

		JButton btnNewButton13 = new JButton("저가순");
		btnNewButton13.setBounds(819, 12, 75, 23);
		panel12.add(btnNewButton13);

		JButton btnNewButton14 = new JButton("고가순");
		btnNewButton14.setBounds(898, 12, 74, 23);
		panel12.add(btnNewButton14);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 45, 971, 469);
		panel12.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

	    // JTables selectAll = new JTables();
	    // table.add(selectAll.tableAction());

		// 테이블정보
//	    JTables orderByPrice = new JTables();
//	    ItemDB itemDB = new ItemDB();
//	    ArrayList<ItemList> itemList = itemDB.orderData("price");
//	    JTable a = orderByPrice.toJTable(itemList);
//	    
//	    JPanel table = new JPanel();
//	    table.add(a);
//	    
//	    table.setBounds(200, 200, 0, 0);
//	    table.setSize(800, 600);
//	    panel_1.add(table);
//	    
	    //패널 만들기
		CardLayout c1 = new CardLayout();
		JPanel table1 = new JPanel(c1);
		table1.setBounds(10, 200, 960, 200);
		frame.getContentPane().add(table1);
		frame.setVisible(true);
       
		
		table1.add(new JTables().tableAction(), "0");
		table1.add(new JTables().tableActionDesc("num"), "1");
		table1.add(new JTables().tableAction("price"), "2");
		table1.add(new JTables().tableActionDesc("price"), "3");
		table1.add(new JTables().toJTable(itemDB.likeData(value)),"4");
				
				
		
		c1.show(table1, "0");

		// 마우스 이벤트
		btnNewButton11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.show(table1, "0");
			}
		});

		btnNewButton12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.show(table1, "1");
			}
		});

		btnNewButton13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.show(table1, "2");
			}
		});

		btnNewButton14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.show(table1, "3");
			}
		});
		// 돋보기 버튼
				JButton bt2 = new JButton(updateIcon2);
				bt2.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("로그인 유저 아이디: " + LogInPage.logInUser.getId());
						c1.show(table1, "4");
					}
				});
				bt2.setBounds(574, 30, 28, 23);
				panel.add(bt2);
	}

	//----------------------------------------------------기본 뼈대 메소드 끝--------------------------------------------------//
	
	}
	
