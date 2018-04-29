package application;

public class Elem {
    private String str;
    private int count;

    public Elem(char  chr){
        this.str = "" + chr;
        this.count = 1;
    }

    public Elem(String str){
        this.str = str;
        this.count = 1;
    }

    public Elem(String str, int count){
        this.str = str;
        this.count = count;
    }

    public String getStr(){
        return this.str;
    }

    public int getCount(){
        return count;
    }

    public void increaseCount(){
        this.count++;
    }

    public String getDecoded() {
        String s = "";
        for(int i=0; i<count; i++) {
            s = s + this.str;
        }
        return s;
    }

    public String getEncoded() {
        return this.str + this.count;
    }
}
