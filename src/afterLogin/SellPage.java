package afterLogin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import beforeLogin.BeforeLogInMain;
import beforeLogin.LogInPage;
import swing.Page2;
import userDB.User;

public class SellPage extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private String value;
	


///////메인

	public static void main(String[]args) throws InvocationTargetException, InterruptedException  {
		
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					try {
						Page2 frame = new Page2();
						frame.setVisible(true);
					}
					catch(Exception e) {
						e.printStackTrace();
				}
			}
		});
	}
		
		
	
////////
	public SellPage() {
		run();
	}
	
	private void run() {
		
	     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100,100,1000,800);
		
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("등록하기"); //하단 등록하기 버튼
		
		button.addActionListener(new ActionListener() {
			String str = "";
			
			public void actionPerformed(ActionEvent e) {
				
				
					
					 JFrame jFrame = new JFrame();
				     JOptionPane.showMessageDialog(jFrame, "상품등록완료");
				     
					
				
			    
				
			}
			
		});
		
		 JButton bt1 = new JButton();
	      bt1.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	         }
	      });
	      bt1.setBorderPainted(false);
	      bt1.setBounds(12, 10, 180, 60);
//	      panel4.add(bt1);
//	      panel4.setLayout(null);
	      
	      //상단검색바
	      textField3 = new JTextField("  검색");
	      textField3.addFocusListener(new FocusListener() {

	         @Override
	         public void focusGained(FocusEvent e) {
	            textField3.setText("");
	            value = textField3.getText();
	         }

	         @Override
	         public void focusLost(FocusEvent e) {
	            
	         }
	      });
	      textField3.setBounds(234, 25, 333, 34);
	      textField3.setBorder(BorderFactory.createLineBorder(Color.decode("#ff0000")));
//	      panel4.add(textField3);
	      textField3.setColumns(10);
	      
	      //상단 우측 버튼들
	      JButton btnNewButton = new JButton("로그아웃");
	      btnNewButton.setBounds(887, 23, 85, 42);
//	      panel4.add(btnNewButton);
	      
	      JButton btnNewButton_1 = new JButton("내 상점");
	      btnNewButton_1.setBounds(790, 24, 85, 42);
//	      panel4.add(btnNewButton_1);
	      
	      JButton btnNewButton_2 = new JButton("판매하기");
	      btnNewButton_2.setBounds(693, 24, 85, 42);
//	      panel4.add(btnNewButton_2);
	      
	      //상단 검색창 돋보기 버튼
	      JButton bt2 = new JButton();
	      bt2.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	         }
	      });
		
		
		
			button.setBounds(850, 650, 97, 55);
			contentPane.add(button);
			
			
			//상단
			 JPanel panel4 = new JPanel();
		     panel4.setBounds(0, 0, 1000, 109);
		     contentPane.add(panel4);
		     panel4.add(textField3);
		     panel4.add(btnNewButton);
		     panel4.add(btnNewButton_1);
		     panel4.add(btnNewButton_2);
		     panel4.add(bt1);
		     panel4.setLayout(null);
		     bt2.setBounds(574, 30, 28, 23);
		     panel4.add(bt2);

			//하단 상품등록 제목창
			textField1 = new JTextField();
			textField1.setBorder(new TitledBorder(null,"제목",TitledBorder.LEADING,TitledBorder.TOP,null,null));
			textField1.setBounds(55, 350, 445, 45);
			
			contentPane.add(textField1);
			textField1.setColumns(10);
			String inputName = textField1.getText();
			
			//하단 상품등록 상품상세정보창
			textField2 = new JTextField();
			textField2.setBorder(new TitledBorder(null,"상품상세정보",TitledBorder.LEADING,TitledBorder.TOP,null,null));
			textField2.setBounds(55, 600, 600, 140);
			
			contentPane.add(textField2);
			textField2.setColumns(10);
			String inputContent = textField2.getText();

			
			//가격창
			textField3 = new JTextField();
			textField3.setBorder(new TitledBorder(null,"가격",TitledBorder.LEADING,TitledBorder.TOP,null,null));
			textField3.setBounds(550, 350, 200, 45);
			
			contentPane.add(textField3);
			textField3.setColumns(10);
			String inputPrice = textField3.getText();
			
			//지역창
			textField4 = new JTextField();
			textField4.setBorder(new TitledBorder(null,"지역(ex.ㅇㅇ시 ㅇㅇ구 ㅇㅇ동)",TitledBorder.LEADING,TitledBorder.TOP,null,null));
			textField4.setBounds(55, 440, 445, 45);
			
			contentPane.add(textField4);
			textField4.setColumns(10);
			String inputAddress = textField4.getText();
			
			//배송유형
			textField5 = new JTextField();
			textField5.setBorder(new TitledBorder(null,"배송유형(직거래/택배)",TitledBorder.LEADING,TitledBorder.TOP,null,null));
			textField5.setBounds(55, 520, 445, 45);
			
			contentPane.add(textField5);
			textField5.setColumns(10);
			String inputinputTransaction = textField5.getText();
		
//로그인한 유저 아이디: LogInPage.logInUser.getId()        	
//insertDatas("a", inputName, inputContent ..)
	       
			//Panel 1~3 -> 하단부분
			//Panel 4 -> 상단부분
		
			
			
	}
	
		
	
	
}
