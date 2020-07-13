import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyCollectionGeneral {
    private String[] arr;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void print(){
        System.out.println(Arrays.asList(arr));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
    }
}
