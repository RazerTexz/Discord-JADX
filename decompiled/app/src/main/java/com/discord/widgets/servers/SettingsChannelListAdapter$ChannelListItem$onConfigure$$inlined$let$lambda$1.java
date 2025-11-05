package com.discord.widgets.servers;

import android.view.View;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: SettingsChannelListAdapter.kt */
/* loaded from: classes2.dex */
public final class SettingsChannelListAdapter$ChannelListItem$onConfigure$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ SettingsChannelListAdapter.ChannelItem $it$inlined;
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ SettingsChannelListAdapter.ChannelListItem this$0;

    public SettingsChannelListAdapter$ChannelListItem$onConfigure$$inlined$let$lambda$1(Function1 function1, SettingsChannelListAdapter.ChannelItem channelItem, SettingsChannelListAdapter.ChannelListItem channelListItem) {
        this.$onClick = function1;
        this.$it$inlined = channelItem;
        this.this$0 = channelListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onClick.invoke(Long.valueOf(this.$it$inlined.getChannel().getId()));
    }
}
