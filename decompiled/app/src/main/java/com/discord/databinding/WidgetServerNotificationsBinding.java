package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.NotificationHighlightsSettingsView;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import p007b.p008a.p025i.ViewAddOverrideItemBinding;

/* loaded from: classes.dex */
public final class WidgetServerNotificationsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17489a;

    /* renamed from: b */
    @NonNull
    public final ViewAddOverrideItemBinding f17490b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f17491c;

    /* renamed from: d */
    @NonNull
    public final CheckedSetting f17492d;

    /* renamed from: e */
    @NonNull
    public final CheckedSetting f17493e;

    /* renamed from: f */
    @NonNull
    public final CheckedSetting f17494f;

    /* renamed from: g */
    @NonNull
    public final CheckedSetting f17495g;

    /* renamed from: h */
    @NonNull
    public final View f17496h;

    /* renamed from: i */
    @NonNull
    public final LinearLayout f17497i;

    /* renamed from: j */
    @NonNull
    public final NotificationHighlightsSettingsView f17498j;

    /* renamed from: k */
    @NonNull
    public final View f17499k;

    /* renamed from: l */
    @NonNull
    public final NotificationMuteSettingsView f17500l;

    /* renamed from: m */
    @NonNull
    public final View f17501m;

    /* renamed from: n */
    @NonNull
    public final TextView f17502n;

    /* renamed from: o */
    @NonNull
    public final CheckedSetting f17503o;

    /* renamed from: p */
    @NonNull
    public final View f17504p;

    /* renamed from: q */
    @NonNull
    public final CheckedSetting f17505q;

    public WidgetServerNotificationsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ViewAddOverrideItemBinding viewAddOverrideItemBinding, @NonNull RecyclerView recyclerView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull NotificationHighlightsSettingsView notificationHighlightsSettingsView, @NonNull View view2, @NonNull NotificationMuteSettingsView notificationMuteSettingsView, @NonNull View view3, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting5, @NonNull View view4, @NonNull CheckedSetting checkedSetting6) {
        this.f17489a = coordinatorLayout;
        this.f17490b = viewAddOverrideItemBinding;
        this.f17491c = recyclerView;
        this.f17492d = checkedSetting;
        this.f17493e = checkedSetting2;
        this.f17494f = checkedSetting3;
        this.f17495g = checkedSetting4;
        this.f17496h = view;
        this.f17497i = linearLayout;
        this.f17498j = notificationHighlightsSettingsView;
        this.f17499k = view2;
        this.f17500l = notificationMuteSettingsView;
        this.f17501m = view3;
        this.f17502n = textView;
        this.f17503o = checkedSetting5;
        this.f17504p = view4;
        this.f17505q = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17489a;
    }
}
