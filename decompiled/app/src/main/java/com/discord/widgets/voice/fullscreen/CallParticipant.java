package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.api.application.ApplicationAsset;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.views.calls.VideoCallParticipantView;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CallParticipant.kt */
/* loaded from: classes.dex */
public abstract class CallParticipant {

    /* compiled from: CallParticipant.kt */
    public static final /* data */ class EmbeddedActivityParticipant extends CallParticipant {
        private final Application application;
        private final ApplicationAsset backgroundAsset;
        private final EmbeddedActivity embeddedActivity;
        private final String id;
        private final List<UserGuildMember> participantsInActivity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmbeddedActivityParticipant(EmbeddedActivity embeddedActivity, List<UserGuildMember> list, Application application, ApplicationAsset applicationAsset) {
            super(null);
            m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
            m.checkNotNullParameter(list, "participantsInActivity");
            m.checkNotNullParameter(application, "application");
            this.embeddedActivity = embeddedActivity;
            this.participantsInActivity = list;
            this.application = application;
            this.backgroundAsset = applicationAsset;
            this.id = String.valueOf(application.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmbeddedActivityParticipant copy$default(EmbeddedActivityParticipant embeddedActivityParticipant, EmbeddedActivity embeddedActivity, List list, Application application, ApplicationAsset applicationAsset, int i, Object obj) {
            if ((i & 1) != 0) {
                embeddedActivity = embeddedActivityParticipant.embeddedActivity;
            }
            if ((i & 2) != 0) {
                list = embeddedActivityParticipant.participantsInActivity;
            }
            if ((i & 4) != 0) {
                application = embeddedActivityParticipant.application;
            }
            if ((i & 8) != 0) {
                applicationAsset = embeddedActivityParticipant.backgroundAsset;
            }
            return embeddedActivityParticipant.copy(embeddedActivity, list, application, applicationAsset);
        }

        /* renamed from: component1, reason: from getter */
        public final EmbeddedActivity getEmbeddedActivity() {
            return this.embeddedActivity;
        }

        public final List<UserGuildMember> component2() {
            return this.participantsInActivity;
        }

        /* renamed from: component3, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        /* renamed from: component4, reason: from getter */
        public final ApplicationAsset getBackgroundAsset() {
            return this.backgroundAsset;
        }

        public final EmbeddedActivityParticipant copy(EmbeddedActivity embeddedActivity, List<UserGuildMember> participantsInActivity, Application application, ApplicationAsset backgroundAsset) {
            m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
            m.checkNotNullParameter(participantsInActivity, "participantsInActivity");
            m.checkNotNullParameter(application, "application");
            return new EmbeddedActivityParticipant(embeddedActivity, participantsInActivity, application, backgroundAsset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmbeddedActivityParticipant)) {
                return false;
            }
            EmbeddedActivityParticipant embeddedActivityParticipant = (EmbeddedActivityParticipant) other;
            return m.areEqual(this.embeddedActivity, embeddedActivityParticipant.embeddedActivity) && m.areEqual(this.participantsInActivity, embeddedActivityParticipant.participantsInActivity) && m.areEqual(this.application, embeddedActivityParticipant.application) && m.areEqual(this.backgroundAsset, embeddedActivityParticipant.backgroundAsset);
        }

        public final Application getApplication() {
            return this.application;
        }

        public final ApplicationAsset getBackgroundAsset() {
            return this.backgroundAsset;
        }

        public final EmbeddedActivity getEmbeddedActivity() {
            return this.embeddedActivity;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public String getId() {
            return this.id;
        }

        public final List<UserGuildMember> getParticipantsInActivity() {
            return this.participantsInActivity;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public boolean hasActiveVideo() {
            return false;
        }

        public int hashCode() {
            EmbeddedActivity embeddedActivity = this.embeddedActivity;
            int iHashCode = (embeddedActivity != null ? embeddedActivity.hashCode() : 0) * 31;
            List<UserGuildMember> list = this.participantsInActivity;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Application application = this.application;
            int iHashCode3 = (iHashCode2 + (application != null ? application.hashCode() : 0)) * 31;
            ApplicationAsset applicationAsset = this.backgroundAsset;
            return iHashCode3 + (applicationAsset != null ? applicationAsset.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("EmbeddedActivityParticipant(embeddedActivity=");
            sbU.append(this.embeddedActivity);
            sbU.append(", participantsInActivity=");
            sbU.append(this.participantsInActivity);
            sbU.append(", application=");
            sbU.append(this.application);
            sbU.append(", backgroundAsset=");
            sbU.append(this.backgroundAsset);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: CallParticipant.kt */
    public static final /* data */ class UserOrStreamParticipant extends CallParticipant {
        private final String id;
        private final VideoCallParticipantView.ParticipantData participantData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserOrStreamParticipant(VideoCallParticipantView.ParticipantData participantData) {
            super(null);
            m.checkNotNullParameter(participantData, "participantData");
            this.participantData = participantData;
            this.id = participantData.id;
        }

        public static /* synthetic */ UserOrStreamParticipant copy$default(UserOrStreamParticipant userOrStreamParticipant, VideoCallParticipantView.ParticipantData participantData, int i, Object obj) {
            if ((i & 1) != 0) {
                participantData = userOrStreamParticipant.participantData;
            }
            return userOrStreamParticipant.copy(participantData);
        }

        /* renamed from: component1, reason: from getter */
        public final VideoCallParticipantView.ParticipantData getParticipantData() {
            return this.participantData;
        }

        public final UserOrStreamParticipant copy(VideoCallParticipantView.ParticipantData participantData) {
            m.checkNotNullParameter(participantData, "participantData");
            return new UserOrStreamParticipant(participantData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserOrStreamParticipant) && m.areEqual(this.participantData, ((UserOrStreamParticipant) other).participantData);
            }
            return true;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public String getId() {
            return this.id;
        }

        public final VideoCallParticipantView.ParticipantData getParticipantData() {
            return this.participantData;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public boolean hasActiveVideo() {
            VideoCallParticipantView.ParticipantData participantData = this.participantData;
            VoiceState voiceState = participantData.voiceParticipant.getVoiceState();
            return (voiceState != null && voiceState.getSelfVideo()) || participantData.applicationStreamState != null;
        }

        public int hashCode() {
            VideoCallParticipantView.ParticipantData participantData = this.participantData;
            if (participantData != null) {
                return participantData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("UserOrStreamParticipant(participantData=");
            sbU.append(this.participantData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private CallParticipant() {
    }

    public abstract String getId();

    public abstract boolean hasActiveVideo();

    public /* synthetic */ CallParticipant(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
