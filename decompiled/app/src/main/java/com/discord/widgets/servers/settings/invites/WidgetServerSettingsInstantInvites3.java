package com.discord.widgets.servers.settings.invites;

import com.discord.models.domain.ModelInvite;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsInstantInvites.kt */
/* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites3 extends Lambda implements Function1<ModelInvite, Unit> {
    public static final WidgetServerSettingsInstantInvites3 INSTANCE = new WidgetServerSettingsInstantInvites3();

    public WidgetServerSettingsInstantInvites3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        Intrinsics3.checkNotNullParameter(modelInvite, "it");
    }
}
