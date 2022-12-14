package userDB;

import java.awt.*;
import java.awt.event.*;
// 占쎈솭占쎄섯 占쎌읈占쎌넎 筌〓㈇��: https://blog.naver.com/10hsb04/221612791503
import javax.swing.*;

public class AfterLoginPage extends JFrame implements ActionListener {
  UserDB userDB = new UserDB();
  // 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑤벏釉� 筌롢끇苡�占쎌벥 占쎈툡占쎌뵠占쎈탵�몴占� 占쎈섯占쎈뮉 獄쎻뫖苡�
  LogInUser logInUser = LogInUser.getInstance();
  // (1)LogInUser logInUser = LogInUser.getInstance();
  // (2)logInUser.getId();
  // 占쎌깏占쏙옙 (1) LogInUser.getInstance().getId();
  // 嚥≪뮄�젃占쎌뵥占쎈읂占쎌뵠筌욑옙占쎈퓠占쎄퐣 占쎈뼄占쎈솭占쎈뻻, 嚥≪뮄�젃占쎈툡占쎌뜍占쎈뻻 logInUser占쎌벥 占쎈툡占쎌뵠占쎈탵揶쏉옙(null)

  JButton logOutBtn = new JButton("嚥≪뮄�젃占쎈툡占쎌뜍");
  JButton resignUserBtn = new JButton("占쎌돳占쎌뜚占쎄퉱占쎈닚");
  JButton showUserInfoBtn = new JButton("揶쏆뮇�뵥占쎌젟癰귣똻�쒙옙�돳");
  JButton editUserInfoBtn = new JButton("揶쏆뮇�뵥占쎌젟癰귣똻�땾占쎌젟");

  JPanel northPanel = new JPanel(); // 占쎄맒占쎈뼊 占쎈솭占쎄섯
  JPanel southPanel = new JPanel(); // 占쎈릭占쎈뼊 占쎈솭占쎄섯

  // 揶쏆뮇�뵥占쎌젟癰귣똻�땾占쎌젟 占쎈�볩옙�뮞占쎈뱜占쎈툡占쎈굡 //占쎈툡占쎌뵠占쎈탵占쎈뮉 癰귨옙野껓옙 筌륁궢釉�野껓옙
  JPasswordField updatePwd = new JPasswordField(logInUser.getPwd(), 20);
  JTextField updateName = new JTextField(logInUser.getName(), 10);
  JTextField updateAddress = new JTextField(logInUser.getAddress(), 35);
  JTextField updatePhone = new JTextField(String.valueOf(logInUser.getPhone()), 15);
  JLabel limit = new JLabel("-占쎌뱽 �겫�늿�뵠筌욑옙筌띾뜆苑�占쎌뒄.");
  JTextField updateNick = new JTextField(logInUser.getNick(), 10);

  AfterLoginPage() {

    setLocation(500, 300);
    setSize(500, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cont = this.getContentPane();
    JPanel viewPanel = new JPanel();
    cont.add(viewPanel);

    viewPanel.setLayout(new BorderLayout());
    viewPanel.add(northPanel, BorderLayout.NORTH);
    southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS)); // 占쎈릭占쎈뼊(�⑥쥙�젟) 占쎈솭占쎄섯占쎌벥
                                                                       // 占쎌쟿占쎌뵠占쎈툡占쎌뜍
                                                                       // 占쎄퐬占쎌젟

    northPanel.add(logOutBtn);
    northPanel.add(resignUserBtn);
    northPanel.add(showUserInfoBtn);
    northPanel.add(editUserInfoBtn);

    logOutBtn.addActionListener(this);
    resignUserBtn.addActionListener(this);
    showUserInfoBtn.addActionListener(this);
    editUserInfoBtn.addActionListener(this);

    firstSouth(); // �룯�뜃由곤옙�넅筌롳옙
    viewPanel.add(southPanel);
    this.setVisible(true);

  }

  void firstSouth() { // �룯�뜃由� 獄쏉옙 筌ｃ꺂苡뀐쭪占� 占쎈솭占쎄섯占쎌벥 占쎌넅筌롳옙
    southPanel.add(new JLabel("�룯�뜃由곤옙�넅筌롳옙 占쎈솭占쎄섯"));
  }

  void resignSouth() { // (1)占쎌돳占쎌뜚占쎄퉱占쎈닚 占쎈솭占쎄섯
    southPanel.add(new JLabel("占쎌돳占쎌뜚占쎄퉱占쎈닚 占쎈솭占쎄섯"));
    JPanel idPanel = new JPanel();
    JLabel idLb = new JLabel("占쎈툡占쎌뵠占쎈탵 : ");
    JTextField idTxt = new JTextField(10); // 占쎌뿯占쎌젾占쏙옙
    JPanel pwdPanel = new JPanel();
    JLabel pwdLb = new JLabel("�뜮袁⑨옙甕곕뜇�깈 : ");
    JPasswordField pwdTxt = new JPasswordField(10);// 占쎌뿯占쎌젾占쏙옙
    JButton confirmResignBtn = new JButton("占쎌돳占쎌뜚占쎄퉱占쎈닚 筌욊쑵六�");
    idPanel.add(idLb);
    idPanel.add(idTxt);
    pwdPanel.add(pwdLb);
    pwdPanel.add(pwdTxt);
    southPanel.add(idPanel);
    southPanel.add(pwdPanel);
    southPanel.add(confirmResignBtn);

    LogInUser user = userDB.getLogInUserInfo(logInUser.getId());
    confirmResignBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String inputId = idTxt.getText();
        String inputPwd = new String(pwdTxt.getPassword());
        if (user.getId().equals(inputId) && user.getPwd().equals(inputPwd)) {
          int confirm = JOptionPane.showConfirmDialog(null, "占쎌젟筌띾Ŧ以� 占쎄퉱占쎈닚占쎈릭占쎈뻻野껋쥙�뮸占쎈빍繹먲옙?",
              "占쎌돳占쎌뜚占쎄퉱占쎈닚 占쎌넇占쎌뵥", JOptionPane.YES_NO_OPTION);
          if (confirm == 0) {
            userDB.delete(inputId);
            JOptionPane.showMessageDialog(null, "占쎌돳占쎌뜚占쎄퉱占쎈닚 占쎄쉐�⑨옙!");
            setVisible(false); // 占쎌겱占쎌삺 筌∽옙 占쎈툧癰귣똻�뵠野껓옙 占쎈릭疫뀐옙
          }
        } else {
          JOptionPane.showMessageDialog(null, "占쎌돳占쎌뜚占쎄퉱占쎈닚 占쎈뼄占쎈솭!", "占쎌궎�몴占�",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

  void showUserInfoSouth() { // (2)揶쏆뮇�뵥占쎌젟癰귣똻�쒙옙�돳 占쎈솭占쎄섯
    southPanel.add(new JLabel(logInUser.getName() + "占쎈뻷(" + logInUser.getNick() + ")占쎌벥 占쎈솭占쎄섯"));
    String infoStr = String.format(
        "占쎈툡占쎌뵠占쎈탵 : %s \n 占쎌뵠�뵳占� : %s \n 雅뚯눘�꺖 : %s \n 占쎈빏占쎄퐬占쎌뿫 : %s \n 占쎌읈占쎌넅甕곕뜇�깈 : %d \n",
        logInUser.getId(), logInUser.getName(), logInUser.getAddress(), logInUser.getNick(),
        logInUser.getPhone());

    JTextArea infoArea = new JTextArea(infoStr);
    infoArea.setFont(new Font("Courier", Font.PLAIN, 20));
    southPanel.add(infoArea);
  }

  void editSouth() { // (3)揶쏆뮇�뵥占쎌젟癰귣똻�땾占쎌젟 占쎈솭占쎄섯
    // UI
    southPanel.add(new JLabel(
        logInUser.getName() + "(" + logInUser.getNick() + ")占쎈뻷占쎌벥 揶쏆뮇�뵥占쎌젟癰귣똻�땾占쎌젟 占쎈솭占쎄섯"));

    // 占쎌뵬甕곤옙
    JLabel[] labelList = new JLabel[5];
    String strList[] =
        {"�뜮袁⑨옙甕곕뜇�깈 : ", "占쎌뵠    �뵳占� : ", "雅뚳옙    占쎈꺖 : ", "占쎈염 占쎌뵭 筌ｏ옙 : ", "占쎈빏 占쎄퐬 占쎌뿫 : "};
    for (int i = 0; i < labelList.length; i++) {
      labelList[i] = new JLabel(strList[i]);
    }

    // 占쎌뵬甕곤옙 + 占쎈�볩옙�뮞占쎈뱜占쎈툡占쎈굡 = formPanelList
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

    // formPanelList 8揶쏉옙 占쎌젟占쎌졊
    JPanel allFormPanel = new JPanel();
    allFormPanel.setLayout(new GridLayout(8, 1, 0, 30)); // 8占쎈뻬,1占쎈였
    for (int i = 0; i < formPanelList.length; i++) {
      allFormPanel.add(formPanelList[i]);
    }

    southPanel.add(allFormPanel);
    JButton editBtn = new JButton("揶쏆뮇�뵥占쎌젟癰귨옙 占쎈땾占쎌젟");
    southPanel.add(editBtn);


    editBtn.addActionListener(new ActionListener() {
      String updatePwd2 = new String(updatePwd.getPassword());

      @Override
      public void actionPerformed(ActionEvent e) {
        if (updatePwd2.trim().equals("") || updateAddress.getText().trim().equals("")
            || updateNick.getText().trim().equals("") || updatePhone.getText().trim().equals("")) {
          JOptionPane.showMessageDialog(null, "占쎌젟癰귣�占쏙옙 筌뤴뫀紐� 占쎌뿯占쎌젾占쎈퉸雅뚯눘苑�占쎌뒄", "占쎌궎�몴占�", 2);
        } else {
          int myPhone = 0;
          try {
            myPhone = Integer.valueOf(updatePhone.getText());
          } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, "占쎌읈占쎌넅甕곕뜇�깈�몴占� 占쎈떭占쎌쁽嚥∽옙 占쎌뿯占쎌젾占쎈퉸雅뚯눘苑�占쎌뒄.",
                "占쎌궎�몴占�", JOptionPane.ERROR_MESSAGE);
          }
          if (myPhone != 0) {
            userDB.userUpdate(updatePwd2, updateName.getText(), updateAddress.getText(),
                updateNick.getText(), myPhone, logInUser.getId());
            JOptionPane.showMessageDialog(null, "占쎌돳占쎌뜚占쎌젟癰귣떯占� 占쎈땾占쎌젟占쎈┷占쎈�占쎈뮸占쎈빍占쎈뼄.");
          }
        }
      }
    });

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String btnVal = e.getActionCommand(); // 甕곌쑵�뱣揶쏉옙 獄쏆룄由�
    southPanel.removeAll(); // 占쎈릭占쎈뼊 占쎈솭占쎄섯 筌욑옙占쎌뒭疫뀐옙
    if (btnVal.equals("嚥≪뮄�젃占쎈툡占쎌뜍")) {
      logInUser.setId(null); // 嚥≪뮄�젃占쎈툡占쎌뜍占쎈뻻 logInUser 占쎌젟癰귣�諭� �룯�뜃由곤옙�넅(null)
      logInUser.setPwd(null);
      logInUser.setAddress(null);
      logInUser.setNick(null);
      logInUser.setPhone(0);

      dispose();
      LogInPage.logInPage.setVisible(true);
    } else if (btnVal.equals("占쎌돳占쎌뜚占쎄퉱占쎈닚")) {
      resignSouth();
    } else if (btnVal.equals("揶쏆뮇�뵥占쎌젟癰귣똻�쒙옙�돳")) {
      showUserInfoSouth();
    } else if (btnVal.equals("揶쏆뮇�뵥占쎌젟癰귣똻�땾占쎌젟")) {
      editSouth();
    }
    southPanel.updateUI(); // 占쎈솭占쎄섯 占쎌넅筌롳옙 占쎈씜占쎈쑓占쎌뵠占쎈뱜

  }

  public static void main(String[] args) {

  }

}
