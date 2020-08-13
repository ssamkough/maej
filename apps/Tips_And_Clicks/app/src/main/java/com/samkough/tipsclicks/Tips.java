package com.samkough.tipsclicks;

import java.util.ArrayList;

public class Tips
{
    ArrayList<String> tips;

    public Tips()
    {
        tips = new ArrayList<>();
    }

    public String addTip(String n)
    {
        String result = "";

        result += tips.add(n);

        return result;
    }

    public String getTip(int n)
    {
        String result = "";

        result += tips.get(n);

        return result;
    }

    public int getAmountOfTips()
    {
        int size;
        size = tips.size();

        return size;
    }
}
