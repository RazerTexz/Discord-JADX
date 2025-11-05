package i0;

import f0.e;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;

/* compiled from: HttpServiceMethod.java */
/* loaded from: classes3.dex */
public abstract class j<ResponseT, ReturnT> extends z<ReturnT> {
    public final w a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a f3742b;
    public final h<ResponseBody, ResponseT> c;

    /* compiled from: HttpServiceMethod.java */
    public static final class a<ResponseT, ReturnT> extends j<ResponseT, ReturnT> {
        public final e<ResponseT, ReturnT> d;

        public a(w wVar, e.a aVar, h<ResponseBody, ResponseT> hVar, e<ResponseT, ReturnT> eVar) {
            super(wVar, aVar, hVar);
            this.d = eVar;
        }

        @Override // i0.j
        public ReturnT c(d<ResponseT> dVar, Object[] objArr) {
            return this.d.b(dVar);
        }
    }

    /* compiled from: HttpServiceMethod.java */
    public static final class b<ResponseT> extends j<ResponseT, Object> {
        public final e<ResponseT, d<ResponseT>> d;

        public b(w wVar, e.a aVar, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar, boolean z2) {
            super(wVar, aVar, hVar);
            this.d = eVar;
        }

        @Override // i0.j
        public Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> dVarB = this.d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                s.a.l lVar = new s.a.l(d0.w.h.b.intercepted(continuation), 1);
                lVar.f(new l(dVarB));
                dVarB.C(new m(lVar));
                Object objU = lVar.u();
                if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    d0.w.i.a.g.probeCoroutineSuspended(continuation);
                }
                return objU;
            } catch (Exception e) {
                return b.i.a.f.e.o.f.i1(e, continuation);
            }
        }
    }

    /* compiled from: HttpServiceMethod.java */
    public static final class c<ResponseT> extends j<ResponseT, Object> {
        public final e<ResponseT, d<ResponseT>> d;

        public c(w wVar, e.a aVar, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar) {
            super(wVar, aVar, hVar);
            this.d = eVar;
        }

        @Override // i0.j
        public Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> dVarB = this.d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                s.a.l lVar = new s.a.l(d0.w.h.b.intercepted(continuation), 1);
                lVar.f(new n(dVarB));
                dVarB.C(new o(lVar));
                Object objU = lVar.u();
                if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    d0.w.i.a.g.probeCoroutineSuspended(continuation);
                }
                return objU;
            } catch (Exception e) {
                return b.i.a.f.e.o.f.i1(e, continuation);
            }
        }
    }

    public j(w wVar, e.a aVar, h<ResponseBody, ResponseT> hVar) {
        this.a = wVar;
        this.f3742b = aVar;
        this.c = hVar;
    }

    @Override // i0.z
    public final ReturnT a(Object[] objArr) {
        return c(new p(this.a, objArr, this.f3742b, this.c), objArr);
    }

    public abstract ReturnT c(d<ResponseT> dVar, Object[] objArr);
}
