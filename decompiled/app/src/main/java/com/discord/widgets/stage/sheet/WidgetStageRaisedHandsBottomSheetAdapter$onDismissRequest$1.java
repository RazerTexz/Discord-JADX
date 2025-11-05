package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter$onDismissRequest$1 extends o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
    public static final WidgetStageRaisedHandsBottomSheetAdapter$onDismissRequest$1 INSTANCE = new WidgetStageRaisedHandsBottomSheetAdapter$onDismissRequest$1();

    public WidgetStageRaisedHandsBottomSheetAdapter$onDismissRequest$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
        invoke2(voiceUser);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
        m.checkNotNullParameter(voiceUser, "it");
    }
}
