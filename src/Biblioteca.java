import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Persona> personas = new ArrayList<>();
    private List<Material> materiales = new ArrayList<>();
    private List<Movimiento> historial = new ArrayList<>(); // Historial de movimientos

    // Método para registrar personas en la biblioteca
    public void registrarPersona(Persona persona) {
        personas.add(persona);
        System.out.println("Persona registrada: " + persona.getNombres());
    }

    // Método para eliminar personas
    public void eliminarPersona(String cedula) {
        personas.removeIf(p -> p.getCedula().equals(cedula));
        System.out.println("Persona eliminada.");
    }

    // Método para registrar materiales
    public void registrarMaterial(Material material) {
        materiales.add(material);
        System.out.println("Material registrado: " + material.getTitulo());
    }

    // Método para prestar material
    public void prestarMaterial(String identificador, String cedula) {
        Persona persona = buscarPersona(cedula);
        Material material = buscarMaterial(identificador);
        if (persona != null && material != null && persona.getMaxPrestamos() > 0) {
            if (material.prestar()) {
                historial.add(new Movimiento(identificador, "Préstamo", cedula));
                System.out.println("Material prestado a " + persona.getNombres());
            }
        } else {
            System.out.println("No se puede prestar el material.");
        }
    }

    // Método para devolver material
    public void devolverMaterial(String identificador, String cedula) {
        Material material = buscarMaterial(identificador);
        if (material != null) {
            material.devolver();
            historial.add(new Movimiento(identificador, "Devolución", cedula));
            System.out.println("Material devuelto.");
        } else {
            System.out.println("Material no encontrado.");
        }
    }

    // Método para renovar material
    public void renovarMaterial(String identificador, String cedula) {
        Material material = buscarMaterial(identificador);
        if (material != null) {
            material.renovar();
            historial.add(new Movimiento(identificador, "Renovación", cedula));
            System.out.println("Material renovado.");
        } else {
            System.out.println("Material no encontrado.");
        }
    }

    // Incrementar la cantidad de un material específico
    public void incrementarCantidad(String identificador, int cantidad) {
        Material material = buscarMaterial(identificador);
        if (material != null) {
            material.incrementarCantidad(cantidad);
            System.out.println("Cantidad incrementada.");
        } else {
            System.out.println("Material no encontrado.");
        }
    }

    // Consultar el historial
    public void consultarHistorial() {
        System.out.println("Historial de Movimientos:");
        for (Movimiento movimiento : historial) {
            System.out.println(movimiento.toString());
        }
    }

    // Métodos auxiliares para buscar personas y materiales
    private Persona buscarPersona(String cedula) {
        for (Persona p : personas) {
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        System.out.println("Persona no encontrada.");
        return null;
    }

    private Material buscarMaterial(String identificador) {
        for (Material m : materiales) {
            if (m.getIdentificador().equals(identificador)) {
                return m;
            }
        }
        System.out.println("Material no encontrado.");
        return null;
    }
}