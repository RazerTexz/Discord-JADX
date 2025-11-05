package com.discord.widgets.stage.model;

import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: StageCallModel.kt */
/* loaded from: classes2.dex */
public final class StageCallModel$Companion$create$2 extends o implements Function1<StageCallItem.SpeakerItem, Boolean> {
    public static final StageCallModel$Companion$create$2 INSTANCE = new StageCallModel$Companion$create$2();

    public StageCallModel$Companion$create$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageCallItem.SpeakerItem speakerItem) {
        return Boolean.valueOf(invoke2(speakerItem));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageCallItem.SpeakerItem speakerItem) {
        m.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser().getIsSpeaking() && !speakerItem.getVoiceUser().isMe();
    }
}
