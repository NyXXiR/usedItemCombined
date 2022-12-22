package itemDB;

import java.sql.*;
import java.util.ArrayList;
import beforeLogin.LogInPage;

public class ItemDB2_JH {
	// columns: num, id, name, price, address, date
	Connection conn;
	Statement stmt;
	PreparedStatement pstm;
	ResultSet rs;
	String sql;

	SoldItemDB soldItemDB = new SoldItemDB();
	public ArrayList<ItemList> itemList = new ArrayList<ItemList>();
	public ArrayList<ItemList> itemList2 = new ArrayList<ItemList>();

	public ItemDB2_JH() {
		// connection part
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://172.30.1.11:3306/usedItemProject", "root2", "mysql");
			System.out.println("itemDB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// loveData(String data)=특정 단어 포함한 행 검색
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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
		}
		return itemList;
	}

	public ArrayList<ItemList> orderData(String column, String column2, String column3) throws SQLException {
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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
		}
		return itemList;
	}
	
	// likeDB에서 찾은 값 itemDB에서 찾기
	public ArrayList whereDBLike(ArrayList<String> arraylist) throws SQLException {
		stmt = conn.createStatement();
		for (int i = 0; i < arraylist.size(); i++) {
			String data = arraylist.get(i);
			sql = String.format("select * from itemDB where num='%s';", data);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String num = rs.getString("num");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String address = rs.getString("address");
				String content = rs.getString("content");
				String transaction = rs.getString("transaction");
				String love = rs.getString("love");
				String date = rs.getString("date");

				itemList2.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
			}
		}
		return itemList2;
	}

	// likeDB에서 값 찾기 *****************************
	public ArrayList<String> whereDataLike(String id) throws SQLException {
		sql = "select num from likeDB where id = '" + "id" + "'";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);

		ArrayList<String> likeList = new ArrayList<String>();
		while (rs.next()) {
			String likeNum = rs.getString("num");
			likeList.add(likeNum);
		}

		return likeList;
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
		ItemDB2_JH itemDB = new ItemDB2_JH();
		itemList1 = itemDB.whereData("num", num1);
		itemDB.insertSoldData2(itemList1.get(0));
		itemDB.deleteData(num1);
	}

	// insertSoldData(String num) = 입력한 num과 일치하는 행을 soldItemDB에 복제
	public void insertSoldData(ItemList itemList) throws SQLException {
		String sql = "insert into soldItemDB values ('?','?','?','?','?','?','?','?','?','?','?','?')";
		pstm = conn.prepareStatement(sql);

		pstm.setString(1, "0");
		pstm.setString(2, itemList.num);
		pstm.setString(3, itemList.id);
		pstm.setString(4, itemList.name);
		pstm.setString(5, itemList.price);
		pstm.setString(6, itemList.address);
		pstm.setString(7, itemList.content);
		pstm.setString(8, itemList.transaction);
		pstm.setString(9, itemList.love);
		pstm.setString(10, itemList.date);
		pstm.setString(11, LogInPage.logInUser.getId());
		pstm.setString(12, "now()");

		// pstm.setString(10, LogInPage.logInUser.getId());

		int result = pstm.executeUpdate(sql);
		System.out.println(result + "건 처리되었습니다.");

	}

	public void insertSoldData2(ItemList itemList) throws SQLException {
		stmt = conn.createStatement();
		String sql = String.format(
				"insert into soldItemDB values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',%s);", 0,
				itemList.num, itemList.id, itemList.name, itemList.price, itemList.address, itemList.content,
				itemList.transaction, itemList.love, itemList.date, LogInPage.logInUser.getId(), "now()");

		// pstm.setString(10, LogInPage.logInUser.getId());

		int result = stmt.executeUpdate(sql);
		System.out.println(result + "건 처리되었습니다.");

	}

	public void insertData(ItemList itemList) throws SQLException {
		String sql = "insert into ItemDB values ('?','?','?','?','?','?','?','?','?','?','?')";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, itemList.num);
		pstm.setString(2, LogInPage.logInUser.getId());
		pstm.setString(3, itemList.name);
		pstm.setString(4, itemList.price);
		pstm.setString(5, itemList.address);
		pstm.setString(6, itemList.content);
		pstm.setString(7, itemList.transaction);
		pstm.setString(8, itemList.love);
		pstm.setString(9, "now()");

		int result = pstm.executeUpdate(sql);
		System.out.println(result + "건 처리했습니다.");

	}
	
	// 찜하기 버튼 클릭시 likeDB에 입력되는 메소드
	public void insertloveData(ItemList itemList) {
		try {
			String sql = "insert into likeDB values (?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, LogInPage.logInUser.getId());
			pstm.setString(2, itemList.num);
			int result = pstm.executeUpdate();
			System.out.println(result + "건 처리했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	void updateData(ItemList itemList) {
		// String sql = "update itemDB " + "set column1 = ?, 2=? ~~";
		// try {
		// pstm = conn.prepareStatement(sql);
		// pstm.setString(1, itemList.id);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}
	
	// 찜하기 버튼 클릭시 itemDB에 love값 증가 메소드
	public void likePlus(String data) throws SQLException {
		String sql = "Update itemDB Set love=love+1 Where num = ? ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, data);
		int result = pstm.executeUpdate();
		System.out.println(result + "건 처리완료");

	}

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
			String love = rs.getString("love");
			String date = rs.getString("date");

			itemList.add(new ItemList(num, id, name, price, address, content, transaction, love, date));
		}
		return itemList;
	}

	public void insertDatas(String inputId, String inputName, String inputPrice, String inputAddress,
			String inputContent, String inputTransaction) throws SQLException {
		int result = 0;
		stmt = conn.createStatement();

		String sql = String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())", inputId,
				inputName, inputPrice, inputAddress, inputContent, inputTransaction);
		int result1 = stmt.executeUpdate(sql);

	}
}
