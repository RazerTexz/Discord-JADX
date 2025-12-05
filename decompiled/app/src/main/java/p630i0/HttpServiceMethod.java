package p630i0;

import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p600f0.Call2;
import p659s.p660a.CancellableContinuationImpl5;

/* compiled from: HttpServiceMethod.java */
/* renamed from: i0.j, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {

    /* renamed from: a */
    public final RequestFactory f26541a;

    /* renamed from: b */
    public final Call2.a f26542b;

    /* renamed from: c */
    public final Converter2<ResponseBody, ResponseT> f26543c;

    /* compiled from: HttpServiceMethod.java */
    /* renamed from: i0.j$a */
    public static final class a<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {

        /* renamed from: d */
        public final CallAdapter<ResponseT, ReturnT> f26544d;

        public a(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory, aVar, converter2);
            this.f26544d = callAdapter;
        }

        @Override // p630i0.HttpServiceMethod
        /* renamed from: c */
        public ReturnT mo10711c(Call3<ResponseT> call3, Object[] objArr) {
            return this.f26544d.mo10706b(call3);
        }
    }

    /* compiled from: HttpServiceMethod.java */
    /* renamed from: i0.j$b */
    public static final class b<ResponseT> extends HttpServiceMethod<ResponseT, Object> {

        /* renamed from: d */
        public final CallAdapter<ResponseT, Call3<ResponseT>> f26545d;

        public b(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2, CallAdapter<ResponseT, Call3<ResponseT>> callAdapter, boolean z2) {
            super(requestFactory, aVar, converter2);
            this.f26545d = callAdapter;
        }

        @Override // p630i0.HttpServiceMethod
        /* renamed from: c */
        public Object mo10711c(Call3<ResponseT> call3, Object[] objArr) {
            Call3<ResponseT> call3Mo10706b = this.f26545d.mo10706b(call3);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
                cancellableContinuationImpl5.mo10902f(new KotlinExtensions2(call3Mo10706b));
                call3Mo10706b.mo10697C(new KotlinExtensions3(cancellableContinuationImpl5));
                Object objM11326u = cancellableContinuationImpl5.m11326u();
                if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return objM11326u;
            } catch (Exception e) {
                return C3404f.m4301i1(e, continuation);
            }
        }
    }

    /* compiled from: HttpServiceMethod.java */
    /* renamed from: i0.j$c */
    public static final class c<ResponseT> extends HttpServiceMethod<ResponseT, Object> {

        /* renamed from: d */
        public final CallAdapter<ResponseT, Call3<ResponseT>> f26546d;

        public c(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2, CallAdapter<ResponseT, Call3<ResponseT>> callAdapter) {
            super(requestFactory, aVar, converter2);
            this.f26546d = callAdapter;
        }

        @Override // p630i0.HttpServiceMethod
        /* renamed from: c */
        public Object mo10711c(Call3<ResponseT> call3, Object[] objArr) {
            Call3<ResponseT> call3Mo10706b = this.f26546d.mo10706b(call3);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
                cancellableContinuationImpl5.mo10902f(new KotlinExtensions4(call3Mo10706b));
                call3Mo10706b.mo10697C(new KotlinExtensions5(cancellableContinuationImpl5));
                Object objM11326u = cancellableContinuationImpl5.m11326u();
                if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return objM11326u;
            } catch (Exception e) {
                return C3404f.m4301i1(e, continuation);
            }
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2) {
        this.f26541a = requestFactory;
        this.f26542b = aVar;
        this.f26543c = converter2;
    }

    @Override // p630i0.ServiceMethod
    /* renamed from: a */
    public final ReturnT mo10710a(Object[] objArr) {
        return mo10711c(new OkHttpCall(this.f26541a, objArr, this.f26542b, this.f26543c), objArr);
    }

    /* renamed from: c */
    public abstract ReturnT mo10711c(Call3<ResponseT> call3, Object[] objArr);
}
