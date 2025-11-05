package com.discord.widgets.voice.controls;

import android.view.View;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import kotlin.jvm.functions.Function0;

/* compiled from: VoiceControlsSheetView.kt */
/* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureRaiseHandButton$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceControlsSheetView4 implements View.OnClickListener {
    public final /* synthetic */ boolean $isUpdatingRequestToSpeak$inlined;
    public final /* synthetic */ CallModel $model$inlined;
    public final /* synthetic */ Function0 $onRaiseHandClick$inlined;
    public final /* synthetic */ StageRoles $stageRoles$inlined;
    public final /* synthetic */ VoiceControlsSheetView this$0;

    public VoiceControlsSheetView4(VoiceControlsSheetView voiceControlsSheetView, StageRoles stageRoles, CallModel callModel, boolean z2, Function0 function0) {
        this.this$0 = voiceControlsSheetView;
        this.$stageRoles$inlined = stageRoles;
        this.$model$inlined = callModel;
        this.$isUpdatingRequestToSpeak$inlined = z2;
        this.$onRaiseHandClick$inlined = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onRaiseHandClick$inlined.invoke();
    }
}
