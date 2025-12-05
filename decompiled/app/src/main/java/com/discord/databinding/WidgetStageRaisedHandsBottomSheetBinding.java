package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;

/* loaded from: classes.dex */
public final class WidgetStageRaisedHandsBottomSheetBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f18165a;

    /* renamed from: b */
    @NonNull
    public final MaterialTextView f18166b;

    /* renamed from: c */
    @NonNull
    public final Group f18167c;

    /* renamed from: d */
    @NonNull
    public final SwitchMaterial f18168d;

    /* renamed from: e */
    @NonNull
    public final MaxHeightRecyclerView f18169e;

    /* renamed from: f */
    @NonNull
    public final MaterialTextView f18170f;

    /* renamed from: g */
    @NonNull
    public final MaterialTextView f18171g;

    /* renamed from: h */
    @NonNull
    public final ImageView f18172h;

    public WidgetStageRaisedHandsBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MaterialTextView materialTextView, @NonNull Group group, @NonNull ImageView imageView, @NonNull MaterialTextView materialTextView2, @NonNull MaterialTextView materialTextView3, @NonNull SwitchMaterial switchMaterial, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull MaxHeightRecyclerView maxHeightRecyclerView, @NonNull MaterialTextView materialTextView4, @NonNull MaterialTextView materialTextView5, @NonNull MaterialTextView materialTextView6, @NonNull Group group2, @NonNull ImageView imageView2) {
        this.f18165a = coordinatorLayout;
        this.f18166b = materialTextView;
        this.f18167c = group;
        this.f18168d = switchMaterial;
        this.f18169e = maxHeightRecyclerView;
        this.f18170f = materialTextView4;
        this.f18171g = materialTextView6;
        this.f18172h = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18165a;
    }
}
