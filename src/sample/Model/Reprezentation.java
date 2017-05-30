package sample.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TeTorro on 30.05.2017.
 */
public final class Reprezentation {
    private static String res;
    public final static List<String> convertToReprezentation(String input){
         return new ArrayList<>(Arrays.asList(input.split("(?<=\\G.{120})")));
    }

    public final static  String toResult(List<String> input){
        res = "";
        input.forEach(b -> res += b + "\n");
        return res;
    }
}
