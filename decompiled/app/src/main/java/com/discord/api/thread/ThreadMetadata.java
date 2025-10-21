package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ThreadMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class ThreadMetadata {
    private final String archiveTimestamp;
    private final boolean archived;
    private final int autoArchiveDuration;
    private final boolean locked;

    /* renamed from: a, reason: from getter */
    public final String getArchiveTimestamp() {
        return this.archiveTimestamp;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getArchived() {
        return this.archived;
    }

    /* renamed from: c, reason: from getter */
    public final int getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMetadata)) {
            return false;
        }
        ThreadMetadata threadMetadata = (ThreadMetadata) other;
        return this.archived == threadMetadata.archived && Intrinsics3.areEqual(this.archiveTimestamp, threadMetadata.archiveTimestamp) && this.autoArchiveDuration == threadMetadata.autoArchiveDuration && this.locked == threadMetadata.locked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z2 = this.archived;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.archiveTimestamp;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.autoArchiveDuration) * 31;
        boolean z3 = this.locked;
        return iHashCode + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadMetadata(archived=");
        sbU.append(this.archived);
        sbU.append(", archiveTimestamp=");
        sbU.append(this.archiveTimestamp);
        sbU.append(", autoArchiveDuration=");
        sbU.append(this.autoArchiveDuration);
        sbU.append(", locked=");
        return outline.O(sbU, this.locked, ")");
    }
}
