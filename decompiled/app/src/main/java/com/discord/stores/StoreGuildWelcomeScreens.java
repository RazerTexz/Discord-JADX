package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

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
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
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
                StringBuilder sbM833U = outline.m833U("Loaded(data=");
                sbM833U.append(this.data);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1 */
    public static final class C60911 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildWelcomeScreens.kt */
        /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<GuildWelcomeScreen, Unit> {

            /* compiled from: StoreGuildWelcomeScreens.kt */
            /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132591 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ GuildWelcomeScreen $guildWelcomeScreen;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132591(GuildWelcomeScreen guildWelcomeScreen) {
                    super(0);
                    this.$guildWelcomeScreen = guildWelcomeScreen;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C60911 c60911 = C60911.this;
                    StoreGuildWelcomeScreens.access$handleGuildWelcomeScreen(StoreGuildWelcomeScreens.this, c60911.$guildId, this.$guildWelcomeScreen);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildWelcomeScreen guildWelcomeScreen) {
                invoke2(guildWelcomeScreen);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildWelcomeScreen guildWelcomeScreen) {
                Intrinsics3.checkNotNullParameter(guildWelcomeScreen, "guildWelcomeScreen");
                StoreGuildWelcomeScreens.access$getDispatcher$p(StoreGuildWelcomeScreens.this).schedule(new C132591(guildWelcomeScreen));
            }
        }

        /* compiled from: StoreGuildWelcomeScreens.kt */
        /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGuildWelcomeScreens.kt */
            /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2$1, reason: invalid class name */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C60911 c60911 = C60911.this;
                    StoreGuildWelcomeScreens.access$handleGuildWelcomeScreenFetchFailed(StoreGuildWelcomeScreens.this, c60911.$guildId);
                }
            }

            public AnonymousClass2() {
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
                StoreGuildWelcomeScreens.access$getDispatcher$p(StoreGuildWelcomeScreens.this).schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60911(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = (State) StoreGuildWelcomeScreens.access$getGuildWelcomeScreensState$p(StoreGuildWelcomeScreens.this).get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildWelcomeScreens.access$handleGuildWelcomeScreenFetchStart(StoreGuildWelcomeScreens.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildWelcomeScreen(this.$guildId), false), StoreGuildWelcomeScreens.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$markWelcomeScreenShown$1 */
    public static final class C60921 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60921(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1 */
    public static final class C60931 extends Lambda implements Function0<State> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60931(long j) {
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
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
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

    @Store3
    private final void handleGuildWelcomeScreen(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), new State.Loaded(guildWelcomeScreen));
        markChanged();
    }

    @Store3
    private final void handleGuildWelcomeScreenFetchFailed(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleGuildWelcomeScreenFetchStart(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new C60911(guildId));
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
        this.dispatcher.schedule(new C60921(guildId));
    }

    public final Observable<State> observeGuildWelcomeScreen(long guildId) {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60931(guildId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildWelcomeScreensSnapshot = new HashMap(this.guildWelcomeScreensState);
        this.guildWelcomeScreensSeenSnapshot = new HashSet(this.guildWelcomeScreensSeen);
    }

    public StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildWelcomeScreensSnapshot = Maps6.emptyMap();
        this.guildWelcomeScreensSeenSnapshot = Sets5.emptySet();
        this.guildWelcomeScreensState = new HashMap<>();
        this.guildWelcomeScreensSeen = new HashSet<>();
    }
}
