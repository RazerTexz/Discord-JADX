package com.discord.widgets.guilds.invite;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

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
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
        Intrinsics3.checkNotNullParameter(inviteSuggestionItem, "it");
    }
}
