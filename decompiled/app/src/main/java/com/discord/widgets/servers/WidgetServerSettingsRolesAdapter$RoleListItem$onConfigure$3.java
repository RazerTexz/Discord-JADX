package com.discord.widgets.servers;

import android.view.View;
import com.discord.R;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsRolesAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$3 extends o implements Function1<View, Unit> {
    public static final WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$3 INSTANCE = new WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$3();

    public WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        b.a.d.m.g(view.getContext(), R.string.help_missing_manage_roles_permission, 0, null, 12);
    }
}
