package com.discord.widgets.channels;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.channels.SimpleMembersAdapter;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.SimpleMembersAdapter$MemberAdapterItem$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: SimpleMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleMembersAdapter2 implements View.OnClickListener {
    public final /* synthetic */ User $user;
    public final /* synthetic */ SimpleMembersAdapter.MemberAdapterItem this$0;

    public SimpleMembersAdapter2(SimpleMembersAdapter.MemberAdapterItem memberAdapterItem, User user) {
        this.this$0 = memberAdapterItem;
        this.$user = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getOnUserClickedListener$p = SimpleMembersAdapter.access$getOnUserClickedListener$p(SimpleMembersAdapter.MemberAdapterItem.access$getAdapter$p(this.this$0));
        if (function1Access$getOnUserClickedListener$p != null) {
        }
    }
}
