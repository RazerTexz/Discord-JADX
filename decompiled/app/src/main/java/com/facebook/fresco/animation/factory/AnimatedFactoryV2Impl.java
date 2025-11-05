package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import b.f.d.b.f;
import b.f.d.b.g;
import b.f.d.d.c;
import b.f.d.d.l;
import b.f.j.a.b.d;
import b.f.j.c.m;
import b.f.j.e.e;
import b.f.j.j.i;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

@c
/* loaded from: classes.dex */
public class AnimatedFactoryV2Impl implements b.f.j.a.b.a {
    public final PlatformBitmapFactory a;

    /* renamed from: b, reason: collision with root package name */
    public final e f2894b;
    public final m<CacheKey, b.f.j.j.c> c;
    public final boolean d;
    public d e;
    public b.f.j.a.c.b f;
    public b.f.j.a.d.a g;
    public b.f.j.i.a h;
    public f i;

    public class a implements b.f.j.h.b {
        public a() {
        }

        @Override // b.f.j.h.b
        public b.f.j.j.c a(b.f.j.j.e eVar, int i, i iVar, b.f.j.d.b bVar) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.e == null) {
                animatedFactoryV2Impl.e = new b.f.j.a.b.e(new b.f.h.a.d.d(animatedFactoryV2Impl), animatedFactoryV2Impl.a);
            }
            d dVar = animatedFactoryV2Impl.e;
            Bitmap.Config config = bVar.e;
            b.f.j.a.b.e eVar2 = (b.f.j.a.b.e) dVar;
            Objects.requireNonNull(eVar2);
            if (b.f.j.a.b.e.a == null) {
                throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceC = eVar.c();
            Objects.requireNonNull(closeableReferenceC);
            try {
                PooledByteBuffer pooledByteBufferU = closeableReferenceC.u();
                return eVar2.a(bVar, pooledByteBufferU.getByteBuffer() != null ? b.f.j.a.b.e.a.c(pooledByteBufferU.getByteBuffer(), bVar) : b.f.j.a.b.e.a.h(pooledByteBufferU.k(), pooledByteBufferU.size(), bVar), config);
            } finally {
                closeableReferenceC.close();
            }
        }
    }

    public class b implements b.f.j.h.b {
        public b() {
        }

        @Override // b.f.j.h.b
        public b.f.j.j.c a(b.f.j.j.e eVar, int i, i iVar, b.f.j.d.b bVar) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.e == null) {
                animatedFactoryV2Impl.e = new b.f.j.a.b.e(new b.f.h.a.d.d(animatedFactoryV2Impl), animatedFactoryV2Impl.a);
            }
            d dVar = animatedFactoryV2Impl.e;
            Bitmap.Config config = bVar.e;
            b.f.j.a.b.e eVar2 = (b.f.j.a.b.e) dVar;
            Objects.requireNonNull(eVar2);
            if (b.f.j.a.b.e.f547b == null) {
                throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceC = eVar.c();
            Objects.requireNonNull(closeableReferenceC);
            try {
                PooledByteBuffer pooledByteBufferU = closeableReferenceC.u();
                return eVar2.a(bVar, pooledByteBufferU.getByteBuffer() != null ? b.f.j.a.b.e.f547b.c(pooledByteBufferU.getByteBuffer(), bVar) : b.f.j.a.b.e.f547b.h(pooledByteBufferU.k(), pooledByteBufferU.size(), bVar), config);
            } finally {
                closeableReferenceC.close();
            }
        }
    }

    @c
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, e eVar, m<CacheKey, b.f.j.j.c> mVar, boolean z2, f fVar) {
        this.a = platformBitmapFactory;
        this.f2894b = eVar;
        this.c = mVar;
        this.d = z2;
        this.i = fVar;
    }

    @Override // b.f.j.a.b.a
    public b.f.j.i.a a(Context context) {
        if (this.h == null) {
            b.f.h.a.d.a aVar = new b.f.h.a.d.a(this);
            ExecutorService cVar = this.i;
            if (cVar == null) {
                cVar = new b.f.d.b.c(this.f2894b.a());
            }
            ExecutorService executorService = cVar;
            b.f.h.a.d.b bVar = new b.f.h.a.d.b(this);
            Supplier<Boolean> supplier = l.a;
            if (this.f == null) {
                this.f = new b.f.h.a.d.c(this);
            }
            b.f.j.a.c.b bVar2 = this.f;
            if (g.k == null) {
                g.k = new g();
            }
            this.h = new b.f.h.a.d.e(bVar2, g.k, executorService, RealtimeSinceBootClock.get(), this.a, this.c, aVar, bVar, supplier);
        }
        return this.h;
    }

    @Override // b.f.j.a.b.a
    public b.f.j.h.b b() {
        return new a();
    }

    @Override // b.f.j.a.b.a
    public b.f.j.h.b c() {
        return new b();
    }
}
