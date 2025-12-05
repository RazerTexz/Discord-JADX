package com.discord.analytics.generated.traits;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackLocationStackMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackLocationStackMetadata {
    private final List<CharSequence> locationStack = null;

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackLocationStackMetadata) && Intrinsics3.areEqual(this.locationStack, ((TrackLocationStackMetadata) other).locationStack);
        }
        return true;
    }

    public int hashCode() {
        List<CharSequence> list = this.locationStack;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m824L(outline.m833U("TrackLocationStackMetadata(locationStack="), this.locationStack, ")");
    }
}
