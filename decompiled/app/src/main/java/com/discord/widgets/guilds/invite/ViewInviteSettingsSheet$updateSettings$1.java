package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ViewInviteSettingsSheet.kt */
/* loaded from: classes2.dex */
public final class ViewInviteSettingsSheet$updateSettings$1 extends o implements Function1<ModelInvite.Settings, Unit> {
    public static final ViewInviteSettingsSheet$updateSettings$1 INSTANCE = new ViewInviteSettingsSheet$updateSettings$1();

    public ViewInviteSettingsSheet$updateSettings$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite.Settings settings) {
        invoke2(settings);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite.Settings settings) {
        m.checkNotNullParameter(settings, "it");
    }
}
