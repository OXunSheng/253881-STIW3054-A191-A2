package com.xunsheng;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class readPersonalData implements Runnable{

    private ArrayList<GitHubAccount> data = new ArrayList<GitHubAccount>();
    private final String token, url;

    readPersonalData(String token, String url, ArrayList<GitHubAccount> data){
        this.token = token;
        this.url = url;
        this.data = data;
    }

    public String parse(String responseBody){
        JSONObject personalData = new JSONObject(responseBody);

        int followers = personalData.getInt("followers");
        int repoNo = personalData.getInt("public_repos");
        int following = personalData.getInt("following");
        int gists = personalData.getInt("public_gists");

        data.add(new GitHubAccount(followers, repoNo, following, gists, url));

        return null;
    }

    public ArrayList<GitHubAccount> arrayList(){
        return data;
    }

    @Override
    public void run() {
        String curl = "curl " + url + "?access_token="+token;

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
}
