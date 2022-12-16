package secondHand_site.userDB;

public class User { 
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String nick;
	private int phone;
	
	public User() {};
	public User(String id, String pwd, String name, String address, String nick, int phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.nick = nick;
		this.phone = phone;	
		
	}

	//setter
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	//getter
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getNick() {
		return nick;
	}
	public int getPhone() {
		return phone;
	}
	
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address + ", nick=" + nick
				+ ", phone=" + phone + "]";
	}

	
	

}
