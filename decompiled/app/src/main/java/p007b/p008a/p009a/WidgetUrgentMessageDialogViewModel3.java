package p007b.p008a.p009a;

import android.content.Context;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* renamed from: b.a.a.x, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel3 extends AppViewModel<d> {

    /* renamed from: j */
    public static final a f446j = new a(null);

    /* renamed from: k */
    public final PublishSubject<b> f447k;

    /* renamed from: l */
    public final RestAPI f448l;

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$b */
    public static abstract class b {

        /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
        /* renamed from: b.a.a.x$b$a */
        public static final class a extends b {

            /* renamed from: a */
            public static final a f449a = new a();

            public a() {
                super(null);
            }
        }

        /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
        /* renamed from: b.a.a.x$b$b, reason: collision with other inner class name */
        public static final class C13210b extends b {

            /* renamed from: a */
            public static final C13210b f450a = new C13210b();

            public C13210b() {
                super(null);
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$c */
    public static final class c {

        /* renamed from: a */
        public final User f451a;

        public c(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.f451a = user;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && Intrinsics3.areEqual(this.f451a, ((c) obj).f451a);
            }
            return true;
        }

        public int hashCode() {
            User user = this.f451a;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(user=");
            sbM833U.append(this.f451a);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$d */
    public static final class d {

        /* renamed from: a */
        public final Integer f452a;

        /* renamed from: b */
        public final boolean f453b;

        public d(Integer num, boolean z2) {
            this.f452a = num;
            this.f453b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics3.areEqual(this.f452a, dVar.f452a) && this.f453b == dVar.f453b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Integer num = this.f452a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            boolean z2 = this.f453b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ViewState(userFlags=");
            sbM833U.append(this.f452a);
            sbM833U.append(", isBusy=");
            return outline.m827O(sbM833U, this.f453b, ")");
        }
    }

    public WidgetUrgentMessageDialogViewModel3() {
        this(null, null, null, 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrgentMessageDialogViewModel3(RestAPI restAPI, StoreUser storeUser, Observable observable, int i) {
        Observable observableM11083G;
        super(null, 1, null);
        RestAPI api = (i & 1) != 0 ? RestAPI.INSTANCE.getApi() : null;
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        if ((i & 4) != 0) {
            observableM11083G = StoreUser.observeMe$default(users, false, 1, null).m11083G(WidgetUrgentMessageDialogViewModel2.f445j);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "storeUser.observeMe().ma…oreState(user = meUser) }");
        } else {
            observableM11083G = null;
        }
        Intrinsics3.checkNotNullParameter(api, "restAPI");
        Intrinsics3.checkNotNullParameter(users, "storeUser");
        Intrinsics3.checkNotNullParameter(observableM11083G, "storeObservable");
        this.f448l = api;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11083G), this, null, 2, null), WidgetUrgentMessageDialogViewModel3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUrgentMessageDialogViewModel(this), 62, (Object) null);
        this.f447k = PublishSubject.m11133k0();
    }
}
