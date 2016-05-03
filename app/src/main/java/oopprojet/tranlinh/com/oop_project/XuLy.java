package oopprojet.tranlinh.com.oop_project;

import android.util.Log;

/**
 * Created by luatnguyen88 on 4/26/2016.
 */
public class XuLy {
//    public int[] CatXau(String xau){
//        char[] temp = new char[xau.length()];
//        int i=0,k=0;
//        int[] gia = new int[2];
//        gia[0]=gia[1]=-1;
//        xau = xau.replaceAll(" ","");
//        if(xau.equals(""))return gia;
//        char[] charXau = xau.toCharArray();
//        while(charXau[i]=='-'||i==xau.length()-1){
//            temp[i]=charXau[i];
//            i++;
//        }
//        Log.e("gia",String.copyValueOf(charXau));
//        Log.e()
//        gia[0]=ChuyenGia(temp);
//        while (i==xau.length()-1){
//            temp[k]=charXau[i];
//            i++;k++;
//        }
//        gia[1]=ChuyenGia(temp);
//        return gia;
//    }
//    public int ChuyenGia(char[] xau){
//        int length = xau.length;
//        char[] temp = new char[length];
//        int gia = 10;
//        if(xau[length-1]=='k'||xau[length-1]=='m'){
//            for(int i=0;i<xau.length-1;i++){
//                temp[i]=xau[i];
//            }
////            gia = temp.toString();
//            if(xau[xau.length-1]=='k'){
//                Log.e("test","test");
//                return Integer.parseInt(String.valueOf(temp))*1000;
//            }
//            else
//                return  Integer.parseInt(String.valueOf(temp))*10000;
//        }
//
//
//
//
//        gia = Integer.parseInt(new String(xau));
//        return gia;
////        return 100;
//    }
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
        switch (string.charAt(string.length() - 1)) {
            case 'k':
                string = string.substring(0, string.length() - 1) + "000";
                break;
            case 'm':
                string = string.substring(0, string.length() - 1) + "000000";
                break;
        }
        return Integer.parseInt(string);
    }
}
