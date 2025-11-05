package b.a.a.d;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.d0;
import com.discord.R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: UserActionsDialogViewModel.kt */
/* loaded from: classes.dex */
public final class f extends d0<d> {
    public static final a j = new a(null);
    public final PublishSubject<b> k;
    public final long l;
    public final RestAPI m;

    /* compiled from: UserActionsDialogViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    public static abstract class b {

        /* compiled from: UserActionsDialogViewModel.kt */
        public static final class a extends b {
            public final int a;

            public a(int i) {
                super(null);
                this.a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && this.a == ((a) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return this.a;
            }

            public String toString() {
                return b.d.b.a.a.B(b.d.b.a.a.U("Failure(failureMessageStringRes="), this.a, ")");
            }
        }

        /* compiled from: UserActionsDialogViewModel.kt */
        /* renamed from: b.a.a.d.f$b$b, reason: collision with other inner class name */
        public static final class C0022b extends b {
            public final int a;

            public C0022b(int i) {
                super(null);
                this.a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C0022b) && this.a == ((C0022b) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return this.a;
            }

            public String toString() {
                return b.d.b.a.a.B(b.d.b.a.a.U("Success(successMessageStringRes="), this.a, ")");
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    public static final class c {
        public final User a;

        /* renamed from: b, reason: collision with root package name */
        public final Integer f46b;
        public final GuildMember c;

        public c(User user, Integer num, GuildMember guildMember) {
            this.a = user;
            this.f46b = num;
            this.c = guildMember;
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    public static abstract class d {

        /* compiled from: UserActionsDialogViewModel.kt */
        public static final class a extends d {
            public final User a;

            /* renamed from: b, reason: collision with root package name */
            public final String f47b;
            public final boolean c;
            public final boolean d;
            public final boolean e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(User user, String str, boolean z2, boolean z3, boolean z4) {
                super(null);
                m.checkNotNullParameter(user, "user");
                this.a = user;
                this.f47b = str;
                this.c = z2;
                this.d = z3;
                this.e = z4;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return m.areEqual(this.a, aVar.a) && m.areEqual(this.f47b, aVar.f47b) && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                User user = this.a;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                String str = this.f47b;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.c;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.d;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.e;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("Loaded(user=");
                sbU.append(this.a);
                sbU.append(", userNickname=");
                sbU.append(this.f47b);
                sbU.append(", showBlockItem=");
                sbU.append(this.c);
                sbU.append(", showUnblockItem=");
                sbU.append(this.d);
                sbU.append(", showRemoveFriendItem=");
                return b.d.b.a.a.O(sbU, this.e, ")");
            }
        }

        /* compiled from: UserActionsDialogViewModel.kt */
        public static final class b extends d {
            public static final b a = new b();

            public b() {
                super(null);
            }
        }

        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    public static final class e extends o implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Void r3) {
            f fVar = f.this;
            int i = this.$successMessageStringRes;
            PublishSubject<b> publishSubject = fVar.k;
            publishSubject.k.onNext(new b.C0022b(i));
            return Unit.a;
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    /* renamed from: b.a.a.d.f$f, reason: collision with other inner class name */
    public static final class C0023f extends o implements Function1<Error, Unit> {
        public C0023f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            m.checkNotNullParameter(error, "it");
            PublishSubject<b> publishSubject = f.this.k;
            publishSubject.k.onNext(new b.a(R.string.default_failure_to_perform_action_message));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(long j2, long j3, RestAPI restAPI, Observable observable, int i) {
        Observable observableR;
        super(d.b.a);
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 8) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreUser users = companion.getUsers();
            StoreUserRelationships userRelationships = companion.getUserRelationships();
            StoreGuilds guilds = companion.getGuilds();
            StoreChannels channels = companion.getChannels();
            Observable<User> observableObserveUser = users.observeUser(j2);
            Observable<Integer> observableObserve = userRelationships.observe(j2);
            Observable observableR2 = channels.observeChannel(j3).Y(new b.a.a.d.d(guilds, j2)).r();
            m.checkNotNullExpressionValue(observableR2, "storeChannels\n          …  .distinctUntilChanged()");
            observableR = Observable.i(observableObserveUser, observableObserve, observableR2, b.a.a.d.e.a).r();
            m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        } else {
            observableR = null;
        }
        m.checkNotNullParameter(api, "restAPI");
        m.checkNotNullParameter(observableR, "storeObservable");
        this.l = j2;
        this.m = api;
        this.k = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), f.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b.a.a.d.b(this), 62, (Object) null);
    }

    public final void removeRelationship(@StringRes int i) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.m.removeRelationship("User Profile", this.l), false, 1, null), this, null, 2, null), f.class, (Context) null, (Function1) null, new C0023f(), (Function0) null, (Function0) null, new e(i), 54, (Object) null);
    }
}
