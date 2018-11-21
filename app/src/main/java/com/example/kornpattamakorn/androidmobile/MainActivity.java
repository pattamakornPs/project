package com.example.kornpattamakorn.androidmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private TextView regis;
    private EditText user;
    private EditText pass;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.btnlogin);
        regis = findViewById(R.id.txeregis);
        user = findViewById(R.id.editusername);
        pass = findViewById(R.id.editpassword);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,register.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login(){
        String url = "http://10.51.100.218/mobileDevice/login.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject posts = array.getJSONObject(i);
                        status = posts.getString("status");
                    }
                    if(status.equalsIgnoreCase("admin")){
                        //Toast.makeText(getApplicationContext(),status,Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,homeAdmin.class);
                        startActivity(intent);
                    }else {
                        //Toast.makeText(getApplicationContext(),status,Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,homeUser.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                //if(response.equalsIgnoreCase("welcome Boss")){
//                    Intent intent = new Intent(MainActivity.this,home.class);
//                    startActivity(intent);
//                //}else {
//                    Intent intent = new Intent(MainActivity.this,register.class);
//                    startActivity(intent);
//                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("username",user.getText().toString());
                param.put("password",pass.getText().toString());
                return param;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
