package oopprojet.tranlinh.com.oop_project;

import android.text.Editable;

/**
 * Created by luatnguyen88 on 4/26/2016.
 */
public class SanPham {
    private String tuKhoa;
    private String danhMuc;
    private String nhanHieu;
    private String kichCo;
    private int Gia;
    private String trangThai;
    public SanPham(String tuKhoa,String danhMuc,String nhanHieu,String kichCo,String trangThai){
        this.tuKhoa = tuKhoa;
        this.danhMuc = danhMuc;
        this.kichCo = kichCo;
        this.nhanHieu = nhanHieu;
//        this.Gia = Gia;
        this.trangThai = trangThai;
    }


    public String getTuKhoa(){
        return this.tuKhoa;
    }
    public String getDanhMuc(){
        return this.danhMuc;
    }
    public String getNhanHieu(){
        return this.nhanHieu;
    }
    public  String getKichCo(){
        return this.kichCo;
    }
    public int getGia(){
        return this.Gia;
    }
    public String getTrangThai(){
        return this.trangThai;
    }
}
