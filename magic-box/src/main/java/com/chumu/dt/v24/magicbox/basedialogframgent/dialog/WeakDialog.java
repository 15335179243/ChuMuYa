package com.chumu.dt.v24.magicbox.basedialogframgent.dialog;

import android.app.Dialog;
import android.content.Context;

import com.chumu.dt.v24.magicbox.basedialogframgent.utils.Weak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;




public class WeakDialog extends Dialog {
    public WeakDialog(@NonNull Context context) {
        super(context);
    }

    public WeakDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected WeakDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void setOnCancelListener(@Nullable OnCancelListener listener) {
        super.setOnCancelListener(Weak.proxy(listener));
    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        super.setOnDismissListener(Weak.proxy(listener));
    }

    @Override
    public void setOnShowListener(@Nullable OnShowListener listener) {
        super.setOnShowListener(Weak.proxy(listener));
    }
}
