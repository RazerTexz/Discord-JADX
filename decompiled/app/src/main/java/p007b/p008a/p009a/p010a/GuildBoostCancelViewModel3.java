package p007b.p008a.p009a.p010a;

import android.content.Context;
import androidx.annotation.StringRes;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: b.a.a.a.f, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostCancelViewModel3 extends AppViewModel<c> {

    /* JADX INFO: renamed from: j */
    public static final a f191j = new a(null);

    /* JADX INFO: renamed from: k */
    public final long f192k;

    /* JADX INFO: renamed from: l */
    public final StoreGuildBoost f193l;

    /* JADX INFO: renamed from: m */
    public final StoreSubscriptions f194m;

    /* JADX INFO: renamed from: n */
    public final RestAPI f195n;

    /* JADX INFO: renamed from: b.a.a.a.f$a */
    /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.f$b */
    /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final StoreGuildBoost.State f196a;

        /* JADX INFO: renamed from: b */
        public final StoreSubscriptions.SubscriptionsState f197b;

        public b(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(state, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionState");
            this.f196a = state;
            this.f197b = subscriptionsState;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.f196a, bVar.f196a) && Intrinsics3.areEqual(this.f197b, bVar.f197b);
        }

        public int hashCode() {
            StoreGuildBoost.State state = this.f196a;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.f197b;
            return iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(guildBoostState=");
            sbM833U.append(this.f196a);
            sbM833U.append(", subscriptionState=");
            sbM833U.append(this.f197b);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.f$c */
    /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a */
        public final boolean f198a;

        /* JADX INFO: renamed from: b */
        public final boolean f199b;

        /* JADX INFO: renamed from: c */
        public final boolean f200c;

        /* JADX INFO: renamed from: d */
        public final boolean f201d;

        /* JADX INFO: renamed from: e */
        public final boolean f202e;

        /* JADX INFO: renamed from: b.a.a.a.f$c$a */
        /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
        public static final class a extends c {

            /* JADX INFO: renamed from: f */
            public final ModelSubscription f203f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ModelSubscription modelSubscription) {
                super(false, true, false, true, false, null);
                Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f203f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && Intrinsics3.areEqual(this.f203f, ((a) obj).f203f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f203f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("CancelInProgress(subscription=");
                sbM833U.append(this.f203f);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.f$c$b */
        /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
        public static final class b extends c {

            /* JADX INFO: renamed from: f */
            public final ModelSubscription f204f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ModelSubscription modelSubscription) {
                super(false, false, false, false, true, null);
                Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f204f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof b) && Intrinsics3.areEqual(this.f204f, ((b) obj).f204f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f204f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Cancelled(subscription=");
                sbM833U.append(this.f204f);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.f$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
        public static final class C13204c extends c {

            /* JADX INFO: renamed from: f */
            public final Integer f205f;

            public C13204c() {
                this(null, 1);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C13204c(Integer num, int i) {
                this(null);
                int i2 = i & 1;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C13204c) && Intrinsics3.areEqual(this.f205f, ((C13204c) obj).f205f);
                }
                return true;
            }

            public int hashCode() {
                Integer num = this.f205f;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m818F(outline.m833U("Dismiss(dismissStringId="), this.f205f, ")");
            }

            public C13204c(@StringRes Integer num) {
                super(false, false, false, false, true, null);
                this.f205f = num;
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.f$c$d */
        /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
        public static final class d extends c {

            /* JADX INFO: renamed from: f */
            public final ModelSubscription f206f;

            public d(ModelSubscription modelSubscription) {
                super(true, true, true, false, true, null);
                this.f206f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof d) && Intrinsics3.areEqual(this.f206f, ((d) obj).f206f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f206f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("FailureCancelling(subscription=");
                sbM833U.append(this.f206f);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.f$c$e */
        /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
        public static final class e extends c {

            /* JADX INFO: renamed from: f */
            public final ModelSubscription f207f;

            /* JADX INFO: renamed from: g */
            public final boolean f208g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(ModelSubscription modelSubscription, boolean z2) {
                super(false, true, true, false, true, null);
                Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f207f = modelSubscription;
                this.f208g = z2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return Intrinsics3.areEqual(this.f207f, eVar.f207f) && this.f208g == eVar.f208g;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                ModelSubscription modelSubscription = this.f207f;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                boolean z2 = this.f208g;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(subscription=");
                sbM833U.append(this.f207f);
                sbM833U.append(", isFromInventory=");
                return outline.m827O(sbM833U, this.f208g, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.f$c$f */
        /* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
        public static final class f extends c {

            /* JADX INFO: renamed from: f */
            public static final f f209f = new f();

            public f() {
                super(false, true, false, false, true, null);
            }
        }

        public c(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
            this.f198a = z2;
            this.f199b = z3;
            this.f200c = z4;
            this.f201d = z5;
            this.f202e = z6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostCancelViewModel3(long j, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, RestAPI restAPI, Observable observable, int i) {
        Observable observableM11076j;
        super(c.f.f209f);
        StoreGuildBoost guildBoosts = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : null;
        StoreSubscriptions subscriptions = (i & 4) != 0 ? StoreStream.INSTANCE.getSubscriptions() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 16) != 0) {
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(guildBoosts, null, 1, null);
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = subscriptions.observeSubscriptions();
            GuildBoostCancelViewModel2 guildBoostCancelViewModel2 = GuildBoostCancelViewModel2.f190j;
            observableM11076j = Observable.m11076j(observableObserveGuildBoostState$default, observableObserveSubscriptions, (Func2) (guildBoostCancelViewModel2 != null ? new GuildBoostCancelViewModel5(guildBoostCancelViewModel2) : guildBoostCancelViewModel2));
            Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…   ::StoreState\n        )");
        } else {
            observableM11076j = null;
        }
        Intrinsics3.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(subscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(api, "api");
        Intrinsics3.checkNotNullParameter(observableM11076j, "storeObservable");
        this.f192k = j;
        this.f193l = guildBoosts;
        this.f194m = subscriptions;
        this.f195n = api;
        guildBoosts.fetchUserGuildBoostState();
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11076j), this, null, 2, null), GuildBoostCancelViewModel3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostCancelViewModel(this), 62, (Object) null);
    }
}
