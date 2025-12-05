package com.discord.api.activity;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ActivityMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class ActivityMetadata {
    private final String albumId;
    private final List<String> artistIds;
    private final List<String> buttonUrls;
    private final String contextUri;

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b */
    public final List<String> m7557b() {
        return this.buttonUrls;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityMetadata)) {
            return false;
        }
        ActivityMetadata activityMetadata = (ActivityMetadata) other;
        return Intrinsics3.areEqual(this.contextUri, activityMetadata.contextUri) && Intrinsics3.areEqual(this.albumId, activityMetadata.albumId) && Intrinsics3.areEqual(this.artistIds, activityMetadata.artistIds) && Intrinsics3.areEqual(this.buttonUrls, activityMetadata.buttonUrls);
    }

    public int hashCode() {
        String str = this.contextUri;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.albumId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.artistIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.buttonUrls;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ActivityMetadata(contextUri=");
        sbM833U.append(this.contextUri);
        sbM833U.append(", albumId=");
        sbM833U.append(this.albumId);
        sbM833U.append(", artistIds=");
        sbM833U.append(this.artistIds);
        sbM833U.append(", buttonUrls=");
        return outline.m824L(sbM833U, this.buttonUrls, ")");
    }
}
