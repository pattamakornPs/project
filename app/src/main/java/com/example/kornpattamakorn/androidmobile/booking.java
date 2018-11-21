package com.example.kornpattamakorn.androidmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class booking extends AppCompatActivity {
    private EditText bname;
    private EditText btel;
    private EditText btime;
    private CheckBox ccut,ccolor,ctattoo;
    private Button booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        addListenerOnButton();
        addListenerOnclick();
        setbooking();
    }
    public void addListenerOnclick(){
        ccut = findViewById(R.id.hc);
        ccolor = findViewById(R.id.cc);
        ctattoo = findViewById(R.id.ct);
        ccut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()){
                    Toast.makeText(com.example.kornpattamakorn.androidmobile.booking.this,"1",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void addListenerOnButton(){
        ccut = findViewById(R.id.hc);
        ccolor = findViewById(R.id.cc);
        ctattoo = findViewById(R.id.ct);
        bname = findViewById(R.id.bookingname);
        btel = findViewById(R.id.bookingtel);
        btime = findViewById(R.id.bookingtime);
        booking = findViewById(R.id.buttonbooking);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer cresult = new StringBuffer();
                cresult.append("1").append(ccut.isChecked());
                cresult.append("2").append(ctattoo.isChecked());
                cresult.append("3").append(ccolor.isChecked());
                Toast.makeText(booking.this,cresult.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setbooking(){
        String url = "http://10.51.100.218/mobileDevice/register.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("name",bname.getText().toString());
                param.put("tel",btel.getText().toString());
                param.put("date",btime.getText().toString());
                param.put("service",ccolor.getText().toString());
                //param.put("service",ccut.getText().toString());
                //param.put("service",ctattoo.getText().toString());
                return param;

            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
