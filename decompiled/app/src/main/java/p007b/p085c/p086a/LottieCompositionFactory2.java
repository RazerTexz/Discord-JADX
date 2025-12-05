package p007b.p085c.p086a;

import android.content.Context;
import androidx.core.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p099z.FileExtension;
import p007b.p085c.p086a.p099z.NetworkCache;
import p007b.p085c.p086a.p099z.NetworkFetcher;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: LottieCompositionFactory.java */
/* renamed from: b.c.a.f, reason: use source file name */
/* loaded from: classes.dex */
public class LottieCompositionFactory2 implements Callable<LottieResult<LottieComposition>> {

    /* renamed from: j */
    public final /* synthetic */ Context f2355j;

    /* renamed from: k */
    public final /* synthetic */ String f2356k;

    /* renamed from: l */
    public final /* synthetic */ String f2357l;

    public LottieCompositionFactory2(Context context, String str, String str2) {
        this.f2355j = context;
        this.f2356k = str;
        this.f2357l = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LottieResult<LottieComposition> call() throws Exception {
        Pair pair;
        File file;
        FileExtension fileExtension;
        NetworkFetcher networkFetcher = new NetworkFetcher(this.f2355j, this.f2356k, this.f2357l);
        FileExtension fileExtension2 = FileExtension.ZIP;
        NetworkCache networkCache = networkFetcher.f2930c;
        LottieComposition lottieComposition = null;
        if (networkCache != null) {
            String str = networkFetcher.f2929b;
            try {
                File fileM794b = networkCache.m794b();
                fileExtension = FileExtension.JSON;
                file = new File(fileM794b, NetworkCache.m793a(str, fileExtension, false));
                if (!file.exists()) {
                    file = new File(networkCache.m794b(), NetworkCache.m793a(str, fileExtension2, false));
                    if (!file.exists()) {
                        file = null;
                    }
                }
            } catch (FileNotFoundException unused) {
            }
            if (file == null) {
                pair = null;
                if (pair != null) {
                    FileExtension fileExtension3 = (FileExtension) pair.first;
                    InputStream inputStream = (InputStream) pair.second;
                    LottieComposition lottieComposition2 = (fileExtension3 == fileExtension2 ? LottieCompositionFactory.m677d(new ZipInputStream(inputStream), networkFetcher.f2929b) : LottieCompositionFactory.m675b(inputStream, networkFetcher.f2929b)).f2449a;
                    if (lottieComposition2 != null) {
                        lottieComposition = lottieComposition2;
                    }
                }
            } else {
                FileInputStream fileInputStream = new FileInputStream(file);
                if (file.getAbsolutePath().endsWith(".zip")) {
                    fileExtension = fileExtension2;
                }
                StringBuilder sbM837Y = outline.m837Y("Cache hit for ", str, " at ");
                sbM837Y.append(file.getAbsolutePath());
                Logger2.m639a(sbM837Y.toString());
                pair = new Pair(fileExtension, fileInputStream);
                if (pair != null) {
                }
            }
        }
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        StringBuilder sbM833U = outline.m833U("Animation for ");
        sbM833U.append(networkFetcher.f2929b);
        sbM833U.append(" not found in cache. Fetching from network.");
        Logger2.m639a(sbM833U.toString());
        try {
            return networkFetcher.m796a();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }
}
