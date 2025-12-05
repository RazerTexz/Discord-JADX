package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetServerSettingsEnableCommunityBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ScrollView f17658a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f17659b;

    public WidgetServerSettingsEnableCommunityBinding(@NonNull ScrollView scrollView, @NonNull ScreenTitleView screenTitleView, @NonNull ImageView imageView, @NonNull ScrollView scrollView2, @NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton) {
        this.f17658a = scrollView;
        this.f17659b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17658a;
    }
}
