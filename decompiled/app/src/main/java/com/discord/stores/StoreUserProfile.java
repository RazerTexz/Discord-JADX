package com.discord.stores;

import android.content.Context;
import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: StoreUserProfile.kt */
/* loaded from: classes2.dex */
public final class StoreUserProfile extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserProfile EMPTY_PROFILE = new UserProfile(null, null, null, null, null, null, null, Opcodes.LAND);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final HashMap<Long, UserProfile> profiles;
    private final HashSet<Long> profilesLoading;
    private Map<Long, UserProfile> profilesSnapshot;
    private final RestAPI restAPI;
    private final StoreStream storeStream;

    /* compiled from: StoreUserProfile.kt */
    public static final class Companion {
        private Companion() {
        }

        public final UserProfile getEMPTY_PROFILE() {
            return StoreUserProfile.access$getEMPTY_PROFILE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserProfile.kt */
    /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ Function1 $onFetchSuccess;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ boolean $withMutualGuilds;

        /* compiled from: StoreUserProfile.kt */
        /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03091 extends o implements Function1<UserProfile, Unit> {

            /* compiled from: StoreUserProfile.kt */
            /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03101 extends o implements Function0<Unit> {
                public final /* synthetic */ UserProfile $userProfile;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C03101(UserProfile userProfile) {
                    super(0);
                    this.$userProfile = userProfile;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.$userProfile != null) {
                        StoreUserProfile.access$getStoreStream$p(StoreUserProfile.this).handleUserProfile(this.$userProfile, AnonymousClass1.this.$guildId);
                        Function1 function1 = AnonymousClass1.this.$onFetchSuccess;
                        if (function1 != null) {
                        }
                    }
                }
            }

            public C03091() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
                invoke2(userProfile);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UserProfile userProfile) {
                StoreUserProfile.access$getDispatcher$p(StoreUserProfile.this).schedule(new C03101(userProfile));
            }
        }

        /* compiled from: StoreUserProfile.kt */
        /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {

            /* compiled from: StoreUserProfile.kt */
            /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C03111 extends o implements Function0<Unit> {
                public C03111() {
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
                    StoreUserProfile.access$handleFailure(StoreUserProfile.this, anonymousClass1.$userId);
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
                StoreUserProfile.access$getDispatcher$p(StoreUserProfile.this).schedule(new C03111());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Long l, boolean z2, Function1 function1) {
            super(0);
            this.$userId = j;
            this.$guildId = l;
            this.$withMutualGuilds = z2;
            this.$onFetchSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreUserProfile.access$getProfilesLoading$p(StoreUserProfile.this).contains(Long.valueOf(this.$userId))) {
                return;
            }
            StoreUserProfile.access$getProfilesLoading$p(StoreUserProfile.this).add(Long.valueOf(this.$userId));
            Observable observableR = ObservableExtensionsKt.restSubscribeOn$default(StoreUserProfile.access$getRestAPI$p(StoreUserProfile.this).userProfileGet(this.$userId, this.$withMutualGuilds, this.$guildId), false, 1, null).r();
            m.checkNotNullExpressionValue(observableR, "restAPI\n          .userP…  .distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR, StoreUserProfile.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C03091(), 54, (Object) null);
        }
    }

    /* compiled from: StoreUserProfile.kt */
    /* renamed from: com.discord.stores.StoreUserProfile$observeUserProfile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<UserProfile> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserProfile invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserProfile invoke() {
            return StoreUserProfile.this.getUserProfile(this.$userId);
        }
    }

    /* compiled from: StoreUserProfile.kt */
    /* renamed from: com.discord.stores.StoreUserProfile$updateUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ User $user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(User user) {
            super(0);
            this.$user = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserProfile.access$handleUser(StoreUserProfile.this, this.$user);
        }
    }

    public /* synthetic */ StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, storeStream, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.dispatcher;
    }

    public static final /* synthetic */ UserProfile access$getEMPTY_PROFILE$cp() {
        return EMPTY_PROFILE;
    }

    public static final /* synthetic */ HashSet access$getProfilesLoading$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.profilesLoading;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.restAPI;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.storeStream;
    }

    public static final /* synthetic */ void access$handleFailure(StoreUserProfile storeUserProfile, long j) {
        storeUserProfile.handleFailure(j);
    }

    public static final /* synthetic */ void access$handleUser(StoreUserProfile storeUserProfile, User user) {
        storeUserProfile.handleUser(user);
    }

    public static /* synthetic */ void fetchProfile$default(StoreUserProfile storeUserProfile, long j, Long l, boolean z2, Function1 function1, int i, Object obj) {
        storeUserProfile.fetchProfile(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : function1);
    }

    @StoreThread
    private final void handleFailure(long userId) {
        this.profilesLoading.remove(Long.valueOf(userId));
    }

    @StoreThread
    private final void handleUser(User user) {
        UserProfile userProfile = this.profiles.get(Long.valueOf(user.getId()));
        if (userProfile != null) {
            m.checkNotNullExpressionValue(userProfile, "profiles[user.id] ?: return");
            this.profiles.put(Long.valueOf(user.getId()), new UserProfile(userProfile.b(), userProfile.d(), user, userProfile.getPremiumSince(), userProfile.getPremiumGuildSince(), null, userProfile.getApplication()));
            markChanged();
        }
    }

    public final void fetchProfile(long userId, Long guildId, boolean withMutualGuilds, Function1<? super UserProfile, Unit> onFetchSuccess) {
        this.dispatcher.schedule(new AnonymousClass1(userId, guildId, withMutualGuilds, onFetchSuccess));
    }

    public final UserProfile getUserProfile(long userId) {
        UserProfile userProfile = this.profilesSnapshot.get(Long.valueOf(userId));
        return userProfile != null ? userProfile : EMPTY_PROFILE;
    }

    @StoreThread
    public final void handleUserProfile(UserProfile userProfile) {
        m.checkNotNullParameter(userProfile, "userProfile");
        long id2 = userProfile.getUser().getId();
        this.profilesLoading.remove(Long.valueOf(id2));
        this.profiles.put(Long.valueOf(id2), userProfile);
        markChanged();
    }

    public final Observable<UserProfile> observeUserProfile(long userId) {
        Observable<UserProfile> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(userId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.profilesSnapshot = new HashMap(this.profiles);
    }

    public final void updateUser(User user) {
        m.checkNotNullParameter(user, "user");
        this.dispatcher.schedule(new AnonymousClass1(user));
    }

    public StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.storeStream = storeStream;
        this.restAPI = restAPI;
        this.profilesLoading = new HashSet<>();
        this.profiles = new HashMap<>();
        this.profilesSnapshot = h0.emptyMap();
    }
}
