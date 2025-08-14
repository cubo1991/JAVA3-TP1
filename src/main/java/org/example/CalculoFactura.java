package org.example;

import java.util.Scanner;

public class CalculoFactura {

    public static void main(String[] args) {
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

                //Instanciamos las clases facturas y cliente
                Factura factura = new Factura();
                Cliente cliente = new Cliente();


                // Comenzamos a pedir los datos de la factura
                System.out.println("Ingrese los datos de la factura");


                //Validamos que el dato ingresado sea un numero
                while (true) {
                    System.out.println("Numero factura");
                    String numeroFactura = sc.nextLine();
                    if (Validaciones.validarLong(numeroFactura)) {
                        factura.setNroFactura(Long.parseLong(numeroFactura));
                        break;
                    } else {
                        System.out.println("Ingrese un valor valido");
                        continue;
                    }

                }

                System.out.println("Ingrese fecha de factura");

                //Validamos que el dato ingresado no contenga letras
                while (true) {
                    String fechaFactura = sc.nextLine().trim();
                    if (Validaciones.validarFecha(fechaFactura)) {
                        factura.setFecha(fechaFactura);
                        break;
                    } else {
                        System.out.println("Ingrese un valor valido");
                        continue;
                    }
                }
                System.out.println("Ingrese Datos del cliente");
                System.out.println("Razon Social");
                cliente.setRazonSocial(sc.nextLine().trim());
                factura.setRazonSocial(cliente.getRazonSocial());
                System.out.println("Cuit");

                //Validamos que el dato ingresado sea un numero
                while (true) {
                    String cuitCliente = sc.nextLine().trim();
                    if (Validaciones.validarLong(cuitCliente)) {
                        long cuit = Long.parseLong(cuitCliente);
                        cliente.setCuit(cuit);
                        factura.setCuitCliente(cuit);
                        break;
                    } else {
                        System.out.println("Ingrese un valor valido");
                        continue;
                    }
                }

                // vamos con el pago
                while (true) {
                    try {
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
                                //Si se pide un valor numerico que no este contemplado en las opciones, pide uno nuevo
                                System.out.println("Opcion invalida, ingrese un valor válido");
                                continue;
                        }
                        break;
                    } catch (Exception e) {
                        //En caso de que no sea un número, pide ingresar un valor númerico
                        System.out.println("Ingrese un caracter numerico valido");

                    }
                }
                System.out.println("Ingrese la cantidad de articulos a facturar");
                int cantidad = 0;

                while (true) {
                    String cantStr = sc.nextLine();
                    //Validamos que el dato ingresado sea un numero
                    if (Validaciones.validarNumero(cantStr)) {
                        cantidad = Integer.parseInt(cantStr);
                        break;
                    } else {
                        System.out.println("Por favor, ingrese un valor válido");
                    }
                }

                while (true) {

                    if (cantidad > 0) {

                        //Se instancia la matriz

                        String[][] matriz = new String[cantidad + 1][5];
                        factura.setItemsFactura(matriz);
                        break;
                    } else {
                        System.out.println("Pruebe nuevamente");
                    }
                    break;
                }
                while (cantidad > 0) {
                    boolean encontrado=false;
                    System.out.println("Articulos a facturar");
                    int posicion = 0;
                    System.out.println("Ingrese el código del articulo ");
                    String codigo = sc.nextLine();
                    for (int i = 0; i < articulos.length; i++) {
                        if (codigo.equals(articulos[i][0])) {
                            encontrado=true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Ingrese un valor valido");
                        continue;
                    }

                    String cantidadArt = "";
                    while (true) {

                        if (articulos[posicion][0].equals(codigo)) {
                            String[] art = new String[5];
                            for (int i = 0; i < 4; i++) {
                                art[i] = articulos[posicion][i];
                            }

                            System.out.println("Ingrese cantidad del articulo");

                            if (art[3].equals("U")) {
                                System.out.println("Ingrese un numero entero");
                                String numero = sc.nextLine();
                                //Validamos que el dato ingresado sea un numero
                                if (!Validaciones.validarNumero(numero)) {
                                    System.out.println("Ingrese un numero");
                                    continue;
                                }
                                while (true) {
                                    if (numero.contains(".")) {
                                        System.out.println("Por favor ingrese un entero");
                                        break;
                                    } else {
                                        cantidadArt = numero;
                                    }
                                    break;
                                }
                            }
                            if (art[3].equals("Kg")) {
                                while (true) {
                                    System.out.println("Ingrese un numero decimal");
                                    String numero = sc.nextLine();
                                    //Validamos que el dato ingresado sea un decimal
                                    if (!Validaciones.validarDecimal(numero)) {
                                        System.out.println("Ingrese un número válido");
                                        continue;
                                    }

                                    cantidadArt = numero;
                                    break;
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
                System.out.println("Total Items " + factura.getMontoTotal());
                System.out.println("Recargo " + factura.getRecargo());
                System.out.println("Total final " + factura.getMontoFinal());
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}










