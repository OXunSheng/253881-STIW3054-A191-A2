package com.xunsheng;

import java.util.ArrayList;

public interface readData {
    public abstract void readAPI(String token, String url);
    public abstract String parse(String responseBody);
    public abstract ArrayList<GitHubAccount> arrayList();
}
