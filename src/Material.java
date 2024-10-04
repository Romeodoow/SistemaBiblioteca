public class Material {
    private String identificador;
    private String titulo;
    private String fechaRegistro;
    private int cantidadRegistrada;
    private int cantidadActual;

    public Material(String identificador, String titulo, String fechaRegistro, int cantidadRegistrada) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.fechaRegistro = fechaRegistro;
        this.cantidadRegistrada = cantidadRegistrada;
        this.cantidadActual = cantidadRegistrada;
    }

    // Métodos para prestar, renovar y devolver materiales
    public boolean prestar() {
        if (cantidadActual > 0) {
            cantidadActual--;
            return true;
        } else {
            System.out.println("No hay unidades disponibles para prestar.");
            return false;
        }
    }

    public void devolver() {
        cantidadActual++;
    }

    public void renovar() {
        System.out.println("Material renovado.");
    }

    // Incrementar la cantidad de materiales
    public void incrementarCantidad(int cantidad) {
        this.cantidadRegistrada += cantidad;
        this.cantidadActual += cantidad;
    }

    // Getters
    public String getIdentificador() { return identificador; }
    public String getTitulo() { return titulo; }
    public String getFechaRegistro() { return fechaRegistro; }
    public int getCantidadRegistrada() { return cantidadRegistrada; }
    public int getCantidadActual() { return cantidadActual; }
}