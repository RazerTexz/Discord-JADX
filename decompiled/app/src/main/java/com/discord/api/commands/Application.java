package com.discord.api.commands;

import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;

/* compiled from: Application.kt */
/* loaded from: classes.dex */
public final class Application implements Serializable {
    private final User bot;
    private final boolean builtIn;
    private final int commandCount;
    private final String icon;
    private final long id;
    private final String name;

    /* renamed from: a, reason: from getter */
    public final User getBot() {
        return this.bot;
    }

    /* renamed from: b, reason: from getter */
    public final int getCommandCount() {
        return this.commandCount;
    }

    /* renamed from: c, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final long getId() {
        return this.id;
    }
}
