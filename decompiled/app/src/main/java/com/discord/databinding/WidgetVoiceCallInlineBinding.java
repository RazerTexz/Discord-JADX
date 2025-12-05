package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetVoiceCallInlineBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f18455a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f18456b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f18457c;

    public WidgetVoiceCallInlineBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton) {
        this.f18455a = linearLayout;
        this.f18456b = linearLayout2;
        this.f18457c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18455a;
    }
}
