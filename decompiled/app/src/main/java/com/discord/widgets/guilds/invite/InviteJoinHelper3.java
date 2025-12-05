package com.discord.widgets.guilds.invite;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import p507d0.Result2;
import p507d0.p592z.p594d.Lambda;

/* compiled from: InviteJoinHelper.kt */
/* renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$4$hasCompletedMembershipGate$1$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InviteJoinHelper3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Continuation $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteJoinHelper3(Continuation continuation) {
        super(0);
        this.$cont = continuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Continuation continuation = this.$cont;
        Boolean bool = Boolean.TRUE;
        Result2.a aVar = Result2.f25169j;
        continuation.resumeWith(Result2.m11474constructorimpl(bool));
    }
}
