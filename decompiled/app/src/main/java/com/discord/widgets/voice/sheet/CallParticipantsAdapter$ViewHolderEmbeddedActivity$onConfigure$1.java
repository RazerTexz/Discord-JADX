package com.discord.widgets.voice.sheet;

import android.view.View;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderEmbeddedActivity$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ CallParticipantsAdapter.ViewHolderEmbeddedActivity this$0;

    public CallParticipantsAdapter$ViewHolderEmbeddedActivity$onConfigure$1(CallParticipantsAdapter.ViewHolderEmbeddedActivity viewHolderEmbeddedActivity) {
        this.this$0 = viewHolderEmbeddedActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CallParticipantsAdapter.ViewHolderEmbeddedActivity.access$getAdapter$p(this.this$0).getOnEmbeddedActivityClicked().invoke();
    }
}
