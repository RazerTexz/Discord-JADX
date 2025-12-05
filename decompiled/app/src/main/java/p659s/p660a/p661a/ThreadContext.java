package p659s.p660a.p661a;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p659s.p660a.ThreadContextElement;

/* compiled from: ThreadContext.kt */
/* renamed from: s.a.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ThreadContext {

    /* renamed from: a */
    public static final Symbol3 f27658a = new Symbol3("ZERO");

    /* renamed from: b */
    public static final Function2<Object, CoroutineContext.Element, Object> f27659b = b.f27666j;

    /* renamed from: c */
    public static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> f27660c = c.f27667j;

    /* renamed from: d */
    public static final Function2<ThreadContext2, CoroutineContext.Element, ThreadContext2> f27661d = a.f27664k;

    /* renamed from: e */
    public static final Function2<ThreadContext2, CoroutineContext.Element, ThreadContext2> f27662e = a.f27663j;

    /* compiled from: kotlin-style lambda group */
    /* renamed from: s.a.a.a$a */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function2<ThreadContext2, CoroutineContext.Element, ThreadContext2> {

        /* renamed from: j */
        public static final a f27663j = new a(0);

        /* renamed from: k */
        public static final a f27664k = new a(1);

        /* renamed from: l */
        public final /* synthetic */ int f27665l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(2);
            this.f27665l = i;
        }

        @Override // kotlin.jvm.functions.Function2
        public final ThreadContext2 invoke(ThreadContext2 threadContext2, CoroutineContext.Element element) {
            int i = this.f27665l;
            if (i == 0) {
                ThreadContext2 threadContext22 = threadContext2;
                CoroutineContext.Element element2 = element;
                if (element2 instanceof ThreadContextElement) {
                    CoroutineContext coroutineContext = threadContext22.f27710c;
                    Object[] objArr = threadContext22.f27708a;
                    int i2 = threadContext22.f27709b;
                    threadContext22.f27709b = i2 + 1;
                    ((ThreadContextElement) element2).m11352y(coroutineContext, objArr[i2]);
                }
                return threadContext22;
            }
            if (i != 1) {
                throw null;
            }
            ThreadContext2 threadContext23 = threadContext2;
            CoroutineContext.Element element3 = element;
            if (element3 instanceof ThreadContextElement) {
                Object objM11351C = ((ThreadContextElement) element3).m11351C(threadContext23.f27710c);
                Object[] objArr2 = threadContext23.f27708a;
                int i3 = threadContext23.f27709b;
                threadContext23.f27709b = i3 + 1;
                objArr2[i3] = objM11351C;
            }
            return threadContext23;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* renamed from: s.a.a.a$b */
    public static final class b extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {

        /* renamed from: j */
        public static final b f27666j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, CoroutineContext.Element element) {
            CoroutineContext.Element element2 = element;
            if (!(element2 instanceof ThreadContextElement)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? element2 : Integer.valueOf(iIntValue + 1);
        }
    }

    /* compiled from: ThreadContext.kt */
    /* renamed from: s.a.a.a$c */
    public static final class c extends Lambda implements Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> {

        /* renamed from: j */
        public static final c f27667j = new c();

        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
            ThreadContextElement<?> threadContextElement2 = threadContextElement;
            CoroutineContext.Element element2 = element;
            if (threadContextElement2 != null) {
                return threadContextElement2;
            }
            if (!(element2 instanceof ThreadContextElement)) {
                element2 = null;
            }
            return (ThreadContextElement) element2;
        }
    }

    /* renamed from: a */
    public static final void m11140a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f27658a) {
            return;
        }
        if (obj instanceof ThreadContext2) {
            ((ThreadContext2) obj).f27709b = 0;
            coroutineContext.fold(obj, f27662e);
        } else {
            Object objFold = coroutineContext.fold(null, f27660c);
            Objects.requireNonNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) objFold).m11352y(coroutineContext, obj);
        }
    }

    /* renamed from: b */
    public static final Object m11141b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, f27659b);
            Intrinsics3.checkNotNull(obj);
        }
        if (obj == 0) {
            return f27658a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadContext2(coroutineContext, ((Number) obj).intValue()), f27661d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).m11351C(coroutineContext);
    }
}
