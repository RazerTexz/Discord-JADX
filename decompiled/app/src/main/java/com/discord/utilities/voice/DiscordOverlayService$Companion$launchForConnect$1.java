package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection;
import j0.k.b;

/* compiled from: DiscordOverlayService.kt */
/* loaded from: classes2.dex */
public final class DiscordOverlayService$Companion$launchForConnect$1<T, R> implements b<RtcConnection.StateChange, String> {
    public static final DiscordOverlayService$Companion$launchForConnect$1 INSTANCE = new DiscordOverlayService$Companion$launchForConnect$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(RtcConnection.StateChange stateChange) {
        return call2(stateChange);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return (!(state instanceof RtcConnection.State.d) || ((RtcConnection.State.d) state).a) ? "com.discord.actions.OVERLAY_OPEN" : "com.discord.actions.OVERLAY_SELECTOR";
    }
}
