package com.example.white.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends Activity {

    String JSON_String;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = (TextView) this.findViewById(R.id.textView);
        EditText vendor_id = (EditText) findViewById(R.id.editText);

        final TextView post_txt =(TextView) this.findViewById(R.id.post_txt);
       // String ven = post_txt.getText().toString();
        post_txt.setText(vendor_id.getText().toString());

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                User user = new User();
                String ven = post_txt.getText().toString();
                post_txt.setText(ven);
                user.setVendor_id(ven);
                HttpCall httpCallPost = new HttpCall();
                httpCallPost.setMethodtype(HttpCall.POST);
                httpCallPost.setUrl("http://192.168.0.106/services/loyalty.php");
                HashMap<String, String> paramsPost = new HashMap<>();
                paramsPost.put("vendor_id","ZVR001");
                httpCallPost.setParams(paramsPost);
                new HttpRequest() {
                    @Override
                    public void onResponse(String response) {
                        super.onResponse(response);
                        post_txt.setText(post_txt.getText() + "\nPost:" + response);
//                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT);
                    }
                }.execute(httpCallPost);
            }
        });


    }
    }
