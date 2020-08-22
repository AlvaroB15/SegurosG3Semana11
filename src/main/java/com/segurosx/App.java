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
        
        
        /**------------------------- PREGUNTA 2 -------------------------------*/
        ClienteAsegurado asegurado = new ClienteAsegurado("Pedro Pablo", correoMediator);
        Cliente cliente2 = new Cliente("Miguel Ramirez",correoMediator);
        ClienteAsegurado asegurado2 = new ClienteAsegurado("Roberto Palacios",correoMediator);
        
        cliente.setCorreoMediator(correoMediator);//AGREGANDO AL CLIENTE su correoMediador para que tambien reciba correo
        //asegurado.enviaCorreo();
        
        //agregando observadores del observado seguro2
        seguro2.addObserver(cliente);
        seguro2.addObserver(asegurado);
        seguro2.addObserver(cliente2);
        seguro2.addObserver(asegurado2);
        
        //cambio de estado del seguro2 entonces se enviara una notificacion automatica por correo a los observadores
        seguro2.setSumaAsegurada(34.5);


   }
}
