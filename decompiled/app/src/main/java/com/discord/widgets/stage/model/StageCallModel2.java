package com.discord.widgets.stage.model;

import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StageCallModel.kt */
/* renamed from: com.discord.widgets.stage.model.StageCallModel$Companion$create$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageCallModel2 extends Lambda implements Function1<StageCallItem.SpeakerItem, Boolean> {
    public static final StageCallModel2 INSTANCE = new StageCallModel2();

    public StageCallModel2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageCallItem.SpeakerItem speakerItem) {
        return Boolean.valueOf(invoke2(speakerItem));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageCallItem.SpeakerItem speakerItem) {
        Intrinsics3.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser().getIsSpeaking() && !speakerItem.getVoiceUser().isMe();
    }
}
