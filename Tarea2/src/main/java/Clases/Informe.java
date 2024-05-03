package Clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Informe {
    public Informe() {
    }
    public void generarInforme() {
        try {
            File archivo = new File("informeReunión.txt");
            int x=1;
            while(archivo.exists()) {
                File archivoRenombrado = new File("informeReunión"+x+".txt");
                archivo.renameTo(archivoRenombrado);
                x++;
            }
            FileWriter informe = new FileWriter(archivo);
            informe.write("INFORME DE LA REUNIÓN\n\n");
            informe.write("Fecha y hora:" + "\n"); // fecha y horaPrevista
            informe.write("Hora de inicio:" + "\n"); // horaInicio
            informe.write("Hora de fin:" + "\n"); // horaFin
            informe.write("Duración:" + "\n"); // duracionPrevista
            informe.write("Tipo de reunión::" + "\n"); // tipoReunion
            informe.write("Enlace/Sala:" + "\n"); // enlace si es ReunionVirtual, sala si es ReunionPresencial
            informe.write("Lista de Participantes:" + "\n"); // TotalAsistencia
            informe.write("Notas de la reunión:" + "\n"); // Nota
            informe.close();
        }
        catch(IOException exception) {
            exception.printStackTrace(System.out);
        }
    }
}
