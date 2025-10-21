package com.discord.api.directory;


/* compiled from: DirectoryEntryGuild.kt */
/* renamed from: com.discord.api.directory.DirectoryEntryType, reason: use source file name */
/* loaded from: classes.dex */
public enum DirectoryEntryGuild3 {
    Guild(0),
    GuildScheduledEvent(1);

    private final int key;

    DirectoryEntryGuild3(int i) {
        this.key = i;
    }

    public final int getKey() {
        return this.key;
    }
}
