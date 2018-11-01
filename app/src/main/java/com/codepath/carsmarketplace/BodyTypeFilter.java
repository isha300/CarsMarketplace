package com.codepath.carsmarketplace;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BodyTypeFilter extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL cars = new URL("https://mock-cars-api.herokuapp.com/api/v1/cars");
            HttpURLConnection httpURLConnection = (HttpURLConnection) cars.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while(line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                if (JO.get("bodyType").equals(MainActivity.bodyType)) {
                    singleParsed = "\n" + JO.get("carYear") + " " + JO.get("makeName") + " " + JO.get("modelName")
                            + " (" + JO.get("bodyType") + ")" + "\n"
                            + "$" + JO.get("price") + "\n" +
                            "Rating: " + JO.get("sellerRating") + "\n" +
                            "Click on link to view image: " + JO.get("mainPictureUrl") + "\n" +
                            "___________________________________________________\n";
                    dataParsed = dataParsed + singleParsed;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.dataParsed);
        MainActivity.dismiss.setVisibility(View.VISIBLE);
        MainActivity.gray.setVisibility(View.INVISIBLE);
        MainActivity.blue.setVisibility(View.INVISIBLE);
        MainActivity.black.setVisibility(View.INVISIBLE);
        MainActivity.brown.setVisibility(View.INVISIBLE);
        MainActivity.white.setVisibility(View.INVISIBLE);
        MainActivity.silver.setVisibility(View.INVISIBLE);
        MainActivity.red.setVisibility(View.INVISIBLE);
        MainActivity.green.setVisibility(View.INVISIBLE);
        MainActivity.yellow.setVisibility(View.INVISIBLE);
        MainActivity.advanced.setVisibility(View.INVISIBLE);
        MainActivity.loading.setVisibility(View.INVISIBLE);
        MainActivity.colorbrowse.setVisibility(View.INVISIBLE);
        MainActivity.pricebrowse.setVisibility(View.INVISIBLE);
        MainActivity.twenty.setVisibility(View.INVISIBLE);
        MainActivity.forty.setVisibility(View.INVISIBLE);
        MainActivity.sixty.setVisibility(View.INVISIBLE);
        MainActivity.eighty.setVisibility(View.INVISIBLE);
        MainActivity.hundred.setVisibility(View.INVISIBLE);
        MainActivity.hundredTwenty.setVisibility(View.INVISIBLE);
        MainActivity.hundredForty.setVisibility(View.INVISIBLE);
        MainActivity.hundredSixty.setVisibility(View.INVISIBLE);
        MainActivity.hundredEighty.setVisibility(View.INVISIBLE);
        MainActivity.twoHundred.setVisibility(View.INVISIBLE);
    }
}
