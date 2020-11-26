package com.example.belajarsql;

public class Siswa {
    String Nosiswa;
    String Idjurusan;
    String Nama;
    String Jeniskelamin;
    String Tgllahir;

    public Siswa(String Nosiswa,String Idjurusan,String Nama,String Jeniskelamin,String Tgllahir) {

        this.Nosiswa = Nosiswa;
        this.Idjurusan = Idjurusan;
        this.Nama = Nama;
        this.Jeniskelamin = Jeniskelamin;
        this.Tgllahir = Tgllahir;
    }

    public String getNosiswa() {
        return Nosiswa;
    }

    public void setNosiswa(String nosiswa) {
        Nosiswa = nosiswa;
    }

    public String getIdjurusan() {
        return Idjurusan;
    }

    public void setIdjurusan(String idjurusan) {
        Idjurusan = idjurusan;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJeniskelamin() {
        return Jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        Jeniskelamin = jeniskelamin;
    }

    public String getTgllahir() {
        return Tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        Tgllahir = tgllahir;
    }
}
