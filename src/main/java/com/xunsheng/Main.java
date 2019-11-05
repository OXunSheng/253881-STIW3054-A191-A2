package com.xunsheng;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static String token = "25c0623f68acb69bc80089d6498715e46254dde4";
    private static String url1 = "https://api.github.com/users/zhamri/followers?per_page=100";
    private static String url2 = "https://api.github.com/users/zhamri/followers?per_page=100&page=2";
    private static final ArrayList<GitHubAccount> follower = new ArrayList<GitHubAccount>();
    private static final ArrayList<GitHubAccount> personalData = new ArrayList<GitHubAccount>();


    public static void main(String[] args) {
        readJson rJ = new readJson();
        readJson rJ2 = new readJson();
        rJ.readAPI(token,url1);
        follower.addAll(rJ.arrayList());
        rJ2.readAPI(token,url2);
        follower.addAll(rJ2.arrayList());

        ExecutorService executor = Executors.newFixedThreadPool(follower.size());
        for(int i = 0; i < follower.size(); i++){
            String url = follower.get(i).getUrl();
            readPersonalData worker = new readPersonalData(token, url, personalData);
            executor.execute(worker);
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()){

        }


        compareData compare = new compareData();
        compare.compareData(follower, personalData);

        Print print = new Print();
        print.printData(follower);

        exportToExcel export = new exportToExcel();
        try{
            export.exportExcel(follower);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    
    public void run() {
    	
    }

}
