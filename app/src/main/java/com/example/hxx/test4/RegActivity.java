package com.example.hxx.test4;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hxx.test4.utils.OkHttp;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        EditText username=(EditText ) findViewById(R.id.username2);
        EditText pwd2=(EditText) findViewById(R.id.pwd2);

        Button button=(Button) findViewById(R.id.regester);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpconnection();
                Intent intent=new Intent(RegActivity.this,MainActivity.class);
                startActivity(intent);
            }

            private void httpconnection() {
                OkHttpClient okHttpClient  = new OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10,TimeUnit.SECONDS)
                        .readTimeout(20, TimeUnit.SECONDS)
                        .build();

                //post方式提交的数据
                FormBody formBody = new FormBody.Builder()
                        .add("username", username.getText().toString())
                        .add("password",pwd2.getText().toString())
                        .build();

                final Request request = new Request.Builder()
                        .url("http://bihu.jay86.com/register.php")
                        .post(formBody)
                        .build();


                Call call = okHttpClient.newCall(request);

                call.enqueue(new Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("连接失败");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.code()==200) {

                            Toast.makeText(RegActivity.this,"自动登录成功",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });

}



}
