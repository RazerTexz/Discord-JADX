package p007b.p109f.p161j.p168c;

import com.facebook.common.memory.PooledByteBuffer;

/* JADX INFO: renamed from: b.f.j.c.p, reason: use source file name */
/* JADX INFO: compiled from: EncodedCountingMemoryCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class EncodedCountingMemoryCacheFactory implements ValueDescriptor<PooledByteBuffer> {
    @Override // p007b.p109f.p161j.p168c.ValueDescriptor
    /* JADX INFO: renamed from: a */
    public int mo1212a(PooledByteBuffer pooledByteBuffer) {
        return pooledByteBuffer.size();
    }
}
