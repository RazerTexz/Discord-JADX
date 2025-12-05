package com.discord.api.localizedstring;

import java.io.Serializable;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: LocalizedString.kt */
/* loaded from: classes.dex */
public final /* data */ class LocalizedString implements Serializable {
    private final String default;
    private final Map<String, String> localizations;

    public LocalizedString(String str, Map<String, String> map) {
        Intrinsics3.checkNotNullParameter(str, "default");
        Intrinsics3.checkNotNullParameter(map, "localizations");
        this.default = str;
        this.localizations = map;
    }

    /* renamed from: a, reason: from getter */
    public final String getDefault() {
        return this.default;
    }

    /* renamed from: b */
    public final Map<String, String> m8017b() {
        return this.localizations;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalizedString)) {
            return false;
        }
        LocalizedString localizedString = (LocalizedString) other;
        return Intrinsics3.areEqual(this.default, localizedString.default) && Intrinsics3.areEqual(this.localizations, localizedString.localizations);
    }

    public int hashCode() {
        String str = this.default;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.localizations;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("LocalizedString(default=");
        sbM833U.append(this.default);
        sbM833U.append(", localizations=");
        return outline.m825M(sbM833U, this.localizations, ")");
    }
}
