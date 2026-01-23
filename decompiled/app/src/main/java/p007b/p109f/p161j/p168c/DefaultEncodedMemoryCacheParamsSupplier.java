package p007b.p109f.p161j.p168c;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.f.j.c.o, reason: use source file name */
/* JADX INFO: compiled from: DefaultEncodedMemoryCacheParamsSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a */
    public static final long f3685a = TimeUnit.MINUTES.toMillis(5);

    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        int i = iMin < 16777216 ? 1048576 : iMin < 33554432 ? 2097152 : 4194304;
        return new MemoryCacheParams(i, Integer.MAX_VALUE, i, Integer.MAX_VALUE, i / 8, f3685a);
    }
}
