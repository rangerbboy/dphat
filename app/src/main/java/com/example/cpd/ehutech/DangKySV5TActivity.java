package com.example.cpd.ehutech;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpd.ehutech.model.SV5T.Row;
import com.example.cpd.ehutech.model.SV5T.TTinTChiSV5T;

import com.example.cpd.ehutech.remote.ApiUtils;
import com.example.cpd.ehutech.service.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangKySV5TActivity extends AppCompatActivity {

    TextView txt_TCDD, txt_TCHT, txt_TCTL, txt_TCTN, txt_TCHN, txt_TCUT;
    EditText edt_drlhk1, edt_drlhk2, edt_dhthk1, edt_dhthk2, edt_dhttb, edt_kiennghi;
    CheckBox cb_rl_cluongDV, cb_rl_tnttltlBac, cb_rl_hthiTTHCM, cb_ht_thdtNCKH, cb_ht_bvNCKH, cb_ht_dgCTHT,
            cb_tl_sbKhoe, cb_tl_tvDTuyenTDTT, cb_tl_giaiHThao, cb_tn_MXHXTN, cb_tn_5hoatdong,
            cb_hn_AVanB1, cb_hn_GluuQuocTe, cb_hn_GiaiNgoaiNgu, cb_hn_1KhoahocKyNang,
            cb_hn_3HoiThaoKiNang, cb_hn_hoatdongHN, cb_ut_utuDang, cb_ut_hienmau, cb_ut_khenthuong;
    Button btn_dky, btn_huy;
    Row row = new Row();
    Intent intent;
    dkySV5T a = new dkySV5T();
    MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_sv5_t);
        Anhxa();
        btn_dky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemtraChuky();
                setData();
                doDKySV5T(row);
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DangKySV5TActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void kiemtraChuky(){
        a.sharedPreferences = getSharedPreferences(a.MyPREFERENCES, Context.MODE_PRIVATE);
        String chuky = a.sharedPreferences.getString(a.ChuKy, null);
        if(chuky == null)
        {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            Intent intent = new Intent(DangKySV5TActivity.this,DrawSignatureActivity.class);
                            startActivity(intent);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            dialog.cancel();
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bạn Chưa Có Chữ Ký!");
            builder.setMessage("Hãy Thêm Chữ Ký").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
        }
    }

    public void doDKySV5T(Row row) {
        a.sharedPreferences = getSharedPreferences(a.MyPREFERENCES, Context.MODE_PRIVATE);
        String token = "Bearer " + a.sharedPreferences.getString(a.Token, "");
        a.apiService = ApiUtils.getUserService();
        Call<TTinTChiSV5T> call = a.apiService.dkyTTinTChiSV5T(token, row);
        call.enqueue(new Callback<TTinTChiSV5T>() {
            @Override
            public void onResponse(Call<TTinTChiSV5T> call, Response<TTinTChiSV5T> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(DangKySV5TActivity.this,"Đăng ký thành công", Toast.LENGTH_LONG).show();
                    intent = new Intent(DangKySV5TActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                        Toast.makeText(DangKySV5TActivity.this, "Đã Xảy Ra Lỗi!!Hãy Thử Đăng Nhập Lại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TTinTChiSV5T> call, Throwable t) {
                Toast.makeText(DangKySV5TActivity.this, "Ket Noi Loi", Toast.LENGTH_LONG).show();
                intent = new Intent(DangKySV5TActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private Row setData() {
        a.sharedPreferences = getSharedPreferences(a.MyPREFERENCES, Context.MODE_PRIVATE);
        String chuky = a.sharedPreferences.getString(a.ChuKy, null);
        String username = a.sharedPreferences.getString(a.MSSV, "");
        String hoten = a.sharedPreferences.getString(a.Ten, "");
        String email = a.sharedPreferences.getString(a.Email, "");
        String sdt = a.sharedPreferences.getString(a.SDT, "");
        String lop = a.sharedPreferences.getString(a.Lop, "");
        String khoa = a.sharedPreferences.getString(a.Khoa, "");

        row.setUsername(username);
        row.setChuky(chuky);
        row.setHoten(hoten);
        row.setEmail(email);
        row.setSdt(sdt);
        row.setTenlop(lop);
        row.setTenkhoa(khoa);

        int drlhk1, drlhk2;
        float dhthk1, dhthk2, dhttb;
        int defaultt = 0;
        String kiennghi;

        if (edt_drlhk1.getText().toString().trim().equals(""))
        {
            edt_drlhk1.setText(Integer.toString(defaultt));
            drlhk1 = KiemTraDRL(Integer.parseInt(edt_drlhk1.getText().toString()));
        }else {
            drlhk1 = KiemTraDRL(Integer.parseInt(edt_drlhk1.getText().toString()));
        }
        if (edt_drlhk2.getText().toString().trim().equals(""))
        {
            edt_drlhk2.setText(Integer.toString(defaultt));
            drlhk2 = KiemTraDRL(Integer.parseInt(edt_drlhk2.getText().toString()));
        }else {
            drlhk2 = KiemTraDRL(Integer.parseInt(edt_drlhk2.getText().toString()));
        }
        if (edt_dhthk1.getText().toString().trim().equals(""))
        {
            edt_dhthk1.setText(Float.toString(defaultt));
            dhthk1 = KiemTraDHT(Float.parseFloat(edt_dhthk1.getText().toString()));
        }else {
            dhthk1 = KiemTraDHT(Float.parseFloat(edt_dhthk1.getText().toString()));
        }
        if (edt_dhthk2.getText().toString().trim().equals(""))
        {
            edt_dhthk2.setText(Float.toString(defaultt));
            dhthk2 = KiemTraDHT(Float.parseFloat(edt_dhthk2.getText().toString()));
        }else {
            dhthk2 = KiemTraDHT(Float.parseFloat(edt_dhthk2.getText().toString()));
        }
        if (edt_dhttb.getText().toString().trim().equals(""))
        {
            edt_dhttb.setText(Float.toString((dhthk1+ dhthk2) /2));
            dhttb = KiemTraDHT(Float.parseFloat(edt_dhttb.getText().toString()));
        }else {
            dhttb = KiemTraDHT(Float.parseFloat(edt_dhttb.getText().toString()));
        }
        kiennghi = edt_kiennghi.getText().toString();

        row.setDd_drlhk1(drlhk1);
        row.setDd_drlhk2(drlhk2);
        row.setHt_diemhk1(dhthk1);
        row.setHt_diemhk2(dhthk2);
        row.setHt_diemtbn(dhttb);
        row.setDd_hoithitutuonghcm(cb_rl_hthiTTHCM.isChecked());
        row.setDd_loaidoanvien(cb_rl_cluongDV.isChecked());
        row.setDd_thanhnientientien(cb_rl_tnttltlBac.isChecked());
        row.setHt_baivietnckh(cb_ht_bvNCKH.isChecked());
        row.setHt_giaithuongnckh(cb_ht_dgCTHT.isChecked());
        row.setHt_thuchiennckh(cb_ht_thdtNCKH.isChecked());
        row.setTl_doituyentdtt(cb_tl_tvDTuyenTDTT.isChecked());
        row.setTl_giaithuongthethao(cb_tl_giaiHThao.isChecked());
        row.setTl_sinhvienkhoe(cb_tl_sbKhoe.isChecked());
        row.setTn_5tn_nam(cb_tn_5hoatdong.isChecked());
        row.setTn_mhx_xtn(cb_tn_MXHXTN.isChecked());
        row.setHnhap_1khoakynang(cb_hn_1KhoahocKyNang.isChecked());
        row.setHnhap_3hoithaokynang(cb_hn_3HoiThaoKiNang.isChecked());
        row.setHnhap_avanB1(cb_hn_AVanB1.isChecked());
        row.setHnhap_giaithuongthingoaingu(cb_hn_GiaiNgoaiNgu.isChecked());
        row.setHnhap_giaoluuquocte(cb_hn_GluuQuocTe.isChecked());
        row.setHnhap_thamgiahoatdonghoinhap(cb_hn_hoatdongHN.isChecked());
        row.setUutien_bieuduongkhenthuong(cb_ut_khenthuong.isChecked());
        row.setUutien_duocketnapdang(cb_ut_utuDang.isChecked());
        row.setUutien_hienmau(cb_ut_hienmau.isChecked());
        row.setKiennghi_khokhan(kiennghi);

        return row;
    }

    int KiemTraDRL(int a)
    {
        if(a >= 100){
            a = 100;
        }
        if(a <= 0){
            a = 0;
        }
        return a;
    }

    float KiemTraDHT(float a)
    {
        if(a >= 10){
            a = 10;
        }
        if(a <= 0){
            a = 0;
        }
        return a;
    }

    private void Anhxa()
    {
        txt_TCDD = (TextView) findViewById(R.id.TCDD);
        txt_TCHT = (TextView) findViewById(R.id.TCHT);
        txt_TCTL = (TextView) findViewById(R.id.TCTL);
        txt_TCTN = (TextView) findViewById(R.id.TCTN);
        txt_TCHN = (TextView) findViewById(R.id.TCHN);
        txt_TCUT = (TextView) findViewById(R.id.TCUT);
        edt_drlhk1 = (EditText) findViewById(R.id.edt_rl_drlhk1);
        edt_drlhk2 = (EditText) findViewById(R.id.edt_rl_drlhk2);
        edt_dhthk1 = (EditText) findViewById(R.id.edt_ht_dhthk1);
        edt_dhthk2 = (EditText) findViewById(R.id.edt_ht_dhthk2);
        edt_dhttb = (EditText) findViewById(R.id.edt_ht_dhttb);
        edt_kiennghi = (EditText) findViewById(R.id.edt_kiennghi);
        cb_rl_cluongDV = (CheckBox) findViewById(R.id.cb_rl_cluongDV);
        cb_rl_tnttltlBac = (CheckBox) findViewById(R.id.cb_rl_tnttltlBac);
        cb_rl_hthiTTHCM = (CheckBox) findViewById(R.id.cb_rl_hthiTTHCM);
        cb_ht_thdtNCKH = (CheckBox) findViewById(R.id.cb_ht_thdtNCKH);
        cb_ht_bvNCKH = (CheckBox) findViewById(R.id.cb_ht_bvNCKH);
        cb_ht_dgCTHT = (CheckBox) findViewById(R.id.cb_ht_dgCTHT);
        cb_tl_sbKhoe = (CheckBox) findViewById(R.id.cb_tl_sbKhoe);
        cb_tl_tvDTuyenTDTT = (CheckBox) findViewById(R.id.cb_tl_tvDTuyenTDTT);
        cb_tl_giaiHThao = (CheckBox) findViewById(R.id.cb_tl_giaiHThao);
        cb_tn_MXHXTN = (CheckBox) findViewById(R.id.cb_tn_MXHXTN);
        cb_tn_5hoatdong = (CheckBox) findViewById(R.id.cb_tn_5hoatdong);
        cb_hn_AVanB1 = (CheckBox) findViewById(R.id.cb_hn_AVanB1);
        cb_hn_GluuQuocTe = (CheckBox) findViewById(R.id.cb_hn_GluuQuocTe);
        cb_hn_GiaiNgoaiNgu = (CheckBox) findViewById(R.id.cb_hn_GiaiNgoaiNgu);
        cb_hn_1KhoahocKyNang = (CheckBox) findViewById(R.id.cb_hn_1KhoahocKyNang);
        cb_hn_3HoiThaoKiNang = (CheckBox) findViewById(R.id.cb_hn_3HoiThaoKiNang);
        cb_hn_hoatdongHN = (CheckBox) findViewById(R.id.cb_hn_hoatdongHN);
        cb_ut_utuDang = (CheckBox) findViewById(R.id.cb_ut_utuDang);
        cb_ut_hienmau = (CheckBox) findViewById(R.id.cb_ut_hienmau);
        cb_ut_khenthuong = (CheckBox) findViewById(R.id.cb_ut_khenthuong);
        btn_dky = (Button) findViewById(R.id.btn_dky_sv5t);
        btn_huy = (Button) findViewById(R.id.btn_huydky_sv5t);
    }

    public void txt_DKySV5T_Action(View v)
    {
        btn_dky.callOnClick();
    }

    public void txt_TCDD_Action(View v)
    {
        LinearLayout layout_TCDD = findViewById(R.id.TTin_TCDD);
        if(layout_TCDD.getVisibility() == View.GONE)
        {
            layout_TCDD.setVisibility(View.VISIBLE);
        }else {
            layout_TCDD.setVisibility(View.GONE);
        }
    }

    public void txt_TCHT_Action(View v)
    {
        LinearLayout layout_TCHT = findViewById(R.id.TTin_TCHT);
        if(layout_TCHT.getVisibility() == View.GONE)
        {
            layout_TCHT.setVisibility(View.VISIBLE);
        }else {
            layout_TCHT.setVisibility(View.GONE);
        };
    }

    public void txt_TCTL_Action(View v)
    {
        LinearLayout layout_TCTL = findViewById(R.id.TTin_TCTL);
        if(layout_TCTL.getVisibility() == View.GONE)
        {
            layout_TCTL.setVisibility(View.VISIBLE);
        }else {
            layout_TCTL.setVisibility(View.GONE);
        }
    }

    public void txt_TCTN_Action(View v)
    {
        LinearLayout layout_TCTN = findViewById(R.id.TTin_TCTN);
        if(layout_TCTN.getVisibility() == View.GONE)
        {
            layout_TCTN.setVisibility(View.VISIBLE);
        }else {
            layout_TCTN.setVisibility(View.GONE);
        }
    }

    public void txt_TCHN_Action(View v)
    {
        LinearLayout layout_TCHN = findViewById(R.id.TTin_TCHN);
        if(layout_TCHN.getVisibility() == View.GONE)
        {
            layout_TCHN.setVisibility(View.VISIBLE);
        }else {
            layout_TCHN.setVisibility(View.GONE);
        }
    }

    public void txt_TCUT_Action(View v)
    {
        LinearLayout layout_TCUT = findViewById(R.id.TTin_TCUT);
        if(layout_TCUT.getVisibility() == View.GONE)
        {
            layout_TCUT.setVisibility(View.VISIBLE);

        }else {
            layout_TCUT.setVisibility(View.GONE);
        }
    }

    class dkySV5T extends LoginActivity{
    }
}
