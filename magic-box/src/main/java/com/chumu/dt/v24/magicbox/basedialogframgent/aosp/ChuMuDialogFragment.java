package com.chumu.dt.v24.magicbox.basedialogframgent.aosp;

import android.app.Dialog;
import android.os.Bundle;


import androidx.fragment.app.FixDialogFragment;
import com.chumu.dt.v24.magicbox.basedialogframgent.dialog.WeakDialog;

import org.jetbrains.annotations.NotNull;


public class ChuMuDialogFragment extends FixDialogFragment {
    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new WeakDialog(getActivity(), getTheme());
    }
}
