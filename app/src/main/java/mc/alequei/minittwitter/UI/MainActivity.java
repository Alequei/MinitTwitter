package mc.alequei.minittwitter.UI;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import mc.alequei.minittwitter.R;
import mc.alequei.minittwitter.Retrofity.MiniTwiterClient;
import mc.alequei.minittwitter.Retrofity.MiniTwiterService;
import mc.alequei.minittwitter.Retrofity.Request.RequestLogin;
import mc.alequei.minittwitter.Retrofity.Response.ResponseAuth;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 TextView registrarse;
 EditText email,password;
 Button ingresar;
 MiniTwiterClient miniTwiterClient;
    MiniTwiterService miniTwiterService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Oculta el bar
        getSupportActionBar().hide();
        //Llamar metodos
        RetrofitInit();
        findViews();
        events();



    }

    private void RetrofitInit() {
    miniTwiterClient = MiniTwiterClient.getInstance();
    miniTwiterService = miniTwiterClient.getMiniTwiterService();


    }

    //Valores
    private void findViews() {
        email=findViewById(R.id.correoid);
        password=findViewById(R.id.contraseñaid);
        registrarse=findViewById(R.id.registrarseid);
        ingresar =findViewById(R.id.ingresar);
    }
    //Eventos
    private void events() {
        registrarse.setOnClickListener(this);
        ingresar.setOnClickListener(this);
    }


    //Metodo
    @Override
    public void onClick(View v) {
     int id=v.getId();
     switch (id){
         case R.id.registrarseid:
             registrar();
             break;
         case R.id.ingresar:
             goToLogin();
             break;
     }

    }

    private void goToLogin() {
        String InEmail=email.getText().toString();
        String InPassword=password.getText().toString();
        if (InEmail.isEmpty()){
            email.setError("El email es requerido");
        }else if(InPassword.isEmpty()){
            password.setError("La contraseña es requerida");
        }else {
            RequestLogin requestLogin=new RequestLogin(InEmail,InPassword);
            Call<ResponseAuth> call=miniTwiterService.DoLogin(requestLogin);
            call.enqueue(new Callback<ResponseAuth>()    {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Session  iniciada correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this,SingOup.class);
                        startActivity(intent);
                        finish();
                    }else {
                         Toast.makeText(MainActivity.this, "Algo fue mal revise  sus datos de acceso", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Log.d("ERROR", Objects.requireNonNull(t.getMessage()));
                    Toast.makeText(MainActivity.this,"Problemas  de Conexion",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    //Accion en cada metodo
    private void registrar() {
        Intent intent = new Intent(MainActivity.this,SingOup.class);
        startActivity(intent);
    }

}
