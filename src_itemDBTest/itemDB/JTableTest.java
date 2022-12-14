package itemDB;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class JTableTest extends JPanel implements MouseListener {
  String[] columns;
  JTable jtable;
  public ArrayList<ItemList> itemList = new ArrayList<ItemList>();
  List<ItemList> dataList = new ArrayList<>();

  public JTableTest() throws ClassNotFoundException, SQLException {
    ItemDB itemDB = new ItemDB();
    itemList = itemDB.selectData("price");
    System.out.println(itemList);
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

    JScrollPane spane = new JScrollPane(jtable);

    add(spane, BorderLayout.CENTER);

  }

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    JFrame f = new JFrame("JTable test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTableTest jt = new JTableTest();
    f.add(jt);
    f.setSize(300, 200);
    f.setVisible(true);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    int row = jtable.getSelectedRow();
    int column = jtable.getSelectedColumn();


    // jtable.getValueAt(row,0) 하면 pri key 얻을 수 있음
    System.out.println(jtable.getValueAt(row, 0) + "선택");

    // System.out.println(jtable.getSelectedRow());
    // 넘버까지 나오게 하고 넘버만 받게 만들자

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

