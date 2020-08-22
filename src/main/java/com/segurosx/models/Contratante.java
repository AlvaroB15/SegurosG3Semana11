package com.segurosx.models;

public class Contratante extends Persona{

    public Contratante(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    public Contratante(final String nombre, final CorreoMediator correoMediator){
        super(nombre, correoMediator);
    }

    @Override
    public void notifica() {
        try {
            System.out.println("Notificando al contratante " + this.getNombre());
        }
        catch(Throwable t) {
            System.out.println("Notificacion con error" + t.getMessage() );
        }
    }
}