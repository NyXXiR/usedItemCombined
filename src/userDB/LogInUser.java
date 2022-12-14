package userDB;

public class LogInUser { // 占쎈뼓疫뀐옙占쎈꽑 揶쏆빘猿� 243p.
  private static LogInUser logInUser = new LogInUser();
  private String id;
  private String pwd;
  private String name;
  private String address;
  private String nick;
  private int phone;

  private LogInUser() {}

  public static LogInUser getInstance() {
    return logInUser;
  }


  // 揶쏉옙 占쎌젟癰귨옙 getter,setter 筌롫뗄�꺖占쎈굡
  public String getId() {
    return id;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  public void setId(String id) {
    this.id = id;
  }



}
