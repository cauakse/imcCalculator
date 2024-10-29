package com.example.imccalculatorfx.util;

public class IMC {
    static public double get(int peso,double altura){
        return peso/(Math.pow(altura,2));
    }

   static public String getCondicao (double imc){
        String cond = "";
            if(imc>=40){
                cond= "Obesidade Mórbida";
            } else if (imc>=30) {
                cond = "Obesidade";
            }
                else if (imc >=25){
                    cond="Sobrepeso";
                } else if (imc >=20) {
                    cond = "Peso Normal";
                } else if (imc>=14.5) {
                    cond="Peso Abaixo do Normal";
                }
                else
                    cond = "Desnutrição";


       return cond;
    }
}
