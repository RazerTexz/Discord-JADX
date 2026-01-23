package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import p007b.p008a.p025i.LayoutIconUploaderBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCreateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16768a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f16769b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f16770c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LayoutIconUploaderBinding f16771d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextInputLayout f16772e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ScreenTitleView f16773f;

    public WidgetGuildCreateBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LayoutIconUploaderBinding layoutIconUploaderBinding, @NonNull TextInputLayout textInputLayout, @NonNull ScreenTitleView screenTitleView) {
        this.f16768a = coordinatorLayout;
        this.f16769b = loadingButton;
        this.f16770c = linkifiedTextView;
        this.f16771d = layoutIconUploaderBinding;
        this.f16772e = textInputLayout;
        this.f16773f = screenTitleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16768a;
    }
}
