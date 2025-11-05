package com.discord.widgets.voice.sheet;

import android.view.View;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CallParticipantsAdapter.kt */
/* loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderInvite$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ CallParticipantsAdapter.ViewHolderInvite this$0;

    public CallParticipantsAdapter$ViewHolderInvite$onConfigure$1(CallParticipantsAdapter.ViewHolderInvite viewHolderInvite) {
        this.this$0 = viewHolderInvite;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<View, Unit> onInviteFriendsClicked = CallParticipantsAdapter.ViewHolderInvite.access$getAdapter$p(this.this$0).getOnInviteFriendsClicked();
        m.checkNotNullExpressionValue(view, "it");
        onInviteFriendsClicked.invoke(view);
    }
}
