/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.model;

/**
 *
 * @author cris7
 */
public class Administrador {
    private int idAdministrador;
    private String dniAdministrador;
    private String nombresAdministrador;
    private String apellidosAdministrador;
    private String addresAdministrador;
    private String telefonoAdministrador;
    private String userAdministrador;
    private String passAdministrador;

    public Administrador() {
    }

    public Administrador(int idAdministrador, String dniAdministrador, String nombresAdministrador, String apellidosAdministrador, String addresAdministrador, String telefonoAdministrador, String userAdministrador, String passAdministrador) {
        this.idAdministrador = idAdministrador;
        this.dniAdministrador = dniAdministrador;
        this.nombresAdministrador = nombresAdministrador;
        this.apellidosAdministrador = apellidosAdministrador;
        this.addresAdministrador = addresAdministrador;
        this.telefonoAdministrador = telefonoAdministrador;
        this.userAdministrador = userAdministrador;
        this.passAdministrador = passAdministrador;
    }
    public Administrador build() {
            Administrador administrador = new Administrador();
            administrador.idAdministrador = this.idAdministrador;
            administrador.dniAdministrador = this.dniAdministrador;
            administrador.nombresAdministrador = this.nombresAdministrador;
            administrador.apellidosAdministrador = this.apellidosAdministrador;
            administrador.addresAdministrador = this.addresAdministrador;
            administrador.telefonoAdministrador = this.telefonoAdministrador;
            administrador.userAdministrador = this.userAdministrador;
            administrador.passAdministrador = this.passAdministrador;
            return administrador;
        }
    
    public String getPassAdministrador() {
        return passAdministrador;
    }

    public void setPassAdministrador(String passAdministrador) {
        this.passAdministrador = passAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getDniAdministrador() {
        return dniAdministrador;
    }

    public void setDniAdministrador(String dniAdministrador) {
        this.dniAdministrador = dniAdministrador;
    }

    public String getNombresAdministrador() {
        return nombresAdministrador;
    }

    public void setNombresAdministrador(String nombresAdministrador) {
        this.nombresAdministrador = nombresAdministrador;
    }

    public String getApellidosAdministrador() {
        return apellidosAdministrador;
    }

    public void setApellidosAdministrador(String apellidosAdministrador) {
        this.apellidosAdministrador = apellidosAdministrador;
    }

    public String getAddresAdministrador() {
        return addresAdministrador;
    }

    public void setAddresAdministrador(String addresAdministrador) {
        this.addresAdministrador = addresAdministrador;
    }

    public String getTelefonoAdministrador() {
        return telefonoAdministrador;
    }

    public void setTelefonoAdministrador(String telefonoAdministrador) {
        this.telefonoAdministrador = telefonoAdministrador;
    }

    public String getUserAdministrador() {
        return userAdministrador;
    }

    public void setUserAdministrador(String userAdministrador) {
        this.userAdministrador = userAdministrador;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idAdministrador=" + idAdministrador + ", dniAdministrador=" + dniAdministrador + ", nombresAdministrador=" + nombresAdministrador + ", apellidosAdministrador=" + apellidosAdministrador + ", addresAdministrador=" + addresAdministrador + ", telefonoAdministrador=" + telefonoAdministrador + ", userAdministrador=" + userAdministrador + ", passAdministrador=" + passAdministrador + '}';
    }
    
    
    
    
}
