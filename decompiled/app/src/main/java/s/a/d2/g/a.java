package s.a.d2.g;

import d0.l;
import d0.t.u;
import d0.w.i.a.k;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.ProducerScope;
import org.objectweb.asm.Opcodes;
import s.a.c2.m;
import s.a.z;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes3.dex */
public abstract class a<T> implements s.a.d2.d {
    public final CoroutineContext a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3837b;
    public final s.a.c2.e c;

    /* compiled from: ChannelFlow.kt */
    @d0.w.i.a.e(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {Opcodes.I2D}, m = "invokeSuspend")
    /* renamed from: s.a.d2.g.a$a, reason: collision with other inner class name */
    public static final class C0648a extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ s.a.d2.e $collector;
        public Object L$0;
        public int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0648a(s.a.d2.e eVar, Continuation continuation) {
            super(2, continuation);
            this.$collector = eVar;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0648a c0648a = new C0648a(this.$collector, continuation);
            c0648a.p$ = (CoroutineScope) obj;
            return c0648a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            C0648a c0648a = new C0648a(this.$collector, continuation);
            c0648a.p$ = coroutineScope;
            return c0648a.invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                s.a.d2.e eVar = this.$collector;
                a aVar = a.this;
                CoroutineContext coroutineContext = aVar.a;
                int i2 = aVar.f3837b;
                if (i2 == -3) {
                    i2 = -2;
                }
                s.a.c2.e eVar2 = aVar.c;
                CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
                b bVar = new b(aVar, null);
                m mVar = new m(z.a(coroutineScope, coroutineContext), b.i.a.f.e.o.f.b(i2, eVar2, null, 4));
                mVar.j0(coroutineStart, mVar, bVar);
                this.L$0 = coroutineScope;
                this.label = 1;
                Object objU = b.i.a.f.e.o.f.U(eVar, mVar, true, this);
                if (objU != d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    objU = Unit.a;
                }
                if (objU == coroutine_suspended) {
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

    public a(CoroutineContext coroutineContext, int i, s.a.c2.e eVar) {
        this.a = coroutineContext;
        this.f3837b = i;
        this.c = eVar;
    }

    @Override // s.a.d2.d
    public Object a(s.a.d2.e<? super T> eVar, Continuation<? super Unit> continuation) throws Throwable {
        Object objM = b.i.a.f.e.o.f.M(new C0648a(eVar, null), continuation);
        return objM == d0.w.h.c.getCOROUTINE_SUSPENDED() ? objM : Unit.a;
    }

    public abstract Object b(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        if (this.a != d0.w.f.j) {
            StringBuilder sbU = b.d.b.a.a.U("context=");
            sbU.append(this.a);
            arrayList.add(sbU.toString());
        }
        if (this.f3837b != -3) {
            StringBuilder sbU2 = b.d.b.a.a.U("capacity=");
            sbU2.append(this.f3837b);
            arrayList.add(sbU2.toString());
        }
        if (this.c != s.a.c2.e.SUSPEND) {
            StringBuilder sbU3 = b.d.b.a.a.U("onBufferOverflow=");
            sbU3.append(this.c);
            arrayList.add(sbU3.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return b.d.b.a.a.H(sb, u.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }
}
