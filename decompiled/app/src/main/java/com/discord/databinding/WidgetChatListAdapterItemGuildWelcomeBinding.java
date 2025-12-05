package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemGuildWelcomeBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f16232a;

    /* renamed from: b */
    @NonNull
    public final TextView f16233b;

    /* renamed from: c */
    @NonNull
    public final LinkifiedTextView f16234c;

    /* renamed from: d */
    @NonNull
    public final LinkifiedTextView f16235d;

    /* renamed from: e */
    @NonNull
    public final ChatActionItem f16236e;

    /* renamed from: f */
    @NonNull
    public final ChatActionItem f16237f;

    public WidgetChatListAdapterItemGuildWelcomeBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull ChatActionItem chatActionItem, @NonNull ChatActionItem chatActionItem2) {
        this.f16232a = linearLayout;
        this.f16233b = textView;
        this.f16234c = linkifiedTextView;
        this.f16235d = linkifiedTextView2;
        this.f16236e = chatActionItem;
        this.f16237f = chatActionItem2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16232a;
    }
}
