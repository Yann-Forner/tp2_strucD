public class Main {

    static int[] arrayOfInts = {0,1,2,3,4,5,6,7};

    static void change (int[] t){
        t[0] = 5;
    }
    public static void main(String[] args) {
        IntTab intTab = new IntTab(arrayOfInts);
        intTab.decalage(1,2,2);
        System.out.println(intTab.toString());

    }
}