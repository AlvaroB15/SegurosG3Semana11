package com.segurosx.models;

public class ClienteAsegurado extends Cliente {


    public ClienteAsegurado(String nombre, CorreoMediator correoMediator) {

        super(nombre, correoMediator);
    }

    public void enviaCorreo()    {

        correoMediator.setServidorCorreoSMTP("10.20.5.107");
        correoMediator.enviaCorreoSMTP(this);
    }

    
}