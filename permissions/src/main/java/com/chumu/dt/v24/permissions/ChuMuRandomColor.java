package com.chumu.dt.v24.permissions;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;

public class ChuMuRandomColor {

    private static String getRandColorCode() {
        String r, g, b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;

        return "#"+r + g + b;
    }
    public static int onRandomColor() {
        return Color.parseColor(getRandColorCode());
    }
}
