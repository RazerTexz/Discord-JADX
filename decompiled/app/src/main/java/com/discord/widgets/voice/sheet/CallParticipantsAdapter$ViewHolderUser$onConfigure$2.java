package com.discord.widgets.voice.sheet;

import android.view.View;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;

/* compiled from: CallParticipantsAdapter.kt */
/* loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderUser$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ StoreVoiceParticipants.VoiceUser $voiceUser;
    public final /* synthetic */ CallParticipantsAdapter.ViewHolderUser this$0;

    public CallParticipantsAdapter$ViewHolderUser$onConfigure$2(CallParticipantsAdapter.ViewHolderUser viewHolderUser, StoreVoiceParticipants.VoiceUser voiceUser) {
        this.this$0 = viewHolderUser;
        this.$voiceUser = voiceUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CallParticipantsAdapter.ViewHolderUser.access$getAdapter$p(this.this$0).getOnVoiceUserClicked().invoke(this.$voiceUser);
    }
}
