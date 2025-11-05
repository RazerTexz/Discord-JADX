package com.discord.utilities.guildhash;

import com.discord.api.guildhash.GuildHashes;
import d0.z.d.m;

/* compiled from: GuildHashUtils.kt */
/* loaded from: classes2.dex */
public final class GuildHashUtilsKt {
    public static final boolean isSupported(GuildHashes guildHashes) {
        m.checkNotNullParameter(guildHashes, "$this$isSupported");
        return guildHashes.getVersion() == 1;
    }
}
