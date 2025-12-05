package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* loaded from: classes.dex */
public final class WidgetHubEventsFooterBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17181a;

    /* renamed from: b */
    @NonNull
    public final LoadingButton f17182b;

    public WidgetHubEventsFooterBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton) {
        this.f17181a = linearLayout;
        this.f17182b = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17181a;
    }
}
