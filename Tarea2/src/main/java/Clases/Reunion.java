package Clases;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Instant horaInicio;
    private Instant horaFinal;
    private Instant[] horario;
    private TipoReunion tipoReunion;


    public Reunion(){


        horario = new Instant[]{horaPrevista, horaInicio, horaFinal};
    }


    public Date getTime(){
        return fecha;
    }


    public Instant[] getHorario(){
        return horario;
    }

    public TipoReunion getTipo(){
        return tipoReunion;
    }
}
