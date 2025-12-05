package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetSettingsAccessibilityBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17769a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f17770b;

    /* renamed from: c */
    @NonNull
    public final CheckedSetting f17771c;

    /* renamed from: d */
    @NonNull
    public final TextView f17772d;

    /* renamed from: e */
    @NonNull
    public final LinkifiedTextView f17773e;

    /* renamed from: f */
    @NonNull
    public final TextView f17774f;

    /* renamed from: g */
    @NonNull
    public final CheckedSetting f17775g;

    /* renamed from: h */
    @NonNull
    public final TextView f17776h;

    /* renamed from: i */
    @NonNull
    public final CheckedSetting f17777i;

    /* renamed from: j */
    @NonNull
    public final CheckedSetting f17778j;

    /* renamed from: k */
    @NonNull
    public final CheckedSetting f17779k;

    public WidgetSettingsAccessibilityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting3, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull View view, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6) {
        this.f17769a = coordinatorLayout;
        this.f17770b = checkedSetting;
        this.f17771c = checkedSetting2;
        this.f17772d = textView;
        this.f17773e = linkifiedTextView;
        this.f17774f = textView2;
        this.f17775g = checkedSetting3;
        this.f17776h = textView3;
        this.f17777i = checkedSetting4;
        this.f17778j = checkedSetting5;
        this.f17779k = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17769a;
    }
}
