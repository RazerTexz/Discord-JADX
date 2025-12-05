package com.discord.widgets.guilds.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final String sourceSection;
    private boolean trackedModalOpen;
    private boolean trackedUpsell;

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$1 */
    public static final class C87731 extends Lambda implements Function1<StoreState, Unit> {
        public C87731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChangeGuildIdentityViewModel.access$handleStoreState(WidgetChangeGuildIdentityViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds storeGuilds, StoreUser storeUser) {
            Observable<StoreState> observableM11073h = Observable.m11073h(GuildChannelsInfo.INSTANCE.get(guildId), storeGuilds.observeGuild(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null).m11099Y(new WidgetChangeGuildIdentityViewModel2(guildId)), WidgetChangeGuildIdentityViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…uildChannelsInfo)\n      }");
            return observableM11073h;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            if ((i & 4) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(j, storeGuilds, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        public static final /* data */ class MemberUpdateFailed extends Event {
            private final String errorMessage;

            public MemberUpdateFailed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public static /* synthetic */ MemberUpdateFailed copy$default(MemberUpdateFailed memberUpdateFailed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = memberUpdateFailed.errorMessage;
                }
                return memberUpdateFailed.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public final MemberUpdateFailed copy(String errorMessage) {
                return new MemberUpdateFailed(errorMessage);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof MemberUpdateFailed) && Intrinsics3.areEqual(this.errorMessage, ((MemberUpdateFailed) other).errorMessage);
                }
                return true;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public int hashCode() {
                String str = this.errorMessage;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m822J(outline.m833U("MemberUpdateFailed(errorMessage="), this.errorMessage, ")");
            }
        }

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        public static final class MemberUpdateSucceeded extends Event {
            public static final MemberUpdateSucceeded INSTANCE = new MemberUpdateSucceeded();

            private MemberUpdateSucceeded() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final MeUser meUser;
        private final GuildMember member;

        public StoreState(Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            this.guild = guild;
            this.meUser = meUser;
            this.member = guildMember;
            this.guildChannelsInfo = guildChannelsInfo;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                meUser = storeState.meUser;
            }
            if ((i & 4) != 0) {
                guildMember = storeState.member;
            }
            if ((i & 8) != 0) {
                guildChannelsInfo = storeState.guildChannelsInfo;
            }
            return storeState.copy(guild, meUser, guildMember, guildChannelsInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildMember getMember() {
            return this.member;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreState copy(Guild guild, MeUser meUser, GuildMember member, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            return new StoreState(guild, meUser, member, guildChannelsInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.member, storeState.member) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final GuildMember getMember() {
            return this.member;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            MeUser meUser = this.meUser;
            int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
            GuildMember guildMember = this.member;
            int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            return iHashCode3 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", member=");
            sbM833U.append(this.member);
            sbM833U.append(", guildChannelsInfo=");
            sbM833U.append(this.guildChannelsInfo);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canChangeNickname;
            private final NullSerializable<String> currentAvatar;
            private final String currentNickname;
            private final boolean dimmed;
            private final String displayedAvatarURL;
            private final boolean displayingGuildAvatar;
            private final Guild guild;
            private final boolean isDirty;
            private final MeUser meUser;
            private final GuildMember member;
            private final boolean shouldUpsell;
            private final boolean showSaveFab;

            public /* synthetic */ Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(guild, meUser, guildMember, z2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : nullSerializable, (i & 64) != 0 ? false : z3);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = loaded.guild;
                }
                if ((i & 2) != 0) {
                    meUser = loaded.meUser;
                }
                MeUser meUser2 = meUser;
                if ((i & 4) != 0) {
                    guildMember = loaded.member;
                }
                GuildMember guildMember2 = guildMember;
                if ((i & 8) != 0) {
                    z2 = loaded.canChangeNickname;
                }
                boolean z4 = z2;
                if ((i & 16) != 0) {
                    str = loaded.currentNickname;
                }
                String str2 = str;
                if ((i & 32) != 0) {
                    nullSerializable = loaded.currentAvatar;
                }
                NullSerializable nullSerializable2 = nullSerializable;
                if ((i & 64) != 0) {
                    z3 = loaded.dimmed;
                }
                return loaded.copy(guild, meUser2, guildMember2, z4, str2, nullSerializable2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getMember() {
                return this.member;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getCanChangeNickname() {
                return this.canChangeNickname;
            }

            /* renamed from: component5, reason: from getter */
            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final NullSerializable<String> component6() {
                return this.currentAvatar;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getDimmed() {
                return this.dimmed;
            }

            public final Loaded copy(Guild guild, MeUser meUser, GuildMember member, boolean canChangeNickname, String currentNickname, NullSerializable<String> currentAvatar, boolean dimmed) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(member, "member");
                return new Loaded(guild, meUser, member, canChangeNickname, currentNickname, currentAvatar, dimmed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guild, loaded.guild) && Intrinsics3.areEqual(this.meUser, loaded.meUser) && Intrinsics3.areEqual(this.member, loaded.member) && this.canChangeNickname == loaded.canChangeNickname && Intrinsics3.areEqual(this.currentNickname, loaded.currentNickname) && Intrinsics3.areEqual(this.currentAvatar, loaded.currentAvatar) && this.dimmed == loaded.dimmed;
            }

            public final boolean getCanChangeNickname() {
                return this.canChangeNickname;
            }

            public final NullSerializable<String> getCurrentAvatar() {
                return this.currentAvatar;
            }

            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final boolean getDimmed() {
                return this.dimmed;
            }

            public final String getDisplayedAvatarURL() {
                return this.displayedAvatarURL;
            }

            public final boolean getDisplayingGuildAvatar() {
                return this.displayingGuildAvatar;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final GuildMember getMember() {
                return this.member;
            }

            public final boolean getShouldUpsell() {
                return this.shouldUpsell;
            }

            public final boolean getShowSaveFab() {
                return this.showSaveFab;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                MeUser meUser = this.meUser;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                GuildMember guildMember = this.member;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                boolean z2 = this.canChangeNickname;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode3 + i) * 31;
                String str = this.currentNickname;
                int iHashCode4 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable = this.currentAvatar;
                int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
                boolean z3 = this.dimmed;
                return iHashCode5 + (z3 ? 1 : z3 ? 1 : 0);
            }

            /* renamed from: isDirty, reason: from getter */
            public final boolean getIsDirty() {
                return this.isDirty;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", meUser=");
                sbM833U.append(this.meUser);
                sbM833U.append(", member=");
                sbM833U.append(this.member);
                sbM833U.append(", canChangeNickname=");
                sbM833U.append(this.canChangeNickname);
                sbM833U.append(", currentNickname=");
                sbM833U.append(this.currentNickname);
                sbM833U.append(", currentAvatar=");
                sbM833U.append(this.currentAvatar);
                sbM833U.append(", dimmed=");
                return outline.m827O(sbM833U, this.dimmed, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable<String> nullSerializable, boolean z3) {
                String forGuildMember$default;
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(guildMember, "member");
                this.guild = guild;
                this.meUser = meUser;
                this.member = guildMember;
                this.canChangeNickname = z2;
                this.currentNickname = str;
                this.currentAvatar = nullSerializable;
                this.dimmed = z3;
                String nick = guildMember.getNick();
                boolean z4 = (Intrinsics3.areEqual(nick == null ? "" : nick, str) ^ true) || nullSerializable != null;
                this.isDirty = z4;
                this.showSaveFab = z4;
                if (!(nullSerializable instanceof NullSerializable)) {
                    forGuildMember$default = guildMember.hasAvatar() ? IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, true, 2, null) : IconUtils.getForUser$default(meUser, true, null, 4, null);
                } else if (nullSerializable instanceof NullSerializable.C5566b) {
                    forGuildMember$default = (String) ((NullSerializable.C5566b) nullSerializable).mo8429a();
                } else {
                    if (!(nullSerializable instanceof NullSerializable.C5565a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    forGuildMember$default = IconUtils.getForUser$default(meUser, true, null, 4, null);
                }
                this.displayedAvatarURL = forGuildMember$default;
                this.displayingGuildAvatar = nullSerializable instanceof NullSerializable ? nullSerializable instanceof NullSerializable.C5566b : guildMember.hasAvatar();
                this.shouldUpsell = !UserUtils.INSTANCE.isPremiumTier2(meUser);
            }
        }

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$saveMemberChanges$1 */
    public static final class C87751 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87751(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x005f  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(Error error) {
            String message;
            Intrinsics3.checkNotNullParameter(error, "it");
            Intrinsics3.checkNotNullExpressionValue(error.getResponse(), "it.response");
            if (!r0.getMessages().values().isEmpty()) {
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                Intrinsics3.checkNotNullExpressionValue(_Collections.first(response.getMessages().values()), "it.response.messages.values.first()");
                if (!((Collection) r0).isEmpty()) {
                    Error.Response response2 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response2, "it.response");
                    Object objFirst = _Collections.first(response2.getMessages().values());
                    Intrinsics3.checkNotNullExpressionValue(objFirst, "it.response.messages.values.first()");
                    message = (String) _Collections.first((List) objFirst);
                } else {
                    Error.Response response3 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response3, "it.response");
                    message = response3.getMessage();
                }
            }
            WidgetChangeGuildIdentityViewModel.access$getEventSubject$p(WidgetChangeGuildIdentityViewModel.this).f27650k.onNext(new Event.MemberUpdateFailed(message));
            WidgetChangeGuildIdentityViewModel.access$updateViewState(WidgetChangeGuildIdentityViewModel.this, ViewState.Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$saveMemberChanges$2 */
    public static final class C87762 extends Lambda implements Function1<com.discord.api.guildmember.GuildMember, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87762(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guildmember.GuildMember guildMember) {
            invoke2(guildMember);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guildmember.GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(guildMember, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChangeGuildIdentityViewModel.access$getEventSubject$p(WidgetChangeGuildIdentityViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.MemberUpdateSucceeded.INSTANCE);
            WidgetChangeGuildIdentityViewModel.access$updateViewState(WidgetChangeGuildIdentityViewModel.this, ViewState.Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
        }
    }

    public /* synthetic */ WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel) {
        return widgetChangeGuildIdentityViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, StoreState storeState) {
        widgetChangeGuildIdentityViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, ViewState viewState) {
        widgetChangeGuildIdentityViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String nick;
        NullSerializable<String> currentAvatar;
        Guild guild = storeState.getGuild();
        GuildMember member = storeState.getMember();
        MeUser meUser = storeState.getMeUser();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        if (guild == null || member == null) {
            return;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (nick = loaded.getCurrentNickname()) == null) {
            nick = member.getNick();
        }
        String str = nick;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        updateViewState(new ViewState.Loaded(guild, meUser, member, guildChannelsInfo.getCanChangeNickname(), str, (loaded2 == null || (currentAvatar = loaded2.getCurrentAvatar()) == null) ? null : currentAvatar, false, 64, null));
    }

    @MainThread
    public final void clearStatus() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, "", null, false, 111, null));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getSourceSection() {
        return this.sourceSection;
    }

    public final boolean getTrackedModalOpen() {
        return this.trackedModalOpen;
    }

    public final boolean getTrackedUpsell() {
        return this.trackedUpsell;
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    @MainThread
    public final void saveMemberChanges(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, null, null, true, 63, null));
            RestAPI restAPI = this.restAPI;
            long id2 = loaded.getGuild().getId();
            String currentNickname = loaded.getCurrentNickname();
            String nick = loaded.getMember().getNick();
            if (nick == null) {
                nick = "";
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.updateMeGuildMember(id2, new PatchGuildMemberBody(Intrinsics3.areEqual(currentNickname, nick) ^ true ? loaded.getCurrentNickname() : null, loaded.getCurrentAvatar(), null, null, 12)), false, 1, null), this, null, 2, null), WidgetChangeGuildIdentityViewModel.class, context, (Function1) null, new C87751(loaded), (Function0) null, (Function0) null, new C87762(loaded), 52, (Object) null);
        }
    }

    public final void setTrackedModalOpen(boolean z2) {
        this.trackedModalOpen = z2;
    }

    public final void setTrackedUpsell(boolean z2) {
        this.trackedUpsell = z2;
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, null, dataUrl != null ? new NullSerializable.C5566b(dataUrl) : new NullSerializable.C5565a(null, 1), false, 95, null));
        }
    }

    @MainThread
    public final void updateNickname(String nickname) {
        Intrinsics3.checkNotNullParameter(nickname, "nickname");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !(!Intrinsics3.areEqual(nickname, loaded.getCurrentNickname()))) {
            return;
        }
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, nickname, null, false, 111, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "sourceSection");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.guildId = j;
        this.sourceSection = str;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Companion.observeStoreState$default(INSTANCE, j, null, null, 6, null)), this, null, 2, null), WidgetChangeGuildIdentityViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87731(), 62, (Object) null);
    }
}
