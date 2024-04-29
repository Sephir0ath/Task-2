package Clases;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


public class Informe {
    public Informe(){}

    public ArrayList<Object> getInfo(Reunion reunion) {
        ArrayList<Object> info = new ArrayList<>();
        info.add(reunion.getTime());
        info.add(reunion.getHorario());
        info.add(reunion.getTipo());

        return info;
    }
}
