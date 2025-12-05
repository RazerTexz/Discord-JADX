package p007b.p008a.p009a.p013d;

import android.content.Context;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: UserActionsDialogViewModel.kt */
/* renamed from: b.a.a.d.f, reason: use source file name */
/* loaded from: classes.dex */
public final class UserActionsDialogViewModel5 extends AppViewModel<d> {

    /* renamed from: j */
    public static final a f329j = new a(null);

    /* renamed from: k */
    public final PublishSubject<b> f330k;

    /* renamed from: l */
    public final long f331l;

    /* renamed from: m */
    public final RestAPI f332m;

    /* compiled from: UserActionsDialogViewModel.kt */
    /* renamed from: b.a.a.d.f$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    /* renamed from: b.a.a.d.f$b */
    public static abstract class b {

        /* compiled from: UserActionsDialogViewModel.kt */
        /* renamed from: b.a.a.d.f$b$a */
        public static final class a extends b {

            /* renamed from: a */
            public final int f333a;

            public a(int i) {
                super(null);
                this.f333a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && this.f333a == ((a) obj).f333a;
                }
                return true;
            }

            public int hashCode() {
                return this.f333a;
            }

            public String toString() {
                return outline.m814B(outline.m833U("Failure(failureMessageStringRes="), this.f333a, ")");
            }
        }

        /* compiled from: UserActionsDialogViewModel.kt */
        /* renamed from: b.a.a.d.f$b$b, reason: collision with other inner class name */
        public static final class C13207b extends b {

            /* renamed from: a */
            public final int f334a;

            public C13207b(int i) {
                super(null);
                this.f334a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C13207b) && this.f334a == ((C13207b) obj).f334a;
                }
                return true;
            }

            public int hashCode() {
                return this.f334a;
            }

            public String toString() {
                return outline.m814B(outline.m833U("Success(successMessageStringRes="), this.f334a, ")");
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    /* renamed from: b.a.a.d.f$c */
    public static final class c {

        /* renamed from: a */
        public final User f335a;

        /* renamed from: b */
        public final Integer f336b;

        /* renamed from: c */
        public final GuildMember f337c;

        public c(User user, Integer num, GuildMember guildMember) {
            this.f335a = user;
            this.f336b = num;
            this.f337c = guildMember;
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    /* renamed from: b.a.a.d.f$d */
    public static abstract class d {

        /* compiled from: UserActionsDialogViewModel.kt */
        /* renamed from: b.a.a.d.f$d$a */
        public static final class a extends d {

            /* renamed from: a */
            public final User f338a;

            /* renamed from: b */
            public final String f339b;

            /* renamed from: c */
            public final boolean f340c;

            /* renamed from: d */
            public final boolean f341d;

            /* renamed from: e */
            public final boolean f342e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(User user, String str, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(user, "user");
                this.f338a = user;
                this.f339b = str;
                this.f340c = z2;
                this.f341d = z3;
                this.f342e = z4;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics3.areEqual(this.f338a, aVar.f338a) && Intrinsics3.areEqual(this.f339b, aVar.f339b) && this.f340c == aVar.f340c && this.f341d == aVar.f341d && this.f342e == aVar.f342e;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                User user = this.f338a;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                String str = this.f339b;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.f340c;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.f341d;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.f342e;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(user=");
                sbM833U.append(this.f338a);
                sbM833U.append(", userNickname=");
                sbM833U.append(this.f339b);
                sbM833U.append(", showBlockItem=");
                sbM833U.append(this.f340c);
                sbM833U.append(", showUnblockItem=");
                sbM833U.append(this.f341d);
                sbM833U.append(", showRemoveFriendItem=");
                return outline.m827O(sbM833U, this.f342e, ")");
            }
        }

        /* compiled from: UserActionsDialogViewModel.kt */
        /* renamed from: b.a.a.d.f$d$b */
        public static final class b extends d {

            /* renamed from: a */
            public static final b f343a = new b();

            public b() {
                super(null);
            }
        }

        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    /* renamed from: b.a.a.d.f$e */
    public static final class e extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Void r3) {
            UserActionsDialogViewModel5 userActionsDialogViewModel5 = UserActionsDialogViewModel5.this;
            int i = this.$successMessageStringRes;
            PublishSubject<b> publishSubject = userActionsDialogViewModel5.f330k;
            publishSubject.f27650k.onNext(new b.C13207b(i));
            return Unit.f27425a;
        }
    }

    /* compiled from: UserActionsDialogViewModel.kt */
    /* renamed from: b.a.a.d.f$f */
    public static final class f extends Lambda implements Function1<Error, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject<b> publishSubject = UserActionsDialogViewModel5.this.f330k;
            publishSubject.f27650k.onNext(new b.a(C5419R.string.default_failure_to_perform_action_message));
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserActionsDialogViewModel5(long j, long j2, RestAPI restAPI, Observable observable, int i) {
        Observable observableM11112r;
        super(d.b.f343a);
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 8) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreUser users = companion.getUsers();
            StoreUserRelationships userRelationships = companion.getUserRelationships();
            StoreGuilds guilds = companion.getGuilds();
            StoreChannels channels = companion.getChannels();
            Observable<User> observableObserveUser = users.observeUser(j);
            Observable<Integer> observableObserve = userRelationships.observe(j);
            Observable observableM11112r2 = channels.observeChannel(j2).m11099Y(new UserActionsDialogViewModel3(guilds, j)).m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r2, "storeChannels\n          …  .distinctUntilChanged()");
            observableM11112r = Observable.m11075i(observableObserveUser, observableObserve, observableM11112r2, UserActionsDialogViewModel4.f328a).m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        } else {
            observableM11112r = null;
        }
        Intrinsics3.checkNotNullParameter(api, "restAPI");
        Intrinsics3.checkNotNullParameter(observableM11112r, "storeObservable");
        this.f331l = j;
        this.f332m = api;
        this.f330k = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), UserActionsDialogViewModel5.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new UserActionsDialogViewModel(this), 62, (Object) null);
    }

    public final void removeRelationship(@StringRes int i) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.f332m.removeRelationship("User Profile", this.f331l), false, 1, null), this, null, 2, null), UserActionsDialogViewModel5.class, (Context) null, (Function1) null, new f(), (Function0) null, (Function0) null, new e(i), 54, (Object) null);
    }
}
