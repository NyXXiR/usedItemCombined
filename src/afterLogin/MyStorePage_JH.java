package afterLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import beforeLogin.BeforeLogInMain;
import beforeLogin.LogInPage;
import itemDB.ItemDB2_JH;
import itemDB.ItemList;
import itemDB.JTables_JH;
import itemDB.SoldItemDB;
import userDB.User;

public class MyStorePage_JH {
  public static JFrame frame;
  public JTextField textField;
  public String value;
  public JLabel label1; // 개인정보조회 및 수정
  public JLabel label2; // 판매중
  public JLabel label3; // 판매완료
  public JLabel label4; // 구매목록
  public JLabel label5; // 찜목록
  boolean run = true;
  public JPanel[] arr1 = new JPanel[5];
  public JButton[] arr2 = new JButton[5];
  public Object[][] arr3 = new Object[5][2];

  // 번개장터 로고 버튼
  ImageIcon icon =
      new ImageIcon("C:\\Users\\admin\\Desktop\\usedItemCombined\\src\\swing/Logo.jpg");
  Image img = icon.getImage();
  Image imgChange = img.getScaledInstance(180, 60, Image.SCALE_SMOOTH);
  ImageIcon updateIcon = new ImageIcon(imgChange);

  // 검색바 돋보기 버튼
  ImageIcon icon2 =
      new ImageIcon("C:\\Users\\admin\\Desktop\\usedItemCombined\\src\\swing/Icon.png");
  Image img2 = icon2.getImage();
  Image imgChange2 = img2.getScaledInstance(28, 23, Image.SCALE_SMOOTH);
  ImageIcon updateIcon2 = new ImageIcon(imgChange2);

  // 개인정보조회 및 수정 UI
  JPanel panel1 = new JPanel();
  UserService userService = new UserService(); // 개인정보조회 및 수정관련 기능

  // 판매중
  JPanel panel2 = new JPanel();
  ItemDB2_JH itemDB = new ItemDB2_JH();
  JTables_JH tables = new JTables_JH();
  ArrayList<ItemList> itemListSell = new ArrayList<ItemList>();

  // 판매완료
  JPanel panel3 = new JPanel();
  SoldItemDB soldItemDB = new SoldItemDB();
  ArrayList<ItemList> itemListSold = new ArrayList<ItemList>();

  // 구매
  JPanel panel4 = new JPanel();
  ArrayList<ItemList> itemListBuy = new ArrayList<ItemList>();
  
  // 찜목록
  JPanel panel5 = new JPanel();
  ArrayList<ItemList> itemListLike = new ArrayList<ItemList>();
  
  

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    MyStorePage_JH window = new MyStorePage_JH();
    window.frame.setVisible(true);
  }

  // 생성자
  public MyStorePage_JH() throws ClassNotFoundException, SQLException {
    run();
  }

  // ----------------------------------------------------기본 뼈대
  // 메소드--------------------------------------------------//
  public void run() throws SQLException, ClassNotFoundException {
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

    // 하단 패널 모음
    arr1[0] = panel1;
    panel1.setBounds(0, 239, 995, 402);
    frame.getContentPane().add(panel1);
    panel1.setVisible(true);

    JPanel panel2 = new JPanel();
    arr1[1] = panel2;
    panel2.setBounds(0, 239, 995, 402);
    frame.getContentPane().add(panel2);
    panel2.setVisible(false);

    JPanel panel3 = new JPanel();
    arr1[2] = panel3;
    panel3.setBounds(0, 239, 995, 402);
    frame.getContentPane().add(panel3);
    panel3.setVisible(false);

    JPanel panel4 = new JPanel();
    arr1[3] = panel4;
    panel4.setBounds(0, 239, 995, 402);
    frame.getContentPane().add(panel4);
    panel4.setVisible(false);

    JPanel panel5 = new JPanel();
    arr1[4] = panel5;
    panel5.setBounds(0, 239, 995, 402);
    frame.getContentPane().add(panel5);
    panel5.setVisible(false);

    // 하단 UI
    // (1)개인정보 조회 및 수정
    panel1.setLayout(new BorderLayout());
    editUI();

    // (2)판매중 아이템
    panel2.setLayout(new BorderLayout());
    label2 = new JLabel("판매중");
    panel2.add(label2, BorderLayout.NORTH);

    itemListSell = itemDB.whereData("id", LogInPage.logInUser.getId());
    JTable jtable = tables.toJTable(itemListSell);
    panel2.add(jtable, BorderLayout.CENTER);

    // (3)판매완료
    panel3.setLayout(new BorderLayout());
    label3 = new JLabel("판매완료");
    panel3.add(label3, BorderLayout.NORTH);
    itemListSold = soldItemDB.whereData("id", LogInPage.logInUser.getId());
    JTable jtable2 = tables.toJTable(itemListSold);
    JScrollPane spane2 = new JScrollPane(jtable2);
    panel3.add(jtable2, BorderLayout.CENTER);

    // (4)구매목록
    panel4.setLayout(new BorderLayout());
    label4 = new JLabel("구매 목록");
    panel4.add(label4, BorderLayout.NORTH);

    itemListBuy = soldItemDB.whereData("buyer_id", LogInPage.logInUser.getId());
    JTable jtable3 = tables.toJTable(itemListBuy);
    JScrollPane spane3 = new JScrollPane(jtable3);
    panel4.add(jtable3, BorderLayout.CENTER);

    // (5)찜목록
    panel5.setLayout(new BorderLayout());
    label5 = new JLabel("찜 목록");
    panel5.add(label5, BorderLayout.NORTH);
    
    ArrayList love = itemDB.whereDataLike(LogInPage.logInUser.getId());
    itemListLike = itemDB.whereDBLike(love);
    JTable jtable4 = tables.toJTable(itemListLike);
    JScrollPane spane4 = new JScrollPane(jtable4);
    panel5.add(jtable4, BorderLayout.CENTER);
    

    // 버튼
    JButton bt1 = new JButton("회원정보 조회 및 수정");
    arr2[0] = bt1;
    bt1.setBounds(-1, 140, 199, 89);
    frame.getContentPane().add(bt1);

    JButton bt2 = new JButton("판매중");
    arr2[1] = bt2;
    bt2.setBounds(197, 140, 199, 89);
    frame.getContentPane().add(bt2);

    JButton bt3 = new JButton("판매완료");
    arr2[2] = bt3;
    bt3.setBounds(397, 140, 199, 89);
    frame.getContentPane().add(bt3);

    JButton bt4 = new JButton("구매 목록");
    arr2[3] = bt4;
    bt4.setBounds(597, 140, 199, 89);
    frame.getContentPane().add(bt4);

    JButton bt5 = new JButton("찜 목록");
    arr2[4] = bt5;
    bt5.setBounds(796, 140, 199, 89);
    frame.getContentPane().add(bt5);

    // 버튼 클릭 이벤트
    arr3[0][0] = panel1;
    arr3[0][1] = bt1;

    arr3[1][0] = panel2;
    arr3[1][1] = bt2;

    arr3[2][0] = panel3;
    arr3[2][1] = bt3;

    arr3[3][0] = panel4;
    arr3[3][1] = bt4;

    arr3[4][0] = panel5;
    arr3[4][1] = bt5;

    for (Object[] object : arr3) {
      ((JButton) object[1]).addActionListener((e) -> {
        // 초기화
        for (Object[] object2 : arr3) {
          ((JPanel) object2[0]).setVisible(false);
        }
        // 원하는 부분 보여주기
        ((JPanel) object[0]).setVisible(true);
      });
    }

    // 번개장터 로고 버튼 + 메인페이지 이동
    JButton bt11 = new JButton(updateIcon);
    bt11.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        AfterLogInMain_JH.frame.setVisible(true);
        frame.setVisible(false);
        System.out.println("로그인 유저 아이디: " + LogInPage.logInUser.getId());
      }
    });
    bt11.setBorderPainted(false);
    bt11.setBounds(12, 10, 180, 60);
    panel.add(bt11);
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

    // --> 상단 우측 버튼 클릭시
    // 로그아웃
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        User logout = new User(null, null, null, null, null, 0);
        LogInPage.logInUser = logout; // 로그인한 유저 끊기
        BeforeLogInMain.frame.setVisible(true);
        frame.dispose();
        SellPage.frame.dispose();
        AfterLogInMain_JH.frame.dispose();
      }
    });
    // 판매하기
    btnNewButton_2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SellPage.frame.setVisible(true);
        frame.setVisible(false);
      }
    });

    // 돋보기 버튼
    JButton bt12 = new JButton(updateIcon2);
    bt12.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });
    bt12.setBounds(574, 30, 28, 23);
    panel.add(bt12);
  }
  // ----------------------------------------------------기본 뼈대 메소드
  // 끝--------------------------------------------------//



  // --------------------------------------------개인정보 UI 메소드
  // 시작------------------------------------------------//
  void resignUI(User logInUser) {
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    panel1.add(northPanel, BorderLayout.NORTH);
    panel1.add(centerPanel, BorderLayout.CENTER);
    panel1.add(southPanel, BorderLayout.SOUTH);
    northPanel.add(new JLabel("회원탈퇴 패널"));
    JPanel pwdPanel = new JPanel();
    JLabel pwdLb = new JLabel("비밀번호 : ");
    JPasswordField pwdTxt = new JPasswordField(10);
    JPanel pwdRePanel = new JPanel();
    JLabel pwdReLb = new JLabel("비밀번호 확인: ");
    JPasswordField pwdReTxt = new JPasswordField(10);// 입력란
    JButton confirmResignBtn = new JButton("회원탈퇴 진행");
    JButton cancelBtn = new JButton("회원탈퇴 취소");
    pwdPanel.add(pwdLb);
    pwdPanel.add(pwdTxt);
    pwdRePanel.add(pwdReLb);
    pwdRePanel.add(pwdReTxt);
    centerPanel.add(pwdPanel);
    centerPanel.add(pwdRePanel);
    southPanel.add(confirmResignBtn);
    southPanel.add(cancelBtn);
    confirmResignBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String inputPwd = new String(pwdTxt.getPassword());
        String inputPwdRe = new String(pwdReTxt.getPassword());
        userService.resignUser(logInUser, inputPwd, inputPwdRe);


      }
    });
    cancelBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        panel1.removeAll(); // 패널 지우기
        editUI();
        panel1.updateUI(); // 패널 화면 업데이트
      }
    });
  }

  void editUI() {
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    panel1.add(northPanel, BorderLayout.NORTH);
    panel1.add(centerPanel, BorderLayout.CENTER);
    panel1.add(southPanel, BorderLayout.SOUTH);
    // 상단
    label1 = new JLabel("회원정보 수정 및 탈퇴");
    label1.setBounds(162, 94, 232, 117);
    JLabel labelName = new JLabel("\t(" + LogInPage.logInUser.getNick() + ")님의 정보");
    northPanel.add(label1);
    northPanel.add(labelName);
    // 중앙
    // 라벨
    JLabel[] labelList = new JLabel[5];
    String strList[] = {"비밀번호 : ", "이    름 : ", "주    소 : ", "연 락 처 : ", "닉 네 임 : "};
    for (int i = 0; i < labelList.length; i++) {
      labelList[i] = new JLabel(strList[i]);
    }
    // 텍스트필드
    JPasswordField inputPwd = new JPasswordField(LogInPage.logInUser.getPwd(), 20);
    JTextField inputName = new JTextField(LogInPage.logInUser.getName(), 10);
    JTextField inputAddress = new JTextField(LogInPage.logInUser.getAddress(), 35);
    JTextField inputPhone =
        new JTextField("0" + String.valueOf(LogInPage.logInUser.getPhone()), 15);
    JTextField inputNick = new JTextField(LogInPage.logInUser.getNick(), 10);
    // 라벨 + 텍스트필드 = formPanelList
    JPanel[] formPanelList = new JPanel[5];
    Font formFont = new Font("Courier", Font.PLAIN, 30);
    for (int i = 0; i < strList.length; i++) {
      formPanelList[i] = new JPanel();
      formPanelList[i].setLayout(new FlowLayout(FlowLayout.LEFT));
      formPanelList[i].add(labelList[i]);
      formPanelList[i].setFont(formFont);
    }
    formPanelList[0].add(inputPwd);
    formPanelList[1].add(inputName);
    formPanelList[2].add(inputAddress);
    formPanelList[3].add(inputPhone);
    JLabel limit = new JLabel("-을 붙이지마세요.");
    formPanelList[3].add(limit);
    formPanelList[4].add(inputNick);
    // formPanelList 8개 정렬
    JPanel allFormPanel = new JPanel();
    allFormPanel.setLayout(new GridLayout(8, 1, 0, 30)); // 8행,1열
    for (int i = 0; i < formPanelList.length; i++) {
      allFormPanel.add(formPanelList[i]);
    }
    centerPanel.add(allFormPanel);
    // 하단패널
    JButton resignUserBtn = new JButton("회원탈퇴");
    JButton editUserBtn = new JButton("개인정보수정");
    southPanel.add(editUserBtn);
    southPanel.add(resignUserBtn);
    editUserBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String updatePwd = new String(inputPwd.getPassword()).trim();
        String updateName = inputName.getText().trim();
        String updateAddress = inputAddress.getText().trim();
        String updateNick = inputPhone.getText().trim();
        String updatePhone = inputPhone.getText().trim();
        userService.editUser(LogInPage.logInUser, updatePwd, updateName, updateAddress, updateNick,
            updatePhone);
      }
    });
    resignUserBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        panel1.removeAll(); // 패널 지우기
        resignUI(LogInPage.logInUser);
        panel1.updateUI(); // 패널 화면 업데이트
      }
    });
  }
  // --------------------------------------------개인정보 UI 메소드
  // 끝-----------------------------------------------//



}
