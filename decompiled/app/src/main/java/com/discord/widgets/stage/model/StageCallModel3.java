package com.discord.widgets.stage.model;

import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.stage.model.StageCallModel$Companion$create$3, reason: use source file name */
/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel3 extends Lambda implements Function1<StageCallItem.SpeakerItem, StoreVoiceParticipants.VoiceUser> {
    public static final StageCallModel3 INSTANCE = new StageCallModel3();

    public StageCallModel3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreVoiceParticipants.VoiceUser invoke(StageCallItem.SpeakerItem speakerItem) {
        return invoke2(speakerItem);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreVoiceParticipants.VoiceUser invoke2(StageCallItem.SpeakerItem speakerItem) {
        Intrinsics3.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser();
    }
}
