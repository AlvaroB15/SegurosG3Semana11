package com.segurosx.models;

import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.segurosx.models.patterns.IClienteObserver;
import com.segurosx.models.patterns.ISeguroObservable;

public abstract class Seguro implements ISeguroObservable {

    protected Integer numero;
    protected Certificado certificado;
    protected Poliza poliza;
    protected Cliente cliente; // contratante
    protected String nivelRiesgo = "NINGUNO";
    protected String bancoTarjeta;
    protected String marca;
    protected String modelo;
    protected List<IClienteObserver> contratantes;

    public Seguro() {
        this.numero = new Integer(new Random().nextInt());
        this.certificado = new Certificado();
        this.contratantes = new ArrayList<IClienteObserver>();
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(final Certificado certificado) {
        this.certificado = certificado;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(final Poliza poliza) {
        this.poliza = poliza;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(final Integer numero) {
        this.numero = numero;
    }

    public String getNivelRiesgo() {
        return this.nivelRiesgo;
    }

    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public abstract String getDetalleSeguro();

    public void setSumaAsegurada(final Double suma) throws AWTException {

        this.poliza.setSumaAsegurada(suma);
        // notify contratante
        System.out.println("***********************************************************");
        System.out.println("Se modifico la Suma Asegurada, notificando... ");
        System.out.println("***********************************************************");
        for( IClienteObserver a : this.contratantes) {

            a.notifica();
        }        
    }

    public void addObserver(IClienteObserver observer) {
        this.contratantes.add( observer );
    }

    public void removeObserver(IClienteObserver observer) {
        this.contratantes.remove( observer );
    }   

}
