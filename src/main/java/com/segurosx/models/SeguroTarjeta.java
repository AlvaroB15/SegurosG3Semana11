package com.segurosx.models;

public class SeguroTarjeta extends Seguro implements INivelRiesgo, ICobertura {
  

    public SeguroTarjeta(String bancoTarjeta)    {

        super();
        this.bancoTarjeta = bancoTarjeta;
    }

    @Override
    public void calcularRiesgo()   {

        if (this.bancoTarjeta.equals("AZTECA")) {
            this.nivelRiesgo = "ALTO";
        }
        else {
            this.nivelRiesgo = "BAJO";
        } 
    }

    @Override
    public String getDetalleSeguro() {
        
        return "Seg. Tarjeta Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }

    @Override
    public void calculaCobertura() {
        // TODO Auto-generated method stub

    }
}