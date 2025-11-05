package com.discord.api.guildrolesubscription;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PayoutGroupStatus.kt */
/* loaded from: classes.dex */
public enum PayoutGroupStatus {
    UNKNOWN(0),
    OPEN(1),
    PAYOUT_CREATED(2),
    CANCELED(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: PayoutGroupStatus.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    PayoutGroupStatus(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
