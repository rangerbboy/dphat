package com.example.cpd.ehutech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cpd.ehutech.model.SV5T.Row;
import com.google.gson.Gson;


public class SV5TActivity extends AppCompatActivity {

    TextView txt_TCDD, txt_TCHT, txt_TCTL, txt_TCTN, txt_TCHN, txt_TCUT;
    EditText edt_drlhk1, edt_drlhk2, edt_dhthk1, edt_dhthk2, edt_dhttb;
    CheckBox cb_rl_cluongDV, cb_rl_tnttltlBac, cb_rl_hthiTTHCM, cb_ht_thdtNCKH, cb_ht_bvNCKH, cb_ht_dgCTHT,
            cb_tl_sbKhoe, cb_tl_tvDTuyenTDTT, cb_tl_giaiHThao, cb_tn_MXHXTN, cb_tn_5hoatdong,
            cb_hn_AVanB1, cb_hn_GluuQuocTe, cb_hn_GiaiNgoaiNgu, cb_hn_1KhoahocKyNang,
            cb_hn_3HoiThaoKiNang, cb_hn_hoatdongHN, cb_ut_utuDang, cb_ut_hienmau, cb_ut_khenthuong;

    Row row = new Row();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv5t_main);
        getInfoSV5T();
        Anhxa();
        getData();
    }

    private void getData() {
        edt_drlhk1.setText(row.getDd_drlhk1().toString());
        edt_drlhk2.setText(row.getDd_drlhk2().toString());
        edt_dhthk1.setText(row.getHt_diemhk1().toString());
        edt_dhthk2.setText(row.getHt_diemhk2().toString());
        edt_dhttb.setText(row.getHt_diemtbn().toString());
        cb_rl_cluongDV.setChecked(row.getDd_loaidoanvien());
        cb_rl_hthiTTHCM.setChecked(row.getDd_hoithitutuonghcm());
        cb_rl_tnttltlBac.setChecked(row.getDd_thanhnientientien());
        cb_ht_bvNCKH.setChecked(row.getHt_baivietnckh());
        cb_ht_dgCTHT.setChecked(row.getHt_giaithuongnckh());
        cb_ht_thdtNCKH.setChecked(row.getHt_thuchiennckh());
        cb_tl_giaiHThao.setChecked(row.getTl_giaithuongthethao());
        cb_tl_sbKhoe.setChecked(row.getTl_sinhvienkhoe());
        cb_tl_tvDTuyenTDTT.setChecked(row.getTl_doituyentdtt());
        cb_tn_5hoatdong.setChecked(row.getTn_5tn_nam());
        cb_tn_MXHXTN.setChecked(row.getTn_mhx_xtn());
        cb_hn_GiaiNgoaiNgu.setChecked(row.getHnhap_giaithuongthingoaingu());
        cb_hn_1KhoahocKyNang.setChecked(row.getHnhap_1khoakynang());
        cb_hn_3HoiThaoKiNang.setChecked(row.getHnhap_3hoithaokynang());
        cb_hn_AVanB1.setChecked(row.getHnhap_avanB1());
        cb_hn_GluuQuocTe.setChecked(row.getHnhap_giaoluuquocte());
        cb_hn_hoatdongHN.setChecked(row.getHnhap_thamgiahoatdonghoinhap());
        cb_ut_hienmau.setChecked(row.getUutien_hienmau());
        cb_ut_khenthuong.setChecked(row.getUutien_bieuduongkhenthuong());
        cb_ut_utuDang.setChecked(row.getUutien_duocketnapdang());
    }

    public void Anhxa()
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

    void getInfoSV5T(){
        Gson gson = new Gson();
        String getInfSV5T = getIntent().getStringExtra("InfoSV5T");
        row = gson.fromJson(getInfSV5T,Row.class);
    }
}
