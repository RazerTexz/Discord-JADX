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

    /* renamed from: a */
    public final List<ApplicationCommand> m7746a() {
        return this.applicationCommands;
    }

    /* renamed from: b */
    public final List<Application> m7747b() {
        return this.applications;
    }

    /* renamed from: c, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }
}
