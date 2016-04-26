package oopprojet.tranlinh.com.oop_project;

/**
 * Created by luatnguyen88 on 4/26/2016.
 */
public class XuLy {
    public int[] CatXau(String xau){
        char[] temp = new char[xau.length()];
        int i=0,k=0;
        int[] gia = new int[2];
        gia[0]=gia[1]=-1;
        xau = xau.replaceAll(" ","");
        char[] charXau = xau.toCharArray();
        while(charXau[i]=='-'||i==xau.length()-1){
            temp[i]=charXau[i];
            i++;
        }
        gia[0]=ChuyenGia(temp);
        while (i==xau.length()-1){
            temp[k]=charXau[i];
            i++;k++;
        }
        gia[1]=ChuyenGia(temp);
        return gia;
    }
    public int ChuyenGia(char[] xau){
        char[] temp = new char[xau.length];
        String gia;
        if(xau[xau.length-1]=='k'||xau[xau.length-1]=='m'){
            for(int i=0;i<xau.length-1;i++){
                temp[i]=xau[i];
            }
            gia = temp.toString();
            if(xau[xau.length-1]=='k'){
                return Integer.parseInt(String.valueOf(temp))*1000;
            }
            else
                return  Integer.parseInt(String.valueOf(temp))*10000;
        }
        gia = xau.toString();
        return Integer.parseInt(gia);
    }
}
