package com.discord.widgets.stage.model;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StageChannel.kt */
/* loaded from: classes2.dex */
public final /* data */ class StageChannel {
    private final int audienceSize;
    private final boolean canAccess;
    private final Channel channel;
    private final boolean containsMe;
    private final StageRoles myRoles;
    private final List<User> participants;
    private final Set<Long> speakerIds;
    private final List<UserGuildMember> speakers;
    private final StageInstance stageInstance;

    /* JADX WARN: Multi-variable type inference failed */
    private StageChannel(Channel channel, List<? extends User> list, StageRoles stageRoles, Set<Long> set, List<UserGuildMember> list2, int i, StageInstance stageInstance, boolean z2, boolean z3) {
        this.channel = channel;
        this.participants = list;
        this.myRoles = stageRoles;
        this.speakerIds = set;
        this.speakers = list2;
        this.audienceSize = i;
        this.stageInstance = stageInstance;
        this.canAccess = z2;
        this.containsMe = z3;
    }

    /* renamed from: copy-LcZnYPc$default, reason: not valid java name */
    public static /* synthetic */ StageChannel m43copyLcZnYPc$default(StageChannel stageChannel, Channel channel, List list, StageRoles stageRoles, Set set, List list2, int i, StageInstance stageInstance, boolean z2, boolean z3, int i2, Object obj) {
        return stageChannel.m45copyLcZnYPc((i2 & 1) != 0 ? stageChannel.channel : channel, (i2 & 2) != 0 ? stageChannel.participants : list, (i2 & 4) != 0 ? stageChannel.myRoles : stageRoles, (i2 & 8) != 0 ? stageChannel.speakerIds : set, (i2 & 16) != 0 ? stageChannel.speakers : list2, (i2 & 32) != 0 ? stageChannel.audienceSize : i, (i2 & 64) != 0 ? stageChannel.stageInstance : stageInstance, (i2 & 128) != 0 ? stageChannel.canAccess : z2, (i2 & 256) != 0 ? stageChannel.containsMe : z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final List<User> component2() {
        return this.participants;
    }

    /* renamed from: component3-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getMyRoles() {
        return this.myRoles;
    }

    public final Set<Long> component4() {
        return this.speakerIds;
    }

    public final List<UserGuildMember> component5() {
        return this.speakers;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    /* renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanAccess() {
        return this.canAccess;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getContainsMe() {
        return this.containsMe;
    }

    /* renamed from: copy-LcZnYPc, reason: not valid java name */
    public final StageChannel m45copyLcZnYPc(Channel channel, List<? extends User> participants, StageRoles myRoles, Set<Long> speakerIds, List<UserGuildMember> speakers, int audienceSize, StageInstance stageInstance, boolean canAccess, boolean containsMe) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(participants, "participants");
        Intrinsics3.checkNotNullParameter(speakerIds, "speakerIds");
        Intrinsics3.checkNotNullParameter(speakers, "speakers");
        return new StageChannel(channel, participants, myRoles, speakerIds, speakers, audienceSize, stageInstance, canAccess, containsMe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageChannel)) {
            return false;
        }
        StageChannel stageChannel = (StageChannel) other;
        return Intrinsics3.areEqual(this.channel, stageChannel.channel) && Intrinsics3.areEqual(this.participants, stageChannel.participants) && Intrinsics3.areEqual(this.myRoles, stageChannel.myRoles) && Intrinsics3.areEqual(this.speakerIds, stageChannel.speakerIds) && Intrinsics3.areEqual(this.speakers, stageChannel.speakers) && this.audienceSize == stageChannel.audienceSize && Intrinsics3.areEqual(this.stageInstance, stageChannel.stageInstance) && this.canAccess == stageChannel.canAccess && this.containsMe == stageChannel.containsMe;
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final boolean getCanAccess() {
        return this.canAccess;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getContainsMe() {
        return this.containsMe;
    }

    public final boolean getHasActiveStageInstance() {
        return this.stageInstance != null;
    }

    /* renamed from: getMyRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m46getMyRolestwRsX0() {
        return this.myRoles;
    }

    public final List<User> getParticipants() {
        return this.participants;
    }

    public final Set<Long> getSpeakerIds() {
        return this.speakerIds;
    }

    public final List<UserGuildMember> getSpeakers() {
        return this.speakers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        List<User> list = this.participants;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        StageRoles stageRoles = this.myRoles;
        int iHashCode3 = (iHashCode2 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
        Set<Long> set = this.speakerIds;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        List<UserGuildMember> list2 = this.speakers;
        int iHashCode5 = (((iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.audienceSize) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode6 = (iHashCode5 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        boolean z2 = this.canAccess;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode6 + i) * 31;
        boolean z3 = this.containsMe;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageChannel(channel=");
        sbU.append(this.channel);
        sbU.append(", participants=");
        sbU.append(this.participants);
        sbU.append(", myRoles=");
        sbU.append(this.myRoles);
        sbU.append(", speakerIds=");
        sbU.append(this.speakerIds);
        sbU.append(", speakers=");
        sbU.append(this.speakers);
        sbU.append(", audienceSize=");
        sbU.append(this.audienceSize);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", canAccess=");
        sbU.append(this.canAccess);
        sbU.append(", containsMe=");
        return outline.O(sbU, this.containsMe, ")");
    }

    public /* synthetic */ StageChannel(Channel channel, List list, StageRoles stageRoles, Set set, List list2, int i, StageInstance stageInstance, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, list, stageRoles, set, list2, i, stageInstance, z2, z3);
    }
}
