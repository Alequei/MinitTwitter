package mc.alequei.minittwitter.Retrofity;

import mc.alequei.minittwitter.Common.Constantes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiniTwiterClient {
    private static  MiniTwiterClient instance =null;
    private MiniTwiterService miniTwiterService;
    private Retrofit retrofit;
    public MiniTwiterClient() {
    retrofit= new Retrofit.Builder()
            .baseUrl(Constantes.API_MINITWITER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    miniTwiterService =retrofit.create(MiniTwiterService.class);
    }
    public static  MiniTwiterClient getInstance(){
        if (instance == null){
            instance =  new MiniTwiterClient();
        }
        return instance;
    }
    public  MiniTwiterService getMiniTwiterService(){
        return  miniTwiterService;
    }
}
