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
//    public SanPham(String tuKhoa,String danhMuc,String nhanHieu,String kichCo,String trangThai){
//        this.tuKhoa = tuKhoa;
//        this.danhMuc = danhMuc;
//        this.kichCo = kichCo;
//        this.nhanHieu = nhanHieu;
////        this.Gia = Gia;
//        this.trangThai = trangThai;
//    }


    public String getTuKhoa(){
        return this.tuKhoa;
    }
    public void setTuKhoa(String tuKhoa){
        this.tuKhoa = tuKhoa;
        return;
    }

    public String getDanhMuc(){
        return this.danhMuc;
    }
    public void setDanhMuc(String danhMuc){
        this.danhMuc = danhMuc;
    }

    public String getNhanHieu(){
        return this.nhanHieu;
    }
    public void setNhanHieu(String nhanHieu){
        this.nhanHieu = nhanHieu;
        return;
    }

    public  String getKichCo(){
        return this.kichCo;
    }
    public void setKichCo(String kichCo){
        this.kichCo = kichCo;
        return;
    }

    public int getGia(){
        return this.Gia;
    }
    public void setGia(int gia) {
        this.Gia = gia;
    }

    public String getTrangThai() {
        return this.trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
