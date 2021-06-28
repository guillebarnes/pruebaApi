package domain;

import domain.services.refugiosAPI.ServicioRefugios;
import domain.services.refugiosAPI.entities.ListadoDeRefugios;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        ServicioRefugios apiRefugios = ServicioRefugios.getInstancia();


        apiRefugios.listadoDeRefugios(1);

    }
}
