package com.discord.widgets.channels.permissions;

import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.FunctionReferenceImpl;

/* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsAdvanced3 extends FunctionReferenceImpl implements Function2<User, User, Integer> {
    public static final WidgetChannelSettingsPermissionsAdvanced3 INSTANCE = new WidgetChannelSettingsPermissionsAdvanced3();

    public WidgetChannelSettingsPermissionsAdvanced3() {
        super(2, UserUtils.class, "compareUserNames", "compareUserNames(Lcom/discord/models/user/User;Lcom/discord/models/user/User;)I", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(User user, User user2) {
        return Integer.valueOf(invoke2(user, user2));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(User user, User user2) {
        return UserUtils.INSTANCE.compareUserNames(user, user2);
    }
}
