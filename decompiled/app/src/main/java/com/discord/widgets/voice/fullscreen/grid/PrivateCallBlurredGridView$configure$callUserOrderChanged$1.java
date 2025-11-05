package com.discord.widgets.voice.fullscreen.grid;

import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* compiled from: PrivateCallBlurredGridView.kt */
/* loaded from: classes.dex */
public final class PrivateCallBlurredGridView$configure$callUserOrderChanged$1 extends o implements Function2<StoreVoiceParticipants.VoiceUser, StoreVoiceParticipants.VoiceUser, Boolean> {
    public static final PrivateCallBlurredGridView$configure$callUserOrderChanged$1 INSTANCE = new PrivateCallBlurredGridView$configure$callUserOrderChanged$1();

    public PrivateCallBlurredGridView$configure$callUserOrderChanged$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        return Boolean.valueOf(invoke2(voiceUser, voiceUser2));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        m.checkNotNullParameter(voiceUser, "o1");
        m.checkNotNullParameter(voiceUser2, "o2");
        return voiceUser.getUser().getId() == voiceUser2.getUser().getId();
    }
}
