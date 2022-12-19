package itemDB;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTables extends JPanel implements MouseListener {
  String[] columns;
  JTable jtable;
  public ArrayList<ItemList> itemList = new ArrayList<ItemList>();

  public JTable toJTable(ArrayList<ItemList> itemList1)
      throws ClassNotFoundException, SQLException {
    ArrayList<ItemList> itemList = new ArrayList<>();
    itemList1 = itemList;
    ItemDB itemDB = new ItemDB();

    setLayout(new BorderLayout());
    // column을 입력하고
    // 각 배열마다 데이터 집어넣음

    String[] columns =
        {"num", "id", "name", "price", "address", "content", "transaction", "like", "date"};

    DefaultTableModel model = new DefaultTableModel(columns, 0);
    jtable = new JTable(model);

    String[] row = new String[columns.length];

    for (int j = 0; j < itemList.size(); j++) {
      row[0] = itemList1.get(j).num;
      row[1] = itemList1.get(j).id;
      row[2] = itemList1.get(j).name;
      row[3] = itemList1.get(j).price;
      row[4] = itemList1.get(j).address;
      row[5] = itemList1.get(j).content;
      row[6] = itemList1.get(j).transaction;
      row[7] = itemList1.get(j).like;
      row[8] = itemList1.get(j).date;
      model.addRow(row);
    } ;

    jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    jtable.addMouseListener(this);
    return jtable;


  }



  // 일단 살려둠. 나중에 ToJTable로 다 바꾸면 삭제해도 됨

  // select * from ItemDB의 정보를 입력한 JTable을 반환하는 메소드
  public JTable tableAction() throws ClassNotFoundException, SQLException {
    ItemDB itemDB = new ItemDB();
    itemList = itemDB.selectData();
    setLayout(new BorderLayout());
    // column을 입력하고
    // 각 배열마다 데이터 집어넣음

    String[] columns =
        {"num", "id", "name", "price", "address", "content", "transaction", "like", "date"};

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
      row[7] = itemList.get(j).like;
      row[8] = itemList.get(j).date;
      model.addRow(row);
    } ;

    jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    jtable.addMouseListener(this);
    return jtable;


  }


  // String을 입력받고 해당 String을 기준으로 정렬한 JTable을 반환하는 메소드 오버로딩
  public JTable tableAction(String column) throws ClassNotFoundException, SQLException {
    ItemDB itemDB = new ItemDB();
    itemList = itemDB.orderData(column);
    setLayout(new BorderLayout());
    // column을 입력하고
    // 각 배열마다 데이터 집어넣음

    String[] columns =
        {"num", "id", "name", "price", "address", "content", "transaction", "like", "date"};

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
      row[7] = itemList.get(j).like;
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
