package com.xunsheng;

import java.util.ArrayList;

public class Print {
    public void printData(ArrayList<GitHubAccount> follower){
        System.out.printf("\n Zhamri's GitHub followers" +
                "\n ________________________________________________________________________________________________________________________________________________________" +
                "\n| No.  | Login ID                 | Number of Repositories | Number of Followers | Following Count | Github Link                                         |" +
                "\n|------|--------------------------|------------------------|---------------------|-----------------|-----------------------------------------------------|");

        for(int i = 0; i < follower.size(); i++){
            System.out.printf("\n| %-4d | %-24s | %-22d | %-19d | %-15d | %-51s |",(i+1),follower.get(i).getLogin(),follower.get(i).getRepoNo(),follower.get(i).getFollowers(),follower.get(i).getFollowing(),follower.get(i).getProfileURL() );
        }

        System.out.printf("\n ________________________________________________________________________________________________________________________________________________________");
    }
}
