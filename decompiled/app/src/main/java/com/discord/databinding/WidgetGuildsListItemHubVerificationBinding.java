package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.tooltips.SparkleView;

/* loaded from: classes.dex */
public final class WidgetGuildsListItemHubVerificationBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f17118a;

    /* renamed from: b */
    @NonNull
    public final SparkleView f17119b;

    public WidgetGuildsListItemHubVerificationBinding(@NonNull FrameLayout frameLayout, @NonNull SparkleView sparkleView) {
        this.f17118a = frameLayout;
        this.f17119b = sparkleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17118a;
    }
}
