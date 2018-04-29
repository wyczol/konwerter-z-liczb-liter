package application;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Codec {

    private ArrayList<Elem> elemArrayList;
    

    public String encode(String plainText) {
        String encodedStr;

        listFromPlain(plainText);
        encodedStr = "";
        for (Elem elem:elemArrayList) {
            if (encodedStr != "")
                encodedStr = encodedStr + ",";

            encodedStr = encodedStr + elem.getEncoded();
        }

        return encodedStr;
    }

    public String decode(String encodedText) {
        String plainStr;

        listFromEncoded(encodedText);
        plainStr = "";
        for (Elem elem:elemArrayList) {
            plainStr = plainStr + elem.getDecoded();
        }

        return plainStr;

    }

    private void listFromEncoded(String encodedText){
        String[] partsEncoded = encodedText.split(Pattern.quote(",")) ;
        this.elemArrayList = new ArrayList<>();

        for(String chrAndCount:partsEncoded){
            String s = "" + chrAndCount.charAt(0);
            Integer cnt = new Integer(chrAndCount.substring(1));

            this.elemArrayList.add(new Elem(s, cnt));
        }
    }

    private void listFromPlain(String plainText) {
        this.elemArrayList = new ArrayList<>();

        for (int i = 0; i < plainText.length(); i++) {
            boolean found = false;

            //1st character just add to list and skip to next one
            if (i == 0) {
                this.elemArrayList.add(new Elem(plainText.charAt(i)));
                continue;
            }

            String str = "" + plainText.charAt(i);
            found = false;
            for (Elem e:elemArrayList) {
                if (e.getStr().equals(str)) {
                    e.increaseCount();
                    found = true;
                    break;
                }
            }
            if (found == false)
                this.elemArrayList.add(new Elem(plainText.charAt(i)));
        }

    }
}