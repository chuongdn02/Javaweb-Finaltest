/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_114;

/**
 *
 * @author macpro
 */
public class product {

    private int id;
    private String name, des, price, title;
    private int idUser;

    public product() {
    }

    public product(int idUser, int id, String name, String price, String des, String title) {
        this.idUser = idUser;
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
        this.title = title;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }

    public String getdes() {
        return des;
    }

    public void setdes(String des) {
        this.des = des;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }
}
