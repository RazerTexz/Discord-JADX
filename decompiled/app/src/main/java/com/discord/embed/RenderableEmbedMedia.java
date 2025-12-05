package com.discord.embed;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RenderableEmbedMedia.kt */
/* loaded from: classes.dex */
public final /* data */ class RenderableEmbedMedia {

    /* renamed from: a, reason: from kotlin metadata */
    public final String url;

    /* renamed from: b, reason: from kotlin metadata */
    public final Integer width;

    /* renamed from: c, reason: from kotlin metadata */
    public final Integer height;

    public RenderableEmbedMedia(String str, Integer num, Integer num2) {
        this.url = str;
        this.width = num;
        this.height = num2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenderableEmbedMedia)) {
            return false;
        }
        RenderableEmbedMedia renderableEmbedMedia = (RenderableEmbedMedia) other;
        return Intrinsics3.areEqual(this.url, renderableEmbedMedia.url) && Intrinsics3.areEqual(this.width, renderableEmbedMedia.width) && Intrinsics3.areEqual(this.height, renderableEmbedMedia.height);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.width;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("RenderableEmbedMedia(url=");
        sbM833U.append(this.url);
        sbM833U.append(", width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        return outline.m818F(sbM833U, this.height, ")");
    }
}
