package com.xunsheng;

import java.util.ArrayList;

public class Print {
    public void printData(ArrayList<GitHubAccount> follower){
        System.out.printf("\n Zhamri's GitHub followers" +
                "\n ____________________________________________________________________________________________________________________" +
                "\n| No.  | Login ID                 | Number of Repositories | Number of Followers | Following Count | Number of Gists |" +
                "\n|------|--------------------------|------------------------|---------------------|-----------------|-----------------|");

        for(int i = 0; i < follower.size(); i++){
            System.out.printf("\n| %-4d | %-24s | %-22d | %-19d | %-15d | %-15d |",(i+1),follower.get(i).getLogin(),follower.get(i).getRepoNo(),follower.get(i).getFollowers(),follower.get(i).getFollowing(),follower.get(i).getGists() );
        }

        System.out.printf("\n ____________________________________________________________________________________________________________________");
    }
}
