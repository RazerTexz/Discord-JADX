package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import java.util.Objects;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;

/* JADX INFO: renamed from: b.f.j.l.o, reason: use source file name */
/* JADX INFO: compiled from: GenericByteArrayPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {

    /* JADX INFO: renamed from: k */
    public final int[] f3944k;

    public GenericByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.f3978c;
        Objects.requireNonNull(sparseIntArray);
        this.f3944k = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.f3944k[i] = sparseIntArray.keyAt(i);
        }
        m8699m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: e */
    public byte[] mo1382e(int i) {
        return new byte[i];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: g */
    public void mo1383g(byte[] bArr) {
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: i */
    public int mo1384i(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f3944k) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: j */
    public int mo1385j(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: k */
    public int mo1386k(int i) {
        return i;
    }
}
