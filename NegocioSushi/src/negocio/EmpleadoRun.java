package negocio;

public class EmpleadoRun {
    private String  fechaContrato;
    private Integer sueldoLiquido;
    private Integer sueldoBruto;
    private String  tipo;
    private String  run;
    private String  nombre;
    private String  direccion;
    private String  comuna;
    private String  provincia;
    private String  region;
    private String  fechaNacimiento;
    private String  genero;
    private String  correoElectronico;
    private String numeroTelefonico;
    private String  password;

    public EmpleadoRun() {
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public Integer getSueldoLiquido() {
        return sueldoLiquido;
    }

    public void setSueldoLiquido(Integer sueldoLiquido) {
        this.sueldoLiquido = sueldoLiquido;
    }

    public Integer getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(Integer sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Rut" + " " + run +"\n"+ "Nombre"+ " " + nombre +"\n"+ "Tipo" + " " + tipo+"\n"+ "Sueldo Liquido" + " " +  sueldoLiquido+ "\n"+ "Sueldo Bruto"+ " " + sueldoBruto +"\n"+"Fecha contrato" +" " + fechaContrato+"\n"+ "Region" +" "+ region+"\n"+"Provincia" + " " +provincia+"\n"+ "Comuna"+" "+ comuna+"\n"+ "Direccion"+ direccion+"\n"+ "Fecha Nacimiento"+" "+ fechaNacimiento +"\n"+ "Genero" +" "+ genero+"\n"+  "Numero Telefonico"+" "+numeroTelefonico+"\n"+ "Correo"+ " "+ correoElectronico+"\n"+ "Password" +" "+ password+"\n"+ "\n";
                       
    }
    
    
}
