package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserLimitView;

/* loaded from: classes.dex */
public final class WidgetChannelsListItemChannelVoiceBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16029a;

    /* renamed from: b */
    @NonNull
    public final TextView f16030b;

    /* renamed from: c */
    @NonNull
    public final ImageView f16031c;

    /* renamed from: d */
    @NonNull
    public final TextView f16032d;

    /* renamed from: e */
    @NonNull
    public final ImageView f16033e;

    /* renamed from: f */
    @NonNull
    public final TextView f16034f;

    /* renamed from: g */
    @NonNull
    public final ImageView f16035g;

    /* renamed from: h */
    @NonNull
    public final VoiceUserLimitView f16036h;

    public WidgetChannelsListItemChannelVoiceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull TextView textView3, @NonNull ImageView imageView3, @NonNull VoiceUserLimitView voiceUserLimitView, @NonNull LinearLayout linearLayout) {
        this.f16029a = constraintLayout;
        this.f16030b = textView;
        this.f16031c = imageView;
        this.f16032d = textView2;
        this.f16033e = imageView2;
        this.f16034f = textView3;
        this.f16035g = imageView3;
        this.f16036h = voiceUserLimitView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16029a;
    }
}
