package itemDB;

import java.sql.*;
import java.util.ArrayList;
import beforeLogin.LogInPage;

public class ItemDB {
  // columns: num, id, name, price, address, date
  Connection conn;
  Statement stmt;
  PreparedStatement pstm;
  ResultSet rs;
  String sql;

  SoldItemDB soldItemDB = new SoldItemDB();
  public ArrayList<ItemList> itemList = new ArrayList<ItemList>();

  public ItemDB() throws ClassNotFoundException, SQLException {
    // connection part
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://172.30.1.11:3306/usedItemProject", "root2",
        "mysql");
    System.out.println("itemDB ���� ����");
  }



  // likeData(Data) = �̸��� String�� ���Ե� �� �˻�
  public ArrayList<ItemList> likeData(String data) throws SQLException {
    stmt = conn.createStatement();
    String sql = "select * from itemDB where name like '%" + data + "%'";
    rs = stmt.executeQuery(sql);

    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  // selectData() = ��ü �� ���
  public ArrayList<ItemList> selectData() throws SQLException {
    // executeQuery�� �������� ResultSet ��ü�� ���� ��ȯ�Ѵ�.
    stmt = conn.createStatement();
    sql = "select * from itemDB";
    rs = stmt.executeQuery(sql);

    // for������ �ٲ㼭 �� �پ� ��µǰ� ������
    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  // orderData(Column)= �ش� column�� �������� �������� ����. ���������� �ʿ��� ��� desc �ٿ��� ����(ex. orderDataDesc)
  public ArrayList<ItemList> orderData(String column) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB order by %s;", column);
    rs = stmt.executeQuery(sql);

    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  public ArrayList<ItemList> orderDataDesc(String column) throws SQLException {
	    stmt = conn.createStatement();
	    sql = String.format("select * from itemDB order by %s Desc", column);
	    rs = stmt.executeQuery(sql);



    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  // 2, 3������ ������ �� �ִ� orderData �޼ҵ� �����ε�
  public ArrayList<ItemList> orderData(String column, String column2) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB order by %s, %s;", column, column2);
    rs = stmt.executeQuery(sql);

    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  public ArrayList<ItemList> orderData(String column, String column2, String column3)
      throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB order by %s, %s, %s;", column, column2, column3);
    rs = stmt.executeQuery(sql);

    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  // where ���ǽ��� �ٿ� �Է��� column�� Ư�� data�� ������ ��쿡�� ���
  public ArrayList<ItemList> whereData(String column, String data) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB where %s=%s;", column, data);
    rs = stmt.executeQuery(sql);

    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  public void deleteData(String num) throws SQLException {
    stmt = conn.createStatement();
    String sql = String.format("delete from itemDB where num=%s", num);
    int result = stmt.executeUpdate(sql);
    System.out.println(result + " ���� �����Ͱ� �����Ǿ����ϴ�.");

  }


  // �������� �� �׼�. �̸� moveData, num�� �Է¹����� itemDB���� �ش� num�� ���� ���� soldItemDB�� �����Ѵ�.
  // sql��: select * from itemDB where num=?


  // select�� �����͸� �ϴ� itemList�� �־ ��������.

  // ���Ϲ��� values���� ������ ���ݾ�
  // �׷����� num�� ������ itemList�� �����ϴ� �޼ҵ带 �����ߵ�
  // �������
  // �׷� ���� ItemList�� �� ������ insert����.



  public void moveData(String num1) throws SQLException, ClassNotFoundException {

    ArrayList<ItemList> itemList1 = new ArrayList<>();
    // num�� ������ soldData�� �Է�
    ItemDB itemDB = new ItemDB();
    itemList1 = itemDB.whereData("num", num1);
    itemDB.insertSoldData(itemList1.get(0));

    // itemDB �� �ش� num�� ������ �� ����
    itemDB.deleteData(num1);
  }


  // int�� string ����� �Ҽ��� ����(num, price, like)
  public void insertSoldData(ItemList itemList) throws SQLException {
    String sql = "insert into soldItemDB values (?,?,?,?,?,?,?,?,?,?,?)";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1, itemList.num);
    pstm.setString(2, itemList.id);
    pstm.setString(3, itemList.name);
    pstm.setString(4, itemList.price);
    pstm.setString(5, itemList.address);
    pstm.setString(1, itemList.content);
    pstm.setString(1, itemList.transaction);
    pstm.setString(1, itemList.date);
    // �α������� ���̵� �޾ƾ���
    pstm.setString(1, "buyerIDNeeded");
    pstm.setString(1, itemList.name);
    pstm.setString(11, "now()");

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "���� ó���߽��ϴ�.");

  }

  public void insertLikeData(ItemList itemList) throws SQLException {
    String sql = "insert into likeDB values (?,?)";
    pstm = conn.prepareStatement(sql);

    pstm.setString(1, itemList.id);
    pstm.setString(2, LogInPage.logInUser.getId());

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "���� ó���߽��ϴ�.");

  }



  // update �ʿ��ϸ� ����


  void updateData(ItemList itemList) {
    // String sql = "update itemDB " + "set column1 = ?, 2=? ~~";
    // try {
    // pstm = conn.prepareStatement(sql);
    // pstm.setString(1, itemList.id);
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
  }



  // ���ϱ� ��ư Ŭ���� like�� 1 �ö󰡴� ���. üũ�ڽ� ������ like�� �ٽ� 1 �����ؾ� ��.
  // void likePlus(String num) {
  //
  // alter like from itemDB where num = ? like +1 ;
  // sout "likeDB �Է¿Ϸ�"
  //
  // }


  // this Ȱ���� addListener ���� Ŭ���� �࿡ ����
  void likeMinus() {}

  // whereData ���ŷο� ���� �־ �����. whereData(num,data)�� ��� ����
  public ArrayList<ItemList> numSelect(String num1) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB where num=%s;", num1);
    rs = stmt.executeQuery(sql);

    while (rs.next()) {
      String num = rs.getString("num");
      String id = rs.getString("id");
      String name = rs.getString("name");
      String price = rs.getString("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      String like = rs.getString("like");
      String date = rs.getString("date");

      itemList.add(new ItemList(num, id, name, price, address, content, transaction, like, date));
    }
    return itemList;
  }

  // // insertData�� ������. �ϴ� �ּ�ó���ص�
  // public void insertData() throws SQLException {
  // // executeUpdate�� �ݿ��� ���ڵ��� �Ǽ��� ��ȯ�Ѵ�.(�ٷ� insert, update, delete�ϸ� �Ǵϱ� rs�� ���Ϲ��� �ʿ䰡 ����)
  // // ��¥ ĭ�� �Է� ���ϸ� �����ڰ� �ڵ����� �Էµȴٴµ� Ȯ���غ���.
  //
  // System.out.println("ID�� �Է��ϼ���.");
  // String inputId = sc.nextLine();
  // System.out.println("��ǰ���� �Է��ϼ���.");
  //
  // String inputName = sc.nextLine();
  // System.out.println("��������� �Է��ϼ���.");
  // String inputPrice = sc.nextLine();
  // System.out.println("�ּҸ� �Է��ϼ���.");
  // String inputAddress = sc.nextLine();
  // System.out.println("��ǰ ������ �߰����ּ���.");
  // String description = sc.nextLine();
  // String inputContent = description;
  // System.out.println("������¸� ��� �ּ���.");
  // String inputTransaction = sc.nextLine();
  // int intPrice = Integer.parseInt(inputPrice);
  // stmt = conn.createStatement();
  //
  // String sql =
  // String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
  // inputId, inputName, intPrice, inputAddress, inputContent, inputTransaction);
  // int result = stmt.executeUpdate(sql);
  //
  // System.out.println(result + " ���� �����͸� ó���߽��ϴ�.");
  // }


  public void insertDatas(String inputId, String inputName) throws SQLException {
    int result = 0;
    stmt = conn.createStatement();

    String sql =
        String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
            inputId, inputName, inputPrice, inputAddress, inputContent, inputTransaction);
    int result = stmt.executeUpdate(sql);


  }
}


