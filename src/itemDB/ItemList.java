package itemDB;


// �ϴ� �� String���� �ް� �ʿ��ϸ� int�� ��ȯ����
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



  // 8���� ������ �޴� ������. id�� userDB�� ���� �Է¹޾ƾ� ��.
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
