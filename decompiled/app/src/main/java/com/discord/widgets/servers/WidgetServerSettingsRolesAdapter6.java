package com.discord.widgets.servers;

import android.view.View;
import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$4, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter6 extends Lambda implements Function1<View, Unit> {
    public static final WidgetServerSettingsRolesAdapter6 INSTANCE = new WidgetServerSettingsRolesAdapter6();

    public WidgetServerSettingsRolesAdapter6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        AppToast.m169g(view.getContext(), C5419R.string.two_fa_guild_mfa_warning_ios, 0, null, 12);
    }
}
