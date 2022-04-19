import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class My {
    public static void main(String[] args) {
        try {
            Object o = new Object();
            String string = new String();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test
    void kkcne() {
        System.out.println("aa = ");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1111xx");
        arrayList.add("1111xx");
        arrayList.add("1111xx");
        arrayList.add("1111xx");
        arrayList.add("1111xx");
        for (java.lang.String s : arrayList) {
            System.out.println("s = " + s);
        }
        String format = new SimpleDateFormat("yyyy=MM=dd").format(new Date());
    }
}
