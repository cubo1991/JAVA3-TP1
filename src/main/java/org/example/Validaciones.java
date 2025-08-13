package org.example;



public class Validaciones {

    public static boolean validarLong(String numero) {
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

    public static boolean validarNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validarDecimal(String numero) {
        try {
            double valor = Double.parseDouble(numero);
            return valor % 1 != 0; // true solo si tiene parte decimal
        } catch (NumberFormatException e) {
            return false;
        }
    }


}


