package p007b.p085c.p086a;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: LottieCompositionFactory.java */
/* renamed from: b.c.a.i, reason: use source file name */
/* loaded from: classes.dex */
public class LottieCompositionFactory5 implements Callable<LottieResult<LottieComposition>> {

    /* renamed from: j */
    public final /* synthetic */ InputStream f2364j;

    /* renamed from: k */
    public final /* synthetic */ String f2365k;

    public LottieCompositionFactory5(InputStream inputStream, String str) {
        this.f2364j = inputStream;
        this.f2365k = str;
    }

    @Override // java.util.concurrent.Callable
    public LottieResult<LottieComposition> call() throws Exception {
        return LottieCompositionFactory.m675b(this.f2364j, this.f2365k);
    }
}
