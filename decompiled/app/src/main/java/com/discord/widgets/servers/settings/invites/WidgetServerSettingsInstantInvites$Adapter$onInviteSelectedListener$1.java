package com.discord.widgets.servers.settings.invites;

import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsInstantInvites.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1 extends o implements Function1<ModelInvite, Unit> {
    public static final WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1 INSTANCE = new WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1();

    public WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        m.checkNotNullParameter(modelInvite, "it");
    }
}
