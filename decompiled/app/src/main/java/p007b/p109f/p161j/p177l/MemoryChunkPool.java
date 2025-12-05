package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import java.util.Objects;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;

/* compiled from: MemoryChunkPool.java */
/* renamed from: b.f.j.l.s, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MemoryChunkPool extends BasePool<MemoryChunk> {

    /* renamed from: k */
    public final int[] f3952k;

    public MemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.f3978c;
        Objects.requireNonNull(sparseIntArray);
        this.f3952k = new int[sparseIntArray.size()];
        int i = 0;
        while (true) {
            int[] iArr = this.f3952k;
            if (i >= iArr.length) {
                m8699m();
                return;
            } else {
                iArr[i] = sparseIntArray.keyAt(i);
                i++;
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: e */
    public /* bridge */ /* synthetic */ MemoryChunk mo1382e(int i) {
        return mo1393s(i);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: g */
    public void mo1383g(MemoryChunk memoryChunk) {
        memoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: i */
    public int mo1384i(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f3952k) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: j */
    public int mo1385j(MemoryChunk memoryChunk) {
        return memoryChunk.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: k */
    public int mo1386k(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: o */
    public boolean mo1388o(MemoryChunk memoryChunk) {
        return !memoryChunk.isClosed();
    }

    /* renamed from: s */
    public abstract MemoryChunk mo1393s(int i);
}
