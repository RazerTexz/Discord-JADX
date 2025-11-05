package com.discord.widgets.stage.model;

import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.d0.f;
import d0.f0.q;
import d0.t.g0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StageCallModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class StageCallModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<StageCallItem.AudienceItem> audience;
    private final Guild guild;
    private final boolean isLurking;
    private final List<StageMediaParticipant> mediaParticipants;
    private final int myStageRoles;
    private final int numBlockedUsers;
    private final int numSpeakers;
    private final int requestingToSpeakCount;
    private final List<StageCallItem.SpeakerItem> speakerItems;
    private final List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers;
    private final StageInstance stageInstance;

    /* compiled from: StageCallModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final StageCallModel create(Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> participants, Set<Long> blockedUsers, StageInstance stageInstance, boolean isLurking, StoreStageChannels stagesStore) {
            int i;
            int i2;
            VoiceState voiceState;
            int i3;
            boolean z2;
            String string;
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = participants.values();
            ArrayList<StoreVoiceParticipants.VoiceUser> arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (((StoreVoiceParticipants.VoiceUser) obj).isConnected()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(Long.valueOf(((StoreVoiceParticipants.VoiceUser) obj2).getUser().getId()), obj2);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                Object key = entry.getKey();
                StageRoles stageRolesM17getUserRolesuOBN1zc = stagesStore.m17getUserRolesuOBN1zc(((Number) entry.getKey()).longValue(), channel.getId());
                linkedHashMap2.put(key, StageRoles.m25boximpl(stageRolesM17getUserRolesuOBN1zc != null ? stageRolesM17getUserRolesuOBN1zc.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo()));
            }
            Collection collectionValues2 = linkedHashMap2.values();
            if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
                i = 0;
            } else {
                Iterator it = collectionValues2.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    if (StageRoles.m33isSpeakerimpl(((StageRoles) it.next()).m35unboximpl()) && (i4 = i4 + 1) < 0) {
                        n.throwCountOverflow();
                    }
                }
                i = i4;
            }
            if (arrayList.isEmpty()) {
                i2 = 0;
            } else {
                int i5 = 0;
                for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                    StageRoles stageRolesM17getUserRolesuOBN1zc2 = stagesStore.m17getUserRolesuOBN1zc(voiceUser.getUser().getId(), channel.getId());
                    if ((StageRoles.m33isSpeakerimpl(stageRolesM17getUserRolesuOBN1zc2 != null ? stageRolesM17getUserRolesuOBN1zc2.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo()) && ((voiceState = voiceUser.getVoiceState()) == null || !voiceState.getSelfVideo())) && (i5 = i5 + 1) < 0) {
                        n.throwCountOverflow();
                    }
                }
                i2 = i5;
            }
            int iCoerceAtMost = f.coerceAtMost(i2, 3);
            int i6 = 0;
            int i7 = 0;
            for (StoreVoiceParticipants.VoiceUser voiceUser2 : arrayList) {
                VoiceState voiceState2 = voiceUser2.getVoiceState();
                if (voiceState2 != null) {
                    m.checkNotNullParameter(voiceState2, "$this$hasUnackedRequestToSpeak");
                    if (d.y0(voiceState2) == StageRequestToSpeakState.REQUESTED_TO_SPEAK) {
                        i6++;
                    }
                }
                int i8 = i6;
                boolean zContains = blockedUsers.contains(Long.valueOf(voiceUser2.getUser().getId()));
                if (zContains) {
                    i7++;
                }
                int i9 = i7;
                StageRoles stageRoles = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                if (stageRoles == null || !StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
                    arrayList4.add(new StageCallItem.AudienceItem(voiceUser2, channel, RoleUtils.getHighestHoistedRole(guildRoles, guildMembers.get(Long.valueOf(voiceUser2.getUser().getId()))), zContains));
                } else {
                    if (voiceUser2.getStreamContext() != null) {
                        StageCallItem.MediaType mediaType = StageCallItem.MediaType.STREAM;
                        StringBuilder sbU = a.U("STREAM-");
                        sbU.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageMediaParticipant(sbU.toString(), voiceUser2, channel, false, zContains, mediaType));
                    }
                    VoiceState voiceState3 = voiceUser2.getVoiceState();
                    if (voiceState3 != null && voiceState3.getSelfVideo()) {
                        StageRoles stageRoles2 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        boolean z3 = stageRoles2 != null && StageRoles.m32isModeratorimpl(stageRoles2.m35unboximpl());
                        StageCallItem.MediaType mediaType2 = StageCallItem.MediaType.USER;
                        StringBuilder sbU2 = a.U("USER-");
                        sbU2.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageMediaParticipant(sbU2.toString(), voiceUser2, channel, z3, zContains, mediaType2));
                    } else {
                        StageRoles stageRoles3 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        if (stageRoles3 == null || !StageRoles.m32isModeratorimpl(stageRoles3.m35unboximpl())) {
                            i3 = 3;
                            z2 = false;
                        } else {
                            i3 = 3;
                            z2 = true;
                        }
                        if (i > i3) {
                            string = String.valueOf(arrayList3.size() % i3);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(arrayList3.size() % i3);
                            sb.append('-');
                            sb.append(i);
                            string = sb.toString();
                        }
                        arrayList3.add(new StageCallItem.SpeakerItem(voiceUser2, channel, z2, string, iCoerceAtMost, zContains));
                    }
                }
                i6 = i8;
                i7 = i9;
            }
            StageRoles stageRolesM15getMyRolesvisDeB4 = stagesStore.m15getMyRolesvisDeB4(channel.getId());
            return new StageCallModel(stageRolesM15getMyRolesvisDeB4 != null ? stageRolesM15getMyRolesvisDeB4.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo(), arrayList3, arrayList2, u.sorted(arrayList4), q.toList(q.map(q.filter(u.asSequence(arrayList3), StageCallModel$Companion$create$2.INSTANCE), StageCallModel$Companion$create$3.INSTANCE)), i6, stageInstance, i7, guild, isLurking, i, null);
        }

        public static /* synthetic */ StageCallModel create$default(Companion companion, Channel channel, Map map, Map map2, Guild guild, Map map3, Set set, StageInstance stageInstance, boolean z2, StoreStageChannels storeStageChannels, int i, Object obj) {
            return companion.create(channel, map, map2, guild, map3, set, stageInstance, z2, (i & 256) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels);
        }

        public final Observable<StageCallModel> observeStageCallModel(long channelId) {
            Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new StageCallModel$Companion$observeStageCallModel$1(channelId));
            m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private StageCallModel(int i, List<StageCallItem.SpeakerItem> list, List<StageMediaParticipant> list2, List<StageCallItem.AudienceItem> list3, List<StoreVoiceParticipants.VoiceUser> list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4) {
        this.myStageRoles = i;
        this.speakerItems = list;
        this.mediaParticipants = list2;
        this.audience = list3;
        this.speakingVoiceUsers = list4;
        this.requestingToSpeakCount = i2;
        this.stageInstance = stageInstance;
        this.numBlockedUsers = i3;
        this.guild = guild;
        this.isLurking = z2;
        this.numSpeakers = i4;
    }

    /* renamed from: copy-YvLQhEs$default, reason: not valid java name */
    public static /* synthetic */ StageCallModel m39copyYvLQhEs$default(StageCallModel stageCallModel, int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, int i5, Object obj) {
        return stageCallModel.m41copyYvLQhEs((i5 & 1) != 0 ? stageCallModel.myStageRoles : i, (i5 & 2) != 0 ? stageCallModel.speakerItems : list, (i5 & 4) != 0 ? stageCallModel.mediaParticipants : list2, (i5 & 8) != 0 ? stageCallModel.audience : list3, (i5 & 16) != 0 ? stageCallModel.speakingVoiceUsers : list4, (i5 & 32) != 0 ? stageCallModel.requestingToSpeakCount : i2, (i5 & 64) != 0 ? stageCallModel.stageInstance : stageInstance, (i5 & 128) != 0 ? stageCallModel.numBlockedUsers : i3, (i5 & 256) != 0 ? stageCallModel.guild : guild, (i5 & 512) != 0 ? stageCallModel.isLurking : z2, (i5 & 1024) != 0 ? stageCallModel.numSpeakers : i4);
    }

    /* renamed from: component1-1LxfuJo, reason: not valid java name and from getter */
    public final int getMyStageRoles() {
        return this.myStageRoles;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    /* renamed from: component11, reason: from getter */
    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final List<StageCallItem.SpeakerItem> component2() {
        return this.speakerItems;
    }

    public final List<StageMediaParticipant> component3() {
        return this.mediaParticipants;
    }

    public final List<StageCallItem.AudienceItem> component4() {
        return this.audience;
    }

    public final List<StoreVoiceParticipants.VoiceUser> component5() {
        return this.speakingVoiceUsers;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    /* renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* renamed from: component8, reason: from getter */
    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    /* renamed from: component9, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: copy-YvLQhEs, reason: not valid java name */
    public final StageCallModel m41copyYvLQhEs(int myStageRoles, List<StageCallItem.SpeakerItem> speakerItems, List<StageMediaParticipant> mediaParticipants, List<StageCallItem.AudienceItem> audience, List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers, int requestingToSpeakCount, StageInstance stageInstance, int numBlockedUsers, Guild guild, boolean isLurking, int numSpeakers) {
        m.checkNotNullParameter(speakerItems, "speakerItems");
        m.checkNotNullParameter(mediaParticipants, "mediaParticipants");
        m.checkNotNullParameter(audience, "audience");
        m.checkNotNullParameter(speakingVoiceUsers, "speakingVoiceUsers");
        return new StageCallModel(myStageRoles, speakerItems, mediaParticipants, audience, speakingVoiceUsers, requestingToSpeakCount, stageInstance, numBlockedUsers, guild, isLurking, numSpeakers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallModel)) {
            return false;
        }
        StageCallModel stageCallModel = (StageCallModel) other;
        return this.myStageRoles == stageCallModel.myStageRoles && m.areEqual(this.speakerItems, stageCallModel.speakerItems) && m.areEqual(this.mediaParticipants, stageCallModel.mediaParticipants) && m.areEqual(this.audience, stageCallModel.audience) && m.areEqual(this.speakingVoiceUsers, stageCallModel.speakingVoiceUsers) && this.requestingToSpeakCount == stageCallModel.requestingToSpeakCount && m.areEqual(this.stageInstance, stageCallModel.stageInstance) && this.numBlockedUsers == stageCallModel.numBlockedUsers && m.areEqual(this.guild, stageCallModel.guild) && this.isLurking == stageCallModel.isLurking && this.numSpeakers == stageCallModel.numSpeakers;
    }

    public final List<StageCallItem.AudienceItem> getAudience() {
        return this.audience;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<StageMediaParticipant> getMediaParticipants() {
        return this.mediaParticipants;
    }

    /* renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
    public final int m42getMyStageRoles1LxfuJo() {
        return this.myStageRoles;
    }

    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    public final List<StageCallItem.SpeakerItem> getSpeakerItems() {
        return this.speakerItems;
    }

    public final List<StoreVoiceParticipants.VoiceUser> getSpeakingVoiceUsers() {
        return this.speakingVoiceUsers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.myStageRoles * 31;
        List<StageCallItem.SpeakerItem> list = this.speakerItems;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<StageMediaParticipant> list2 = this.mediaParticipants;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<StageCallItem.AudienceItem> list3 = this.audience;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<StoreVoiceParticipants.VoiceUser> list4 = this.speakingVoiceUsers;
        int iHashCode4 = (((iHashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31) + this.requestingToSpeakCount) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode5 = (((iHashCode4 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31) + this.numBlockedUsers) * 31;
        Guild guild = this.guild;
        int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isLurking;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return ((iHashCode6 + i2) * 31) + this.numSpeakers;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public String toString() {
        StringBuilder sbU = a.U("StageCallModel(myStageRoles=");
        sbU.append(StageRoles.m34toStringimpl(this.myStageRoles));
        sbU.append(", speakerItems=");
        sbU.append(this.speakerItems);
        sbU.append(", mediaParticipants=");
        sbU.append(this.mediaParticipants);
        sbU.append(", audience=");
        sbU.append(this.audience);
        sbU.append(", speakingVoiceUsers=");
        sbU.append(this.speakingVoiceUsers);
        sbU.append(", requestingToSpeakCount=");
        sbU.append(this.requestingToSpeakCount);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", numBlockedUsers=");
        sbU.append(this.numBlockedUsers);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isLurking=");
        sbU.append(this.isLurking);
        sbU.append(", numSpeakers=");
        return a.B(sbU, this.numSpeakers, ")");
    }

    public /* synthetic */ StageCallModel(int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, list2, list3, list4, i2, stageInstance, i3, guild, z2, i4);
    }
}
