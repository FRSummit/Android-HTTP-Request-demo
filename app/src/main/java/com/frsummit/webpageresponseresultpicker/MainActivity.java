package com.frsummit.webpageresponseresultpicker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends Activity {

    String url = "http://localhost:3000/posts/1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = findViewById(R.id.textView);
        t.setText(url);
    }

    public void getReqBtn(View v) throws UnsupportedEncodingException {
        Toast.makeText(MainActivity.this, "Get Request Btn is clicked", Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(this);
//        final String url2 = "http://192.168.43.152:8080/PhpApi/api/category/read.php";
        final String url2 = "http://192.168.43.152:8080/PhpApi/api/product/read.php";

        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url2, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                        final TextView tt = findViewById(R.id.textView);
//                        tt.setText(response.toString());
                        try {
                            JSONObject obj = new JSONObject(response.toString());
//                            JSONObject records = obj.getJSONObject("records");
//                            String name = records.getString("name");
                            System.out.println(obj);
                            System.out.println(obj.get("records"));
                            String str = obj.get("records").toString();
                            System.out.println(str);
                            tt.setText(obj.get("records").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Log.d("Error.Response", response);
                        System.out.println("error : " + error);
                    }
                }
        );
        // add it to the RequestQueue
        queue.add(getRequest);

//        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                System.out.println("This is reesponse : ");
//                System.out.println("This is reesponse : " + response);
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    Toast.makeText(MainActivity.this,jsonObject.getString("message"),Toast.LENGTH_LONG).show();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    Toast.makeText(MainActivity.this,"e "+e.toString(),Toast.LENGTH_LONG).show();
//                }
//            }}, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(MainActivity.this,"err "+error.toString(),Toast.LENGTH_LONG).show();
//                }
//            }
//        );
//        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
//        requestQueue.add(stringRequest);
//        System.out.println(requestQueue);
//        System.out.println(stringRequest);

//        Add();

    }

    /*private void Add() throws UnsupportedEncodingException {
//        String name1 = URLEncoder.encode(name.getText().toString(),"UTF8");
//        Integer price1 = Integer.parseInt(URLEncoder.encode(price.getText().toString(),"UTF8"));
//        Integer qty1 = Integer.parseInt(URLEncoder.encode(qty.getText().toString(),"UTF8"));
//        String url = server_url_insert + "?pro_name=" + name1 + "&pro_price=" + price1 + "&pro_qty=" + qty1 + "";
        String url = "http://192.168.43.152:8080/PhpApi/api/category/read.php";
        Log.e("URL",url);
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this,jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"e"+e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"err"+error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
//        name.setText(" ");
//        price.setText(" ");
//        qty.setText(" ");
    }*/
}
