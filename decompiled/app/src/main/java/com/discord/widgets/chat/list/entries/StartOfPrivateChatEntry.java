package com.discord.widgets.chat.list.entries;

import com.discord.models.guild.Guild;
import java.util.List;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StartOfPrivateChatEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class StartOfPrivateChatEntry extends ChatListEntry {
    private final String channelIcon;
    private final long channelId;
    private final String channelName;
    private final int channelType;
    private final boolean isSystemDM;
    private final String key;
    private final List<Guild> mutualGuilds;
    private final int type;

    public StartOfPrivateChatEntry(long j, String str, int i, String str2, boolean z2, List<Guild> list) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
        Intrinsics3.checkNotNullParameter(list, "mutualGuilds");
        this.channelId = j;
        this.channelName = str;
        this.channelType = i;
        this.channelIcon = str2;
        this.isSystemDM = z2;
        this.mutualGuilds = list;
        this.type = 29;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ StartOfPrivateChatEntry copy$default(StartOfPrivateChatEntry startOfPrivateChatEntry, long j, String str, int i, String str2, boolean z2, List list, int i2, Object obj) {
        return startOfPrivateChatEntry.copy((i2 & 1) != 0 ? startOfPrivateChatEntry.channelId : j, (i2 & 2) != 0 ? startOfPrivateChatEntry.channelName : str, (i2 & 4) != 0 ? startOfPrivateChatEntry.channelType : i, (i2 & 8) != 0 ? startOfPrivateChatEntry.channelIcon : str2, (i2 & 16) != 0 ? startOfPrivateChatEntry.isSystemDM : z2, (i2 & 32) != 0 ? startOfPrivateChatEntry.mutualGuilds : list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChannelIcon() {
        return this.channelIcon;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSystemDM() {
        return this.isSystemDM;
    }

    public final List<Guild> component6() {
        return this.mutualGuilds;
    }

    public final StartOfPrivateChatEntry copy(long channelId, String channelName, int channelType, String channelIcon, boolean isSystemDM, List<Guild> mutualGuilds) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        Intrinsics3.checkNotNullParameter(mutualGuilds, "mutualGuilds");
        return new StartOfPrivateChatEntry(channelId, channelName, channelType, channelIcon, isSystemDM, mutualGuilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartOfPrivateChatEntry)) {
            return false;
        }
        StartOfPrivateChatEntry startOfPrivateChatEntry = (StartOfPrivateChatEntry) other;
        return this.channelId == startOfPrivateChatEntry.channelId && Intrinsics3.areEqual(this.channelName, startOfPrivateChatEntry.channelName) && this.channelType == startOfPrivateChatEntry.channelType && Intrinsics3.areEqual(this.channelIcon, startOfPrivateChatEntry.channelIcon) && this.isSystemDM == startOfPrivateChatEntry.isSystemDM && Intrinsics3.areEqual(this.mutualGuilds, startOfPrivateChatEntry.mutualGuilds);
    }

    public final String getChannelIcon() {
        return this.channelIcon;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final List<Guild> getMutualGuilds() {
        return this.mutualGuilds;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iM3a = C0002b.m3a(this.channelId) * 31;
        String str = this.channelName;
        int iHashCode = (((iM3a + (str != null ? str.hashCode() : 0)) * 31) + this.channelType) * 31;
        String str2 = this.channelIcon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.isSystemDM;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        List<Guild> list = this.mutualGuilds;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isSystemDM() {
        return this.isSystemDM;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("StartOfPrivateChatEntry(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelName=");
        sbM833U.append(this.channelName);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", channelIcon=");
        sbM833U.append(this.channelIcon);
        sbM833U.append(", isSystemDM=");
        sbM833U.append(this.isSystemDM);
        sbM833U.append(", mutualGuilds=");
        return outline.m824L(sbM833U, this.mutualGuilds, ")");
    }
}
