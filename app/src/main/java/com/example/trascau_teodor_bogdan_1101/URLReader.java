package com.example.trascau_teodor_bogdan_1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class URLReader {
    String urlStr;
   public URLReader(String url)
   {
       this. urlStr = url;
   }

   public String read() throws IOException {
       StringBuilder result = new StringBuilder();
       URL url = new URL(urlStr);
       HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
       InputStream stream = connection.getInputStream();
       BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

       String line;
       while((line = reader.readLine())!=null)
       {
           result.append(line);
       }
       reader.close();
       stream.close();
       connection.disconnect();

       return result.toString();
   }

   void Init()
   {

   }
}
