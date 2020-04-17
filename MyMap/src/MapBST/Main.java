package MapBST;

import MyMapInterface.MyMap;

public class Main {
    public static void main(String[] args) {
        MyMap map = new MapBST();
        for (int i = 0; i < 5; i++) {
            map.add(i, i + 10);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(map.get(i));
        }
    }
}
