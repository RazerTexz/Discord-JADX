package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.widgets.guilds.invite.PrivateChannelAdapter;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.PrivateChannelAdapter$Item$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: PrivateChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelAdapter2 implements View.OnClickListener {
    public final /* synthetic */ InviteSuggestionItem $data;
    public final /* synthetic */ PrivateChannelAdapter.Item this$0;

    public PrivateChannelAdapter2(PrivateChannelAdapter.Item item, InviteSuggestionItem inviteSuggestionItem) {
        this.this$0 = item;
        this.$data = inviteSuggestionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PrivateChannelAdapter.Item.access$getAdapter$p(this.this$0).getOnClick().invoke(this.$data);
    }
}
