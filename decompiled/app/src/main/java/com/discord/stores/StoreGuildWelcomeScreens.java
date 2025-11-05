package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.t.n0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildWelcomeScreens.kt */
/* loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens extends StoreV2 {
    private final Dispatcher dispatcher;
    private final HashSet<Long> guildWelcomeScreensSeen;
    private Set<Long> guildWelcomeScreensSeenSnapshot;
    private Map<Long, ? extends State> guildWelcomeScreensSnapshot;
    private final HashMap<Long, State> guildWelcomeScreensState;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreGuildWelcomeScreens.kt */
    public static abstract class State {

        /* compiled from: StoreGuildWelcomeScreens.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGuildWelcomeScreens.kt */
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* compiled from: StoreGuildWelcomeScreens.kt */
        public static final /* data */ class Loaded extends State {
            private final GuildWelcomeScreen data;

            public Loaded(GuildWelcomeScreen guildWelcomeScreen) {
                super(null);
                this.data = guildWelcomeScreen;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, GuildWelcomeScreen guildWelcomeScreen, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildWelcomeScreen = loaded.data;
                }
                return loaded.copy(guildWelcomeScreen);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildWelcomeScreen getData() {
                return this.data;
            }

            public final Loaded copy(GuildWelcomeScreen data) {
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final GuildWelcomeScreen getData() {
                return this.data;
            }

            public int hashCode() {
                GuildWelcomeScreen guildWelcomeScreen = this.data;
                if (guildWelcomeScreen != null) {
                    return guildWelcomeScreen.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(data=");
                sbU.append(this.data);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildWelcomeScreens.kt */
        /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02571 extends o implements Function1<GuildWelcomeScreen, Unit> {

            /* compiled from: StoreGuildWelcomeScreens.kt */
            /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02581 extends o implements Function0<Unit> {
                public final /* synthetic */ GuildWelcomeScreen $guildWelcomeScreen;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02581(GuildWelcomeScreen guildWelcomeScreen) {
                    super(0);
                    this.$guildWelcomeScreen = guildWelcomeScreen;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildWelcomeScreens.access$handleGuildWelcomeScreen(StoreGuildWelcomeScreens.this, anonymousClass1.$guildId, this.$guildWelcomeScreen);
                }
            }

            public C02571() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildWelcomeScreen guildWelcomeScreen) {
                invoke2(guildWelcomeScreen);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildWelcomeScreen guildWelcomeScreen) {
                m.checkNotNullParameter(guildWelcomeScreen, "guildWelcomeScreen");
                StoreGuildWelcomeScreens.access$getDispatcher$p(StoreGuildWelcomeScreens.this).schedule(new C02581(guildWelcomeScreen));
            }
        }

        /* compiled from: StoreGuildWelcomeScreens.kt */
        /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {

            /* compiled from: StoreGuildWelcomeScreens.kt */
            /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02591 extends o implements Function0<Unit> {
                public C02591() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildWelcomeScreens.access$handleGuildWelcomeScreenFetchFailed(StoreGuildWelcomeScreens.this, anonymousClass1.$guildId);
                }
            }

            public AnonymousClass2() {
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
                StoreGuildWelcomeScreens.access$getDispatcher$p(StoreGuildWelcomeScreens.this).schedule(new C02591());
            }
        }

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
            State state = (State) StoreGuildWelcomeScreens.access$getGuildWelcomeScreensState$p(StoreGuildWelcomeScreens.this).get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildWelcomeScreens.access$handleGuildWelcomeScreenFetchStart(StoreGuildWelcomeScreens.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildWelcomeScreen(this.$guildId), false), StoreGuildWelcomeScreens.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C02571(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$markWelcomeScreenShown$1, reason: invalid class name */
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
            if (StoreGuildWelcomeScreens.access$getGuildWelcomeScreensSeen$p(StoreGuildWelcomeScreens.this).contains(Long.valueOf(this.$guildId))) {
                return;
            }
            StoreGuildWelcomeScreens.access$getGuildWelcomeScreensSeen$p(StoreGuildWelcomeScreens.this).add(Long.valueOf(this.$guildId));
            StoreGuildWelcomeScreens.this.markChanged();
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<State> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGuildWelcomeScreens.this.getGuildWelcomeScreen(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.dispatcher;
    }

    public static final /* synthetic */ HashSet access$getGuildWelcomeScreensSeen$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.guildWelcomeScreensSeen;
    }

    public static final /* synthetic */ HashMap access$getGuildWelcomeScreensState$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.guildWelcomeScreensState;
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreen(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j, GuildWelcomeScreen guildWelcomeScreen) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreen(j, guildWelcomeScreen);
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreenFetchFailed(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreenFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreenFetchStart(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreenFetchStart(j);
    }

    @StoreThread
    private final void handleGuildWelcomeScreen(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), new State.Loaded(guildWelcomeScreen));
        markChanged();
    }

    @StoreThread
    private final void handleGuildWelcomeScreenFetchFailed(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleGuildWelcomeScreenFetchStart(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final State getGuildWelcomeScreen(long guildId) {
        return this.guildWelcomeScreensSnapshot.get(Long.valueOf(guildId));
    }

    public final void handleGuildJoined(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        handleGuildWelcomeScreen(guildId, guildWelcomeScreen);
    }

    public final boolean hasWelcomeScreenBeenSeen(long guildId) {
        return this.guildWelcomeScreensSeenSnapshot.contains(Long.valueOf(guildId));
    }

    public final void markWelcomeScreenShown(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Observable<State> observeGuildWelcomeScreen(long guildId) {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildWelcomeScreensSnapshot = new HashMap(this.guildWelcomeScreensState);
        this.guildWelcomeScreensSeenSnapshot = new HashSet(this.guildWelcomeScreensSeen);
    }

    public StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildWelcomeScreensSnapshot = h0.emptyMap();
        this.guildWelcomeScreensSeenSnapshot = n0.emptySet();
        this.guildWelcomeScreensState = new HashMap<>();
        this.guildWelcomeScreensSeen = new HashSet<>();
    }
}
