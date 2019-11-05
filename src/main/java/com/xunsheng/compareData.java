package com.xunsheng;

import java.util.ArrayList;

public class compareData {
    //Compare data that have the same api url
    public void compareData(ArrayList<GitHubAccount> follower, ArrayList <GitHubAccount> personal){
        for(int i = 0; i < follower.size(); i++){

            for(int j = 0; j < personal.size(); j++){
                if((follower.get(i).getUrl().equals(personal.get(j).getUrl()))){

                    follower.get(i).setFollowers(personal.get(j).getFollowers());
                    follower.get(i).setRepoNo(personal.get(j).getRepoNo());
                    follower.get(i).setFollowing(personal.get(j).getFollowing());
                    follower.get(i).setGists(personal.get(j).getGists());
                }
            }

        }

    }
}
