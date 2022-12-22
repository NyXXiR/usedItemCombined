package itemDB;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTables_JH extends JPanel implements MouseListener {
  String[] columns;
  JTable jtable;
  Object x;
  String y;
  ItemDB2_JH itemDB = new ItemDB2_JH();
  ArrayList<ItemList> itemList = new ArrayList<>();



  public JTable toJTable(ArrayList<ItemList> itemList1)
      throws ClassNotFoundException, SQLException {

    setLayout(new BorderLayout());
    // column을 입력하고
    // 각 배열마다 데이터 집어넣음

    String[] columns =
        {"num", "id", "name", "price", "address", "content", "transaction", "love", "date"};

    DefaultTableModel model = new DefaultTableModel(columns, 0);
    jtable = new JTable(model);
    String[] row = new String[columns.length];

    for (int j = 0; j < itemList1.size(); j++) {
      row[0] = itemList1.get(j).num;
      row[1] = itemList1.get(j).id;
      row[2] = itemList1.get(j).name;
      row[3] = itemList1.get(j).price;
      row[4] = itemList1.get(j).address;
      row[5] = itemList1.get(j).content;
      row[6] = itemList1.get(j).transaction;
      row[7] = itemList1.get(j).love;
      row[8] = itemList1.get(j).date;
      model.addRow(row);
    };

    jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    jtable.addMouseListener(this);
    return jtable;

  }
  
  // 찜목록 테이블 메소드
  public JTable likeJTable(ArrayList<ItemList> itemList1)
	      throws ClassNotFoundException, SQLException {

	    setLayout(new BorderLayout());
	    // column을 입력하고
	    // 각 배열마다 데이터 집어넣음

	    String[] columns =
	        {"num", "id", "name", "price", "address", "content", "transaction", "love", "date"};

	    DefaultTableModel model = new DefaultTableModel(columns, 0);
	    jtable = new JTable(model);
	    String[] row = new String[columns.length];

	    for (int j = 0; j < itemList1.size(); j++) {
	      row[0] = itemList1.get(j).num;
	      row[1] = itemList1.get(j).id;
	      row[2] = itemList1.get(j).name;
	      row[3] = itemList1.get(j).price;
	      row[4] = itemList1.get(j).address;
	      row[5] = itemList1.get(j).content;
	      row[6] = itemList1.get(j).transaction;
	      row[7] = itemList1.get(j).love;
	      row[8] = itemList1.get(j).date;
	      model.addRow(row);
	    };
	    return jtable;
  }


  // 일단 살려둠. 나중에 ToJTable로 다 바꾸면 삭제해도 됨

  // select * from ItemDB의 정보를 입력한 JTable을 반환하는 메소드
  public JTable tableAction() throws ClassNotFoundException, SQLException {
    ItemDB2_JH itemDB = new ItemDB2_JH();
    itemList = itemDB.selectData();
    setLayout(new BorderLayout());
    // column을 입력하고
    // 각 배열마다 데이터 집어넣음

    String[] columns =
        {"num", "id", "name", "price", "address", "content", "transaction", "love", "date"};

    DefaultTableModel model = new DefaultTableModel(columns, 0);
    jtable = new JTable(model);

    String[] row = new String[columns.length];

    for (int j = 0; j < itemList.size(); j++) {
      row[0] = itemList.get(j).num;
      row[1] = itemList.get(j).id;
      row[2] = itemList.get(j).name;
      row[3] = itemList.get(j).price;
      row[4] = itemList.get(j).address;
      row[5] = itemList.get(j).content;
      row[6] = itemList.get(j).transaction;
      row[7] = itemList.get(j).love;
      row[8] = itemList.get(j).date;
      model.addRow(row);
    } ;

    jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    jtable.addMouseListener(this);
    return jtable;

  }


  // String을 입력받고 해당 String을 기준으로 정렬한 JTable을 반환하는 메소드 오버로딩
  public JTable tableAction(String column) throws ClassNotFoundException, SQLException {
    ItemDB2_JH itemDB = new ItemDB2_JH();
    itemList = itemDB.orderData(column);
    setLayout(new BorderLayout());
    // column을 입력하고
    // 각 배열마다 데이터 집어넣음

    String[] columns =
        {"num", "id", "name", "price", "address", "content", "transaction", "love", "date"};

    DefaultTableModel model = new DefaultTableModel(columns, 0);
    jtable = new JTable(model);

    String[] row = new String[columns.length];

    for (int j = 0; j < itemList.size(); j++) {
      row[0] = itemList.get(j).num;
      row[1] = itemList.get(j).id;
      row[2] = itemList.get(j).name;
      row[3] = itemList.get(j).price;
      row[4] = itemList.get(j).address;
      row[5] = itemList.get(j).content;
      row[6] = itemList.get(j).transaction;
      row[7] = itemList.get(j).love;
      row[8] = itemList.get(j).date;
      model.addRow(row);
    } ;

    jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    jtable.addMouseListener(this);
    return jtable;

  }

  public JTable tableActionDesc(String column) throws ClassNotFoundException, SQLException {
    ItemDB2_JH itemDB = new ItemDB2_JH();
    itemList = itemDB.orderDataDesc(column);
    setLayout(new BorderLayout());
    // column을 입력하고
    // 각 배열마다 데이터 집어넣음

    String[] columns =
        {"num", "id", "name", "price", "address", "content", "transaction", "love", "date"};

    DefaultTableModel model = new DefaultTableModel(columns, 0);
    jtable = new JTable(model);

    String[] row = new String[columns.length];

    for (int j = 0; j < itemList.size(); j++) {
      row[0] = itemList.get(j).num;
      row[1] = itemList.get(j).id;
      row[2] = itemList.get(j).name;
      row[3] = itemList.get(j).price;
      row[4] = itemList.get(j).address;
      row[5] = itemList.get(j).content;
      row[6] = itemList.get(j).transaction;
      row[7] = itemList.get(j).love;
      row[8] = itemList.get(j).date;
      model.addRow(row);
    } ;

    jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    jtable.addMouseListener(this);
    return jtable;

  }

  @Override
  public void mouseClicked(MouseEvent e) {

    int row = jtable.getSelectedRow();
    int column = jtable.getSelectedColumn();
    
    // jtable.getValueAt(row,0) = 해당 행의 primary key값.
    System.out.println(jtable.getValueAt(row, 0) + "선택");
    
    // 클릭한 행 soldItemDB로 이동, itemDB에서 삭제하는 부분. 나중에 찜 버튼 옆에 함께 배치
    x = jtable.getValueAt(row, 0);
	y = (String) x;
    
    // 구매,찜 팝업창
    JFrame fr = new JFrame("선택하기");
    JButton jb = new JButton("구매하기");
    JButton jb2 = new JButton("찜하기");
    fr.setSize(300, 200);
    fr.setLocation(600, 500);
    fr.setVisible(true);
    Container c = fr.getContentPane();
    c.setLayout(new BorderLayout());
    JPanel jp = new JPanel(new FlowLayout());
    jp.add(jb);
    jp.add(jb2);
    c.add(jp, BorderLayout.CENTER);

    // 구매하기 버튼 클릭 이벤트
	jb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
		    	System.out.println(y);
				itemDB.whereData("num", y);
				ItemList a = itemDB.whereData("num", y).get(0);
				itemDB.moveData(y);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	
	// 찜하기 버튼 클릭 이벤트
	jb2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				itemDB.likePlus(y);
				ArrayList<ItemList> itemList = itemDB.numSelect(y);
				itemDB.insertloveData(itemList.get(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	});
    
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }






}
