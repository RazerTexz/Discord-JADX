package p659s.p660a;

import java.util.Objects;
import kotlinx.coroutines.CoroutineDispatcher;
import p659s.p660a.p666e2.Dispatcher3;

/* compiled from: Dispatchers.kt */
/* renamed from: s.a.k0, reason: use source file name */
/* loaded from: classes3.dex */
public final class Dispatchers {

    /* renamed from: a */
    public static final CoroutineDispatcher f27866a;

    /* renamed from: b */
    public static final CoroutineDispatcher f27867b;

    static {
        f27866a = CoroutineContext2.f27923a ? Dispatcher3.f27814p : CommonPool.f27898k;
        Unconfined2 unconfined2 = Unconfined2.f27922j;
        Objects.requireNonNull(Dispatcher3.f27814p);
        f27867b = Dispatcher3.f27813o;
    }
}
