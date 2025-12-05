package p659s.p660a;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.ContinuationInterceptor;

/* compiled from: CoroutineContext.kt */
/* renamed from: s.a.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class CoroutineContext2 {

    /* renamed from: a */
    public static final boolean f27923a;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        boolean z2;
        String strM4309k1 = C3404f.m4309k1("kotlinx.coroutines.scheduler");
        if (strM4309k1 != null) {
            int iHashCode = strM4309k1.hashCode();
            if (iHashCode != 0) {
                if (iHashCode != 3551) {
                    z2 = (iHashCode == 109935 && strM4309k1.equals("off")) ? false : true;
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + strM4309k1 + '\'').toString());
            }
        }
        f27923a = z2;
    }

    /* renamed from: a */
    public static final CoroutineContext m11354a(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextPlus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        if (coroutineContextPlus == coroutineDispatcher) {
            return coroutineContextPlus;
        }
        int i = ContinuationInterceptor.f25235e;
        return coroutineContextPlus.get(ContinuationInterceptor.b.f25236a) == null ? coroutineContextPlus.plus(coroutineDispatcher) : coroutineContextPlus;
    }
}
