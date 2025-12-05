package com.discord.stores.updates;

import kotlin.Lazy;
import p507d0.LazyJVM;

/* compiled from: ObservationDeck.kt */
/* renamed from: com.discord.stores.updates.ObservationDeckProvider, reason: use source file name */
/* loaded from: classes2.dex */
public final class ObservationDeck4 {
    public static final ObservationDeck4 INSTANCE = new ObservationDeck4();

    /* renamed from: INSTANCE$delegate, reason: from kotlin metadata */
    private static final Lazy INSTANCE = LazyJVM.lazy(ObservationDeck5.INSTANCE);

    private ObservationDeck4() {
    }

    public static final ObservationDeck get() {
        return INSTANCE.getINSTANCE();
    }

    private final ObservationDeck getINSTANCE() {
        return (ObservationDeck) INSTANCE.getValue();
    }
}
