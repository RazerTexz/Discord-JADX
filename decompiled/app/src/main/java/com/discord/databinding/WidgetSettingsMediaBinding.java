package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetSettingsMediaBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f18005a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f18006b;

    /* renamed from: c */
    @NonNull
    public final CheckedSetting f18007c;

    /* renamed from: d */
    @NonNull
    public final LinkifiedTextView f18008d;

    /* renamed from: e */
    @NonNull
    public final TextView f18009e;

    /* renamed from: f */
    @NonNull
    public final TextView f18010f;

    /* renamed from: g */
    @NonNull
    public final CheckedSetting f18011g;

    /* renamed from: h */
    @NonNull
    public final CheckedSetting f18012h;

    /* renamed from: i */
    @NonNull
    public final TextView f18013i;

    /* renamed from: j */
    @NonNull
    public final TextView f18014j;

    /* renamed from: k */
    @NonNull
    public final TextView f18015k;

    /* renamed from: l */
    @NonNull
    public final CheckedSetting f18016l;

    /* renamed from: m */
    @NonNull
    public final CheckedSetting f18017m;

    public WidgetSettingsMediaBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6) {
        this.f18005a = coordinatorLayout;
        this.f18006b = checkedSetting;
        this.f18007c = checkedSetting2;
        this.f18008d = linkifiedTextView;
        this.f18009e = textView;
        this.f18010f = textView2;
        this.f18011g = checkedSetting3;
        this.f18012h = checkedSetting4;
        this.f18013i = textView3;
        this.f18014j = textView4;
        this.f18015k = textView5;
        this.f18016l = checkedSetting5;
        this.f18017m = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18005a;
    }
}
