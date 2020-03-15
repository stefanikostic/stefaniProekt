package com.example.stefaniProekt.threads;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Scope("prototype")
public class MyThread implements Runnable {
    @Override
    @Async
    public void run() {
        try {
            System.out.println("Called from thread!");
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://kam.com.mk/topponuda/");
            HttpResponse response;
            StringBuilder builder = new StringBuilder();
            response = httpClient.execute(httpPost);
            System.out.println(response.toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            char[] buf = new char[1000];
            int l = 0;
            while (l >= 0) {
                builder.append(buf, 0, l);
                l = in.read(buf);
            }
            int firstIndex = 0;
            int lastIndex = 0;
            String substring = builder.toString().substring(lastIndex);
            // System.out.println("lala"+builder.toString());
            while (true) {
                substring = substring.substring(lastIndex);
                firstIndex = substring.indexOf("http://kam.com.mk/wp-content/uploads/");
                // System.out.println(firstIndex);
                //  System.out.println(builder.toString().substring(firstIndex));
                lastIndex = firstIndex + (substring.substring(firstIndex)).indexOf(".jpg");
                // System.out.println(firstIndex+lastIndex);
                if (substring.substring(firstIndex, lastIndex).contains("TOP-PONUDA")) {
                    System.out.println(substring.substring(firstIndex, lastIndex + 4));
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException :" + e);
            e.printStackTrace();
        }
    }
}
