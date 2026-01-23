package com.facebook.imagepipeline.memory;

import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p161j.p177l.MemoryChunk;
import p007b.p109f.p161j.p177l.MemoryChunkPool;
import p007b.p109f.p161j.p177l.PoolParams;
import p007b.p109f.p161j.p177l.PoolStatsTracker;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: e */
    public MemoryChunk mo1382e(int i) {
        return new NativeMemoryChunk(i);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunkPool
    /* JADX INFO: renamed from: s */
    public MemoryChunk mo1393s(int i) {
        return new NativeMemoryChunk(i);
    }
}
