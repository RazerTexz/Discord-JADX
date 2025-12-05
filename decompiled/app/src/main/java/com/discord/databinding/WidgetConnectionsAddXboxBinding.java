package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;

/* loaded from: classes.dex */
public final class WidgetConnectionsAddXboxBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16405a;

    /* renamed from: b */
    @NonNull
    public final CodeVerificationView f16406b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f16407c;

    /* renamed from: d */
    @NonNull
    public final DimmerView f16408d;

    public WidgetConnectionsAddXboxBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CodeVerificationView codeVerificationView, @NonNull LinearLayout linearLayout, @NonNull DimmerView dimmerView) {
        this.f16405a = coordinatorLayout;
        this.f16406b = codeVerificationView;
        this.f16407c = linearLayout;
        this.f16408d = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16405a;
    }
}
