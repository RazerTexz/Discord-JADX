package com.discord.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetGroupInviteFriendsItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f16733a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f16734b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f16735c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeSpanTextView f16736d;

    /* renamed from: e */
    @NonNull
    public final TextView f16737e;

    /* renamed from: f */
    @NonNull
    public final StatusView f16738f;

    /* renamed from: g */
    @NonNull
    public final CheckBox f16739g;

    public WidgetGroupInviteFriendsItemBinding(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull RelativeLayout relativeLayout2, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView, @NonNull StatusView statusView, @NonNull CheckBox checkBox) {
        this.f16733a = linearLayout;
        this.f16734b = relativeLayout;
        this.f16735c = simpleDraweeView;
        this.f16736d = simpleDraweeSpanTextView;
        this.f16737e = textView;
        this.f16738f = statusView;
        this.f16739g = checkBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16733a;
    }
}
