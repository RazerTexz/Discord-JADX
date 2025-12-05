package com.discord.widgets.guilds.profile;

import android.content.Context;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetGuildProfileSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private boolean isEmojiSectionExpanded;
    private final RestAPI restAPI;
    private final StoreLurking storeLurking;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreUserSettings storeUserSettings;
    private final boolean viewingGuild;

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$1 */
    public static final class C88031 extends Lambda implements Function1<StoreState, Unit> {
        public C88031() {
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
            WidgetGuildProfileSheetViewModel.access$handleStoreState(WidgetGuildProfileSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class Actions {
        private final boolean canChangeNickname;
        private final boolean canLeaveGuild;
        private final boolean canManageChannels;
        private final boolean canManageEvents;
        private final boolean displayGuildIdentityRow;
        private final String guildAvatar;
        private final boolean hideMutedChannels;
        private final boolean isAllowDMChecked;
        private final boolean isDeveloper;
        private final boolean isUnread;
        private final String nick;
        private final String username;

        /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Actions(boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, String str3) {
            Intrinsics3.checkNotNullParameter(str3, "username");
            this.isUnread = z2;
            this.canManageChannels = z3;
            this.canManageEvents = z4;
            this.canChangeNickname = z5;
            this.nick = str;
            this.guildAvatar = str2;
            this.isAllowDMChecked = z6;
            this.hideMutedChannels = z7;
            this.canLeaveGuild = z8;
            this.isDeveloper = z9;
            this.username = str3;
            boolean z10 = false;
            if (str == null || str.length() == 0) {
                if (!(str2 == null || str2.length() == 0)) {
                }
            } else {
                z10 = true;
            }
            this.displayGuildIdentityRow = z10;
        }

        public static /* synthetic */ Actions copy$default(Actions actions, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, String str3, int i, Object obj) {
            return actions.copy((i & 1) != 0 ? actions.isUnread : z2, (i & 2) != 0 ? actions.canManageChannels : z3, (i & 4) != 0 ? actions.canManageEvents : z4, (i & 8) != 0 ? actions.canChangeNickname : z5, (i & 16) != 0 ? actions.nick : str, (i & 32) != 0 ? actions.guildAvatar : str2, (i & 64) != 0 ? actions.isAllowDMChecked : z6, (i & 128) != 0 ? actions.hideMutedChannels : z7, (i & 256) != 0 ? actions.canLeaveGuild : z8, (i & 512) != 0 ? actions.isDeveloper : z9, (i & 1024) != 0 ? actions.username : str3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        /* renamed from: component11, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanManageChannels() {
            return this.canManageChannels;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        /* renamed from: component5, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        /* renamed from: component6, reason: from getter */
        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsAllowDMChecked() {
            return this.isAllowDMChecked;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getHideMutedChannels() {
            return this.hideMutedChannels;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCanLeaveGuild() {
            return this.canLeaveGuild;
        }

        public final Actions copy(boolean isUnread, boolean canManageChannels, boolean canManageEvents, boolean canChangeNickname, String nick, String guildAvatar, boolean isAllowDMChecked, boolean hideMutedChannels, boolean canLeaveGuild, boolean isDeveloper, String username) {
            Intrinsics3.checkNotNullParameter(username, "username");
            return new Actions(isUnread, canManageChannels, canManageEvents, canChangeNickname, nick, guildAvatar, isAllowDMChecked, hideMutedChannels, canLeaveGuild, isDeveloper, username);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Actions)) {
                return false;
            }
            Actions actions = (Actions) other;
            return this.isUnread == actions.isUnread && this.canManageChannels == actions.canManageChannels && this.canManageEvents == actions.canManageEvents && this.canChangeNickname == actions.canChangeNickname && Intrinsics3.areEqual(this.nick, actions.nick) && Intrinsics3.areEqual(this.guildAvatar, actions.guildAvatar) && this.isAllowDMChecked == actions.isAllowDMChecked && this.hideMutedChannels == actions.hideMutedChannels && this.canLeaveGuild == actions.canLeaveGuild && this.isDeveloper == actions.isDeveloper && Intrinsics3.areEqual(this.username, actions.username);
        }

        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        public final boolean getCanLeaveGuild() {
            return this.canLeaveGuild;
        }

        public final boolean getCanManageChannels() {
            return this.canManageChannels;
        }

        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        public final boolean getDisplayGuildIdentityRow() {
            return this.displayGuildIdentityRow;
        }

        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        public final boolean getHideMutedChannels() {
            return this.hideMutedChannels;
        }

        public final String getNick() {
            return this.nick;
        }

        public final String getUsername() {
            return this.username;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isUnread;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.canManageChannels;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.canManageEvents;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.canChangeNickname;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            String str = this.nick;
            int iHashCode = (i7 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.guildAvatar;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            ?? r24 = this.isAllowDMChecked;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (iHashCode2 + i8) * 31;
            ?? r25 = this.hideMutedChannels;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            ?? r26 = this.canLeaveGuild;
            int i12 = r26;
            if (r26 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            boolean z3 = this.isDeveloper;
            int i14 = (i13 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            String str3 = this.username;
            return i14 + (str3 != null ? str3.hashCode() : 0);
        }

        public final boolean isAllowDMChecked() {
            return this.isAllowDMChecked;
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Actions(isUnread=");
            sbM833U.append(this.isUnread);
            sbM833U.append(", canManageChannels=");
            sbM833U.append(this.canManageChannels);
            sbM833U.append(", canManageEvents=");
            sbM833U.append(this.canManageEvents);
            sbM833U.append(", canChangeNickname=");
            sbM833U.append(this.canChangeNickname);
            sbM833U.append(", nick=");
            sbM833U.append(this.nick);
            sbM833U.append(", guildAvatar=");
            sbM833U.append(this.guildAvatar);
            sbM833U.append(", isAllowDMChecked=");
            sbM833U.append(this.isAllowDMChecked);
            sbM833U.append(", hideMutedChannels=");
            sbM833U.append(this.hideMutedChannels);
            sbM833U.append(", canLeaveGuild=");
            sbM833U.append(this.canLeaveGuild);
            sbM833U.append(", isDeveloper=");
            sbM833U.append(this.isDeveloper);
            sbM833U.append(", username=");
            return outline.m822J(sbM833U, this.username, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class Banner {
        private final long guildId;
        private final String hash;
        private final Type type;

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        public enum Type {
            BANNER,
            SPLASH
        }

        public Banner(long j, String str, Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.guildId = j;
            this.hash = str;
            this.type = type;
        }

        public static /* synthetic */ Banner copy$default(Banner banner, long j, String str, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                j = banner.guildId;
            }
            if ((i & 2) != 0) {
                str = banner.hash;
            }
            if ((i & 4) != 0) {
                type = banner.type;
            }
            return banner.copy(j, str, type);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getHash() {
            return this.hash;
        }

        /* renamed from: component3, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final Banner copy(long guildId, String hash, Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new Banner(guildId, hash, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Banner)) {
                return false;
            }
            Banner banner = (Banner) other;
            return this.guildId == banner.guildId && Intrinsics3.areEqual(this.hash, banner.hash) && Intrinsics3.areEqual(this.type, banner.type);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getHash() {
            return this.hash;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            String str = this.hash;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            Type type = this.type;
            return iHashCode + (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Banner(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", hash=");
            sbM833U.append(this.hash);
            sbM833U.append(", type=");
            sbM833U.append(this.type);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class BottomActions {
        private final boolean showJoinServer;
        private final boolean showUploadEmoji;
        private final boolean showViewServer;

        public BottomActions(boolean z2, boolean z3, boolean z4) {
            this.showUploadEmoji = z2;
            this.showJoinServer = z3;
            this.showViewServer = z4;
        }

        public static /* synthetic */ BottomActions copy$default(BottomActions bottomActions, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = bottomActions.showUploadEmoji;
            }
            if ((i & 2) != 0) {
                z3 = bottomActions.showJoinServer;
            }
            if ((i & 4) != 0) {
                z4 = bottomActions.showViewServer;
            }
            return bottomActions.copy(z2, z3, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowUploadEmoji() {
            return this.showUploadEmoji;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowJoinServer() {
            return this.showJoinServer;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowViewServer() {
            return this.showViewServer;
        }

        public final BottomActions copy(boolean showUploadEmoji, boolean showJoinServer, boolean showViewServer) {
            return new BottomActions(showUploadEmoji, showJoinServer, showViewServer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BottomActions)) {
                return false;
            }
            BottomActions bottomActions = (BottomActions) other;
            return this.showUploadEmoji == bottomActions.showUploadEmoji && this.showJoinServer == bottomActions.showJoinServer && this.showViewServer == bottomActions.showViewServer;
        }

        public final boolean getShowJoinServer() {
            return this.showJoinServer;
        }

        public final boolean getShowUploadEmoji() {
            return this.showUploadEmoji;
        }

        public final boolean getShowViewServer() {
            return this.showViewServer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.showUploadEmoji;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.showJoinServer;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.showViewServer;
            return i3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("BottomActions(showUploadEmoji=");
            sbM833U.append(this.showUploadEmoji);
            sbM833U.append(", showJoinServer=");
            sbM833U.append(this.showJoinServer);
            sbM833U.append(", showViewServer=");
            return outline.m827O(sbM833U, this.showViewServer, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableM11066c = Observable.m11066c(companion.getGuilds().observeGuild(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), companion.getReadStates().getIsUnread(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).m11099Y(new WidgetGuildProfileSheetViewModel2(guildId)), companion.getUserSettings().observeRestrictedGuildIds(), companion.getEmojis().getEmojiSet(new StoreEmoji.EmojiContext.GuildProfile(guildId), true, false).m11083G(new WidgetGuildProfileSheetViewModel3(guildId)), companion.getLurking().isLurkingObs(guildId), GuildChannelsInfo.INSTANCE.get(guildId), WidgetGuildProfileSheetViewModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11066c, "Observable.combineLatest…ead\n          )\n        }");
            return observableM11066c;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class EmojisData {
        private final List<Emoji> emojis;
        private final boolean isExpanded;
        private final boolean isPremium;

        /* JADX WARN: Multi-variable type inference failed */
        public EmojisData(boolean z2, boolean z3, List<? extends Emoji> list) {
            Intrinsics3.checkNotNullParameter(list, "emojis");
            this.isPremium = z2;
            this.isExpanded = z3;
            this.emojis = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmojisData copy$default(EmojisData emojisData, boolean z2, boolean z3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = emojisData.isPremium;
            }
            if ((i & 2) != 0) {
                z3 = emojisData.isExpanded;
            }
            if ((i & 4) != 0) {
                list = emojisData.emojis;
            }
            return emojisData.copy(z2, z3, list);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsPremium() {
            return this.isPremium;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsExpanded() {
            return this.isExpanded;
        }

        public final List<Emoji> component3() {
            return this.emojis;
        }

        public final EmojisData copy(boolean isPremium, boolean isExpanded, List<? extends Emoji> emojis) {
            Intrinsics3.checkNotNullParameter(emojis, "emojis");
            return new EmojisData(isPremium, isExpanded, emojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmojisData)) {
                return false;
            }
            EmojisData emojisData = (EmojisData) other;
            return this.isPremium == emojisData.isPremium && this.isExpanded == emojisData.isExpanded && Intrinsics3.areEqual(this.emojis, emojisData.emojis);
        }

        public final List<Emoji> getEmojis() {
            return this.emojis;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isPremium;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isExpanded;
            int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            List<Emoji> list = this.emojis;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public final boolean isPremium() {
            return this.isPremium;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("EmojisData(isPremium=");
            sbM833U.append(this.isPremium);
            sbM833U.append(", isExpanded=");
            sbM833U.append(this.isExpanded);
            sbM833U.append(", emojis=");
            return outline.m824L(sbM833U, this.emojis, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        public static final /* data */ class DismissAndShowToast extends Event {
            private final int stringRes;

            public DismissAndShowToast(@StringRes int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ DismissAndShowToast copy$default(DismissAndShowToast dismissAndShowToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = dismissAndShowToast.stringRes;
                }
                return dismissAndShowToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final DismissAndShowToast copy(@StringRes int stringRes) {
                return new DismissAndShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof DismissAndShowToast) && this.stringRes == ((DismissAndShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.m814B(outline.m833U("DismissAndShowToast(stringRes="), this.stringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final GuildMember computedMe;
        private final List<Emoji> emojis;
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final StoreGuildProfiles.GuildProfileData guildProfile;
        private final boolean isDeveloper;
        private final boolean isLurking;
        private final boolean isUnread;
        private final MeUser me;
        private final List<Long> restrictedGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, GuildChannelsInfo guildChannelsInfo, MeUser meUser, GuildMember guildMember, List<Long> list, boolean z2, List<? extends Emoji> list2, boolean z3, boolean z4) {
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(list, "restrictedGuildIds");
            Intrinsics3.checkNotNullParameter(list2, "emojis");
            this.guild = guild;
            this.guildProfile = guildProfileData;
            this.guildChannelsInfo = guildChannelsInfo;
            this.me = meUser;
            this.computedMe = guildMember;
            this.restrictedGuildIds = list;
            this.isDeveloper = z2;
            this.emojis = list2;
            this.isLurking = z3;
            this.isUnread = z4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, GuildChannelsInfo guildChannelsInfo, MeUser meUser, GuildMember guildMember, List list, boolean z2, List list2, boolean z3, boolean z4, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.guild : guild, (i & 2) != 0 ? storeState.guildProfile : guildProfileData, (i & 4) != 0 ? storeState.guildChannelsInfo : guildChannelsInfo, (i & 8) != 0 ? storeState.me : meUser, (i & 16) != 0 ? storeState.computedMe : guildMember, (i & 32) != 0 ? storeState.restrictedGuildIds : list, (i & 64) != 0 ? storeState.isDeveloper : z2, (i & 128) != 0 ? storeState.emojis : list2, (i & 256) != 0 ? storeState.isLurking : z3, (i & 512) != 0 ? storeState.isUnread : z4);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        /* renamed from: component4, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildMember getComputedMe() {
            return this.computedMe;
        }

        public final List<Long> component6() {
            return this.restrictedGuildIds;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final List<Emoji> component8() {
            return this.emojis;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsLurking() {
            return this.isLurking;
        }

        public final StoreState copy(Guild guild, StoreGuildProfiles.GuildProfileData guildProfile, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(restrictedGuildIds, "restrictedGuildIds");
            Intrinsics3.checkNotNullParameter(emojis, "emojis");
            return new StoreState(guild, guildProfile, guildChannelsInfo, me2, computedMe, restrictedGuildIds, isDeveloper, emojis, isLurking, isUnread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.guildProfile, storeState.guildProfile) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo) && Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.computedMe, storeState.computedMe) && Intrinsics3.areEqual(this.restrictedGuildIds, storeState.restrictedGuildIds) && this.isDeveloper == storeState.isDeveloper && Intrinsics3.areEqual(this.emojis, storeState.emojis) && this.isLurking == storeState.isLurking && this.isUnread == storeState.isUnread;
        }

        public final GuildMember getComputedMe() {
            return this.computedMe;
        }

        public final List<Emoji> getEmojis() {
            return this.emojis;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final List<Long> getRestrictedGuildIds() {
            return this.restrictedGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StoreGuildProfiles.GuildProfileData guildProfileData = this.guildProfile;
            int iHashCode2 = (iHashCode + (guildProfileData != null ? guildProfileData.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            int iHashCode3 = (iHashCode2 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            GuildMember guildMember = this.computedMe;
            int iHashCode5 = (iHashCode4 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            List<Long> list = this.restrictedGuildIds;
            int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isDeveloper;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode6 + i) * 31;
            List<Emoji> list2 = this.emojis;
            int iHashCode7 = (i2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z3 = this.isLurking;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode7 + i3) * 31;
            boolean z4 = this.isUnread;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isLurking() {
            return this.isLurking;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", guildProfile=");
            sbM833U.append(this.guildProfile);
            sbM833U.append(", guildChannelsInfo=");
            sbM833U.append(this.guildChannelsInfo);
            sbM833U.append(", me=");
            sbM833U.append(this.me);
            sbM833U.append(", computedMe=");
            sbM833U.append(this.computedMe);
            sbM833U.append(", restrictedGuildIds=");
            sbM833U.append(this.restrictedGuildIds);
            sbM833U.append(", isDeveloper=");
            sbM833U.append(this.isDeveloper);
            sbM833U.append(", emojis=");
            sbM833U.append(this.emojis);
            sbM833U.append(", isLurking=");
            sbM833U.append(this.isLurking);
            sbM833U.append(", isUnread=");
            return outline.m827O(sbM833U, this.isUnread, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class TabItems {
        private final boolean ableToInstantInvite;
        private final boolean canAccessSettings;
        private final int premiumSubscriptionCount;

        public TabItems(boolean z2, boolean z3, int i) {
            this.canAccessSettings = z2;
            this.ableToInstantInvite = z3;
            this.premiumSubscriptionCount = i;
        }

        public static /* synthetic */ TabItems copy$default(TabItems tabItems, boolean z2, boolean z3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = tabItems.canAccessSettings;
            }
            if ((i2 & 2) != 0) {
                z3 = tabItems.ableToInstantInvite;
            }
            if ((i2 & 4) != 0) {
                i = tabItems.premiumSubscriptionCount;
            }
            return tabItems.copy(z2, z3, i);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCanAccessSettings() {
            return this.canAccessSettings;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAbleToInstantInvite() {
            return this.ableToInstantInvite;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPremiumSubscriptionCount() {
            return this.premiumSubscriptionCount;
        }

        public final TabItems copy(boolean canAccessSettings, boolean ableToInstantInvite, int premiumSubscriptionCount) {
            return new TabItems(canAccessSettings, ableToInstantInvite, premiumSubscriptionCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TabItems)) {
                return false;
            }
            TabItems tabItems = (TabItems) other;
            return this.canAccessSettings == tabItems.canAccessSettings && this.ableToInstantInvite == tabItems.ableToInstantInvite && this.premiumSubscriptionCount == tabItems.premiumSubscriptionCount;
        }

        public final boolean getAbleToInstantInvite() {
            return this.ableToInstantInvite;
        }

        public final boolean getCanAccessSettings() {
            return this.canAccessSettings;
        }

        public final int getPremiumSubscriptionCount() {
            return this.premiumSubscriptionCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.canAccessSettings;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.ableToInstantInvite;
            return ((i + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.premiumSubscriptionCount;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("TabItems(canAccessSettings=");
            sbM833U.append(this.canAccessSettings);
            sbM833U.append(", ableToInstantInvite=");
            sbM833U.append(this.ableToInstantInvite);
            sbM833U.append(", premiumSubscriptionCount=");
            return outline.m814B(sbM833U, this.premiumSubscriptionCount, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Actions actions;
            private final Banner banner;
            private final BottomActions bottomActions;
            private final EmojisData emojisData;
            private final String guildDescription;
            private final String guildIcon;
            private final long guildId;
            private final String guildName;
            private final String guildShortName;
            private final boolean isGuildHub;
            private final MeUser meUser;
            private final Integer memberCount;
            private final Integer onlineCount;
            private final TabItems tabItems;
            private final Integer verifiedPartneredIconRes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, String str, String str2, String str3, String str4, Integer num, Banner banner, Integer num2, Integer num3, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean z2, MeUser meUser) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "guildName");
                Intrinsics3.checkNotNullParameter(str2, "guildShortName");
                Intrinsics3.checkNotNullParameter(banner, "banner");
                Intrinsics3.checkNotNullParameter(emojisData, "emojisData");
                Intrinsics3.checkNotNullParameter(bottomActions, "bottomActions");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                this.guildId = j;
                this.guildName = str;
                this.guildShortName = str2;
                this.guildIcon = str3;
                this.guildDescription = str4;
                this.verifiedPartneredIconRes = num;
                this.banner = banner;
                this.onlineCount = num2;
                this.memberCount = num3;
                this.tabItems = tabItems;
                this.actions = actions;
                this.emojisData = emojisData;
                this.bottomActions = bottomActions;
                this.isGuildHub = z2;
                this.meUser = meUser;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, long j, String str, String str2, String str3, String str4, Integer num, Banner banner, Integer num2, Integer num3, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean z2, MeUser meUser, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.guildId : j, (i & 2) != 0 ? loaded.guildName : str, (i & 4) != 0 ? loaded.guildShortName : str2, (i & 8) != 0 ? loaded.guildIcon : str3, (i & 16) != 0 ? loaded.guildDescription : str4, (i & 32) != 0 ? loaded.verifiedPartneredIconRes : num, (i & 64) != 0 ? loaded.banner : banner, (i & 128) != 0 ? loaded.onlineCount : num2, (i & 256) != 0 ? loaded.memberCount : num3, (i & 512) != 0 ? loaded.tabItems : tabItems, (i & 1024) != 0 ? loaded.actions : actions, (i & 2048) != 0 ? loaded.emojisData : emojisData, (i & 4096) != 0 ? loaded.bottomActions : bottomActions, (i & 8192) != 0 ? loaded.isGuildHub : z2, (i & 16384) != 0 ? loaded.meUser : meUser);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component10, reason: from getter */
            public final TabItems getTabItems() {
                return this.tabItems;
            }

            /* renamed from: component11, reason: from getter */
            public final Actions getActions() {
                return this.actions;
            }

            /* renamed from: component12, reason: from getter */
            public final EmojisData getEmojisData() {
                return this.emojisData;
            }

            /* renamed from: component13, reason: from getter */
            public final BottomActions getBottomActions() {
                return this.bottomActions;
            }

            /* renamed from: component14, reason: from getter */
            public final boolean getIsGuildHub() {
                return this.isGuildHub;
            }

            /* renamed from: component15, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getGuildShortName() {
                return this.guildShortName;
            }

            /* renamed from: component4, reason: from getter */
            public final String getGuildIcon() {
                return this.guildIcon;
            }

            /* renamed from: component5, reason: from getter */
            public final String getGuildDescription() {
                return this.guildDescription;
            }

            /* renamed from: component6, reason: from getter */
            public final Integer getVerifiedPartneredIconRes() {
                return this.verifiedPartneredIconRes;
            }

            /* renamed from: component7, reason: from getter */
            public final Banner getBanner() {
                return this.banner;
            }

            /* renamed from: component8, reason: from getter */
            public final Integer getOnlineCount() {
                return this.onlineCount;
            }

            /* renamed from: component9, reason: from getter */
            public final Integer getMemberCount() {
                return this.memberCount;
            }

            public final Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, Integer verifiedPartneredIconRes, Banner banner, Integer onlineCount, Integer memberCount, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean isGuildHub, MeUser meUser) {
                Intrinsics3.checkNotNullParameter(guildName, "guildName");
                Intrinsics3.checkNotNullParameter(guildShortName, "guildShortName");
                Intrinsics3.checkNotNullParameter(banner, "banner");
                Intrinsics3.checkNotNullParameter(emojisData, "emojisData");
                Intrinsics3.checkNotNullParameter(bottomActions, "bottomActions");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                return new Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, verifiedPartneredIconRes, banner, onlineCount, memberCount, tabItems, actions, emojisData, bottomActions, isGuildHub, meUser);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.guildId == loaded.guildId && Intrinsics3.areEqual(this.guildName, loaded.guildName) && Intrinsics3.areEqual(this.guildShortName, loaded.guildShortName) && Intrinsics3.areEqual(this.guildIcon, loaded.guildIcon) && Intrinsics3.areEqual(this.guildDescription, loaded.guildDescription) && Intrinsics3.areEqual(this.verifiedPartneredIconRes, loaded.verifiedPartneredIconRes) && Intrinsics3.areEqual(this.banner, loaded.banner) && Intrinsics3.areEqual(this.onlineCount, loaded.onlineCount) && Intrinsics3.areEqual(this.memberCount, loaded.memberCount) && Intrinsics3.areEqual(this.tabItems, loaded.tabItems) && Intrinsics3.areEqual(this.actions, loaded.actions) && Intrinsics3.areEqual(this.emojisData, loaded.emojisData) && Intrinsics3.areEqual(this.bottomActions, loaded.bottomActions) && this.isGuildHub == loaded.isGuildHub && Intrinsics3.areEqual(this.meUser, loaded.meUser);
            }

            public final Actions getActions() {
                return this.actions;
            }

            public final Banner getBanner() {
                return this.banner;
            }

            public final BottomActions getBottomActions() {
                return this.bottomActions;
            }

            public final EmojisData getEmojisData() {
                return this.emojisData;
            }

            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final String getGuildIcon() {
                return this.guildIcon;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getGuildShortName() {
                return this.guildShortName;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Integer getMemberCount() {
                return this.memberCount;
            }

            public final Integer getOnlineCount() {
                return this.onlineCount;
            }

            public final TabItems getTabItems() {
                return this.tabItems;
            }

            public final Integer getVerifiedPartneredIconRes() {
                return this.verifiedPartneredIconRes;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iM3a = C0002b.m3a(this.guildId) * 31;
                String str = this.guildName;
                int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildShortName;
                int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIcon;
                int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.guildDescription;
                int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                Integer num = this.verifiedPartneredIconRes;
                int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
                Banner banner = this.banner;
                int iHashCode6 = (iHashCode5 + (banner != null ? banner.hashCode() : 0)) * 31;
                Integer num2 = this.onlineCount;
                int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
                Integer num3 = this.memberCount;
                int iHashCode8 = (iHashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
                TabItems tabItems = this.tabItems;
                int iHashCode9 = (iHashCode8 + (tabItems != null ? tabItems.hashCode() : 0)) * 31;
                Actions actions = this.actions;
                int iHashCode10 = (iHashCode9 + (actions != null ? actions.hashCode() : 0)) * 31;
                EmojisData emojisData = this.emojisData;
                int iHashCode11 = (iHashCode10 + (emojisData != null ? emojisData.hashCode() : 0)) * 31;
                BottomActions bottomActions = this.bottomActions;
                int iHashCode12 = (iHashCode11 + (bottomActions != null ? bottomActions.hashCode() : 0)) * 31;
                boolean z2 = this.isGuildHub;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode12 + i) * 31;
                MeUser meUser = this.meUser;
                return i2 + (meUser != null ? meUser.hashCode() : 0);
            }

            public final boolean isGuildHub() {
                return this.isGuildHub;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", guildName=");
                sbM833U.append(this.guildName);
                sbM833U.append(", guildShortName=");
                sbM833U.append(this.guildShortName);
                sbM833U.append(", guildIcon=");
                sbM833U.append(this.guildIcon);
                sbM833U.append(", guildDescription=");
                sbM833U.append(this.guildDescription);
                sbM833U.append(", verifiedPartneredIconRes=");
                sbM833U.append(this.verifiedPartneredIconRes);
                sbM833U.append(", banner=");
                sbM833U.append(this.banner);
                sbM833U.append(", onlineCount=");
                sbM833U.append(this.onlineCount);
                sbM833U.append(", memberCount=");
                sbM833U.append(this.memberCount);
                sbM833U.append(", tabItems=");
                sbM833U.append(this.tabItems);
                sbM833U.append(", actions=");
                sbM833U.append(this.actions);
                sbM833U.append(", emojisData=");
                sbM833U.append(this.emojisData);
                sbM833U.append(", bottomActions=");
                sbM833U.append(this.bottomActions);
                sbM833U.append(", isGuildHub=");
                sbM833U.append(this.isGuildHub);
                sbM833U.append(", meUser=");
                sbM833U.append(this.meUser);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
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

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickLeaveServer$1 */
    public static final class C88051 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88051(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickMarkAsRead$1 */
    public static final class C88061 extends Lambda implements Function1<Void, Unit> {
        public C88061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetGuildProfileSheetViewModel.access$getEventSubject$p(WidgetGuildProfileSheetViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(new Event.DismissAndShowToast(C5419R.string.marked_as_read));
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickResetNickname$1 */
    public static final class C88071 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88071(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickSaveNickname$1 */
    public static final class C88081 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88081(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    public /* synthetic */ WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 2) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, z2, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 16) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking, (i & 32) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, j, (i & 128) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel) {
        return widgetGuildProfileSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel, StoreState storeState) {
        widgetGuildProfileSheetViewModel.handleStoreState(storeState);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleLoadedGuild(Guild guild, GuildPreview guildPreview, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
        Integer num;
        Integer numValueOf;
        Actions actions;
        List<? extends Emoji> listEmptyList;
        List<GuildEmoji> listM7887d;
        if (guild.getFeatures().contains(GuildFeature.VERIFIED)) {
            numValueOf = Integer.valueOf(C5419R.drawable.ic_verified_badge);
        } else {
            if (!guild.getFeatures().contains(GuildFeature.PARTNERED)) {
                num = null;
                Banner banner = new Banner(guild.getId(), guild.getBanner(), Banner.Type.BANNER);
                PermissionsContexts manageGuildContext = guildChannelsInfo.getManageGuildContext();
                TabItems tabItems = isLurking ? new TabItems(manageGuildContext.canManage(), guildChannelsInfo.getAbleToInstantInvite(), guild.getPremiumSubscriptionCount()) : null;
                if (isLurking) {
                    actions = new Actions(isUnread, manageGuildContext.getCanManageChannels(), manageGuildContext.getCanManageEvents(), guildChannelsInfo.getCanChangeNickname(), computedMe != null ? computedMe.getNick() : null, computedMe != null ? computedMe.getAvatarHash() : null, !restrictedGuildIds.contains(Long.valueOf(guild.getId())), guildChannelsInfo.getHideMutedChannels(), !guild.isOwner(me2.getId()), isDeveloper, me2.getUsername());
                } else {
                    actions = null;
                }
                if (isLurking) {
                    listEmptyList = emojis;
                } else if (guildPreview == null || (listM7887d = guildPreview.m7887d()) == null) {
                    listEmptyList = null;
                } else {
                    listEmptyList = new ArrayList<>(Iterables2.collectionSizeOrDefault(listM7887d, 10));
                    Iterator<T> it = listM7887d.iterator();
                    while (it.hasNext()) {
                        listEmptyList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
                    }
                }
                BottomActions bottomActions = new BottomActions(isLurking && manageGuildContext.getCanManageEmojisAndStickers(), isLurking, true ^ this.viewingGuild);
                long id2 = guild.getId();
                String name = guild.getName();
                String shortName = guild.getShortName();
                String icon = guild.getIcon();
                String description = guild.getDescription();
                Integer approximatePresenceCount = guildPreview == null ? guildPreview.getApproximatePresenceCount() : null;
                Integer approximateMemberCount = guildPreview != null ? guildPreview.getApproximateMemberCount() : null;
                TabItems tabItems2 = tabItems;
                boolean zIsPremium = UserUtils.INSTANCE.isPremium(me2);
                boolean z2 = this.isEmojiSectionExpanded;
                if (listEmptyList == null) {
                    listEmptyList = Collections2.emptyList();
                }
                updateViewState(new ViewState.Loaded(id2, name, shortName, icon, description, num, banner, approximatePresenceCount, approximateMemberCount, tabItems2, actions, new EmojisData(zIsPremium, z2, listEmptyList), bottomActions, guild.isHub(), me2));
            }
            numValueOf = Integer.valueOf(C5419R.drawable.ic_partnered_badge);
        }
        num = numValueOf;
        Banner banner2 = new Banner(guild.getId(), guild.getBanner(), Banner.Type.BANNER);
        PermissionsContexts manageGuildContext2 = guildChannelsInfo.getManageGuildContext();
        if (isLurking) {
        }
        if (isLurking) {
        }
        if (isLurking) {
        }
        BottomActions bottomActions2 = new BottomActions(isLurking && manageGuildContext2.getCanManageEmojisAndStickers(), isLurking, true ^ this.viewingGuild);
        long id22 = guild.getId();
        String name2 = guild.getName();
        String shortName2 = guild.getShortName();
        String icon2 = guild.getIcon();
        String description2 = guild.getDescription();
        if (guildPreview == null) {
        }
        if (guildPreview != null) {
        }
        TabItems tabItems22 = tabItems;
        boolean zIsPremium2 = UserUtils.INSTANCE.isPremium(me2);
        boolean z22 = this.isEmojiSectionExpanded;
        if (listEmptyList == null) {
        }
        updateViewState(new ViewState.Loaded(id22, name2, shortName2, icon2, description2, num, banner2, approximatePresenceCount, approximateMemberCount, tabItems22, actions, new EmojisData(zIsPremium2, z22, listEmptyList), bottomActions2, guild.isHub(), me2));
    }

    private final void handleLoadedGuildPreview(GuildPreview guildPreview, MeUser meUser) {
        Integer numValueOf = guildPreview.m7889f().contains(GuildFeature.VERIFIED) ? Integer.valueOf(C5419R.drawable.ic_verified_badge) : guildPreview.m7889f().contains(GuildFeature.PARTNERED) ? Integer.valueOf(C5419R.drawable.ic_partnered_badge) : null;
        Banner banner = new Banner(guildPreview.getId(), guildPreview.getSplash(), Banner.Type.SPLASH);
        BottomActions bottomActions = new BottomActions(false, true, !this.viewingGuild);
        long id2 = guildPreview.getId();
        String name = guildPreview.getName();
        String strComputeShortName = GuildUtils.computeShortName(guildPreview.getName());
        String icon = guildPreview.getIcon();
        String description = guildPreview.getDescription();
        Integer approximatePresenceCount = guildPreview.getApproximatePresenceCount();
        Integer approximateMemberCount = guildPreview.getApproximateMemberCount();
        boolean zIsPremium = UserUtils.INSTANCE.isPremium(meUser);
        boolean z2 = this.isEmojiSectionExpanded;
        List<GuildEmoji> listM7887d = guildPreview.m7887d();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listM7887d, 10));
        Iterator it = listM7887d.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
            it = it;
            approximatePresenceCount = approximatePresenceCount;
            approximateMemberCount = approximateMemberCount;
        }
        updateViewState(new ViewState.Loaded(id2, name, strComputeShortName, icon, description, numValueOf, banner, approximatePresenceCount, approximateMemberCount, null, null, new EmojisData(zIsPremium, z2, arrayList), bottomActions, guildPreview.m7889f().contains(GuildFeature.HUB), meUser));
    }

    private final void handleStoreState(StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildProfiles.GuildProfileData guildProfile = storeState.getGuildProfile();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        MeUser me2 = storeState.getMe();
        GuildMember computedMe = storeState.getComputedMe();
        List<Long> listComponent6 = storeState.component6();
        boolean isDeveloper = storeState.getIsDeveloper();
        List<Emoji> listComponent8 = storeState.component8();
        boolean isLurking = storeState.getIsLurking();
        boolean isUnread = storeState.getIsUnread();
        if (guild != null) {
            handleLoadedGuild(guild, guildProfile != null ? guildProfile.getData() : null, guildChannelsInfo, me2, computedMe, listComponent6, isDeveloper, listComponent8, isLurking, isUnread);
            return;
        }
        StoreGuildProfiles.FetchStates fetchState = guildProfile != null ? guildProfile.getFetchState() : null;
        StoreGuildProfiles.FetchStates fetchStates = StoreGuildProfiles.FetchStates.SUCCEEDED;
        if (fetchState == fetchStates && guildProfile.getData() != null) {
            handleLoadedGuildPreview(guildProfile.getData(), me2);
            return;
        }
        if ((guildProfile != null ? guildProfile.getFetchState() : null) != StoreGuildProfiles.FetchStates.FAILED) {
            if ((guildProfile != null ? guildProfile.getFetchState() : null) != fetchStates || guildProfile.getData() != null) {
                updateViewState(ViewState.Loading.INSTANCE);
                return;
            }
        }
        updateViewState(ViewState.Invalid.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickEmoji() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || this.isEmojiSectionExpanded) {
            return;
        }
        this.isEmojiSectionExpanded = true;
        updateViewState(ViewState.Loaded.copy$default(loaded, 0L, null, null, null, null, null, null, null, null, null, null, EmojisData.copy$default(loaded.getEmojisData(), false, this.isEmojiSectionExpanded, null, 5, null), null, false, null, 30719, null));
    }

    public final void onClickJoinServer(long guildId, Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Context context = fragment.getContext();
        if (context != null) {
            StoreLurking storeLurking = this.storeLurking;
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            storeLurking.postJoinGuildAsMember(guildId, context);
        }
    }

    public final void onClickLeaveServer(long guildId, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(guildId), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88051(onSuccess), 62, (Object) null);
    }

    public final void onClickMarkAsRead(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(guildId), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88061(), 62, (Object) null);
    }

    public final void onClickResetNickname(long guildId, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams.Nick("")), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88071(onSuccess), 62, (Object) null);
    }

    public final void onClickSaveNickname(long guildId, String nick, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams.Nick(nick)), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88081(onSuccess), 62, (Object) null);
    }

    public final void onClickViewServer(long guildId, Long channelId) {
        StoreLurking.startLurkingAndNavigate$default(this.storeLurking, guildId, channelId, null, 4, null);
    }

    public final void setAllowDM(AppActivity appActivity, long guildId, boolean allow) {
        this.storeUserSettings.setRestrictedGuildId(appActivity, guildId, !allow);
    }

    public final void setHideMutedChannels(long guildId, boolean hide) {
        this.storeUserGuildSettings.setHideMutedChannels(guildId, hide);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeLurking, "storeLurking");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.viewingGuild = z2;
        this.restAPI = restAPI;
        this.storeLurking = storeLurking;
        this.guildId = j;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88031(), 62, (Object) null);
        storeAnalytics.trackGuildProfileOpened(j);
    }
}
