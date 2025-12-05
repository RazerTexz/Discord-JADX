package com.discord.widgets.user.profile;

import com.discord.widgets.user.Badge;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: UserProfileHeaderView.kt */
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$onBadgeClick$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderView6 extends Lambda implements Function1<Badge, Unit> {
    public static final UserProfileHeaderView6 INSTANCE = new UserProfileHeaderView6();

    public UserProfileHeaderView6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        Intrinsics3.checkNotNullParameter(badge, "it");
    }
}
