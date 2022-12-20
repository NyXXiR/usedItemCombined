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
    System.out.println("itemDB 연결 성공");
  }



  // likeData(String data)=특정 단어 포함한 행 검색
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

  // selectData() = 전체 셀렉트
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

  // orderData(String column)= 입력한 column 오름차순으로 행 정렬
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

  // whereData(String column, String data)= 입력한 column과 일치하는 데이터만 출력
  public ArrayList<ItemList> whereData(String column, String data) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB where %s='%s';", column, data);
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
    System.out.println(result + " 건을 처리했습니다.");

  }

  // num 입력받으면 해당 행 move 처리
  public void moveData(String num1) throws SQLException, ClassNotFoundException {

    ArrayList<ItemList> itemList1 = new ArrayList<>();
    ItemDB itemDB = new ItemDB();
    itemList1 = itemDB.whereData("num", num1);
    itemDB.insertSoldData(itemList1.get(0));

    // itemDB 占쏙옙 占쌔댐옙 num占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
    itemDB.deleteData(num1);
  }


  // insertSoldData(String num) = 입력한 num과 일치하는 행을 soldItemDB에 복제
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
    System.out.println(result + "건 처리되었습니다.");

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
    System.out.println(result + "건 처리했습니다.");

  }


  public void insertLikeData(ItemList itemList) throws SQLException {
    String sql = "insert into likeDB values (?,?)";
    pstm = conn.prepareStatement(sql);

    pstm.setString(1, itemList.id);
    pstm.setString(2, LogInPage.logInUser.getId());

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "건 처리했습니다.");

  }



  // update 占십울옙占싹몌옙 占쏙옙占쏙옙


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
      String inputContent, String inputTransaction) throws SQLException {
    int result = 0;
    stmt = conn.createStatement();

    String sql =
        String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
            inputId, inputName, inputPrice, inputAddress, inputContent, inputTransaction);
    int result1 = stmt.executeUpdate(sql);


  }
}


