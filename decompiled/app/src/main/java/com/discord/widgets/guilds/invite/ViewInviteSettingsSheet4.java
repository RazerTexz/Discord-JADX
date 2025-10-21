package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ViewInviteSettingsSheet.kt */
/* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$updateSettings$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewInviteSettingsSheet4 extends Lambda implements Function1<ModelInvite.Settings, Unit> {
    public static final ViewInviteSettingsSheet4 INSTANCE = new ViewInviteSettingsSheet4();

    public ViewInviteSettingsSheet4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite.Settings settings) {
        invoke2(settings);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "it");
    }
}
