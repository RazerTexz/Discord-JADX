package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CodeVerificationView;

/* loaded from: classes.dex */
public final class WidgetSettingsEnableMfaInputBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17945a;

    /* renamed from: b */
    @NonNull
    public final CodeVerificationView f17946b;

    public WidgetSettingsEnableMfaInputBinding(@NonNull LinearLayout linearLayout, @NonNull CodeVerificationView codeVerificationView) {
        this.f17945a = linearLayout;
        this.f17946b = codeVerificationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17945a;
    }
}
