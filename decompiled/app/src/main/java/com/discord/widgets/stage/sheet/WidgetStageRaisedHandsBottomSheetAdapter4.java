package com.discord.widgets.stage.sheet;

import android.view.View;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter4 implements View.OnClickListener {
    public final /* synthetic */ StoreVoiceParticipants.VoiceUser $participant;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant this$0;

    public WidgetStageRaisedHandsBottomSheetAdapter4(WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant viewHolderParticipant, StoreVoiceParticipants.VoiceUser voiceUser) {
        this.this$0 = viewHolderParticipant;
        this.$participant = voiceUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnDismissRequest().invoke(this.$participant);
    }
}
