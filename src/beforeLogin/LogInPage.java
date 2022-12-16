package secondHand_site.beforeLogin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import secondHand_site.userDB.UserDao;
import secondHand_site.afterLogIn.AfterLogInMain;
import secondHand_site.afterLogIn.MyStorePage;
import secondHand_site.afterLogIn.SellPage;
import secondHand_site.userDB.User;

public class LogInPage extends JFrame implements ActionListener {
	static LogInPage logInPage;
	//로그인한 사람
	public static User logInUser = new User();
	
	// 데이터연동
	public static UserDao userDao = new UserDao();

	// UI
	Container body;
	// 상단 타이틀
	JLabel title = new JLabel("           로그인 페이지");

	// 중앙 로그인 패널
	JPanel logPanel = new JPanel();
	JPanel idPanel = new JPanel();
	JLabel idLb = new JLabel("아이디 :");
	JTextField idTxt = new JTextField(10); // 입력란
	JPanel pwdPanel = new JPanel();
	JLabel pwdLb = new JLabel("비밀번호 :");
	JPasswordField pwdTxt = new JPasswordField(10);// 입력란

	// 하단 버튼 패널
	JPanel btnPanel = new JPanel();
	JButton logInBtn = new JButton("로그인");
	JButton signUpBtn = new JButton("회원가입");

	public LogInPage() {
		this.setTitle("메인페이지");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		body = getContentPane();
		body.setLayout(new GridLayout(3, 1));
		title.setFont(new Font("Courier", Font.PLAIN, 30));
		body.add(title, BorderLayout.NORTH);
		this.setLogPanel();
		body.add(logPanel);
		this.setButtonPanel();
		body.add(btnPanel);
		this.setVisible(true);
		// 초기 화면단에 보일 것은 setVisible위에

		// 회원가입 창띄우기
		signUpBtn.addActionListener(this);

		// 로그인 버튼 누를시.
		logInBtn.addActionListener(this);

	}

	void setButtonPanel() {
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		btnPanel.add(logInBtn);
		btnPanel.add(signUpBtn);
	}

	void setLogPanel() {
		logPanel.setSize(300, 200);
		logPanel.setLayout(new GridLayout(2, 1, 20, 10));
		Font logFont = new Font("Courier", Font.PLAIN, 20);
		idLb.setFont(logFont);
		idTxt.setFont(logFont);
		pwdLb.setFont(logFont);
		pwdTxt.setFont(logFont);

		idPanel.add(idLb);
		idPanel.add(idTxt);
		pwdPanel.add(pwdLb);
		pwdPanel.add(pwdTxt);

		logPanel.add(idPanel);
		logPanel.add(pwdPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signUpBtn) { // 회원가입 버튼 누를시
			new SignUpPage();
			setVisible(false);
		} else if (e.getSource() == logInBtn) { // 로그인 버튼 누를시
			String inputId = idTxt.getText();
			String inputPwd = new String(pwdTxt.getPassword());
			if (inputId.equals("") || inputPwd.equals("")) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				System.out.println("로그인 실패 > 로그인 정보 미입력");
			} else if (inputId != null && inputPwd != null) {
				if (userDao.logInCheck(inputId, inputPwd)) { // 로그인 성공시
					System.out.println("로그인 성공");
					JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
					
					logInUser = userDao.getLogInUserInfo(inputId); // ****** 로그인한 유저의 정보 저장.
					
					
					new AfterLogInMain(); // 로그인 성공 이후 화면 관련
					AfterLogInMain.frame.setVisible(true);
					new SellPage();
					SellPage.frame.setVisible(false);
					new MyStorePage();
					MyStorePage.frame.setVisible(false);
					BeforeLogInMain.frame.setVisible(false);
					setVisible(false);
				} else {
					System.out.println("로그인 실패 > 로그인 정보 불일치");
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}



}
