package com.discord.widgets.voice.controls;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* compiled from: VoiceControlsSheetView.kt */
/* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceControlsSheetView5 implements View.OnClickListener {
    public final /* synthetic */ Function0 $onDisconnectClick$inlined;
    public final /* synthetic */ boolean $showDisconnect$inlined;

    public VoiceControlsSheetView5(boolean z2, Function0 function0) {
        this.$showDisconnect$inlined = z2;
        this.$onDisconnectClick$inlined = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onDisconnectClick$inlined.invoke();
    }
}
