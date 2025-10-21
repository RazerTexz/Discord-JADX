package com.discord.api.message.embed;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: EmbedFooter.kt */
/* loaded from: classes.dex */
public final /* data */ class EmbedFooter {
    private final String iconUrl;
    private final String proxyIconUrl;
    private final String text;

    /* renamed from: a, reason: from getter */
    public final String getProxyIconUrl() {
        return this.proxyIconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedFooter)) {
            return false;
        }
        EmbedFooter embedFooter = (EmbedFooter) other;
        return Intrinsics3.areEqual(this.text, embedFooter.text) && Intrinsics3.areEqual(this.iconUrl, embedFooter.iconUrl) && Intrinsics3.areEqual(this.proxyIconUrl, embedFooter.proxyIconUrl);
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.iconUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.proxyIconUrl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbedFooter(text=");
        sbU.append(this.text);
        sbU.append(", iconUrl=");
        sbU.append(this.iconUrl);
        sbU.append(", proxyIconUrl=");
        return outline.J(sbU, this.proxyIconUrl, ")");
    }
}
