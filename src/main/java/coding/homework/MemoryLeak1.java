package coding.homework;



import jdk.internal.net.http.common.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class MemoryLeak1 {
    public static List<Double> list=new ArrayList<>();

    public void getList(){
        for (int i = 0; i < 10000000; i++) {
            Random random=new Random();
            list.add(random.nextDouble());
        }
        Logger.getLogger("****Executed Methods***");
        Log.logError("Error");
//        Log.info("Log inside method the list");

    }
    public static void main(String[] args) {
//        Log.info("Log before generating the list");
        new MemoryLeak1().getList();
//        Log.info("Log after generating the list");
    }


}





