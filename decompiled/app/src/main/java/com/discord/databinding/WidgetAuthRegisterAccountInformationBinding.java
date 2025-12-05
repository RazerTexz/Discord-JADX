package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetAuthRegisterAccountInformationBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f15702a;

    /* renamed from: b */
    @NonNull
    public final LinkifiedTextView f15703b;

    /* renamed from: c */
    @NonNull
    public final LoadingButton f15704c;

    /* renamed from: d */
    @NonNull
    public final TextInputLayout f15705d;

    /* renamed from: e */
    @NonNull
    public final TextInputLayout f15706e;

    /* renamed from: f */
    @NonNull
    public final MaterialCheckBox f15707f;

    public WidgetAuthRegisterAccountInformationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LoadingButton loadingButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull MaterialCheckBox materialCheckBox) {
        this.f15702a = coordinatorLayout;
        this.f15703b = linkifiedTextView;
        this.f15704c = loadingButton;
        this.f15705d = textInputLayout;
        this.f15706e = textInputLayout2;
        this.f15707f = materialCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15702a;
    }
}
