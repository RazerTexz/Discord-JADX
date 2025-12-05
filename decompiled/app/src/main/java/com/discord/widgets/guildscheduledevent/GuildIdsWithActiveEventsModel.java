package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Maps;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: GuildIdsWithActiveEventsModel.kt */
/* loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel {
    public static final GuildIdsWithActiveEventsModel INSTANCE = new GuildIdsWithActiveEventsModel();

    /* compiled from: GuildIdsWithActiveEventsModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1 */
    public static final class C88091 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ StoreGuildScheduledEvents $storeGuildScheduledEvents;

        /* compiled from: GuildIdsWithActiveEventsModel.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> entry) {
                return Boolean.valueOf(invoke2((Map.Entry<Long, ? extends List<GuildScheduledEvent>>) entry));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Map.Entry<Long, ? extends List<GuildScheduledEvent>> entry) {
                Intrinsics3.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                List<GuildScheduledEvent> value = entry.getValue();
                if (!(value instanceof Collection) || !value.isEmpty()) {
                    Iterator<T> it = value.iterator();
                    while (it.hasNext()) {
                        if (((GuildScheduledEvent) it.next()).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        /* compiled from: GuildIdsWithActiveEventsModel.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Long> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> entry) {
                return Long.valueOf(invoke2((Map.Entry<Long, ? extends List<GuildScheduledEvent>>) entry));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2(Map.Entry<Long, ? extends List<GuildScheduledEvent>> entry) {
                Intrinsics3.checkNotNullParameter(entry, "entry");
                return entry.getKey().longValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88091(StoreGuildScheduledEvents storeGuildScheduledEvents) {
            super(0);
            this.$storeGuildScheduledEvents = storeGuildScheduledEvents;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Maps.asSequence(this.$storeGuildScheduledEvents.getAllGuildScheduledEvents()), AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
        }
    }

    private GuildIdsWithActiveEventsModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithActiveEventsModel guildIdsWithActiveEventsModel, StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
        }
        if ((i & 2) != 0) {
            observationDeck = ObservationDeck4.get();
        }
        return guildIdsWithActiveEventsModel.observe(storeGuildScheduledEvents, observationDeck);
    }

    public final Observable<Set<Long>> observe(StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildScheduledEvents}, false, null, null, new C88091(storeGuildScheduledEvents), 14, null);
    }
}
