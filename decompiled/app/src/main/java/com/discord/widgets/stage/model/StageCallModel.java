package com.discord.widgets.stage.model;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: StageCallModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class StageCallModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<StageCallItem.AudienceItem> audience;
    private final Guild guild;
    private final boolean isLurking;
    private final List<StageCallModel5> mediaParticipants;
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
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(Long.valueOf(((StoreVoiceParticipants.VoiceUser) obj2).getUser().getId()), obj2);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                Object key = entry.getKey();
                StageRoles stageRolesM11394getUserRolesuOBN1zc = stagesStore.m11394getUserRolesuOBN1zc(((Number) entry.getKey()).longValue(), channel.getId());
                linkedHashMap2.put(key, StageRoles.m11402boximpl(stageRolesM11394getUserRolesuOBN1zc != null ? stageRolesM11394getUserRolesuOBN1zc.m11412unboximpl() : StageRoles.INSTANCE.m11414getAUDIENCE1LxfuJo()));
            }
            Collection collectionValues2 = linkedHashMap2.values();
            if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
                i = 0;
            } else {
                Iterator it = collectionValues2.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    if (StageRoles.m11410isSpeakerimpl(((StageRoles) it.next()).m11412unboximpl()) && (i4 = i4 + 1) < 0) {
                        Collections2.throwCountOverflow();
                    }
                }
                i = i4;
            }
            if (arrayList.isEmpty()) {
                i2 = 0;
            } else {
                int i5 = 0;
                for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                    StageRoles stageRolesM11394getUserRolesuOBN1zc2 = stagesStore.m11394getUserRolesuOBN1zc(voiceUser.getUser().getId(), channel.getId());
                    if ((StageRoles.m11410isSpeakerimpl(stageRolesM11394getUserRolesuOBN1zc2 != null ? stageRolesM11394getUserRolesuOBN1zc2.m11412unboximpl() : StageRoles.INSTANCE.m11414getAUDIENCE1LxfuJo()) && ((voiceState = voiceUser.getVoiceState()) == null || !voiceState.getSelfVideo())) && (i5 = i5 + 1) < 0) {
                        Collections2.throwCountOverflow();
                    }
                }
                i2 = i5;
            }
            int iCoerceAtMost = _Ranges.coerceAtMost(i2, 3);
            int i6 = 0;
            int i7 = 0;
            for (StoreVoiceParticipants.VoiceUser voiceUser2 : arrayList) {
                VoiceState voiceState2 = voiceUser2.getVoiceState();
                if (voiceState2 != null) {
                    Intrinsics3.checkNotNullParameter(voiceState2, "$this$hasUnackedRequestToSpeak");
                    if (AnimatableValueParser.m592y0(voiceState2) == StageRequestToSpeakState.REQUESTED_TO_SPEAK) {
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
                if (stageRoles == null || !StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) {
                    arrayList4.add(new StageCallItem.AudienceItem(voiceUser2, channel, RoleUtils.getHighestHoistedRole(guildRoles, guildMembers.get(Long.valueOf(voiceUser2.getUser().getId()))), zContains));
                } else {
                    if (voiceUser2.getStreamContext() != null) {
                        StageCallItem.MediaType mediaType = StageCallItem.MediaType.STREAM;
                        StringBuilder sbM833U = outline.m833U("STREAM-");
                        sbM833U.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageCallModel5(sbM833U.toString(), voiceUser2, channel, false, zContains, mediaType));
                    }
                    VoiceState voiceState3 = voiceUser2.getVoiceState();
                    if (voiceState3 != null && voiceState3.getSelfVideo()) {
                        StageRoles stageRoles2 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        boolean z3 = stageRoles2 != null && StageRoles.m11409isModeratorimpl(stageRoles2.m11412unboximpl());
                        StageCallItem.MediaType mediaType2 = StageCallItem.MediaType.USER;
                        StringBuilder sbM833U2 = outline.m833U("USER-");
                        sbM833U2.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageCallModel5(sbM833U2.toString(), voiceUser2, channel, z3, zContains, mediaType2));
                    } else {
                        StageRoles stageRoles3 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        if (stageRoles3 == null || !StageRoles.m11409isModeratorimpl(stageRoles3.m11412unboximpl())) {
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
            StageRoles stageRolesM11392getMyRolesvisDeB4 = stagesStore.m11392getMyRolesvisDeB4(channel.getId());
            return new StageCallModel(stageRolesM11392getMyRolesvisDeB4 != null ? stageRolesM11392getMyRolesvisDeB4.m11412unboximpl() : StageRoles.INSTANCE.m11414getAUDIENCE1LxfuJo(), arrayList3, arrayList2, _Collections.sorted(arrayList4), _Sequences2.toList(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(arrayList3), StageCallModel2.INSTANCE), StageCallModel3.INSTANCE)), i6, stageInstance, i7, guild, isLurking, i, null);
        }

        public static /* synthetic */ StageCallModel create$default(Companion companion, Channel channel, Map map, Map map2, Guild guild, Map map3, Set set, StageInstance stageInstance, boolean z2, StoreStageChannels storeStageChannels, int i, Object obj) {
            return companion.create(channel, map, map2, guild, map3, set, stageInstance, z2, (i & 256) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels);
        }

        public final Observable<StageCallModel> observeStageCallModel(long channelId) {
            Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new StageCallModel4(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private StageCallModel(int i, List<StageCallItem.SpeakerItem> list, List<StageCallModel5> list2, List<StageCallItem.AudienceItem> list3, List<StoreVoiceParticipants.VoiceUser> list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4) {
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
    public static /* synthetic */ StageCallModel m11416copyYvLQhEs$default(StageCallModel stageCallModel, int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, int i5, Object obj) {
        return stageCallModel.m11418copyYvLQhEs((i5 & 1) != 0 ? stageCallModel.myStageRoles : i, (i5 & 2) != 0 ? stageCallModel.speakerItems : list, (i5 & 4) != 0 ? stageCallModel.mediaParticipants : list2, (i5 & 8) != 0 ? stageCallModel.audience : list3, (i5 & 16) != 0 ? stageCallModel.speakingVoiceUsers : list4, (i5 & 32) != 0 ? stageCallModel.requestingToSpeakCount : i2, (i5 & 64) != 0 ? stageCallModel.stageInstance : stageInstance, (i5 & 128) != 0 ? stageCallModel.numBlockedUsers : i3, (i5 & 256) != 0 ? stageCallModel.guild : guild, (i5 & 512) != 0 ? stageCallModel.isLurking : z2, (i5 & 1024) != 0 ? stageCallModel.numSpeakers : i4);
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

    public final List<StageCallModel5> component3() {
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
    public final StageCallModel m11418copyYvLQhEs(int myStageRoles, List<StageCallItem.SpeakerItem> speakerItems, List<StageCallModel5> mediaParticipants, List<StageCallItem.AudienceItem> audience, List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers, int requestingToSpeakCount, StageInstance stageInstance, int numBlockedUsers, Guild guild, boolean isLurking, int numSpeakers) {
        Intrinsics3.checkNotNullParameter(speakerItems, "speakerItems");
        Intrinsics3.checkNotNullParameter(mediaParticipants, "mediaParticipants");
        Intrinsics3.checkNotNullParameter(audience, "audience");
        Intrinsics3.checkNotNullParameter(speakingVoiceUsers, "speakingVoiceUsers");
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
        return this.myStageRoles == stageCallModel.myStageRoles && Intrinsics3.areEqual(this.speakerItems, stageCallModel.speakerItems) && Intrinsics3.areEqual(this.mediaParticipants, stageCallModel.mediaParticipants) && Intrinsics3.areEqual(this.audience, stageCallModel.audience) && Intrinsics3.areEqual(this.speakingVoiceUsers, stageCallModel.speakingVoiceUsers) && this.requestingToSpeakCount == stageCallModel.requestingToSpeakCount && Intrinsics3.areEqual(this.stageInstance, stageCallModel.stageInstance) && this.numBlockedUsers == stageCallModel.numBlockedUsers && Intrinsics3.areEqual(this.guild, stageCallModel.guild) && this.isLurking == stageCallModel.isLurking && this.numSpeakers == stageCallModel.numSpeakers;
    }

    public final List<StageCallItem.AudienceItem> getAudience() {
        return this.audience;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<StageCallModel5> getMediaParticipants() {
        return this.mediaParticipants;
    }

    /* renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
    public final int m11419getMyStageRoles1LxfuJo() {
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
        List<StageCallModel5> list2 = this.mediaParticipants;
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
        StringBuilder sbM833U = outline.m833U("StageCallModel(myStageRoles=");
        sbM833U.append(StageRoles.m11411toStringimpl(this.myStageRoles));
        sbM833U.append(", speakerItems=");
        sbM833U.append(this.speakerItems);
        sbM833U.append(", mediaParticipants=");
        sbM833U.append(this.mediaParticipants);
        sbM833U.append(", audience=");
        sbM833U.append(this.audience);
        sbM833U.append(", speakingVoiceUsers=");
        sbM833U.append(this.speakingVoiceUsers);
        sbM833U.append(", requestingToSpeakCount=");
        sbM833U.append(this.requestingToSpeakCount);
        sbM833U.append(", stageInstance=");
        sbM833U.append(this.stageInstance);
        sbM833U.append(", numBlockedUsers=");
        sbM833U.append(this.numBlockedUsers);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", isLurking=");
        sbM833U.append(this.isLurking);
        sbM833U.append(", numSpeakers=");
        return outline.m814B(sbM833U, this.numSpeakers, ")");
    }

    public /* synthetic */ StageCallModel(int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, list2, list3, list4, i2, stageInstance, i3, guild, z2, i4);
    }
}
