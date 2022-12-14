package userDB;


import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class SignUpPage extends JFrame implements ActionListener {
  // UserDB占쎈염占쎈짗
  UserDB userDB = new UserDB();

  // 占쎌돳占쎌뜚揶쏉옙占쎌뿯 占쎌젟癰귣똻�뿯占쎌젾
  JLabel[] labelList = new JLabel[7];
  String strList[] = {"占쎈툡占쎌뵠占쎈탵 : ", "�뜮袁⑨옙甕곕뜇�깈 : ", "�뜮袁⑨옙甕곕뜇�깈 占쎌삺占쎌넇占쎌뵥: ", "占쎌뵠    �뵳占� : ",
      "雅뚳옙    占쎈꺖 : ", "占쎈염 占쎌뵭 筌ｏ옙 : ", "占쎈빏 占쎄퐬 占쎌뿫 : "};

  JTextField inputId = new JTextField(10);
  JButton idCheckBtn = new JButton("ID 餓λ쵎�궗 筌ｋ똾寃�");
  JPasswordField inputPwd = new JPasswordField(20);
  JPasswordField inputPwdRe = new JPasswordField(20);
  JTextField inputName = new JTextField(10);
  JTextField inputAddress = new JTextField(35);
  JTextField inputPhone = new JTextField(15);
  JLabel limit = new JLabel("-占쎌뱽 �겫�늿�뵠筌욑옙筌띾뜆苑�占쎌뒄.");
  JTextField inputNick = new JTextField(10);

  JPanel[] formPanelList = new JPanel[7];
  JPanel allFormPanel = new JPanel();

  // 甕곌쑵�뱣
  JPanel btnPanel = new JPanel();
  JButton joinBtn = new JButton("占쎌돳占쎌뜚揶쏉옙占쎌뿯");
  JButton cancelBtn = new JButton("�뿆�뫁�꺖");

  public SignUpPage() throws ClassNotFoundException, SQLException {
    this.setTitle("占쎌돳占쎌뜚揶쏉옙占쎌뿯 占쎌넅筌롳옙");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // 占쎌맊占쎈즲占쎌뒭 占쎌넅筌롳옙 揶쏉옙占쎌뒲占쎈쑓占쎈퓠 占쎈꼦疫뀐옙
    Dimension frameSize = getSize();
    Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation((windowSize.width - frameSize.width) / 2,
        (windowSize.height - frameSize.height) / 2); // 占쎌넅筌롳옙 餓λ쵐釉곤옙肉� 占쎌뱽占쎌뒭疫뀐옙

    // �뚮똾猷뤄옙瑗놂옙�뱜占쎈굶
    // (1)占쏙옙占쎌뵠占쏙옙 (占쎄맒占쎈뼊)
    JLabel title = new JLabel("占쎌돳占쎌뜚揶쏉옙占쎌뿯", JLabel.CENTER);
    title.setForeground(new Color(5, 0, 153));
    title.setFont(new Font("Courier", Font.BOLD, 50));

    // (2)占쎌젟癰귣똻�뿯占쎌젾 占쎈솭占쎄섯(餓λ쵐釉�)
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

    allFormPanel.setLayout(new GridLayout(8, 1, 0, 30)); // 8占쎈뻬,1占쎈였
    for (int i = 0; i < formPanelList.length; i++) {
      allFormPanel.add(formPanelList[i]);
    }

    // (3)甕곌쑵�뱣 占쎈솭占쎄섯(占쎈릭占쎈뼊)
    Font buttonFont = new Font("Courier", Font.PLAIN, 30);
    joinBtn.setFont(buttonFont);
    cancelBtn.setFont(buttonFont);

    btnPanel.add(joinBtn);
    btnPanel.add(cancelBtn);

    // (1),(2),(3)獄쏄퀣�뒄
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
    String myId = inputId.getText(); // inputId占쎈뮉 id占쎈�볩옙�뮞占쎈뱜占쎈툡占쎈굡
                                     // inputId.getText()占쎈뮉 占쎈�볩옙�뮞占쎈뱜占쎈툡占쎈굡占쎈퓠 占쎌읅占쎌뿺 �눧紐꾩쁽.
    if (e.getSource() == joinBtn) { // 揶쏉옙占쎌뿯甕곌쑵�뱣 占쎈땭占쏙옙占쎌뱽 占쎈르

      String myPwd = new String(inputPwd.getPassword());
      String myName = inputName.getText();
      String myAddress = inputAddress.getText();
      String myNick = inputNick.getText();
      int myPhone = 0;

      String myPwdRe = new String(inputPwdRe.getPassword());
      if (myId.equals("") || myPwd.equals("") || myAddress.equals("") || myNick.equals("")
          || inputPhone.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "占쎌젟癰귣�占쏙옙 筌뤴뫀紐� 占쎌뿯占쎌젾占쎈퉸雅뚯눘苑�占쎌뒄", "占쎌궎�몴占�",
            JOptionPane.ERROR_MESSAGE);
      } else {
        try {
          myPhone = Integer.valueOf(inputPhone.getText());
        } catch (NumberFormatException e1) {
          JOptionPane.showMessageDialog(null, "占쎌읈占쎌넅甕곕뜇�깈�몴占� 占쎈떭占쎌쁽嚥∽옙 占쎌뿯占쎌젾占쎈퉸雅뚯눘苑�占쎌뒄",
              "占쎌궎�몴占�", JOptionPane.ERROR_MESSAGE);
        }
        if (!userDB.getIdByCheck(myId)) { // 餓λ쵎�궗占쎌뵬 野껋럩�뒭
          JOptionPane.showMessageDialog(null, "id 餓λ쵎�궗筌ｋ똾寃뺟몴占� 占쎈퉸雅뚯눘苑�占쎌뒄", "占쎈툡占쎌뵠占쎈탵 占쎌궎�몴占�",
              JOptionPane.ERROR_MESSAGE);
        } else if (!myPwd.equals(myPwdRe)) {
          JOptionPane.showMessageDialog(null, "�뜮袁⑨옙甕곕뜇�깈揶쏉옙 占쎄퐣嚥∽옙 筌띿쉸占� 占쎈륫占쎈뮸占쎈빍占쎈뼄",
              "�뜮袁⑨옙甕곕뜇�깈 占쎌궎�몴占�", JOptionPane.ERROR_MESSAGE);
        } else {
          if (myPhone != 0) {
            userDB.insert(myId, myPwd, myName, myAddress, myNick, myPhone);
            JOptionPane.showMessageDialog(null,
                " " + myName + " 占쎈뻷, 占쎌돳占쎌뜚揶쏉옙占쎌뿯占쎈퓠 占쎄쉐�⑤벏釉�占쎈�뀐옙�뮸占쎈빍占쎈뼄 ");
            LogInPage.logInPage.setVisible(true);
            dispose();
          }
        }
      }
    } else if (e.getSource() == cancelBtn) {// �뿆�뫁�꺖甕곌쑵�뱣 占쎈땭占쏙옙占쎌뱽 占쎈르
      LogInPage.logInPage.setVisible(true);
      dispose(); // 占쎌겱占쎌삺 筌∽옙 占쎄콢占쎈뮉 筌롫뗄�꺖占쎈굡
    } else if (e.getSource() == idCheckBtn) {// id 餓λ쵎�궗筌ｋ똾寃� 占쎈땭占쏙옙占쎌뱽 占쎈뻘
      // id占쎈�볩옙�뮞占쎈뱜獄쏅벡�뮞占쎈퓠 揶쏉옙 占쎈씨占쎌몵筌롳옙 筌롫뗄苑�筌욑옙 �빊�뮆�젾, 占쎌뿳占쎌몵筌롳옙 DB占쎈염占쎈짗占쎈립占쎈뼄.
      if (myId.trim().equals("")) {
        JOptionPane.showMessageDialog(null, "ID�몴占� 占쎌뿯占쎌젾占쎈퉸雅뚯눘苑�占쎌뒄.");
        inputId.requestFocus();// id text獄쏅벡�뮞嚥∽옙 占쎈７�뚣끉�뮞占쎌뵠占쎈짗
      } else {
        if (userDB.getIdByCheck(myId)) { // 餓λ쵎�궗占쎈툡占쎈빍占쎈뼄.(占쎄텢占쎌뒠揶쏉옙占쎈뮟)
          JOptionPane.showMessageDialog(null, myId + "占쎈뮉 占쎄텢占쎌뒠揶쏉옙占쎈뮟占쎈�占쎈빍占쎈뼄.");
        } else { // 餓λ쵎�궗占쎌뵠占쎈뼄.
          JOptionPane.showMessageDialog(null, myId + "占쎈뮉 餓λ쵎�궗占쎈쭆 id占쎌뿯占쎈빍占쎈뼄.",
              "餓λ쵎�궗 占쎈툡占쎌뵠占쎈탵 占쎌궎�몴占�", 1);
          inputId.setText("");// id text獄쏅벡�뮞 筌욑옙占쎌뒭疫뀐옙
          inputId.requestFocus();// id text獄쏅벡�뮞占쎈퓠 �뚣끉苑뚳옙�꼦疫뀐옙

        }
      }

    }
  }
}
// [UI筌〓챷��] https://october-east-sea.tistory.com/73
