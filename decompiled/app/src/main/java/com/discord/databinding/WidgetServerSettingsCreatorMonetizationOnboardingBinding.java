package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* loaded from: classes.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboardingBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17597a;

    /* renamed from: b */
    @NonNull
    public final TextView f17598b;

    /* renamed from: c */
    @NonNull
    public final ViewStub f17599c;

    /* renamed from: d */
    @NonNull
    public final ViewStub f17600d;

    /* renamed from: e */
    @NonNull
    public final AppViewFlipper f17601e;

    public WidgetServerSettingsCreatorMonetizationOnboardingBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull AppViewFlipper appViewFlipper) {
        this.f17597a = coordinatorLayout;
        this.f17598b = textView;
        this.f17599c = viewStub;
        this.f17600d = viewStub2;
        this.f17601e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17597a;
    }
}
