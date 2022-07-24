package com.is210q12022.is210.sistema.restaurante;

public class productObjectModel {
    private int orderId;
    private String bebida;
    private float precioB;
    private int cantidadB;
    private String comida;
    private float precioC;
    private int cantidadC;

    public int getorderId() {
        return orderId;
    }

    public void setorderId(int orderId) {
        this.orderId = orderId;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public float getPriceb() {
        return precioB;
    }

    public void setPriceb(float precioB) {
        this.precioB = precioB;
    }

    public int getCantb() {
        return cantidadB;
    }

    public void setCantb(int cantB) {
        this.cantidadB = cantB;
    }
    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public float getPricec() {
        return precioC;
    }

    public void setPricec(float precioC) {
        this.precioC = precioC;
    }

    public int getCantc() {
        return cantidadC;
    }

    public void setCantc(int cantidadC) {
        this.cantidadC = cantidadC;
    }
}