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
    // column�� �Է��ϰ�
    // �� �迭���� ������ �������

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



  // �ϴ� �����. ���߿� ToJTable�� �� �ٲٸ� �����ص� ��

  // select * from ItemDB�� ������ �Է��� JTable�� ��ȯ�ϴ� �޼ҵ�
  public JTable tableAction() throws ClassNotFoundException, SQLException {
    ItemDB itemDB = new ItemDB();
    itemList = itemDB.selectData();
    setLayout(new BorderLayout());
    // column�� �Է��ϰ�
    // �� �迭���� ������ �������

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


  // String�� �Է¹ް� �ش� String�� �������� ������ JTable�� ��ȯ�ϴ� �޼ҵ� �����ε�
  public JTable tableAction(String column) throws ClassNotFoundException, SQLException {
    ItemDB itemDB = new ItemDB();
    itemList = itemDB.orderData(column);
    setLayout(new BorderLayout());
    // column�� �Է��ϰ�
    // �� �迭���� ������ �������

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

    // jtable.getValueAt(row,0) = �ش� ���� primary key��.
    System.out.println(jtable.getValueAt(row, 0) + "����");


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
