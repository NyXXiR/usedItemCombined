package secondHand_site.afterLogIn;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import secondHand_site.beforeLogin.BeforeLogInMain;
import secondHand_site.beforeLogin.LogInPage;
import secondHand_site.userDB.UserDao;
import secondHand_site.userDB.User;

public class UserService {

	// 개인정보조회
//	String showUserInfo(User logInUser) { 
//		String infoStr = String.format("아이디 : %s \n이름 : %s \n주소 : %s \n닉네임 : %s \n 전화번호 : %d \n", logInUser.getId(),
//		logInUser.getName(), logInUser.getAddress(), logInUser.getNick(), logInUser.getPhone());
//
//		return infoStr;
//	}
	
//	String showUserInfo(User logInUser) { // 개인정보조회
//	String infoStr = String.format("아이디 : %s \n이름 : %s \n주소 : %s \n닉네임 : %s \n 전화번호 : %d \n", logInUser.getId(),
//	logInUser.getName(), logInUser.getAddress(), logInUser.getNick(), logInUser.getPhone());
//
//	return infoStr;
//}
	//탈퇴
	void resignUser(User logInUser, String inputPwd, String inputPwdRe) { 
		if ( inputPwd.equals(inputPwdRe) && logInUser.getPwd().equals(inputPwd)) {
			int confirm = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?", "회원탈퇴 확인", JOptionPane.YES_NO_OPTION);
			if (confirm == 0) {
				LogInPage.userDao.deleteUserDB(logInUser.getId());
				JOptionPane.showMessageDialog(null, "회원탈퇴 성공!");
				BeforeLogInMain.frame.setVisible(true);
				AfterLogInMain.frame.dispose();
				SellPage.frame.dispose();
				MyStorePage.frame.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(null, "회원탈퇴 실패!", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//개인정보수정
	void editUser(User logInUser, String updatePwd, String updateName, String updateAddress, String updateNick, String updatePhone) {
		if (updatePwd.equals("") || updateName.equals("")  ||updateAddress.equals("") || updateNick.equals("") || updatePhone.equals("")) {
			JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "오류", 2);
		} else {
			int myPhone = 0;
			try {
				myPhone = Integer.valueOf(updatePhone);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "전화번호를 숫자로 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}
			if (myPhone != 0) {
				LogInPage.userDao.updateUserDB(logInUser);
				JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
			}
		}
	}
	
	
	
}
