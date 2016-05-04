package oopprojet.tranlinh.com.oop_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Tran Linh on 4/25/2016.
 */
public class Database extends SQLiteOpenHelper {
    SQLiteDatabase database = null;
//    Database data ;
    // ten database
    private static final String DATABASE_NAME ="database.db";

    // bang San Pham
    public static final String TABLE_SP = "san_pham";
    public static final String SP_ID = "id_sanpham";
    public static final String SP_TEN = "ten_sanpham";

    // tao bang san pham
    public static final String CREATE_TABLE_SP ="CREATE TABLE IF NOT EXISTS " +TABLE_SP +" ( "+SP_ID+" INTEGER PRIMARY KEY NOT NULL, "+SP_TEN+" TEXT NOT NULL) ";

    // bang Nhan Hieu
    public static final String TABLE_NH ="nhan_hieu";
    public static final String NH_ID = "id_nhanhieu";
    public static final String NH_TEN ="ten_nhanhieu";

    // tao bang Nhan Hieu
    public static final String CREATE_TABLE_NH ="CREATE TABLE IF NOT EXISTS " + TABLE_NH +" ( "+NH_ID+" INTEGER PRIMARY KEY NOT NULL, "+NH_TEN+" TEXT NOT NULL)";

    // bang Mo Ta
    public static final String TABLE_MT ="mo_ta";
    public static final String MT_ID ="id_mota";
    public static final String MT_MT ="mota";
    public static final String MT_TRANGTHAI ="trangthai";

    // tao bang Mo Ta
    public static final String CREATE_TABLE_MT ="CREATE TABLE IF NOT EXISTS "+TABLE_MT+" ( "+MT_ID+" INTEGER PRIMARY KEY NOT NULL, "+MT_MT+" TEXT NOT NULL, "+MT_TRANGTHAI+" TEXT NOT NULL)";

    // bang Danh Muc
    public static final String TABLE_DM ="danh_muc";
    public static final String DM_ID ="id_danhmuc";
    public static final String DM_DM ="danh_muc";

    //tao bang Danh Muc
    public static final String CREATE_TABLE_DM ="CREATE TABLE IF NOT EXISTS "+TABLE_DM+" ( "+DM_ID+" INTEGER PRIMARY KEY  NOT NULL, "+DM_DM+" TEXT NOT NULL)";
    // bang Thuoc Tinh
    public static final String TABLE_TT ="thuoc_tinh";
    public static final String TT_ID_SP ="id_sanpham";
    public static final String TT_ID_MT ="id_mota";
    public static final String TT_ID_NHAN ="id_nhanhieu";
    public static final String TT_ID_DM ="id_danhmuc";
    public static final String TT_GIA ="tt_gia";
    public static final String TT_KC ="tt_kich_co";

    // tao bang Thuoc Tinh


    public static final String CREATE_TABLE_TT ="CREATE TABLE IF NOT EXISTS " + TABLE_TT+ "( "+
                                TT_ID_SP+" INTEGER , "+
                                TT_ID_MT+" INTEGER , "+
                                TT_ID_NHAN+" INTEGER , "+
                                TT_ID_DM+" INTEGER , "+
                                TT_GIA+" INTEGER ,"+
                                TT_KC+" TEXT )";
    public static final int DATABASE_VERSION = 4;
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
//        data =new Database(this);
        db.execSQL(CREATE_TABLE_SP);
        db.execSQL(CREATE_TABLE_DM);
        db.execSQL(CREATE_TABLE_MT);
        db.execSQL(CREATE_TABLE_NH);
        db.execSQL(CREATE_TABLE_TT);
        Log.e("test", "onCreat");

//        data.doInsertInToDB();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NH);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_DM);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SP);
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_TT);

        // Recreate
        onCreate(db);
    }
    public void doInsertInToTableSP(int id,String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SP_ID, id);
        values.put(SP_TEN, name);

        db.insert(TABLE_SP, null, values);
        db.close();
    }

    public void doInsertInToTableMT(int id, String name,String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MT_ID,id);
        values.put(MT_MT, name);
        values.put(MT_TRANGTHAI, status);

        db.insert(TABLE_MT,null,values);

        db.close();
    }
    public void doInsertInToTableNH(int id, String name){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NH_ID,id);
        values.put(NH_TEN,name);


        db.insert(TABLE_NH,null,values);

        db.close();
    }

    public void doInsertInToTableDM(int id,String name){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DM_ID,id);
        values.put(DM_DM,name);


        db.insert(TABLE_DM,null,values);

        db.close();
    }

    public void doInsertInToTableTT(int idSp,int idMt,int idDm,int idNhan, int value, String size){
       SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TT_ID_SP,idSp);
        values.put(TT_ID_MT,idMt);
        values.put(TT_ID_DM,idDm);
        values.put(TT_ID_NHAN,idNhan);
        values.put(TT_GIA,value);
        values.put(TT_KC,size);



        db.insert(TABLE_TT, null, values);
        db.close();
    }



    public void doInsertInToDB(){

        doInsertInToTableDM(1,"Tivi");
        doInsertInToTableDM(2, "Tủ Lạnh");
        doInsertInToTableDM(3, "Máy Giặt");
        doInsertInToTableDM(4, "Điều Hòa");
        doInsertInToTableDM(5, "Audio");
        doInsertInToTableDM(6, "Máy Tính");
        doInsertInToTableDM(7, "Điện Thoại");

        doInsertInToTableNH(1, "SONY");
        doInsertInToTableNH(2, "SAMSUNG");
        doInsertInToTableNH(3, "LG");
        doInsertInToTableNH(4, "TOSIBA");
        doInsertInToTableNH(5, "ELECTROLUX");
        doInsertInToTableNH(6, "HITACHI");
        doInsertInToTableNH(7, "SANYO");
        doInsertInToTableNH(8, "DAIKIN");
        doInsertInToTableNH(9, "PANASONIC");
        doInsertInToTableNH(10, "LENOVO");
        doInsertInToTableNH(11, "HP");
        doInsertInToTableNH(12, "ACER");
        doInsertInToTableNH(13, "OPPO");
        doInsertInToTableNH(14, "APPLE");

        doInsertInToTableSP(1, "SONY 43W800C");              doInsertInToTableMT(1, "", "Tốt");
        doInsertInToTableSP(2, "SONY 32R300C");              doInsertInToTableMT(2, "", "Tốt");
        doInsertInToTableSP(3, "SONY 48W700C");              doInsertInToTableMT(3, "", "Mới");
        doInsertInToTableSP(4, "SAMSUNG 43J5500");           doInsertInToTableMT(4, "", "Khá Mới");
        doInsertInToTableSP(5, "SAMSUNG 32J4100");           doInsertInToTableMT(5, "", "Cũ");
        doInsertInToTableSP(6, "SAMSUNG 40J5500");           doInsertInToTableMT(6, "", "Khá Mới");
        doInsertInToTableSP(7, "SAMSUNG 48J5500");           doInsertInToTableMT(7, "", "Mới");
        doInsertInToTableSP(8, "SONY 43X8300C");             doInsertInToTableMT(8, "", "Tốt");
        doInsertInToTableSP(9, "LG 32LF550D");               doInsertInToTableMT(9, "", "Khá Tốt");    doInsertInToTableTT(9, 9, 1, 3, 5600000, "32");
        doInsertInToTableSP(10, "LG 49LF540T");              doInsertInToTableMT(10, "", "Khá Tốt");   doInsertInToTableTT(10, 10, 1, 3, 12600000, "49");

        doInsertInToTableSP(11, "TOSIBA S19VPP(S)");         doInsertInToTableMT(11, "", "Tốt");       doInsertInToTableTT(11, 11, 2, 4, 5590000, "S");
        doInsertInToTableSP(12, "TOSIBA S19VPP(DS)");        doInsertInToTableMT(12, "", "Mới");       doInsertInToTableTT(12, 12, 2, 4, 5790000, "XS");
        doInsertInToTableSP(13, "SAMSUNG RT43H5231SL/SV");   doInsertInToTableMT(13, "", "Khá Mới");   doInsertInToTableTT(13, 13, 2, 2, 6000000, "M");
        doInsertInToTableSP(14, "SAMSUNG RT50H6631SL/SV");   doInsertInToTableMT(14, "", "Khá Mới");   doInsertInToTableTT(14, 14, 2, 2, 7000000, "M");
        doInsertInToTableSP(15, "ELECTROLUX ETB2302PE");     doInsertInToTableMT(15, "", "Khá Tốt");   doInsertInToTableTT(15, 15, 2, 5, 5000000, "XXL");
        doInsertInToTableSP(16, "ELECTROLUX EME2600SA-RVN"); doInsertInToTableMT(16, "", "Mới");       doInsertInToTableTT(16, 16, 2, 5, 8000000, "XXXL");
        doInsertInToTableSP(17, "HITACHI V400PGV3");         doInsertInToTableMT(17, "", "Cũ");        doInsertInToTableTT(17, 17, 2, 6, 6341240, "M");
        doInsertInToTableSP(18, "SAMSUNG RT38FEAKDSL/SV");   doInsertInToTableMT(18, "", "Cũ");        doInsertInToTableTT(18, 18, 2, 2, 10000000, "XXXL");
        doInsertInToTableSP(19, "HITACHI VG470PGV3");        doInsertInToTableMT(19, "", "Mới");       doInsertInToTableTT(19, 19, 2, 6, 4900000, "M");
        doInsertInToTableSP(20, "SANYO SR-PQ285RB/SB");      doInsertInToTableMT(20, "", "Khá Mới");   doInsertInToTableTT(20, 20, 2, 7, 6000000, "S");
        doInsertInToTableSP(21, "SANYO SR-Q345RB/SS");       doInsertInToTableMT(21, "", "Mới");       doInsertInToTableTT(21, 21, 2, 7, 7000000, "XS");
        doInsertInToTableSP(22, "ELECREOLUX EBE3500SA");     doInsertInToTableMT(22, "", "Cũ");        doInsertInToTableTT(22, 22, 2, 5, 8000000, "XXS");

        doInsertInToTableSP(23, "SAMSUNG WW75J3283GS/SV");   doInsertInToTableMT(23, "", "Mới");       doInsertInToTableTT(23, 23, 3, 2, 4000000, "S");
        doInsertInToTableSP(24, "ELECTROLUX EWF85742");      doInsertInToTableMT(24, "", "Cũ");        doInsertInToTableTT(24, 24, 3, 5, 6020300, "M");
        doInsertInToTableSP(25, "TOSIBA E920LV(WL)");        doInsertInToTableMT(25, "", "Khá Tốt");   doInsertInToTableTT(25, 25, 3, 4, 5000000, "XS");

        doInsertInToTableSP(26, "DAIKIN FTNE35MV1V");        doInsertInToTableMT(26, "", "Tốt");       doInsertInToTableTT(26, 26, 4, 8, 4900000, "M");
        doInsertInToTableSP(27, "DAIKIN FTXM25HVMV");        doInsertInToTableMT(27, "", "Khá Tốt");   doInsertInToTableTT(27, 27, 4, 8, 8090000, "S");
        doInsertInToTableSP(28,"PANASONIC CU/CS-KC12QKH-8");doInsertInToTableMT(28, "", "Cũ");        doInsertInToTableTT(28, 28, 4, 9, 6000000, "M");
        doInsertInToTableSP(29, "DAIKIN FTXM35HVMV");        doInsertInToTableMT(29, "", "Tốt");       doInsertInToTableTT(29, 29, 4, 8, 6789283, "S");

        doInsertInToTableSP(30, "SAMSUNG HT-E350K");         doInsertInToTableMT(30, "", "Mới");       doInsertInToTableTT(30, 30, 5, 2, 7277738, "XS");
        doInsertInToTableSP(31, "SONY BDV-E6100");           doInsertInToTableMT(31, "", "Khá Mới");   doInsertInToTableTT(31, 31, 5, 1, 3092992, "L");
        doInsertInToTableSP(32, "SONY DAV-TZ150");           doInsertInToTableMT(32, "", "Khá Mới");   doInsertInToTableTT(32, 32, 5, 1, 3929900, "XXL");
        doInsertInToTableSP(33, "SAMSUNG HT-F453HRK");       doInsertInToTableMT(33, "", "Mới");       doInsertInToTableTT(33, 33, 5, 2, 8829391, "XXXL");
        doInsertInToTableSP(34, "SAMSUNG BDV-E2100");        doInsertInToTableMT(34, "", "Tốt");       doInsertInToTableTT(34, 34, 5, 2, 3129312, "XXL");

        doInsertInToTableSP(35, "LENOVO H3000ST");           doInsertInToTableMT(35, "", "Tốt");       doInsertInToTableTT(35, 35, 6, 10, 8000000, "XXS");
        doInsertInToTableSP(36, "HP 110-500x");              doInsertInToTableMT(36, "", "Mới");       doInsertInToTableTT(36, 36, 6, 11, 10000000, "L");
        doInsertInToTableSP(37, "HP 251-a20L");              doInsertInToTableMT(37, "", "Khá Mới");   doInsertInToTableTT(37, 37, 6, 11, 11000000, "XS");
        doInsertInToTableSP(38, "ACER XOESV 007");           doInsertInToTableMT(38, "", "Cũ");        doInsertInToTableTT(38, 38, 6, 12, 5000000, "S");
        doInsertInToTableSP(39, "ACER XoESV 009");           doInsertInToTableMT(39, "", "Mới");       doInsertInToTableTT(39, 39, 6, 12, 6000000, "S");

        doInsertInToTableSP(40, "SAMSUNG G935FD");           doInsertInToTableMT(40, "", "Tốt");       doInsertInToTableTT(40, 40, 7, 2, 5000000, "32");
        doInsertInToTableSP(41, "OPPO F1");                  doInsertInToTableMT(41, "", "Cũ");        doInsertInToTableTT(41, 41, 7, 13, 4000000, "40");
        doInsertInToTableSP(42, "OPPO A33w");                doInsertInToTableMT(42, "", "Khá Mới");   doInsertInToTableTT(42, 42, 7, 13, 3500000, "20");
        doInsertInToTableSP(43, "OPPO 1201");                doInsertInToTableMT(43, "", "Khá Tốt");   doInsertInToTableTT(43, 43, 7, 13, 5000000, "21");
        doInsertInToTableSP(44, "SONY Xperia E2353");        doInsertInToTableMT(44, "", "Mới");       doInsertInToTableTT(44, 44, 7, 1, 8000400, "50");
        doInsertInToTableSP(45, "APPLE IPHONE S5");         doInsertInToTableMT(45, "", "Tốt");       doInsertInToTableTT(45, 45, 7, 14, 20000000, "62");


        doInsertInToTableTT(1, 1, 1, 1, 13900000, "43");
        doInsertInToTableTT(2, 2, 1, 1, 5600000, "32");
        doInsertInToTableTT(3, 3, 1, 1, 15900000, "48");
        doInsertInToTableTT(4, 4, 1, 2, 12400000, "43");
        doInsertInToTableTT(5, 5, 1, 2, 6600000, "32");
        doInsertInToTableTT(6, 6, 1, 2, 10900000, "40");
        doInsertInToTableTT(7, 7, 1, 2, 15900000, "48");
        doInsertInToTableTT(8, 8, 1, 1, 20900000, "48");
    }



    public void createDefaultIfNeed(){
        int count = this.count();
        if(count == 0){
            this.doInsertInToDB();
        }
    }

    // SQL Query
    public int count(){
        String countQuery = "SELECT * FROM "+ TABLE_SP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);

        int count = cursor.getCount();

        cursor.close();
        return count;
    }
    public ArrayList<String> getSP(){
        ArrayList<String> a = new ArrayList<String>();
        String selectQuery ="SELECT "+SP_TEN+" FROM "+TABLE_SP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            if(cursor.getString(0)!=null){
                a.add(cursor.getString(0));
            }
            cursor.moveToNext();
        }
        db.close();
        return a;
    }
    public String getAllItem(String tuKhoa,String danhMuc, String nhanHieu,String kichCo,int giaDau,int giaCuoi, String trangThai){
//        List<SanPham> list = new ArrayList<SanPham>();
        Log.e("test","getAllitem");

        String selectQuery = "SELECT * FROM " + TABLE_SP +" NATURAL JOIN "+ TABLE_DM +" NATURAL JOIN "+ TABLE_MT +" NATURAL JOIN "+ TABLE_NH + " NATURAL JOIN " + TABLE_TT+ " WHERE";
        if(tuKhoa!=null){
            selectQuery += " "+TABLE_SP + "."+SP_TEN+" LIKE '%"+tuKhoa+"%'";
        }
//        if((danhMuc!=null) && (danhMuc.equals("Tât cả")==false)){
//            selectQuery += " AND "+TABLE_DM+"."+DM_DM+" = "+danhMuc;
//        }
        if((danhMuc != null) && (danhMuc.equals("Tất cả") == false)){
            selectQuery += " AND "+ TABLE_DM+"."+DM_DM+" ='"+danhMuc+"'";
            Log.e("danhmuc","danh muc");
        }
        if((nhanHieu != null) && (nhanHieu.equals("Tất cả") == false)){
            selectQuery += " AND "+ TABLE_NH+"."+NH_TEN+" ='"+nhanHieu+"'";
            Log.e("nhan hieu","nhan hieu");
        }
        if((kichCo != null) && (kichCo.equals("Tất cả") == false) ){
            selectQuery += " AND " + TABLE_TT+"."+TT_KC+" ='"+kichCo+"'";
        }
        if((giaDau!= -1) && (giaCuoi!=-1) && (giaDau <= giaCuoi)){
            selectQuery += " AND "+TABLE_TT+"."+TT_GIA+" BETWEEN  "+giaDau+"  AND  "+giaCuoi+" ";
        }
        if((trangThai != null) && (trangThai.equals("Tất cả") == false)){
            selectQuery += " AND "+TABLE_MT+"."+MT_TRANGTHAI+" ='"+trangThai+"'";
        }

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        String noiDung = "";
//        Log.e("sau noi dung","noi dung");
        while (cursor.isAfterLast()==false){
            noiDung+="Ten:";
            Log.e("test","cursor");
            noiDung+=cursor.getString(cursor.getColumnIndex(SP_TEN))+"\nDanh muc :"+cursor.getString(cursor.getColumnIndex(DM_DM))+"\nNhan hieu:"+cursor.getString(cursor.getColumnIndex(NH_TEN))+
                    "\nGia:"+cursor.getInt(cursor.getColumnIndex(TT_GIA))+"\nTrang thai:"+cursor.getString(cursor.getColumnIndex(MT_TRANGTHAI))+"\n----------------------------------------------\n";
            cursor.moveToNext();
        }
        db.close();


        return noiDung;
    }
    public ArrayList<String> getDM(String tuKhoa,String nhanHieu,String kichCo,int giaDau,int giaCuoi,String trangThai) {
        ArrayList<String> arrayList = new ArrayList<String>();

        String selectQuery = "SELECT DISTINCT " + DM_DM + " FROM " + TABLE_SP + " NATURAL JOIN " + TABLE_DM + " NATURAL JOIN " + TABLE_MT + " NATURAL JOIN " + TABLE_NH + " NATURAL JOIN " + TABLE_TT + " WHERE ";


        if (tuKhoa != null) {
            selectQuery += " " + TABLE_SP + "." + SP_TEN + " LIKE '%" + tuKhoa + "%' ";
        }
        if (!nhanHieu.equals("Tất cả")) {
            selectQuery += " AND  " + TABLE_NH + "." + NH_TEN + " = '" + nhanHieu + "' ";
        }
        if (!kichCo.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_TT + "." + TT_KC + " = '" + kichCo + "' ";
        }
        if ((giaDau != -1) && (giaDau < giaCuoi)) {
            selectQuery += " AND " + TABLE_TT + "." + TT_GIA + " BETWEEN " + giaDau + " AND " + giaCuoi + " ";
        }
        if (!trangThai.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_MT + "." + MT_TRANGTHAI + " ='" + trangThai+"'";
        }

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(0) != null) {
                arrayList.add(cursor.getString(0));
            }
            cursor.moveToNext();
        }
        db.close();
        return arrayList;
    }
    public ArrayList<String> getNH(String tuKhoa,String danhMuc,String kichCo,int giaDau,int giaCuoi,String trangThai) {
        ArrayList<String> arrayList = new ArrayList<String>();

        String selectQuery = "SELECT DISTINCT " + NH_TEN + " FROM " + TABLE_SP + " NATURAL JOIN " + TABLE_DM + " NATURAL JOIN " + TABLE_MT + " NATURAL JOIN " + TABLE_NH + " NATURAL JOIN " + TABLE_TT + " WHERE ";


        if (tuKhoa != null) {
            selectQuery += " " + TABLE_SP + "." + SP_TEN + " LIKE '%" + tuKhoa + "%'  ";
        }
        if (!danhMuc.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_DM + "." + DM_DM + " = '" + danhMuc + "' ";
        }
        if (!kichCo.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_TT + "." + TT_KC + " = '" + kichCo + "' ";
        }
        if ((giaDau != -1) && (giaDau < giaCuoi)) {
            selectQuery += " AND " + TABLE_TT + "." + TT_GIA + " BETWEEN " + giaDau + "  AND  " + giaCuoi + "  ";
        }
        if (!trangThai.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_MT + "." + MT_TRANGTHAI + " = '" + trangThai+"'";
        }

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(0) != null) {
                arrayList.add(cursor.getString(0));
            }
            cursor.moveToNext();
        }
        db.close();
        return arrayList;
    }

    public ArrayList<String> getKC(String tuKhoa,String nhanHieu,String danhMuc,int giaDau,int giaCuoi,String trangThai) {
        ArrayList<String> arrayList = new ArrayList<String>();

        String selectQuery = "SELECT DISTINCT " + TT_KC + " FROM " + TABLE_SP + " NATURAL JOIN " + TABLE_DM + " NATURAL JOIN " + TABLE_MT + " NATURAL JOIN " + TABLE_NH + " NATURAL JOIN " + TABLE_TT + " WHERE ";


        if (tuKhoa != null) {
            selectQuery += " " + TABLE_SP + "." + SP_TEN + " LIKE '%" + tuKhoa + "%'  ";
        }
        if (!nhanHieu.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_NH + "." + NH_TEN + " = '" + nhanHieu + "' ";
        }
        if (!danhMuc.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_DM + "." + DM_DM + " = '" + danhMuc + "' ";
        }
        if ((giaDau != -1) && (giaDau < giaCuoi)) {
            selectQuery += " AND " + TABLE_TT + "." + TT_GIA + " BETWEEN " + giaDau + "  AND  " + giaCuoi + "  ";
        }
        if (!trangThai.equals("Tất cả")) {
            selectQuery += " AND " + TABLE_MT + "." + MT_TRANGTHAI + " = '" + trangThai+"'";
        }

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(0) != null) {
                arrayList.add(cursor.getString(0));
            }
            cursor.moveToNext();
        }
        db.close();
        return arrayList;
    }


}

