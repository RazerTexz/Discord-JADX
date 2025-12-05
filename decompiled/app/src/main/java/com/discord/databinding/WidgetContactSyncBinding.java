package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import p007b.p008a.p025i.LayoutContactSyncAddPhoneBinding;
import p007b.p008a.p025i.LayoutContactSyncLandingBinding;
import p007b.p008a.p025i.LayoutContactSyncNameInputBinding;
import p007b.p008a.p025i.LayoutContactSyncSuggestionsBinding;
import p007b.p008a.p025i.LayoutContactSyncSuggestionsEmptyBinding;
import p007b.p008a.p025i.LayoutContactSyncVerifyPhoneBinding;

/* loaded from: classes.dex */
public final class WidgetContactSyncBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16409a;

    /* renamed from: b */
    @NonNull
    public final LayoutContactSyncAddPhoneBinding f16410b;

    /* renamed from: c */
    @NonNull
    public final LayoutContactSyncSuggestionsBinding f16411c;

    /* renamed from: d */
    @NonNull
    public final LayoutContactSyncSuggestionsEmptyBinding f16412d;

    /* renamed from: e */
    @NonNull
    public final LayoutContactSyncLandingBinding f16413e;

    /* renamed from: f */
    @NonNull
    public final LayoutContactSyncNameInputBinding f16414f;

    /* renamed from: g */
    @NonNull
    public final LayoutContactSyncVerifyPhoneBinding f16415g;

    /* renamed from: h */
    @NonNull
    public final AppViewFlipper f16416h;

    public WidgetContactSyncBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LayoutContactSyncAddPhoneBinding layoutContactSyncAddPhoneBinding, @NonNull LayoutContactSyncSuggestionsBinding layoutContactSyncSuggestionsBinding, @NonNull LayoutContactSyncSuggestionsEmptyBinding layoutContactSyncSuggestionsEmptyBinding, @NonNull LayoutContactSyncLandingBinding layoutContactSyncLandingBinding, @NonNull LayoutContactSyncNameInputBinding layoutContactSyncNameInputBinding, @NonNull LayoutContactSyncVerifyPhoneBinding layoutContactSyncVerifyPhoneBinding, @NonNull AppViewFlipper appViewFlipper) {
        this.f16409a = coordinatorLayout;
        this.f16410b = layoutContactSyncAddPhoneBinding;
        this.f16411c = layoutContactSyncSuggestionsBinding;
        this.f16412d = layoutContactSyncSuggestionsEmptyBinding;
        this.f16413e = layoutContactSyncLandingBinding;
        this.f16414f = layoutContactSyncNameInputBinding;
        this.f16415g = layoutContactSyncVerifyPhoneBinding;
        this.f16416h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16409a;
    }
}
