package com.segurosx.models;

import java.util.Properties;

public class ClienteAsegurado extends Cliente {
   

    public ClienteAsegurado(String nombre, CorreoMediator correoMediator) {

        super(nombre, correoMediator);
    }

    public void enviaCorreo()    {

        correoMediator.setServidorCorreoSMTP("587");
        correoMediator.enviaCorreoSMTP(this," ");
        
        
    }
    @Override
    public void  notifica(String msg){
        super.notifica(msg);
    }


    
}