package com.example.po.tj_xianyu.gson;

/**
 * Created by 13701 on 2017/12/28.
 */

public class Item {
    private int id;
    private String itemName;
    private String description;
    private int price;
    private int status;
    private String bitMapString;
    public Item(){

    }
    public Item(int _id,String _itemName,String _description,int _price,int _status,String _bitmapString){
        id = _id;
        itemName = _itemName;
        description = _description;
        price = _price;
        status = _status;
        bitMapString = _bitmapString;
    }

    public String getPhotoFileName(){
        return "IMG"+getItemName()+".jpg";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBitMapString() {
        return bitMapString;
    }

    public void setBitMapString(String bitMapString) {
        this.bitMapString = bitMapString;
    }
}
