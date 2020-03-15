package com.example.stefaniProekt.service.getData;

import com.example.stefaniProekt.service.PromotionService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class GetDataService {
    private final RestTemplate restTemplate;
    private final PromotionService promotionService;

    public GetDataService(RestTemplateBuilder restTemplateBuilder, PromotionService promotionService) {
        this.restTemplate = restTemplateBuilder.build();
        this.promotionService = promotionService;
    }

    //@Async("taskExecutor")
    public void findImageUrl(){
        this.promotionService.deleteAllPromotions();
        findImgTopPonudaKam();
        findImgAkcijaVikendKam();
    }

    @Async ("taskExecutor")
    public void findImgAkcijaVikendKam() {
        String url="";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://kam.com.mk/akcija/");
            HttpResponse response;
            StringBuilder builder = new StringBuilder();
            response = httpClient.execute(httpPost);
            //System.out.println(response.toString());
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
        //    System.out.println(builder.toString());
            while (true) {
                substring = substring.substring(lastIndex);
                firstIndex = substring.indexOf("http://kam.com.mk/wp-content/uploads/");
                //  System.out.println(firstIndex);
                //  System.out.println(builder.toString().substring(firstIndex));
                lastIndex = firstIndex + (substring.substring(firstIndex)).indexOf(".jpg");
                // System.out.println(firstIndex+lastIndex);
                if (substring.substring(firstIndex, lastIndex).contains("SUPER-VIKEND")) {
                    url = substring.substring(firstIndex,lastIndex+4);
                    changeUrl(url);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e);
            e.printStackTrace();
        }
    }

    @Async ("taskExecutor")
    public void changeUrl(String url){
        this.promotionService.createPromotion(url);
    }

    @Async ("taskExecutor")
    public void findImgTopPonudaKam(){
        String url="";
        try {
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
            System.out.println(builder.toString());
            while (true) {
                substring = substring.substring(lastIndex);
                firstIndex = substring.indexOf("300w, http://kam.com.mk/wp-content/uploads/");
                //  System.out.println(firstIndex);
                //  System.out.println(builder.toString().substring(firstIndex));
                lastIndex = firstIndex + (substring.substring(firstIndex)).indexOf("768x766.jpg");
                System.out.println("vk:"+firstIndex+lastIndex);
                if (substring.substring(firstIndex, lastIndex).contains("TOP-PONUDA")) {
                    url = substring.substring(firstIndex+5,lastIndex+11);
                    System.out.println(url);
                    changeUrl(url);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e);
            e.printStackTrace();
        }
    }
}

