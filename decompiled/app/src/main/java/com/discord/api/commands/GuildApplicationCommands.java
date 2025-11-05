package com.discord.api.commands;

import java.util.List;

/* compiled from: GuildApplicationCommands.kt */
/* loaded from: classes.dex */
public final class GuildApplicationCommands {
    private final List<ApplicationCommand> applicationCommands;
    private final List<Application> applications;
    private final long guildId;
    private final String nonce;
    private final long updatedAt;

    public final List<ApplicationCommand> a() {
        return this.applicationCommands;
    }

    public final List<Application> b() {
        return this.applications;
    }

    /* renamed from: c, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }
}
