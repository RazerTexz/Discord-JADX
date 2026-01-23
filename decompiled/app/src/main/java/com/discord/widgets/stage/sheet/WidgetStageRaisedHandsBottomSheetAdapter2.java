package com.discord.widgets.stage.sheet;

import android.view.View;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter2 implements View.OnClickListener {
    public final /* synthetic */ StoreVoiceParticipants.VoiceUser $participant$inlined;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant this$0;

    public WidgetStageRaisedHandsBottomSheetAdapter2(WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant viewHolderParticipant, StoreVoiceParticipants.VoiceUser voiceUser) {
        this.this$0 = viewHolderParticipant;
        this.$participant$inlined = voiceUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnInviteToSpeak().invoke(this.$participant$inlined);
    }
}
