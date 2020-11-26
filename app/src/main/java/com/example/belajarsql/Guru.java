package com.example.belajarsql;

public class Guru {
    private String idguru;
    private String nama_guru;
    private String jenis_kelamin;
    private String kota;
    private String gajiguru;

    public Guru(String idguru, String nama_guru, String jenis_kelamin, String kota, String gajiguru) {
        this.idguru = idguru;
        this.nama_guru = nama_guru;
        this.jenis_kelamin = jenis_kelamin;
        this.kota = kota;
        this.gajiguru = gajiguru;
    }

    public String getIdguru() {
        return idguru;
    }

    public void setIdguru(String idguru) {
        this.idguru = idguru;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getGajiguru() {
        return gajiguru;
    }

    public void setGajiguru(String gajiguru) {
        this.gajiguru = gajiguru;
    }
}
