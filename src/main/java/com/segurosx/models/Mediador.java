package com.segurosx.models;

public class Mediador extends Persona{

    public Mediador(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }
    
    public Mediador(final String nombre, final CorreoMediator correoMediator){
        super(nombre, correoMediator);
    }

    @Override
    public void notifica() {
        try {
            System.out.println("Notificando al mediador " + this.getNombre());
        }
        catch(Throwable t) {
            System.out.println("Notificacion con error" + t.getMessage() );
        }
    }
}