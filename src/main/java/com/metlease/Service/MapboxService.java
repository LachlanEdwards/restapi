package com.metlease.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.json.*;

@Service
@Scope("prototype")
public class MapboxService {
    public String[] getMapboxResponse(String q) {
        try {
            URL url = new URL("https://api.mapbox.com/geocoding/v5/mapbox.places/" + URLEncoder.encode(q, StandardCharsets.UTF_8.name()) + ".json?access_token=pk.eyJ1IjoibWV0bGVhc2UiLCJhIjoiY2pyYzA5ZW1sMThhdjN5cG45N24wZzk3aCJ9.sgPujNuDMhFzEElX-P83aQ&autocomplete=true&types=address&limit=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObject = new JSONObject(response.toString());

            BigDecimal x = jsonObject.getJSONArray("features").getJSONObject(0).getJSONArray("center").getBigDecimal(0);
            BigDecimal y = jsonObject.getJSONArray("features").getJSONObject(0).getJSONArray("center").getBigDecimal(1);

            String cd[] = {x.toString(), y.toString()};
            return cd;
        } catch (Exception e) {
            return new String[] {e.getMessage()};
        }
    }
}
