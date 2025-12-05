package com.discord.widgets.settings.account;

import com.discord.models.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersAdapter$onClickUnblock$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter4 extends Lambda implements Function1<User, Unit> {
    public static final WidgetSettingsBlockedUsersAdapter4 INSTANCE = new WidgetSettingsBlockedUsersAdapter4();

    public WidgetSettingsBlockedUsersAdapter4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
    }
}
