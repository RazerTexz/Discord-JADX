package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionDirectoryGuildEntryDelete;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.directory.DirectoryEntryGuild3;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreDirectories.kt */
/* loaded from: classes2.dex */
public final class StoreDirectories extends StoreV2 {
    private static final String DISCORD_HUB_VERIFICATION_CLICKED_KEY = "hub_verification_clicked_key";
    private static final String GUILD_SCHEDULED_EVENTS_HEADER_DISMISSED = "guild_scheduled_events_header_dismissed";
    private static final String HUB_NAME_PROMPT = "hub_name_prompt";
    private Map<Long, RestCallState<List<DirectoryEntryGuild>>> directoriesMap;
    private Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> directoriesMapSnapshot;
    private Map<Long, RestCallState<List<DirectoryEntryGuild2>>> directoryGuildScheduledEventsMap;
    private Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild2>>> directoryGuildScheduledEventsMapSnapshot;
    private final Persister<Boolean> discordHubClickedPersister;
    private final Dispatcher dispatcher;
    private Map<Long, RestCallState<Map<Integer, Integer>>> entryCountMap;
    private Map<Long, ? extends RestCallState<? extends Map<Integer, Integer>>> entryCountMapSnapshot;
    private final Persister<Boolean> guildScheduledEventsHeaderDismissed;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StoreGuilds guildStore;
    private final Persister<Set<Long>> hubNamePromptPersister;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$addServerToDirectory$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ DirectoryEntryGuild $directoryEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, DirectoryEntryGuild directoryEntryGuild) {
            super(0);
            this.$channelId = j;
            this.$directoryEntry = directoryEntryGuild;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map mapAccess$getDirectoriesMap$p = StoreDirectories.access$getDirectoriesMap$p(StoreDirectories.this);
            Long lValueOf = Long.valueOf(this.$channelId);
            RestCallState restCallState = (RestCallState) StoreDirectories.access$getDirectoriesMap$p(StoreDirectories.this).get(Long.valueOf(this.$channelId));
            List<DirectoryEntryGuild> listEmptyList = restCallState != null ? (List) restCallState.invoke() : null;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
            boolean z2 = false;
            for (DirectoryEntryGuild directoryEntryGuild : listEmptyList) {
                if (directoryEntryGuild.getGuild().getId() == this.$directoryEntry.getGuild().getId()) {
                    z2 = true;
                    directoryEntryGuild = this.$directoryEntry;
                }
                arrayList.add(directoryEntryGuild);
            }
            mapAccess$getDirectoriesMap$p.put(lValueOf, new RestCallState6(_Collections.plus((Collection) arrayList, (Iterable) Collections2.listOfNotNull(z2 ? null : this.$directoryEntry))));
            StoreDirectories.this.markChanged();
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$fetchDirectoriesForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends DirectoryEntryGuild>, List<? extends DirectoryEntryGuild>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends DirectoryEntryGuild> call(List<? extends DirectoryEntryGuild> list) {
            return call2((List<DirectoryEntryGuild>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<DirectoryEntryGuild> call2(List<DirectoryEntryGuild> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "entries");
            return _Collections.sortedWith(list, new StoreDirectories$fetchDirectoriesForChannel$1$$special$$inlined$sortedByDescending$1());
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$fetchDirectoriesForChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild>>, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreDirectories.kt */
        /* renamed from: com.discord.stores.StoreDirectories$fetchDirectoriesForChannel$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ RestCallState $entriesResponse;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestCallState restCallState) {
                super(0);
                this.$entriesResponse = restCallState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreDirectories.access$getDirectoriesMap$p(StoreDirectories.this).put(Long.valueOf(AnonymousClass2.this.$channelId), this.$entriesResponse);
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState) {
            invoke2((RestCallState<? extends List<DirectoryEntryGuild>>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "entriesResponse");
            StoreDirectories.access$getDispatcher$p(StoreDirectories.this).schedule(new AnonymousClass1(restCallState));
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$fetchEntryCountsForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends Map<Integer, ? extends Integer>>, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreDirectories.kt */
        /* renamed from: com.discord.stores.StoreDirectories$fetchEntryCountsForChannel$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01071 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ RestCallState $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01071(RestCallState restCallState) {
                super(0);
                this.$response = restCallState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreDirectories.access$getEntryCountMap$p(StoreDirectories.this).put(Long.valueOf(AnonymousClass1.this.$channelId), this.$response);
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends Map<Integer, ? extends Integer>> restCallState) {
            invoke2((RestCallState<? extends Map<Integer, Integer>>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends Map<Integer, Integer>> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "response");
            StoreDirectories.access$getDispatcher$p(StoreDirectories.this).schedule(new C01071(restCallState));
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$fetchGuildScheduledEventsForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild2>>, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreDirectories.kt */
        /* renamed from: com.discord.stores.StoreDirectories$fetchGuildScheduledEventsForChannel$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01081 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ RestCallState $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01081(RestCallState restCallState) {
                super(0);
                this.$response = restCallState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreDirectories.access$getDirectoryGuildScheduledEventsMap$p(StoreDirectories.this).put(Long.valueOf(AnonymousClass1.this.$channelId), this.$response);
                RestCallState restCallState = this.$response;
                if (restCallState instanceof RestCallState6) {
                    Iterable iterable = (Iterable) ((RestCallState6) restCallState).invoke();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        GuildScheduledEvent guildScheduledEvent = ((DirectoryEntryGuild2) it.next()).getGuildScheduledEvent();
                        if (!(guildScheduledEvent.getUserRsvp() != null)) {
                            guildScheduledEvent = null;
                        }
                        Tuples2 tuples2 = guildScheduledEvent != null ? Tuples.to(Long.valueOf(guildScheduledEvent.getGuildId()), Long.valueOf(guildScheduledEvent.getId())) : null;
                        if (tuples2 != null) {
                            arrayList.add(tuples2);
                        }
                    }
                    StoreDirectories.access$getGuildScheduledEventsStore$p(StoreDirectories.this).addMeRsvpsForEvent(arrayList);
                }
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild2>> restCallState) {
            invoke2((RestCallState<? extends List<DirectoryEntryGuild2>>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild2>> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "response");
            StoreDirectories.access$getDispatcher$p(StoreDirectories.this).schedule(new C01081(restCallState));
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Guild>, Set<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, Guild> map) {
            Collection<Guild> collectionValues = map.values();
            ArrayList arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (((Guild) t).isHub()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((Guild) it.next()).getId()));
            }
            return _Collections.toSet(arrayList2);
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Set<? extends Long>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            Set set2 = (Set) StoreDirectories.access$getHubNamePromptPersister$p(StoreDirectories.this).get();
            Persister persisterAccess$getHubNamePromptPersister$p = StoreDirectories.access$getHubNamePromptPersister$p(StoreDirectories.this);
            ArrayList arrayList = new ArrayList();
            for (Object obj : set2) {
                if (set.contains(Long.valueOf(((Number) obj).longValue()))) {
                    arrayList.add(obj);
                }
            }
            Persister.set$default(persisterAccess$getHubNamePromptPersister$p, _Collections.toSet(arrayList), false, 2, null);
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$observeDirectories$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>> invoke2() {
            return StoreDirectories.access$getDirectoriesMapSnapshot$p(StoreDirectories.this);
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$observeDirectoriesForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<RestCallState<? extends List<? extends DirectoryEntryGuild>>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ RestCallState<? extends List<? extends DirectoryEntryGuild>> invoke2() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final RestCallState<? extends List<? extends DirectoryEntryGuild>> invoke() {
            return (RestCallState) StoreDirectories.access$getDirectoriesMapSnapshot$p(StoreDirectories.this).get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$observeDirectoryGuildScheduledEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild2>>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild2>>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild2>>> invoke2() {
            return StoreDirectories.access$getDirectoryGuildScheduledEventsMapSnapshot$p(StoreDirectories.this);
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$removeServerFromDirectory$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<DirectoryEntryGuild, TrackNetworkMetadata2> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$guildId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(DirectoryEntryGuild directoryEntryGuild) {
            return invoke2(directoryEntryGuild);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(DirectoryEntryGuild directoryEntryGuild) {
            return new TrackNetworkActionDirectoryGuildEntryDelete(Long.valueOf(this.$channelId), Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreDirectories.kt */
    /* renamed from: com.discord.stores.StoreDirectories$removeServerFromDirectory$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends DirectoryEntryGuild>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreDirectories.kt */
        /* renamed from: com.discord.stores.StoreDirectories$removeServerFromDirectory$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                Map mapAccess$getDirectoriesMap$p = StoreDirectories.access$getDirectoriesMap$p(StoreDirectories.this);
                Long lValueOf = Long.valueOf(AnonymousClass2.this.$channelId);
                RestCallState restCallState = (RestCallState) StoreDirectories.access$getDirectoriesMap$p(StoreDirectories.this).get(Long.valueOf(AnonymousClass2.this.$channelId));
                List listEmptyList = restCallState != null ? (List) restCallState.invoke() : null;
                if (listEmptyList == null) {
                    listEmptyList = Collections2.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : listEmptyList) {
                    GuildPreview guild = ((DirectoryEntryGuild) obj).getGuild();
                    if (guild == null || guild.getId() != AnonymousClass2.this.$guildId) {
                        arrayList.add(obj);
                    }
                }
                mapAccess$getDirectoriesMap$p.put(lValueOf, new RestCallState6(arrayList));
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$guildId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends DirectoryEntryGuild> restCallState) {
            invoke2((RestCallState<DirectoryEntryGuild>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<DirectoryEntryGuild> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "request");
            if (restCallState instanceof RestCallState6) {
                StoreDirectories.access$getDispatcher$p(StoreDirectories.this).schedule(new AnonymousClass1());
            }
        }
    }

    public /* synthetic */ StoreDirectories(Dispatcher dispatcher, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildScheduledEvents storeGuildScheduledEvents, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, observationDeck, storeGuilds, storeGuildScheduledEvents, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Map access$getDirectoriesMap$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoriesMap;
    }

    public static final /* synthetic */ Map access$getDirectoriesMapSnapshot$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoriesMapSnapshot;
    }

    public static final /* synthetic */ Map access$getDirectoryGuildScheduledEventsMap$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoryGuildScheduledEventsMap;
    }

    public static final /* synthetic */ Map access$getDirectoryGuildScheduledEventsMapSnapshot$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoryGuildScheduledEventsMapSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreDirectories storeDirectories) {
        return storeDirectories.dispatcher;
    }

    public static final /* synthetic */ Map access$getEntryCountMap$p(StoreDirectories storeDirectories) {
        return storeDirectories.entryCountMap;
    }

    public static final /* synthetic */ StoreGuildScheduledEvents access$getGuildScheduledEventsStore$p(StoreDirectories storeDirectories) {
        return storeDirectories.guildScheduledEventsStore;
    }

    public static final /* synthetic */ Persister access$getHubNamePromptPersister$p(StoreDirectories storeDirectories) {
        return storeDirectories.hubNamePromptPersister;
    }

    public static final /* synthetic */ void access$setDirectoriesMap$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoriesMap = map;
    }

    public static final /* synthetic */ void access$setDirectoriesMapSnapshot$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoriesMapSnapshot = map;
    }

    public static final /* synthetic */ void access$setDirectoryGuildScheduledEventsMap$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoryGuildScheduledEventsMap = map;
    }

    public static final /* synthetic */ void access$setDirectoryGuildScheduledEventsMapSnapshot$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoryGuildScheduledEventsMapSnapshot = map;
    }

    public static final /* synthetic */ void access$setEntryCountMap$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.entryCountMap = map;
    }

    public final void addServerToDirectory(long channelId, DirectoryEntryGuild directoryEntry) {
        Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
        this.dispatcher.schedule(new AnonymousClass1(channelId, directoryEntry));
    }

    public final void fetchDirectoriesForChannel(long channelId) {
        Observable<R> observableG = this.restApi.getDirectoryEntries(channelId).G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "restApi\n        .getDire…imateMemberCount ?: 0 } }");
        RestCallState5.executeRequest(observableG, new AnonymousClass2(channelId));
    }

    public final void fetchEntryCountsForChannel(long channelId) {
        RestCallState5.executeRequest(this.restApi.getEntryCounts(channelId), new AnonymousClass1(channelId));
    }

    public final void fetchGuildScheduledEventsForChannel(long guildId, long channelId) {
        if (GrowthTeamFeatures.INSTANCE.hubEventsEnabled(guildId, false)) {
            RestCallState5.executeRequest(this.restApi.getDirectoryGuildScheduledEvents(channelId, DirectoryEntryGuild3.GuildScheduledEvent.getKey()), new AnonymousClass1(channelId));
        }
    }

    public final boolean getAndSetSeenNamePrompt(long guildId) {
        boolean zContains = this.hubNamePromptPersister.get().contains(Long.valueOf(guildId));
        Persister<Set<Long>> persister = this.hubNamePromptPersister;
        persister.set(_Sets.plus(persister.get(), Long.valueOf(guildId)), true);
        return zContains;
    }

    public final RestCallState<List<DirectoryEntryGuild>> getDirectoriesForChannel(long channelId) {
        return (RestCallState) this.directoriesMapSnapshot.get(Long.valueOf(channelId));
    }

    public final RestCallState<Map<Integer, Integer>> getEntryCountsForChannel(long channelId) {
        return (RestCallState) this.entryCountMapSnapshot.get(Long.valueOf(channelId));
    }

    public final RestCallState<List<DirectoryEntryGuild2>> getGuildScheduledEventsForChannel(long channelId) {
        return (RestCallState) this.directoryGuildScheduledEventsMapSnapshot.get(Long.valueOf(channelId));
    }

    public final boolean getGuildScheduledEventsHeaderDismissed() {
        return this.guildScheduledEventsHeaderDismissed.get().booleanValue();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Observable observableR = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(this.guildStore.observeGuilds(), 1L, TimeUnit.SECONDS)).G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "guildStore\n        .obse…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, StoreDirectories.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public final void markDiscordHubClicked() {
        this.discordHubClickedPersister.set(Boolean.TRUE, true);
    }

    public final void markGuildScheduledEventsHeaderDismissed() {
        this.guildScheduledEventsHeaderDismissed.set(Boolean.TRUE, true);
    }

    public final Observable<Map<Long, RestCallState<List<DirectoryEntryGuild>>>> observeDirectories() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<RestCallState<List<DirectoryEntryGuild>>> observeDirectoriesForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<Map<Long, RestCallState<List<DirectoryEntryGuild2>>>> observeDirectoryGuildScheduledEvents() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeDiscordHubClicked() {
        Observable<Boolean> observableR = this.discordHubClickedPersister.getObservable().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "discordHubClickedPersist…  .distinctUntilChanged()");
        return observableR;
    }

    public final void removeServerFromDirectory(long channelId, long guildId) {
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(this.restApi.removeServerFromHub(channelId, guildId), new AnonymousClass1(channelId, guildId)), new AnonymousClass2(channelId, guildId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        this.directoriesMapSnapshot = new HashMap(this.directoriesMap);
        this.entryCountMapSnapshot = new HashMap(this.entryCountMap);
        this.directoryGuildScheduledEventsMapSnapshot = new HashMap(this.directoryGuildScheduledEventsMap);
    }

    public StoreDirectories(Dispatcher dispatcher, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildScheduledEvents storeGuildScheduledEvents, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildStore = storeGuilds;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.restApi = restAPI;
        this.directoriesMapSnapshot = Maps6.emptyMap();
        this.directoriesMap = new LinkedHashMap();
        this.entryCountMapSnapshot = Maps6.emptyMap();
        this.entryCountMap = new LinkedHashMap();
        this.directoryGuildScheduledEventsMapSnapshot = Maps6.emptyMap();
        this.directoryGuildScheduledEventsMap = new LinkedHashMap();
        Boolean bool = Boolean.FALSE;
        this.discordHubClickedPersister = new Persister<>(DISCORD_HUB_VERIFICATION_CLICKED_KEY, bool);
        this.guildScheduledEventsHeaderDismissed = new Persister<>(GUILD_SCHEDULED_EVENTS_HEADER_DISMISSED, bool);
        this.hubNamePromptPersister = new Persister<>(HUB_NAME_PROMPT, Sets5.emptySet());
    }
}
