package com.example.zubinthakkar.asktoagriexpert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ExpertAnswered extends AppCompatActivity {
    TextView tv_ql;
    EditText ed_query_ans;
    Button btnSubmit, btnCancle;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_answered);
        tv_ql=findViewById(R.id.tv_q1);
        ed_query_ans = findViewById(R.id.ed_queryans);
        btnCancle = findViewById(R.id.btnCancle);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertAnswered.this, query_list.class);
                startActivity(intent);
            }
        });



        Bundle b=getIntent().getExtras();
        if(b!=null){

            s=b.getString("val");
            tv_ql.setText(s);
            //Qansfetch qans = new Qansfetch(this);
            //qans.execute(s);

        }


    }
    public void OnSubmitAns (View view)
    {

    }

    class Qansfetch extends AsyncTask<String,Void,String> {
        Context context;
        AlertDialog alertDialog;
        Qansfetch (Context ctx){

            context = ctx;
        }

        @Override
        protected String doInBackground(String... params) {

            String qans_url = Url.URL+"qans.php";
            try {
                String query_id = params[0];
                URL url = new URL(qans_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("query_id", "UTF-8")+"="+URLEncoder.encode(query_id, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String  line="";
                while((line = bufferedReader.readLine())!= null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return  result;
            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }




            return null;
        }

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login Status");

        }

        @Override
        protected void onPostExecute(String result) {
            alertDialog.setMessage(result);

            if(result.toString().equals("Login Successfull"))
            {
                Intent intent = new Intent(context, ExpertDashboard.class);
                context.startActivity(intent);
            }
            else
            {
                alertDialog.show();
            }



        }

        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
        }


    }

}
