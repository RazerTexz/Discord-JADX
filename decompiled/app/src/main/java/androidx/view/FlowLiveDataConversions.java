package androidx.view;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.time.Duration;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import s.a.a.n;
import s.a.c2.f;
import s.a.c2.g;
import s.a.d2.d;
import s.a.k0;
import s.a.l1;
import s.a.x0;

/* compiled from: FlowLiveData.kt */
/* loaded from: classes.dex */
public final class FlowLiveDataConversions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {96, 100, 101}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends k implements Function2<s.a.d2.e<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ LiveData $this_asFlow;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* compiled from: FlowLiveData.kt */
        @e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00021 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00021(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // d0.w.i.a.a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                m.checkNotNullParameter(continuation, "completion");
                return new C00021(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00021) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.a
            public final Object invokeSuspend(Object obj) {
                c.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
                AnonymousClass1.this.$this_asFlow.observeForever(this.$observer);
                return Unit.a;
            }
        }

        /* compiled from: FlowLiveData.kt */
        @e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // d0.w.i.a.a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                m.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass2(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.a
            public final Object invokeSuspend(Object obj) {
                c.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
                AnonymousClass1.this.$this_asFlow.removeObserver(this.$observer);
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0097 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:29:0x009d, B:31:0x00a5), top: B:45:0x009d }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4, types: [androidx.lifecycle.Observer] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object, s.a.d2.e] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b8 -> B:47:0x0089). Please report as a decompilation issue!!! */
        @Override // d0.w.i.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            s.a.d2.e eVar;
            Observer flowLiveDataConversions$asFlow$1$observer$1;
            f fVar;
            Throwable th;
            AnonymousClass1<T> anonymousClass1;
            ?? r7;
            Observer observer;
            g gVar;
            g it;
            Object objA;
            Observer observer2;
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ?? r4 = 1;
            try {
                try {
                    if (i == 0) {
                        l.throwOnFailure(obj);
                        eVar = (s.a.d2.e) this.L$0;
                        f fVarB = b.i.a.f.e.o.f.b(-1, null, null, 6);
                        flowLiveDataConversions$asFlow$1$observer$1 = new FlowLiveDataConversions$asFlow$1$observer$1(fVarB);
                        CoroutineDispatcher coroutineDispatcher = k0.a;
                        l1 l1VarH = n.f3830b.H();
                        C00021 c00021 = new C00021(flowLiveDataConversions$asFlow$1$observer$1, null);
                        this.L$0 = eVar;
                        this.L$1 = fVarB;
                        this.L$2 = flowLiveDataConversions$asFlow$1$observer$1;
                        this.label = 1;
                        if (b.i.a.f.e.o.f.C1(l1VarH, c00021, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fVar = fVarB;
                    } else if (i != 1) {
                        try {
                            if (i == 2) {
                                g gVar2 = (g) this.L$2;
                                Observer observer3 = (Observer) this.L$1;
                                s.a.d2.e eVar2 = (s.a.d2.e) this.L$0;
                                l.throwOnFailure(obj);
                                r7 = eVar2;
                                observer = observer3;
                                gVar = gVar2;
                                anonymousClass1 = this;
                                if (((Boolean) obj).booleanValue()) {
                                }
                            } else {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                g gVar3 = (g) this.L$2;
                                Observer observer4 = (Observer) this.L$1;
                                eVar = (s.a.d2.e) this.L$0;
                                l.throwOnFailure(obj);
                                it = gVar3;
                                observer2 = observer4;
                                anonymousClass1 = this;
                                r4 = observer2;
                                anonymousClass1.L$0 = eVar;
                                anonymousClass1.L$1 = r4;
                                anonymousClass1.L$2 = it;
                                anonymousClass1.label = 2;
                                objA = it.a(anonymousClass1);
                                if (objA == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Observer observer5 = r4;
                                gVar = it;
                                obj = objA;
                                r7 = eVar;
                                observer = observer5;
                                try {
                                    if (((Boolean) obj).booleanValue()) {
                                        x0 x0Var = x0.j;
                                        CoroutineDispatcher coroutineDispatcher2 = k0.a;
                                        b.i.a.f.e.o.f.H0(x0Var, n.f3830b.H(), null, anonymousClass1.new AnonymousClass2(observer, null), 2, null);
                                        return Unit.a;
                                    }
                                    Object next = gVar.next();
                                    anonymousClass1.L$0 = r7;
                                    anonymousClass1.L$1 = observer;
                                    anonymousClass1.L$2 = gVar;
                                    anonymousClass1.label = 3;
                                    if (r7.emit(next, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    it = gVar;
                                    r4 = observer;
                                    eVar = r7;
                                    anonymousClass1.L$0 = eVar;
                                    anonymousClass1.L$1 = r4;
                                    anonymousClass1.L$2 = it;
                                    anonymousClass1.label = 2;
                                    objA = it.a(anonymousClass1);
                                    if (objA == coroutine_suspended) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    r4 = observer;
                                    x0 x0Var2 = x0.j;
                                    CoroutineDispatcher coroutineDispatcher3 = k0.a;
                                    b.i.a.f.e.o.f.H0(x0Var2, n.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            anonymousClass1 = this;
                            x0 x0Var22 = x0.j;
                            CoroutineDispatcher coroutineDispatcher32 = k0.a;
                            b.i.a.f.e.o.f.H0(x0Var22, n.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                            throw th;
                        }
                    } else {
                        flowLiveDataConversions$asFlow$1$observer$1 = (Observer) this.L$2;
                        fVar = (f) this.L$1;
                        eVar = (s.a.d2.e) this.L$0;
                        l.throwOnFailure(obj);
                    }
                    anonymousClass1.L$0 = eVar;
                    anonymousClass1.L$1 = r4;
                    anonymousClass1.L$2 = it;
                    anonymousClass1.label = 2;
                    objA = it.a(anonymousClass1);
                    if (objA == coroutine_suspended) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    x0 x0Var222 = x0.j;
                    CoroutineDispatcher coroutineDispatcher322 = k0.a;
                    b.i.a.f.e.o.f.H0(x0Var222, n.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                    throw th;
                }
                it = fVar.iterator();
                observer2 = flowLiveDataConversions$asFlow$1$observer$1;
                anonymousClass1 = this;
                r4 = observer2;
            } catch (Throwable th5) {
                th = th5;
                r4 = flowLiveDataConversions$asFlow$1$observer$1;
                anonymousClass1 = this;
                x0 x0Var2222 = x0.j;
                CoroutineDispatcher coroutineDispatcher3222 = k0.a;
                b.i.a.f.e.o.f.H0(x0Var2222, n.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                throw th;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @e(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {Opcodes.FCMPL}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends k implements Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ d $this_asLiveData;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(d dVar, Continuation continuation) {
            super(2, continuation);
            this.$this_asLiveData = dVar;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asLiveData, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                d dVar = this.$this_asLiveData;
                FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 flowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 = new FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1(liveDataScope);
                this.label = 1;
                if (dVar.a(flowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    public static final <T> d<T> asFlow(LiveData<T> liveData) {
        m.checkNotNullParameter(liveData, "$this$asFlow");
        return new s.a.d2.f(new AnonymousClass1(liveData, null));
    }

    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar) {
        return asLiveData$default(dVar, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar, CoroutineContext coroutineContext) {
        return asLiveData$default(dVar, coroutineContext, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar, CoroutineContext coroutineContext, long j) {
        m.checkNotNullParameter(dVar, "$this$asLiveData");
        m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineLiveDataKt.liveData(coroutineContext, j, new AnonymousClass1(dVar, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(d dVar, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = d0.w.f.j;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(dVar, coroutineContext, j);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar, CoroutineContext coroutineContext, Duration duration) {
        m.checkNotNullParameter(dVar, "$this$asLiveData");
        m.checkNotNullParameter(coroutineContext, "context");
        m.checkNotNullParameter(duration, "timeout");
        return asLiveData(dVar, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(d dVar, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = d0.w.f.j;
        }
        return asLiveData(dVar, coroutineContext, duration);
    }
}
