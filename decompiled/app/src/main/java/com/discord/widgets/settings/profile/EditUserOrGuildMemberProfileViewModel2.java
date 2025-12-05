package com.discord.widgets.settings.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.api.user.PatchUserBody;
import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel, reason: use source file name */
/* loaded from: classes2.dex */
public final class EditUserOrGuildMemberProfileViewModel2 extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> bioParser;
    private final PublishSubject<Event> eventSubject;
    private final Long guildId;
    private final RestAPI restAPI;
    private final Set<Integer> revealedBioIndices;
    private final StoreGuilds storeGuilds;
    private final StoreUserProfile storeUserProfile;

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$1 */
    public static final class C99531 extends Lambda implements Function1<MeUser, Unit> {
        public C99531() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            StoreUserProfile.fetchProfile$default(EditUserOrGuildMemberProfileViewModel2.access$getStoreUserProfile$p(EditUserOrGuildMemberProfileViewModel2.this), meUser.getId(), EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this), false, null, 12, null);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$2 */
    public static final class C99542 extends Lambda implements Function1<StoreState, Unit> {
        public C99542() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2 = EditUserOrGuildMemberProfileViewModel2.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            EditUserOrGuildMemberProfileViewModel2.access$handleStoreState(editUserOrGuildMemberProfileViewModel2, storeState);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(Long guildId, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserProfile storeUserProfile) {
            Observable<StoreState> observableM11099Y = Observable.m11076j(StoreUser.observeMe$default(storeUser, false, 1, null), storeGuilds.observeGuild(guildId != null ? guildId.longValue() : -1L), EditUserOrGuildMemberProfileViewModel3.INSTANCE).m11099Y(new EditUserOrGuildMemberProfileViewModel4(storeUserProfile, storeGuilds, guildId));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "Observable.combineLatest…      )\n        }\n      }");
            return observableM11099Y;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, Long l, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserProfile storeUserProfile, int i, Object obj) {
            if ((i & 2) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            if ((i & 4) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            if ((i & 8) != 0) {
                storeUserProfile = StoreStream.INSTANCE.getUserProfile();
            }
            return companion.observeStoreState(l, storeUser, storeGuilds, storeUserProfile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Event */
    public static abstract class Event {

        /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
        /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted */
        public static final class UserUpdateRequestCompleted extends Event {
            public static final UserUpdateRequestCompleted INSTANCE = new UserUpdateRequestCompleted();

            private UserUpdateRequestCompleted() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$StoreState */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final GuildMember meMember;
        private final MeUser user;
        private final UserProfile userProfile;

        public StoreState(MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            this.user = meUser;
            this.guild = guild;
            this.userProfile = userProfile;
            this.meMember = guildMember;
            this.guildChannelsInfo = guildChannelsInfo;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.user;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                userProfile = storeState.userProfile;
            }
            UserProfile userProfile2 = userProfile;
            if ((i & 8) != 0) {
                guildMember = storeState.meMember;
            }
            GuildMember guildMember2 = guildMember;
            if ((i & 16) != 0) {
                guildChannelsInfo = storeState.guildChannelsInfo;
            }
            return storeState.copy(meUser, guild2, userProfile2, guildMember2, guildChannelsInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildMember getMeMember() {
            return this.meMember;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreState copy(MeUser user, Guild guild, UserProfile userProfile, GuildMember meMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            return new StoreState(user, guild, userProfile, meMember, guildChannelsInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile) && Intrinsics3.areEqual(this.meMember, storeState.meMember) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final GuildMember getMeMember() {
            return this.meMember;
        }

        public final MeUser getUser() {
            return this.user;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public int hashCode() {
            MeUser meUser = this.user;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            UserProfile userProfile = this.userProfile;
            int iHashCode3 = (iHashCode2 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
            GuildMember guildMember = this.meMember;
            int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            return iHashCode4 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(user=");
            sbM833U.append(this.user);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", userProfile=");
            sbM833U.append(this.userProfile);
            sbM833U.append(", meMember=");
            sbM833U.append(this.meMember);
            sbM833U.append(", guildChannelsInfo=");
            sbM833U.append(this.guildChannelsInfo);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$ViewState */
    public static abstract class ViewState {

        /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
        /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$ViewState$Loaded */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Node<MessageRenderContext>> bioAst;
            private final boolean canEditNickname;
            private final boolean canHaveAnimatedAvatars;
            private final NullSerializable<String> currentAvatar;
            private final NullSerializable<String> currentBannerColorHex;
            private final NullSerializable<String> currentBannerImage;
            private final String currentBio;
            private final String currentNickname;
            private final Guild guild;
            private final boolean hasAvatarForDisplay;
            private final boolean hasBannerImageForDisplay;
            private final boolean hasMemberAvatarForDisplay;
            private final boolean hasMemberBannerForDisplay;
            private final boolean hasUserAvatarForDisplay;
            private final boolean hasUserBannerForDisplay;
            private final boolean isBioChanged;
            private final boolean isDirty;
            private final boolean isEditingBio;
            private final GuildMember meMember;
            private final String nonDefaultColorPreviewHex;
            private final boolean showBioEditor;
            private final boolean showSaveFab;
            private final MeUser user;
            private final UserProfile userProfile;

            public /* synthetic */ Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(meUser, guild, guildMember, userProfile, (i & 16) != 0 ? null : nullSerializable, (i & 32) != 0 ? null : nullSerializable2, (i & 64) != 0 ? null : nullSerializable3, (i & 128) != 0 ? null : str, str2, list, z2, z3);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.user : meUser, (i & 2) != 0 ? loaded.guild : guild, (i & 4) != 0 ? loaded.meMember : guildMember, (i & 8) != 0 ? loaded.userProfile : userProfile, (i & 16) != 0 ? loaded.currentAvatar : nullSerializable, (i & 32) != 0 ? loaded.currentBannerImage : nullSerializable2, (i & 64) != 0 ? loaded.currentBannerColorHex : nullSerializable3, (i & 128) != 0 ? loaded.currentNickname : str, (i & 256) != 0 ? loaded.currentBio : str2, (i & 512) != 0 ? loaded.bioAst : list, (i & 1024) != 0 ? loaded.isEditingBio : z2, (i & 2048) != 0 ? loaded.canEditNickname : z3);
            }

            /* renamed from: component1, reason: from getter */
            public final MeUser getUser() {
                return this.user;
            }

            public final List<Node<MessageRenderContext>> component10() {
                return this.bioAst;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getIsEditingBio() {
                return this.isEditingBio;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getCanEditNickname() {
                return this.canEditNickname;
            }

            /* renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getMeMember() {
                return this.meMember;
            }

            /* renamed from: component4, reason: from getter */
            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            public final NullSerializable<String> component5() {
                return this.currentAvatar;
            }

            public final NullSerializable<String> component6() {
                return this.currentBannerImage;
            }

            public final NullSerializable<String> component7() {
                return this.currentBannerColorHex;
            }

            /* renamed from: component8, reason: from getter */
            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            /* renamed from: component9, reason: from getter */
            public final String getCurrentBio() {
                return this.currentBio;
            }

            public final Loaded copy(MeUser user, Guild guild, GuildMember meMember, UserProfile userProfile, NullSerializable<String> currentAvatar, NullSerializable<String> currentBannerImage, NullSerializable<String> currentBannerColorHex, String currentNickname, String currentBio, List<Node<MessageRenderContext>> bioAst, boolean isEditingBio, boolean canEditNickname) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                return new Loaded(user, guild, meMember, userProfile, currentAvatar, currentBannerImage, currentBannerColorHex, currentNickname, currentBio, bioAst, isEditingBio, canEditNickname);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.user, loaded.user) && Intrinsics3.areEqual(this.guild, loaded.guild) && Intrinsics3.areEqual(this.meMember, loaded.meMember) && Intrinsics3.areEqual(this.userProfile, loaded.userProfile) && Intrinsics3.areEqual(this.currentAvatar, loaded.currentAvatar) && Intrinsics3.areEqual(this.currentBannerImage, loaded.currentBannerImage) && Intrinsics3.areEqual(this.currentBannerColorHex, loaded.currentBannerColorHex) && Intrinsics3.areEqual(this.currentNickname, loaded.currentNickname) && Intrinsics3.areEqual(this.currentBio, loaded.currentBio) && Intrinsics3.areEqual(this.bioAst, loaded.bioAst) && this.isEditingBio == loaded.isEditingBio && this.canEditNickname == loaded.canEditNickname;
            }

            public final List<Node<MessageRenderContext>> getBioAst() {
                return this.bioAst;
            }

            public final boolean getCanEditNickname() {
                return this.canEditNickname;
            }

            public final boolean getCanHaveAnimatedAvatars() {
                return this.canHaveAnimatedAvatars;
            }

            public final NullSerializable<String> getCurrentAvatar() {
                return this.currentAvatar;
            }

            public final NullSerializable<String> getCurrentBannerColorHex() {
                return this.currentBannerColorHex;
            }

            public final NullSerializable<String> getCurrentBannerImage() {
                return this.currentBannerImage;
            }

            public final String getCurrentBio() {
                return this.currentBio;
            }

            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getHasAvatarForDisplay() {
                return this.hasAvatarForDisplay;
            }

            public final boolean getHasBannerImageForDisplay() {
                return this.hasBannerImageForDisplay;
            }

            public final GuildMember getMeMember() {
                return this.meMember;
            }

            public final String getNonDefaultColorPreviewHex() {
                return this.nonDefaultColorPreviewHex;
            }

            public final boolean getShowBioEditor() {
                return this.showBioEditor;
            }

            public final boolean getShowSaveFab() {
                return this.showSaveFab;
            }

            public final MeUser getUser() {
                return this.user;
            }

            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                MeUser meUser = this.user;
                int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
                Guild guild = this.guild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                GuildMember guildMember = this.meMember;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                UserProfile userProfile = this.userProfile;
                int iHashCode4 = (iHashCode3 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable = this.currentAvatar;
                int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable2 = this.currentBannerImage;
                int iHashCode6 = (iHashCode5 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable3 = this.currentBannerColorHex;
                int iHashCode7 = (iHashCode6 + (nullSerializable3 != null ? nullSerializable3.hashCode() : 0)) * 31;
                String str = this.currentNickname;
                int iHashCode8 = (iHashCode7 + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.currentBio;
                int iHashCode9 = (iHashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<Node<MessageRenderContext>> list = this.bioAst;
                int iHashCode10 = (iHashCode9 + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isEditingBio;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode10 + i) * 31;
                boolean z3 = this.canEditNickname;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            /* renamed from: isBioChanged, reason: from getter */
            public final boolean getIsBioChanged() {
                return this.isBioChanged;
            }

            /* renamed from: isDirty, reason: from getter */
            public final boolean getIsDirty() {
                return this.isDirty;
            }

            public final boolean isEditingBio() {
                return this.isEditingBio;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(user=");
                sbM833U.append(this.user);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", meMember=");
                sbM833U.append(this.meMember);
                sbM833U.append(", userProfile=");
                sbM833U.append(this.userProfile);
                sbM833U.append(", currentAvatar=");
                sbM833U.append(this.currentAvatar);
                sbM833U.append(", currentBannerImage=");
                sbM833U.append(this.currentBannerImage);
                sbM833U.append(", currentBannerColorHex=");
                sbM833U.append(this.currentBannerColorHex);
                sbM833U.append(", currentNickname=");
                sbM833U.append(this.currentNickname);
                sbM833U.append(", currentBio=");
                sbM833U.append(this.currentBio);
                sbM833U.append(", bioAst=");
                sbM833U.append(this.bioAst);
                sbM833U.append(", isEditingBio=");
                sbM833U.append(this.isEditingBio);
                sbM833U.append(", canEditNickname=");
                return outline.m827O(sbM833U, this.canEditNickname, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, NullSerializable<String> nullSerializable3, String str, String str2, List<Node<MessageRenderContext>> list, boolean z2, boolean z3) {
                boolean z4;
                boolean z5;
                String bio;
                super(null);
                Intrinsics3.checkNotNullParameter(meUser, "user");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                this.user = meUser;
                this.guild = guild;
                this.meMember = guildMember;
                this.userProfile = userProfile;
                this.currentAvatar = nullSerializable;
                this.currentBannerImage = nullSerializable2;
                this.currentBannerColorHex = nullSerializable3;
                this.currentNickname = str;
                this.currentBio = str2;
                this.bioAst = list;
                this.isEditingBio = z2;
                this.canEditNickname = z3;
                boolean z6 = false;
                if (nullSerializable != null || nullSerializable2 != null || nullSerializable3 != null) {
                    z4 = true;
                } else if (guildMember != null) {
                    bio = "";
                    if (!(!Intrinsics3.areEqual(str2, bio))) {
                        if (guildMember != null) {
                            if (!Intrinsics3.areEqual(guildMember.getNick() == null ? "" : r13, str == null ? "" : str)) {
                            }
                        }
                        z4 = false;
                    }
                } else {
                    bio = "";
                    if (!(!Intrinsics3.areEqual(str2, bio))) {
                    }
                }
                this.isDirty = z4;
                this.showSaveFab = z4 && !z2;
                this.isBioChanged = !Intrinsics3.areEqual(str2, meUser.getBio());
                if (z2) {
                    z5 = true;
                } else {
                    if (!(str2 == null || StringsJVM.isBlank(str2))) {
                        z5 = false;
                    }
                }
                this.showBioEditor = z5;
                this.nonDefaultColorPreviewHex = ((nullSerializable3 instanceof NullSerializable.C5566b) || (nullSerializable3 instanceof NullSerializable.C5565a)) ? nullSerializable3.mo8429a() : meUser.getBannerColor();
                boolean z7 = guildMember == null && meUser.getAvatar() != null;
                this.hasUserAvatarForDisplay = z7;
                boolean z8 = guildMember != null && guildMember.hasAvatar();
                this.hasMemberAvatarForDisplay = z8;
                this.hasAvatarForDisplay = !(nullSerializable instanceof NullSerializable.C5565a) && ((nullSerializable instanceof NullSerializable.C5566b) || z7 || z8);
                boolean z9 = guildMember == null && meUser.getBanner() != null;
                this.hasUserBannerForDisplay = z9;
                boolean z10 = guildMember != null && guildMember.hasBanner();
                this.hasMemberBannerForDisplay = z10;
                if (!(nullSerializable2 instanceof NullSerializable.C5565a) && ((nullSerializable2 instanceof NullSerializable.C5566b) || z9 || z10)) {
                    z6 = true;
                }
                this.hasBannerImageForDisplay = z6;
                this.canHaveAnimatedAvatars = PremiumUtils3.grantsAccessToCustomTagAndAnimatedAvatarFeatures(meUser.getPremiumTier());
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$observeHeaderViewState$1 */
    public static final class C99561<T, R> implements Func1<ViewState, UserProfileHeaderViewModel.ViewState> {
        public static final C99561 INSTANCE = new C99561();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ UserProfileHeaderViewModel.ViewState call(ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final UserProfileHeaderViewModel.ViewState call2(ViewState viewState) {
            String banner;
            GuildMember meMember;
            if (viewState == null) {
                return UserProfileHeaderViewModel.ViewState.Uninitialized.INSTANCE;
            }
            if (!(viewState instanceof ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewState;
            MeUser user = (loaded.getCurrentAvatar() == null || loaded.getMeMember() != null) ? loaded.getUser() : MeUser.copy$default(loaded.getUser(), 0L, null, loaded.getCurrentAvatar().mo8429a(), null, false, false, 0, null, null, false, false, null, 0, 0, null, null, null, null, 262139, null);
            UserProfile userProfile = loaded.getUserProfile();
            if (loaded.getCurrentBannerImage() != null) {
                banner = loaded.getCurrentBannerImage() instanceof NullSerializable.C5565a ? loaded.getMeMember() != null ? loaded.getUser().getBanner() : null : loaded.getCurrentBannerImage().mo8429a();
            } else {
                GuildMember meMember2 = loaded.getMeMember();
                if (meMember2 == null || (banner = meMember2.getBannerHash()) == null) {
                    banner = loaded.getUser().getBanner();
                }
            }
            String str = banner;
            NullSerializable<String> currentBannerColorHex = loaded.getCurrentBannerColorHex();
            String strMo8429a = ((currentBannerColorHex instanceof NullSerializable.C5566b) || (currentBannerColorHex instanceof NullSerializable.C5565a)) ? currentBannerColorHex.mo8429a() : loaded.getUser().getBannerColor();
            boolean zIsPremium = UserUtils.INSTANCE.isPremium(loaded.getUser());
            boolean zIsVerified = loaded.getUser().isVerified();
            if (loaded.getMeMember() != null) {
                GuildMember meMember3 = loaded.getMeMember();
                if (loaded.getCurrentAvatar() != null) {
                    meMember3 = GuildMember.copy$default(meMember3, 0, 0L, null, null, null, false, null, 0L, 0L, loaded.getCurrentAvatar().mo8429a(), null, null, null, 7679, null);
                }
                GuildMember guildMemberCopy$default = meMember3;
                if (loaded.getCurrentBannerImage() != null) {
                    guildMemberCopy$default = GuildMember.copy$default(guildMemberCopy$default, 0, 0L, null, null, null, false, null, 0L, 0L, null, loaded.getCurrentBannerImage().mo8429a(), null, null, 7167, null);
                }
                meMember = guildMemberCopy$default;
            } else {
                meMember = loaded.getMeMember();
            }
            return new UserProfileHeaderViewModel.ViewState.Loaded(user, str, strMo8429a, meMember, null, null, null, userProfile, zIsPremium, zIsVerified, false, false, true, false, false, false, 58480, null);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveGuildMemberChanges$1 */
    public static final class C99571 extends Lambda implements Function1<Error, Unit> {
        public C99571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveGuildMemberChanges$2 */
    public static final class C99582 extends Lambda implements Function1<com.discord.api.guildmember.GuildMember, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99582(ViewState.Loaded loaded) {
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
            Intrinsics3.checkNotNullParameter(guildMember, "apiMember");
            EditUserOrGuildMemberProfileViewModel2.access$getStoreGuilds$p(EditUserOrGuildMemberProfileViewModel2.this).handleGuildMember(com.discord.api.guildmember.GuildMember.m7915a(guildMember, EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this).longValue(), null, null, null, null, null, false, null, null, null, null, null, null, 8190), EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this).longValue(), true);
            EditUserOrGuildMemberProfileViewModel2.access$updateViewState(EditUserOrGuildMemberProfileViewModel2.this, ViewState.Loaded.copy$default(this.$viewState, null, null, GuildMember.Companion.from$default(GuildMember.INSTANCE, guildMember, EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this).longValue(), null, EditUserOrGuildMemberProfileViewModel2.access$getStoreGuilds$p(EditUserOrGuildMemberProfileViewModel2.this), 4, null), null, null, null, null, null, null, null, false, false, 3979, null));
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveUserChanges$1 */
    public static final class C99591 extends Lambda implements Function1<Error, Unit> {
        public C99591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveUserChanges$2 */
    public static final class C99602 extends Lambda implements Function1<User, Unit> {
        public final /* synthetic */ MeUser $meUser;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99602(MeUser meUser, ViewState.Loaded loaded) {
            super(1);
            this.$meUser = meUser;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "apiUser");
            EditUserOrGuildMemberProfileViewModel2.access$getStoreUserProfile$p(EditUserOrGuildMemberProfileViewModel2.this).updateUser(user);
            EditUserOrGuildMemberProfileViewModel2.access$updateViewState(EditUserOrGuildMemberProfileViewModel2.this, ViewState.Loaded.copy$default(this.$viewState, MeUser.INSTANCE.merge(this.$meUser, user), null, null, null, null, null, null, null, null, null, false, false, 3982, null));
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    public /* synthetic */ EditUserOrGuildMemberProfileViewModel2(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser parser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 4) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 32) != 0 ? DiscordParser.createParser$default(false, false, false, false, false, 28, null) : parser, (i & 64) != 0 ? Companion.observeStoreState$default(INSTANCE, l, null, null, null, 14, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.eventSubject;
    }

    public static final /* synthetic */ Long access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.guildId;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.storeGuilds;
    }

    public static final /* synthetic */ StoreUserProfile access$getStoreUserProfile$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.storeUserProfile;
    }

    public static final /* synthetic */ void access$handleStoreState(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2, StoreState storeState) {
        editUserOrGuildMemberProfileViewModel2.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2, ViewState viewState) {
        editUserOrGuildMemberProfileViewModel2.updateViewState(viewState);
    }

    private final List<Node<MessageRenderContext>> createAndProcessBioAstFromText(String bio) {
        List<Node<MessageRenderContext>> bio2 = parseBio(bio);
        createMessagePreprocessor().process(bio2);
        return bio2;
    }

    private final MessagePreprocessor createMessagePreprocessor() {
        return new MessagePreprocessor(-1L, this.revealedBioIndices, null, false, null, 28, null);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String bio;
        String str;
        MeUser user = storeState.getUser();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (bio = loaded.getCurrentBio()) == null) {
            GuildMember meMember = storeState.getMeMember();
            if (meMember != null) {
                bio = meMember.getBio();
                if (bio == null) {
                    bio = "";
                }
            } else {
                bio = null;
            }
        }
        if (bio == null) {
            bio = user.getBio();
        }
        String str2 = bio;
        List<Node<MessageRenderContext>> listCreateAndProcessBioAstFromText = str2 != null ? createAndProcessBioAstFromText(str2) : null;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        if (loaded2 == null || (nick = loaded2.getCurrentNickname()) == null) {
            GuildMember meMember2 = storeState.getMeMember();
            if (meMember2 != null) {
                String nick = meMember2.getNick();
                str = nick;
            } else {
                str = null;
            }
        } else {
            str = nick;
        }
        Guild guild = storeState.getGuild();
        UserProfile userProfile = storeState.getUserProfile();
        ViewState viewState3 = getViewState();
        ViewState.Loaded loaded3 = (ViewState.Loaded) (viewState3 instanceof ViewState.Loaded ? viewState3 : null);
        updateViewState(new ViewState.Loaded(user, guild, storeState.getMeMember(), userProfile, null, null, null, str, str2, listCreateAndProcessBioAstFromText, loaded3 != null ? loaded3.isEditingBio() : false, storeState.getGuildChannelsInfo().getCanChangeNickname(), 112, null));
    }

    private final List<Node<MessageRenderContext>> parseBio(String bio) {
        return Parser.parse$default(this.bioParser, bio, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    @MainThread
    private final void saveGuildMemberChanges(Context context) {
        Long l;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (l = this.guildId) == null) {
            return;
        }
        l.longValue();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateMeGuildMember(this.guildId.longValue(), new PatchGuildMemberBody(loaded.getCurrentNickname(), loaded.getCurrentAvatar(), loaded.getCurrentBannerImage(), loaded.getCurrentBio())), false, 1, null), this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, context, (Function1) null, new C99571(), (Function0) null, (Function0) null, new C99582(loaded), 52, (Object) null);
    }

    @MainThread
    private final void saveUserChanges(Context context) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            MeUser user = loaded.getUser();
            String currentBio = loaded.getCurrentBio();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.patchUser(new PatchUserBody(loaded.getCurrentAvatar(), loaded.getCurrentBannerImage(), loaded.getCurrentBannerColorHex(), loaded.getIsBioChanged() ? currentBio != null ? new NullSerializable.C5566b(currentBio) : new NullSerializable.C5565a(null, 1) : null)), false, 1, null), this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, context, (Function1) null, new C99591(), (Function0) null, (Function0) null, new C99602(user, loaded), 52, (Object) null);
        }
    }

    @MainThread
    public final void handleBioIndexClicked(SpoilerNode<?> spoilerNode) {
        String currentBio;
        Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (currentBio = loaded.getCurrentBio()) == null) {
            return;
        }
        this.revealedBioIndices.add(Integer.valueOf(spoilerNode.getId()));
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, null, createAndProcessBioAstFromText(currentBio), false, false, 3583, null));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<UserProfileHeaderViewModel.ViewState> observeHeaderViewState() {
        Observable<UserProfileHeaderViewModel.ViewState> observableM11112r = observeViewState().m11083G(C99561.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeViewState().map {… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @MainThread
    public final void saveChanges(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (this.guildId != null) {
            saveGuildMemberChanges(context);
        } else {
            saveUserChanges(context);
        }
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, dataUrl != null ? new NullSerializable.C5566b(dataUrl) : new NullSerializable.C5565a(null, 1), null, null, null, null, null, false, false, 4079, null));
        }
    }

    @MainThread
    public final void updateBannerColor(String colorHex) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, colorHex != null ? new NullSerializable.C5566b(colorHex) : new NullSerializable.C5565a(null, 1), null, null, null, false, false, 4031, null));
        }
    }

    @MainThread
    public final void updateBannerImage(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, dataUrl != null ? new NullSerializable.C5566b(dataUrl) : new NullSerializable.C5565a(null, 1), null, null, null, null, false, false, 4063, null));
        }
    }

    @MainThread
    public final void updateBio(String bio) {
        Intrinsics3.checkNotNullParameter(bio, "bio");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null && (!Intrinsics3.areEqual(bio, loaded.getCurrentBio()))) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, bio, createAndProcessBioAstFromText(bio), false, false, 3327, null));
        }
    }

    @MainThread
    public final void updateIsEditingBio(boolean isEditing) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, null, null, isEditing, false, 3071, null));
        }
    }

    @MainThread
    public final void updateNickname(String nick) {
        Intrinsics3.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, nick, null, null, false, false, 3967, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserOrGuildMemberProfileViewModel2(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(parser, "bioParser");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = l;
        this.storeUserProfile = storeUserProfile;
        this.storeGuilds = storeGuilds;
        this.restAPI = restAPI;
        this.bioParser = parser;
        this.eventSubject = PublishSubject.m11133k0();
        Observable observableM11100Z = ObservableExtensionsKt.computationLatest(storeUser.observeMe(false)).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "storeUser.observeMe(emit…Latest()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11100Z, this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C99531(), 62, (Object) null);
        Observable<StoreState> observableM11112r = observable.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C99542(), 62, (Object) null);
        this.revealedBioIndices = new LinkedHashSet();
    }
}
