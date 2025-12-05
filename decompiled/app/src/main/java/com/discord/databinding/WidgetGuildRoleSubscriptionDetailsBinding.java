package com.discord.databinding;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionDetailsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16911a;

    /* renamed from: b */
    @NonNull
    public final TextInputEditText f16912b;

    /* renamed from: c */
    @NonNull
    public final TextInputLayout f16913c;

    /* renamed from: d */
    @NonNull
    public final GuildSubscriptionRoleImageUploadView f16914d;

    /* renamed from: e */
    @NonNull
    public final TextInputEditText f16915e;

    /* renamed from: f */
    @NonNull
    public final TextInputLayout f16916f;

    /* renamed from: g */
    @NonNull
    public final TextView f16917g;

    /* renamed from: h */
    @NonNull
    public final TextView f16918h;

    /* renamed from: i */
    @NonNull
    public final TextView f16919i;

    /* renamed from: j */
    @NonNull
    public final View f16920j;

    public WidgetGuildRoleSubscriptionDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ScrollView scrollView, @NonNull GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, @NonNull TextInputEditText textInputEditText2, @NonNull TextInputLayout textInputLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view) {
        this.f16911a = constraintLayout;
        this.f16912b = textInputEditText;
        this.f16913c = textInputLayout;
        this.f16914d = guildSubscriptionRoleImageUploadView;
        this.f16915e = textInputEditText2;
        this.f16916f = textInputLayout2;
        this.f16917g = textView;
        this.f16918h = textView2;
        this.f16919i = textView3;
        this.f16920j = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16911a;
    }
}
