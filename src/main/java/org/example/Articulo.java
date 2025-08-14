package org.example;

import java.util.List;

public class Articulo {

    private int codigo;
    private String denominacion;
    private double precio;
    private String unidadMedida;
    private List<DetalleFactura> detallesfactura;

    @Override
    public String toString() {
        return "Articulo{" +
                "unidadMedida='" + unidadMedida + '\'' +
                ", precio=" + precio +
                ", denominacion='" + denominacion + '\'' +
                ", codigo=" + codigo +
                '}';
    }

    public void mostrarDetallesFactura (){
        for (DetalleFactura detalles : detallesfactura ) {

        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
