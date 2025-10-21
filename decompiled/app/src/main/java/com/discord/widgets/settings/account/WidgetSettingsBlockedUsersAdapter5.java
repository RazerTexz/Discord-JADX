package com.discord.widgets.settings.account;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersAdapter$onClickUserProfile$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter5 extends Lambda implements Function1<User, Unit> {
    public static final WidgetSettingsBlockedUsersAdapter5 INSTANCE = new WidgetSettingsBlockedUsersAdapter5();

    public WidgetSettingsBlockedUsersAdapter5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
    }
}
