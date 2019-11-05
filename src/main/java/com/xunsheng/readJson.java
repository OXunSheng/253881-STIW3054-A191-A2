package com.xunsheng;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class readJson implements readData {

    private final ArrayList<GitHubAccount> data = new ArrayList<GitHubAccount>();

    @Override
    public void readAPI(String token, String url){
        String curl = "curl " + url + "&access_token="+token;

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try{
            Process p = Runtime.getRuntime().exec(curl);
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line = reader.readLine()) != null){
                responseContent.append(line);
            }
            reader.close();

            parse(responseContent.toString());

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String parse(String responseBody){
        JSONArray followers = new JSONArray(responseBody);
        for(int i =0; i < followers.length(); i++){
            JSONObject follower = followers.getJSONObject(i);
            String loginID = follower.getString("login");
            String URL = follower.getString("url");

            data.add(new GitHubAccount(loginID,URL));


        }
        return null;
    }

    @Override
    public ArrayList<GitHubAccount> arrayList(){
        return data;
    }

}
