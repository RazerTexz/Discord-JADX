package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.media.AudioAttributesCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelAuditLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelWebhook;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.auditlogs.AuditLogChangeUtils;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.s;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreAuditLog.kt */
/* loaded from: classes2.dex */
public final class StoreAuditLog extends StoreV2 {
    private static final long NO_GUILD = -1;
    private Long cutoffTimestamp;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private AuditLogState state;
    private AuditLogState stateSnapshot;

    /* compiled from: StoreAuditLog.kt */
    public static final /* data */ class AuditLogFilter {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int actionFilter;
        private final long userFilter;

        /* compiled from: StoreAuditLog.kt */
        public static final class Companion {
            private Companion() {
            }

            public final AuditLogFilter emptyFilter() {
                return new AuditLogFilter(0L, 0);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AuditLogFilter(long j, int i) {
            this.userFilter = j;
            this.actionFilter = i;
        }

        public static /* synthetic */ AuditLogFilter copy$default(AuditLogFilter auditLogFilter, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = auditLogFilter.userFilter;
            }
            if ((i2 & 2) != 0) {
                i = auditLogFilter.actionFilter;
            }
            return auditLogFilter.copy(j, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserFilter() {
            return this.userFilter;
        }

        /* renamed from: component2, reason: from getter */
        public final int getActionFilter() {
            return this.actionFilter;
        }

        public final AuditLogFilter copy(long userFilter, int actionFilter) {
            return new AuditLogFilter(userFilter, actionFilter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuditLogFilter)) {
                return false;
            }
            AuditLogFilter auditLogFilter = (AuditLogFilter) other;
            return this.userFilter == auditLogFilter.userFilter && this.actionFilter == auditLogFilter.actionFilter;
        }

        public final int getActionFilter() {
            return this.actionFilter;
        }

        public final long getUserFilter() {
            return this.userFilter;
        }

        public int hashCode() {
            return (b.a(this.userFilter) * 31) + this.actionFilter;
        }

        public String toString() {
            StringBuilder sbU = a.U("AuditLogFilter(userFilter=");
            sbU.append(this.userFilter);
            sbU.append(", actionFilter=");
            return a.B(sbU, this.actionFilter, ")");
        }
    }

    /* compiled from: StoreAuditLog.kt */
    public static final /* data */ class AuditLogState {
        private final Map<ModelAuditLogEntry.TargetType, Map<Long, CharSequence>> deletedTargets;
        private final List<ModelAuditLogEntry> entries;
        private final AuditLogFilter filter;
        private final long guildId;
        private final List<GuildScheduledEvent> guildScheduledEvents;
        private final List<ModelGuildIntegration> integrations;
        private final boolean isLoading;
        private final Long selectedItemId;
        private final List<Channel> threads;
        private final Map<Long, User> users;
        private final List<ModelWebhook> webhooks;

        public AuditLogState() {
            this(0L, null, null, null, null, null, null, null, null, null, false, 2047, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AuditLogState(long j, Map<Long, ? extends User> map, List<? extends ModelAuditLogEntry> list, List<? extends ModelWebhook> list2, List<? extends ModelGuildIntegration> list3, List<GuildScheduledEvent> list4, List<Channel> list5, Long l, AuditLogFilter auditLogFilter, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, CharSequence>> map2, boolean z2) {
            m.checkNotNullParameter(map, "users");
            m.checkNotNullParameter(list2, "webhooks");
            m.checkNotNullParameter(list3, "integrations");
            m.checkNotNullParameter(list4, "guildScheduledEvents");
            m.checkNotNullParameter(list5, "threads");
            m.checkNotNullParameter(auditLogFilter, "filter");
            m.checkNotNullParameter(map2, "deletedTargets");
            this.guildId = j;
            this.users = map;
            this.entries = list;
            this.webhooks = list2;
            this.integrations = list3;
            this.guildScheduledEvents = list4;
            this.threads = list5;
            this.selectedItemId = l;
            this.filter = auditLogFilter;
            this.deletedTargets = map2;
            this.isLoading = z2;
        }

        public static /* synthetic */ AuditLogState copy$default(AuditLogState auditLogState, long j, Map map, List list, List list2, List list3, List list4, List list5, Long l, AuditLogFilter auditLogFilter, Map map2, boolean z2, int i, Object obj) {
            return auditLogState.copy((i & 1) != 0 ? auditLogState.guildId : j, (i & 2) != 0 ? auditLogState.users : map, (i & 4) != 0 ? auditLogState.entries : list, (i & 8) != 0 ? auditLogState.webhooks : list2, (i & 16) != 0 ? auditLogState.integrations : list3, (i & 32) != 0 ? auditLogState.guildScheduledEvents : list4, (i & 64) != 0 ? auditLogState.threads : list5, (i & 128) != 0 ? auditLogState.selectedItemId : l, (i & 256) != 0 ? auditLogState.filter : auditLogFilter, (i & 512) != 0 ? auditLogState.deletedTargets : map2, (i & 1024) != 0 ? auditLogState.isLoading : z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Map<ModelAuditLogEntry.TargetType, Map<Long, CharSequence>> component10() {
            return this.deletedTargets;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final List<ModelAuditLogEntry> component3() {
            return this.entries;
        }

        public final List<ModelWebhook> component4() {
            return this.webhooks;
        }

        public final List<ModelGuildIntegration> component5() {
            return this.integrations;
        }

        public final List<GuildScheduledEvent> component6() {
            return this.guildScheduledEvents;
        }

        public final List<Channel> component7() {
            return this.threads;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getSelectedItemId() {
            return this.selectedItemId;
        }

        /* renamed from: component9, reason: from getter */
        public final AuditLogFilter getFilter() {
            return this.filter;
        }

        public final AuditLogState copy(long guildId, Map<Long, ? extends User> users, List<? extends ModelAuditLogEntry> entries, List<? extends ModelWebhook> webhooks, List<? extends ModelGuildIntegration> integrations, List<GuildScheduledEvent> guildScheduledEvents, List<Channel> threads, Long selectedItemId, AuditLogFilter filter, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, CharSequence>> deletedTargets, boolean isLoading) {
            m.checkNotNullParameter(users, "users");
            m.checkNotNullParameter(webhooks, "webhooks");
            m.checkNotNullParameter(integrations, "integrations");
            m.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
            m.checkNotNullParameter(threads, "threads");
            m.checkNotNullParameter(filter, "filter");
            m.checkNotNullParameter(deletedTargets, "deletedTargets");
            return new AuditLogState(guildId, users, entries, webhooks, integrations, guildScheduledEvents, threads, selectedItemId, filter, deletedTargets, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuditLogState)) {
                return false;
            }
            AuditLogState auditLogState = (AuditLogState) other;
            return this.guildId == auditLogState.guildId && m.areEqual(this.users, auditLogState.users) && m.areEqual(this.entries, auditLogState.entries) && m.areEqual(this.webhooks, auditLogState.webhooks) && m.areEqual(this.integrations, auditLogState.integrations) && m.areEqual(this.guildScheduledEvents, auditLogState.guildScheduledEvents) && m.areEqual(this.threads, auditLogState.threads) && m.areEqual(this.selectedItemId, auditLogState.selectedItemId) && m.areEqual(this.filter, auditLogState.filter) && m.areEqual(this.deletedTargets, auditLogState.deletedTargets) && this.isLoading == auditLogState.isLoading;
        }

        public final Map<ModelAuditLogEntry.TargetType, Map<Long, CharSequence>> getDeletedTargets() {
            return this.deletedTargets;
        }

        public final List<ModelAuditLogEntry> getEntries() {
            return this.entries;
        }

        public final AuditLogFilter getFilter() {
            return this.filter;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final List<GuildScheduledEvent> getGuildScheduledEvents() {
            return this.guildScheduledEvents;
        }

        public final List<ModelGuildIntegration> getIntegrations() {
            return this.integrations;
        }

        public final Long getSelectedItemId() {
            return this.selectedItemId;
        }

        public final List<Channel> getThreads() {
            return this.threads;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public final List<ModelWebhook> getWebhooks() {
            return this.webhooks;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            Map<Long, User> map = this.users;
            int iHashCode = (iA + (map != null ? map.hashCode() : 0)) * 31;
            List<ModelAuditLogEntry> list = this.entries;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<ModelWebhook> list2 = this.webhooks;
            int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<ModelGuildIntegration> list3 = this.integrations;
            int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
            List<GuildScheduledEvent> list4 = this.guildScheduledEvents;
            int iHashCode5 = (iHashCode4 + (list4 != null ? list4.hashCode() : 0)) * 31;
            List<Channel> list5 = this.threads;
            int iHashCode6 = (iHashCode5 + (list5 != null ? list5.hashCode() : 0)) * 31;
            Long l = this.selectedItemId;
            int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
            AuditLogFilter auditLogFilter = this.filter;
            int iHashCode8 = (iHashCode7 + (auditLogFilter != null ? auditLogFilter.hashCode() : 0)) * 31;
            Map<ModelAuditLogEntry.TargetType, Map<Long, CharSequence>> map2 = this.deletedTargets;
            int iHashCode9 = (iHashCode8 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.isLoading;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode9 + i;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = a.U("AuditLogState(guildId=");
            sbU.append(this.guildId);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", entries=");
            sbU.append(this.entries);
            sbU.append(", webhooks=");
            sbU.append(this.webhooks);
            sbU.append(", integrations=");
            sbU.append(this.integrations);
            sbU.append(", guildScheduledEvents=");
            sbU.append(this.guildScheduledEvents);
            sbU.append(", threads=");
            sbU.append(this.threads);
            sbU.append(", selectedItemId=");
            sbU.append(this.selectedItemId);
            sbU.append(", filter=");
            sbU.append(this.filter);
            sbU.append(", deletedTargets=");
            sbU.append(this.deletedTargets);
            sbU.append(", isLoading=");
            return a.O(sbU, this.isLoading, ")");
        }

        public /* synthetic */ AuditLogState(long j, Map map, List list, List list2, List list3, List list4, List list5, Long l, AuditLogFilter auditLogFilter, Map map2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? -1L : j, (i & 2) != 0 ? h0.emptyMap() : map, (i & 4) != 0 ? null : list, (i & 8) != 0 ? n.emptyList() : list2, (i & 16) != 0 ? n.emptyList() : list3, (i & 32) != 0 ? n.emptyList() : list4, (i & 64) != 0 ? n.emptyList() : list5, (i & 128) == 0 ? l : null, (i & 256) != 0 ? AuditLogFilter.INSTANCE.emptyFilter() : auditLogFilter, (i & 512) != 0 ? h0.emptyMap() : map2, (i & 1024) != 0 ? false : z2);
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$clearState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuditLog.access$clearStateInternal(StoreAuditLog.this);
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$fetchAuditLogIfNeeded$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            boolean z2 = this.$guildId != StoreAuditLog.access$getState$p(StoreAuditLog.this).getGuildId();
            boolean z3 = StoreAuditLog.access$getState$p(StoreAuditLog.this).getEntries() == null && !StoreAuditLog.access$getState$p(StoreAuditLog.this).isLoading();
            if (z2) {
                StoreAuditLog.access$clearStateInternal(StoreAuditLog.this);
            }
            if (z2 || z3) {
                StoreAuditLog storeAuditLog = StoreAuditLog.this;
                StoreAuditLog.access$fetchAuditLogs(storeAuditLog, this.$guildId, StoreAuditLog.access$getState$p(storeAuditLog).getFilter());
            }
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$fetchAuditLogs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreAuditLog.access$handleFetchFailure(StoreAuditLog.this);
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$fetchAuditLogs$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ModelAuditLog, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelAuditLog modelAuditLog) {
            invoke2(modelAuditLog);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelAuditLog modelAuditLog) {
            m.checkNotNullParameter(modelAuditLog, "newAuditLog");
            StoreAuditLog.access$handleFetchSuccess(StoreAuditLog.this, this.$guildId, modelAuditLog);
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$fetchMoreAuditLogEntries$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuditLog storeAuditLog = StoreAuditLog.this;
            StoreAuditLog.access$fetchAuditLogs(storeAuditLog, StoreAuditLog.access$getState$p(storeAuditLog).getGuildId(), StoreAuditLog.access$getState$p(StoreAuditLog.this).getFilter());
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$handleFetchFailure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuditLog storeAuditLog = StoreAuditLog.this;
            StoreAuditLog.access$setState$p(storeAuditLog, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog), 0L, null, null, null, null, null, null, null, null, null, false, AudioAttributesCompat.FLAG_ALL, null));
            StoreAuditLog.this.markChanged();
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$handleFetchSuccess$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ ModelAuditLog $newAuditLog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelAuditLog modelAuditLog, long j) {
            super(0);
            this.$newAuditLog = modelAuditLog;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$newAuditLog.getUsers() != null) {
                Map mutableMap = h0.toMutableMap(StoreAuditLog.access$getState$p(StoreAuditLog.this).getUsers());
                List<com.discord.api.user.User> users = this.$newAuditLog.getUsers();
                m.checkNotNullExpressionValue(users, "newAuditLog.users");
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(users, 10));
                for (com.discord.api.user.User user : users) {
                    m.checkNotNullExpressionValue(user, "it");
                    arrayList.add(new CoreUser(user));
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(arrayList, 10)), 16));
                for (Object obj : arrayList) {
                    linkedHashMap.put(Long.valueOf(((CoreUser) obj).getId()), obj);
                }
                mutableMap.putAll(linkedHashMap);
                StoreAuditLog storeAuditLog = StoreAuditLog.this;
                StoreAuditLog.access$setState$p(storeAuditLog, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog), 0L, mutableMap, null, null, null, null, null, null, null, null, false, 2045, null));
            }
            if (this.$newAuditLog.getWebhooks() != null) {
                List mutableList = u.toMutableList((Collection) StoreAuditLog.access$getState$p(StoreAuditLog.this).getWebhooks());
                List<ModelWebhook> webhooks = this.$newAuditLog.getWebhooks();
                m.checkNotNullExpressionValue(webhooks, "newAuditLog.webhooks");
                mutableList.addAll(webhooks);
                StoreAuditLog storeAuditLog2 = StoreAuditLog.this;
                StoreAuditLog.access$setState$p(storeAuditLog2, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog2), 0L, null, null, mutableList, null, null, null, null, null, null, false, 2039, null));
            }
            if (this.$newAuditLog.getIntegrations() != null) {
                List mutableList2 = u.toMutableList((Collection) StoreAuditLog.access$getState$p(StoreAuditLog.this).getIntegrations());
                List<ModelGuildIntegration> integrations = this.$newAuditLog.getIntegrations();
                m.checkNotNullExpressionValue(integrations, "newAuditLog.integrations");
                mutableList2.addAll(integrations);
                StoreAuditLog storeAuditLog3 = StoreAuditLog.this;
                StoreAuditLog.access$setState$p(storeAuditLog3, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog3), 0L, null, null, null, mutableList2, null, null, null, null, null, false, 2031, null));
            }
            if (this.$newAuditLog.getGuildScheduledEvents() != null) {
                StoreAuditLog storeAuditLog4 = StoreAuditLog.this;
                AuditLogState auditLogStateAccess$getState$p = StoreAuditLog.access$getState$p(storeAuditLog4);
                List<GuildScheduledEvent> guildScheduledEvents = StoreAuditLog.access$getState$p(StoreAuditLog.this).getGuildScheduledEvents();
                List<GuildScheduledEvent> guildScheduledEvents2 = this.$newAuditLog.getGuildScheduledEvents();
                m.checkNotNullExpressionValue(guildScheduledEvents2, "newAuditLog.guildScheduledEvents");
                StoreAuditLog.access$setState$p(storeAuditLog4, AuditLogState.copy$default(auditLogStateAccess$getState$p, 0L, null, null, null, null, u.plus((Collection) guildScheduledEvents, (Iterable) guildScheduledEvents2), null, null, null, null, false, 2015, null));
            }
            if (this.$newAuditLog.getThreads() != null) {
                StoreAuditLog storeAuditLog5 = StoreAuditLog.this;
                AuditLogState auditLogStateAccess$getState$p2 = StoreAuditLog.access$getState$p(storeAuditLog5);
                List<Channel> threads = StoreAuditLog.access$getState$p(StoreAuditLog.this).getThreads();
                List<Channel> threads2 = this.$newAuditLog.getThreads();
                m.checkNotNullExpressionValue(threads2, "newAuditLog.threads");
                StoreAuditLog.access$setState$p(storeAuditLog5, AuditLogState.copy$default(auditLogStateAccess$getState$p2, 0L, null, null, null, null, null, u.plus((Collection) threads, (Iterable) threads2), null, null, null, false, 1983, null));
            }
            List<ModelAuditLogEntry> entries = StoreAuditLog.access$getState$p(StoreAuditLog.this).getEntries();
            if (entries == null) {
                entries = n.emptyList();
            }
            List mutableList3 = u.toMutableList((Collection) entries);
            StoreAuditLog storeAuditLog6 = StoreAuditLog.this;
            long j = this.$guildId;
            List<ModelAuditLogEntry> auditLogEntries = this.$newAuditLog.getAuditLogEntries();
            m.checkNotNullExpressionValue(auditLogEntries, "newAuditLog.auditLogEntries");
            mutableList3.addAll(StoreAuditLog.access$transformEntries(storeAuditLog6, j, auditLogEntries));
            StoreAuditLog storeAuditLog7 = StoreAuditLog.this;
            StoreAuditLog.access$setState$p(storeAuditLog7, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog7), 0L, null, mutableList3, null, null, null, null, null, null, null, false, 2043, null));
            StoreAuditLog storeAuditLog8 = StoreAuditLog.this;
            StoreAuditLog.access$setState$p(storeAuditLog8, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog8), 0L, null, null, null, null, null, null, null, null, null, false, AudioAttributesCompat.FLAG_ALL, null));
            StoreAuditLog.this.markChanged();
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$observeAuditLogState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<AuditLogState> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ AuditLogState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AuditLogState invoke() {
            return StoreAuditLog.this.getAuditLogState(this.$guildId);
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$observeAuditLogState$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<AuditLogState> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(AuditLogState auditLogState) {
            call2(auditLogState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(AuditLogState auditLogState) {
            StoreAuditLog.this.fetchAuditLogIfNeeded(this.$guildId);
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$setAuditLogFilterActionId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ int $actionId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(0);
            this.$actionId = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$actionId != StoreAuditLog.access$getState$p(StoreAuditLog.this).getFilter().getActionFilter()) {
                StoreAuditLog storeAuditLog = StoreAuditLog.this;
                StoreAuditLog.access$setState$p(storeAuditLog, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog), 0L, null, null, null, null, null, null, null, null, null, false, 2043, null));
            }
            StoreAuditLog storeAuditLog2 = StoreAuditLog.this;
            StoreAuditLog.access$setState$p(storeAuditLog2, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog2), 0L, null, null, null, null, null, null, null, AuditLogFilter.copy$default(StoreAuditLog.access$getState$p(StoreAuditLog.this).getFilter(), 0L, this.$actionId, 1, null), null, false, 1791, null));
            StoreAuditLog.this.markChanged();
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$setAuditLogFilterUserId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$userId != StoreAuditLog.access$getState$p(StoreAuditLog.this).getFilter().getUserFilter()) {
                StoreAuditLog storeAuditLog = StoreAuditLog.this;
                StoreAuditLog.access$setState$p(storeAuditLog, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog), 0L, null, null, null, null, null, null, null, null, null, false, 2043, null));
            }
            StoreAuditLog storeAuditLog2 = StoreAuditLog.this;
            StoreAuditLog.access$setState$p(storeAuditLog2, AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog2), 0L, null, null, null, null, null, null, null, AuditLogFilter.copy$default(StoreAuditLog.access$getState$p(StoreAuditLog.this).getFilter(), this.$userId, 0, 2, null), null, false, 1791, null));
            StoreAuditLog.this.markChanged();
        }
    }

    /* compiled from: StoreAuditLog.kt */
    /* renamed from: com.discord.stores.StoreAuditLog$toggleSelectedState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $selectedItemId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$selectedItemId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuditLog storeAuditLog = StoreAuditLog.this;
            long j = this.$selectedItemId;
            Long selectedItemId = StoreAuditLog.access$getState$p(storeAuditLog).getSelectedItemId();
            StoreAuditLog.access$setState$p(storeAuditLog, (selectedItemId != null && j == selectedItemId.longValue()) ? AuditLogState.copy$default(StoreAuditLog.access$getState$p(StoreAuditLog.this), 0L, null, null, null, null, null, null, null, null, null, false, 1919, null) : AuditLogState.copy$default(StoreAuditLog.access$getState$p(StoreAuditLog.this), 0L, null, null, null, null, null, null, Long.valueOf(this.$selectedItemId), null, null, false, 1919, null));
            StoreAuditLog.this.markChanged();
        }
    }

    public StoreAuditLog(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        AuditLogState auditLogState = new AuditLogState(0L, null, null, null, null, null, null, null, null, null, false, 2047, null);
        this.state = auditLogState;
        this.stateSnapshot = auditLogState;
    }

    public static final /* synthetic */ void access$clearStateInternal(StoreAuditLog storeAuditLog) {
        storeAuditLog.clearStateInternal();
    }

    public static final /* synthetic */ void access$fetchAuditLogs(StoreAuditLog storeAuditLog, long j, AuditLogFilter auditLogFilter) {
        storeAuditLog.fetchAuditLogs(j, auditLogFilter);
    }

    public static final /* synthetic */ AuditLogState access$getState$p(StoreAuditLog storeAuditLog) {
        return storeAuditLog.state;
    }

    public static final /* synthetic */ void access$handleFetchFailure(StoreAuditLog storeAuditLog) {
        storeAuditLog.handleFetchFailure();
    }

    public static final /* synthetic */ void access$handleFetchSuccess(StoreAuditLog storeAuditLog, long j, ModelAuditLog modelAuditLog) {
        storeAuditLog.handleFetchSuccess(j, modelAuditLog);
    }

    public static final /* synthetic */ void access$setState$p(StoreAuditLog storeAuditLog, AuditLogState auditLogState) {
        storeAuditLog.state = auditLogState;
    }

    public static final /* synthetic */ List access$transformEntries(StoreAuditLog storeAuditLog, long j, List list) {
        return storeAuditLog.transformEntries(j, list);
    }

    @StoreThread
    private final void clearStateInternal() {
        this.cutoffTimestamp = null;
        this.state = new AuditLogState(0L, null, null, null, null, null, null, null, null, null, false, 2047, null);
        markChanged();
    }

    @StoreThread
    private final void fetchAuditLogs(long guildId, AuditLogFilter filter) {
        ModelAuditLogEntry modelAuditLogEntry;
        List<ModelAuditLogEntry> entries = this.state.getEntries();
        Long lValueOf = (entries == null || (modelAuditLogEntry = (ModelAuditLogEntry) u.lastOrNull((List) entries)) == null) ? null : Long.valueOf(modelAuditLogEntry.getId());
        if (this.cutoffTimestamp == null) {
            this.cutoffTimestamp = 0L;
        }
        if (m.areEqual(lValueOf, this.cutoffTimestamp)) {
            return;
        }
        this.cutoffTimestamp = lValueOf;
        this.state = AuditLogState.copy$default(this.state, guildId, null, null, null, null, null, null, null, null, null, true, 1022, null);
        markChanged();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getAuditLogs(guildId, lValueOf, Long.valueOf(filter.getUserFilter()), Integer.valueOf(filter.getActionFilter())), false, 1, null), StoreAuditLog.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(guildId), 54, (Object) null);
    }

    private final void handleFetchFailure() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    private final void handleFetchSuccess(long guildId, ModelAuditLog newAuditLog) {
        this.dispatcher.schedule(new AnonymousClass1(newAuditLog, guildId));
    }

    private final boolean shouldMergeEntries(ModelAuditLogEntry prevEntry, ModelAuditLogEntry entry, int numMerges, int timeWindowMins, int maxMerges) {
        if (prevEntry != null && prevEntry.getActionTypeId() == entry.getActionTypeId() && prevEntry.getTargetId() == entry.getTargetId() && prevEntry.getUserId() == entry.getUserId() && m.areEqual(prevEntry.getOptions(), entry.getOptions()) && numMerges < maxMerges && entry.getTargetType() != ModelAuditLogEntry.TargetType.INVITE && entry.getActionTypeId() != 72 && entry.getActionTypeId() != 73 && entry.getActionTypeId() != 26 && entry.getActionTypeId() != 27) {
            AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
            if (Math.abs(auditLogUtils.getTimestampStart(entry) - auditLogUtils.getTimestampStart(prevEntry)) < timeWindowMins * 60000) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean shouldMergeEntries$default(StoreAuditLog storeAuditLog, ModelAuditLogEntry modelAuditLogEntry, ModelAuditLogEntry modelAuditLogEntry2, int i, int i2, int i3, int i4, Object obj) {
        return storeAuditLog.shouldMergeEntries(modelAuditLogEntry, modelAuditLogEntry2, i, (i4 & 8) != 0 ? 30 : i2, (i4 & 16) != 0 ? 50 : i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final List<ModelAuditLogEntry> transformEntries(long guildId, List<? extends ModelAuditLogEntry> rawEntries) {
        ModelAuditLogEntry.Change change;
        ModelAuditLogEntry.Change change2;
        ModelAuditLogEntry.Options options;
        List<ModelAuditLogEntry.Change> changes;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i = 0;
            for (ModelAuditLogEntry modelAuditLogEntry : s.asReversed(rawEntries)) {
                ArrayList arrayList2 = new ArrayList();
                if (modelAuditLogEntry.getReason() != null) {
                    arrayList2.add(new ModelAuditLogEntry.Change(ModelAuditLogEntry.CHANGE_KEY_REASON, null, modelAuditLogEntry.getReason()));
                }
                List<ModelAuditLogEntry.Change> changes2 = modelAuditLogEntry.getChanges();
                if (changes2 != null) {
                    ModelAuditLogEntry.Change change3 = null;
                    ModelAuditLogEntry.Change change4 = null;
                    for (ModelAuditLogEntry.Change change5 : changes2) {
                        m.checkNotNullExpressionValue(change5, "change");
                        String key = change5.getKey();
                        if (key != null) {
                            switch (key.hashCode()) {
                                case 3079692:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionOverride(change5));
                                    }
                                    break;
                                case 92906313:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionOverride(change5));
                                    }
                                    break;
                                case 108404047:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionOverride(change5));
                                    }
                                    break;
                                case 1133704324:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionChange(change5));
                                    }
                                    break;
                            }
                        }
                        arrayList2.add(change5);
                        String key2 = change5.getKey();
                        if (key2 != null) {
                            int iHashCode = key2.hashCode();
                            if (iHashCode != 3373707) {
                                if (iHashCode == 3575610 && key2.equals("type")) {
                                    change4 = change5;
                                }
                            } else if (key2.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                change3 = change5;
                            }
                        }
                    }
                    change = change3;
                    change2 = change4;
                } else {
                    change = null;
                    change2 = null;
                }
                if (modelAuditLogEntry.getActionTypeId() == 21) {
                    ModelAuditLogEntry.Options options2 = modelAuditLogEntry.getOptions();
                    arrayList2.add(new ModelAuditLogEntry.Change(ModelAuditLogEntry.CHANGE_KEY_PRUNE_DELETE_DAYS, null, Integer.valueOf(options2 != null ? options2.getDeleteMemberDays() : 1)));
                }
                ModelAuditLogEntry modelAuditLogEntry2 = new ModelAuditLogEntry(modelAuditLogEntry.getId(), modelAuditLogEntry.getActionTypeId(), modelAuditLogEntry.getTargetId(), modelAuditLogEntry.getUserId(), arrayList2, modelAuditLogEntry.getOptions(), guildId, null);
                ModelAuditLogEntry modelAuditLogEntry3 = (ModelAuditLogEntry) u.firstOrNull((List) arrayList);
                List mutableList = null;
                if (shouldMergeEntries$default(this, modelAuditLogEntry3, modelAuditLogEntry2, i, 0, 0, 24, null)) {
                    long id2 = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getId() : modelAuditLogEntry2.getId();
                    int actionTypeId = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getActionTypeId() : modelAuditLogEntry2.getActionTypeId();
                    long targetId = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getTargetId() : modelAuditLogEntry2.getTargetId();
                    long userId = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getUserId() : modelAuditLogEntry2.getUserId();
                    if (modelAuditLogEntry3 != null && (changes = modelAuditLogEntry3.getChanges()) != null) {
                        mutableList = u.toMutableList((Collection) changes);
                    }
                    if (mutableList != null) {
                        List<ModelAuditLogEntry.Change> changes3 = modelAuditLogEntry2.getChanges();
                        if (changes3 == null) {
                            changes3 = n.emptyList();
                        }
                        mutableList.addAll(changes3);
                    } else {
                        modelAuditLogEntry2.getChanges();
                    }
                    if (modelAuditLogEntry3 == null || (options = modelAuditLogEntry3.getOptions()) == null) {
                        options = modelAuditLogEntry2.getOptions();
                    }
                    arrayList.set(0, new ModelAuditLogEntry(id2, actionTypeId, targetId, userId, mutableList, options, guildId, Long.valueOf(AuditLogUtils.INSTANCE.getTimestampStart(modelAuditLogEntry2))));
                    i++;
                } else {
                    Map mutableMap = h0.toMutableMap(this.state.getDeletedTargets());
                    if (modelAuditLogEntry2.getActionType() == ModelAuditLogEntry.ActionType.DELETE && change != null) {
                        String str = (String) change.getOldValue();
                        if (modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL) {
                            if (m.areEqual(change2 != null ? change2.getOldValue() : null, (Object) 0)) {
                                str = MentionUtilsKt.CHANNELS_CHAR + str;
                            }
                        }
                        if (mutableMap.get(modelAuditLogEntry2.getTargetType()) == null) {
                            ModelAuditLogEntry.TargetType targetType = modelAuditLogEntry2.getTargetType();
                            m.checkNotNullExpressionValue(targetType, "entry.targetType");
                            mutableMap.put(targetType, h0.mutableMapOf(d0.o.to(Long.valueOf(modelAuditLogEntry2.getTargetId()), str)));
                        } else {
                            Map map = (Map) mutableMap.get(modelAuditLogEntry2.getTargetType());
                            if (map != null) {
                            }
                        }
                        this.state = AuditLogState.copy$default(this.state, 0L, null, null, null, null, null, null, null, null, mutableMap, false, 1535, null);
                    }
                    arrayList.add(0, modelAuditLogEntry2);
                }
            }
            return arrayList;
        }
    }

    public final void clearState() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void fetchAuditLogIfNeeded(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void fetchMoreAuditLogEntries() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final AuditLogState getAuditLogState(long guildId) {
        AuditLogState auditLogState = this.stateSnapshot;
        if (guildId == auditLogState.getGuildId()) {
            return auditLogState;
        }
        return null;
    }

    public final Observable<AuditLogState> observeAuditLogState(long guildId) {
        Observable observableU = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r().u(new AnonymousClass2(guildId));
        m.checkNotNullExpressionValue(observableU, "observationDeck.connectR…ditLogIfNeeded(guildId) }");
        Observable<AuditLogState> observableG = observableU.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        return observableG;
    }

    public final void setAuditLogFilterActionId(int actionId) {
        this.dispatcher.schedule(new AnonymousClass1(actionId));
    }

    public final void setAuditLogFilterUserId(long userId) {
        this.dispatcher.schedule(new AnonymousClass1(userId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        AuditLogState auditLogState = this.state;
        HashMap map = new HashMap(this.state.getUsers());
        List<ModelAuditLogEntry> entries = this.state.getEntries();
        ArrayList arrayList = entries != null ? new ArrayList(entries) : null;
        ArrayList arrayList2 = new ArrayList(this.state.getWebhooks());
        ArrayList arrayList3 = new ArrayList(this.state.getIntegrations());
        ArrayList arrayList4 = new ArrayList(this.state.getGuildScheduledEvents());
        ArrayList arrayList5 = new ArrayList(this.state.getThreads());
        Map<ModelAuditLogEntry.TargetType, Map<Long, CharSequence>> deletedTargets = this.state.getDeletedTargets();
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(deletedTargets.size()));
        Iterator<T> it = deletedTargets.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), new HashMap((Map) entry.getValue()));
        }
        this.stateSnapshot = AuditLogState.copy$default(auditLogState, 0L, map, arrayList, arrayList2, arrayList3, arrayList4, arrayList5, null, null, linkedHashMap, false, 1409, null);
    }

    public final void toggleSelectedState(long selectedItemId) {
        this.dispatcher.schedule(new AnonymousClass1(selectedItemId));
    }
}
