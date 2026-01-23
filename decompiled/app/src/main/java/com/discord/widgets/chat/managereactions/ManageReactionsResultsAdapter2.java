package com.discord.widgets.chat.managereactions;

import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;
import java.util.Objects;

/* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter$ErrorViewHolder$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter2 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public ManageReactionsResultsAdapter2(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MGRecyclerDataPayload mGRecyclerDataPayload = this.$data;
        Objects.requireNonNull(mGRecyclerDataPayload, "null cannot be cast to non-null type com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter.ErrorItem");
        ManageReactionsResultsAdapter.ErrorItem errorItem = (ManageReactionsResultsAdapter.ErrorItem) mGRecyclerDataPayload;
        StoreStream.INSTANCE.getMessageReactions().forceRetryFetchReactions(errorItem.getChannelId(), errorItem.getMessageId(), errorItem.getEmoji());
    }
}
