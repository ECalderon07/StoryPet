/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import VO.ServiciosVo;

/**
 *
 * @author Brayan
 */
public interface CRUD_SERVICIOS {

    public boolean AgregarRegistro(ServiciosVo serviciosVo);

    public boolean ActualizarRegistro(ServiciosVo serviciosVo);

    public boolean EliminarRegistro(int id);
}
