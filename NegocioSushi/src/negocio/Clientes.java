package negocio;

public class Clientes {
    private String clienteRun;
    private String nombreCompleto;
    private String direccion;
    private String comuna;
    private String provincia;
    private String region;
    private String fechaNacimiento;
    private String genero;
    private String correoElectronico;
    private String numeroTelefonico;
    private String password;

    public Clientes() {
    }

    public String getClienteRun() {
        return clienteRun;
    }

    public void setClienteRun(String clienteRun) {
        this.clienteRun = clienteRun;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteRun=" + clienteRun + ", nombreCompleto=" + nombreCompleto + ", direccion=" + direccion + ", comuna=" + comuna + ", provincia=" + provincia + ", region=" + region + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", correoElectronico=" + correoElectronico + ", numeroTelefonico=" + numeroTelefonico + ", password=" + password + '}';
    }

    
    
}
