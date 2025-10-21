package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection;
import j0.k.Func1;

/* compiled from: DiscordOverlayService.kt */
/* renamed from: com.discord.utilities.voice.DiscordOverlayService$Companion$launchForConnect$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class DiscordOverlayService2<T, R> implements Func1<RtcConnection.StateChange, String> {
    public static final DiscordOverlayService2 INSTANCE = new DiscordOverlayService2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ String call(RtcConnection.StateChange stateChange) {
        return call2(stateChange);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return (!(state instanceof RtcConnection.State.d) || ((RtcConnection.State.d) state).a) ? "com.discord.actions.OVERLAY_OPEN" : "com.discord.actions.OVERLAY_SELECTOR";
    }
}
