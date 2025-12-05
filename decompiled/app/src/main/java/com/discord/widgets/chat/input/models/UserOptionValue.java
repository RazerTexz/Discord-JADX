package com.discord.widgets.chat.input.models;

import com.discord.models.user.User;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CommandOptionValue.kt */
/* loaded from: classes2.dex */
public final class UserOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserOptionValue(User user) {
        super(String.valueOf(user.getId()), null);
        Intrinsics3.checkNotNullParameter(user, "user");
    }
}
