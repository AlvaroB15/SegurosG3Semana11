package com.segurosx.models;

import java.util.ArrayList;
import java.util.List;

public class ClienteAsegurado extends Persona {

    private final List<Seguro> seguros;

    public ClienteAsegurado(String nombre, CorreoMediator correoMediator) {

        super(nombre, correoMediator);
        this.seguros = new ArrayList<Seguro>();
    }

    public void enviaCorreo()    {

        correoMediator.setServidorCorreoSMTP("10.20.5.107");
        correoMediator.enviaCorreoSMTP(this);
    }

        
}