package com.discord.widgets.chat.list.adapter;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemPrivateChannelStart.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemPrivateChannelStart2 extends Lambda implements Function1<Integer, String> {
    public final /* synthetic */ String $iconURL;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemPrivateChannelStart2(String str) {
        super(1);
        this.$iconURL = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        return this.$iconURL;
    }
}
