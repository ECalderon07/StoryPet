/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import VO.UsuarioVO;

/**
 *
 * @author Admin
 */
public interface CRUD_USUARIO {

    public boolean AgregarRegistro(UsuarioVO usuarioVo);

    public boolean ActualizarRegistro(UsuarioVO usuarioVo);

    public boolean EliminarRegistro(int id);

    //public List Listar();
    //public Persona Listar(int id);
    //public boolean Agregar();
    //public boolean Editar();
    //public boolean Eliminar(int id);
}
