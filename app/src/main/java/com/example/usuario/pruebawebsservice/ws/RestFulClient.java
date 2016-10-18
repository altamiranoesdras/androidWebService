package com.example.usuario.pruebawebsservice.ws;

import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Usuario on 11/10/2016.
 */

public class RestFulClient {
    private  static final String GET_URL="http://asiti.powerwtechnology.com:9000/getService?";
    private  static final String POST_URL="http://asiti.powerwtechnology.com:9000/postService?";

    public static String connectToServerGet(){
        String result = "";
        try {
            URL url = new URL(GET_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);
            //connection.setDoInput(true);
            //connection.setDoOutput(true);
            connection.setRequestMethod("GET");
    //            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            //OutputStream outputStream = new BufferedOutputStream(connection)

            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode < HttpURLConnection.HTTP_BAD_REQUEST){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String temp = "";
                result ="";
                while ((temp = bufferedReader.readLine()) != null){
                    result += temp;
                }

                Log.d("ServerConnection","jsonResponse"+ result);
            }else if(responseCode == HttpURLConnection.HTTP_UNAUTHORIZED){
                result= "HTTP Unautorized";
            }else {
                result= "HTTP Bad Request Message";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            result = e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            result = e.getMessage();
            e.printStackTrace();
        }

        return result;
    }

    public static String connectToServerPost(){
        String result = "";
        try {
            URL url = new URL(POST_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            //OutputStream outputStream = new BufferedOutputStream(connection)

            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode < HttpURLConnection.HTTP_BAD_REQUEST){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String temp = "";
                result ="";
                while ((temp = bufferedReader.readLine()) != null){
                    result += temp;
                }

                Log.d("ServerConnection","jsonResponse"+ result);
            }else if(responseCode == HttpURLConnection.HTTP_UNAUTHORIZED){
                result= "HTTP Unautorized";
            }else {
                result= "HTTP Bad Request Message";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            result = e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            result = e.getMessage();
            e.printStackTrace();
        }

        return result;
    }

}
