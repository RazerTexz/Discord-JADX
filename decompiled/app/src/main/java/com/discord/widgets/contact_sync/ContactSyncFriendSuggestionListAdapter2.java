package com.discord.widgets.contact_sync;

import android.widget.CompoundButton;
import com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter;

/* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: ContactSyncFriendSuggestionListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter2 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ long $id;
    public final /* synthetic */ ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion this$0;

    public ContactSyncFriendSuggestionListAdapter2(ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion itemFriendSuggestion, long j) {
        this.this$0 = itemFriendSuggestion;
        this.$id = j;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion.access$getAdapter$p(this.this$0).getOnClickFriendSuggestion().invoke(Long.valueOf(this.$id), Boolean.valueOf(z2));
    }
}
