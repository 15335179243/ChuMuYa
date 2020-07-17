package com.chumu.dt.v24.magicbox.basedialogframgent.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CancelableDialog extends WeakDialog {

    private static final int[] GRAVITY_ATTR = {
            android.R.attr.gravity,
    };

    public CancelableDialog(@NonNull Context context) {
        super(context);
    }

    public CancelableDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        TypedArray a = context.obtainStyledAttributes(themeResId, GRAVITY_ATTR);
        int gravity = a.getInt(0, Gravity.CENTER);
        Window window = getWindow();
        window.setGravity(gravity);
        a.recycle();
    }

    protected CancelableDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private ShouldCancelCallback l;

    private PreCancelCallback mPreCancelCallback;

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        if (isShowing() && shouldCloseOnTouch(getContext(), event)) {
            cancel();
            return true;
        }
        return false;
    }

    /*
     * copy from Window.java
     */
    private boolean shouldCloseOnTouch(Context context, MotionEvent event) {
        return (l == null || l.shouldCancelOnTouchOutside())
                && event.getAction() == MotionEvent.ACTION_DOWN
                && isOutOfBounds(context, event) && (getWindow() == null ||
                getWindow().peekDecorView() != null);
    }

    /*
     * copy from Window.java
     */
    private boolean isOutOfBounds(Context context, MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        if (getWindow() == null) return true;
        final View decorView = getWindow().getDecorView();
        return (x < -slop) || (y < -slop)
                || (x > (decorView.getWidth() + slop))
                || (y > (decorView.getHeight() + slop));
    }

    @Deprecated
    @Override
    public void setCancelable(boolean flag) {
//        super.setCancelable(flag);
    }

    @Deprecated
    @Override
    public void setCanceledOnTouchOutside(boolean cancel) {
//        super.setCanceledOnTouchOutside(cancel);
    }

    @Override
    public void onBackPressed() {
        if (l == null || l.shouldCancelOnBackPressed()) {
            cancel();
        }
    }

    @Override
    public void cancel() {
        if (null != mPreCancelCallback) {
            mPreCancelCallback.onPreCancel();
        }
        super.cancel();
    }

    public void setPreCancelCallback(PreCancelCallback preCancelCallback) {
        mPreCancelCallback = preCancelCallback;
    }

    public void setShouldCancelCallback(ShouldCancelCallback shouldCancelCallback) {
        this.l = shouldCancelCallback;
    }

    public interface ShouldCancelCallback {
        boolean shouldCancelOnBackPressed();

        boolean shouldCancelOnTouchOutside();
    }

    public interface PreCancelCallback {
        void onPreCancel();
    }
}
