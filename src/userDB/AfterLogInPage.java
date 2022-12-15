package secondHandSite.user2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
//패널 전환 참고: https://blog.naver.com/10hsb04/221612791503 
import javax.swing.JTextField;

public class AfterLogInPage extends JFrame implements ActionListener {
	UserDao userDao = new UserDao();

	JButton logOutBtn = new JButton("로그아웃");
	JButton resignMemberBtn = new JButton("회원탈퇴");
	JButton showMemberInfoBtn = new JButton("개인정보조회");
	JButton editMemberInfoBtn = new JButton("개인정보수정");

	JPanel northPanel = new JPanel(); // 상단 패널
	JPanel southPanel = new JPanel(); // 하단 패널

	// 개인정보수정 텍스트필드 //아이디는 변경 못하게
	JPasswordField updatePwd;
	JTextField updateName; 
	JTextField updateAddress; 
	JTextField updatePhone;
	JLabel limit = new JLabel("-을 붙이지마세요.");
	JTextField updateNick;

	AfterLogInPage() {
		userDao.connect();
		setLocation(500, 300);
		setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont = this.getContentPane();
		JPanel viewPanel = new JPanel();
		cont.add(viewPanel);

		viewPanel.setLayout(new BorderLayout());
		viewPanel.add(northPanel, BorderLayout.NORTH);
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS)); // 하단(고정) 패널의 레이아웃 설정

		northPanel.add(logOutBtn);
		northPanel.add(resignMemberBtn);
		northPanel.add(showMemberInfoBtn);
		northPanel.add(editMemberInfoBtn);

		logOutBtn.addActionListener(this);
		resignMemberBtn.addActionListener(this);
		showMemberInfoBtn.addActionListener(this);
		editMemberInfoBtn.addActionListener(this);

		firstSouth(); // 초기화면
		viewPanel.add(southPanel);
		this.setVisible(true);
	}

	void firstSouth() { // 초기 및 첫번째 패널의 화면
		southPanel.add(new JLabel("초기화면 패널"));
	}

	void resignSouth(UserDto logInUser) { // (1)회원탈퇴 패널
		System.out.println(logInUser);
		southPanel.add(new JLabel("회원탈퇴 패널"));
		JPanel idPanel = new JPanel();
		JLabel idLb = new JLabel("아이디 : ");
		JTextField idTxt = new JTextField(10); // 입력란
		JPanel pwdPanel = new JPanel();
		JLabel pwdLb = new JLabel("비밀번호 : ");
		JPasswordField pwdTxt = new JPasswordField(10);// 입력란
		JButton confirmResignBtn = new JButton("회원탈퇴 진행");
		idPanel.add(idLb);
		idPanel.add(idTxt);
		pwdPanel.add(pwdLb);
		pwdPanel.add(pwdTxt);
		southPanel.add(idPanel);
		southPanel.add(pwdPanel);
		southPanel.add(confirmResignBtn);

		confirmResignBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputId = idTxt.getText();
				String inputPwd = new String(pwdTxt.getPassword());
				if (logInUser.getId().equals(inputId) && logInUser.getPwd().equals(inputPwd)) {
					int confirm = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?", "회원탈퇴 확인",
							JOptionPane.YES_NO_OPTION);
					if (confirm == 0) {
						userDao.deleteUserDB(inputId);
						JOptionPane.showMessageDialog(null, "회원탈퇴 성공!");
						new LogInPage();
						dispose(); 
					}
				} else {
					JOptionPane.showMessageDialog(null, "회원탈퇴 실패!", "오류", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	void showUserInfoSouth(UserDto logInUser) { // (2)개인정보조회 패널
		southPanel.add(new JLabel(logInUser.getName() + "님(" + logInUser.getNick() + ")의 패널"));
		String infoStr = String.format("아이디 : %s \n 이름 : %s \n 주소 : %s \n 닉네임 : %s \n 전화번호 : %d \n", logInUser.getId(),
				logInUser.getName(), logInUser.getAddress(), logInUser.getNick(), logInUser.getPhone());

		JTextArea infoArea = new JTextArea(infoStr);
		infoArea.setFont(new Font("Courier", Font.PLAIN, 20));
		southPanel.add(infoArea);
	}

	void editSouth(UserDto logInUser) { // (3)개인정보수정 패널
		// UI
		southPanel.add(new JLabel(logInUser.getName() + "(" + logInUser.getNick() + ")님의 개인정보수정 패널"));
		
		// 라벨
		JLabel[] labelList = new JLabel[5];
		String strList[] = { "비밀번호 : ", "이    름 : ", "주    소 : ", "연 락 처 : ", "닉 네 임 : " };
		for (int i = 0; i < labelList.length; i++) {
			labelList[i] = new JLabel(strList[i]);
		}
		
		//텍스트필드
		updatePwd = new JPasswordField(logInUser.getPwd(), 20);
		updateName = new JTextField(logInUser.getName(), 10);
		updateAddress = new JTextField(logInUser.getAddress(), 35);
		updatePhone = new JTextField(String.valueOf(logInUser.getPhone()), 15);
		updateNick = new JTextField(logInUser.getNick(), 10);

		// 라벨 + 텍스트필드 = formPanelList
		JPanel[] formPanelList = new JPanel[5];
		Font formFont = new Font("Courier", Font.PLAIN, 30);
		for (int i = 0; i < strList.length; i++) {
			formPanelList[i] = new JPanel();
			formPanelList[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			formPanelList[i].add(labelList[i]);
			formPanelList[i].setFont(formFont);
		}
		formPanelList[0].add(updatePwd);
		formPanelList[1].add(updateName);
		formPanelList[2].add(updateAddress);
		formPanelList[3].add(updatePhone);
		formPanelList[3].add(limit);
		formPanelList[4].add(updateNick);

		// formPanelList 8개 정렬
		JPanel allFormPanel = new JPanel();
		allFormPanel.setLayout(new GridLayout(8, 1, 0, 30)); // 8행,1열
		for (int i = 0; i < formPanelList.length; i++) {
			allFormPanel.add(formPanelList[i]);
		}

		southPanel.add(allFormPanel);
		JButton editBtn = new JButton("개인정보 수정");
		southPanel.add(editBtn);
		
		
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (updatePwd.equals("") || updateAddress.equals("") || updateNick.equals("")|| updatePhone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "오류", 2);
				} else {
					int myPhone = 0;
					try {
						myPhone = Integer.valueOf(updatePhone.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "전화번호를 숫자로 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					}
					if (myPhone != 0) {
						userDao.updateUserDB(logInUser);
						JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
					}
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnVal = e.getActionCommand(); // 버튼값 받기
		southPanel.removeAll(); // 하단 패널 지우기
		if (btnVal.equals("로그아웃")) {
			UserDto logout = new UserDto(); 
			LogInPage.logInUser = logout; //로그인한 유저 끊기
			new LogInPage();
			dispose();
		} else if (btnVal.equals("회원탈퇴")) {
			resignSouth(LogInPage.logInUser);
		
		} else if (btnVal.equals("개인정보조회")) {
			showUserInfoSouth(LogInPage.logInUser);
		} else if (btnVal.equals("개인정보수정")) {
			editSouth(LogInPage.logInUser);
		}
		southPanel.updateUI(); // 패널 화면 업데이트

	}


}
