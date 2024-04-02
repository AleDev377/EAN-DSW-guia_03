/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private final ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private final ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el método que agrega al principio
        this.pacientes.add(0,pac);
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agregar un paciente al final de la lista
        this.pacientes.add(pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código dado
        // Buscar el índice del paciente con el código dado
        int index = -1;
        for (int i = 0; i < darNumeroPacientes(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                index = i;
                break;
            }
        }
        // Si se encuentra el paciente con el código dado, insertar el nuevo paciente antes de él
        if (index != -1) {
                pacientes.add(index, pac);
        } else {
            throw new NoExisteException(cod);
        }
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
        // Buscar el índice del paciente con el código dado
        int index = -1;
        for (int i = 0; i < darNumeroPacientes(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                index = i;
                break;
            }
        }
        // Si se encuentra el paciente con el código dado, insertar el nuevo paciente después de él
        if (index != -1) {
            pacientes.add(index + 1, pac);
        } else {
            throw new NoExisteException(cod);
        }
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el método
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == codigo) {
                return paciente;
            }
        }
        return null; // Retorna null si no se encuentra ningún paciente con el código dado
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción
        // Buscar el índice del paciente con el código dado
        int index = -1;
        for (int i = 0; i < darNumeroPacientes(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                index = i;
                break;
            }
        }

        // Si se encuentra el paciente con el código dado, eliminarlo
        if (index != -1) {
            pacientes.remove(index);
        } else {
            throw new NoExisteException(cod);
        }
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        // TODO: Completar
        int count = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.HOMBRE) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        // TODO: Completar
        int count = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.MUJER) {
                count++;
            }
        }
        return count;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        // TODO: Completar

        // Inicializar un arreglo para contar la cantidad de pacientes por cada clínica
        int[] pacientesPorClinica = new int[listaClinicas.size()];

        // Contar la cantidad de pacientes por clínica
        for (Paciente paciente : pacientes) {
            String clinica = paciente.darClinica();
            int index = listaClinicas.indexOf(clinica);
            if (index != -1) {
                pacientesPorClinica[index]++;
            }
        }

        // Encontrar la clínica con más pacientes
        int maxPacientes = 0;
        int indexMasOcupada = -1;
        for (int i = 0; i < pacientesPorClinica.length; i++) {
            if (pacientesPorClinica[i] > maxPacientes) {
                maxPacientes = pacientesPorClinica[i];
                indexMasOcupada = i;
            }
        }

        // Si se encontró la clínica más ocupada, retornar su nombre
        if (indexMasOcupada != -1) {
            return listaClinicas.get(indexMasOcupada);
        } else {
            return "No hay pacientes asignados a ninguna clínica";
        }
    }
}
