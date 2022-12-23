package afterLogin;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
// LogInPage를 정확하게 임포트
import beforeLogin.*;
import itemDB.ItemDB;
import userDB.User;

public class SellPage extends JFrame {
  ItemDB itemDB = new ItemDB();
  public static LogInPage logInPage;
  public static User logInUser = new User();
  public static JFrame frame = new JFrame();

  private JPanel contentPane;
  private JTextField textField1 = new JTextField();
  private JTextField textField2 = new JTextField();
  private JTextField textField3 = new JTextField();
  private JTextField textField4 = new JTextField();
  private JTextField textField5 = new JTextField();
  private String value;



  // 생성자
  public SellPage() {

    run();

  }

  // 메인메소드
  public static void main(String[] args) {

    SellPage window;
    window = new SellPage();
    window.frame.setVisible(true);


  }

  // ----------------------------------------------------기본 뼈대
  // 메소드-----------------------------------------------//
  public void run() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, 1000, 800);
    frame.setLocationRelativeTo(null);
    contentPane = new JPanel();
    frame.setContentPane(contentPane);
    contentPane.setLayout(null);

    // 번개장터 로고 버튼 + 메인페이지 이동
    JButton bt1 = new JButton();
    bt1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
       AfterLogInMain.frame.setVisible(true);
        frame.setVisible(false);
      }
    });
    bt1.setBorderPainted(false);
    bt1.setBounds(12, 10, 180, 60);

    // 상단검색바
    // textField3 = new JTextField(" 검색");
    // textField3.addFocusListener(new FocusListener() {
    //
    // @Override
    // public void focusGained(FocusEvent e) {
    // textField3.setText("");
    // value = textField3.getText();
    // }
    //
    // @Override
    // public void focusLost(FocusEvent e) {
    //
    // }
    // });
    // textField3.setBounds(234, 25, 333, 34);
    // textField3.setBorder(BorderFactory.createLineBorder(Color.decode("#ff0000")));
    // textField3.setColumns(10);

    // 상단 우측 버튼들
    JButton btnNewButton = new JButton("로그아웃");
    btnNewButton.setBounds(887, 23, 85, 42);

    JButton btnNewButton_1 = new JButton("내 상점");
    btnNewButton_1.setBounds(790, 24, 85, 42);

    JButton btnNewButton_2 = new JButton("판매하기");
    btnNewButton_2.setBounds(693, 24, 85, 42);

    // --> 상단 우측 버튼 기능
    // 로그아웃
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        User logout = new User();
        LogInPage.logInUser = logout; // 로그인한 유저 끊기

      
        BeforeLogInMain.frame.setVisible(true);
        frame.dispose();
        AfterLogInMain.frame.dispose();
      }
    });
    // 내상점
    btnNewButton_1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         MyStorePage myStore = new MyStorePage();
        	myStore.frame.setVisible(true);
            frame.setVisible(false);
      }
    });

    // 상단 검색창 돋보기 버튼
    // JButton bt2 = new JButton();
    // bt2.addActionListener(new java.awt.event.ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    //
    // }
    // });

    // 상단
    JPanel panel4 = new JPanel();
    panel4.setBounds(0, 0, 1000, 109);
    contentPane.add(panel4);
    panel4.add(textField3);
    panel4.add(btnNewButton);
    panel4.add(btnNewButton_1);
    panel4.add(btnNewButton_2);
    panel4.add(bt1);
    panel4.setLayout(null);
    // bt2.setBounds(574, 30, 28, 23);
    // panel4.add(bt2);


    // -------------------------------------하단-------------------------------------//
    // 하단 상품등록 제목창

    LogInPage.logInUser.getId();

    textField1.setBorder(
        new TitledBorder(null, "제목", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    textField1.setBounds(55, 130, 445, 45);

    contentPane.add(textField1);
    textField1.setColumns(10);


    // 하단 상품등록 상품상세정보창
    textField2.setBorder(
        new TitledBorder(null, "상품상세정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    textField2.setBounds(55, 340, 600, 140);

    contentPane.add(textField2);
    textField2.setColumns(10);


    // 가격창
    textField3.setBorder(
        new TitledBorder(null, "가격", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    textField3.setBounds(550, 130, 200, 45);

    contentPane.add(textField3);
    textField3.setColumns(10);


    // 지역창
    textField4.setBorder(new TitledBorder(null, "지역(ex.ㅇㅇ시 ㅇㅇ구 ㅇㅇ동)", TitledBorder.LEADING,
        TitledBorder.TOP, null, null));
    textField4.setBounds(55, 200, 445, 45);

    contentPane.add(textField4);
    textField4.setColumns(10);


    // 배송유형
    textField5.setBorder(
        new TitledBorder(null, "배송유형(직거래/택배)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    textField5.setBounds(55, 270, 445, 45);

    contentPane.add(textField5);
    textField5.setColumns(10);



    JButton button = new JButton("등록하기");
    button.setBounds(750, 420, 97, 55);
    contentPane.add(button);
    button.addActionListener(new Listener());


  }

  class Listener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println(e.getActionCommand());
      String inputName = textField1.getText();
      System.out.println(inputName);
      String inputContent = textField2.getText();
      System.out.println(inputContent);
      String inputPrice = textField3.getText();
      System.out.println(inputPrice);
      String inputAddress = textField4.getText();
      System.out.println(inputAddress);
      String inputTransaction = textField5.getText();
      System.out.println(inputTransaction);


      JOptionPane.showMessageDialog(frame, "상품등록완료");
      itemDB.insertDatas(LogInPage.logInUser.getId(), inputName, inputPrice, inputAddress,
          inputContent, inputTransaction);


    }



  }



  // ----------------------------------------------------기본 뼈대
  // 메소드--------------------------------------------------//
}
