/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import VO.EspeciesVO;

/**
 *
 * @author Admin
 */
public interface CRUD_ESPECIES {

    public boolean Agregar(EspeciesVO especiesVO);

    public boolean Editar(EspeciesVO especiesVO);

    public boolean Eliminar(int id);

}
