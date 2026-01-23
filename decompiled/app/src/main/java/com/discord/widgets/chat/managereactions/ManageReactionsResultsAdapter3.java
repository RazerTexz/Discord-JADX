package com.discord.widgets.chat.managereactions;

import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;

/* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter$ReactionUserViewHolder$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter3 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public ManageReactionsResultsAdapter3(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreStream.INSTANCE.getMessageReactions().deleteEmoji(((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getChannelId(), ((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getMessageId(), ((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getEmoji(), ((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getUser().getId());
    }
}
