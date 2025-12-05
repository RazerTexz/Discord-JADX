package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.steps.StepsView;

/* loaded from: classes.dex */
public final class WidgetEnableMfaStepsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f16589a;

    /* renamed from: b */
    @NonNull
    public final DimmerView f16590b;

    /* renamed from: c */
    @NonNull
    public final StepsView f16591c;

    public WidgetEnableMfaStepsBinding(@NonNull FrameLayout frameLayout, @NonNull DimmerView dimmerView, @NonNull StepsView stepsView) {
        this.f16589a = frameLayout;
        this.f16590b = dimmerView;
        this.f16591c = stepsView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16589a;
    }
}
