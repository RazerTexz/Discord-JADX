package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import p007b.p008a.p025i.LayoutAgeVerifyBinding;
import p007b.p008a.p025i.LayoutAgeVerifyConfirmBinding;
import p007b.p008a.p025i.LayoutAgeVerifyUnderageBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAgeVerifyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15643a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f15644b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LayoutAgeVerifyConfirmBinding f15645c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LayoutAgeVerifyUnderageBinding f15646d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LayoutAgeVerifyBinding f15647e;

    public WidgetAgeVerifyBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull LayoutAgeVerifyConfirmBinding layoutAgeVerifyConfirmBinding, @NonNull LayoutAgeVerifyUnderageBinding layoutAgeVerifyUnderageBinding, @NonNull LayoutAgeVerifyBinding layoutAgeVerifyBinding) {
        this.f15643a = coordinatorLayout;
        this.f15644b = appViewFlipper;
        this.f15645c = layoutAgeVerifyConfirmBinding;
        this.f15646d = layoutAgeVerifyUnderageBinding;
        this.f15647e = layoutAgeVerifyBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15643a;
    }
}
