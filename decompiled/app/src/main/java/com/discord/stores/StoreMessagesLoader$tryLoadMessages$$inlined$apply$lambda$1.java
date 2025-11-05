package com.discord.stores;

import com.discord.models.message.Message;
import com.discord.stores.StoreMessagesLoader;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreMessagesLoader.kt */
/* loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$1 extends o implements Function1<List<? extends Message>, Unit> {
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreMessagesLoader.ChannelLoadedState $channelLoadedState$inlined;
    public final /* synthetic */ StoreMessagesLoader.AnonymousClass4 $loadPagedMessages$4$inlined;
    public final /* synthetic */ boolean $shouldRequestNewerMessages;
    public final /* synthetic */ boolean $shouldRequestOlderMessages;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$1(boolean z2, boolean z3, StoreMessagesLoader storeMessagesLoader, StoreMessagesLoader.ChannelLoadedState channelLoadedState, long j, StoreMessagesLoader.AnonymousClass4 anonymousClass4) {
        super(1);
        this.$shouldRequestOlderMessages = z2;
        this.$shouldRequestNewerMessages = z3;
        this.this$0 = storeMessagesLoader;
        this.$channelLoadedState$inlined = channelLoadedState;
        this.$channelId$inlined = j;
        this.$loadPagedMessages$4$inlined = anonymousClass4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
        invoke2((List<Message>) list);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Message> list) {
        StoreMessagesLoader.AnonymousClass4 anonymousClass4 = this.$loadPagedMessages$4$inlined;
        long j = this.$channelId$inlined;
        m.checkNotNullExpressionValue(list, "messages");
        anonymousClass4.invoke(j, list, this.$shouldRequestOlderMessages, this.$shouldRequestNewerMessages);
    }
}
