package com.discord.utilities.websocket;


/* compiled from: RawMessageHandler.kt */
/* loaded from: classes2.dex */
public interface RawMessageHandler {
    void onRawMessage(String rawMessage);

    void onRawMessageInflateFailed(Throwable throwable);
}
