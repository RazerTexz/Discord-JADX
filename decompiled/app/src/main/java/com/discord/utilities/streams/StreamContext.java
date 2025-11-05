package com.discord.utilities.streams;

import b.d.b.a.outline;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import d0.z.d.Intrinsics3;

/* compiled from: StreamContext.kt */
/* loaded from: classes2.dex */
public final /* data */ class StreamContext {
    private final Guild guild;
    private final boolean isCurrentUserParticipating;
    private final boolean isSelfStream;
    private final Joinability joinability;
    private final StoreApplicationStreamPreviews.StreamPreview preview;
    private final ModelApplicationStream stream;
    private final User user;
    private final String userNickname;

    /* compiled from: StreamContext.kt */
    public enum Joinability {
        CAN_CONNECT,
        VOICE_CHANNEL_FULL,
        MISSING_PERMISSIONS
    }

    public StreamContext(ModelApplicationStream modelApplicationStream, Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Joinability joinability, User user, String str, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        Intrinsics3.checkNotNullParameter(user, "user");
        this.stream = modelApplicationStream;
        this.guild = guild;
        this.preview = streamPreview;
        this.joinability = joinability;
        this.user = user;
        this.userNickname = str;
        this.isCurrentUserParticipating = z2;
        this.isSelfStream = z3;
    }

    public static /* synthetic */ StreamContext copy$default(StreamContext streamContext, ModelApplicationStream modelApplicationStream, Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Joinability joinability, User user, String str, boolean z2, boolean z3, int i, Object obj) {
        return streamContext.copy((i & 1) != 0 ? streamContext.stream : modelApplicationStream, (i & 2) != 0 ? streamContext.guild : guild, (i & 4) != 0 ? streamContext.preview : streamPreview, (i & 8) != 0 ? streamContext.joinability : joinability, (i & 16) != 0 ? streamContext.user : user, (i & 32) != 0 ? streamContext.userNickname : str, (i & 64) != 0 ? streamContext.isCurrentUserParticipating : z2, (i & 128) != 0 ? streamContext.isSelfStream : z3);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    /* renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component3, reason: from getter */
    public final StoreApplicationStreamPreviews.StreamPreview getPreview() {
        return this.preview;
    }

    /* renamed from: component4, reason: from getter */
    public final Joinability getJoinability() {
        return this.joinability;
    }

    /* renamed from: component5, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUserNickname() {
        return this.userNickname;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsCurrentUserParticipating() {
        return this.isCurrentUserParticipating;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsSelfStream() {
        return this.isSelfStream;
    }

    public final StreamContext copy(ModelApplicationStream stream, Guild guild, StoreApplicationStreamPreviews.StreamPreview preview, Joinability joinability, User user, String userNickname, boolean isCurrentUserParticipating, boolean isSelfStream) {
        Intrinsics3.checkNotNullParameter(stream, "stream");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        Intrinsics3.checkNotNullParameter(user, "user");
        return new StreamContext(stream, guild, preview, joinability, user, userNickname, isCurrentUserParticipating, isSelfStream);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamContext)) {
            return false;
        }
        StreamContext streamContext = (StreamContext) other;
        return Intrinsics3.areEqual(this.stream, streamContext.stream) && Intrinsics3.areEqual(this.guild, streamContext.guild) && Intrinsics3.areEqual(this.preview, streamContext.preview) && Intrinsics3.areEqual(this.joinability, streamContext.joinability) && Intrinsics3.areEqual(this.user, streamContext.user) && Intrinsics3.areEqual(this.userNickname, streamContext.userNickname) && this.isCurrentUserParticipating == streamContext.isCurrentUserParticipating && this.isSelfStream == streamContext.isSelfStream;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Joinability getJoinability() {
        return this.joinability;
    }

    public final StoreApplicationStreamPreviews.StreamPreview getPreview() {
        return this.preview;
    }

    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    public final User getUser() {
        return this.user;
    }

    public final String getUserNickname() {
        return this.userNickname;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ModelApplicationStream modelApplicationStream = this.stream;
        int iHashCode = (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        StoreApplicationStreamPreviews.StreamPreview streamPreview = this.preview;
        int iHashCode3 = (iHashCode2 + (streamPreview != null ? streamPreview.hashCode() : 0)) * 31;
        Joinability joinability = this.joinability;
        int iHashCode4 = (iHashCode3 + (joinability != null ? joinability.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode5 = (iHashCode4 + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.userNickname;
        int iHashCode6 = (iHashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isCurrentUserParticipating;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode6 + i) * 31;
        boolean z3 = this.isSelfStream;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isCurrentUserParticipating() {
        return this.isCurrentUserParticipating;
    }

    public final boolean isSelfStream() {
        return this.isSelfStream;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamContext(stream=");
        sbU.append(this.stream);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", preview=");
        sbU.append(this.preview);
        sbU.append(", joinability=");
        sbU.append(this.joinability);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", userNickname=");
        sbU.append(this.userNickname);
        sbU.append(", isCurrentUserParticipating=");
        sbU.append(this.isCurrentUserParticipating);
        sbU.append(", isSelfStream=");
        return outline.O(sbU, this.isSelfStream, ")");
    }
}
