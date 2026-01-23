package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import p007b.p008a.p025i.ViewUserStatusPresenceBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusUpdateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f18431a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final UserStatusPresenceCustomView f18432b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ViewUserStatusPresenceBinding f18433c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ViewUserStatusPresenceBinding f18434d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ViewUserStatusPresenceBinding f18435e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ViewUserStatusPresenceBinding f18436f;

    public WidgetUserStatusUpdateBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull UserStatusPresenceCustomView userStatusPresenceCustomView, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding2, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding3, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding4) {
        this.f18431a = nestedScrollView;
        this.f18432b = userStatusPresenceCustomView;
        this.f18433c = viewUserStatusPresenceBinding;
        this.f18434d = viewUserStatusPresenceBinding2;
        this.f18435e = viewUserStatusPresenceBinding3;
        this.f18436f = viewUserStatusPresenceBinding4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18431a;
    }
}
