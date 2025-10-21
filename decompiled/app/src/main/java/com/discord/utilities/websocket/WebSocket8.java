package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WebSocket.kt */
/* renamed from: com.discord.utilities.websocket.WebSocket$onOpened$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WebSocket8 extends Lambda implements Function1<WebSocket.Opened, Unit> {
    public static final WebSocket8 INSTANCE = new WebSocket8();

    public WebSocket8() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket.Opened opened) {
        invoke2(opened);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket.Opened opened) {
        Intrinsics3.checkNotNullParameter(opened, "it");
    }
}
