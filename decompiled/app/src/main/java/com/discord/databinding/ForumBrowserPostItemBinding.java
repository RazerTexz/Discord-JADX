package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.forums.ForumBrowserPostView;

/* loaded from: classes.dex */
public final class ForumBrowserPostItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ForumBrowserPostView f15078a;

    /* renamed from: b */
    @NonNull
    public final ForumBrowserPostView f15079b;

    public ForumBrowserPostItemBinding(@NonNull ForumBrowserPostView forumBrowserPostView, @NonNull ForumBrowserPostView forumBrowserPostView2) {
        this.f15078a = forumBrowserPostView;
        this.f15079b = forumBrowserPostView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15078a;
    }
}
