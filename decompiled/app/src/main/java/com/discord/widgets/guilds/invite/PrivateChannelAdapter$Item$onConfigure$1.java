package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.widgets.guilds.invite.PrivateChannelAdapter;

/* compiled from: PrivateChannelAdapter.kt */
/* loaded from: classes2.dex */
public final class PrivateChannelAdapter$Item$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ InviteSuggestionItem $data;
    public final /* synthetic */ PrivateChannelAdapter.Item this$0;

    public PrivateChannelAdapter$Item$onConfigure$1(PrivateChannelAdapter.Item item, InviteSuggestionItem inviteSuggestionItem) {
        this.this$0 = item;
        this.$data = inviteSuggestionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PrivateChannelAdapter.Item.access$getAdapter$p(this.this$0).getOnClick().invoke(this.$data);
    }
}
