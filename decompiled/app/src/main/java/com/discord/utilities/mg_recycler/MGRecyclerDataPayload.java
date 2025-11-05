package com.discord.utilities.mg_recycler;

import com.discord.utilities.recycler.DiffKeyProvider;

/* compiled from: MGRecyclerDataPayload.kt */
/* loaded from: classes2.dex */
public interface MGRecyclerDataPayload extends DiffKeyProvider {
    @Override // com.discord.utilities.recycler.DiffKeyProvider
    String getKey();

    int getType();
}
