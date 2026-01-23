package com.discord.widgets.voice.sheet;

import android.view.View;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderEvent$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;
    public final /* synthetic */ CallParticipantsAdapter.ViewHolderEvent this$0;

    public CallParticipantsAdapter$ViewHolderEvent$onConfigure$1(CallParticipantsAdapter.ViewHolderEvent viewHolderEvent, MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.this$0 = viewHolderEvent;
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CallParticipantsAdapter.ViewHolderEvent.access$getAdapter$p(this.this$0).getOnEventClicked().invoke(((CallParticipantsAdapter.ListItem.Event) this.$data).getEvent());
    }
}
