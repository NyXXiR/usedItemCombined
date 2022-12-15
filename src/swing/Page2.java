package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Page2 extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JCheckBox checkBox6;
	private JCheckBox checkBox7;
	private JCheckBox checkBox8;
	private JCheckBox checkBox9;
	private JCheckBox checkBox10;
	
	private JRadioButton radio1;
	private JRadioButton radio2;
	
	


///////

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
	public Page2() {
		run();
	}
	
	private void run() {
		
	     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100,100,1000,800);
		
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("����ϱ�");
		
		button.addActionListener(new ActionListener() {
			String str = "";
			
			public void actionPerformed(ActionEvent e) {
				if(radio1.isSelected()) {
					str+=radio1.getText();
				}
				
				str+="";
				
				if(radio2.isSelected()) {
					str+=radio2.getText();
				}
				
				str+="--->";
						
				
				if(checkBox1.isSelected()) {
					str+=checkBox1.getText();
					str+=" /";
				}
				
				
				if(checkBox2.isSelected()) {
					str+=checkBox2.getText();
					str+=" /";
				}
				
				
				if(checkBox3.isSelected()) {
					str+=checkBox3.getText();
					str+=" /";
				}
				
				
				
				if(checkBox4.isSelected()) {
					str+=checkBox4.getText();
					str+=" /";
				}
				
				
				if(checkBox5.isSelected()) {
					str+=checkBox5.getText();
				}
				
				str+=" ";
				
				if(checkBox6.isSelected()) {
					str+=checkBox6.getText();
				}
				
				str+=" ";
				
				if(checkBox7.isSelected()) {
					str+=checkBox7.getText();
				}
				
				str+=" ";
				
				if(checkBox8.isSelected()) {
					str+=checkBox8.getText();
				}
				
				str+=" ";
				
				if(checkBox9.isSelected()) {
					str+=checkBox9.getText();
				}
				
				str+=" ";
				
				if(checkBox10.isSelected()) {
					str+=checkBox10.getText();
				}
				
				
				
				 JFrame jFrame = new JFrame();
			     JOptionPane.showMessageDialog(jFrame, "��ǰ��ϿϷ�");
			     
				
			}
			
		});
		
		
			button.setBounds(850, 650, 97, 55);
			contentPane.add(button);
			
			
			//////////��з�////////////
			JPanel panel =new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					"��з�",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,0,0)));
			
			
			panel.setBounds(50, 400, 200, 200);
			contentPane.add(panel);
			
			checkBox1 = new JCheckBox("�����Ƿ�");
			panel.add(checkBox1);
			
			checkBox2 = new JCheckBox("�����Ƿ�");
			panel.add(checkBox2);
			
			checkBox3 = new JCheckBox("�м���ȭ");
			panel.add(checkBox3);
			
			checkBox4 = new JCheckBox("����&����");
			panel.add(checkBox4);
			
			
			///////////�ߺз�///////////
			JPanel panel2 =new JPanel();
			panel2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					"�ߺз�",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,0,0)));
			
			
			panel2.setBounds(300, 400, 200, 200);
			contentPane.add(panel2);
			
			checkBox5 = new JCheckBox("����");
			panel2.add(checkBox5);
			
			checkBox6 = new JCheckBox("����");
			panel2.add(checkBox6);
			
			checkBox7 = new JCheckBox("����");
			panel2.add(checkBox7);
			
			checkBox8 = new JCheckBox("�Ź�");
			panel2.add(checkBox8);
			
			checkBox9 = new JCheckBox("TV");
			panel2.add(checkBox9);
			
			checkBox10 = new JCheckBox("ħ��");
			panel2.add(checkBox10);
			
			/////////////���ɹ��//////////
			
			JPanel panel3 =new JPanel();
			panel3.setBorder(new TitledBorder(null,"���ɹ��",TitledBorder.LEADING,
					TitledBorder.TOP,null,null));
			
			
			panel3.setBounds(550, 400, 200, 200);
			contentPane.add(panel3);
			
			radio1 = new JRadioButton("���ŷ�");
			panel3.add(radio1);
			
			radio2 = new JRadioButton("�ù�ŷ�");
			panel3.add(radio2);
			
			
			textField1 = new JTextField();
			textField1.setBorder(new TitledBorder(null,"����",TitledBorder.LEADING,TitledBorder.TOP,null,null));
			textField1.setBounds(55, 350, 418, 45);
			
			contentPane.add(textField1);
			textField1.setColumns(10);
			
			
			textField2 = new JTextField();
			textField2.setBorder(new TitledBorder(null,"��ǰ������",TitledBorder.LEADING,TitledBorder.TOP,null,null));
			textField2.setBounds(55, 610, 600, 140);
			
			contentPane.add(textField2);
			textField2.setColumns(10);
			
		
		
	       
			    
		
			
			
	}
	
}
	
	
	
	
