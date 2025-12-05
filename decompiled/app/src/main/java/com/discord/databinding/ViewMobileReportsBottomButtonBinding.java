package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class ViewMobileReportsBottomButtonBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f15512a;

    /* renamed from: b */
    @NonNull
    public final LoadingButton f15513b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f15514c;

    /* renamed from: d */
    @NonNull
    public final LinkifiedTextView f15515d;

    /* renamed from: e */
    @NonNull
    public final TextView f15516e;

    public ViewMobileReportsBottomButtonBinding(@NonNull View view, @NonNull LoadingButton loadingButton, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.f15512a = view;
        this.f15513b = loadingButton;
        this.f15514c = materialButton;
        this.f15515d = linkifiedTextView;
        this.f15516e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15512a;
    }
}
