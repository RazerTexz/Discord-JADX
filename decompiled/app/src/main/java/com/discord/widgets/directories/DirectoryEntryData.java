package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
/* loaded from: classes2.dex */
public final /* data */ class DirectoryEntryData {
    private final DirectoryEntryGuild entry;
    private final boolean hasEditPermissions;
    private final boolean hasJoinedGuild;

    public DirectoryEntryData(DirectoryEntryGuild directoryEntryGuild, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(directoryEntryGuild, "entry");
        this.entry = directoryEntryGuild;
        this.hasJoinedGuild = z2;
        this.hasEditPermissions = z3;
    }

    public static /* synthetic */ DirectoryEntryData copy$default(DirectoryEntryData directoryEntryData, DirectoryEntryGuild directoryEntryGuild, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            directoryEntryGuild = directoryEntryData.entry;
        }
        if ((i & 2) != 0) {
            z2 = directoryEntryData.hasJoinedGuild;
        }
        if ((i & 4) != 0) {
            z3 = directoryEntryData.hasEditPermissions;
        }
        return directoryEntryData.copy(directoryEntryGuild, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final DirectoryEntryGuild getEntry() {
        return this.entry;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasJoinedGuild() {
        return this.hasJoinedGuild;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasEditPermissions() {
        return this.hasEditPermissions;
    }

    public final DirectoryEntryData copy(DirectoryEntryGuild entry, boolean hasJoinedGuild, boolean hasEditPermissions) {
        Intrinsics3.checkNotNullParameter(entry, "entry");
        return new DirectoryEntryData(entry, hasJoinedGuild, hasEditPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryData)) {
            return false;
        }
        DirectoryEntryData directoryEntryData = (DirectoryEntryData) other;
        return Intrinsics3.areEqual(this.entry, directoryEntryData.entry) && this.hasJoinedGuild == directoryEntryData.hasJoinedGuild && this.hasEditPermissions == directoryEntryData.hasEditPermissions;
    }

    public final DirectoryEntryGuild getEntry() {
        return this.entry;
    }

    public final boolean getHasEditPermissions() {
        return this.hasEditPermissions;
    }

    public final boolean getHasJoinedGuild() {
        return this.hasJoinedGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        DirectoryEntryGuild directoryEntryGuild = this.entry;
        int iHashCode = (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0) * 31;
        boolean z2 = this.hasJoinedGuild;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.hasEditPermissions;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DirectoryEntryData(entry=");
        sbM833U.append(this.entry);
        sbM833U.append(", hasJoinedGuild=");
        sbM833U.append(this.hasJoinedGuild);
        sbM833U.append(", hasEditPermissions=");
        return outline.m827O(sbM833U, this.hasEditPermissions, ")");
    }
}
