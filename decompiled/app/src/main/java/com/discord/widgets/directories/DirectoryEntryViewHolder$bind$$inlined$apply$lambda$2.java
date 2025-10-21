package com.discord.widgets.directories;

import android.view.View;
import com.discord.api.directory.DirectoryEntryGuild;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
/* loaded from: classes2.dex */
public final class DirectoryEntryViewHolder$bind$$inlined$apply$lambda$2 implements View.OnClickListener {
    public final /* synthetic */ DirectoryEntryGuild $data$inlined;
    public final /* synthetic */ DirectoryEntryData $entryData$inlined;
    public final /* synthetic */ DirectoryChannelItemClickInterface $listener$inlined;

    public DirectoryEntryViewHolder$bind$$inlined$apply$lambda$2(DirectoryEntryGuild directoryEntryGuild, DirectoryEntryData directoryEntryData, DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        this.$data$inlined = directoryEntryGuild;
        this.$entryData$inlined = directoryEntryData;
        this.$listener$inlined = directoryChannelItemClickInterface;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$listener$inlined.onGoToGuildClicked(this.$data$inlined.getGuild().getId());
    }
}
