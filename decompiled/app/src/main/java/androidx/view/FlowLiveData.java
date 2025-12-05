package androidx.view;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.time.Duration;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.CoroutineScope2;
import p659s.p660a.Dispatchers;
import p659s.p660a.MainCoroutineDispatcher;
import p659s.p660a.p661a.MainDispatchers;
import p659s.p660a.p663c2.Channel4;
import p659s.p660a.p663c2.Channel5;
import p659s.p660a.p664d2.Builders3;
import p659s.p660a.p664d2.Flow3;
import p659s.p660a.p664d2.FlowCollector;

/* compiled from: FlowLiveData.kt */
/* renamed from: androidx.lifecycle.FlowLiveDataConversions, reason: use source file name */
/* loaded from: classes.dex */
public final class FlowLiveData {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", m10085f = "FlowLiveData.kt", m10086l = {96, 100, 101}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1 */
    public static final class C04331<T> extends ContinuationImpl6 implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ LiveData $this_asFlow;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* compiled from: FlowLiveData.kt */
        @DebugMetadata(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", m10085f = "FlowLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass1(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Intrinsics2.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                C04331.this.$this_asFlow.observeForever(this.$observer);
                return Unit.f27425a;
            }
        }

        /* compiled from: FlowLiveData.kt */
        @DebugMetadata(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", m10085f = "FlowLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass2(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Intrinsics2.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                C04331.this.$this_asFlow.removeObserver(this.$observer);
                return Unit.f27425a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04331(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C04331 c04331 = new C04331(this.$this_asFlow, continuation);
            c04331.L$0 = obj;
            return c04331;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04331) create(obj, continuation)).invokeSuspend(Unit.f27425a);
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
        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Observer flowLiveData2;
            Channel4 channel4;
            Throwable th;
            C04331<T> c04331;
            ?? r7;
            Observer observer;
            Channel5 channel5;
            Channel5 it;
            Object objMo11207a;
            Observer observer2;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ?? r4 = 1;
            try {
                try {
                    if (i == 0) {
                        Result3.throwOnFailure(obj);
                        flowCollector = (FlowCollector) this.L$0;
                        Channel4 channel4M4271b = C3404f.m4271b(-1, null, null, 6);
                        flowLiveData2 = new FlowLiveData2(channel4M4271b);
                        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
                        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowLiveData2, null);
                        this.L$0 = flowCollector;
                        this.L$1 = channel4M4271b;
                        this.L$2 = flowLiveData2;
                        this.label = 1;
                        if (C3404f.m4197C1(mainCoroutineDispatcherMo11194H, anonymousClass1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channel4 = channel4M4271b;
                    } else if (i != 1) {
                        try {
                            if (i == 2) {
                                Channel5 channel52 = (Channel5) this.L$2;
                                Observer observer3 = (Observer) this.L$1;
                                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                                Result3.throwOnFailure(obj);
                                r7 = flowCollector2;
                                observer = observer3;
                                channel5 = channel52;
                                c04331 = this;
                                if (((Boolean) obj).booleanValue()) {
                                }
                            } else {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Channel5 channel53 = (Channel5) this.L$2;
                                Observer observer4 = (Observer) this.L$1;
                                flowCollector = (FlowCollector) this.L$0;
                                Result3.throwOnFailure(obj);
                                it = channel53;
                                observer2 = observer4;
                                c04331 = this;
                                r4 = observer2;
                                c04331.L$0 = flowCollector;
                                c04331.L$1 = r4;
                                c04331.L$2 = it;
                                c04331.label = 2;
                                objMo11207a = it.mo11207a(c04331);
                                if (objMo11207a == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Observer observer5 = r4;
                                channel5 = it;
                                obj = objMo11207a;
                                r7 = flowCollector;
                                observer = observer5;
                                try {
                                    if (((Boolean) obj).booleanValue()) {
                                        CoroutineScope2 coroutineScope2 = CoroutineScope2.f27919j;
                                        CoroutineDispatcher coroutineDispatcher2 = Dispatchers.f27866a;
                                        C3404f.m4211H0(coroutineScope2, MainDispatchers.f27700b.mo11194H(), null, c04331.new AnonymousClass2(observer, null), 2, null);
                                        return Unit.f27425a;
                                    }
                                    Object next = channel5.next();
                                    c04331.L$0 = r7;
                                    c04331.L$1 = observer;
                                    c04331.L$2 = channel5;
                                    c04331.label = 3;
                                    if (r7.emit(next, c04331) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    it = channel5;
                                    r4 = observer;
                                    flowCollector = r7;
                                    c04331.L$0 = flowCollector;
                                    c04331.L$1 = r4;
                                    c04331.L$2 = it;
                                    c04331.label = 2;
                                    objMo11207a = it.mo11207a(c04331);
                                    if (objMo11207a == coroutine_suspended) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    r4 = observer;
                                    CoroutineScope2 coroutineScope22 = CoroutineScope2.f27919j;
                                    CoroutineDispatcher coroutineDispatcher3 = Dispatchers.f27866a;
                                    C3404f.m4211H0(coroutineScope22, MainDispatchers.f27700b.mo11194H(), null, c04331.new AnonymousClass2(r4, null), 2, null);
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c04331 = this;
                            CoroutineScope2 coroutineScope222 = CoroutineScope2.f27919j;
                            CoroutineDispatcher coroutineDispatcher32 = Dispatchers.f27866a;
                            C3404f.m4211H0(coroutineScope222, MainDispatchers.f27700b.mo11194H(), null, c04331.new AnonymousClass2(r4, null), 2, null);
                            throw th;
                        }
                    } else {
                        flowLiveData2 = (Observer) this.L$2;
                        channel4 = (Channel4) this.L$1;
                        flowCollector = (FlowCollector) this.L$0;
                        Result3.throwOnFailure(obj);
                    }
                    c04331.L$0 = flowCollector;
                    c04331.L$1 = r4;
                    c04331.L$2 = it;
                    c04331.label = 2;
                    objMo11207a = it.mo11207a(c04331);
                    if (objMo11207a == coroutine_suspended) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    CoroutineScope2 coroutineScope2222 = CoroutineScope2.f27919j;
                    CoroutineDispatcher coroutineDispatcher322 = Dispatchers.f27866a;
                    C3404f.m4211H0(coroutineScope2222, MainDispatchers.f27700b.mo11194H(), null, c04331.new AnonymousClass2(r4, null), 2, null);
                    throw th;
                }
                it = channel4.iterator();
                observer2 = flowLiveData2;
                c04331 = this;
                r4 = observer2;
            } catch (Throwable th5) {
                th = th5;
                r4 = flowLiveData2;
                c04331 = this;
                CoroutineScope2 coroutineScope22222 = CoroutineScope2.f27919j;
                CoroutineDispatcher coroutineDispatcher3222 = Dispatchers.f27866a;
                C3404f.m4211H0(coroutineScope22222, MainDispatchers.f27700b.mo11194H(), null, c04331.new AnonymousClass2(r4, null), 2, null);
                throw th;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", m10085f = "FlowLiveData.kt", m10086l = {Opcodes.FCMPL}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1 */
    public static final class C04341<T> extends ContinuationImpl6 implements Function2<CoroutineLiveData7<T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Flow3 $this_asLiveData;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04341(Flow3 flow3, Continuation continuation) {
            super(2, continuation);
            this.$this_asLiveData = flow3;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C04341 c04341 = new C04341(this.$this_asLiveData, continuation);
            c04341.L$0 = obj;
            return c04341;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04341) create(obj, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineLiveData7 coroutineLiveData7 = (CoroutineLiveData7) this.L$0;
                Flow3 flow3 = this.$this_asLiveData;
                Collect collect = new Collect(coroutineLiveData7);
                this.label = 1;
                if (flow3.mo11246a(collect, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    public static final <T> Flow3<T> asFlow(LiveData<T> liveData) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$asFlow");
        return new Builders3(new C04331(liveData, null));
    }

    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3) {
        return asLiveData$default(flow3, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3, CoroutineContext coroutineContext) {
        return asLiveData$default(flow3, coroutineContext, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3, CoroutineContext coroutineContext, long j) {
        Intrinsics3.checkNotNullParameter(flow3, "$this$asLiveData");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        return CoroutineLiveData5.liveData(coroutineContext, j, new C04341(flow3, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow3 flow3, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextImpl4.f25237j;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(flow3, coroutineContext, j);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3, CoroutineContext coroutineContext, Duration duration) {
        Intrinsics3.checkNotNullParameter(flow3, "$this$asLiveData");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(duration, "timeout");
        return asLiveData(flow3, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow3 flow3, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextImpl4.f25237j;
        }
        return asLiveData(flow3, coroutineContext, duration);
    }
}
