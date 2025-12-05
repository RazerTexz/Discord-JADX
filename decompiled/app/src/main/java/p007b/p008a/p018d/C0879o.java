package p007b.p008a.p018d;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.app.AppFragment;
import com.discord.utilities.error.Error;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: AppTransformers.kt */
/* renamed from: b.a.d.o */
/* loaded from: classes.dex */
public final class C0879o {

    /* renamed from: a */
    public static final C0879o f566a = new C0879o();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: AppTransformers.kt */
    /* renamed from: b.a.d.o$a */
    public static final class a<T> extends Lambda implements Function1<T, T> {

        /* renamed from: j */
        public static final a f567j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            Intrinsics3.checkNotNull(t);
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K, V1] */
    /* compiled from: AppTransformers.kt */
    /* renamed from: b.a.d.o$b */
    public static final class b<T, R, K, V, V1> implements Observable.InterfaceC13007c<Map<K, ? extends V>, Map<K, ? extends V1>> {

        /* renamed from: j */
        public static final b f568j = new b();

        @Override // p637j0.p641k.Func1
        public Object call(Object obj) {
            return new ScalarSynchronousObservable(Maps6.emptyMap());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K, V1] */
    /* compiled from: AppTransformers.kt */
    /* renamed from: b.a.d.o$c */
    public static final class c<T, R, K, V, V1> implements Observable.InterfaceC13007c<Map<K, ? extends V>, Map<K, ? extends V1>> {

        /* renamed from: j */
        public final /* synthetic */ Collection f569j;

        /* renamed from: k */
        public final /* synthetic */ Function1 f570k;

        public c(Collection collection, Function1 function1) {
            this.f569j = collection;
            this.f570k = function1;
        }

        @Override // p637j0.p641k.Func1
        public Object call(Object obj) {
            return ((Observable) obj).m11099Y(new C0883s(this)).m11112r();
        }
    }

    /* compiled from: AppTransformers.kt */
    /* renamed from: b.a.d.o$d */
    public static final class d<T, R> implements Observable.InterfaceC13007c<T, T> {

        /* renamed from: j */
        public final /* synthetic */ Function1 f571j;

        /* renamed from: k */
        public final /* synthetic */ Object f572k;

        /* renamed from: l */
        public final /* synthetic */ long f573l;

        /* renamed from: m */
        public final /* synthetic */ TimeUnit f574m;

        public d(Function1 function1, Object obj, long j, TimeUnit timeUnit) {
            this.f571j = function1;
            this.f572k = obj;
            this.f573l = j;
            this.f574m = timeUnit;
        }

        @Override // p637j0.p641k.Func1
        public Object call(Object obj) {
            return ((Observable) obj).m11099Y(new C0884t(this));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: AppTransformers.kt */
    /* renamed from: b.a.d.o$e */
    public static final /* synthetic */ class e<T> extends FunctionReferenceImpl implements Function1<T, Unit> {
        public e(Action1 action1) {
            super(1, action1, Action1.class, NotificationCompat.CATEGORY_CALL, "call(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            ((Action1) this.receiver).call(obj);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: AppTransformers.kt */
    /* renamed from: b.a.d.o$f */
    public static final /* synthetic */ class f<T> extends FunctionReferenceImpl implements Function1<T, Unit> {
        public f(Action1 action1) {
            super(1, action1, Action1.class, NotificationCompat.CATEGORY_CALL, "call(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            ((Action1) this.receiver).call(obj);
            return Unit.f27425a;
        }
    }

    /* renamed from: a */
    public static final <K, T> Observable.InterfaceC13007c<Map<K, T>, Map<K, T>> m175a(Collection<? extends K> collection) {
        Intrinsics3.checkNotNullParameter(collection, "filterKeys");
        return m176b(collection, a.f567j);
    }

    /* renamed from: b */
    public static final <K, V, V1> Observable.InterfaceC13007c<Map<K, V>, Map<K, V1>> m176b(Collection<? extends K> collection, Function1<? super V, ? extends V1> function1) {
        Intrinsics3.checkNotNullParameter(function1, "valueMapper");
        return (collection == null || collection.isEmpty()) ? b.f568j : new c(collection, function1);
    }

    /* renamed from: c */
    public static final <T> Observable.InterfaceC13007c<T, T> m177c(Function1<? super T, Boolean> function1, T t, long j, TimeUnit timeUnit) {
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        return new d(function1, t, j, timeUnit);
    }

    /* renamed from: d */
    public static /* synthetic */ Observable.InterfaceC13007c m178d(Function1 function1, Object obj, long j, TimeUnit timeUnit, int i) {
        if ((i & 4) != 0) {
            j = 5000;
        }
        return m177c(function1, obj, j, (i & 8) != 0 ? TimeUnit.MILLISECONDS : null);
    }

    /* renamed from: e */
    public static final <T> Observable.InterfaceC13007c<T, T> m179e(Action1<? super T> action1, Class<?> cls) {
        Intrinsics3.checkNotNullParameter(action1, "onNext");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        return new C0887w(null, cls, null, action1, null);
    }

    /* renamed from: f */
    public static Observable.InterfaceC13007c m180f(C0879o c0879o, Function1 function1, String str, Function1 function12, Function1 function13, Context context, Function0 function0, int i) {
        Function1 function14 = (i & 4) != 0 ? null : function12;
        int i2 = i & 8;
        Context context2 = (i & 16) != 0 ? null : context;
        int i3 = i & 32;
        Intrinsics3.checkNotNullParameter(function1, "onNext");
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        return new C0889y(context2, str, null, function1, function14, null);
    }

    /* renamed from: h */
    public static final <T> Observable.InterfaceC13007c<T, T> m181h(Action1<? super T> action1, Context context, Action1<Error> action12) {
        Intrinsics3.checkNotNullParameter(action1, "onNext");
        e eVar = new e(action1);
        C0857c0 c0857c0 = (40 & 4) != 0 ? null : action12 != null ? new C0857c0(action12) : null;
        int i = 40 & 8;
        Context context2 = (40 & 16) != 0 ? null : context;
        int i2 = 40 & 32;
        Intrinsics3.checkNotNullParameter(eVar, "onNext");
        Intrinsics3.checkNotNullParameter("restClient", "errorTag");
        return new C0889y(context2, "restClient", null, eVar, c0857c0, null);
    }

    /* renamed from: i */
    public static final <T> Observable.InterfaceC13007c<T, T> m182i(Action1<? super T> action1, AppFragment appFragment) {
        Intrinsics3.checkNotNullParameter(action1, "onNext");
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        return f566a.m184g(appFragment.getContext(), new f(action1), null);
    }

    /* renamed from: j */
    public static /* synthetic */ Observable.InterfaceC13007c m183j(Action1 action1, Context context, Action1 action12, int i) {
        int i2 = i & 4;
        return m181h(action1, context, null);
    }

    /* renamed from: g */
    public final <T> Observable.InterfaceC13007c<T, T> m184g(Context context, Function1<? super T, Unit> function1, Action1<Error> action1) {
        Intrinsics3.checkNotNullParameter(function1, "onNext");
        return m180f(this, function1, "restClient", action1 != null ? new C0857c0(action1) : null, null, context, null, 40);
    }
}
