package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.widgets.guilds.invite.InviteSuggestionsAdapter;

/* compiled from: InviteSuggestionsAdapter.kt */
/* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsAdapter$InviteSuggestionViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class InviteSuggestionsAdapter2 implements View.OnClickListener {
    public final /* synthetic */ InviteSuggestionItemV2 $data;
    public final /* synthetic */ InviteSuggestionsAdapter.InviteSuggestionViewHolder this$0;

    public InviteSuggestionsAdapter2(InviteSuggestionsAdapter.InviteSuggestionViewHolder inviteSuggestionViewHolder, InviteSuggestionItemV2 inviteSuggestionItemV2) {
        this.this$0 = inviteSuggestionViewHolder;
        this.$data = inviteSuggestionItemV2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InviteSuggestionsAdapter.InviteSuggestionViewHolder.access$getAdapter$p(this.this$0).getOnClick().invoke(this.$data);
    }
}
