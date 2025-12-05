package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetGuildScheduledEventLocationSelectBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f17014a;

    /* renamed from: b */
    @NonNull
    public final TextInputEditText f17015b;

    /* renamed from: c */
    @NonNull
    public final TextInputLayout f17016c;

    /* renamed from: d */
    @NonNull
    public final ImageView f17017d;

    /* renamed from: e */
    @NonNull
    public final TextInputEditText f17018e;

    /* renamed from: f */
    @NonNull
    public final TextInputLayout f17019f;

    /* renamed from: g */
    @NonNull
    public final CheckedSetting f17020g;

    /* renamed from: h */
    @NonNull
    public final TextView f17021h;

    /* renamed from: i */
    @NonNull
    public final MaterialButton f17022i;

    /* renamed from: j */
    @NonNull
    public final CheckedSetting f17023j;

    /* renamed from: k */
    @NonNull
    public final TextView f17024k;

    /* renamed from: l */
    @NonNull
    public final View f17025l;

    /* renamed from: m */
    @NonNull
    public final CheckedSetting f17026m;

    public WidgetGuildScheduledEventLocationSelectBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull TextInputEditText textInputEditText2, @NonNull TextInputLayout textInputLayout2, @NonNull CheckedSetting checkedSetting, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView2, @NonNull ScreenTitleView screenTitleView, @NonNull ConstraintLayout constraintLayout2, @NonNull View view2, @NonNull CheckedSetting checkedSetting3) {
        this.f17014a = constraintLayout;
        this.f17015b = textInputEditText;
        this.f17016c = textInputLayout;
        this.f17017d = imageView;
        this.f17018e = textInputEditText2;
        this.f17019f = textInputLayout2;
        this.f17020g = checkedSetting;
        this.f17021h = textView;
        this.f17022i = materialButton;
        this.f17023j = checkedSetting2;
        this.f17024k = textView2;
        this.f17025l = view2;
        this.f17026m = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17014a;
    }
}
