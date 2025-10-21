package com.discord.widgets.voice.controls;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* compiled from: VoiceControlsSheetView.kt */
/* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureUI$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceControlsSheetView7 implements View.OnClickListener {
    public final /* synthetic */ Function0 $onStopWatchingClick;

    public VoiceControlsSheetView7(Function0 function0) {
        this.$onStopWatchingClick = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onStopWatchingClick.invoke();
    }
}
