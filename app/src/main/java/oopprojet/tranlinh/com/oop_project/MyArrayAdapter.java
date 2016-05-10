package oopprojet.tranlinh.com.oop_project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tran Linh on 5/6/2016.
 */
//custom listview search
public class MyArrayAdapter extends ArrayAdapter<SanPham> {
    Activity context = null;
    ArrayList<SanPham> arrayList = null;
    int layoutId;

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<SanPham> arrayList) {
        super(context, layoutId, arrayList);
        this.context = context;
        this.layoutId = layoutId;
        this.arrayList = arrayList;
    }

    public View getView(int position, View convertView,ViewGroup parent){
        LayoutInflater inflater= context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);

        final TextView textViewTenSP =(TextView)convertView.findViewById(R.id.textView25);
        final TextView textViewGia = (TextView)convertView.findViewById(R.id.textView34);
        final TextView textViewDanhMuc = (TextView)convertView.findViewById(R.id.textView30);
        final TextView textViewNhanHieu = (TextView)convertView.findViewById(R.id.textView31);
        final  TextView textViewKichCo = (TextView)convertView.findViewById(R.id.textView32);
        final TextView textViewTrangThai = (TextView)convertView.findViewById(R.id.textView33);
        final SanPham sanPham = arrayList.get(position);

        textViewTenSP.setText(sanPham.getTuKhoa());
        textViewGia.setText(String.valueOf(sanPham.getGia()) + "  VNĐ");
        textViewDanhMuc.setText(sanPham.getDanhMuc());
        textViewNhanHieu.setText(sanPham.getNhanHieu());
        textViewKichCo.setText(sanPham.getKichCo());
        textViewTrangThai.setText(sanPham.getTrangThai());

    return convertView;

    }
}
