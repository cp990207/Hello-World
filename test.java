package list;
public class test {
    public static void main(String[] args){
        Integer[] a={1,2,3,4,5,6,7};
        CirDoublyList<Integer> test=new CirDoublyList<Integer>(a);
        Integer[] b={1,2,3};
        CirDoublyList<Integer> test2=new CirDoublyList<Integer>(b);
        System.out.println(test.toPreviousString());
        test.removeAll(test2);
        System.out.println(test.toPreviousString());
    }
}
