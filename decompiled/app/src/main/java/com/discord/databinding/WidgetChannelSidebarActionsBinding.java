package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;

/* loaded from: classes.dex */
public final class WidgetChannelSidebarActionsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f15958a;

    /* renamed from: b */
    @NonNull
    public final GuildChannelSideBarActionsView f15959b;

    /* renamed from: c */
    @NonNull
    public final PrivateChannelSideBarActionsView f15960c;

    public WidgetChannelSidebarActionsBinding(@NonNull FrameLayout frameLayout, @NonNull GuildChannelSideBarActionsView guildChannelSideBarActionsView, @NonNull PrivateChannelSideBarActionsView privateChannelSideBarActionsView) {
        this.f15958a = frameLayout;
        this.f15959b = guildChannelSideBarActionsView;
        this.f15960c = privateChannelSideBarActionsView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15958a;
    }
}
