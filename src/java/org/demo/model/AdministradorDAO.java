package org.demo.model;

import java.util.List;

public interface AdministradorDAO {
    public Administrador validarAdministrador(String userAdministrador, String passAdministrador);
    public int registrarAdministrador(Administrador a);
    public List<Administrador> listarAdministrador();
    public Administrador listarAdministradorId(int id);
    public int actualizarAdministrador(Administrador a);
    public int eliminarAdministrador(int id);
}
