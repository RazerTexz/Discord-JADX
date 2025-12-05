package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetMemberVerificationParagraphItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final TextInputLayout f17248a;

    /* renamed from: b */
    @NonNull
    public final TextInputEditText f17249b;

    public WidgetMemberVerificationParagraphItemBinding(@NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText) {
        this.f17248a = textInputLayout;
        this.f17249b = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17248a;
    }
}
