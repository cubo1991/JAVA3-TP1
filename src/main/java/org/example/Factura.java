package org.example;


import java.util.Arrays;

public class Factura {
    private String fecha;
    private long nroFactura;
    private String razonSocial ;
    private long cuitCliente;
    private String tipoPago;
    private double montoTotalItems;
    private double recargo;
    private double montoFinal;
    private String [][] itemsFactura;
    private int indiceActual = 1;
    private double subTotal = 0.0;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public long getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(long cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMontoTotalItems() {
        return montoTotalItems;
    }

    public void setMontoTotalItems(double montoTotalItems) {
        this.montoTotalItems = montoTotalItems;
    }

    public double getRecargo() {
        if(this.tipoPago.equals("C")) recargo = 0.0;
        if(this.tipoPago.equals("TC")) recargo = (subTotal * 0.1);
        if(this.tipoPago.equals("TD")) recargo = (subTotal * 0.05);
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getMontoFinal() {
        return getMontoTotal() + this.recargo;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getItemsFactura() {
        return itemsFactura;
    }

    public void setItemsFactura(String[][] itemsFactura) {
        this.itemsFactura = itemsFactura;
    }

    public void getMatriz() {
        this.itemsFactura[0][0] = "Código Ítem";
        this.itemsFactura[0][1] = "Denominación";
        this.itemsFactura[0][2] = "Precio Unitario";
        this.itemsFactura[0][3] = "Cantidad";
        this.itemsFactura[0][4] = "Subtotal";

        for (int i = 0; i < itemsFactura.length; i++) {
            for (int j = 0; j < itemsFactura[i].length; j++) {
                if (itemsFactura[i][j] == null) {
                    itemsFactura[i][j] = "-";
                }
                System.out.printf("%-20s", itemsFactura[i][j]);
            }
            System.out.println();

        }
    }
    public void setArticuloMatriz(String[] articulo, String cantidad) {
        articulo[3] = cantidad;
        double cantidadCast = Double.parseDouble(cantidad);
        double total = cantidadCast * Integer.parseInt(articulo[2]);
        articulo[4] = String.valueOf((int) total);
        subTotal += total;

        if (indiceActual < itemsFactura.length) {
            for (int j = 0; j < articulo.length; j++) {
                itemsFactura[indiceActual][j] = articulo[j];
            }
            indiceActual++;
        } else {
            System.out.println("No se pueden agregar más artículos, la factura está llena.");
        }
    }

    public double getMontoTotal(){

        return subTotal;

    }

    public double getTotalFinal (){
        return subTotal + recargo;
    }

    public void getFactura (Cliente cliente){

        System.out.println("Cliente: " +  cliente.getRazonSocial());
        System.out.println("Fecha: " + this.getFecha());
        System.out.println("Numero: " + this.getNroFactura());
        System.out.println("Tipo pago: "+ this.getTipoPago());



    }

    @Override
    public String toString() {
        return "Factura{" +
                "fecha='" + fecha + '\'' +
                ", nroFactura=" + nroFactura +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuitCliente=" + cuitCliente +
                ", tipoPago='" + tipoPago + '\'' +
                ", montoTotalItems=" + montoTotalItems +
                ", recargo=" + recargo +
                ", montoFinal=" + montoFinal +
                ", itemsFactura=" + Arrays.toString(itemsFactura) +
                '}';
    }
}
