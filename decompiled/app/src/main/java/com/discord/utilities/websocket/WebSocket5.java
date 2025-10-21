package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WebSocket.kt */
/* renamed from: com.discord.utilities.websocket.WebSocket$onClosed$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WebSocket5 extends Lambda implements Function1<WebSocket.Closed, Unit> {
    public static final WebSocket5 INSTANCE = new WebSocket5();

    public WebSocket5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket.Closed closed) {
        invoke2(closed);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket.Closed closed) {
        Intrinsics3.checkNotNullParameter(closed, "it");
    }
}
