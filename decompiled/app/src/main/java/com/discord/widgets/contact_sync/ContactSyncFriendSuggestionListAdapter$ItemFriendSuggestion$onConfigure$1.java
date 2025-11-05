package com.discord.widgets.contact_sync;

import android.widget.CompoundButton;
import com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter;

/* compiled from: ContactSyncFriendSuggestionListAdapter.kt */
/* loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion$onConfigure$1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ long $id;
    public final /* synthetic */ ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion this$0;

    public ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion$onConfigure$1(ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion itemFriendSuggestion, long j) {
        this.this$0 = itemFriendSuggestion;
        this.$id = j;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion.access$getAdapter$p(this.this$0).getOnClickFriendSuggestion().invoke(Long.valueOf(this.$id), Boolean.valueOf(z2));
    }
}
