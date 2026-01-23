package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p161j.p177l.AshmemMemoryChunk;
import p007b.p109f.p161j.p177l.MemoryChunk;
import p007b.p109f.p161j.p177l.MemoryChunkPool;
import p007b.p109f.p161j.p177l.PoolParams;
import p007b.p109f.p161j.p177l.PoolStatsTracker;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@TargetApi(27)
public class AshmemMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public AshmemMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: e */
    public MemoryChunk mo1382e(int i) {
        return new AshmemMemoryChunk(i);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunkPool
    /* JADX INFO: renamed from: s */
    public MemoryChunk mo1393s(int i) {
        return new AshmemMemoryChunk(i);
    }
}
