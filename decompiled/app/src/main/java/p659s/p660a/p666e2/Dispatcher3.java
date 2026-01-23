package p659s.p660a.p666e2;

import kotlinx.coroutines.CoroutineDispatcher;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p512d0._Ranges;
import p659s.p660a.p661a.SystemProps;

/* JADX INFO: renamed from: s.a.e2.b, reason: use source file name */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Dispatcher3 extends Dispatcher4 {

    /* JADX INFO: renamed from: o */
    public static final CoroutineDispatcher f27813o;

    /* JADX INFO: renamed from: p */
    public static final Dispatcher3 f27814p;

    static {
        Dispatcher3 dispatcher3 = new Dispatcher3();
        f27814p = dispatcher3;
        f27813o = new Dispatcher5(dispatcher3, C3404f.m4313l1("kotlinx.coroutines.io.parallelism", _Ranges.coerceAtLeast(64, SystemProps.f27706a), 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public Dispatcher3() {
        super(0, 0, null, 7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
