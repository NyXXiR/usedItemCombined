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
    System.out.println("itemDB 占쏙옙占쏙옙 占쏙옙占쏙옙");
  }



  // likeData(Data) = 占싱몌옙占쏙옙 String占쏙옙 占쏙옙占쌉듸옙 占쏙옙 占싯삼옙
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

  // selectData() = 占쏙옙체 占쏙옙 占쏙옙占�
  public ArrayList<ItemList> selectData() throws SQLException {
    // executeQuery占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 ResultSet 占쏙옙체占쏙옙 占쏙옙占쏙옙 占쏙옙환占싼댐옙.
    stmt = conn.createStatement();
    sql = "select * from itemDB";
    rs = stmt.executeQuery(sql);

    // for占쏙옙占쏙옙占쏙옙 占쌕꿔서 占쏙옙 占쌕억옙 占쏙옙쨉품占� 占쏙옙占쏙옙占쏙옙
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

  // orderData(Column)= 占쌔댐옙 column占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙. 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占십울옙占쏙옙 占쏙옙占� desc 占쌕울옙占쏙옙 占쏙옙占쏙옙(ex. orderDataDesc)
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

  // 2, 3占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쌍댐옙 orderData 占쌨소듸옙 占쏙옙占쏙옙占싸듸옙
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

  // where 占쏙옙占실쏙옙占쏙옙 占쌕울옙 占쌉뤄옙占쏙옙 column占쏙옙 특占쏙옙 data占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙荑∽옙占� 占쏙옙占�
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
    System.out.println(result + " 占쏙옙占쏙옙 占쏙옙占쏙옙占싶곤옙 占쏙옙占쏙옙占실억옙占쏙옙占싹댐옙.");

  }


  // 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙 占쌓쇽옙. 占싱몌옙 moveData, num占쏙옙 占쌉력뱄옙占쏙옙占쏙옙 itemDB占쏙옙占쏙옙 占쌔댐옙 num占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 soldItemDB占쏙옙 占쏙옙占쏙옙占싼댐옙.
  // sql占쏙옙: select * from itemDB where num=?


  // select占쏙옙 占쏙옙占쏙옙占싶몌옙 占싹댐옙 itemList占쏙옙 占쌍어서 占쏙옙占쏙옙占쏙옙占쏙옙.

  // 占쏙옙占싹뱄옙占쏙옙 values占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쌥억옙
  // 占쌓뤄옙占쏙옙占쏙옙 num占쏙옙 占쏙옙占쏙옙占쏙옙 itemList占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨소드를 占쏙옙占쏙옙占쌩듸옙
  // 占쏙옙占쏙옙占쏙옙占�
  // 占쌓뤄옙 占쏙옙占쏙옙 ItemList占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 insert占쏙옙占쏙옙.



  public void moveData(String num1) throws SQLException, ClassNotFoundException {

    ArrayList<ItemList> itemList1 = new ArrayList<>();
    // num占쏙옙 占쏙옙占쏙옙占쏙옙 soldData占쏙옙 占쌉뤄옙
    ItemDB itemDB = new ItemDB();
    itemList1 = itemDB.whereData("num", num1);
    itemDB.insertSoldData(itemList1.get(0));

    // itemDB 占쏙옙 占쌔댐옙 num占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
    itemDB.deleteData(num1);
  }


  // int占쏙옙 string 占쏙옙占쏙옙占� 占쌀쇽옙占쏙옙 占쏙옙占쏙옙(num, price, like)
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
    pstm.setString(8, itemList.date);
    // 占싸깍옙占쏙옙占쏙옙占쏙옙 占쏙옙占싱듸옙 占쌨아억옙占쏙옙
    pstm.setString(9, "buyerIDNeeded");
    pstm.setString(10, LogInPage.logInUser.getId());
    pstm.setString(11, "now()");

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "占쏙옙占쏙옙 처占쏙옙占쌩쏙옙占싹댐옙.");

  }
  public void insertData(ItemList itemList) throws SQLException {
	    String sql = "insert into ItemDB values (?,?,?,?,?,?,?,?,?,?,?)";
	    pstm = conn.prepareStatement(sql);
	    pstm.setString(1, itemList.num);
	    pstm.setString(2, itemList.id);
	    pstm.setString(3, itemList.name);
	    pstm.setString(4, itemList.price);
	    pstm.setString(5, itemList.address);
	    pstm.setString(6, itemList.content);
	    pstm.setString(7, itemList.transaction);
	    pstm.setString(8, itemList.date);
	    // 占싸깍옙占쏙옙占쏙옙占쏙옙 占쏙옙占싱듸옙 占쌨아억옙占쏙옙
	    pstm.setString(9, LogInPage.logInUser.getId());
	    pstm.setString(10, itemList.name);
	    pstm.setString(11, "now()");

	    int result = pstm.executeUpdate(sql);
	    System.out.println(result + "占쏙옙占쏙옙 처占쏙옙占쌩쏙옙占싹댐옙.");

	  }
  
  
  public void insertLikeData(ItemList itemList) throws SQLException {
    String sql = "insert into likeDB values (?,?)";
    pstm = conn.prepareStatement(sql);

    pstm.setString(1, itemList.id);
    pstm.setString(2, LogInPage.logInUser.getId());

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "占쏙옙占쏙옙 처占쏙옙占쌩쏙옙占싹댐옙.");

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



  // 占쏙옙占싹깍옙 占쏙옙튼 클占쏙옙占쏙옙 like占쏙옙 1 占시라가댐옙 占쏙옙占�. 체크占쌘쏙옙 占쏙옙占쏙옙占쏙옙 like占쏙옙 占쌕쏙옙 1 占쏙옙占쏙옙占쌔억옙 占쏙옙.
  // void likePlus(String num) {
  //
  // alter like from itemDB where num = ? like +1 ;
  // sout "likeDB 占쌉력완뤄옙"
  //
  // }


  // this 활占쏙옙占쏙옙 addListener 占쏙옙占쏙옙 클占쏙옙占쏙옙 占썅에 占쏙옙占쏙옙
  void likeMinus() {}

  // whereData 占쏙옙占신로울옙 占쏙옙占쏙옙 占쌍어서 占쏙옙占쏙옙占�. whereData(num,data)占쏙옙 占쏙옙占� 占쏙옙占쏙옙
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

  // // insertData占쏙옙 占쏙옙占쏙옙占쏙옙. 占싹댐옙 占쌍쇽옙처占쏙옙占쌔듸옙
  // public void insertData() throws SQLException {
  // // executeUpdate占쏙옙 占쌥울옙占쏙옙 占쏙옙占쌘듸옙占쏙옙 占실쇽옙占쏙옙 占쏙옙환占싼댐옙.(占쌕뤄옙 insert, update, delete占싹몌옙 占실니깍옙 rs占쏙옙 占쏙옙占싹뱄옙占쏙옙 占십요가 占쏙옙占쏙옙)
  // // 占쏙옙짜 칸占쏙옙 占쌉뤄옙 占쏙옙占싹몌옙 占쏙옙占쏙옙占쌘곤옙 占쌘듸옙占쏙옙占쏙옙 占쌉력된다는듸옙 확占쏙옙占쌔븝옙占쏙옙.
  //
  // System.out.println("ID占쏙옙 占쌉뤄옙占싹쇽옙占쏙옙.");
  // String inputId = sc.nextLine();
  // System.out.println("占쏙옙품占쏙옙占쏙옙 占쌉뤄옙占싹쇽옙占쏙옙.");
  //
  // String inputName = sc.nextLine();
  // System.out.println("占쏙옙占쏙옙占쏙옙占쏙옙占� 占쌉뤄옙占싹쇽옙占쏙옙.");
  // String inputPrice = sc.nextLine();
  // System.out.println("占쌍소몌옙 占쌉뤄옙占싹쇽옙占쏙옙.");
  // String inputAddress = sc.nextLine();
  // System.out.println("占쏙옙품 占쏙옙占쏙옙占쏙옙 占쌩곤옙占쏙옙占쌍쇽옙占쏙옙.");
  // String description = sc.nextLine();
  // String inputContent = description;
  // System.out.println("占쏙옙占쏙옙占쏙옙쨍占� 占쏙옙占� 占쌍쇽옙占쏙옙.");
  // String inputTransaction = sc.nextLine();
  // int intPrice = Integer.parseInt(inputPrice);
  // stmt = conn.createStatement();
  //
  // String sql =
  // String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
  // inputId, inputName, intPrice, inputAddress, inputContent, inputTransaction);
  // int result = stmt.executeUpdate(sql);
  //
  // System.out.println(result + " 占쏙옙占쏙옙 占쏙옙占쏙옙占싶몌옙 처占쏙옙占쌩쏙옙占싹댐옙.");
  // }


  public void insertDatas
	(String inputId, String inputName,String inputPrice,String inputAddress,String inputContent,String inputTransaction )throws SQLException {
	int result=0;
	stmt = conn.createStatement();
	
	String sql =
	String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
	inputId, inputName, inputPrice, inputAddress, inputContent, inputTransaction);
	int result1 = stmt.executeUpdate(sql);


}
}


