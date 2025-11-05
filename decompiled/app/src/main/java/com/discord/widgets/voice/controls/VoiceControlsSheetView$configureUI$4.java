package com.discord.widgets.voice.controls;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* compiled from: VoiceControlsSheetView.kt */
/* loaded from: classes.dex */
public final class VoiceControlsSheetView$configureUI$4 implements View.OnClickListener {
    public final /* synthetic */ Function0 $onDeafenPressed;

    public VoiceControlsSheetView$configureUI$4(Function0 function0) {
        this.$onDeafenPressed = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onDeafenPressed.invoke();
    }
}
