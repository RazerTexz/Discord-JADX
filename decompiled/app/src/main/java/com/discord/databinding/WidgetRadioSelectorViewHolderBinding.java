package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.IconRow;

/* loaded from: classes.dex */
public final class WidgetRadioSelectorViewHolderBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final IconRow f17404a;

    /* renamed from: b */
    @NonNull
    public final IconRow f17405b;

    public WidgetRadioSelectorViewHolderBinding(@NonNull IconRow iconRow, @NonNull IconRow iconRow2) {
        this.f17404a = iconRow;
        this.f17405b = iconRow2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17404a;
    }
}
