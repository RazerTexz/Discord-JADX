package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$4 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelStageVoice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$4(WidgetChannelsListAdapter.ItemChannelStageVoice itemChannelStageVoice, Channel channel) {
        super(1);
        this.this$0 = itemChannelStageVoice;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetChannelsListAdapter.ItemChannelStageVoice.access$getAdapter$p(this.this$0).getOnSelectChannelOptions().invoke(this.$channel);
    }
}
