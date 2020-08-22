package com.segurosx.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.segurosx.models.patterns.IClienteObserver;

public class Cliente implements IClienteObserver {
    
    private final String nombre;
    private final List<Seguro> seguros;
    protected CorreoMediator correoMediator;

    public Cliente(final String nombre) {

        this.nombre = nombre;
        this.seguros = new ArrayList<Seguro>();
    }

    public Cliente(final String nombre, final CorreoMediator correoMediator) {

        this.nombre = nombre;
        this.correoMediator = correoMediator;
        this.seguros = new ArrayList<Seguro>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setCompraSeguro(final Seguro seguro) {
        // set contratante, observers
        seguro.setCliente(this);

        this.seguros.add(seguro);
    }

    public void getListaSeguroCliente() {

        System.out.println("Nombre: " + this.nombre);
        for (final Seguro seguro : seguros) {

            System.out.println("Seguro: " + seguro.getDetalleSeguro());
        }

    }

    public CorreoMediator getCorreoMediator() {
        return correoMediator;
    }

    public void setCorreoMediator(CorreoMediator correoMediator) {
        this.correoMediator = correoMediator;
    }
    
    @Override
    public void notifica(String msg)   {

        try {
            System.out.println("Notificando al cliente " + this.nombre);
            correoMediator.setServidorCorreoSMTP("587");
            correoMediator.enviaCorreoSMTP(this,msg);
            
        }
        catch(Throwable t) {
            System.out.println("Notificacion con error" + t.getMessage() );
        }
        
    }
}