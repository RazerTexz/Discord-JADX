package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetVoiceNoiseCancellationBottomSheetBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f18479a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f18480b;

    /* renamed from: c */
    @NonNull
    public final TextView f18481c;

    public WidgetVoiceNoiseCancellationBottomSheetBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView) {
        this.f18479a = linearLayout;
        this.f18480b = materialButton;
        this.f18481c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18479a;
    }
}
