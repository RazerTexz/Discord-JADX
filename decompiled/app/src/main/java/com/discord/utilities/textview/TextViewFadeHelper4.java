package com.discord.utilities.textview;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: renamed from: com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$3, reason: use source file name */
/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper4 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View.OnLayoutChangeListener $layoutListener;
    public final /* synthetic */ TextViewFadeHelper3 $textChangedListener;
    public final /* synthetic */ TextView $this_apply;

    public TextViewFadeHelper4(TextView textView, View.OnLayoutChangeListener onLayoutChangeListener, TextViewFadeHelper3 textViewFadeHelper3) {
        this.$this_apply = textView;
        this.$layoutListener = onLayoutChangeListener;
        this.$textChangedListener = textViewFadeHelper3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        this.$this_apply.addOnLayoutChangeListener(this.$layoutListener);
        this.$this_apply.addTextChangedListener(this.$textChangedListener);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.$this_apply.removeOnLayoutChangeListener(this.$layoutListener);
        this.$this_apply.removeTextChangedListener(this.$textChangedListener);
    }
}
