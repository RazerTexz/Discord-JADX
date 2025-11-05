package b.a.a.a;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.d0;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: GuildBoostCancelViewModel.kt */
/* loaded from: classes.dex */
public final class f extends d0<c> {
    public static final a j = new a(null);
    public final long k;
    public final StoreGuildBoost l;
    public final StoreSubscriptions m;
    public final RestAPI n;

    /* compiled from: GuildBoostCancelViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostCancelViewModel.kt */
    public static final class b {
        public final StoreGuildBoost.State a;

        /* renamed from: b, reason: collision with root package name */
        public final StoreSubscriptions.SubscriptionsState f41b;

        public b(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            m.checkNotNullParameter(state, "guildBoostState");
            m.checkNotNullParameter(subscriptionsState, "subscriptionState");
            this.a = state;
            this.f41b = subscriptionsState;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.areEqual(this.a, bVar.a) && m.areEqual(this.f41b, bVar.f41b);
        }

        public int hashCode() {
            StoreGuildBoost.State state = this.a;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.f41b;
            return iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("StoreState(guildBoostState=");
            sbU.append(this.a);
            sbU.append(", subscriptionState=");
            sbU.append(this.f41b);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildBoostCancelViewModel.kt */
    public static abstract class c {
        public final boolean a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f42b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        /* compiled from: GuildBoostCancelViewModel.kt */
        public static final class a extends c {
            public final ModelSubscription f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ModelSubscription modelSubscription) {
                super(false, true, false, true, false, null);
                m.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && m.areEqual(this.f, ((a) obj).f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("CancelInProgress(subscription=");
                sbU.append(this.f);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        public static final class b extends c {
            public final ModelSubscription f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ModelSubscription modelSubscription) {
                super(false, false, false, false, true, null);
                m.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof b) && m.areEqual(this.f, ((b) obj).f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("Cancelled(subscription=");
                sbU.append(this.f);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$c, reason: collision with other inner class name */
        public static final class C0011c extends c {
            public final Integer f;

            public C0011c() {
                this(null, 1);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0011c(Integer num, int i) {
                this(null);
                int i2 = i & 1;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C0011c) && m.areEqual(this.f, ((C0011c) obj).f);
                }
                return true;
            }

            public int hashCode() {
                Integer num = this.f;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return b.d.b.a.a.F(b.d.b.a.a.U("Dismiss(dismissStringId="), this.f, ")");
            }

            public C0011c(@StringRes Integer num) {
                super(false, false, false, false, true, null);
                this.f = num;
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        public static final class d extends c {
            public final ModelSubscription f;

            public d(ModelSubscription modelSubscription) {
                super(true, true, true, false, true, null);
                this.f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof d) && m.areEqual(this.f, ((d) obj).f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("FailureCancelling(subscription=");
                sbU.append(this.f);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        public static final class e extends c {
            public final ModelSubscription f;
            public final boolean g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(ModelSubscription modelSubscription, boolean z2) {
                super(false, true, true, false, true, null);
                m.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f = modelSubscription;
                this.g = z2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return m.areEqual(this.f, eVar.f) && this.g == eVar.g;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                boolean z2 = this.g;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("Loaded(subscription=");
                sbU.append(this.f);
                sbU.append(", isFromInventory=");
                return b.d.b.a.a.O(sbU, this.g, ")");
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$f, reason: collision with other inner class name */
        public static final class C0012f extends c {
            public static final C0012f f = new C0012f();

            public C0012f() {
                super(false, true, false, false, true, null);
            }
        }

        public c(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
            this.a = z2;
            this.f42b = z3;
            this.c = z4;
            this.d = z5;
            this.e = z6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(long j2, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, RestAPI restAPI, Observable observable, int i) {
        Observable observableJ;
        super(c.C0012f.f);
        StoreGuildBoost guildBoosts = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : null;
        StoreSubscriptions subscriptions = (i & 4) != 0 ? StoreStream.INSTANCE.getSubscriptions() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 16) != 0) {
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(guildBoosts, null, 1, null);
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = subscriptions.observeSubscriptions();
            e eVar = e.j;
            observableJ = Observable.j(observableObserveGuildBoostState$default, observableObserveSubscriptions, (Func2) (eVar != null ? new h(eVar) : eVar));
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…   ::StoreState\n        )");
        } else {
            observableJ = null;
        }
        m.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        m.checkNotNullParameter(subscriptions, "storeSubscriptions");
        m.checkNotNullParameter(api, "api");
        m.checkNotNullParameter(observableJ, "storeObservable");
        this.k = j2;
        this.l = guildBoosts;
        this.m = subscriptions;
        this.n = api;
        guildBoosts.fetchUserGuildBoostState();
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), f.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(this), 62, (Object) null);
    }
}
