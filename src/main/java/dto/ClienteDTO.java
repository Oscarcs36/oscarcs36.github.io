package dto;

public class ClienteDTO {
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private double saldo;

    public ClienteDTO() {
    }

    public ClienteDTO(int idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteDTO(int idCliente, String nombre, String apellidos, String correo, String telefono, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public ClienteDTO(String nombre, String apellidos, String correo, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClienteDTO{");
        sb.append("id_cliente=").append(idCliente);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellidos='").append(apellidos).append('\'');
        sb.append(", correo='").append(correo).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}
