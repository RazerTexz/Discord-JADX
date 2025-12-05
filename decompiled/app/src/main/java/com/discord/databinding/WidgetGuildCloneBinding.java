package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.guilds.create.GuildTemplateChannelsView;
import com.discord.widgets.roles.RolesListView;
import com.google.android.material.textfield.TextInputLayout;
import p007b.p008a.p025i.LayoutIconUploaderBinding;

/* loaded from: classes.dex */
public final class WidgetGuildCloneBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16751a;

    /* renamed from: b */
    @NonNull
    public final LoadingButton f16752b;

    /* renamed from: c */
    @NonNull
    public final AppViewFlipper f16753c;

    /* renamed from: d */
    @NonNull
    public final LinkifiedTextView f16754d;

    /* renamed from: e */
    @NonNull
    public final LayoutIconUploaderBinding f16755e;

    /* renamed from: f */
    @NonNull
    public final TextInputLayout f16756f;

    /* renamed from: g */
    @NonNull
    public final TextView f16757g;

    /* renamed from: h */
    @NonNull
    public final GuildTemplateChannelsView f16758h;

    /* renamed from: i */
    @NonNull
    public final RolesListView f16759i;

    /* renamed from: j */
    @NonNull
    public final LinearLayout f16760j;

    public WidgetGuildCloneBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LoadingButton loadingButton, @NonNull AppViewFlipper appViewFlipper, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LayoutIconUploaderBinding layoutIconUploaderBinding, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GuildTemplateChannelsView guildTemplateChannelsView, @NonNull RolesListView rolesListView, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar) {
        this.f16751a = coordinatorLayout;
        this.f16752b = loadingButton;
        this.f16753c = appViewFlipper;
        this.f16754d = linkifiedTextView;
        this.f16755e = layoutIconUploaderBinding;
        this.f16756f = textInputLayout;
        this.f16757g = textView2;
        this.f16758h = guildTemplateChannelsView;
        this.f16759i = rolesListView;
        this.f16760j = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16751a;
    }
}
