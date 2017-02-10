package com.example.vikrant.ilovezappos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vikrant on 2/9/2017.
 */

public class Product extends BaseObservable implements Serializable {
    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("thumbnailImageUrl")
    @Expose
    private String thumbnailImageUrl;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("originalPrice")
    @Expose
    private String originalPrice;
    @SerializedName("styleId")
    @Expose
    private String styleId;
    @SerializedName("colorId")
    @Expose
    private String colorId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("percentOff")
    @Expose
    private String percentOff;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("productName")
    @Expose
    private String productName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    /**
     *
     * @param styleId
     * @param price
     * @param originalPrice
     * @param productUrl
     * @param colorId
     * @param productName
     * @param brandName
     * @param thumbnailImageUrl
     * @param percentOff
     * @param productId
     */
    public Product(String brandName, String thumbnailImageUrl, String productId, String originalPrice, String styleId, String colorId, String price, String percentOff, String productUrl, String productName) {
        super();
        this.brandName = brandName;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.productId = productId;
        this.originalPrice = originalPrice;
        this.styleId = styleId;
        this.colorId = colorId;
        this.price = price;
        this.percentOff = percentOff;
        this.productUrl = productUrl;
        this.productName = productName;
    }

    @Bindable
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
        notifyPropertyChanged(BR.brandName);
    }

    @Bindable
    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
        notifyPropertyChanged(BR.thumbnailImageUrl);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Bindable
    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
        notifyPropertyChanged(BR.originalPrice);
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public String getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
        notifyPropertyChanged(BR.percentOff);
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @Bindable
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
        notifyPropertyChanged(BR.productName);
    }

    @Override
    public String toString() {
        return "Result{" +
                "brandName='" + brandName + '\'' +
                ", thumbnailImageUrl='" + thumbnailImageUrl + '\'' +
                ", productId='" + productId + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", styleId='" + styleId + '\'' +
                ", colorId='" + colorId + '\'' +
                ", price='" + price + '\'' +
                ", percentOff='" + percentOff + '\'' +
                ", productUrl='" + productUrl + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
