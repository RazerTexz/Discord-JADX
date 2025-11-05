package com.discord.widgets.channels;

import com.discord.widgets.chat.WidgetUrlActions;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelTopic.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelTopic$getRenderedTopicForTopic$renderContext$1 extends o implements Function1<String, Unit> {
    public static final WidgetChannelTopic$getRenderedTopicForTopic$renderContext$1 INSTANCE = new WidgetChannelTopic$getRenderedTopicForTopic$renderContext$1();

    public WidgetChannelTopic$getRenderedTopicForTopic$renderContext$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "url");
        WidgetUrlActions.INSTANCE.requestNotice(str);
    }
}
