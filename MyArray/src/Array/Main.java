package Array;


public class Main {
    public static void main(String[] args) {
        //基本类型测试
        Array<Integer> arrayInt = new Array<Integer>();
        for (int i = 0; i < 15; i++) {
            arrayInt.addLast(i);
        }
        arrayInt.add(0, 100);
        arrayInt.addFirst(105);
        arrayInt.addLast(1005);
        for (int i = 0; i < arrayInt.getLength(); i++) {
            System.out.print(arrayInt.get(i) + "    ");
        }
        System.out.println();
        arrayInt.remove(3);
        arrayInt.removeElement(1005);
        arrayInt.removeLast();
        arrayInt.removeFirst();
        for (int i = 0; i < arrayInt.getLength(); i++) {
            System.out.print(arrayInt.get(i) + "    ");
        }

//        // 自定义数据类型测试
//        Array<Student> studentArray = new Array<Student>(2);
//        for (int i = 0; i < 8; i++) {
//            studentArray.addLast(new Student("Tom", 18 + i));
//        }
//        studentArray.addFirst(new Student("Tom", 8));
//        studentArray.add(0, new Student("Tom", 80));
//        for (int i = 0; i < studentArray.getLength(); i++) {
//            System.out.println(studentArray.get(i));
//        }
    }
}
