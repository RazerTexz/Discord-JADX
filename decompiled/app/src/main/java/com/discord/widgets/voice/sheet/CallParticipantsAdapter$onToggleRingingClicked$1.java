package com.discord.widgets.voice.sheet;

import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CallParticipantsAdapter.kt */
/* loaded from: classes.dex */
public final class CallParticipantsAdapter$onToggleRingingClicked$1 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
    public static final CallParticipantsAdapter$onToggleRingingClicked$1 INSTANCE = new CallParticipantsAdapter$onToggleRingingClicked$1();

    public CallParticipantsAdapter$onToggleRingingClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
        invoke2(voiceUser);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
        Intrinsics3.checkNotNullParameter(voiceUser, "it");
    }
}
