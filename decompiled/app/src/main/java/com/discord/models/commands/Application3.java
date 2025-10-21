package com.discord.models.commands;

import com.discord.api.user.User;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.Intrinsics3;

/* compiled from: Application.kt */
/* renamed from: com.discord.models.commands.ApplicationKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Application3 {
    public static final boolean hasBotAvatar(Application application) {
        Intrinsics3.checkNotNullParameter(application, "$this$hasBotAvatar");
        User bot = application.getBot();
        return (bot != null ? bot.a() : null) instanceof NullSerializable.b;
    }
}
