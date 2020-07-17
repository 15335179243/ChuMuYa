package com.chumu.dt.v24.magicbox.basedialogframgent.utils;

import android.content.DialogInterface;

import com.chumu.dt.v24.magicbox.basedialogframgent.utils.weakproxy.WeakOnCancelListener;
import com.chumu.dt.v24.magicbox.basedialogframgent.utils.weakproxy.WeakOnDismissListener;
import com.chumu.dt.v24.magicbox.basedialogframgent.utils.weakproxy.WeakOnShowListener;


public class Weak {
    public static WeakOnCancelListener proxy(DialogInterface.OnCancelListener real) {
        return new WeakOnCancelListener(real);
    }

    public static WeakOnDismissListener proxy(DialogInterface.OnDismissListener real) {
        return new WeakOnDismissListener(real);
    }

    public static WeakOnShowListener proxy(DialogInterface.OnShowListener real) {
        return new WeakOnShowListener(real);
    }
}
