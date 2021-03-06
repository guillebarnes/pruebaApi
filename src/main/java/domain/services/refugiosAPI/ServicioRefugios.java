package domain.services.refugiosAPI;

import domain.services.refugiosAPI.entities.ListadoDeRefugios;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioRefugios {
    private static ServicioRefugios instancia = null;
    private Retrofit retrofit;
    private static final String urlApi = "https://api.refugiosdds.com.ar/api/";
    private String token = "5EfqbMgizd5AUx8vRcQy5eHUUzwoPc54jmUiGhcGxZX4GARumFyLsFyHRLli";

    private ServicioRefugios(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioRefugios getInstancia(){
        if (instancia == null)
            instancia = new ServicioRefugios();

        return instancia;
    }

    public ListadoDeRefugios listadoDeRefugios(int offset) throws IOException {
        RefugiosService refugiosService = this.retrofit.create(RefugiosService.class);

        Call<ListadoDeRefugios> requestRefugios = refugiosService.hogares(offset);
        Response<ListadoDeRefugios> responseRefugios = requestRefugios.execute();

        return responseRefugios.body();
    }
}
