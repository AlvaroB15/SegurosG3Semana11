package com.segurosx.models;

public class Beneficiario extends Persona{
    
    public Beneficiario(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    public Beneficiario(final String nombre, final CorreoMediator correoMediator){
        super(nombre, correoMediator);
    }
    
    @Override
    public void notifica() {
        // TODO Auto-generated method stub
        try {
            System.out.println("Notificando al beneficiario " + this.getNombre());
        }
        catch(Throwable t) {
            System.out.println("Notificacion con error" + t.getMessage() );
        }
    }
}