package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p243a3.MaskingMediaSource;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* JADX INFO: renamed from: b.i.a.c.a3.o, reason: use source file name */
/* JADX INFO: compiled from: CompositeMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {

    /* JADX INFO: renamed from: g */
    public final HashMap<T, b<T>> f5664g = new HashMap<>();

    /* JADX INFO: renamed from: h */
    @Nullable
    public Handler f5665h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public TransferListener f5666i;

    /* JADX INFO: renamed from: b.i.a.c.a3.o$a */
    /* JADX INFO: compiled from: CompositeMediaSource.java */
    public final class a implements MediaSourceEventListener, DrmSessionEventListener {

        /* JADX INFO: renamed from: j */
        public final T f5667j;

        /* JADX INFO: renamed from: k */
        public MediaSourceEventListener.a f5668k;

        /* JADX INFO: renamed from: l */
        public DrmSessionEventListener.a f5669l;

        public a(T t) {
            this.f5668k = CompositeMediaSource.this.f5635c.m2472g(0, null, 0L);
            this.f5669l = CompositeMediaSource.this.f5636d.m3593g(0, null);
            this.f5667j = t;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* JADX INFO: renamed from: J */
        public void mo2567J(int i, @Nullable MediaSource2.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3588b();
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* JADX INFO: renamed from: S */
        public void mo2568S(int i, @Nullable MediaSource2.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3587a();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* JADX INFO: renamed from: X */
        public void mo2461X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            m2569a(i, aVar);
            this.f5668k.m2469d(loadEventInfo, m2570b(mediaLoadData));
        }

        /* JADX INFO: renamed from: a */
        public final boolean m2569a(int i, @Nullable MediaSource2.a aVar) {
            MediaSource2.a aVarM2460b;
            if (aVar != null) {
                CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
                T t = this.f5667j;
                MaskingMediaSource maskingMediaSource = (MaskingMediaSource) compositeMediaSource;
                Objects.requireNonNull(maskingMediaSource);
                Object obj = aVar.f5732a;
                Object obj2 = maskingMediaSource.f5716n.f5723n;
                if (obj2 != null && obj2.equals(obj)) {
                    obj = MaskingMediaSource.a.f5721l;
                }
                aVarM2460b = aVar.m2460b(obj);
            } else {
                aVarM2460b = null;
            }
            Objects.requireNonNull(CompositeMediaSource.this);
            MediaSourceEventListener.a aVar2 = this.f5668k;
            if (aVar2.f5481a != i || !Util2.m2993a(aVar2.f5482b, aVarM2460b)) {
                this.f5668k = CompositeMediaSource.this.f5635c.m2472g(i, aVarM2460b, 0L);
            }
            DrmSessionEventListener.a aVar3 = this.f5669l;
            if (aVar3.f8012a == i && Util2.m2993a(aVar3.f8013b, aVarM2460b)) {
                return true;
            }
            this.f5669l = new DrmSessionEventListener.a(CompositeMediaSource.this.f5636d.f8014c, i, aVarM2460b);
            return true;
        }

        /* JADX INFO: renamed from: b */
        public final MediaLoadData m2570b(MediaLoadData mediaLoadData) {
            CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
            long j = mediaLoadData.f5730f;
            Objects.requireNonNull(compositeMediaSource);
            CompositeMediaSource compositeMediaSource2 = CompositeMediaSource.this;
            long j2 = mediaLoadData.f5731g;
            Objects.requireNonNull(compositeMediaSource2);
            return (j == mediaLoadData.f5730f && j2 == mediaLoadData.f5731g) ? mediaLoadData : new MediaLoadData(mediaLoadData.f5725a, mediaLoadData.f5726b, mediaLoadData.f5727c, mediaLoadData.f5728d, mediaLoadData.f5729e, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* JADX INFO: renamed from: c0 */
        public void mo2571c0(int i, @Nullable MediaSource2.a aVar, int i2) {
            m2569a(i, aVar);
            this.f5669l.m3590d(i2);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* JADX INFO: renamed from: d0 */
        public void mo2572d0(int i, @Nullable MediaSource2.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3592f();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* JADX INFO: renamed from: g0 */
        public void mo2462g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            m2569a(i, aVar);
            this.f5668k.m2470e(loadEventInfo, m2570b(mediaLoadData), iOException, z2);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* JADX INFO: renamed from: i0 */
        public void mo2573i0(int i, @Nullable MediaSource2.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3589c();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* JADX INFO: renamed from: o */
        public void mo2463o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData) {
            m2569a(i, aVar);
            this.f5668k.m2467b(m2570b(mediaLoadData));
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* JADX INFO: renamed from: q */
        public void mo2464q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            m2569a(i, aVar);
            this.f5668k.m2468c(loadEventInfo, m2570b(mediaLoadData));
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* JADX INFO: renamed from: u */
        public void mo2574u(int i, @Nullable MediaSource2.a aVar, Exception exc) {
            m2569a(i, aVar);
            this.f5669l.m3591e(exc);
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* JADX INFO: renamed from: x */
        public void mo2465x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            m2569a(i, aVar);
            this.f5668k.m2471f(loadEventInfo, m2570b(mediaLoadData));
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.o$b */
    /* JADX INFO: compiled from: CompositeMediaSource.java */
    public static final class b<T> {

        /* JADX INFO: renamed from: a */
        public final MediaSource2 f5671a;

        /* JADX INFO: renamed from: b */
        public final MediaSource2.b f5672b;

        /* JADX INFO: renamed from: c */
        public final CompositeMediaSource<T>.a f5673c;

        public b(MediaSource2 mediaSource2, MediaSource2.b bVar, CompositeMediaSource<T>.a aVar) {
            this.f5671a = mediaSource2;
            this.f5672b = bVar;
            this.f5673c = aVar;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.BaseMediaSource
    @CallSuper
    /* JADX INFO: renamed from: o */
    public void mo2551o() {
        for (b<T> bVar : this.f5664g.values()) {
            bVar.f5671a.mo2449d(bVar.f5672b);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.BaseMediaSource
    @CallSuper
    /* JADX INFO: renamed from: p */
    public void mo2552p() {
        for (b<T> bVar : this.f5664g.values()) {
            bVar.f5671a.mo2458m(bVar.f5672b);
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m2566t(T t, MediaSource2 mediaSource2) {
        AnimatableValueParser.m531j(!this.f5664g.containsKey(null));
        MediaSource2.b c2529a = new C2529a(this, null);
        a aVar = new a(null);
        this.f5664g.put(null, new b<>(mediaSource2, c2529a, aVar));
        Handler handler = this.f5665h;
        Objects.requireNonNull(handler);
        mediaSource2.mo2447b(handler, aVar);
        Handler handler2 = this.f5665h;
        Objects.requireNonNull(handler2);
        mediaSource2.mo2451f(handler2, aVar);
        mediaSource2.mo2457l(c2529a, this.f5666i);
        if (!this.f5634b.isEmpty()) {
            return;
        }
        mediaSource2.mo2449d(c2529a);
    }
}
