package sample.Model.Huffman;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by TeTorro on 30.05.2017.
 */
public final class RotationMap {
    private static final Map<String, String> prevA = new Hashtable<String,String>()
    {{
       put("0","C");
       put("1","G");
       put("2","T");
    }};
    private static final Map<String, String> prevC = new Hashtable<String,String>()
    {{
        put("0","G");
        put("1","T");
        put("2","A");
    }};
    private static final Map<String, String> prevG = new Hashtable<String,String>()
    {{
        put("0","T");
        put("1","A");
        put("2","C");
    }};
    private static final Map<String, String> prevT = new Hashtable<String,String>()
    {{
        put("0","A");
        put("1","C");
        put("2","G");
    }};

    private static  final Map<String, Map<String, String>> rotatyMap = new HashMap<String, Map<String, String>>()
    {{
        put("A", prevA);
        put("T", prevT);
        put("C", prevC);
        put("G", prevG);
    }};


    public final static String getValue(String terenaryDigit, String previousBase){
        return rotatyMap.get(previousBase).get(terenaryDigit);
    }
}
