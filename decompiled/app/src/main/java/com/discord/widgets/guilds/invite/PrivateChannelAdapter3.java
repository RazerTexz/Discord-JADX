package com.discord.widgets.guilds.invite;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.PrivateChannelAdapter$onClick$1, reason: use source file name */
/* JADX INFO: compiled from: PrivateChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelAdapter3 extends Lambda implements Function1<InviteSuggestionItem, Unit> {
    public static final PrivateChannelAdapter3 INSTANCE = new PrivateChannelAdapter3();

    public PrivateChannelAdapter3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
        invoke2(inviteSuggestionItem);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
        Intrinsics3.checkNotNullParameter(inviteSuggestionItem, "it");
    }
}
