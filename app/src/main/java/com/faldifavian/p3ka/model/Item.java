package com.faldifavian.p3ka.model;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String idpenyakit;
    private String nama_penyakit;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIdpenyakit() {
        return idpenyakit;
    }

    public void setIdpenyakit(String idpenyakit) {
        this.idpenyakit = idpenyakit;
    }

    public String getNama_penyakit() {
        return nama_penyakit;
    }

    public void setNama_penyakit(String nama_penyakit) {
        this.nama_penyakit = nama_penyakit;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
