package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetSettingsNotificationOsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f18018a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f18019b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f18020c;

    /* renamed from: d */
    @NonNull
    public final CheckedSetting f18021d;

    public WidgetSettingsNotificationOsBinding(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting2) {
        this.f18018a = linearLayout;
        this.f18019b = checkedSetting;
        this.f18020c = relativeLayout;
        this.f18021d = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18018a;
    }
}
