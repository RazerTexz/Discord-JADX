package com.discord.api.message.embed;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: EmbedVideo.kt */
/* loaded from: classes.dex */
public final /* data */ class EmbedVideo {
    private final Integer height;
    private final String proxyUrl;
    private final String url;
    private final Integer width;

    /* renamed from: a, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final String getProxyUrl() {
        return this.proxyUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: d, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedVideo)) {
            return false;
        }
        EmbedVideo embedVideo = (EmbedVideo) other;
        return Intrinsics3.areEqual(this.url, embedVideo.url) && Intrinsics3.areEqual(this.proxyUrl, embedVideo.proxyUrl) && Intrinsics3.areEqual(this.height, embedVideo.height) && Intrinsics3.areEqual(this.width, embedVideo.width);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.proxyUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.height;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.width;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EmbedVideo(url=");
        sbM833U.append(this.url);
        sbM833U.append(", proxyUrl=");
        sbM833U.append(this.proxyUrl);
        sbM833U.append(", height=");
        sbM833U.append(this.height);
        sbM833U.append(", width=");
        return outline.m818F(sbM833U, this.width, ")");
    }
}
