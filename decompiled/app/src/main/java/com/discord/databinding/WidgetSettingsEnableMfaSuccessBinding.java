package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetSettingsEnableMfaSuccessBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17951a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f17952b;

    public WidgetSettingsEnableMfaSuccessBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton) {
        this.f17951a = linearLayout;
        this.f17952b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17951a;
    }
}
