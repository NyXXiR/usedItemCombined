package itemDB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

  public ItemDB()  {
    // connection part
    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://172.30.1.11:3306/usedItemProject", "root2",
		    "mysql");
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 
    System.out.println("itemDB �곌껐 �깃났");
  }



  // likeData(String data)=�뱀�� �⑥�� �ы�⑦�� �� 寃���
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

  // selectData() = ��泥� ������
  public ArrayList<ItemList> selectData() throws SQLException {
    stmt = conn.createStatement();
    sql = "select * from itemDB";
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

  // orderData(String column)= ���ν�� column �ㅻ�李⑥���쇰� �� ����
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

  // whereData(String column, String data)= ���ν�� column怨� �쇱����� �곗�댄�곕� 異���
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
    System.out.println(result + " 嫄댁�� 泥�由ы���듬����.");

  }

  // num ���λ��쇰㈃ �대�� �� move 泥�由�
  public void moveData(String num1) throws SQLException, ClassNotFoundException {

    ArrayList<ItemList> itemList1 = new ArrayList<>();
    ItemDB itemDB = new ItemDB();
    itemList1 = itemDB.whereData("num", num1);
    itemDB.insertSoldData(itemList1.get(0));

    // itemDB ������ �������� num������ ������������������ ������ ������������
    itemDB.deleteData(num1);
  }


  // insertSoldData(String num) = ���ν�� num怨� �쇱����� ���� soldItemDB�� 蹂듭��
  public void insertSoldData(ItemList itemList) throws SQLException {
    String sql = "insert into soldItemDB values (?,?,?,?,?,?,?,?,?,?,?)";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1, itemList.num);
    pstm.setString(2, itemList.id);
    pstm.setString(3, itemList.name);
    pstm.setString(4, itemList.price);
    pstm.setString(5, itemList.address);
    pstm.setString(6, itemList.content);
    pstm.setString(7, itemList.transaction);
    pstm.setString(8, itemList.like);
    pstm.setString(9, itemList.date);
    pstm.setString(10, LogInPage.logInUser.getId());
    pstm.setString(11, "now()");

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "嫄� 泥�由щ�����듬����.");

  }

  public void insertData(ItemList itemList) throws SQLException {
    String sql = "insert into ItemDB values (?,?,?,?,?,?,?,?,?,?,?)";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1, itemList.num);
    pstm.setString(2, LogInPage.logInUser.getId());
    pstm.setString(3, itemList.name);
    pstm.setString(4, itemList.price);
    pstm.setString(5, itemList.address);
    pstm.setString(6, itemList.content);
    pstm.setString(7, itemList.transaction);
    pstm.setString(8, itemList.like);
    pstm.setString(9, "now()");



    int result = pstm.executeUpdate(sql);
    System.out.println(result + "嫄� 泥�由ы���듬����.");

  }


  public void insertLikeData(ItemList itemList) throws SQLException {
    String sql = "insert into likeDB values (?,?)";
    pstm = conn.prepareStatement(sql);

    pstm.setString(1, itemList.id);
    pstm.setString(2, LogInPage.logInUser.getId());

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "嫄� 泥�由ы���듬����.");

  }



  // update �����몄�����밸��� ������������


  void updateData(ItemList itemList) {
    // String sql = "update itemDB " + "set column1 = ?, 2=? ~~";
    // try {
    // pstm = conn.prepareStatement(sql);
    // pstm.setString(1, itemList.id);
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
  }


  void likeMinus() {}

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

  public void insertDatas(String inputId, String inputName, String inputPrice, String inputAddress,
      String inputContent, String inputTransaction)  {
    int result = 0;
    try {
		stmt = conn.createStatement(); 
		String sql =
        String.format("insert into itemDB values(0,'%s','%s', '%s','%s', '%s', '%s', 0, now())",
            inputId, inputName, inputPrice, inputAddress, inputContent, inputTransaction);
    result = stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   


  }
}


