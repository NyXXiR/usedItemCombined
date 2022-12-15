package secondHandSite.user2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import secondHandSite.user.LogInPage;

public class SignUpPage extends JFrame implements ActionListener {
	// UserDB연동
	UserDao userDao = new UserDao();
	LogInPage logInPage = new LogInPage();
	// 회원가입 정보입력
	JLabel[] labelList = new JLabel[7];
	String strList[] = { "아이디 : ", "비밀번호 : ", "비밀번호 재확인: ", "이    름 : ", "주    소 : ", "연 락 처 : ", "닉 네 임 : " };

	JTextField inputId = new JTextField(10);
	JButton idCheckBtn = new JButton("ID 중복 체크");
	JPasswordField inputPwd = new JPasswordField(20);
	JPasswordField inputPwdRe = new JPasswordField(20);
	JTextField inputName = new JTextField(10);
	JTextField inputAddress = new JTextField(35);
	JTextField inputPhone = new JTextField(15);
	JLabel limit = new JLabel("-을 붙이지마세요.");
	JTextField inputNick = new JTextField(10);

	JPanel[] formPanelList = new JPanel[7];
	JPanel allFormPanel = new JPanel();

	// 버튼
	JPanel btnPanel = new JPanel();
	JButton joinBtn = new JButton("회원가입");
	JButton cancelBtn = new JButton("취소");

	public SignUpPage() throws ClassNotFoundException, SQLException {
		this.setTitle("회원가입 화면");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// 윈도우 화면 가운데에 놓기
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기

		// 컴포넌트들
		// (1)타이틀 (상단)
		JLabel title = new JLabel("회원가입", JLabel.CENTER);
		title.setForeground(new Color(5, 0, 153));
		title.setFont(new Font("Courier", Font.BOLD, 50));

		// (2)정보입력 패널(중앙)
		Font Fieldfont = new Font("arian", Font.BOLD, 20);
		inputId.setFont(Fieldfont);
		inputPwd.setFont(Fieldfont);
		inputPwdRe.setFont(Fieldfont);
		inputName.setFont(Fieldfont);
		inputAddress.setFont(Fieldfont);
		inputPhone.setFont(Fieldfont);
		inputNick.setFont(Fieldfont);

		Font formFont = new Font("Courier", Font.PLAIN, 30);
		for (int i = 0; i < strList.length; i++) {
			labelList[i] = new JLabel(strList[i]);
			labelList[i].setFont(formFont);
			formPanelList[i] = new JPanel();
			formPanelList[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			formPanelList[i].add(labelList[i]);
		}

		Font limitFont = new Font("Courier", Font.PLAIN, 20);
		formPanelList[0].add(inputId);
		formPanelList[0].add(idCheckBtn);
		formPanelList[1].add(inputPwd);
		formPanelList[2].add(inputPwdRe);
		formPanelList[3].add(inputName);
		formPanelList[4].add(inputAddress);
		formPanelList[5].add(inputPhone);
		limit.setFont(limitFont);
		formPanelList[5].add(limit);
		formPanelList[6].add(inputNick);

		allFormPanel.setLayout(new GridLayout(8, 1, 0, 30)); // 8행,1열
		for (int i = 0; i < formPanelList.length; i++) {
			allFormPanel.add(formPanelList[i]);
		}

		// (3)버튼 패널(하단)
		Font buttonFont = new Font("Courier", Font.PLAIN, 30);
		joinBtn.setFont(buttonFont);
		cancelBtn.setFont(buttonFont);

		btnPanel.add(joinBtn);
		btnPanel.add(cancelBtn);

		// (1),(2),(3)배치
		this.add(title, BorderLayout.NORTH);
		this.add(allFormPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		joinBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		idCheckBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		userDao.connect();
		
		String newId = inputId.getText(); // inputId는 id텍스트필드
										  // inputId.getText()는 텍스트필드에 적힌 문자.
		String newPwd = new String(inputPwd.getPassword());
		String newPwdRe = new String(inputPwdRe.getPassword());
		String newName = inputName.getText();
		String newAddress = inputAddress.getText();
		String newNick = inputNick.getText();
		int newPhone = 0;

		if (e.getSource() == joinBtn) { // 가입버튼 눌렀을 때
			if (newId.trim().equals("") || newPwd.trim().equals("") || newPwdRe.trim().equals("")
					|| newAddress.trim().equals("") || newNick.trim().equals("")
					|| inputPhone.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "오류", 2);
			} else {
				try {
					newPhone = Integer.valueOf(inputPhone.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "전화번호를 숫자로 입력해주세요", "오류", JOptionPane.ERROR_MESSAGE);
				}
				if (!userDao.getIdByCheck(newId)) { // 중복일 경우
					JOptionPane.showMessageDialog(null, "id 중복체크를 해주세요", "아이디 오류", JOptionPane.ERROR_MESSAGE);
				} else if (!newPwd.equals(newPwdRe)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 서로 맞지 않습니다", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
				} else {
					if (newPhone != 0) {
						UserDto newUser = new UserDto(newId, newPwd, newName, newAddress, newNick, newPhone);
						// ArrayList에도 넣기.
						userDao.insertUserDB(newUser);
						JOptionPane.showMessageDialog(null, " " + newName + " 님, 회원가입에 성공하셨습니다 ");
						dispose();
						logInPage.setVisible(true);
					}
				}
			}
		} else if (e.getSource() == idCheckBtn) {// id 중복체크 눌렀을 떄
			if (newId.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
				inputId.requestFocus();// id text박스로 포커스이동
			} else {
				if (userDao.getIdByCheck(newId)) { // 중복아니다.
					JOptionPane.showMessageDialog(null, newId + "는 사용가능합니다.");
				} else { // 중복이다.
					JOptionPane.showMessageDialog(null, newId + "는 중복된 id입니다.", "중복 아이디 오류", 1);
					inputId.setText("");// id text박스 지우기
					inputId.requestFocus();// id text박스에 커서놓기

				}
			}
		} else if (e.getSource() == cancelBtn) {// 취소버튼 눌렀을 때
			new LogInPage();
			dispose(); // 현재 창 끄는 메소드
		}

	}
}
//[UI참조]  https://october-east-sea.tistory.com/73
