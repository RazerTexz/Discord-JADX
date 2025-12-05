package com.discord.widgets.voice.controls;

import android.view.View;
import com.discord.widgets.stage.StageRoles;
import kotlin.jvm.functions.Function0;

/* compiled from: VoiceControlsSheetView.kt */
/* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureMoveToAudienceButton$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceControlsSheetView2 implements View.OnClickListener {
    public final /* synthetic */ Function0 $onMoveToAudienceClick$inlined;
    public final /* synthetic */ StageRoles $stageRoles$inlined;
    public final /* synthetic */ VoiceControlsSheetView this$0;

    public VoiceControlsSheetView2(VoiceControlsSheetView voiceControlsSheetView, StageRoles stageRoles, Function0 function0) {
        this.this$0 = voiceControlsSheetView;
        this.$stageRoles$inlined = stageRoles;
        this.$onMoveToAudienceClick$inlined = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onMoveToAudienceClick$inlined.invoke();
    }
}
