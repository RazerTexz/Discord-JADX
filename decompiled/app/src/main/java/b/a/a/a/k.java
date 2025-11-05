package b.a.a.a;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildBoostUncancelViewModel.kt */
/* loaded from: classes.dex */
public final class k extends d0<c> {
    public static final a j = new a(null);
    public final long k;
    public final StoreSubscriptions l;
    public final StoreGuildBoost m;
    public final RestAPI n;

    /* compiled from: GuildBoostUncancelViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostUncancelViewModel.kt */
    public static final class b {
        public final StoreSubscriptions.SubscriptionsState a;

        public b(StoreSubscriptions.SubscriptionsState subscriptionsState) {
            m.checkNotNullParameter(subscriptionsState, "subscriptionState");
            this.a = subscriptionsState;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && m.areEqual(this.a, ((b) obj).a);
            }
            return true;
        }

        public int hashCode() {
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.a;
            if (subscriptionsState != null) {
                return subscriptionsState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("StoreState(subscriptionState=");
            sbU.append(this.a);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildBoostUncancelViewModel.kt */
    public static abstract class c {

        /* compiled from: GuildBoostUncancelViewModel.kt */
        public static final class a extends c {
            public final Integer a;

            public a() {
                this(null, 1);
            }

            public a(Integer num) {
                super(null);
                this.a = num;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && m.areEqual(this.a, ((a) obj).a);
                }
                return true;
            }

            public int hashCode() {
                Integer num = this.a;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return b.d.b.a.a.F(b.d.b.a.a.U("Dismiss(errorToastStringResId="), this.a, ")");
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(Integer num, int i) {
                this(null);
                int i2 = i & 1;
            }
        }

        /* compiled from: GuildBoostUncancelViewModel.kt */
        public static final class b extends c {
            public final ModelSubscription a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f43b;
            public final boolean c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ModelSubscription modelSubscription, boolean z2, boolean z3) {
                super(null);
                m.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.a = modelSubscription;
                this.f43b = z2;
                this.c = z3;
            }

            public static b a(b bVar, ModelSubscription modelSubscription, boolean z2, boolean z3, int i) {
                ModelSubscription modelSubscription2 = (i & 1) != 0 ? bVar.a : null;
                if ((i & 2) != 0) {
                    z2 = bVar.f43b;
                }
                if ((i & 4) != 0) {
                    z3 = bVar.c;
                }
                Objects.requireNonNull(bVar);
                m.checkNotNullParameter(modelSubscription2, Traits.Payment.Type.SUBSCRIPTION);
                return new b(modelSubscription2, z2, z3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return m.areEqual(this.a, bVar.a) && this.f43b == bVar.f43b && this.c == bVar.c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelSubscription modelSubscription = this.a;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                boolean z2 = this.f43b;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.c;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("Loaded(subscription=");
                sbU.append(this.a);
                sbU.append(", uncancelInProgress=");
                sbU.append(this.f43b);
                sbU.append(", error=");
                return b.d.b.a.a.O(sbU, this.c, ")");
            }
        }

        /* compiled from: GuildBoostUncancelViewModel.kt */
        /* renamed from: b.a.a.a.k$c$c, reason: collision with other inner class name */
        public static final class C0013c extends c {
            public static final C0013c a = new C0013c();

            public C0013c() {
                super(null);
            }
        }

        /* compiled from: GuildBoostUncancelViewModel.kt */
        public static final class d extends c {
            public static final d a = new d();

            public d() {
                super(null);
            }
        }

        public c() {
        }

        public c(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(long j2, StoreSubscriptions storeSubscriptions, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable observable, int i) {
        Observable observableG;
        super(c.C0013c.a);
        StoreSubscriptions subscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : null;
        StoreGuildBoost guildBoosts = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 16) != 0) {
            observableG = subscriptions.observeSubscriptions().G(j.j);
            m.checkNotNullExpressionValue(observableG, "storeSubscriptions\n     …toreState(it)\n          }");
        } else {
            observableG = null;
        }
        m.checkNotNullParameter(subscriptions, "storeSubscriptions");
        m.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        m.checkNotNullParameter(api, "restAPI");
        m.checkNotNullParameter(observableG, "storeObservable");
        this.k = j2;
        this.l = subscriptions;
        this.m = guildBoosts;
        this.n = api;
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), k.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new i(this), 62, (Object) null);
    }
}
