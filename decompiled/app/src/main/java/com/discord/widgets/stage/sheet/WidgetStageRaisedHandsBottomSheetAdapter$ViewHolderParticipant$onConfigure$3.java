package com.discord.widgets.stage.sheet;

import android.view.View;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;

/* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$3 implements View.OnClickListener {
    public final /* synthetic */ StoreVoiceParticipants.VoiceUser $participant;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant this$0;

    public WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$3(WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant viewHolderParticipant, StoreVoiceParticipants.VoiceUser voiceUser) {
        this.this$0 = viewHolderParticipant;
        this.$participant = voiceUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnDismissRequest().invoke(this.$participant);
    }
}
