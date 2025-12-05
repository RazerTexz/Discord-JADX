package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetTextInVoiceOnboardingBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f18245a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f18246b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f18247c;

    /* renamed from: d */
    @NonNull
    public final VideoView f18248d;

    /* renamed from: e */
    @NonNull
    public final FrameLayout f18249e;

    /* renamed from: f */
    @NonNull
    public final SimpleDraweeView f18250f;

    /* renamed from: g */
    @NonNull
    public final ImageView f18251g;

    public WidgetTextInVoiceOnboardingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull VideoView videoView, @NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView) {
        this.f18245a = constraintLayout;
        this.f18246b = materialButton;
        this.f18247c = materialButton2;
        this.f18248d = videoView;
        this.f18249e = frameLayout;
        this.f18250f = simpleDraweeView;
        this.f18251g = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18245a;
    }
}
