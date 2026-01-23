package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import p007b.p008a.p025i.WidgetRemoteAuthNotFoundBinding;
import p007b.p008a.p025i.WidgetRemoteAuthPendingLoginBinding;
import p007b.p008a.p025i.WidgetRemoteAuthSuccessBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetRemoteAuthBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17406a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final WidgetRemoteAuthSuccessBinding f17407b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final WidgetRemoteAuthNotFoundBinding f17408c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final WidgetRemoteAuthPendingLoginBinding f17409d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final AppViewFlipper f17410e;

    public WidgetRemoteAuthBinding(@NonNull RelativeLayout relativeLayout, @NonNull WidgetRemoteAuthSuccessBinding widgetRemoteAuthSuccessBinding, @NonNull WidgetRemoteAuthNotFoundBinding widgetRemoteAuthNotFoundBinding, @NonNull WidgetRemoteAuthPendingLoginBinding widgetRemoteAuthPendingLoginBinding, @NonNull AppViewFlipper appViewFlipper) {
        this.f17406a = relativeLayout;
        this.f17407b = widgetRemoteAuthSuccessBinding;
        this.f17408c = widgetRemoteAuthNotFoundBinding;
        this.f17409d = widgetRemoteAuthPendingLoginBinding;
        this.f17410e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17406a;
    }
}
