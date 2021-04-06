package com.dma.auctionapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AuctionData {
    @SerializedName("popular")
    @Expose
    private List<Popular> popular = null;
    @SerializedName("recommended")
    @Expose
    private List<Recommended> recommended = null;
    @SerializedName("allmenu")
    @Expose
    private List<AllItems> allitems = null;

    public List<Popular> getPopular() {
        return popular;
    }

    public void setPopular(List<Popular> popular) {
        this.popular = popular;
    }

    public List<Recommended> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<Recommended> recommended) {
        this.recommended = recommended;
    }

    public List<AllItems> getAllmenu() {
        return allitems;
    }

    public void setAllmenu(List<AllItems> allmenu) {
        this.allitems = allmenu;
    }

}

}
