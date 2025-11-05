package com.discord.widgets.stage;

import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import d0.f0.q;
import d0.t.i0;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
/* loaded from: classes2.dex */
public final class GuildIdsWithVisibleStageInstanceModel {
    public static final GuildIdsWithVisibleStageInstanceModel INSTANCE = new GuildIdsWithVisibleStageInstanceModel();

    /* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    /* renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$compute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Boolean> {
        public final /* synthetic */ Map $permissionsByChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(1);
            this.$permissionsByChannel = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> entry) {
            return Boolean.valueOf(invoke2((Map.Entry<Long, ? extends Map<Long, StageInstance>>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Map.Entry<Long, ? extends Map<Long, StageInstance>> entry) {
            int i;
            m.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
            entry.getKey().longValue();
            Set<Long> setKeySet = entry.getValue().keySet();
            if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = setKeySet.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) this.$permissionsByChannel.get(Long.valueOf(((Number) it.next()).longValue()))) && (i = i + 1) < 0) {
                        n.throwCountOverflow();
                    }
                }
            }
            return i > 0;
        }
    }

    /* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    /* renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$compute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> entry) {
            return Long.valueOf(invoke2((Map.Entry<Long, ? extends Map<Long, StageInstance>>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2(Map.Entry<Long, ? extends Map<Long, StageInstance>> entry) {
            m.checkNotNullParameter(entry, "entry");
            return entry.getKey().longValue();
        }
    }

    /* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    /* renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$observe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Set<? extends Long>> {
        public final /* synthetic */ StorePermissions $storePermissions;
        public final /* synthetic */ StoreStageInstances $storeStageInstances;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreStageInstances storeStageInstances, StorePermissions storePermissions) {
            super(0);
            this.$storeStageInstances = storeStageInstances;
            this.$storePermissions = storePermissions;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return GuildIdsWithVisibleStageInstanceModel.INSTANCE.compute(this.$storeStageInstances.getStageInstancesByGuild(), this.$storePermissions.getPermissionsByChannel());
        }
    }

    private GuildIdsWithVisibleStageInstanceModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithVisibleStageInstanceModel guildIdsWithVisibleStageInstanceModel, StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeStageInstances = StoreStream.INSTANCE.getStageInstances();
        }
        if ((i & 2) != 0) {
            storePermissions = StoreStream.INSTANCE.getPermissions();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return guildIdsWithVisibleStageInstanceModel.observe(storeStageInstances, storePermissions, observationDeck);
    }

    public final Set<Long> compute(Map<Long, ? extends Map<Long, StageInstance>> instancesByGuild, Map<Long, Long> permissionsByChannel) {
        m.checkNotNullParameter(instancesByGuild, "instancesByGuild");
        m.checkNotNullParameter(permissionsByChannel, "permissionsByChannel");
        return q.toSet(q.map(q.filter(i0.asSequence(instancesByGuild), new AnonymousClass1(permissionsByChannel)), AnonymousClass2.INSTANCE));
    }

    public final Observable<Set<Long>> observe(StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeStageInstances, storePermissions}, false, null, null, new AnonymousClass1(storeStageInstances, storePermissions), 14, null);
    }
}
