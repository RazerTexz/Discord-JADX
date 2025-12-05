package p659s.p660a.p664d2.p665g;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Produce;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p580t._Collections;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p659s.p660a.CoroutineContext2;
import p659s.p660a.p663c2.BufferOverflow;
import p659s.p660a.p663c2.Produce3;
import p659s.p660a.p664d2.Flow3;
import p659s.p660a.p664d2.FlowCollector;

/* compiled from: ChannelFlow.kt */
/* renamed from: s.a.d2.g.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ChannelFlow<T> implements Flow3 {

    /* renamed from: a */
    public final CoroutineContext f27784a;

    /* renamed from: b */
    public final int f27785b;

    /* renamed from: c */
    public final BufferOverflow f27786c;

    /* compiled from: ChannelFlow.kt */
    @DebugMetadata(m10084c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", m10085f = "ChannelFlow.kt", m10086l = {Opcodes.I2D}, m10087m = "invokeSuspend")
    /* renamed from: s.a.d2.g.a$a */
    public static final class a extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ FlowCollector $collector;
        public Object L$0;
        public int label;

        /* renamed from: p$ */
        private CoroutineScope f27787p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FlowCollector flowCollector, Continuation continuation) {
            super(2, continuation);
            this.$collector = flowCollector;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.$collector, continuation);
            aVar.f27787p$ = (CoroutineScope) obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            a aVar = new a(this.$collector, continuation);
            aVar.f27787p$ = coroutineScope;
            return aVar.invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.f27787p$;
                FlowCollector flowCollector = this.$collector;
                ChannelFlow channelFlow = ChannelFlow.this;
                CoroutineContext coroutineContext = channelFlow.f27784a;
                int i2 = channelFlow.f27785b;
                if (i2 == -3) {
                    i2 = -2;
                }
                BufferOverflow bufferOverflow = channelFlow.f27786c;
                CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
                ChannelFlow2 channelFlow2 = new ChannelFlow2(channelFlow, null);
                Produce3 produce3 = new Produce3(CoroutineContext2.m11354a(coroutineScope, coroutineContext), C3404f.m4271b(i2, bufferOverflow, null, 4));
                produce3.m11191j0(coroutineStart, produce3, channelFlow2);
                this.L$0 = coroutineScope;
                this.label = 1;
                Object objM4249U = C3404f.m4249U(flowCollector, produce3, true, this);
                if (objM4249U != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    objM4249U = Unit.f27425a;
                }
                if (objM4249U == coroutine_suspended) {
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

    public ChannelFlow(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        this.f27784a = coroutineContext;
        this.f27785b = i;
        this.f27786c = bufferOverflow;
    }

    @Override // p659s.p660a.p664d2.Flow3
    /* renamed from: a */
    public Object mo11246a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        Object objM4225M = C3404f.m4225M(new a(flowCollector, null), continuation);
        return objM4225M == Intrinsics2.getCOROUTINE_SUSPENDED() ? objM4225M : Unit.f27425a;
    }

    /* renamed from: b */
    public abstract Object mo11248b(Produce<? super T> produce, Continuation<? super Unit> continuation);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        if (this.f27784a != CoroutineContextImpl4.f25237j) {
            StringBuilder sbM833U = outline.m833U("context=");
            sbM833U.append(this.f27784a);
            arrayList.add(sbM833U.toString());
        }
        if (this.f27785b != -3) {
            StringBuilder sbM833U2 = outline.m833U("capacity=");
            sbM833U2.append(this.f27785b);
            arrayList.add(sbM833U2.toString());
        }
        if (this.f27786c != BufferOverflow.SUSPEND) {
            StringBuilder sbM833U3 = outline.m833U("onBufferOverflow=");
            sbM833U3.append(this.f27786c);
            arrayList.add(sbM833U3.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return outline.m820H(sb, _Collections.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }
}
