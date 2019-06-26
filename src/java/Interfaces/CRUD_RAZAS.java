/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import VO.RazasVO;

/**
 *
 * @author Admin
 */
public interface CRUD_RAZAS {

    public boolean Agregar(RazasVO razasVO);

    public boolean Editar(RazasVO razasVO);

    public boolean Eliminar(int id);
}
