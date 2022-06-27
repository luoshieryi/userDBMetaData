package moe.gothiclolita.userdbmetadata.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    // union two lists
    public static <T> List<T> union(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.removeAll(list2);
        result.addAll(list2);
        return result;
    }

    public static <T> List<T> intersect(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.retainAll(list2);
        return result;
    }

    // divide two lists
    public static <T> List<T> divide(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.removeAll(list2);
        return result;
    }
}
