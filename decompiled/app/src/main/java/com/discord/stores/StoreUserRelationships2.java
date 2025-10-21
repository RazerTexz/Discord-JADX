package com.discord.stores;

import d0.Tuples;
import d0.t.Maps6;
import java.util.HashMap;

/* compiled from: StoreUserRelationships.kt */
/* renamed from: com.discord.stores.StoreUserRelationshipsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreUserRelationships2 {
    private static final HashMap<Long, Integer> UNLOADED_RELATIONSHIPS_SENTINEL = Maps6.hashMapOf(Tuples.to(-1L, -1));

    public static final /* synthetic */ HashMap access$getUNLOADED_RELATIONSHIPS_SENTINEL$p() {
        return UNLOADED_RELATIONSHIPS_SENTINEL;
    }
}
