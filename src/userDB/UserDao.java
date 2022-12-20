package secondHand_site.userDB;

import java.sql.*;
import java.util.ArrayList;


public class UserDao {
  public Connection conn = null;
  public ResultSet rs = null;
  public PreparedStatement pstmt = null;

  public UserDao() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("드라이버 설치");
      String url = "jdbc:mysql://172.30.1.11:3306/thisisjava";
      String id = "java";
      String pwd = "mysql";
      conn = DriverManager.getConnection(url, id, pwd);
      System.out.println("접속 성공");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  void dbClose() {
    if (rs != null)
      try {
        rs.close();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    if (pstmt != null) {
      try {
        pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  // userDB -> userList(ArrayList)에 집어넣기
  public ArrayList<User> fromUserDbToUserList() {
    ArrayList<User> userList = new ArrayList<User>();
    String sql = "select * from userDB";
    try {
      pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5), rs.getInt(6));
        userList.add(user);
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage() + "=> insertUserList() fail");
      e.printStackTrace();
    } finally {
      dbClose();
    }
    return userList;
  }

  public int insertUserDB(User newUser) {
    int result = 0;
    String sql = "" + "INSERT INTO userDB(id, pwd, name, address, nick, phone) "
        + "VALUES (?, ?, ?, ?, ?,?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, newUser.getId());
      pstmt.setString(2, newUser.getPwd());
      pstmt.setString(3, newUser.getName());
      pstmt.setString(4, newUser.getAddress());
      pstmt.setString(5, newUser.getNick());
      pstmt.setInt(6, newUser.getPhone());
      result = pstmt.executeUpdate();
      System.out.println(result + "건 입력 성공");
    } catch (SQLException e) {
      System.out.println(e.getMessage() + "=> insert() fail");
      e.printStackTrace();
    } finally {
      dbClose();
    }
    return result;
  }

  // 정보수정.
  // id가 키 값. 나머지는 변경 값. (id는 변경불가)
  public int updateUserDB(User user) {
    int result = 0;
    String sql = "UPDATE userDB SET pwd=?, name=?, address=?, nick=?, phone=? WHERE id=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, user.getPwd());
      pstmt.setString(2, user.getName());
      pstmt.setString(3, user.getAddress());
      pstmt.setString(4, user.getNick());
      pstmt.setInt(5, user.getPhone());
      pstmt.setString(6, user.getId());
      result = pstmt.executeUpdate();
      System.out.printf("%s의 자료를 %d건 수정", user.getId(), result);
    } catch (SQLException e) {
      System.out.println(e.getMessage() + "=> update() fail");
    } finally {
      dbClose();
    }
    return result;
  }

  // delete메소드 : 멤버DB에서 멤버 삭제, 회원탈퇴
  public int deleteUserDB(String inputId) {
    int result = 0;
    try {
      String sql = "delete from userDB where id=? ";
      pstmt = conn.prepareStatement(sql);
      result = pstmt.executeUpdate();
      System.out.printf("%s의 자료를 %d건 삭제", inputId, result);
    } catch (SQLException e) {
      System.out.println(e.getMessage() + "=> delete() fail");
      e.printStackTrace();
    } finally {
      dbClose();
    }
    return result;
  }

  // Id중복체크
  // 매개변수로 들어온 id에 해당하는 레코드 검색하여 중복여부 체크하기. 리턴값이 true =사용가능 , false = 중복
  public boolean getIdByCheck(String inputId) {
    boolean result = true;
    try {
      pstmt = conn.prepareStatement("SELECT id FROM userDB WHERE id=?");
      pstmt.setString(1, inputId.trim());
      rs = pstmt.executeQuery();
      if (rs.next())
        result = false; // 레코드가 존재하면 false
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println(e + "=> getIdByCheck() fail");
    } finally {
      dbClose();
    }
    return result;
  } // getIdByCheck()
  // [출처] https://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140190267626

  // 로그인(아이디-패스워드 확인) 기능
  public boolean logInCheck(String inputId, String inputPwd) {
    boolean result = false;
    try {
      String checkingStr = "SELECT pwd FROM userDB WHERE id=?";
      pstmt = conn.prepareStatement(checkingStr);
      pstmt.setString(1, inputId.trim());
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        if (inputPwd.equals(rs.getString("pwd"))) {
          result = true; // 로그인 성공
        } else {
          result = false; // 로그인 실패
        }
      }
    } catch (Exception e) {
      result = false;
      System.out.println("로그인 실패 > " + e.toString()); // 입력 아이디가 db에 없을 때.
    } finally {
      dbClose();
    }
    return result;
  }

  // 로그인 성공한 사람의 정보들을 리턴
  public User getLogInUserInfo(String inputId) {
    User logInUser = new User();
    try {
      String checkingStr = "SELECT * FROM userDB WHERE id = ?";
      pstmt = conn.prepareStatement(checkingStr);
      pstmt.setString(1, inputId.trim());
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        if (inputId.equals(rs.getString("id"))) {
          // (1)로그인 성공한 사람의 정보들을 DB에서 블러와서
          String id = rs.getString("id");
          String pwd = rs.getString("pwd");
          String name = rs.getString("name");
          String address = rs.getString("address");
          String nick = rs.getString("nick");
          int phone = rs.getInt("phone");

          // (2)LogInUser 객체에 저장한 후 리턴
          logInUser.setId(id);
          logInUser.setPwd(pwd);
          logInUser.setName(name);
          logInUser.setAddress(address);
          logInUser.setNick(nick);
          logInUser.setPhone(phone);
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage() + "=> getLogInUserInfo() fail");
      e.printStackTrace();
    } finally {
      dbClose();
    }
    return logInUser;
  }


}
