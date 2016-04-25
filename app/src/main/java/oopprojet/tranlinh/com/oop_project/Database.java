package oopprojet.tranlinh.com.oop_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tran Linh on 4/25/2016.
 */
public class Database extends SQLiteOpenHelper {

    // ten database
    public static final String DATABASE_NAME ="database.db";

    // bang San Pham
    public static final String TABLE_SP = "san_pham";
    public static final String SP_ID = "id_sanpham";
    public static final String SP_TEN = "ten_sanpham";

    // tao bang san pham
    public static final String CREATE_TABLE_SP ="CREATE TABLE" +TABLE_SP +"("+SP_ID+"INTEGER PRIMARY KEY AUTO INCREMENT NOT NULL,"+SP_TEN+"TEXT NOT NULL);";

    // bang Nhan Hieu
    public static final String TABLE_NH ="nhan_hieu";
    public static final String NH_ID = "id_nhanhieu";
    public static final String NH_TEN ="ten_nhanhieu";

    // tao bang Nhan Hieu
    public static final String CREATE_TABLE_NH ="CREATE TABLE" + TABLE_NH +"("+NH_ID+"INTEGER PRIMARY KEY AUTO INCREMENT NOT NULL,"+NH_TEN+"TEXT NOT NULL);";

    // bang Mo Ta
    public static final String TABLE_MT ="mo_ta";
    public static final String MT_ID ="id_mota";
    public static final String MT_MT ="mota";
    public static final String MT_TRANGTHAI ="trangthai";

    // tao bang Mo Ta
    public static final String CREATE_TABLE_MT ="CREATE TABLE"+TABLE_MT+"("+MT_ID+"INTEGER PRIMARY KEY AUTO INCREMENT NOT NULL,"+MT_MT+"TEXT NOT NULL, "+MT_TRANGTHAI+" TEXT NOT NULL);";
    // bang Danh Muc
    public static final String TABLE_DM ="danh_muc";
    public static final String DM_ID ="id_danhmuc";
    public static final String DM_DM ="danh_muc";

    //tao bang Danh Muc

    // bang Thuoc Tinh
    public static final String TABLE_TT ="thuoc_tinh";
    public static final String TT_ID_SP ="tt_id_sanpham";
    public static final String TT_ID_MT ="tt_id_mota";
    public static final String TT_ID_NHAN ="tt_id_nhanhieu";
    public static final String TT_ID_DM ="tt_id_danhmuc";
    public static final String TT_GIA ="tt_gia";
    public static final String TT_KC ="tt_kich_co";



    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
