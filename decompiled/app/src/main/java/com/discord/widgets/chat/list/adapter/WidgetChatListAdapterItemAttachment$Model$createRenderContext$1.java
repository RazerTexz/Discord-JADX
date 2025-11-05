package com.discord.widgets.chat.list.adapter;

import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemAttachment.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$Model$createRenderContext$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetChatListAdapter.EventHandler $eventHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAttachment$Model$createRenderContext$1(WidgetChatListAdapter.EventHandler eventHandler) {
        super(1);
        this.$eventHandler = eventHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "url");
        this.$eventHandler.onUrlLongClicked(str);
    }
}
