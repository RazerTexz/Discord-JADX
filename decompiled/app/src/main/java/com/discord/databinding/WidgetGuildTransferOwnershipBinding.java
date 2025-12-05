package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetGuildTransferOwnershipBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17073a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f17074b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f17075c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f17076d;

    /* renamed from: e */
    @NonNull
    public final TextInputLayout f17077e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f17078f;

    public WidgetGuildTransferOwnershipBinding(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2) {
        this.f17073a = linearLayout;
        this.f17074b = checkedSetting;
        this.f17075c = materialButton;
        this.f17076d = materialButton2;
        this.f17077e = textInputLayout;
        this.f17078f = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17073a;
    }
}
