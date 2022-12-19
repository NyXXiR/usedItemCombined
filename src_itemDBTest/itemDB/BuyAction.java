package itemDB;

public class BuyAction extends ItemDB {
  ItemDB itemDB = new ItemDB();
  // 클릭된 itemList


  // 판매된 itemDB의 행 soldItemDB에 추가 > itemDB 행 삭제

  // String column = null;
  // soldItemDB.insertData(column);

  // 특정한 행의 데이터를 가져와서 복제하고 기존 행을 삭제.


  // Jtable 만들어서 클릭리스너 받게 하고
  // 클릭하면 해당 행의 primary key 받아오게 하는 메소드 만들고
  // 해당 메소드로 끌어온 key에 해당하는 행을 soldItemDB에 복제
  // 해당 메소드로 끌어온 key에 해당하는 행을 ItemDB에서 삭제
  BuyAction(String num) {
    // id = item

    // 뭐뭐순 뭐뭐순 정렬ㄹ
    //
    //
    // 난 뭘 하고 싶지?
    //
    // 클릭을 하면
    // soldDB에 같은 행을 insert하고 싶다
    // itemDB에서 같은 행을 delete하고 싶다
    //
    // num은 고유값이다. primary key다
    //
    // 그러면 클릭했을때 num값을 구해두면
    //
    // 얘를 기준으로 복제 삭제를 할수 있겠다
    //
    //
    // 구했다
    //
    //
    // 복제 먼저 해야된다
    // 그러면 클릭한 전체 행을 일단 select해야되네?
    // 내가구하려는 문자열x = {select * from itemDB where num = 구한값}
    //
    // soldDB에 x를 넣어주면됨.
    //
    // insert into solditemDB values { x}
    //
    // delete * from itemDB where num= 구한값

.num..num.....num..
  }

}
