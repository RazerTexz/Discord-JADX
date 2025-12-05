package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* loaded from: classes.dex */
public final class WidgetUserAccountVerifyBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f18320a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f18321b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f18322c;

    /* renamed from: d */
    @NonNull
    public final LinkifiedTextView f18323d;

    /* renamed from: e */
    @NonNull
    public final TextView f18324e;

    public WidgetUserAccountVerifyBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.f18320a = relativeLayout;
        this.f18321b = relativeLayout2;
        this.f18322c = relativeLayout3;
        this.f18323d = linkifiedTextView;
        this.f18324e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18320a;
    }
}
