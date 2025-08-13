package org.example;


import java.util.Arrays;
import java.util.List;

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
    private Cliente cliente;
    private List<DetalleFactura> detallesFactura;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

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

        int columnas = itemsFactura[0].length;
        int[] anchoColumnas = new int[columnas];

        // Calcular ancho de cada columna
        for (int j = 0; j < columnas; j++) {
            int max = 0;
            for (int i = 0; i < itemsFactura.length; i++) {
                if (itemsFactura[i][j] != null && itemsFactura[i][j].length() > max) {
                    max = itemsFactura[i][j].length();
                }
            }
            anchoColumnas[j] = max + 2; // +2 para espacio extra
        }

        // Imprimir fila de separación
        StringBuilder separador = new StringBuilder();
        for (int w : anchoColumnas) {
            separador.append("+");
            for (int k = 0; k < w; k++) separador.append("-");
        }
        separador.append("+");

        // Imprimir la matriz
        System.out.println(separador);
        for (int i = 0; i < itemsFactura.length; i++) {
            System.out.print("|");
            for (int j = 0; j < itemsFactura[i].length; j++) {
                String valor = (itemsFactura[i][j] == null) ? "-" : itemsFactura[i][j];
                System.out.printf(" %-" + (anchoColumnas[j] - 1) + "s|", valor);
            }
            System.out.println();
            System.out.println(separador);
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

    public void getFactura(Cliente cliente) {
        int anchoColumna1 = 13;
        int anchoColumna2 = 55;

        String separador = "+" + "-".repeat(anchoColumna1) + "+" + "-".repeat(anchoColumna2) + "+";
        System.out.println(separador);

        System.out.printf("| %-" + (anchoColumna1 - 1) + "s| %-" + (anchoColumna2 - 1) + "s|\n", "Cliente", cliente.getRazonSocial());
        System.out.println(separador);

        System.out.printf("| %-" + (anchoColumna1 - 1) + "s| %-" + (anchoColumna2 - 1) + "s|\n", "Fecha", this.getFecha());
        System.out.println(separador);

        System.out.printf("| %-" + (anchoColumna1 - 1) + "s| %-" + (anchoColumna2 - 1) + "s|\n", "Número", this.getNroFactura());
        System.out.println(separador);

        System.out.printf("| %-" + (anchoColumna1 - 1) + "s| %-" + (anchoColumna2 - 1) + "s|\n", "Tipo pago", this.getTipoPago());
        System.out.println(separador);
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
