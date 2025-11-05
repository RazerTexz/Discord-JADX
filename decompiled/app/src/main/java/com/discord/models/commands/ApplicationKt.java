package com.discord.models.commands;

import com.discord.api.user.User;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.m;

/* compiled from: Application.kt */
/* loaded from: classes.dex */
public final class ApplicationKt {
    public static final boolean hasBotAvatar(Application application) {
        m.checkNotNullParameter(application, "$this$hasBotAvatar");
        User bot = application.getBot();
        return (bot != null ? bot.a() : null) instanceof NullSerializable.b;
    }
}
