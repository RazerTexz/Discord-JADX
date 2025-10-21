package com.discord.rtcconnection.enums;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TrimMemoryLevel.kt */
/* loaded from: classes.dex */
public enum TrimMemoryLevel {
    Background(40),
    RunningModerate(5),
    Moderate(60),
    RunningLow(10),
    Complete(80),
    RunningCritical(15),
    UiHidden(20);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: TrimMemoryLevel.kt */
    /* renamed from: com.discord.rtcconnection.enums.TrimMemoryLevel$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    TrimMemoryLevel(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
