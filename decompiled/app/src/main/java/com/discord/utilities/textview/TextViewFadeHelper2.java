package com.discord.utilities.textview;

import android.view.View;

/* JADX INFO: renamed from: com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ TextViewFadeHelper this$0;

    public TextViewFadeHelper2(TextViewFadeHelper textViewFadeHelper) {
        this.this$0 = textViewFadeHelper;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        TextViewFadeHelper.access$updateFade(this.this$0);
    }
}
