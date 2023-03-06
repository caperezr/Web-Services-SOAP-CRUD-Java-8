package org.demo.model;

/**
 *
 * @author cris7
 */
public class Cliente {
    private int idCliente;
    private String dniCliente;
    private String nombresCliente;
    private String apellidosCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String emailCliente;
    private String passCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String dniCliente, String nombresCliente, String apellidosCliente, String direccionCliente, String telefonoCliente, String emailCliente, String passCliente) {
        this.idCliente = idCliente;
        this.dniCliente = dniCliente;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.passCliente = passCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", dniCliente=" + dniCliente + ", nombresCliente=" + nombresCliente + ", apellidosCliente=" + apellidosCliente + ", direccionCliente=" + direccionCliente + ", telefonoCliente=" + telefonoCliente + ", emailCliente=" + emailCliente + ", passCliente=" + passCliente + '}';
    }
    
}
