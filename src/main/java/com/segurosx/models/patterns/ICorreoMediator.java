package com.segurosx.models.patterns;

import com.segurosx.models.Cliente;

public interface ICorreoMediator {

    void setServidorCorreoSMTP(String servidorIP);

    void enviaCorreoSMTP(Cliente cliente,String msg);

}
