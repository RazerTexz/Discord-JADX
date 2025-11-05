package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.j;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.widgets.hubs.WidgetHubAddServer;
import d0.z.d.m;

/* compiled from: WidgetDirectoryCategory.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoryCategory$adapter$1 implements DirectoryChannelItemClickInterface {
    public final /* synthetic */ WidgetDirectoryCategory this$0;

    public WidgetDirectoryCategory$adapter$1(WidgetDirectoryCategory widgetDirectoryCategory) {
        this.this$0 = widgetDirectoryCategory;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onAddServerClicked() {
        if (this.this$0.getContext() != null) {
            j.g.f(this.this$0.requireContext(), WidgetDirectoryCategory.access$getActivityResult$p(this.this$0), WidgetHubAddServer.class, null);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onEntryClicked(long guildId, long channelId) {
        Context context = this.this$0.getContext();
        if (context != null) {
            WidgetDirectoriesViewModel viewModel = this.this$0.getViewModel();
            m.checkNotNullExpressionValue(context, "it");
            viewModel.joinGuild(context, guildId, channelId);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onGoToGuildClicked(long guildId) {
        StoreStream.INSTANCE.getGuildSelected().set(guildId);
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner) {
        m.checkNotNullParameter(directoryEntry, "directoryEntry");
        DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
        WidgetDirectoryCategory widgetDirectoryCategory = this.this$0;
        directoryUtils.showServerOptions(widgetDirectoryCategory, directoryEntry, widgetDirectoryCategory.getViewModel().getHubName(), isServerOwner, new WidgetDirectoryCategory$adapter$1$onOverflowClicked$1(this, directoryEntry, channelId));
    }
}
