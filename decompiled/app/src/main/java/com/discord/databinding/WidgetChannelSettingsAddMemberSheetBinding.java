package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChannelSettingsAddMemberSheetBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f15904a;

    /* renamed from: b */
    @NonNull
    public final TextView f15905b;

    /* renamed from: c */
    @NonNull
    public final FragmentContainerView f15906c;

    /* renamed from: d */
    @NonNull
    public final TextView f15907d;

    public WidgetChannelSettingsAddMemberSheetBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull FragmentContainerView fragmentContainerView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15904a = linearLayout;
        this.f15905b = textView;
        this.f15906c = fragmentContainerView;
        this.f15907d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15904a;
    }
}
