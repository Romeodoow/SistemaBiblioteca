public class Persona {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String rol;
    private int maxPrestamos;

    public Persona(String cedula, String nombres, String apellidos, String rol) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        setMaxPrestamos(); // Establece el número máximo de préstamos según el rol
    }

    private void setMaxPrestamos() {
        switch (rol.toLowerCase()) {
            case "estudiante":
                maxPrestamos = 5;
                break;
            case "docente":
                maxPrestamos = 3;
                break;
            case "administrativo":
                maxPrestamos = 2;
                break;
            default:
                maxPrestamos = 0;
        }
    }

    // Getters
    public String getCedula() { return cedula; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getRol() { return rol; }
    public int getMaxPrestamos() { return maxPrestamos; }
}