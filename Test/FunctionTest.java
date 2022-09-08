import com.learning.controller.HubSpot;
import com.learning.controller.Mission;
import com.learning.datamodel.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FunctionTest {
    public static void main(String[] args) {
        Item item1 = new Item();
        HubSpot hub = new HubSpot();
        hub.getLookAround();
        hub.addToInventory();
        // Test reading JSON file and retrieve info.
//        item1.setItemCalledOut("boots");
//        item1.readItemFile();
//        System.out.println(item1.getItemCalledOut());
//        item1.showItemCard();
//        System.out.println(item1.getItemName());

//        System.out.println(item1.getItemDict());







        }




}
