package com.example.dianasari.model;

public class Data {
    private String id, name, jabatan, alamat;

    public Data() {

    }

    public Data(String id, String name, String jabatan, String alamat) {
        this.id = id;
        this.name = name;
        this.jabatan = jabatan;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
