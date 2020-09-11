package com.example.demo.entity;

import java.io.Serializable;

public class TbClub implements Serializable {
    private Integer clubId;

    private String clubName;

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName == null ? null : clubName.trim();
    }
}