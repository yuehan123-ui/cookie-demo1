package homeWrok_2;

import java.util.HashMap;
import java.util.Map;

public class CityDB {


    private static  Map<String,String[]> map = new HashMap<>();

    public static String init() {
        map.clear();
        String name="河南";
        String h_cities_str = "郑州市、开封市、洛阳市、平顶山市 、焦作市、鹤壁市 、新乡市 、安阳市 、濮阳市 、许昌市 、漯河市 、三门峡市 、南阳市 、商丘市 、信阳市 、周口市 、驻马店市 、济源市";
        String[] h_cities = h_cities_str.split("、");
        map.put(name, h_cities);

        for(String str :h_cities) {
            String[] strs = new String[5];
            for(int i=0;i<strs.length;i++) {
                strs[i] = str+"_"+i;
            }
            map.put(str, strs);
        }
        return name;
    }

    public static String[] getByName(String name) {
        String[] str = map.get(name);
        if(null == str) {
            str = new String[5];
            for(int i=0;i<str.length;i++) {
                str[i] = name+"_"+i;
            }
            map.put(name, str);
        }
        return str;
    }
}
