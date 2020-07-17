package com.chumu.dt.v24.magicbox.basedialogframgent.androidx;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.chumu.dt.v24.magicbox.R;
import com.chumu.dt.v24.magicbox.basedialogframgent.aosp.ChuMuDialogFragment;
import com.chumu.dt.v24.magicbox.basedialogframgent.dialog.CancelableDialog;

import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class ChuMuBaseDialogFragment extends ChuMuDialogFragment implements CancelableDialog.PreCancelCallback,
        CancelableDialog.ShouldCancelCallback {

    private static final float DEFAULT_DIM = 0.8f;

    private DismissListener dismissListener;
    private boolean mCancelOnTouchOutside = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(ChuMuDialogFragment.STYLE_NO_TITLE, getTheme());
    }

    /**
     * 如果需要设置主题，请重写这个函数，并返回一个主题
     */
    @Override
    public int getTheme() {
        return R.style.ChuMuBaseDialogStyle;
    }

    /**
     * 最好不要重写这个函数，如果必须重写，那最好不要自己 new Dialog() 否则这个类就失去了意义
     */
    @CallSuper
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        CancelableDialog dialog = new CancelableDialog(getActivity(), getTheme());
        Window window = dialog.getWindow();
        window.setDimAmount(getDimAmount());
        window.setGravity(getGravity());
        dialog.setPreCancelCallback(this);
        dialog.setShouldCancelCallback(this);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            Window window = getDialog().getWindow();
            // 获取对话框当前的参数值
            WindowManager.LayoutParams p = window.getAttributes();
            // 宽度设置为屏幕的比例
            p.width = (int) (dm.widthPixels * getWidthPercent());
            // 设置本身透明度
            p.alpha = getAlpha();
            window.setAttributes(p);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    protected float getWidthPercent(){
        return 0.8f;
    }

    protected float getAlpha(){
        return 1.0f;
    }

    protected int getGravity(){
        return Gravity.CENTER;
    }

    /**
     * dialog 非内容区域的黑色透明度，默认 0.8
     */
    protected float getDimAmount() {
        return DEFAULT_DIM;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getLayoutRes(), container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView(view);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            //在每个add事务前增加一个remove事务，防止连续的add
            manager.beginTransaction().remove(this).commit();
            FragmentTransaction ft = manager.beginTransaction();
            ft.add(this, tag);
            ft.commitAllowingStateLoss();
        } catch (Exception e) {
            //同一实例使用不同的tag会异常,这里捕获一下
            e.printStackTrace();
        }
    }

    @Deprecated
    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }

    /**
     * 安全的显示 dialog
     */
    public void showAllowingStateLoss(FragmentManager fmgr) {
        show(fmgr, getFragmentTag());
    }

    @LayoutRes
    public abstract int getLayoutRes();

    public abstract void bindView(View v);

    /**
     * 点击返回按钮， dialog 是否应该消失
     */
    @Override
    public boolean shouldCancelOnBackPressed() {
        return true;
    }

    /**
     * 点击 dialog 的 外围 是否应该消失
     */
    @Override
    public boolean shouldCancelOnTouchOutside() {
        return mCancelOnTouchOutside;
    }

    public final void setCancelOnTouchOutside(boolean cancelOnTouchOutside) {
        mCancelOnTouchOutside = cancelOnTouchOutside;
    }

    /**
     * cancel 之前的回调
     */
    @Override
    public void onPreCancel() {
    }

    @Override
    public void dismiss() {
        if(isAdded())
            dismissAllowingStateLoss();
    }

    public void setOnDismissListener(DismissListener listener) {
        dismissListener = listener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (null != dismissListener) {
            dismissListener.onDismiss();
        }
    }

    public interface DismissListener {
        void onDismiss();
    }

    public String getFragmentTag() {
        return "dialog_" + getIdentityString();
    }

    protected String getIdentityString() {
        return Integer.toHexString(System.identityHashCode(this));
    }
}
