package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetUserMentionsFilterBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final NestedScrollView f18336a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f18337b;

    /* renamed from: c */
    @NonNull
    public final CheckedSetting f18338c;

    /* renamed from: d */
    @NonNull
    public final CheckedSetting f18339d;

    public WidgetUserMentionsFilterBinding(@NonNull NestedScrollView nestedScrollView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3) {
        this.f18336a = nestedScrollView;
        this.f18337b = checkedSetting;
        this.f18338c = checkedSetting2;
        this.f18339d = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18336a;
    }
}
