package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* loaded from: classes.dex */
public final class UserProfileVoiceSettingsViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f15355a;

    /* renamed from: b */
    @NonNull
    public final SwitchMaterial f15356b;

    /* renamed from: c */
    @NonNull
    public final SwitchMaterial f15357c;

    /* renamed from: d */
    @NonNull
    public final TextView f15358d;

    /* renamed from: e */
    @NonNull
    public final VolumeSliderView f15359e;

    public UserProfileVoiceSettingsViewBinding(@NonNull LinearLayout linearLayout, @NonNull SwitchMaterial switchMaterial, @NonNull SwitchMaterial switchMaterial2, @NonNull TextView textView, @NonNull VolumeSliderView volumeSliderView) {
        this.f15355a = linearLayout;
        this.f15356b = switchMaterial;
        this.f15357c = switchMaterial2;
        this.f15358d = textView;
        this.f15359e = volumeSliderView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15355a;
    }
}
