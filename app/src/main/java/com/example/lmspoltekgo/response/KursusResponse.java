package com.example.lmspoltekgo.response;

import com.example.lmspoltekgo.data.KursusData;

import java.util.List;

public class KursusResponse {
    private List<KursusData> kursusDataList;

    public List<KursusData> getKursusDataList() {
        return kursusDataList;
    }

    public void setKursusDataList(List<KursusData> kursusDataList) {
        this.kursusDataList = kursusDataList;
    }
}
