package itemDB;

import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

public class ItemDB {
  // columns: num, id, name, price, address, date
  Connection conn;
  Statement stmt;
  PreparedStatement pstm;
  ResultSet rs;
  Scanner sc = new Scanner(System.in);
  String sql;
  SoldItemDB soldItemDB = new SoldItemDB();
  ItemDB itemDB = new ItemDB();
  public ArrayList<ItemList> itemList = new ArrayList<ItemList>();

  public ItemDB() throws ClassNotFoundException, SQLException {
    // connection part
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weekend", "root",
        "dla254890*");
    System.out.println("itemDB 연결 성공");
  
  
  }
  // 전체 select, 찜갯수별, 등록시간순, 낮은시간순 정렬
  // select문에 order by 멘트를 추가하는 방식으로 구현



  // 셀렉트데이터는 괄호 안에 있는 값을 쿼리 끝에 order by로 추가함. 최대 3개까지 적용 가능


  // 메소드 오버로딩
  public ArrayList<ItemList> searchData(String column) throws SQLException {
    stmt = conn.createStatement();
    String sql = "select * from itemDB where name like '%" + column + "%'";
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

  public ArrayList<ItemList> selectData(String column) throws SQLException {
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

  public ArrayList<ItemList> selectData(String column, String column2) throws SQLException {
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

  public ArrayList<ItemList> selectData(String column, String column2, String column3)
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


  // insertData만 만들어둠
  public void insertData() throws SQLException {
    // executeUpdate는 반영된 레코드의 건수를 반환한다.(바로 insert, update, delete하면 되니까 rs를 리턴받을 필요가 없다)
    // 날짜 칸은 입력 안하면 오늘자가 자동으로 입력된다는데 확인해보자.

    System.out.println("ID를 입력하세요.");
    String inputId = sc.nextLine();
    System.out.println("제품명을 입력하세요.");

    String inputName = sc.nextLine();
    System.out.println("희망가격을 입력하세요.");
    String inputPrice = sc.nextLine();
    System.out.println("주소를 입력하세요.");
    String inputAddress = sc.nextLine();
    System.out.println("제품 설명을 추가해주세요.");
    String description = sc.nextLine();
    String inputContent = description;
    System.out.println("배송형태를 골라 주세요.");
    String inputTransaction = sc.nextLine();
    int intPrice = Integer.parseInt(inputPrice);
    stmt = conn.createStatement();

    String sql =
        String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
            inputId, inputName, intPrice, inputAddress, inputContent, inputTransaction);
    int result = stmt.executeUpdate(sql);

    System.out.println(result + " 건의 데이터를 처리했습니다.");
  }




  // 뭘 매개변수로 넣어서 delete를 실행하는 게 좋을까? 클릭된 this를 지우면 된다.
  // 옮기면서 buyerID를 추가함. 구매 date는 알아서 입력됨.

  // 클릭하면

  // 몇 가지 변수는 마우스로 입력할 수 있으면 편할 듯. address랑 transaction

  public void deleteData(String num) throws SQLException {
    stmt = conn.createStatement();
    String sql = String.format("delete from student where num=%s", num);
    int result = stmt.executeUpdate(sql);
    System.out.println(result + " 건의 데이터가 삭제되었습니다.");

  }
  
  
  //구매했을 때 액션. 이름 moveData,  num을 입력받으면 itemDB에서 해당 num을 가진 행을 soldItemDB로 복제한다. 
  // sql문: select * from itemDB where num=?
  
  
  //select한 데이터를 일단 itemList에 넣어서 리턴하자.
  
//  리턴받은 values들을 넣으면 되잖아
//  그러려면 num을 선택한 itemList를 리턴하는 메소드를 만들어야돼
  //만들었어
  //그럼 이제 ItemList의 각 값들을 insert하자.
  

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
  
public void moveData(String num1) throws SQLException {
	
	ArrayList<ItemList> itemList1 = new ArrayList<>();
	//num을 추출해 soldData에 입력
	itemList1= itemDB.numSelect(num1);
	itemDB.insertSoldData(itemList1.get(0));
	
	//itemDB 내 해당 num을 보유한 행 삭제
	itemDB.deleteData(num1);
}
  

//int랑 string 맞춰야 할수도 있음(num, price, like)
public void insertSoldData(ItemList itemList) throws SQLException {
    String sql =
        "insert into soldItemDB values (?,?,?,?,?,?,?,?,?,?,?)";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1, itemList.num);
    pstm.setString(2, itemList.id);
    pstm.setString(3, itemList.name);
    pstm.setString(4, itemList.price);
    pstm.setString(5, itemList.address);
    pstm.setString(1, itemList.content);
    pstm.setString(1, itemList.transaction);
    pstm.setString(1, itemList.date);
    pstm.setString(1, LoginPage.loginUser.getId());
    pstm.setString(1, itemList.name);
    pstm.setString(11, "now()");
    
    int result = pstm.executeUpdate(sql);
    System.out.println(result+ "건을 처리했습니다.");

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



}

