package com.example.belajarsql;

import android.os.Parcel;
import android.os.Parcelable;

public class Jrsn {
    private String  idjurusan;
    private String nosiswa;
    private String namajurusan;

    public Jrsn(String idjurusan,String nosiswa, String namajurusan){
        this.idjurusan = idjurusan;
        this.nosiswa = nosiswa;
        this.namajurusan = namajurusan;
    }

    public String getIdjurusan() {
        return idjurusan;
    }

    public void setIdjurusan(String idjurusan) {
        this.idjurusan = idjurusan;
    }

    public String getNosiswa() {
        return nosiswa;
    }

    public void setNosiswa(String nosiswa) {
        this.nosiswa = nosiswa;
    }

    public String getNamajurusan() {
        return namajurusan;
    }

    public void setNamajurusan(String namajurusan) {
        this.namajurusan = namajurusan;
    }
}

