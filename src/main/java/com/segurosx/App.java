package com.segurosx;

import com.segurosx.models.*;
import com.segurosx.models.patterns.PolizaAdapter;
//import com.segurosx.models.patterns.PolizaAdapter2;
import com.segurosx.models.patterns.PolizaAdapter2;

import java.awt.*;

/**
 * HRCS
 *
 */
public class App 
{
    public static void main( String[] args ) throws AWTException {

        Cliente cliente = new Cliente("Juan Perez");
        
        SeguroVehicular seguro = new SeguroVehicular("Toyota","Yaris");
        seguro.calcularRiesgo();
        seguro.calcularCobeturaVehicular();
        cliente.setCompraSeguro(seguro);
        System.out.println( seguro.getDetalleSeguro() );


        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP");
        seguro2.calcularRiesgo();
        seguro2.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez", 12.4));
        cliente.setCompraSeguro(seguro2);
        System.out.println( seguro2.getDetalleSeguro() );

        CorreoMediator correoMediator = new CorreoMediator();
        ClienteAsegurado asegurado = new ClienteAsegurado("Pedro Pablo", correoMediator);
        Contratante contratante = new Contratante("Alvaro", correoMediator);
        Mediador mediador = new Mediador("Miguel", correoMediator);
        Beneficiario beneficiario1 = new Beneficiario("Ramiro", correoMediator);
        Beneficiario beneficiario2 = new Beneficiario("Paolo", correoMediator);
        asegurado.enviaCorreo();


        /*seguro2.setContratante(contratante);
        seguro2.setMediador(mediador);
        seguro2.addBeneficiadrio(beneficiario1);
        seguro2.addBeneficiadrio(beneficiario2);*/


        seguro2.addObserver(cliente);
        seguro2.addObserver(asegurado);
        seguro2.setSumaAsegurada(34.5);


   }
}
