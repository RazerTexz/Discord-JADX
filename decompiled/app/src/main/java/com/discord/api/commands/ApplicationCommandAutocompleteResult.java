package com.discord.api.commands;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: ApplicationCommandAutocompleteResult.kt */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandAutocompleteResult {
    private final List<ApplicationCommandAutocompleteChoice> choices;
    private final String nonce;

    public final List<ApplicationCommandAutocompleteChoice> a() {
        return this.choices;
    }

    /* renamed from: b, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandAutocompleteResult)) {
            return false;
        }
        ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult = (ApplicationCommandAutocompleteResult) other;
        return Intrinsics3.areEqual(this.nonce, applicationCommandAutocompleteResult.nonce) && Intrinsics3.areEqual(this.choices, applicationCommandAutocompleteResult.choices);
    }

    public int hashCode() {
        String str = this.nonce;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ApplicationCommandAutocompleteChoice> list = this.choices;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandAutocompleteResult(nonce=");
        sbU.append(this.nonce);
        sbU.append(", choices=");
        return outline.L(sbU, this.choices, ")");
    }
}
