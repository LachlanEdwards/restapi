package com.metlease.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Service
@Scope("prototype")
public class NewsService {
    public String getGAPIResponse(String q) {
        try {
            URL url = new URL("https://gapi.xyz/api/v2/?q=" + URLEncoder.encode(q, StandardCharsets.UTF_8.name()) + "&max=3&token=440ab357af393afb834c0115e3b5c002");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
