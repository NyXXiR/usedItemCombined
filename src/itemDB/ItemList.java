package itemDB;


// 일단 다 String으로 받고 필요하면 int로 전환하자
public class ItemList {
  String id;
  String name;
  String price;
  String address;
  String content;
  String transaction;
  String like;
  String date;

  @Override
  public String toString() {
    return "ItemList [id=" + id + ", name=" + name + ", price=" + price + ", address=" + address
        + ", content=" + content + ", transaction=" + transaction + ", like=" + like + ", date="
        + date + "]";
  }

  // 7개의 변수를 받는 생성자. id는 userDB를 통해 입력받아야 함.
  ItemList(String id, String name, String price, String address, String content, String transaction,
      String like, String date) {
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.address = address;
    this.content = content;
    this.transaction = transaction;
    this.like = like;

  }
}
