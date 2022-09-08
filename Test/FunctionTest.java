import com.learning.controller.Mission;
import com.learning.datamodel.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FunctionTest {
    public static void main(String[] args) {
        Item item1 = new Item();

//        item1.showItemCard();

        item1.setItemCalledOut("");
        System.out.println(item1.getItemCalledOut());
//        System.out.println(item1.getItemName());

        item1.readItemFile();
        item1.showItemCard();
        System.out.println(item1.getItemName());
                System.out.println(item1.getItemDict());
        };

//        item1.itemCalledOut = "fuel";
//        System.out.println(item1.itemCalledOut);
//        item1.showItemCard(item1.getItemCalledOut());
//        item1.parseItemObject((JSONObject) item1);
//        item1.backpackList.add(item1.itemCalledOut); TODO not working for some reason.
//        System.out.println("Your list has" + item1.backpackList + item1.itemCalledOut);
//        System.out.println(item1.getItemName());
//        System.out.println(item1.getItemLocationList());
//        System.out.println(item1.getItemLocationList().get("start"));


}
