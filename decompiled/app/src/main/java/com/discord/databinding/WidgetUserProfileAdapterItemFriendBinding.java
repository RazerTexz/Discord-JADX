package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.WidgetUserProfileAdapterItemFriendMutualServerBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserProfileAdapterItemFriendBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f18362a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding f18363b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding f18364c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding f18365d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding f18366e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f18367f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final StatusView f18368g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final SimpleDraweeSpanTextView f18369h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f18370i;

    public WidgetUserProfileAdapterItemFriendBinding(@NonNull RelativeLayout relativeLayout, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding2, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding3, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding4, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinearLayout linearLayout, @NonNull StatusView statusView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView) {
        this.f18362a = relativeLayout;
        this.f18363b = widgetUserProfileAdapterItemFriendMutualServerBinding;
        this.f18364c = widgetUserProfileAdapterItemFriendMutualServerBinding2;
        this.f18365d = widgetUserProfileAdapterItemFriendMutualServerBinding3;
        this.f18366e = widgetUserProfileAdapterItemFriendMutualServerBinding4;
        this.f18367f = simpleDraweeView;
        this.f18368g = statusView;
        this.f18369h = simpleDraweeSpanTextView;
        this.f18370i = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18362a;
    }
}
