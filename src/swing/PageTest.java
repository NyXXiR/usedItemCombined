package swing;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import itemDB.*;

public class PageTest extends JFrame {

  private JFrame frame;
  private JTextField textField;
  private String value;

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

  // 메인 메소드
  public static void main(String[] args) {
    run();
  }

  // 실행 메소드
  public static void run() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          PageTest window = new PageTest();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  // 새로고침 메소드
  public static void run2() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          PageTest window = new PageTest();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  // 생성자 메소드
  public PageTest() throws ClassNotFoundException, SQLException {
    initialize();
  }

  private void initialize() throws ClassNotFoundException, SQLException {
    // 프레임
    frame = new JFrame();
    frame.setBounds(100, 100, 1012, 680);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    //////////////////// 패널 상단

    // 상단 패널
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 1000, 109);
    frame.getContentPane().add(panel);

    // 번개장터 로고 버튼 + 메인페이지 이동
    JButton bt1 = new JButton(updateIcon);
    bt1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {}
    });
    bt1.setBorderPainted(false);
    bt1.setBounds(12, 10, 180, 60);
    panel.add(bt1);
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

    // 돋보기 버튼
    JButton bt2 = new JButton(updateIcon2);
    bt2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });
    bt2.setBounds(574, 30, 28, 23);
    panel.add(bt2);

    //////////////////// 패널 하단

    // 하단 패널 부분
    JPanel panel12 = new JPanel();
    panel12.setBounds(0, 108, 995, 533);
    frame.getContentPane().add(panel12);
    panel12.setLayout(null);

    JButton btnNewButton11 = new JButton("정확도순");
    btnNewButton11.setBounds(646, 12, 88, 23);
    panel12.add(btnNewButton11);

    JButton btnNewButton12 = new JButton("최신순");
    btnNewButton12.setBounds(740, 12, 74, 23);
    panel12.add(btnNewButton12);

    JButton btnNewButton13 = new JButton("저가순");
    btnNewButton13.setBounds(819, 12, 75, 23);
    panel12.add(btnNewButton13);

    JButton btnNewButton14 = new JButton("고가순");
    btnNewButton14.setBounds(898, 12, 74, 23);
    panel12.add(btnNewButton14);

    JPanel panel_1 = new JPanel();
    panel_1.setBounds(12, 54, 971, 469);
    panel12.add(panel_1);
    panel_1.setLayout(new CardLayout(0, 0));

    // 테이블정보
    JPanel table = new JPanel();

    table.setBounds(200, 200, 0, 0);
    table.setSize(800, 600);
    frame.getContentPane().add(table);

    // JTables selectAll = new JTables();
    // table.add(selectAll.tableAction());

    JTables orderByPrice = new JTables();
    ItemDB itemDB = new ItemDB();
    ArrayList<ItemList> itemList = itemDB.orderData("price");
    JTable a = orderByPrice.toJTable(itemList);
    table.add(a);


    // 마우스이벤트

    // btnNewButton13.addActionListener(new ActionListener() {
    //
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // t.setVisible(false);
    // tt.setVisible(true);
    // }
    //
    //
    // });


  };


}

