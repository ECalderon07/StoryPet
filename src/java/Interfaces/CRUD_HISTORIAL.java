/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import VO.HistorialVo;

/**
 *
 * @author Brayan
 */
public interface CRUD_HISTORIAL {
    
    public boolean Agregar(HistorialVo historialVo);

    public boolean Editar(HistorialVo historialVo);

    public boolean Eliminar(int id);
    
}
