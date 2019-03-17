package com.example.hxx.test4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hxx.test4.utils.OkHttp;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    EditText name;
    EditText pwd;
    Button login;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=(EditText) findViewById(R.id.name);
        pwd=(EditText) findViewById(R.id.pwd);
        login=(Button) findViewById(R.id.button_login);
        reg=(Button) findViewById(R.id.button_reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpconnection();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });
    }

    private void httpconnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttp.OkHttpConnection(" https://bihu.jay86.com/login.php", new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Toast.makeText(LoginActivity.this,"error",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responseData=response.body().string();

                            parsejson(responseData);

                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void parsejson(String responseData){
            try {
                JSONObject jsonObject1=new JSONObject(responseData);
                JSONObject jsonObject2=jsonObject1.getJSONObject("data");

                String username=jsonObject2.getString("username");
                String token=jsonObject2.getString("token");
                if (username==name.getText().toString()){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"error",Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
