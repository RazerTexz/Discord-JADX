package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.settings.profile.TouchInterceptingCoordinatorLayout;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetSettingsUserProfileBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final TouchInterceptingCoordinatorLayout f18076a;

    /* renamed from: b */
    @NonNull
    public final CardView f18077b;

    /* renamed from: c */
    @NonNull
    public final TextInputEditText f18078c;

    /* renamed from: d */
    @NonNull
    public final TextInputLayout f18079d;

    /* renamed from: e */
    @NonNull
    public final TextView f18080e;

    /* renamed from: f */
    @NonNull
    public final TextView f18081f;

    /* renamed from: g */
    @NonNull
    public final CardView f18082g;

    /* renamed from: h */
    @NonNull
    public final LinkifiedTextView f18083h;

    /* renamed from: i */
    @NonNull
    public final DimmerView f18084i;

    /* renamed from: j */
    @NonNull
    public final TextView f18085j;

    /* renamed from: k */
    @NonNull
    public final LinearLayout f18086k;

    /* renamed from: l */
    @NonNull
    public final LinearLayout f18087l;

    /* renamed from: m */
    @NonNull
    public final FloatingActionButton f18088m;

    /* renamed from: n */
    @NonNull
    public final TextInputLayout f18089n;

    /* renamed from: o */
    @NonNull
    public final UserProfileHeaderView f18090o;

    public WidgetSettingsUserProfileBinding(@NonNull TouchInterceptingCoordinatorLayout touchInterceptingCoordinatorLayout, @NonNull CardView cardView, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CardView cardView2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull DimmerView dimmerView, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CardView cardView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout3, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout2, @NonNull NestedScrollView nestedScrollView, @NonNull UserProfileHeaderView userProfileHeaderView) {
        this.f18076a = touchInterceptingCoordinatorLayout;
        this.f18077b = cardView;
        this.f18078c = textInputEditText;
        this.f18079d = textInputLayout;
        this.f18080e = textView;
        this.f18081f = textView2;
        this.f18082g = cardView2;
        this.f18083h = linkifiedTextView;
        this.f18084i = dimmerView;
        this.f18085j = textView3;
        this.f18086k = linearLayout;
        this.f18087l = linearLayout2;
        this.f18088m = floatingActionButton;
        this.f18089n = textInputLayout2;
        this.f18090o = userProfileHeaderView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18076a;
    }
}
