package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zza;

    public UnsupportedApiCallException(@RecentlyNonNull Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    @RecentlyNonNull
    public String getMessage() {
        String strValueOf = String.valueOf(this.zza);
        return outline.m822J(new StringBuilder(strValueOf.length() + 8), "Missing ", strValueOf);
    }
}
