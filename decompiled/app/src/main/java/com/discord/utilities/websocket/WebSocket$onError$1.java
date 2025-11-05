package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WebSocket.kt */
/* loaded from: classes2.dex */
public final class WebSocket$onError$1 extends o implements Function1<WebSocket.Error, Unit> {
    public static final WebSocket$onError$1 INSTANCE = new WebSocket$onError$1();

    public WebSocket$onError$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket.Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket.Error error) {
        m.checkNotNullParameter(error, "it");
    }
}
