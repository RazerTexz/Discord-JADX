package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetBanUserBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f15723a;

    /* renamed from: b */
    @NonNull
    public final TextView f15724b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f15725c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f15726d;

    /* renamed from: e */
    @NonNull
    public final CheckedSetting f15727e;

    /* renamed from: f */
    @NonNull
    public final CheckedSetting f15728f;

    /* renamed from: g */
    @NonNull
    public final CheckedSetting f15729g;

    /* renamed from: h */
    @NonNull
    public final TextInputLayout f15730h;

    /* renamed from: i */
    @NonNull
    public final TextView f15731i;

    public WidgetBanUserBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3) {
        this.f15723a = linearLayout;
        this.f15724b = textView;
        this.f15725c = materialButton;
        this.f15726d = materialButton2;
        this.f15727e = checkedSetting;
        this.f15728f = checkedSetting2;
        this.f15729g = checkedSetting3;
        this.f15730h = textInputLayout;
        this.f15731i = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15723a;
    }
}
