import java.util.Date;

public class Movimiento {
    private String identificadorMaterial;
    private String tipoMovimiento; // Préstamo, Renovación, Devolución
    private String cedulaPersona;
    private Date fecha;

    public Movimiento(String identificadorMaterial, String tipoMovimiento, String cedulaPersona) {
        this.identificadorMaterial = identificadorMaterial;
        this.tipoMovimiento = tipoMovimiento;
        this.cedulaPersona = cedulaPersona;
        this.fecha = new Date(); // Guarda la fecha actual automáticamente
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "Material='" + identificadorMaterial + '\'' +
                ", Tipo='" + tipoMovimiento + '\'' +
                ", Persona='" + cedulaPersona + '\'' +
                ", Fecha=" + fecha +
                '}';
    }
}