package com.discord.stores;

import android.content.Context;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionFreeTrialIntervalTypes;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.premium.PriceTierType;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreGuildRoleSubscriptions.kt */
/* loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrials;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrialsSnapshot;
    private final Map<Long, GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroups;
    private Map<Long, ? extends GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroupsSnapshot;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiers;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiersSnapshot;
    private PriceTierState priceTierState;
    private PriceTierState priceTierStateSnapshot;
    private final RestAPI restAPI;

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    public static abstract class GuildRoleSubscriptionFreeTrialsState {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Failed extends GuildRoleSubscriptionFreeTrialsState {
            private final String errorMessage;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final /* data */ class Loaded extends GuildRoleSubscriptionFreeTrialsState {
            private final Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials;

            public Loaded() {
                this(null, 1, null);
            }

            public /* synthetic */ Loaded(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : map);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.freeTrials;
                }
                return loaded.copy(map);
            }

            public final Map<Long, GuildRoleSubscriptionTierFreeTrial> component1() {
                return this.freeTrials;
            }

            public final Loaded copy(Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials) {
                return new Loaded(freeTrials);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.freeTrials, ((Loaded) other).freeTrials);
                }
                return true;
            }

            public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getFreeTrials() {
                return this.freeTrials;
            }

            public int hashCode() {
                Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.freeTrials;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m825M(outline.m833U("Loaded(freeTrials="), this.freeTrials, ")");
            }

            public Loaded(Map<Long, GuildRoleSubscriptionTierFreeTrial> map) {
                super(null);
                this.freeTrials = map;
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Loading extends GuildRoleSubscriptionFreeTrialsState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Uninitialized extends GuildRoleSubscriptionFreeTrialsState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private GuildRoleSubscriptionFreeTrialsState() {
        }

        public /* synthetic */ GuildRoleSubscriptionFreeTrialsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    public static abstract class GuildRoleSubscriptionGroupState {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Failed extends GuildRoleSubscriptionGroupState {
            private final String errorMessage;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final /* data */ class Loaded extends GuildRoleSubscriptionGroupState {
            private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

            public Loaded(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                super(null);
                this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildRoleSubscriptionGroupListing = loaded.guildRoleSubscriptionGroupListing;
                }
                return loaded.copy(guildRoleSubscriptionGroupListing);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public final Loaded copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                return new Loaded(guildRoleSubscriptionGroupListing);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing, ((Loaded) other).guildRoleSubscriptionGroupListing);
                }
                return true;
            }

            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public int hashCode() {
                GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
                if (guildRoleSubscriptionGroupListing != null) {
                    return guildRoleSubscriptionGroupListing.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(guildRoleSubscriptionGroupListing=");
                sbM833U.append(this.guildRoleSubscriptionGroupListing);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Loading extends GuildRoleSubscriptionGroupState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private GuildRoleSubscriptionGroupState() {
        }

        public /* synthetic */ GuildRoleSubscriptionGroupState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    public static abstract class PriceTierState {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Failed extends PriceTierState {
            private final String errorMessage;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final /* data */ class Loaded extends PriceTierState {
            private final List<Integer> priceTiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Integer> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "priceTiers");
                this.priceTiers = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.priceTiers;
                }
                return loaded.copy(list);
            }

            public final List<Integer> component1() {
                return this.priceTiers;
            }

            public final Loaded copy(List<Integer> priceTiers) {
                Intrinsics3.checkNotNullParameter(priceTiers, "priceTiers");
                return new Loaded(priceTiers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.priceTiers, ((Loaded) other).priceTiers);
                }
                return true;
            }

            public final List<Integer> getPriceTiers() {
                return this.priceTiers;
            }

            public int hashCode() {
                List<Integer> list = this.priceTiers;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m824L(outline.m833U("Loaded(priceTiers="), this.priceTiers, ")");
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Loading extends PriceTierState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Uninitialized extends PriceTierState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private PriceTierState() {
        }

        public /* synthetic */ PriceTierState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$1 */
    public static final class C60441 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60441(long j) {
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
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2 */
    public static final class C60452 extends Lambda implements Function1<Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;
            public final /* synthetic */ List $guildRoleSubscriptionTrials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List list) {
                super(0);
                this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
                this.$guildRoleSubscriptionTrials = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60452 c60452 = C60452.this;
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionGroupFetch(StoreGuildRoleSubscriptions.this, c60452.$guildId, this.$guildRoleSubscriptionGroupListing);
                C60452 c604522 = C60452.this;
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionFreeTrialListFetch(StoreGuildRoleSubscriptions.this, c604522.$guildId, this.$guildRoleSubscriptionTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60452(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            invoke2((Tuples2<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) tuples2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3 */
    public static final class C60463 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map mapAccess$getGuildRoleSubscriptionGroups$p = StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this);
                Long lValueOf = Long.valueOf(C60463.this.$guildId);
                Error.Response response = this.$error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                mapAccess$getGuildRoleSubscriptionGroups$p.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60463(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$1 */
    public static final class C60491 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60491(long j) {
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
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2 */
    public static final class C60502 extends Lambda implements Function1<Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $guildRoleSubscriptionFreeTrials;
            public final /* synthetic */ List $guildRoleSubscriptionGroupListings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list, List list2) {
                super(0);
                this.$guildRoleSubscriptionGroupListings = list;
                this.$guildRoleSubscriptionFreeTrials = list2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60502 c60502 = C60502.this;
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                long j = c60502.$guildId;
                List list = this.$guildRoleSubscriptionGroupListings;
                Intrinsics3.checkNotNullExpressionValue(list, "guildRoleSubscriptionGroupListings");
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionGroupFetch(storeGuildRoleSubscriptions, j, (GuildRoleSubscriptionGroupListing) _Collections.getOrNull(list, 0));
                C60502 c605022 = C60502.this;
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionFreeTrialListFetch(StoreGuildRoleSubscriptions.this, c605022.$guildId, this.$guildRoleSubscriptionFreeTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60502(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            invoke2((Tuples2<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) tuples2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3 */
    public static final class C60513 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map mapAccess$getGuildRoleSubscriptionGroups$p = StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this);
                Long lValueOf = Long.valueOf(C60513.this.$guildId);
                Error.Response response = this.$it.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                mapAccess$getGuildRoleSubscriptionGroups$p.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60513(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$1 */
    public static final class C60541 extends Lambda implements Function0<Unit> {
        public C60541() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.access$setPriceTierState$p(StoreGuildRoleSubscriptions.this, PriceTierState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2 */
    public static final class C60552 extends Lambda implements Function1<List<? extends Integer>, Unit> {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions.access$setPriceTierState$p(StoreGuildRoleSubscriptions.this, new PriceTierState.Loaded(this.$it));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public C60552() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
            invoke2((List<Integer>) list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Integer> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3 */
    public static final class C60563 extends Lambda implements Function1<Error, Unit> {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                Error.Response response = this.$it.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                StoreGuildRoleSubscriptions.access$setPriceTierState$p(storeGuildRoleSubscriptions, new PriceTierState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public C60563() {
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
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionFreeTrialListFetch$1 */
    public static final class C60571 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $guildRoleSubscriptionFreeTrialList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60571(List list, long j) {
            super(0);
            this.$guildRoleSubscriptionFreeTrialList = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List list = this.$guildRoleSubscriptionFreeTrialList;
            if (list == null) {
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).remove(Long.valueOf(this.$guildId));
                StoreGuildRoleSubscriptions.this.markChanged();
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(Long.valueOf(((GuildRoleSubscriptionTierFreeTrial) obj).getId()), obj);
            }
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), Maps6.toMutableMap(linkedHashMap));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupFetch$1 */
    public static final class C60581 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60581(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, long j) {
            super(0);
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$guildRoleSubscriptionGroupListing == null) {
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).remove(Long.valueOf(this.$guildId));
            } else {
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(GuildRoleSubscriptionGroupListing.m7941a(this.$guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, null, false, Opcodes.ATHROW)));
                List<Long> listM7949i = this.$guildRoleSubscriptionGroupListing.m7949i();
                if (listM7949i == null || listM7949i.isEmpty()) {
                    StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).remove(Long.valueOf(this.$guildId));
                } else {
                    Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap();
                    }
                    List<GuildRoleSubscriptionTierListing> listM7948h = this.$guildRoleSubscriptionGroupListing.m7948h();
                    if (listM7948h != null) {
                        for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : listM7948h) {
                            linkedHashMap.put(Long.valueOf(guildRoleSubscriptionTierListing.getId()), guildRoleSubscriptionTierListing);
                        }
                    }
                    StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), linkedHashMap);
                }
            }
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupUpdate$1 */
    public static final class C60591 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60591(long j, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingDelete$1 */
    public static final class C60601 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionTierListingId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60601(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
            if (map != null) {
                map.remove(Long.valueOf(this.$guildRoleSubscriptionTierListingId));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingUpdate$1 */
    public static final class C60611 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60611(long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put(Long.valueOf(this.$guildRoleSubscriptionTierListing.getId()), this.$guildRoleSubscriptionTierListing);
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierTrialUpdate$1 */
    public static final class C60621 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionGroupListingId;
        public final /* synthetic */ GuildRoleSubscriptionTierFreeTrial $guildRoleSubscriptionTierFreeTrial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60621(long j, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierFreeTrial = guildRoleSubscriptionTierFreeTrial;
            this.$guildRoleSubscriptionGroupListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put(Long.valueOf(this.$guildRoleSubscriptionGroupListingId), this.$guildRoleSubscriptionTierFreeTrial);
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    public /* synthetic */ StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.dispatcher;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionFreeTrials;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionGroups;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionTiers;
    }

    public static final /* synthetic */ PriceTierState access$getPriceTierState$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.priceTierState;
    }

    public static final /* synthetic */ void access$handleGuildRoleSubscriptionFreeTrialListFetch(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, List list) {
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionFreeTrialListFetch(j, list);
    }

    public static final /* synthetic */ void access$handleGuildRoleSubscriptionGroupFetch(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupFetch(j, guildRoleSubscriptionGroupListing);
    }

    public static final /* synthetic */ void access$setPriceTierState$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, PriceTierState priceTierState) {
        storeGuildRoleSubscriptions.priceTierState = priceTierState;
    }

    private final void handleGuildRoleSubscriptionFreeTrialListFetch(long guildId, List<GuildRoleSubscriptionTierFreeTrial> guildRoleSubscriptionFreeTrialList) {
        this.dispatcher.schedule(new C60571(guildRoleSubscriptionFreeTrialList, guildId));
    }

    private final void handleGuildRoleSubscriptionGroupFetch(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        this.dispatcher.schedule(new C60581(guildRoleSubscriptionGroupListing, guildId));
    }

    public final void fetchGuildRoleSubscriptionGroup(long guildId, long guildRoleSubscriptionGroupId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new C60441(guildId));
        Observable observableM11077j0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.m11077j0(this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), StoreGuildRoleSubscriptions2.INSTANCE) : this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId).m11083G(StoreGuildRoleSubscriptions3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11077j0, "observable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableM11077j0, false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new C60463(guildId), (Function0) null, (Function0) null, new C60452(guildId), 54, (Object) null);
    }

    public final void fetchGuildRoleSubscriptionGroupsForGuild(long guildId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new C60491(guildId));
        Observable observableM11077j0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.m11077j0(this.restAPI.getGuildRoleSubscriptionGroupListings(guildId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), StoreGuildRoleSubscriptions4.INSTANCE) : this.restAPI.getGuildRoleSubscriptionGroupListings(guildId).m11083G(StoreGuildRoleSubscriptions5.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11077j0, "observable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableM11077j0, false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new C60513(guildId), (Function0) null, (Function0) null, new C60502(guildId), 54, (Object) null);
    }

    public final void fetchPriceTiersIfNonExisting() {
        PriceTierState priceTierState = this.priceTierState;
        if ((priceTierState instanceof PriceTierState.Loading) || (priceTierState instanceof PriceTierState.Loaded)) {
            return;
        }
        this.dispatcher.schedule(new C60541());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPriceTiers(PriceTierType.GUILD_ROLE_SUBSCRIPTIONS.getApiValue()), false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new C60563(), (Function0) null, (Function0) null, new C60552(), 54, (Object) null);
    }

    public final List<Integer> getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions() {
        return Collections2.listOf((Object[]) new Integer[]{null, 10, 25, 50, 100});
    }

    public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrialForListing(long guildId, long listingId) {
        Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(listingId));
        }
        return null;
    }

    public final List<SubscriptionTrialInterval> getGuildRoleSubscriptionFreeTrialIntervalOptions() {
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = GuildRoleSubscriptionFreeTrialIntervalTypes.DAILY;
        return Collections2.listOf((Object[]) new SubscriptionTrialInterval[]{new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 1), new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 7)});
    }

    public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getGuildRoleSubscriptionFreeTrials(long guildId) {
        return this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
    }

    public final GuildRoleSubscriptionGroupState getGuildRoleSubscriptionState(long guildId) {
        List listEmptyList;
        List<Long> listM7949i;
        GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId));
        if (guildRoleSubscriptionGroupState == null) {
            return null;
        }
        if (!(guildRoleSubscriptionGroupState instanceof GuildRoleSubscriptionGroupState.Loaded)) {
            return guildRoleSubscriptionGroupState;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionGroupState).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null || (listM7949i = guildRoleSubscriptionGroupListing.m7949i()) == null) {
            listEmptyList = Collections2.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listM7949i.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                Map<Long, GuildRoleSubscriptionTierListing> map = this.guildRoleSubscriptionTiersSnapshot.get(Long.valueOf(guildId));
                GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = map != null ? map.get(Long.valueOf(jLongValue)) : null;
                if (guildRoleSubscriptionTierListing != null) {
                    arrayList.add(guildRoleSubscriptionTierListing);
                }
            }
            listEmptyList = arrayList;
        }
        return new GuildRoleSubscriptionGroupState.Loaded(guildRoleSubscriptionGroupListing != null ? GuildRoleSubscriptionGroupListing.m7941a(guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, listEmptyList, false, Opcodes.ATHROW) : null);
    }

    /* renamed from: getPriceTiersState, reason: from getter */
    public final PriceTierState getPriceTierStateSnapshot() {
        return this.priceTierStateSnapshot;
    }

    public final void handleGuildRoleSubscriptionGroupUpdate(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
        this.dispatcher.schedule(new C60591(guildId, guildRoleSubscriptionGroupListing));
    }

    public final void handleGuildRoleSubscriptionTierListingCreate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        handleGuildRoleSubscriptionTierListingUpdate(guildId, guildRoleSubscriptionTierListing);
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingDelete(long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
        this.dispatcher.schedule(new C60601(guildId, guildRoleSubscriptionTierListingId));
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingUpdate(long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        this.dispatcher.schedule(new C60611(guildId, guildRoleSubscriptionTierListing));
    }

    public final void handleGuildRoleSubscriptionTierTrialUpdate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierFreeTrial, "guildRoleSubscriptionTierFreeTrial");
        this.dispatcher.schedule(new C60621(guildId, guildRoleSubscriptionTierFreeTrial, guildRoleSubscriptionGroupListingId));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.priceTierStateSnapshot = this.priceTierState;
        this.guildRoleSubscriptionGroupsSnapshot = new HashMap(this.guildRoleSubscriptionGroups);
        this.guildRoleSubscriptionTiersSnapshot = new HashMap(this.guildRoleSubscriptionTiers);
        this.guildRoleSubscriptionFreeTrialsSnapshot = new HashMap(this.guildRoleSubscriptionFreeTrials);
    }

    public StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        PriceTierState.Uninitialized uninitialized = PriceTierState.Uninitialized.INSTANCE;
        this.priceTierState = uninitialized;
        this.priceTierStateSnapshot = uninitialized;
        this.guildRoleSubscriptionGroups = new LinkedHashMap();
        this.guildRoleSubscriptionGroupsSnapshot = Maps6.emptyMap();
        this.guildRoleSubscriptionTiers = new LinkedHashMap();
        this.guildRoleSubscriptionTiersSnapshot = Maps6.emptyMap();
        this.guildRoleSubscriptionFreeTrials = new LinkedHashMap();
        this.guildRoleSubscriptionFreeTrialsSnapshot = Maps6.emptyMap();
    }
}
