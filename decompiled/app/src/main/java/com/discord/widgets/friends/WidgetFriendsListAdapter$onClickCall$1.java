package com.discord.widgets.friends;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$onClickCall$1 extends Lambda implements Function1<User, Unit> {
    public static final WidgetFriendsListAdapter$onClickCall$1 INSTANCE = new WidgetFriendsListAdapter$onClickCall$1();

    public WidgetFriendsListAdapter$onClickCall$1() {
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
