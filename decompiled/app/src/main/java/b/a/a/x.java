package b.a.a;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* loaded from: classes.dex */
public final class x extends d0<d> {
    public static final a j = new a(null);
    public final PublishSubject<b> k;
    public final RestAPI l;

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static abstract class b {

        /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
        public static final class a extends b {
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
        /* renamed from: b.a.a.x$b$b, reason: collision with other inner class name */
        public static final class C0028b extends b {
            public static final C0028b a = new C0028b();

            public C0028b() {
                super(null);
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static final class c {
        public final User a;

        public c(User user) {
            d0.z.d.m.checkNotNullParameter(user, "user");
            this.a = user;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && d0.z.d.m.areEqual(this.a, ((c) obj).a);
            }
            return true;
        }

        public int hashCode() {
            User user = this.a;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("StoreState(user=");
            sbU.append(this.a);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static final class d {
        public final Integer a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f50b;

        public d(Integer num, boolean z2) {
            this.a = num;
            this.f50b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return d0.z.d.m.areEqual(this.a, dVar.a) && this.f50b == dVar.f50b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            boolean z2 = this.f50b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ViewState(userFlags=");
            sbU.append(this.a);
            sbU.append(", isBusy=");
            return b.d.b.a.a.O(sbU, this.f50b, ")");
        }
    }

    public x() {
        this(null, null, null, 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(RestAPI restAPI, StoreUser storeUser, Observable observable, int i) {
        Observable observableG;
        super(null, 1, null);
        RestAPI api = (i & 1) != 0 ? RestAPI.INSTANCE.getApi() : null;
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        if ((i & 4) != 0) {
            observableG = StoreUser.observeMe$default(users, false, 1, null).G(w.j);
            d0.z.d.m.checkNotNullExpressionValue(observableG, "storeUser.observeMe().ma…oreState(user = meUser) }");
        } else {
            observableG = null;
        }
        d0.z.d.m.checkNotNullParameter(api, "restAPI");
        d0.z.d.m.checkNotNullParameter(users, "storeUser");
        d0.z.d.m.checkNotNullParameter(observableG, "storeObservable");
        this.l = api;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), x.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new v(this), 62, (Object) null);
        this.k = PublishSubject.k0();
    }
}
