package com.discord.widgets.chat.list.entries;


/* compiled from: LoadingEntry.kt */
/* loaded from: classes2.dex */
public final class LoadingEntry extends ChatListEntry {
    private final int type = 2;
    private final String key = String.valueOf(Math.random());

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
