package itemDB;

import java.sql.*;
import java.util.ArrayList;

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



  // likeData(Data) = 이름에 String이 포함된 행 검색
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

  // selectData() = 전체 행 출력
  public ArrayList<ItemList> selectData() throws SQLException {
    // executeQuery는 수행결과로 ResultSet 객체의 값을 반환한다.
    stmt = conn.createStatement();
    sql = "select * from itemDB";
    rs = stmt.executeQuery(sql);

    // for문으로 바꿔서 한 줄씩 출력되게 만들어야
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

  // orderData(Column)= 해당 column을 기준으로 오름차순 정렬. 내림차순이 필요할 경우 desc 붙여서 생성(ex. orderDataDesc)
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
  public ArrayList<ItemList> selectDataDesc(String column) throws SQLException {
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

  // 2, 3중으로 정렬할 수 있는 orderData 메소드 오버로딩
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

  // where 조건식을 붙여 입력한 column에 특정 data가 존재할 경우에만 출력
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
    System.out.println(result + " 건의 데이터가 삭제되었습니다.");

  }


  // 구매했을 때 액션. 이름 moveData, num을 입력받으면 itemDB에서 해당 num을 가진 행을 soldItemDB로 복제한다.
  // sql문: select * from itemDB where num=?


  // select한 데이터를 일단 itemList에 넣어서 리턴하자.

  // 리턴받은 values들을 넣으면 되잖아
  // 그러려면 num을 선택한 itemList를 리턴하는 메소드를 만들어야돼
  // 만들었어
  // 그럼 이제 ItemList의 각 값들을 insert하자.



  public void moveData(String num1) throws SQLException, ClassNotFoundException {

    ArrayList<ItemList> itemList1 = new ArrayList<>();
    // num을 추출해 soldData에 입력
    ItemDB itemDB = new ItemDB();
    itemList1 = itemDB.whereData("num", num1);
    itemDB.insertSoldData(itemList1.get(0));

    // itemDB 내 해당 num을 보유한 행 삭제
    itemDB.deleteData(num1);
  }


  // int랑 string 맞춰야 할수도 있음(num, price, like)
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
    // 로그인유저 아이디 받아야함
    pstm.setString(1, "buyerIDNeeded");
    pstm.setString(1, itemList.name);
    pstm.setString(11, "now()");

    int result = pstm.executeUpdate(sql);
    System.out.println(result + "건을 처리했습니다.");

  }


  // update 필요하면 구현


  void updateData(ItemList itemList) {
    // String sql = "update itemDB " + "set column1 = ?, 2=? ~~";
    // try {
    // pstm = conn.prepareStatement(sql);
    // pstm.setString(1, itemList.id);
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
  }



  // 찜하기 버튼 클릭시 like가 1 올라가는 기능. 체크박스 해제시 like가 다시 1 감소해야 함.
  void likePlus() {}

  // this 활용해 addListener 통해 클릭된 행에 적용
  void likeMinus() {}

  // whereData 번거로울 수도 있어서 살려둠. whereData(num,data)와 기능 같음
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

// // insertData만 만들어둠. 일단 주석처리해둠
//   public void insertData() throws SQLException {
//   // executeUpdate는 반영된 레코드의 건수를 반환한다.(바로 insert, update, delete하면 되니까 rs를 리턴받을 필요가 없다)
//   // 날짜 칸은 입력 안하면 오늘자가 자동으로 입력된다는데 확인해보자.
//  
//   System.out.println("ID를 입력하세요.");
//   String inputId = sc.nextLine();
//   System.out.println("제품명을 입력하세요.");
//  
//   String inputName = sc.nextLine();
//   System.out.println("희망가격을 입력하세요.");
//   String inputPrice = sc.nextLine();
//   System.out.println("주소를 입력하세요.");
//   String inputAddress = sc.nextLine();
//   System.out.println("제품 설명을 추가해주세요.");
//   String description = sc.nextLine();
//   String inputContent = description;
//   System.out.println("배송형태를 골라 주세요.");
//   String inputTransaction = sc.nextLine();
//   int intPrice = Integer.parseInt(inputPrice);
//   stmt = conn.createStatement();
//  
//   String sql =
//   String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
//   inputId, inputName, intPrice, inputAddress, inputContent, inputTransaction);
//   int result = stmt.executeUpdate(sql);
//  
//   System.out.println(result + " 건의 데이터를 처리했습니다.");
//   }
  
  
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


