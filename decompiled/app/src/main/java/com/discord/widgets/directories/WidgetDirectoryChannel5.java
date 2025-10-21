package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import b.a.d.AppScreen2;
import com.discord.api.channel.Channel;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetDirectoryChannel.kt */
/* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
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
            AppScreen2.d(context, WidgetDirectoriesSearch.class, new WidgetDirectoriesSearch2(id2));
        }
    }
}
