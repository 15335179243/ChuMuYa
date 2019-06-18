package com.chumu.dt.v24.permissions;

import android.graphics.Color;

import java.util.ArrayList;

public class ChuMuRandomColor {
    public static int onRandomColor(){

        ArrayList<String> list = new ArrayList<>();
        list.add("#EA8227");
        list.add("#549821");
        list.add("#CD7E2D");
        list.add("#9081DE");
        list.add("#B642D3");
        list.add("#A878B4");
        list.add("#60EFF0");
        list.add("#AC25D2");
        list.add("#318FD7");
        list.add("#99D71F");
     return Color.parseColor(list.get((int) (1 + Math.random() * (10 - 1 + 1) - 1)));
    }
}
