package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CalculoFactura {

        public static void main (String[]args){
            try {

        String[][] articulos = {
                {"100", "Azucar", "20", "U"},
                {"101", "Leche", "30", "U"},
                {"102", "Aceite", "50", "U"},
                {"103", "Sal", "45", "U"},
                {"104", "Fideos", "15", "U"},
                {"105", "Arroz", "28", "U"},
                {"106", "Galletas", "26", "U"},
                {"107", "Carne Molida", "220", "Kg"},
                {"108", "Shampoo", "42", "U"},
                {"109", "Queso Mantecoso", "178", "Kg"},
                {"110", "Jamon Cocido", "320", "Kg"},
                {"111", "Naranjas", "80", "Kg"}
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            Factura factura = new Factura();
            Cliente cliente = new Cliente();

            System.out.println("Ingrese los datos de la factura");
            System.out.println("Numero factura");
            factura.setNroFactura(Long.parseLong(sc.nextLine()));
            System.out.println("Ingrese fecha de factura");
            factura.setFecha(sc.nextLine());
            System.out.println("Ingrese Datos del cliente");
            System.out.println("Razon Social");
            cliente.setRazonSocial(sc.nextLine());
            factura.setRazonSocial(cliente.getRazonSocial());
            System.out.println("Cuit");
            factura.setCuitCliente(cliente.getCuit());
            cliente.setCuit(Long.parseLong(sc.nextLine()));

            while (true) {
                System.out.println("Ingrese el tipo de  pago");
                System.out.println("1 - Contado");
                System.out.println("2 - Tarjeta de Credito");
                System.out.println("3 - Tarjeta de Débito");
                String opcion = sc.nextLine();
                switch (opcion) {
                    case "1":
                        factura.setTipoPago("C");
                        break;
                    case "2":
                        factura.setTipoPago("TC");
                        break;
                    case "3":
                        factura.setTipoPago("TD");
                        break;
                    default:
                        System.out.println("Opcion invalida, ingrese un valor válido");

                }
                break;
            }
            System.out.println("Ingrese la cantidad de articulos a facturar");
            int cantidad;
            while (true) {
                cantidad = Integer.parseInt(sc.nextLine());
                if (cantidad > 0) {
                    String[][] matriz = new String[cantidad + 1][5];
                    factura.setItemsFactura(matriz);
                    break;
                } else {
                    System.out.println("Pruebe nuevamente");
                }
                break;
            }
            while (cantidad > 0) {
                System.out.println("Articulos a facturar");
                int posicion = 0;
                System.out.println("Ingrese el código del articulo ");
                String codigo = sc.nextLine();
                String cantidadArt = "";
                while (true) {

                    if (articulos[posicion][0].equals(codigo)) {
                        String[] art = new String[5];
                        for (int i = 0; i < 4; i++) {
                            art[i] = articulos[posicion][i];
                        }

                        System.out.println("Ingrese cantidad del articulo");

                            if(art[3].equals("U")) {
                                System.out.println("Ingrese un numero entero");
                                String numero = sc.nextLine();
                                while(true) {
                                    if(numero.contains(".")) {
                                        System.out.println("Por favor ingrese un entero");
                                        break;
                                } else {
                                         cantidadArt = numero;
                                    }
                                    break;
                                }
                            }
                            if(art[3].equals("Kg")) {
                                System.out.println("Ingrese un numero decimal");
                                String numero = sc.nextLine();
                                while(true){
                                    if(numero.contains(".")) {
                                        cantidadArt = numero;
                                        break;
                                    } else {
                                        System.out.println("Por favor ingrese un decimal");
                                        break;

                                    }
                                }
                                }



                        factura.setArticuloMatriz(art, cantidadArt);


                        break;
                    } else {

                        posicion++;
                    }

                    if (posicion == (articulos.length)) {
                        System.out.println("El código ingresado es incorrecto");
                        break;
                    }

                }
                cantidad--;
            }
            System.out.println("El ticket a pagar es: ");
            factura.getFactura(cliente);
            factura.getMatriz();
            System.out.println("Total Items "+ factura.getMontoTotal());
            System.out.println("Recargo " + factura.getRecargo());
            System.out.println("Total final " +factura.getMontoFinal());


            break;
        }


    }catch(Exception e) {
                e.printStackTrace();
            }

    }


        }










