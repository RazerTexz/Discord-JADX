package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.home.HomePanelsLayout;
import p007b.p008a.p025i.WidgetHomePanelCenterBinding;
import p007b.p008a.p025i.WidgetHomePanelLeftBinding;
import p007b.p008a.p025i.WidgetHomePanelLoadingBinding;
import p007b.p008a.p025i.WidgetHomePanelRightBinding;

/* loaded from: classes.dex */
public final class WidgetHomeBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f17124a;

    /* renamed from: b */
    @NonNull
    public final WidgetHomePanelLoadingBinding f17125b;

    /* renamed from: c */
    @NonNull
    public final HomePanelsLayout f17126c;

    /* renamed from: d */
    @NonNull
    public final WidgetHomePanelCenterBinding f17127d;

    /* renamed from: e */
    @NonNull
    public final WidgetHomePanelLeftBinding f17128e;

    /* renamed from: f */
    @NonNull
    public final WidgetHomePanelRightBinding f17129f;

    /* renamed from: g */
    @NonNull
    public final ImageView f17130g;

    /* renamed from: h */
    @NonNull
    public final FrameLayout f17131h;

    public WidgetHomeBinding(@NonNull FrameLayout frameLayout, @NonNull WidgetHomePanelLoadingBinding widgetHomePanelLoadingBinding, @NonNull HomePanelsLayout homePanelsLayout, @NonNull WidgetHomePanelCenterBinding widgetHomePanelCenterBinding, @NonNull WidgetHomePanelLeftBinding widgetHomePanelLeftBinding, @NonNull WidgetHomePanelRightBinding widgetHomePanelRightBinding, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2) {
        this.f17124a = frameLayout;
        this.f17125b = widgetHomePanelLoadingBinding;
        this.f17126c = homePanelsLayout;
        this.f17127d = widgetHomePanelCenterBinding;
        this.f17128e = widgetHomePanelLeftBinding;
        this.f17129f = widgetHomePanelRightBinding;
        this.f17130g = imageView;
        this.f17131h = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17124a;
    }
}
