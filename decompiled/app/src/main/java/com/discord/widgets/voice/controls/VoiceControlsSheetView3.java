package com.discord.widgets.voice.controls;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureMuteButton$1, reason: use source file name */
/* JADX INFO: compiled from: VoiceControlsSheetView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetView3 implements View.OnClickListener {
    public final /* synthetic */ Function0 $onMuteClick;

    public VoiceControlsSheetView3(Function0 function0) {
        this.$onMuteClick = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onMuteClick.invoke();
    }
}
