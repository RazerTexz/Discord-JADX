package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.WidgetDiscordHubEmailInputBinding;
import p007b.p008a.p025i.WidgetHubEmailFlowConfirmationBinding;
import p007b.p008a.p025i.WidgetHubEmailFlowWaitlistBinding;

/* loaded from: classes.dex */
public final class WidgetHubEmailFlowBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17173a;

    /* renamed from: b */
    @NonNull
    public final WidgetHubEmailFlowConfirmationBinding f17174b;

    /* renamed from: c */
    @NonNull
    public final WidgetDiscordHubEmailInputBinding f17175c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f17176d;

    /* renamed from: e */
    @NonNull
    public final LoadingButton f17177e;

    /* renamed from: f */
    @NonNull
    public final WidgetHubEmailFlowWaitlistBinding f17178f;

    public WidgetHubEmailFlowBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull WidgetHubEmailFlowConfirmationBinding widgetHubEmailFlowConfirmationBinding, @NonNull WidgetDiscordHubEmailInputBinding widgetDiscordHubEmailInputBinding, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull WidgetHubEmailFlowWaitlistBinding widgetHubEmailFlowWaitlistBinding) {
        this.f17173a = linearLayout;
        this.f17174b = widgetHubEmailFlowConfirmationBinding;
        this.f17175c = widgetDiscordHubEmailInputBinding;
        this.f17176d = materialButton;
        this.f17177e = loadingButton;
        this.f17178f = widgetHubEmailFlowWaitlistBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17173a;
    }
}
