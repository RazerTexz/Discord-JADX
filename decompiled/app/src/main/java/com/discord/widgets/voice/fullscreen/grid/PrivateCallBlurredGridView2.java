package com.discord.widgets.voice.fullscreen.grid;

import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* compiled from: PrivateCallBlurredGridView.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.grid.PrivateCallBlurredGridView$configure$callUserOrderChanged$1, reason: use source file name */
/* loaded from: classes.dex */
public final class PrivateCallBlurredGridView2 extends Lambda implements Function2<StoreVoiceParticipants.VoiceUser, StoreVoiceParticipants.VoiceUser, Boolean> {
    public static final PrivateCallBlurredGridView2 INSTANCE = new PrivateCallBlurredGridView2();

    public PrivateCallBlurredGridView2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        return Boolean.valueOf(invoke2(voiceUser, voiceUser2));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        Intrinsics3.checkNotNullParameter(voiceUser, "o1");
        Intrinsics3.checkNotNullParameter(voiceUser2, "o2");
        return voiceUser.getUser().getId() == voiceUser2.getUser().getId();
    }
}
