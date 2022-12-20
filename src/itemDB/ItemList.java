package itemDB;


// 일단 다 String으로 받고 필요하면 int로 전환하자
public class ItemList {
  String num;
  String id;
  String name;
  String price;
  String address;
  String content;
  String transaction;
  String love;
  String date;



  @Override
  public String toString() {
    return "ItemList [num=" + num + ", id=" + id + ", name=" + name + ", price=" + price
        + ", address=" + address + ", content=" + content + ", transaction=" + transaction
        + ", love=" + love + ", date=" + date + "]";
  }



  // 8개의 변수를 받는 생성자. id는 userDB를 통해 입력받아야 함.
  ItemList(String num, String id, String name, String price, String address, String content,
      String transaction, String love, String date) {
    super();
    this.num = num;
    this.id = id;
    this.name = name;
    this.price = price;
    this.address = address;
    this.content = content;
    this.transaction = transaction;
    this.love = love;
    this.date = date;

  }
}
