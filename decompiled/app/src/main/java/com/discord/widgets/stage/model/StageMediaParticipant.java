package com.discord.widgets.stage.model;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.m;

/* compiled from: StageCallModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class StageMediaParticipant {
    private final Channel channel;
    private final String id;
    private final boolean isBlocked;
    private final boolean isModerator;
    private final StageCallItem.MediaType mediaType;
    private final StoreVoiceParticipants.VoiceUser voiceUser;

    public StageMediaParticipant(String str, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, StageCallItem.MediaType mediaType) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(voiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(mediaType, "mediaType");
        this.id = str;
        this.voiceUser = voiceUser;
        this.channel = channel;
        this.isModerator = z2;
        this.isBlocked = z3;
        this.mediaType = mediaType;
    }

    public static /* synthetic */ StageMediaParticipant copy$default(StageMediaParticipant stageMediaParticipant, String str, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, StageCallItem.MediaType mediaType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stageMediaParticipant.id;
        }
        if ((i & 2) != 0) {
            voiceUser = stageMediaParticipant.voiceUser;
        }
        StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
        if ((i & 4) != 0) {
            channel = stageMediaParticipant.channel;
        }
        Channel channel2 = channel;
        if ((i & 8) != 0) {
            z2 = stageMediaParticipant.isModerator;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = stageMediaParticipant.isBlocked;
        }
        boolean z5 = z3;
        if ((i & 32) != 0) {
            mediaType = stageMediaParticipant.mediaType;
        }
        return stageMediaParticipant.copy(str, voiceUser2, channel2, z4, z5, mediaType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final StoreVoiceParticipants.VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    /* renamed from: component6, reason: from getter */
    public final StageCallItem.MediaType getMediaType() {
        return this.mediaType;
    }

    public final StageMediaParticipant copy(String id2, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean isModerator, boolean isBlocked, StageCallItem.MediaType mediaType) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(voiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(mediaType, "mediaType");
        return new StageMediaParticipant(id2, voiceUser, channel, isModerator, isBlocked, mediaType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageMediaParticipant)) {
            return false;
        }
        StageMediaParticipant stageMediaParticipant = (StageMediaParticipant) other;
        return m.areEqual(this.id, stageMediaParticipant.id) && m.areEqual(this.voiceUser, stageMediaParticipant.voiceUser) && m.areEqual(this.channel, stageMediaParticipant.channel) && this.isModerator == stageMediaParticipant.isModerator && this.isBlocked == stageMediaParticipant.isBlocked && m.areEqual(this.mediaType, stageMediaParticipant.mediaType);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getId() {
        return this.id;
    }

    public final StageCallItem.MediaType getMediaType() {
        return this.mediaType;
    }

    public final StoreVoiceParticipants.VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        StoreVoiceParticipants.VoiceUser voiceUser = this.voiceUser;
        int iHashCode2 = (iHashCode + (voiceUser != null ? voiceUser.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.isModerator;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.isBlocked;
        int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        StageCallItem.MediaType mediaType = this.mediaType;
        return i3 + (mediaType != null ? mediaType.hashCode() : 0);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = a.U("StageMediaParticipant(id=");
        sbU.append(this.id);
        sbU.append(", voiceUser=");
        sbU.append(this.voiceUser);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", isBlocked=");
        sbU.append(this.isBlocked);
        sbU.append(", mediaType=");
        sbU.append(this.mediaType);
        sbU.append(")");
        return sbU.toString();
    }
}
