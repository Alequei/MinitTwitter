package mc.alequei.minittwitter.Retrofity;

import mc.alequei.minittwitter.Retrofity.Request.RequestLogin;

import mc.alequei.minittwitter.Retrofity.Request.RequestRegistrar;
import mc.alequei.minittwitter.Retrofity.Response.ResponseAuth;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MiniTwiterService {

     @POST("auth/login")
     Call<ResponseAuth> DoLogin(@Body RequestLogin requestLogin);
    @POST("auth/signup")
     Call<ResponseAuth>Dosingup(@Body RequestRegistrar requestRegistrar);
}
