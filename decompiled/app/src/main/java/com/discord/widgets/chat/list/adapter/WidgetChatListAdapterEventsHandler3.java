package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionAdd$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler3 extends Lambda implements Function1<MessageReactionUpdate, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler.UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler3(WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler) {
        super(1);
        this.this$0 = userReactionHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
        invoke2(messageReactionUpdate);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
        Intrinsics3.checkNotNullParameter(messageReactionUpdate, "reactionUpdate");
        WidgetChatListAdapterEventsHandler.UserReactionHandler.access$getStoreMessages$p(this.this$0).handleReactionUpdate(CollectionsJVM.listOf(messageReactionUpdate), true);
    }
}
