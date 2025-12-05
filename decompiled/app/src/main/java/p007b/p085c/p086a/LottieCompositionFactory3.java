package p007b.p085c.p086a;

import android.content.Context;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* compiled from: LottieCompositionFactory.java */
/* renamed from: b.c.a.g, reason: use source file name */
/* loaded from: classes.dex */
public class LottieCompositionFactory3 implements Callable<LottieResult<LottieComposition>> {

    /* renamed from: j */
    public final /* synthetic */ Context f2358j;

    /* renamed from: k */
    public final /* synthetic */ String f2359k;

    /* renamed from: l */
    public final /* synthetic */ String f2360l;

    public LottieCompositionFactory3(Context context, String str, String str2) {
        this.f2358j = context;
        this.f2359k = str;
        this.f2360l = str2;
    }

    @Override // java.util.concurrent.Callable
    public LottieResult<LottieComposition> call() throws Exception {
        Context context = this.f2358j;
        String str = this.f2359k;
        String str2 = this.f2360l;
        try {
            return str.endsWith(".zip") ? LottieCompositionFactory.m677d(new ZipInputStream(context.getAssets().open(str)), str2) : LottieCompositionFactory.m675b(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }
}
