import java.util.Arrays;

public class IntTab {
    private final int emptyElement = 0;
    private static final int MAX_SIZE =  10000;
    int[] tab = new int[MAX_SIZE] ;
    int size;

    public IntTab() {
       size=0;
    }

    public IntTab(int size) {
        this.size = size;
        for (int i = 0; i < size ; i++) {
            tab[i] = emptyElement;
        }
    }
    public IntTab(int size,int e) {
        this.size = size;
        for (int i = 0; i < size ; i++) {
            tab[i] = e;
        }
    }
    public IntTab(int[] tab){
        for (int i = 0; i < tab.length ; i++) {
            this.tab[i] = tab[i];
        }
        size= tab.length;
    }

    public int getSize() {
        return size;
    }

    public int get(int i ){
        if(i >= size)return this.emptyElement;
        return tab[i];
    }
    public boolean set(int data, int i){
        if(i >= size)return false;
        tab[i] = data;
        return true;
    }
    public boolean addLast(int e){
        if (this.size+1< MAX_SIZE){
            size = size+1;
            tab[size-1]=e;
            return true;
        }return false;
    }
    public boolean resize(int s){
        if (s>MAX_SIZE)return false;
        if (s>size){
            for (int i = size; i < s ; i++) {
                tab[i]=this.emptyElement;
            }
            size=s;
            return true;

        }
        else if(s<size){
            size=s;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String myString = "IntTab  ";
        for (int i = 0; i < this.size; i++) {
            myString = myString+ ", " + get(i);
        }
        return myString;
    }

    public boolean insert(int data, int i){
        if(size+1 <MAX_SIZE && i <= this.size){
            size = size+1;
            for (int j = this.size-1; j > i ; --j) {
                tab[j] = tab[j-1];
            }
            set(data,i);
            return true;
        }
        return false;
    }
    public boolean remove(int i){
        if (i<this.size){
            for (int j = i; j <this.size ; j++) {
                tab[j] = tab[j+1];
            }
            --this.size;
            return true;

        }
        return false;
    }
    public boolean decalage(int deb, int nb , int dec){
        if(deb+nb+dec<=this.size){
            IntTab intTabTemp  = new IntTab(0);
            for (int i = 0; i < nb ; i++) {
                intTabTemp.addLast(get(deb));
                remove(deb);
            }
            System.out.println(intTabTemp);
            int decalage = deb+dec;
            for (int i = 0; i <intTabTemp.getSize() ; i++) {
                this.insert(intTabTemp.get(i),decalage);
                ++decalage;
            }
            return true;
        }
        return false;
    }

}