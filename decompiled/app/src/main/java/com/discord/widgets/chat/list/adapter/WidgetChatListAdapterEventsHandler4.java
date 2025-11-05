package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterEventsHandler.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionRemove$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler4 extends Lambda implements Function1<MessageReactionUpdate, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler.UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler4(WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler) {
        super(1);
        this.this$0 = userReactionHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
        invoke2(messageReactionUpdate);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
        Intrinsics3.checkNotNullParameter(messageReactionUpdate, "reactionUpdate");
        WidgetChatListAdapterEventsHandler.UserReactionHandler.access$getStoreMessages$p(this.this$0).handleReactionUpdate(CollectionsJVM.listOf(messageReactionUpdate), false);
    }
}
