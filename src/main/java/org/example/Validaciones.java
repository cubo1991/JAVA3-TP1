package org.example;



public class Validaciones {

    public static boolean validarNumeroFactura(String numero) {
        try {
            Long.parseLong(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validarFecha(String fecha) {
        try {
            for (char c : fecha.toCharArray()) {
                if (Character.isLetter(c)) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}


