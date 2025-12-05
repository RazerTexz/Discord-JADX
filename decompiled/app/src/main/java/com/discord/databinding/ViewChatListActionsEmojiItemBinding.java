package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class ViewChatListActionsEmojiItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final SimpleDraweeView f15395a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f15396b;

    public ViewChatListActionsEmojiItemBinding(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.f15395a = simpleDraweeView;
        this.f15396b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15395a;
    }
}
