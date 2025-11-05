package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.g0;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreChannelMembers.kt */
/* loaded from: classes2.dex */
public final class StoreChannelMembers extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private final Function1<Long, Channel> getChannel;
    private final Function1<Long, Integer> getGuildMemberCount;
    private final Function1<Long, Presence> getPresence;
    private final Function1<Long, Boolean> isUserStreaming;
    private final PublishSubject<Unit> markChangedTrigger;
    private final Map<Long, Map<String, ChannelMemberList>> memberLists;
    private Map<Long, ? extends Map<String, ChannelMemberList>> memberListsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;

    /* compiled from: StoreChannelMembers.kt */
    /* renamed from: com.discord.stores.StoreChannelMembers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Unit, Unit> {

        /* compiled from: StoreChannelMembers.kt */
        /* renamed from: com.discord.stores.StoreChannelMembers$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02231 extends o implements Function0<Unit> {
            public C02231() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChannelMembers.this.markChanged();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreChannelMembers.access$getDispatcher$p(StoreChannelMembers.this).schedule(new C02231());
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final MemberListRow.Member makeRowMember(long userId, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Presence presence, boolean isUserStreaming, boolean showOwnerIndicator) {
            m.checkNotNullParameter(users, "users");
            GuildMember guildMember = guildMembers != null ? guildMembers.get(Long.valueOf(userId)) : null;
            User user = users.get(Long.valueOf(userId));
            if (user == null || guildMember == null) {
                return null;
            }
            return new MemberListRow.Member(userId, GuildMember.INSTANCE.getNickOrUsername(guildMember, user), user.getIsBot(), Integer.valueOf(user.getIsSystemUser() ? R.string.system_dm_tag_system : R.string.bot_tag_bot), UserUtils.INSTANCE.isVerifiedBot(user), presence, guildMember.getColor() != -16777216 ? Integer.valueOf(guildMember.getColor()) : null, IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, user, guildMember, null, false, 12, null), showOwnerIndicator, guildMember.getPremiumSince(), isUserStreaming, user.getFlags() | user.getPublicFlags());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    public static final class MemberListIdCalculator {
        public static final MemberListIdCalculator INSTANCE = new MemberListIdCalculator();

        private MemberListIdCalculator() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String computeIdFromOverwrites(List<PermissionOverwrite> permissionOverwrites) {
            String strValueOf;
            String strJoinToString$default;
            if (permissionOverwrites != null) {
                ArrayList arrayList = new ArrayList();
                for (PermissionOverwrite permissionOverwrite : permissionOverwrites) {
                    if (PermissionOverwriteUtilsKt.allows(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                        StringBuilder sbU = a.U("allow:");
                        sbU.append(permissionOverwrite.e());
                        arrayList.add(sbU.toString());
                    } else if (PermissionOverwriteUtilsKt.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                        StringBuilder sbU2 = a.U("deny:");
                        sbU2.append(permissionOverwrite.e());
                        arrayList.add(sbU2.toString());
                    }
                }
                List listSorted = u.sorted(arrayList);
                strValueOf = (listSorted == null || (strJoinToString$default = u.joinToString$default(listSorted, ",", null, null, 0, null, null, 62, null)) == null) ? null : String.valueOf(INSTANCE.toUnsignedLong(j0.l.e.m.a(strJoinToString$default, 0, strJoinToString$default.length(), 0)));
            }
            return strValueOf != null ? strValueOf : "";
        }

        private final long toUnsignedLong(int i) {
            return i & 4294967295L;
        }

        public final String computeMemberListId(Function1<? super Long, Channel> channelsProvider, long channelId, StoreGuilds storeGuilds) {
            m.checkNotNullParameter(channelsProvider, "channelsProvider");
            m.checkNotNullParameter(storeGuilds, "storeGuilds");
            Channel channelInvoke = channelsProvider.invoke(Long.valueOf(channelId));
            String memberListId = channelInvoke != null ? channelInvoke.getMemberListId() : null;
            if (channelInvoke != null) {
                if (memberListId != null) {
                    return memberListId;
                }
                Map mapEmptyMap = (Map) a.c(channelInvoke, storeGuilds.getRoles());
                if (mapEmptyMap == null) {
                    mapEmptyMap = h0.emptyMap();
                }
                if (!PermissionUtils.canEveryone(Permission.VIEW_CHANNEL, channelInvoke, null, mapEmptyMap)) {
                    return computeIdFromOverwrites(channelInvoke.v());
                }
            }
            return ModelGuildMemberListUpdate.EVERYONE_ID;
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    public static final class MemberListUpdateException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberListUpdateException(Exception exc) {
            super(exc);
            m.checkNotNullParameter(exc, "e");
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    public static final class MemberListUpdateLogger {
        private static final String ERROR_TAG = "MemberListUpdateError";
        private static final int MAX_UPDATE_COUNT = 20;
        public static final MemberListUpdateLogger INSTANCE = new MemberListUpdateLogger();
        private static final Map<String, List<String>> opLogs = new HashMap();

        private MemberListUpdateLogger() {
        }

        private final String makeLogKey(long guildId, String memberListId) {
            return guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + memberListId;
        }

        public final void dumpLogs(long guildId, String memberListId, Exception exception) {
            m.checkNotNullParameter(memberListId, "memberListId");
            m.checkNotNullParameter(exception, "exception");
            List<String> list = opLogs.get(makeLogKey(guildId, memberListId));
            StringBuilder sb = new StringBuilder();
            sb.append("guildId: ");
            sb.append(guildId);
            sb.append(" -- memberListId: ");
            sb.append(memberListId);
            sb.append(" -- LAST 20 UPDATES:\n");
            sb.append(list != null ? u.joinToString$default(list, "\n", null, null, 0, null, null, 62, null) : null);
            FirebaseCrashlytics.getInstance().log(sb.toString());
            Logger.e$default(AppLog.g, ERROR_TAG, new MemberListUpdateException(exception), null, 4, null);
        }

        public final void logUpdate(ModelGuildMemberListUpdate update) {
            String string;
            m.checkNotNullParameter(update, "update");
            List<ModelGuildMemberListUpdate.Operation> operations = update.getOperations();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(operations, 10));
            for (ModelGuildMemberListUpdate.Operation operation : operations) {
                if (operation instanceof ModelGuildMemberListUpdate.Operation.Sync) {
                    StringBuilder sbU = a.U("  SYNC: ");
                    sbU.append(((ModelGuildMemberListUpdate.Operation.Sync) operation).getRange());
                    string = sbU.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Update) {
                    StringBuilder sbU2 = a.U("  UPDATE: ");
                    sbU2.append(((ModelGuildMemberListUpdate.Operation.Update) operation).getIndex());
                    string = sbU2.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Insert) {
                    StringBuilder sbU3 = a.U("  INSERT: ");
                    sbU3.append(((ModelGuildMemberListUpdate.Operation.Insert) operation).getIndex());
                    string = sbU3.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Delete) {
                    StringBuilder sbU4 = a.U("  DELETE: ");
                    sbU4.append(((ModelGuildMemberListUpdate.Operation.Delete) operation).getIndex());
                    string = sbU4.toString();
                } else {
                    if (!(operation instanceof ModelGuildMemberListUpdate.Operation.Invalidate)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringBuilder sbU5 = a.U("  INVALIDATE: ");
                    sbU5.append(((ModelGuildMemberListUpdate.Operation.Invalidate) operation).getRange());
                    string = sbU5.toString();
                }
                arrayList.add(string);
            }
            String strJ = a.J(a.U("GROUPS: ["), u.joinToString$default(update.getGroups(), ",", null, null, 0, null, StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1.INSTANCE, 30, null), "]");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            arrayList2.add(strJ);
            arrayList2.add("-----");
            String strMakeLogKey = makeLogKey(update.getGuildId(), update.getId());
            Map<String, List<String>> map = opLogs;
            List<String> arrayList3 = map.get(strMakeLogKey);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList<>();
            }
            arrayList3.add(u.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null));
            if (arrayList3.size() > 20) {
                arrayList3.remove(0);
            }
            map.put(strMakeLogKey, arrayList3);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ModelGuildMemberListUpdate.Group.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ModelGuildMemberListUpdate.Group.Type.ROLE.ordinal()] = 1;
            iArr[ModelGuildMemberListUpdate.Group.Type.OFFLINE.ordinal()] = 2;
            iArr[ModelGuildMemberListUpdate.Group.Type.ONLINE.ordinal()] = 3;
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    /* renamed from: com.discord.stores.StoreChannelMembers$handleGuildMemberListUpdate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ModelGuildMemberListUpdate.Group, MemberListRow> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MemberListRow invoke(ModelGuildMemberListUpdate.Group group) {
            return invoke2(group);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MemberListRow invoke2(ModelGuildMemberListUpdate.Group group) {
            m.checkNotNullParameter(group, "it");
            return StoreChannelMembers.access$makeGroup(StoreChannelMembers.this, this.$guildId, group);
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    /* renamed from: com.discord.stores.StoreChannelMembers$observeChannelMemberList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<ChannelMemberList> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ChannelMemberList invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChannelMemberList invoke() {
            return StoreChannelMembers.this.getChannelMemberList(this.$guildId, this.$channelId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreChannelMembers(ObservationDeck observationDeck, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreUser storeUser, Function1<? super Long, Channel> function1, Function1<? super Long, Integer> function12, Function1<? super Long, Presence> function13, Function1<? super Long, Boolean> function14) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(function1, "getChannel");
        m.checkNotNullParameter(function12, "getGuildMemberCount");
        m.checkNotNullParameter(function13, "getPresence");
        m.checkNotNullParameter(function14, "isUserStreaming");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.storeGuilds = storeGuilds;
        this.storeUser = storeUser;
        this.getChannel = function1;
        this.getGuildMemberCount = function12;
        this.getPresence = function13;
        this.isUserStreaming = function14;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = h0.emptyMap();
        PublishSubject<Unit> publishSubjectK0 = PublishSubject.k0();
        this.markChangedTrigger = publishSubjectK0;
        m.checkNotNullExpressionValue(publishSubjectK0, "markChangedTrigger");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.leadingEdgeThrottle(publishSubjectK0, 1L, TimeUnit.SECONDS), StoreChannelMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelMembers storeChannelMembers) {
        return storeChannelMembers.dispatcher;
    }

    public static final /* synthetic */ MemberListRow access$makeGroup(StoreChannelMembers storeChannelMembers, long j, ModelGuildMemberListUpdate.Group group) {
        return storeChannelMembers.makeGroup(j, group);
    }

    public static final /* synthetic */ MemberListRow access$makeRowMember(StoreChannelMembers storeChannelMembers, long j, long j2, boolean z2) {
        return storeChannelMembers.makeRowMember(j, j2, z2);
    }

    @StoreThread
    private final boolean allowOwnerIndicator(long guildId) {
        Collection<GuildRole> collectionValues;
        Map<Long, GuildRole> map = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        boolean z2 = false;
        if (map != null && (collectionValues = map.values()) != null && !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GuildRole guildRole = (GuildRole) it.next();
                if (guildRole.getHoist() && PermissionUtils.can(8L, Long.valueOf(guildRole.getPermissions()))) {
                    z2 = true;
                    break;
                }
            }
        }
        return !z2;
    }

    @StoreThread
    private final ChannelMemberList getMemberList(long guildId, String memberListId) {
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(memberListId);
        }
        return null;
    }

    @StoreThread
    private final void handleDelete(String memberListId, ModelGuildMemberListUpdate.Operation.Delete deleteOperation, long guildId) {
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.delete(deleteOperation.getIndex());
        }
    }

    @StoreThread
    private final void handleInsert(String memberListId, ModelGuildMemberListUpdate.Operation.Insert insertOperation, long guildId) {
        int index = insertOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.insert(index, makeRow(guildId, insertOperation.getItem()));
        }
    }

    @StoreThread
    private final void handleInvalidate(String memberListId, ModelGuildMemberListUpdate.Operation.Invalidate operation, long guildId) {
        IntRange range = operation.getRange();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.invalidate(range);
        }
    }

    @StoreThread
    private final void handleSync(String memberListId, ModelGuildMemberListUpdate.Operation.Sync syncOperation, long guildId) throws NumberFormatException {
        MemberListRow memberListRowMakeGroup;
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map == null) {
            map = new HashMap<>();
            this.memberLists.put(Long.valueOf(guildId), map);
        }
        ChannelMemberList channelMemberList = map.get(memberListId);
        if (channelMemberList == null) {
            AppLog appLog = AppLog.g;
            channelMemberList = new ChannelMemberList(memberListId, 0, appLog, 2, null);
            map.put(memberListId, channelMemberList);
            appLog.recordBreadcrumb(channelMemberList.getListId() + " INSTANTIATE", "ChannelMemberList");
        }
        boolean zAllowOwnerIndicator = allowOwnerIndicator(guildId);
        List<ModelGuildMemberListUpdate.Operation.Item> items = syncOperation.getItems();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(items, 10));
        for (ModelGuildMemberListUpdate.Operation.Item item : items) {
            if (item instanceof ModelGuildMemberListUpdate.Operation.Item.MemberItem) {
                memberListRowMakeGroup = makeRowMember(guildId, ((ModelGuildMemberListUpdate.Operation.Item.MemberItem) item).getMember().getUser().getId(), zAllowOwnerIndicator);
            } else {
                if (!(item instanceof ModelGuildMemberListUpdate.Operation.Item.GroupItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                memberListRowMakeGroup = makeGroup(guildId, ((ModelGuildMemberListUpdate.Operation.Item.GroupItem) item).getGroup());
            }
            arrayList.add(memberListRowMakeGroup);
        }
        channelMemberList.sync(((Number) u.first(syncOperation.getRange())).intValue(), arrayList);
    }

    private final void handleUpdate(String memberListId, ModelGuildMemberListUpdate.Operation.Update updateOperation, long guildId) {
        int index = updateOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.update(index, makeRow(guildId, updateOperation.getItem()));
        }
    }

    @StoreThread
    private final MemberListRow makeGroup(long guildId, ModelGuildMemberListUpdate.Group group) throws NumberFormatException {
        String name;
        GuildRole guildRole;
        String id2 = group.getId();
        int iOrdinal = group.getType().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return new MemberListRow.StatusHeader(id2, MemberListRow.StatusHeader.Type.OFFLINE, group.getCount());
            }
            if (iOrdinal == 2) {
                return new MemberListRow.StatusHeader(id2, MemberListRow.StatusHeader.Type.ONLINE, group.getCount());
            }
            throw new NoWhenBranchMatchedException();
        }
        long j = Long.parseLong(id2);
        Map<Long, GuildRole> map = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (map == null || (guildRole = map.get(Long.valueOf(j))) == null || (name = guildRole.getName()) == null) {
            name = "";
        }
        return new MemberListRow.RoleHeader(j, name, group.getCount());
    }

    @StoreThread
    private final MemberListRow makeRow(long guildId, ModelGuildMemberListUpdate.Operation.Item item) {
        if (item instanceof ModelGuildMemberListUpdate.Operation.Item.MemberItem) {
            return makeRowMember(guildId, ((ModelGuildMemberListUpdate.Operation.Item.MemberItem) item).getMember().getUser().getId(), allowOwnerIndicator(guildId));
        }
        if (item instanceof ModelGuildMemberListUpdate.Operation.Item.GroupItem) {
            return makeGroup(guildId, ((ModelGuildMemberListUpdate.Operation.Item.GroupItem) item).getGroup());
        }
        throw new NoWhenBranchMatchedException();
    }

    @StoreThread
    private final MemberListRow makeRowMember(long guildId, long userId, boolean allowOwnerIndicator) {
        Guild guild;
        return INSTANCE.makeRowMember(userId, this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId)), this.storeUser.getUsersInternal$app_productionGoogleRelease(), this.getPresence.invoke(Long.valueOf(userId)), this.isUserStreaming.invoke(Long.valueOf(userId)).booleanValue(), allowOwnerIndicator && (guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) != null && guild.getOwnerId() == userId);
    }

    private final void throttleMarkChanged() {
        PublishSubject<Unit> publishSubject = this.markChangedTrigger;
        publishSubject.k.onNext(Unit.a);
    }

    public final ChannelMemberList getChannelMemberList(long guildId, long channelId) {
        String strComputeMemberListId = MemberListIdCalculator.INSTANCE.computeMemberListId(this.getChannel, channelId, this.storeGuilds);
        Map<String, ChannelMemberList> mapEmptyMap = this.memberListsSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        ChannelMemberList channelMemberList = mapEmptyMap.get(strComputeMemberListId);
        return channelMemberList != null ? channelMemberList : new ChannelMemberList(strComputeMemberListId, this.getGuildMemberCount.invoke(Long.valueOf(guildId)).intValue(), AppLog.g);
    }

    @StoreThread
    public final void handleGuildMemberListUpdate(ModelGuildMemberListUpdate update) {
        m.checkNotNullParameter(update, "update");
        long guildId = update.getGuildId();
        String id2 = update.getId();
        MemberListUpdateLogger.INSTANCE.logUpdate(update);
        try {
            for (ModelGuildMemberListUpdate.Operation operation : update.getOperations()) {
                if (operation instanceof ModelGuildMemberListUpdate.Operation.Sync) {
                    handleSync(id2, (ModelGuildMemberListUpdate.Operation.Sync) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Update) {
                    handleUpdate(id2, (ModelGuildMemberListUpdate.Operation.Update) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Insert) {
                    handleInsert(id2, (ModelGuildMemberListUpdate.Operation.Insert) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Delete) {
                    handleDelete(id2, (ModelGuildMemberListUpdate.Operation.Delete) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Invalidate) {
                    handleInvalidate(id2, (ModelGuildMemberListUpdate.Operation.Invalidate) operation, guildId);
                }
            }
            ChannelMemberList memberList = getMemberList(update.getGuildId(), id2);
            if (memberList != null) {
                memberList.setGroups(update.getGroups(), new AnonymousClass2(guildId));
            }
        } catch (Exception e) {
            MemberListUpdateLogger.INSTANCE.dumpLogs(guildId, id2, e);
        }
        throttleMarkChanged();
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        if (this.memberLists.remove(Long.valueOf(guildId)) != null) {
            throttleMarkChanged();
        }
    }

    @StoreThread
    public final void handleGuildRoleCreateOrUpdate(long guildId) {
        boolean zAllowOwnerIndicator = allowOwnerIndicator(guildId);
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map != null) {
            Iterator<Map.Entry<String, ChannelMemberList>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().rebuildMembers(new StoreChannelMembers$handleGuildRoleCreateOrUpdate$$inlined$forEach$lambda$1(this, guildId, zAllowOwnerIndicator));
            }
        }
        throttleMarkChanged();
    }

    public final Observable<ChannelMemberList> observeChannelMemberList(long guildId, long channelId) {
        Observable<ChannelMemberList> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Map<String, ChannelMemberList>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Map map2 = (Map) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(map2.size()));
            for (Map.Entry entry2 : map2.entrySet()) {
                linkedHashMap2.put(entry2.getKey(), new ChannelMemberList((ChannelMemberList) entry2.getValue()));
            }
            linkedHashMap.put(key, linkedHashMap2);
        }
        this.memberListsSnapshot = linkedHashMap;
    }
}
