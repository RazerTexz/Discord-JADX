package com.discord.utilities.debug;

import d0.z.d.m;
import java.lang.ref.WeakReference;

/* compiled from: DebugPrintable.kt */
/* loaded from: classes2.dex */
public final class DebugPrintableRef {
    private final WeakReference<DebugPrintable> reference;
    private final String tag;

    public DebugPrintableRef(String str, DebugPrintable debugPrintable) {
        m.checkNotNullParameter(debugPrintable, "debugPrintable");
        this.tag = str;
        this.reference = new WeakReference<>(debugPrintable);
    }

    public final WeakReference<DebugPrintable> getReference() {
        return this.reference;
    }

    public final String getTag() {
        return this.tag;
    }
}
