package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.LayoutVoiceBottomSheetEmptyBinding;
import p007b.p008a.p025i.LayoutVoiceBottomSheetHeaderBinding;

/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheetBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f18437a;

    /* renamed from: b */
    @NonNull
    public final LayoutVoiceBottomSheetEmptyBinding f18438b;

    /* renamed from: c */
    @NonNull
    public final LayoutVoiceBottomSheetHeaderBinding f18439c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f18440d;

    /* renamed from: e */
    @NonNull
    public final RelativeLayout f18441e;

    /* renamed from: f */
    @NonNull
    public final AnchoredVoiceControlsView f18442f;

    /* renamed from: g */
    @NonNull
    public final MaterialButton f18443g;

    /* renamed from: h */
    @NonNull
    public final RecyclerView f18444h;

    /* renamed from: i */
    @NonNull
    public final CoordinatorLayout f18445i;

    public WidgetVoiceBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LayoutVoiceBottomSheetEmptyBinding layoutVoiceBottomSheetEmptyBinding, @NonNull LayoutVoiceBottomSheetHeaderBinding layoutVoiceBottomSheetHeaderBinding, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull RelativeLayout relativeLayout, @NonNull AnchoredVoiceControlsView anchoredVoiceControlsView, @NonNull MaterialButton materialButton2, @NonNull RecyclerView recyclerView, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.f18437a = coordinatorLayout;
        this.f18438b = layoutVoiceBottomSheetEmptyBinding;
        this.f18439c = layoutVoiceBottomSheetHeaderBinding;
        this.f18440d = materialButton;
        this.f18441e = relativeLayout;
        this.f18442f = anchoredVoiceControlsView;
        this.f18443g = materialButton2;
        this.f18444h = recyclerView;
        this.f18445i = coordinatorLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18437a;
    }
}
