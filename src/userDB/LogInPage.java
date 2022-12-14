package userDB;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class LogInPage extends JFrame implements ActionListener {
  public static LogInPage logInPage; // J占쎈늄占쎌쟿占쎌뿫 setVisible �꽴占쏙옙�졃

  // 占쎈쑓占쎌뵠占쎄숲占쎈염占쎈짗
  UserDB userDB = new UserDB();

  // 嚥≪뮄�젃占쎌뵥占쎈립 占쎌�占쏙옙(占쎈뼓疫뀐옙占쎈꽑) 占쎈섯疫뀐옙
  LogInUser logInUser = LogInUser.getInstance();

  // UI
  Container body;
  // 占쎄맒占쎈뼊 占쏙옙占쎌뵠占쏙옙
  JLabel title = new JLabel("          Log In Page");

  // 餓λ쵐釉� 嚥≪뮄�젃占쎌뵥 占쎈솭占쎄섯
  JPanel logPanel = new JPanel();
  JPanel idPanel = new JPanel();
  JLabel idLb = new JLabel("占쎈툡占쎌뵠占쎈탵 :");
  JTextField idTxt = new JTextField(10); // 占쎌뿯占쎌젾占쏙옙
  JPanel pwdPanel = new JPanel();
  JLabel pwdLb = new JLabel("�뜮袁⑨옙甕곕뜇�깈 :");
  JPasswordField pwdTxt = new JPasswordField(10);// 占쎌뿯占쎌젾占쏙옙

  // 占쎈릭占쎈뼊 甕곌쑵�뱣 占쎈솭占쎄섯
  JPanel btnPanel = new JPanel();
  JButton logInBtn = new JButton("嚥≪뮄�젃占쎌뵥");
  JButton signUpBtn = new JButton("占쎌돳占쎌뜚揶쏉옙占쎌뿯");

  public LogInPage() {
    this.setTitle("筌롫뗄�뵥占쎈읂占쎌뵠筌욑옙");
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
    // �룯�뜃由� 占쎌넅筌롫��뼊占쎈퓠 癰귣똻�뵬 野껉퍔占� setVisible占쎌맄占쎈퓠

    // 占쎌돳占쎌뜚揶쏉옙占쎌뿯 筌≪럥�뱽占쎌뒭疫뀐옙
    signUpBtn.addActionListener(this);

    // 嚥≪뮄�젃占쎌뵥 甕곌쑵�뱣 占쎈듇�몴�눘�뻻.
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

  public static void main(String[] args) {
    logInPage = new LogInPage();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == signUpBtn) { // 占쎌돳占쎌뜚揶쏉옙占쎌뿯 甕곌쑵�뱣 占쎈듇�몴�눘�뻻
      try {
        new SignUpPage(); // 占쎌돳占쎌뜚揶쏉옙占쎌뿯 占쎈읂占쎌뵠筌욑옙
      } catch (ClassNotFoundException | SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      setVisible(false); // 筌∽옙 占쎈툧癰귣똻�뵠野껓옙 占쎈릭疫뀐옙
    } else if (e.getSource() == logInBtn) { // 嚥≪뮄�젃占쎌뵥 甕곌쑵�뱣 占쎈듇�몴�눘�뻻
      String inputId = idTxt.getText();
      String inputPwd = new String(pwdTxt.getPassword());
      System.out.println(logInUser.getId());
      System.out.println(logInUser.getNick());

      if (inputId.equals("") || inputPwd.equals("")) {
        JOptionPane.showMessageDialog(null, "占쎈툡占쎌뵠占쎈탵占쏙옙 �뜮袁⑨옙甕곕뜇�깈 筌뤴뫀紐� 占쎌뿯占쎌젾占쎈퉸雅뚯눘苑�占쎌뒄",
            "嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭", JOptionPane.ERROR_MESSAGE);
        System.out.println("嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭 > 嚥≪뮄�젃占쎌뵥 占쎌젟癰귨옙 沃섎챷�뿯占쎌젾");
      }

      else if (inputId != null && inputPwd != null) {
        if (userDB.loginCheck(inputId, inputPwd)) { // 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑤벊�뻻
          System.out.println("嚥≪뮄�젃占쎌뵥 占쎄쉐�⑨옙");
          JOptionPane.showMessageDialog(null, "嚥≪뮄�젃占쎌뵥占쎈퓠 占쎄쉐�⑤벏釉�占쏙옙占쎈뮸占쎈빍占쎈뼄");
          // 嚥≪뮄�젃占쎌뵥占쎈립 占쎌�占쏙옙占쎌벥 占쎌젟癰귨옙 占쏙옙占쎌삢.
          userDB.getLogInUserInfo(inputId);
          // 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑨옙 占쎌뵠占쎌뜎 占쎌넅筌롳옙 占쎌뱽占쎌뒭疫뀐옙
          new AfterLoginPage();
        } else {
          System.out.println("嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭 > 嚥≪뮄�젃占쎌뵥 占쎌젟癰귨옙 �겫�뜆�뵬燁삼옙");
          JOptionPane.showMessageDialog(null, "嚥≪뮄�젃占쎌뵥占쎈퓠 占쎈뼄占쎈솭占쎈릭占쏙옙占쎈뮸占쎈빍占쎈뼄",
              "嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  }



}
