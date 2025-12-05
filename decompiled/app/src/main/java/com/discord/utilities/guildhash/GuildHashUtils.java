package com.discord.utilities.guildhash;

import com.discord.api.guildhash.GuildHashes;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildHashUtils.kt */
/* renamed from: com.discord.utilities.guildhash.GuildHashUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildHashUtils {
    public static final boolean isSupported(GuildHashes guildHashes) {
        Intrinsics3.checkNotNullParameter(guildHashes, "$this$isSupported");
        return guildHashes.getVersion() == 1;
    }
}
