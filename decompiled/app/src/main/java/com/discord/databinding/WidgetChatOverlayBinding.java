package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.typing.TypingDots;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p007b.p008a.p025i.WidgetChatInputStickerSuggestionsBinding;

/* loaded from: classes.dex */
public final class WidgetChatOverlayBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16362a;

    /* renamed from: b */
    @NonNull
    public final FloatingActionButton f16363b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f16364c;

    /* renamed from: d */
    @NonNull
    public final TypingDots f16365d;

    /* renamed from: e */
    @NonNull
    public final TextView f16366e;

    /* renamed from: f */
    @NonNull
    public final ImageView f16367f;

    /* renamed from: g */
    @NonNull
    public final TextView f16368g;

    /* renamed from: h */
    @NonNull
    public final WidgetChatInputStickerSuggestionsBinding f16369h;

    public WidgetChatOverlayBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull RelativeLayout relativeLayout, @NonNull TypingDots typingDots, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding) {
        this.f16362a = constraintLayout;
        this.f16363b = floatingActionButton;
        this.f16364c = relativeLayout;
        this.f16365d = typingDots;
        this.f16366e = textView;
        this.f16367f = imageView;
        this.f16368g = textView2;
        this.f16369h = widgetChatInputStickerSuggestionsBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16362a;
    }
}
