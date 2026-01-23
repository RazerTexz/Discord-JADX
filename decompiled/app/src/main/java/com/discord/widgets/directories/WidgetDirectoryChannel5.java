package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel5 implements View.OnClickListener {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState $state$inlined;
    public final /* synthetic */ ServerDiscoveryHeader $this_apply;

    public WidgetDirectoryChannel5(ServerDiscoveryHeader serverDiscoveryHeader, WidgetDirectoriesViewModel.ViewState viewState) {
        this.$this_apply = serverDiscoveryHeader;
        this.$state$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Channel channel = this.$state$inlined.getChannel();
        if (channel != null) {
            long id2 = channel.getId();
            Context context = this.$this_apply.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            AppScreen2.m156d(context, WidgetDirectoriesSearch.class, new WidgetDirectoriesSearch2(id2));
        }
    }
}
