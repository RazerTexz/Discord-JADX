package p007b.p085c.p086a;

import android.content.Context;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* compiled from: LottieCompositionFactory.java */
/* renamed from: b.c.a.h, reason: use source file name */
/* loaded from: classes.dex */
public class LottieCompositionFactory4 implements Callable<LottieResult<LottieComposition>> {

    /* renamed from: j */
    public final /* synthetic */ WeakReference f2361j;

    /* renamed from: k */
    public final /* synthetic */ Context f2362k;

    /* renamed from: l */
    public final /* synthetic */ int f2363l;

    public LottieCompositionFactory4(WeakReference weakReference, Context context, int i) {
        this.f2361j = weakReference;
        this.f2362k = context;
        this.f2363l = i;
    }

    @Override // java.util.concurrent.Callable
    public LottieResult<LottieComposition> call() throws Exception {
        Context context = (Context) this.f2361j.get();
        if (context == null) {
            context = this.f2362k;
        }
        int i = this.f2363l;
        try {
            return LottieCompositionFactory.m675b(context.getResources().openRawResource(i), LottieCompositionFactory.m679f(context, i));
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }
}
