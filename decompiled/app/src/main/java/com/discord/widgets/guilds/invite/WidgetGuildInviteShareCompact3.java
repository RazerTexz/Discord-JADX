package com.discord.widgets.guilds.invite;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildInviteShareCompact.kt */
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact3 extends Lambda implements Function1<InviteSuggestionItem, Unit> {
    public static final WidgetGuildInviteShareCompact3 INSTANCE = new WidgetGuildInviteShareCompact3();

    public WidgetGuildInviteShareCompact3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
        invoke2(inviteSuggestionItem);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
        Intrinsics3.checkNotNullParameter(inviteSuggestionItem, "it");
    }
}
