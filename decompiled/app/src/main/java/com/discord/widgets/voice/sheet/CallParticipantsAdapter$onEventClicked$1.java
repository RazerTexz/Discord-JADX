package com.discord.widgets.voice.sheet;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CallParticipantsAdapter.kt */
/* loaded from: classes.dex */
public final class CallParticipantsAdapter$onEventClicked$1 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
    public static final CallParticipantsAdapter$onEventClicked$1 INSTANCE = new CallParticipantsAdapter$onEventClicked$1();

    public CallParticipantsAdapter$onEventClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
        invoke2(guildScheduledEvent);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "it");
    }
}
