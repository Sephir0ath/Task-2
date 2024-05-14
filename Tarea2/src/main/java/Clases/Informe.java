package Clases;
import Excepciones.NoFinalizadoReunionException;
import Excepciones.NoIniciadoReunionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Informe representa un informe que contiene los datos de la Reunión.
 */
public class Informe {
    private Reunion informeDatos;

    /**
     * Contructor de Informe
     * @param reunion Reunión de la cual se obtendrán los datos que contendrá el informe a generar.
     */
    public Informe(Reunion reunion) {
        informeDatos = reunion;
    }

    /**
     * Método que genera el informe en un archivo .txt a partir de los datos de la reunión.
     * El informe contiene datos temporales de la reunión, de los participantes de la misma y anotaciones realizadas.
     * @throws RuntimeException Si se genera un error durante la generación del informe.
     */
    public void generarInforme() {
        try {
            File archivo = new File("informeReunión.txt");
            int x=1;

            while (archivo.exists()) {
                archivo = new File("informeReunión" + x + ".txt");
                x++;
            }

            FileWriter informe = new FileWriter(archivo);
            informe.write("INFORME DE LA REUNIÓN\n");
            informe.write("------------------------------------------\n");
            informe.write("Fecha y hora: " + informeDatos.getFecha() + "\n");
            informe.write("Hora de inicio: " + informeDatos.getHoraInicio() + "\n");
            informe.write("Hora de fin: " + informeDatos.getHoraFinal() + "\n");
            informe.write("Duración: " + informeDatos.getDuracionReunion() + "\n");
            informe.write("------------------------------------------\n");
            informe.write("Tipo de reunión: " + informeDatos.getTipo() + "\n");
            informe.write("Enlace/Sala: " + informeDatos.getAcceso() + "\n");

            informe.write("------------------------------------------\n");

            informe.write("Asistentes totales: " + informeDatos.getTotalAsistencia()+ "\n");
            informe.write("Lista de Participantes: " + "\n");
            ArrayList<Empleado> listaAsistentes = informeDatos.getAsistencias();
            for (int i = 0; i < informeDatos.getTotalAsistencia(); i++){
                informe.write("Nombre: " + listaAsistentes.get(i).getNombre() + " " + listaAsistentes.get(i).getApellidos() + "\n");
                informe.write("ID: " + listaAsistentes.get(i).getId() + "\n");
                informe.write("Correo: " + listaAsistentes.get(i).getCorreo());
                informe.write("\n");
            }

            informe.write("------------------------------------------\n");
            // Bucle 2
            ArrayList<Nota> notas = informeDatos.getNotas();
            informe.write("Notas de la reunión: " + "\n"); // Nota
            for (int i = 0; i < informeDatos.getNotas().size(); i++){
                informe.write("- " + notas.get(i).getContenidoNota() + "\n");
            }

            informe.close();
        }

        catch(IOException exception) {
            exception.printStackTrace(System.out);
        } catch (NoIniciadoReunionException e) {
            throw new RuntimeException(e);
        } catch (NoFinalizadoReunionException e) {
            throw new RuntimeException(e);
        }
    }
}