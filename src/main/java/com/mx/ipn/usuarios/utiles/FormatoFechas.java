package com.mx.ipn.usuarios.utiles;

import java.time.LocalDate;
import java.time.Period;

public class FormatoFechas {

    public static Integer calcularEdad(LocalDate fechaNacimiento){        
    	LocalDate  fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
