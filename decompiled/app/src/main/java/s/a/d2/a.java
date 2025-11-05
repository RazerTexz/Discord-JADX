package s.a.d2;

import d0.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Flow.kt */
/* loaded from: classes3.dex */
public abstract class a<T> implements d<T> {

    /* compiled from: Flow.kt */
    @d0.w.i.a.e(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {212}, m = "collect")
    /* renamed from: s.a.d2.a$a, reason: collision with other inner class name */
    public static final class C0647a extends d0.w.i.a.d {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C0647a(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // s.a.d2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(e<? super T> eVar, Continuation<? super Unit> continuation) throws Throwable {
        C0647a c0647a;
        Throwable th;
        s.a.d2.g.e eVar2;
        if (continuation instanceof C0647a) {
            c0647a = (C0647a) continuation;
            int i = c0647a.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c0647a.label = i - Integer.MIN_VALUE;
            } else {
                c0647a = new C0647a(continuation);
            }
        }
        Object obj = c0647a.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = c0647a.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar2 = (s.a.d2.g.e) c0647a.L$2;
            try {
                l.throwOnFailure(obj);
                eVar2.releaseIntercepted();
                return Unit.a;
            } catch (Throwable th2) {
                th = th2;
                eVar2.releaseIntercepted();
                throw th;
            }
        }
        l.throwOnFailure(obj);
        s.a.d2.g.e eVar3 = new s.a.d2.g.e(eVar, c0647a.getContext());
        try {
            c0647a.L$0 = this;
            c0647a.L$1 = eVar;
            c0647a.L$2 = eVar3;
            c0647a.label = 1;
            if (b(eVar3, c0647a) == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar2 = eVar3;
            eVar2.releaseIntercepted();
            return Unit.a;
        } catch (Throwable th3) {
            th = th3;
            eVar2 = eVar3;
            eVar2.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object b(e<? super T> eVar, Continuation<? super Unit> continuation);
}
