package oopprojet.tranlinh.com.oop_project;

import android.util.Log;

/**
 * Created by luatnguyen88 on 4/26/2016.
 */
public class XuLy {

public int[] CatXau(String xau){
    int[] gia = new int[2];
    if(xau.length()==0){
        gia[0]=gia[1]=-1;
        return gia;
    }
    String gia1 = cutBefore(xau);
    String gia2 = cutAfter(xau);
    gia[0]=convertToInteger(gia1);
    gia[1]=convertToInteger(gia2);
    return gia;

}
public String cutAfter (String string) {
    for (int i = 0 ; i < string.length() ; i++) {
        if ("-".compareTo(String.valueOf(string.charAt(i))) == 0) {
            return string.substring(i + 1);
        }
    }
    return string;
}

    public String cutBefore (String string) {
        for (int i = 0 ; i < string.length() ; i++) {
            if ("-".compareTo(String.valueOf(string.charAt(i))) == 0) {
                return string.substring(0, i);
            }
        }
        return string;
    }

    public int convertToInteger (String string) {
//        switch (string.charAt(string.length() - 1)) {
//            case 'k':
//                string = string.substring(0, string.length() - 1) + "000";
//                break;
//            case 'm':
//                string = string.substring(0, string.length() - 1) + "000000";
//                break;
//        }
        Character temp = string.charAt(string.length()-1);
        if(temp =='k'){
            string = string.substring(0,string.length()-1)+"000";
        }
        else if(temp =='m'){
            string = string.substring(0,string.length()-1)+"000000";
        }
        else if(temp == '0'||temp=='1'||temp=='2'||temp=='3'||temp=='4'||temp=='5'||temp=='6'||temp=='7'||temp=='8'||temp=='9'){
            string = string.substring(0,string.length()-1);
        }
        else{
            Log.e("test","-1-1-1-1-1");
            string = String.valueOf("-1");

        }
        return Integer.parseInt(string);
    }
}
