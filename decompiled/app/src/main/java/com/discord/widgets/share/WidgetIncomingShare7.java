package com.discord.widgets.share;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetIncomingShare.kt */
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$filter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare7 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $receiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare7(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        super(1);
        this.$receiver = itemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        return channel != null && channel.getId() == ((WidgetGlobalSearchModel.ItemChannel) this.$receiver).getChannel().getId();
    }
}
