package com.discord.widgets.notice;

import com.discord.widgets.chat.WidgetUrlActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: NoticePopupChannel.kt */
/* renamed from: com.discord.widgets.notice.NoticePopupChannel$createModel$messageRenderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NoticePopupChannel2 extends Lambda implements Function1<String, Unit> {
    public static final NoticePopupChannel2 INSTANCE = new NoticePopupChannel2();

    public NoticePopupChannel2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "url");
        WidgetUrlActions.INSTANCE.requestNotice(str);
    }
}
