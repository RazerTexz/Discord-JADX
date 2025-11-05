package com.discord.widgets.notice;

import com.discord.widgets.chat.WidgetUrlActions;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: NoticePopupChannel.kt */
/* loaded from: classes2.dex */
public final class NoticePopupChannel$createModel$messageRenderContext$1 extends o implements Function1<String, Unit> {
    public static final NoticePopupChannel$createModel$messageRenderContext$1 INSTANCE = new NoticePopupChannel$createModel$messageRenderContext$1();

    public NoticePopupChannel$createModel$messageRenderContext$1() {
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
