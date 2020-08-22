package com.segurosx.models;

import com.segurosx.models.patterns.IClienteObserver;

public class Persona implements IClienteObserver{
    private final String nombre;
    protected CorreoMediator correoMediator;

    public Persona(final String nombre){
        this.nombre = nombre;
    }

    public Persona(final String nombre, final CorreoMediator correoMediator) {

        this.nombre = nombre;
        this.correoMediator = correoMediator;
    }

    public String getNombre() {
        return nombre;
    }

	@Override
	public void notifica() {
		// TODO Auto-generated method stub
        try {
            System.out.println("Notificando al cliente " + this.nombre);
        }
        catch(Throwable t) {
            System.out.println("Notificacion con error" + t.getMessage() );
        }
	}

}
    