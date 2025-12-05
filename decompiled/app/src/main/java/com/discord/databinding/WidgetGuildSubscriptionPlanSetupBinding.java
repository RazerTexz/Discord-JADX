package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.steps.StepsView;

/* loaded from: classes.dex */
public final class WidgetGuildSubscriptionPlanSetupBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final StepsView f17071a;

    /* renamed from: b */
    @NonNull
    public final StepsView f17072b;

    public WidgetGuildSubscriptionPlanSetupBinding(@NonNull StepsView stepsView, @NonNull StepsView stepsView2) {
        this.f17071a = stepsView;
        this.f17072b = stepsView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17071a;
    }
}
