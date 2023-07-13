import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class practice {
    @DataProvider(name = "data-provider")
    public Object[][] dpmethod(){
        return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }

    @DataProvider(name = "Using HashMap")
    public Object[][] abcdef(){
        HashMap<Object,Object> hm = new HashMap<>();
        hm.put("first one","is first one");
        hm.put("second one","is second one");
        return new Object[][]{{hm}};
    }

    @Test(dataProvider = "data-provider")
    public void myTest(String val){
        System.out.println("value is "+val);
    }

    @Test(dataProvider = "Using HashMap")
    public void myTesthm(HashMap<Object,Object> hmhs){
        System.out.println("value is "+hmhs.get("first one"));
        System.out.println("value is "+hmhs.get("second one"));
    }

}
