package com.example.cpd.ehutech.model.SV5T;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("hoten")
    @Expose
    private String hoten;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("sdt")
    @Expose
    private String sdt;
    @SerializedName("tenlop")
    @Expose
    private String tenlop;
    @SerializedName("tenkhoa")
    @Expose
    private String tenkhoa;
    @SerializedName("chuky")
    @Expose
    private String chuky;
    @SerializedName("danhhieu")
    @Expose
    private String danhhieu;
    @SerializedName("dd_drlhk1")
    @Expose
    private Integer dd_drlhk1;
    @SerializedName("dd_drlhk2")
    @Expose
    private Integer dd_drlhk2;
    @SerializedName("dd_loaidoanvien")
    @Expose
    private Boolean dd_loaidoanvien;
    @SerializedName("dd_thanhnientientien")
    @Expose
    private Boolean dd_thanhnientientien;
    @SerializedName("dd_hoithitutuonghcm")
    @Expose
    private Boolean dd_hoithitutuonghcm;
    @SerializedName("ht_diemhk1")
    @Expose
    private Float ht_diemhk1;
    @SerializedName("ht_diemhk2")
    @Expose
    private Float ht_diemhk2;
    @SerializedName("ht_diemtbn")
    @Expose
    private Float ht_diemtbn;
    @SerializedName("ht_baivietnckh")
    @Expose
    private Boolean ht_baivietnckh;
    @SerializedName("ht_thuchiennckh")
    @Expose
    private Boolean ht_thuchiennckh;
    @SerializedName("ht_giaithuongnckh")
    @Expose
    private Boolean ht_giaithuongnckh;
    @SerializedName("tl_sinhvienkhoe")
    @Expose
    private Boolean tl_sinhvienkhoe;
    @SerializedName("tl_doituyentdtt")
    @Expose
    private Boolean tl_doituyentdtt;
    @SerializedName("tl_giaithuongthethao")
    @Expose
    private Boolean tl_giaithuongthethao;
    @SerializedName("tn_mhx_xtn")
    @Expose
    private Boolean tn_mhx_xtn;
    @SerializedName("tn_5tn_nam")
    @Expose
    private Boolean tn_5tn_nam;
    @SerializedName("hnhap_avanB1")
    @Expose
    private Boolean hnhap_avanB1;
    @SerializedName("hnhap_giaoluuquocte")
    @Expose
    private Boolean hnhap_giaoluuquocte;
    @SerializedName("hnhap_giaithuongthingoaingu")
    @Expose
    private Boolean hnhap_giaithuongthingoaingu;
    @SerializedName("hnhap_1khoakynang")
    @Expose
    private Boolean hnhap_1khoakynang;
    @SerializedName("hnhap_3hoithaokynang")
    @Expose
    private Boolean hnhap_3hoithaokynang;
    @SerializedName("hnhap_thamgiahoatdonghoinhap")
    @Expose
    private Boolean hnhap_thamgiahoatdonghoinhap;
    @SerializedName("uutien_duocketnapdang")
    @Expose
    private Boolean uutien_duocketnapdang;
    @SerializedName("uutien_hienmau")
    @Expose
    private Boolean uutien_hienmau;
    @SerializedName("uutien_bieuduongkhenthuong")
    @Expose
    private Boolean uutien_bieuduongkhenthuong;
    @SerializedName("kiennghi_khokhan")
    @Expose
    private String kiennghi_khokhan;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("updated_at")
    @Expose
    private String updated_at;
    @SerializedName("deleted_at")
    @Expose
    private String deleted_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getChuky() {
        return chuky;
    }

    public void setChuky(String chuky) {
        this.chuky = chuky;
    }

    public String getDanhhieu() {
        return danhhieu;
    }

    public void setDanhhieu(String danhhieu) {
        this.danhhieu = danhhieu;
    }

    public Integer getDd_drlhk1() {
        return dd_drlhk1;
    }

    public void setDd_drlhk1(Integer dd_drlhk1) {
        this.dd_drlhk1 = dd_drlhk1;
    }

    public Integer getDd_drlhk2() {
        return dd_drlhk2;
    }

    public void setDd_drlhk2(Integer dd_drlhk2) {
        this.dd_drlhk2 = dd_drlhk2;
    }

    public Boolean getDd_loaidoanvien() {
        return dd_loaidoanvien;
    }

    public void setDd_loaidoanvien(Boolean dd_loaidoanvien) {
        this.dd_loaidoanvien = dd_loaidoanvien;
    }

    public Boolean getDd_thanhnientientien() {
        return dd_thanhnientientien;
    }

    public void setDd_thanhnientientien(Boolean dd_thanhnientientien) {
        this.dd_thanhnientientien = dd_thanhnientientien;
    }

    public Boolean getDd_hoithitutuonghcm() {
        return dd_hoithitutuonghcm;
    }

    public void setDd_hoithitutuonghcm(Boolean dd_hoithitutuonghcm) {
        this.dd_hoithitutuonghcm = dd_hoithitutuonghcm;
    }

    public Float getHt_diemhk1() {
        return ht_diemhk1;
    }

    public void setHt_diemhk1(Float ht_diemhk1) {
        this.ht_diemhk1 = ht_diemhk1;
    }

    public Float getHt_diemhk2() {
        return ht_diemhk2;
    }

    public void setHt_diemhk2(Float ht_diemhk2) {
        this.ht_diemhk2 = ht_diemhk2;
    }

    public Float getHt_diemtbn() {
        return ht_diemtbn;
    }

    public void setHt_diemtbn(Float ht_diemtbn) {
        this.ht_diemtbn = ht_diemtbn;
    }

    public Boolean getHt_baivietnckh() {
        return ht_baivietnckh;
    }

    public void setHt_baivietnckh(Boolean ht_baivietnckh) {
        this.ht_baivietnckh = ht_baivietnckh;
    }

    public Boolean getHt_thuchiennckh() {
        return ht_thuchiennckh;
    }

    public void setHt_thuchiennckh(Boolean ht_thuchiennckh) {
        this.ht_thuchiennckh = ht_thuchiennckh;
    }

    public Boolean getHt_giaithuongnckh() {
        return ht_giaithuongnckh;
    }

    public void setHt_giaithuongnckh(Boolean ht_giaithuongnckh) {
        this.ht_giaithuongnckh = ht_giaithuongnckh;
    }

    public Boolean getTl_sinhvienkhoe() {
        return tl_sinhvienkhoe;
    }

    public void setTl_sinhvienkhoe(Boolean tl_sinhvienkhoe) {
        this.tl_sinhvienkhoe = tl_sinhvienkhoe;
    }

    public Boolean getTl_doituyentdtt() {
        return tl_doituyentdtt;
    }

    public void setTl_doituyentdtt(Boolean tl_doituyentdtt) {
        this.tl_doituyentdtt = tl_doituyentdtt;
    }

    public Boolean getTl_giaithuongthethao() {
        return tl_giaithuongthethao;
    }

    public void setTl_giaithuongthethao(Boolean tl_giaithuongthethao) {
        this.tl_giaithuongthethao = tl_giaithuongthethao;
    }

    public Boolean getTn_mhx_xtn() {
        return tn_mhx_xtn;
    }

    public void setTn_mhx_xtn(Boolean tn_mhx_xtn) {
        this.tn_mhx_xtn = tn_mhx_xtn;
    }

    public Boolean getTn_5tn_nam() {
        return tn_5tn_nam;
    }

    public void setTn_5tn_nam(Boolean tn_5tn_nam) {
        this.tn_5tn_nam = tn_5tn_nam;
    }

    public Boolean getHnhap_avanB1() {
        return hnhap_avanB1;
    }

    public void setHnhap_avanB1(Boolean hnhap_avanB1) {
        this.hnhap_avanB1 = hnhap_avanB1;
    }

    public Boolean getHnhap_giaoluuquocte() {
        return hnhap_giaoluuquocte;
    }

    public void setHnhap_giaoluuquocte(Boolean hnhap_giaoluuquocte) {
        this.hnhap_giaoluuquocte = hnhap_giaoluuquocte;
    }

    public Boolean getHnhap_giaithuongthingoaingu() {
        return hnhap_giaithuongthingoaingu;
    }

    public void setHnhap_giaithuongthingoaingu(Boolean hnhap_giaithuongthingoaingu) {
        this.hnhap_giaithuongthingoaingu = hnhap_giaithuongthingoaingu;
    }

    public Boolean getHnhap_1khoakynang() {
        return hnhap_1khoakynang;
    }

    public void setHnhap_1khoakynang(Boolean hnhap_1khoakynang) {
        this.hnhap_1khoakynang = hnhap_1khoakynang;
    }

    public Boolean getHnhap_3hoithaokynang() {
        return hnhap_3hoithaokynang;
    }

    public void setHnhap_3hoithaokynang(Boolean hnhap_3hoithaokynang) {
        this.hnhap_3hoithaokynang = hnhap_3hoithaokynang;
    }

    public Boolean getHnhap_thamgiahoatdonghoinhap() {
        return hnhap_thamgiahoatdonghoinhap;
    }

    public void setHnhap_thamgiahoatdonghoinhap(Boolean hnhap_thamgiahoatdonghoinhap) {
        this.hnhap_thamgiahoatdonghoinhap = hnhap_thamgiahoatdonghoinhap;
    }

    public Boolean getUutien_duocketnapdang() {
        return uutien_duocketnapdang;
    }

    public void setUutien_duocketnapdang(Boolean uutien_duocketnapdang) {
        this.uutien_duocketnapdang = uutien_duocketnapdang;
    }

    public Boolean getUutien_hienmau() {
        return uutien_hienmau;
    }

    public void setUutien_hienmau(Boolean uutien_hienmau) {
        this.uutien_hienmau = uutien_hienmau;
    }

    public Boolean getUutien_bieuduongkhenthuong() {
        return uutien_bieuduongkhenthuong;
    }

    public void setUutien_bieuduongkhenthuong(Boolean uutien_bieuduongkhenthuong) {
        this.uutien_bieuduongkhenthuong = uutien_bieuduongkhenthuong;
    }

    public String getKiennghi_khokhan() {
        return kiennghi_khokhan;
    }

    public void setKiennghi_khokhan(String kiennghi_khokhan) {
        this.kiennghi_khokhan = kiennghi_khokhan;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
}
