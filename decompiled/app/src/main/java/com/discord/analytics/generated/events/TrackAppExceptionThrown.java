package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAppExceptionThrown.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAppExceptionThrown implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence stacktrace = null;
    private final transient String analyticsSchemaTypeName = "app_exception_thrown";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAppExceptionThrown) && Intrinsics3.areEqual(this.stacktrace, ((TrackAppExceptionThrown) other).stacktrace);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.stacktrace;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackAppExceptionThrown(stacktrace="), this.stacktrace, ")");
    }
}
