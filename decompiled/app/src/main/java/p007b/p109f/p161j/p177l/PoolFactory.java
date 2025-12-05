package p007b.p109f.p161j.p177l;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p122g.PooledByteStreams;

/* compiled from: PoolFactory.java */
/* renamed from: b.f.j.l.x, reason: use source file name */
/* loaded from: classes3.dex */
public class PoolFactory {

    /* renamed from: a */
    public final PoolConfig f3968a;

    /* renamed from: b */
    public MemoryChunkPool f3969b;

    /* renamed from: c */
    public BitmapPool f3970c;

    /* renamed from: d */
    public MemoryChunkPool f3971d;

    /* renamed from: e */
    public MemoryChunkPool f3972e;

    /* renamed from: f */
    public PooledByteBufferFactory f3973f;

    /* renamed from: g */
    public PooledByteStreams f3974g;

    /* renamed from: h */
    public ByteArrayPool f3975h;

    public PoolFactory(PoolConfig poolConfig) {
        this.f3968a = poolConfig;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: a */
    public BitmapPool m1406a() {
        if (this.f3970c == null) {
            String str = this.f3968a.f3966i;
            char c = 65535;
            switch (str.hashCode()) {
                case -1868884870:
                    if (str.equals("legacy_default_params")) {
                        c = 3;
                    }
                    break;
                case -1106578487:
                    if (str.equals("legacy")) {
                        c = 4;
                    }
                    break;
                case -404562712:
                    if (str.equals("experimental")) {
                        c = 2;
                    }
                    break;
                case -402149703:
                    if (str.equals("dummy_with_tracking")) {
                        c = 1;
                    }
                    break;
                case 95945896:
                    if (str.equals("dummy")) {
                        c = 0;
                    }
                    break;
            }
            if (c == 0) {
                this.f3970c = new DummyBitmapPool();
            } else if (c == 1) {
                this.f3970c = new DummyTrackingInUseBitmapPool();
            } else if (c == 2) {
                Objects.requireNonNull(this.f3968a);
                int i = this.f3968a.f3967j;
                NoOpPoolStatsTracker noOpPoolStatsTrackerM1398h = NoOpPoolStatsTracker.m1398h();
                Objects.requireNonNull(this.f3968a);
                this.f3970c = new LruBitmapPool(0, i, noOpPoolStatsTrackerM1398h, null);
            } else if (c != 3) {
                PoolConfig poolConfig = this.f3968a;
                this.f3970c = new BucketsBitmapPool(poolConfig.f3961d, poolConfig.f3958a, poolConfig.f3959b, false);
            } else {
                this.f3970c = new BucketsBitmapPool(this.f3968a.f3961d, DefaultBitmapPoolParams.m1390a(), this.f3968a.f3959b, false);
            }
        }
        return this.f3970c;
    }

    /* renamed from: b */
    public int m1407b() {
        return this.f3968a.f3960c.f3979d;
    }

    /* renamed from: c */
    public PooledByteBufferFactory m1408c(int i) throws SecurityException {
        MemoryChunkPool memoryChunkPool;
        if (this.f3973f == null) {
            if (i == 0) {
                if (this.f3972e == null) {
                    try {
                        Constructor<?> constructor = Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class);
                        PoolConfig poolConfig = this.f3968a;
                        this.f3972e = (MemoryChunkPool) constructor.newInstance(poolConfig.f3961d, poolConfig.f3962e, poolConfig.f3963f);
                    } catch (ClassNotFoundException e) {
                        FLog.m978f("PoolFactory", "", e);
                        this.f3972e = null;
                    } catch (IllegalAccessException e2) {
                        FLog.m978f("PoolFactory", "", e2);
                        this.f3972e = null;
                    } catch (InstantiationException e3) {
                        FLog.m978f("PoolFactory", "", e3);
                        this.f3972e = null;
                    } catch (NoSuchMethodException e4) {
                        FLog.m978f("PoolFactory", "", e4);
                        this.f3972e = null;
                    } catch (InvocationTargetException e5) {
                        FLog.m978f("PoolFactory", "", e5);
                        this.f3972e = null;
                    }
                }
                memoryChunkPool = this.f3972e;
            } else if (i == 1) {
                if (this.f3971d == null) {
                    try {
                        Constructor<?> constructor2 = Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class);
                        PoolConfig poolConfig2 = this.f3968a;
                        this.f3971d = (MemoryChunkPool) constructor2.newInstance(poolConfig2.f3961d, poolConfig2.f3962e, poolConfig2.f3963f);
                    } catch (ClassNotFoundException unused) {
                        this.f3971d = null;
                    } catch (IllegalAccessException unused2) {
                        this.f3971d = null;
                    } catch (InstantiationException unused3) {
                        this.f3971d = null;
                    } catch (NoSuchMethodException unused4) {
                        this.f3971d = null;
                    } catch (InvocationTargetException unused5) {
                        this.f3971d = null;
                    }
                }
                memoryChunkPool = this.f3971d;
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("Invalid MemoryChunkType");
                }
                if (this.f3969b == null) {
                    try {
                        Constructor<?> constructor3 = Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class);
                        PoolConfig poolConfig3 = this.f3968a;
                        this.f3969b = (MemoryChunkPool) constructor3.newInstance(poolConfig3.f3961d, poolConfig3.f3962e, poolConfig3.f3963f);
                    } catch (ClassNotFoundException unused6) {
                        this.f3969b = null;
                    } catch (IllegalAccessException unused7) {
                        this.f3969b = null;
                    } catch (InstantiationException unused8) {
                        this.f3969b = null;
                    } catch (NoSuchMethodException unused9) {
                        this.f3969b = null;
                    } catch (InvocationTargetException unused10) {
                        this.f3969b = null;
                    }
                }
                memoryChunkPool = this.f3969b;
            }
            AnimatableValueParser.m591y(memoryChunkPool, "failed to get pool for chunk type: " + i);
            this.f3973f = new MemoryPooledByteBufferFactory(memoryChunkPool, m1409d());
        }
        return this.f3973f;
    }

    /* renamed from: d */
    public PooledByteStreams m1409d() {
        if (this.f3974g == null) {
            this.f3974g = new PooledByteStreams(m1410e());
        }
        return this.f3974g;
    }

    /* renamed from: e */
    public ByteArrayPool m1410e() {
        if (this.f3975h == null) {
            PoolConfig poolConfig = this.f3968a;
            this.f3975h = new GenericByteArrayPool(poolConfig.f3961d, poolConfig.f3964g, poolConfig.f3965h);
        }
        return this.f3975h;
    }
}
