package com.discord.stores;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreGuildRoleMemberCounts.kt */
/* loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts extends StoreV2 {
    private static final int CACHE_TIME_MS = 120000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Map<Long, ? extends Map<Long, Integer>> guildMemberCountsSnapshot;
    private final HashMap<Long, Long> guildRoleMemberCountFetchTimes;
    private final HashMap<Long, Map<Long, Integer>> guildRoleMemberCounts;
    private final RestAPI restApi;

    /* compiled from: StoreGuildRoleMemberCounts.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCounts$1, reason: invalid class name */
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
            StoreGuildRoleMemberCounts.access$fetchGuildRoleMemberCountsIfNecessary(StoreGuildRoleMemberCounts.this, this.$guildId);
        }
    }

    /* compiled from: StoreGuildRoleMemberCounts.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Map<Long, ? extends Integer>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Integer> map) {
            invoke2((Map<Long, Integer>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Integer> map) {
            if (map != null) {
                StoreGuildRoleMemberCounts.access$getDispatcher$p(StoreGuildRoleMemberCounts.this).schedule(new StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$$special$$inlined$let$lambda$1(map, this));
            }
        }
    }

    /* compiled from: StoreGuildRoleMemberCounts.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleMemberCounts.kt */
        /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2$1, reason: invalid class name */
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
                StoreGuildRoleMemberCounts.access$getGuildRoleMemberCountFetchTimes$p(StoreGuildRoleMemberCounts.this).remove(Long.valueOf(AnonymousClass2.this.$guildId));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGuildRoleMemberCounts.access$getDispatcher$p(StoreGuildRoleMemberCounts.this).schedule(new AnonymousClass1());
        }
    }

    public /* synthetic */ StoreGuildRoleMemberCounts(Dispatcher dispatcher, Clock clock, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$fetchGuildRoleMemberCountsIfNecessary(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts, long j) {
        storeGuildRoleMemberCounts.fetchGuildRoleMemberCountsIfNecessary(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildRoleMemberCountFetchTimes$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.guildRoleMemberCountFetchTimes;
    }

    public static final /* synthetic */ HashMap access$getGuildRoleMemberCounts$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.guildRoleMemberCounts;
    }

    @StoreThread
    private final void fetchGuildRoleMemberCountsIfNecessary(long guildId) {
        Long l = this.guildRoleMemberCountFetchTimes.get(Long.valueOf(guildId));
        if (this.guildRoleMemberCounts.get(Long.valueOf(guildId)) == null || l == null || this.clock.currentTimeMillis() - l.longValue() >= CACHE_TIME_MS) {
            this.guildRoleMemberCountFetchTimes.put(Long.valueOf(guildId), Long.valueOf(this.clock.currentTimeMillis()));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getGuildRoleMemberCounts(guildId), false, 1, null), StoreGuildRoleMemberCounts.class, (Context) null, (Function1) null, new AnonymousClass2(guildId), (Function0) null, (Function0) null, new AnonymousClass1(guildId), 54, (Object) null);
        }
    }

    public final void fetchGuildRoleMemberCounts(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Map<Long, Integer> getGuildRoleMemberCounts(long guildId) {
        return this.guildMemberCountsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        this.guildRoleMemberCounts.remove(Long.valueOf(guildId));
        this.guildRoleMemberCountFetchTimes.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.guildMemberCountsSnapshot = new HashMap(this.guildRoleMemberCounts);
    }

    public StoreGuildRoleMemberCounts(Dispatcher dispatcher, Clock clock, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restApi = restAPI;
        this.guildRoleMemberCounts = new HashMap<>();
        this.guildMemberCountsSnapshot = h0.emptyMap();
        this.guildRoleMemberCountFetchTimes = new HashMap<>();
    }
}
