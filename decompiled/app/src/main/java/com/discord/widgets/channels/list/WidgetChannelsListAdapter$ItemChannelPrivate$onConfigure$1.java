package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$1 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelPrivate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$1(WidgetChannelsListAdapter.ItemChannelPrivate itemChannelPrivate, ChannelListItem channelListItem) {
        super(1);
        this.this$0 = itemChannelPrivate;
        this.$data = channelListItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetChannelsListAdapter.ItemChannelPrivate.access$getAdapter$p(this.this$0).getOnSelectChannelOptions().invoke(((ChannelListItemPrivate) this.$data).getChannel());
    }
}
