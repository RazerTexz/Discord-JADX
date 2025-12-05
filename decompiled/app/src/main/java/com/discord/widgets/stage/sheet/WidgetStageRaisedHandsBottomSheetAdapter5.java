package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreVoiceParticipants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$onDismissRequest$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter5 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
    public static final WidgetStageRaisedHandsBottomSheetAdapter5 INSTANCE = new WidgetStageRaisedHandsBottomSheetAdapter5();

    public WidgetStageRaisedHandsBottomSheetAdapter5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
        invoke2(voiceUser);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
        Intrinsics3.checkNotNullParameter(voiceUser, "it");
    }
}
