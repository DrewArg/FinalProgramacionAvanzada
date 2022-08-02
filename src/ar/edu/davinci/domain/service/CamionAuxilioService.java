package ar.edu.davinci.domain.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.CamionAuxilio;
import ar.edu.davinci.domain.clases.GranGrua;
import ar.edu.davinci.domain.clases.MiniGrua;
import ar.edu.davinci.domain.clases.MiniTallerMovil;
import ar.edu.davinci.domain.clases.Ubicacion;

public class CamionAuxilioService {

    private List<CamionAuxilio> auxilios = new ArrayList<>();

    public void addMiniGrua(Ubicacion ubicacion, String patente) {
        auxilios.add(new MiniGrua(ubicacion, patente));
    }

    public void addGranGrua(Ubicacion ubicacion, String patente) {
        auxilios.add(new GranGrua(ubicacion, patente));
    }

    public void addMiniTallerMovil(Ubicacion ubicacion, String patente) {
        auxilios.add(new MiniTallerMovil(ubicacion, patente));
    }

    public CamionAuxilio getCamionAuxilio(String patente) {
        for (CamionAuxilio camionAuxilio : auxilios) {
            if (camionAuxilio.getPatente().equals(patente)) {
                return camionAuxilio;
            }
        }

        return null;
    }

}
