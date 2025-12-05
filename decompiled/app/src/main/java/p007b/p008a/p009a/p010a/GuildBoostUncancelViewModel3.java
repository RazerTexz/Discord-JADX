package p007b.p008a.p009a.p010a;

import android.content.Context;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: GuildBoostUncancelViewModel.kt */
/* renamed from: b.a.a.a.k, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostUncancelViewModel3 extends AppViewModel<c> {

    /* renamed from: j */
    public static final a f212j = new a(null);

    /* renamed from: k */
    public final long f213k;

    /* renamed from: l */
    public final StoreSubscriptions f214l;

    /* renamed from: m */
    public final StoreGuildBoost f215m;

    /* renamed from: n */
    public final RestAPI f216n;

    /* compiled from: GuildBoostUncancelViewModel.kt */
    /* renamed from: b.a.a.a.k$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostUncancelViewModel.kt */
    /* renamed from: b.a.a.a.k$b */
    public static final class b {

        /* renamed from: a */
        public final StoreSubscriptions.SubscriptionsState f217a;

        public b(StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionState");
            this.f217a = subscriptionsState;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && Intrinsics3.areEqual(this.f217a, ((b) obj).f217a);
            }
            return true;
        }

        public int hashCode() {
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.f217a;
            if (subscriptionsState != null) {
                return subscriptionsState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(subscriptionState=");
            sbM833U.append(this.f217a);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: GuildBoostUncancelViewModel.kt */
    /* renamed from: b.a.a.a.k$c */
    public static abstract class c {

        /* compiled from: GuildBoostUncancelViewModel.kt */
        /* renamed from: b.a.a.a.k$c$a */
        public static final class a extends c {

            /* renamed from: a */
            public final Integer f218a;

            public a() {
                this(null, 1);
            }

            public a(Integer num) {
                super(null);
                this.f218a = num;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && Intrinsics3.areEqual(this.f218a, ((a) obj).f218a);
                }
                return true;
            }

            public int hashCode() {
                Integer num = this.f218a;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m818F(outline.m833U("Dismiss(errorToastStringResId="), this.f218a, ")");
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(Integer num, int i) {
                this(null);
                int i2 = i & 1;
            }
        }

        /* compiled from: GuildBoostUncancelViewModel.kt */
        /* renamed from: b.a.a.a.k$c$b */
        public static final class b extends c {

            /* renamed from: a */
            public final ModelSubscription f219a;

            /* renamed from: b */
            public final boolean f220b;

            /* renamed from: c */
            public final boolean f221c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ModelSubscription modelSubscription, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f219a = modelSubscription;
                this.f220b = z2;
                this.f221c = z3;
            }

            /* renamed from: a */
            public static b m102a(b bVar, ModelSubscription modelSubscription, boolean z2, boolean z3, int i) {
                ModelSubscription modelSubscription2 = (i & 1) != 0 ? bVar.f219a : null;
                if ((i & 2) != 0) {
                    z2 = bVar.f220b;
                }
                if ((i & 4) != 0) {
                    z3 = bVar.f221c;
                }
                Objects.requireNonNull(bVar);
                Intrinsics3.checkNotNullParameter(modelSubscription2, Traits.Payment.Type.SUBSCRIPTION);
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
                return Intrinsics3.areEqual(this.f219a, bVar.f219a) && this.f220b == bVar.f220b && this.f221c == bVar.f221c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelSubscription modelSubscription = this.f219a;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                boolean z2 = this.f220b;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.f221c;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(subscription=");
                sbM833U.append(this.f219a);
                sbM833U.append(", uncancelInProgress=");
                sbM833U.append(this.f220b);
                sbM833U.append(", error=");
                return outline.m827O(sbM833U, this.f221c, ")");
            }
        }

        /* compiled from: GuildBoostUncancelViewModel.kt */
        /* renamed from: b.a.a.a.k$c$c, reason: collision with other inner class name */
        public static final class C13205c extends c {

            /* renamed from: a */
            public static final C13205c f222a = new C13205c();

            public C13205c() {
                super(null);
            }
        }

        /* compiled from: GuildBoostUncancelViewModel.kt */
        /* renamed from: b.a.a.a.k$c$d */
        public static final class d extends c {

            /* renamed from: a */
            public static final d f223a = new d();

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
    public GuildBoostUncancelViewModel3(long j, StoreSubscriptions storeSubscriptions, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable observable, int i) {
        Observable observableM11083G;
        super(c.C13205c.f222a);
        StoreSubscriptions subscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : null;
        StoreGuildBoost guildBoosts = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 16) != 0) {
            observableM11083G = subscriptions.observeSubscriptions().m11083G(GuildBoostUncancelViewModel2.f211j);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "storeSubscriptions\n     …toreState(it)\n          }");
        } else {
            observableM11083G = null;
        }
        Intrinsics3.checkNotNullParameter(subscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(api, "restAPI");
        Intrinsics3.checkNotNullParameter(observableM11083G, "storeObservable");
        this.f213k = j;
        this.f214l = subscriptions;
        this.f215m = guildBoosts;
        this.f216n = api;
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11083G), this, null, 2, null), GuildBoostUncancelViewModel3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostUncancelViewModel(this), 62, (Object) null);
    }
}
