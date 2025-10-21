package com.discord.widgets.chat.list.model;

import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.FunctionReferenceImpl;
import java.util.List;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChatListModel.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListModel5 extends FunctionReferenceImpl implements Function2<Message, List<? extends ChatListEntry>, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>>> {
    public static final WidgetChatListModel5 INSTANCE = new WidgetChatListModel5();

    public WidgetChatListModel5() {
        super(2, Tuples2.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Tuples2<? extends Message, ? extends List<? extends ChatListEntry>> invoke(Message message, List<? extends ChatListEntry> list) {
        return invoke2(message, list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Tuples2<Message, List<ChatListEntry>> invoke2(Message message, List<? extends ChatListEntry> list) {
        return new Tuples2<>(message, list);
    }
}
