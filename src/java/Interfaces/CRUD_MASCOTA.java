/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import VO.MascotasVO;

/**
 *
 * @author Admin
 */
public interface CRUD_MASCOTA {

    public boolean Agregar(MascotasVO mascotasVO);

    public boolean Editar(MascotasVO mascotasVO);

    public boolean Eliminar(int id);
}
