package com.segurosx.models.patterns;

import com.segurosx.models.Cliente;
import com.segurosx.models.Persona;

public interface ICorreoMediator {

    void setServidorCorreoSMTP(String servidorIP);

    void enviaCorreoSMTP(Persona persona);

}
