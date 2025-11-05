package com.discord.widgets.directories;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.widgets.directories.DirectoryChannelItemClickInterface;
import d0.z.d.m;

/* compiled from: WidgetDirectoriesSearch.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$adapter$1 implements DirectoryChannelItemClickInterface {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    public WidgetDirectoriesSearch$adapter$1(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        this.this$0 = widgetDirectoriesSearch;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onAddServerClicked() {
        DirectoryChannelItemClickInterface.DefaultImpls.onAddServerClicked(this);
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onEntryClicked(long guildId, long channelId) {
        Context context = this.this$0.getContext();
        if (context != null) {
            WidgetDirectoriesSearchViewModel viewModel = this.this$0.getViewModel();
            m.checkNotNullExpressionValue(context, "it");
            viewModel.joinGuild(context, guildId, channelId);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onGoToGuildClicked(long guildId) {
        StoreStream.INSTANCE.getGuildSelected().set(guildId);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner) {
        m.checkNotNullParameter(directoryEntry, "directoryEntry");
        DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
        WidgetDirectoriesSearch widgetDirectoriesSearch = this.this$0;
        directoryUtils.showServerOptions(widgetDirectoriesSearch, directoryEntry, widgetDirectoriesSearch.getViewModel().getHubName(), isServerOwner, new WidgetDirectoriesSearch$adapter$1$onOverflowClicked$1(this, directoryEntry, channelId));
    }
}
