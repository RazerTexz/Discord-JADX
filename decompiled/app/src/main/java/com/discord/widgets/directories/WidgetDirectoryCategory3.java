package com.discord.widgets.directories;

import android.content.Context;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.widgets.hubs.WidgetHubAddServer;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryCategory$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryCategory3 implements DirectoryChannelItemClickInterface {
    public final /* synthetic */ WidgetDirectoryCategory this$0;

    public WidgetDirectoryCategory3(WidgetDirectoryCategory widgetDirectoryCategory) {
        this.this$0 = widgetDirectoryCategory;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onAddServerClicked() {
        if (this.this$0.getContext() != null) {
            AppScreen2.f524g.m160f(this.this$0.requireContext(), WidgetDirectoryCategory.access$getActivityResult$p(this.this$0), WidgetHubAddServer.class, null);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onEntryClicked(long guildId, long channelId) {
        Context context = this.this$0.getContext();
        if (context != null) {
            WidgetDirectoriesViewModel viewModel = this.this$0.getViewModel();
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            viewModel.joinGuild(context, guildId, channelId);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onGoToGuildClicked(long guildId) {
        StoreStream.INSTANCE.getGuildSelected().set(guildId);
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner) {
        Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
        DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
        WidgetDirectoryCategory widgetDirectoryCategory = this.this$0;
        directoryUtils.showServerOptions(widgetDirectoryCategory, directoryEntry, widgetDirectoryCategory.getViewModel().getHubName(), isServerOwner, new WidgetDirectoryCategory4(this, directoryEntry, channelId));
    }
}
