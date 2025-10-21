package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$1 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemVoiceUser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$1(WidgetChannelsListAdapter.ItemVoiceUser itemVoiceUser, ChannelListItem channelListItem) {
        super(1);
        this.this$0 = itemVoiceUser;
        this.$data = channelListItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetChannelsListAdapter.ItemVoiceUser.access$getAdapter$p(this.this$0).getOnSelectUserOptions().invoke(((ChannelListItemVoiceUser) this.$data).getUser(), ((ChannelListItemVoiceUser) this.$data).getChannel());
    }
}
