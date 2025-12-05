package com.discord.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guilds.invite.ViewInviteSettingsSheet;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetGuildInviteShareEmptySuggestionsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16825a;

    /* renamed from: b */
    @NonNull
    public final View f16826b;

    /* renamed from: c */
    @NonNull
    public final TextView f16827c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f16828d;

    /* renamed from: e */
    @NonNull
    public final ImageButton f16829e;

    /* renamed from: f */
    @NonNull
    public final TextView f16830f;

    /* renamed from: g */
    @NonNull
    public final ViewInviteSettingsSheet f16831g;

    public WidgetGuildInviteShareEmptySuggestionsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ImageButton imageButton, @NonNull TextView textView2, @NonNull ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.f16825a = coordinatorLayout;
        this.f16826b = view;
        this.f16827c = textView;
        this.f16828d = materialButton;
        this.f16829e = imageButton;
        this.f16830f = textView2;
        this.f16831g = viewInviteSettingsSheet;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16825a;
    }
}
