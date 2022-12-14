package userDB;

import java.sql.*;

public class UserDB {
  Connection conn;
  Statement stmt;
  ResultSet rs;
  PreparedStatement pstmt;

  // mysql占쎈퓠 占쎌젔占쎈꺗
  public UserDB() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    System.out.println("占쎈굡占쎌뵬占쎌뵠甕곤옙 占쎄퐬燁삼옙");
    System.out.println("占쎌젔占쎈꺗 占쎄쉐�⑨옙");
  }


  // SelectAll筌롫뗄�꺖占쎈굡 : member占쎌읈筌ｏ옙 占쎌젟癰귨옙
  public String selectAll() {
    String str = "";
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select * from user");
      while (rs.next()) {
        String id = rs.getString("id");
        String pwd = rs.getString("pwd");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String nick = rs.getString("nick");
        int phone = rs.getInt("phone");
        str += String.format("id:%s name:%s address:%s nickname:%s phoneNumber:%d \n", id, name,
            address, nick, phone);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return str;
  }

  // insert筌롫뗄�꺖占쎈굡 : 筌롢끇苡쵥B占쎈퓠 �빊遺쏙옙, 占쎌돳占쎌뜚揶쏉옙占쎌뿯
  public void insert(String id, String pwd, String name, String address, String nick, int phone) {

    String sql =
        "" + "INSERT INTO user(id, pwd, name, address, nick, phone) " + "VALUES (?, ?, ?, ?, ?,?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pwd);
      pstmt.setString(3, name);
      pstmt.setString(4, address);
      pstmt.setString(5, nick);
      pstmt.setInt(6, phone);
      int result = pstmt.executeUpdate();
      System.out.println(result + "椰꾬옙 占쎌뿯占쎌젾 占쎄쉐�⑨옙");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  // 占쎌젟癰귣똻�땾占쎌젟.
  // id揶쏉옙 占쎄텕 揶쏉옙. 占쎄돌�솒紐꾬옙占쎈뮉 癰귨옙野껓옙 揶쏉옙. (id占쎈뮉 癰귨옙野껋럥�뀑揶쏉옙)
  // https://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140190267626
  public int userUpdate(String updatePwd, String updateName, String updateAddress,
      String updateNick, int updatePhone, String id) {
    int result = 0;
    String sql = "UPDATE user SET  pwd=?, name=?, address=?, nick=?, phone=? WHERE id=?";
    try {
      pstmt = conn.prepareStatement(sql);
      // ?占쎌벥 占쎈떄占쎄퐣占쏙옙嚥∽옙 揶쏉옙 占쎄퐫疫뀐옙
      pstmt.setString(1, updatePwd);
      pstmt.setString(2, updateName);
      pstmt.setString(3, updateAddress);
      pstmt.setString(4, updateNick);
      pstmt.setInt(5, updatePhone);
      pstmt.setString(6, id);
      // 占쎈뼄占쎈뻬占쎈릭疫뀐옙
      result = pstmt.executeUpdate();

    } catch (SQLException e) {

      System.out.println(e.getMessage() + "=> userUpdate fail");
    }
    return result;
  }// userUpdate()


  // delete筌롫뗄�꺖占쎈굡 : 筌롢끇苡쵥B占쎈퓠占쎄퐣 筌롢끇苡� 占쎄텣占쎌젫, 占쎌돳占쎌뜚占쎄퉱占쎈닚
  public void delete(String id) {
    try {
      stmt = conn.createStatement();
      int result = stmt.executeUpdate("delete from user where id = '" + id + "' ");
      System.out.printf("%s占쎌벥 占쎌쁽�뙴�슢占쏙옙 %d椰꾬옙 占쎄텣占쎌젫", id, result);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  // Id餓λ쵎�궗筌ｋ똾寃�
  // 筌띲끆而삭퉪占쏙옙�땾嚥∽옙 占쎈굶占쎈선占쎌궔 id占쎈퓠 占쎈퉸占쎈뼣占쎈릭占쎈뮉 占쎌쟿�굜遺얜굡 野껓옙占쎄퉳占쎈릭占쎈연 餓λ쵎�궗占쎈연�겫占� 筌ｋ똾寃뺧옙釉�疫뀐옙
  // �뵳�뗪쉘揶쏅�れ뵠 true =占쎄텢占쎌뒠揶쏉옙占쎈뮟 , false =
  // 餓λ쵎�궗
  public boolean getIdByCheck(String id) {
    boolean result = true;
    try {
      pstmt = conn.prepareStatement("SELECT * FROM user WHERE id=?");
      pstmt.setString(1, id.trim());
      // �눧紐꾩쁽占쎈였占쎌뱽 占쎌뿯占쎌젾獄쏆룄援낉옙援� �눧紐꾩쁽占쎈였占쎌뱽 占쎈�燁살쥒瑗랃옙�뒭 揶쏉옙占쎄괴 占쎈쿈占쎈쑓占쎈씨占쎈뮉 �⑤벉媛싷옙�뵠 占쎈뎡占쎌뵬
      // 占쎈굶占쎈선占쎌궎�⑨옙 占쎈�占쎈빍占쎈뼄
      // trim()占쎌뵠占쎌뵬�⑥쥓彛� 占쎈쑅雅뚯눘�뻻筌롳옙, 占쎌뇢筌잛럩肉� 占쎌뿳占쎈뮉 �⑤벉媛�, 占쎌궎�몴紐꾠걹占쎈퓠 占쎌뿳占쎈뮉 �⑤벉媛싷옙�뱽 占쎈뼄
      // 占쎌젫椰꾧퀬鍮먧빳�씭�빍占쎈뼄.
      // 揶쏉옙占쎌뒲占쎈쑓 占쎌뿳占쎈뮉 �⑤벉媛싷옙占� 占쎌젫椰꾧퀬鍮먧틠�눘占쏙옙�뮉 占쎈륫占쎈뮸占쎈빍占쎈뼄. 揶쏉옙占쎌뒲占쎈쑓 占쎌뿳占쎈뮉 �⑤벉媛싷옙占�
      // replace占쎈맙占쎈땾�몴占� 占쎈쑅占쎄퐣 占쎌젫椰꾬옙.
      rs = pstmt.executeQuery();
      if (rs.next())
        result = false; // 占쎌쟿�굜遺얜굡揶쏉옙 鈺곕똻�삺占쎈릭筌롳옙 false

    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println(e + "占쎈르�눧紐꾨퓠  getIdByCheck() fail");
    }
    return result;

  } // getIdByCheck()
  // [�빊�뮇荑�] https://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140190267626

  // 嚥≪뮄�젃占쎌뵥 (占쎈툡占쎌뵠占쎈탵-占쎈솭占쎈뮞占쎌뜖占쎈굡 占쎌넇占쎌뵥) 疫꿸퀡�뮟
  public boolean loginCheck(String inputId, String inputPwd) {
    boolean result = false;
    try {
      stmt = conn.createStatement();
      String checkingStr = "SELECT pwd FROM user WHERE id='" + inputId + "'";
      ResultSet rs = stmt.executeQuery(checkingStr);
      int count = 0;
      while (rs.next()) {
        if (inputPwd.equals(rs.getString("pwd"))) {
          result = true;
          System.out.println("嚥≪뮄�젃占쎌뵥 占쎄쉐�⑨옙");
        } else {
          result = false;
          System.out.println("嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭");
        }
        count++;
      }
    } catch (Exception e) {
      result = false;
      System.out.println("嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭 > " + e.toString()); // 占쎌뿯占쎌젾 占쎈툡占쎌뵠占쎈탵揶쏉옙 db占쎈퓠 占쎈씨占쎌뱽
                                                               // 占쎈르.
    }
    return result;
  }

  // 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑤벏釉� 占쎄텢占쎌뿺占쎌벥 占쎌젟癰귣�諭억옙�뱽 �뵳�뗪쉘
  public LogInUser getLogInUserInfo(String logInUserId) {
    LogInUser logInUser = LogInUser.getInstance();
    try {
      stmt = conn.createStatement();
      String checkingStr = "SELECT * FROM user WHERE id='" + logInUserId + "'";
      rs = stmt.executeQuery(checkingStr);
      while (rs.next()) {
        if (logInUserId.equals(rs.getString("id"))) {
          // (1)嚥≪뮄�젃占쎌뵥 占쎄쉐�⑤벏釉� 占쎄텢占쎌뿺占쎌벥 占쎌젟癰귣�諭억옙�뱽 DB占쎈퓠占쎄퐣 �뇡遺얠쑎占쏙옙占쎄퐣
          String id = rs.getString("id");
          String pwd = rs.getString("pwd");
          String name = rs.getString("name");
          String address = rs.getString("address");
          String nick = rs.getString("nick");
          int phone = rs.getInt("phone");

          // (2)LogInUser 揶쏆빘猿쒙옙肉� 占쏙옙占쎌삢占쎈립 占쎌뜎 �뵳�뗪쉘
          logInUser.setId(id);
          logInUser.setPwd(pwd);
          logInUser.setName(name);
          logInUser.setAddress(address);
          logInUser.setNick(nick);
          logInUser.setPhone(phone);
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return logInUser;
  }


  public static void main(String[] args) {
    // UserDB userDB = new UserDB();
    // userDB.insert(id, pwd, name, address, nick, phone);
    // userDB.delete(占쎄텣占쎌젫占쎈릭占쎌젻占쎈뮉 筌롢끇苡�占쎌벥 id);

  }
}
