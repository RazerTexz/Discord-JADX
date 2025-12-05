package p007b.p225i.p226a.p242c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import p007b.p225i.p226a.p242c.p243a3.LoadEventInfo;
import p007b.p225i.p226a.p242c.p243a3.MaskingMediaPeriod;
import p007b.p225i.p226a.p242c.p243a3.MaskingMediaSource;
import p007b.p225i.p226a.p242c.p243a3.MediaLoadData;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriod;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;
import p007b.p225i.p226a.p242c.p243a3.ShuffleOrder;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* compiled from: MediaSourceList.java */
/* renamed from: b.i.a.c.u1, reason: use source file name */
/* loaded from: classes3.dex */
public final class MediaSourceList {

    /* renamed from: d */
    public final d f7867d;

    /* renamed from: e */
    public final MediaSourceEventListener.a f7868e;

    /* renamed from: f */
    public final DrmSessionEventListener.a f7869f;

    /* renamed from: g */
    public final HashMap<c, b> f7870g;

    /* renamed from: h */
    public final Set<c> f7871h;

    /* renamed from: j */
    public boolean f7873j;

    /* renamed from: k */
    @Nullable
    public TransferListener f7874k;

    /* renamed from: i */
    public ShuffleOrder f7872i = new ShuffleOrder.a(0, new Random());

    /* renamed from: b */
    public final IdentityHashMap<MediaPeriod, c> f7865b = new IdentityHashMap<>();

    /* renamed from: c */
    public final Map<Object, c> f7866c = new HashMap();

    /* renamed from: a */
    public final List<c> f7864a = new ArrayList();

    /* compiled from: MediaSourceList.java */
    /* renamed from: b.i.a.c.u1$a */
    public final class a implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: j */
        public final c f7875j;

        /* renamed from: k */
        public MediaSourceEventListener.a f7876k;

        /* renamed from: l */
        public DrmSessionEventListener.a f7877l;

        public a(c cVar) {
            this.f7876k = MediaSourceList.this.f7868e;
            this.f7877l = MediaSourceList.this.f7869f;
            this.f7875j = cVar;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* renamed from: J */
        public void mo2567J(int i, @Nullable MediaSource2.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3588b();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* renamed from: S */
        public void mo2568S(int i, @Nullable MediaSource2.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3587a();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* renamed from: X */
        public void mo2461X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2469d(loadEventInfo, mediaLoadData);
            }
        }

        /* renamed from: a */
        public final boolean m3544a(int i, @Nullable MediaSource2.a aVar) {
            MediaSource2.a aVarM2460b = null;
            if (aVar != null) {
                c cVar = this.f7875j;
                int i2 = 0;
                while (true) {
                    if (i2 >= cVar.f7884c.size()) {
                        break;
                    }
                    if (cVar.f7884c.get(i2).f5735d == aVar.f5735d) {
                        aVarM2460b = aVar.m2460b(Pair.create(cVar.f7883b, aVar.f5732a));
                        break;
                    }
                    i2++;
                }
                if (aVarM2460b == null) {
                    return false;
                }
            }
            int i3 = i + this.f7875j.f7885d;
            MediaSourceEventListener.a aVar2 = this.f7876k;
            if (aVar2.f5481a != i3 || !Util2.m2993a(aVar2.f5482b, aVarM2460b)) {
                this.f7876k = MediaSourceList.this.f7868e.m2472g(i3, aVarM2460b, 0L);
            }
            DrmSessionEventListener.a aVar3 = this.f7877l;
            if (aVar3.f8012a == i3 && Util2.m2993a(aVar3.f8013b, aVarM2460b)) {
                return true;
            }
            this.f7877l = MediaSourceList.this.f7869f.m3593g(i3, aVarM2460b);
            return true;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* renamed from: c0 */
        public void mo2571c0(int i, @Nullable MediaSource2.a aVar, int i2) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3590d(i2);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* renamed from: d0 */
        public void mo2572d0(int i, @Nullable MediaSource2.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3592f();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* renamed from: g0 */
        public void mo2462g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2470e(loadEventInfo, mediaLoadData, iOException, z2);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* renamed from: i0 */
        public void mo2573i0(int i, @Nullable MediaSource2.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3589c();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* renamed from: o */
        public void mo2463o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2467b(mediaLoadData);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* renamed from: q */
        public void mo2464q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2468c(loadEventInfo, mediaLoadData);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
        /* renamed from: u */
        public void mo2574u(int i, @Nullable MediaSource2.a aVar, Exception exc) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3591e(exc);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
        /* renamed from: x */
        public void mo2465x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2471f(loadEventInfo, mediaLoadData);
            }
        }
    }

    /* compiled from: MediaSourceList.java */
    /* renamed from: b.i.a.c.u1$b */
    public static final class b {

        /* renamed from: a */
        public final MediaSource2 f7879a;

        /* renamed from: b */
        public final MediaSource2.b f7880b;

        /* renamed from: c */
        public final a f7881c;

        public b(MediaSource2 mediaSource2, MediaSource2.b bVar, a aVar) {
            this.f7879a = mediaSource2;
            this.f7880b = bVar;
            this.f7881c = aVar;
        }
    }

    /* compiled from: MediaSourceList.java */
    /* renamed from: b.i.a.c.u1$c */
    public static final class c implements MediaSourceInfoHolder {

        /* renamed from: a */
        public final MaskingMediaSource f7882a;

        /* renamed from: d */
        public int f7885d;

        /* renamed from: e */
        public boolean f7886e;

        /* renamed from: c */
        public final List<MediaSource2.a> f7884c = new ArrayList();

        /* renamed from: b */
        public final Object f7883b = new Object();

        public c(MediaSource2 mediaSource2, boolean z2) {
            this.f7882a = new MaskingMediaSource(mediaSource2, z2);
        }

        @Override // p007b.p225i.p226a.p242c.MediaSourceInfoHolder
        /* renamed from: a */
        public Timeline mo2931a() {
            return this.f7882a.f5716n;
        }

        @Override // p007b.p225i.p226a.p242c.MediaSourceInfoHolder
        public Object getUid() {
            return this.f7883b;
        }
    }

    /* compiled from: MediaSourceList.java */
    /* renamed from: b.i.a.c.u1$d */
    public interface d {
    }

    public MediaSourceList(d dVar, @Nullable AnalyticsCollector analyticsCollector, Handler handler) {
        this.f7867d = dVar;
        MediaSourceEventListener.a aVar = new MediaSourceEventListener.a();
        this.f7868e = aVar;
        DrmSessionEventListener.a aVar2 = new DrmSessionEventListener.a();
        this.f7869f = aVar2;
        this.f7870g = new HashMap<>();
        this.f7871h = new HashSet();
        if (analyticsCollector != null) {
            aVar.f5483c.add(new MediaSourceEventListener.a.C13222a(handler, analyticsCollector));
            aVar2.f8014c.add(new DrmSessionEventListener.a.C13226a(handler, analyticsCollector));
        }
    }

    /* renamed from: a */
    public Timeline m3535a(int i, List<c> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.f7872i = shuffleOrder;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.f7864a.get(i2 - 1);
                    cVar.f7885d = cVar2.f7882a.f5716n.mo2557p() + cVar2.f7885d;
                    cVar.f7886e = false;
                    cVar.f7884c.clear();
                } else {
                    cVar.f7885d = 0;
                    cVar.f7886e = false;
                    cVar.f7884c.clear();
                }
                m3536b(i2, cVar.f7882a.f5716n.mo2557p());
                this.f7864a.add(i2, cVar);
                this.f7866c.put(cVar.f7883b, cVar);
                if (this.f7873j) {
                    m3541g(cVar);
                    if (this.f7865b.isEmpty()) {
                        this.f7871h.add(cVar);
                    } else {
                        b bVar = this.f7870g.get(cVar);
                        if (bVar != null) {
                            bVar.f7879a.mo2449d(bVar.f7880b);
                        }
                    }
                }
            }
        }
        return m3537c();
    }

    /* renamed from: b */
    public final void m3536b(int i, int i2) {
        while (i < this.f7864a.size()) {
            this.f7864a.get(i).f7885d += i2;
            i++;
        }
    }

    /* renamed from: c */
    public Timeline m3537c() {
        if (this.f7864a.isEmpty()) {
            return Timeline.f7337j;
        }
        int iMo2557p = 0;
        for (int i = 0; i < this.f7864a.size(); i++) {
            c cVar = this.f7864a.get(i);
            cVar.f7885d = iMo2557p;
            iMo2557p += cVar.f7882a.f5716n.mo2557p();
        }
        return new PlaylistTimeline(this.f7864a, this.f7872i);
    }

    /* renamed from: d */
    public final void m3538d() {
        Iterator<c> it = this.f7871h.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f7884c.isEmpty()) {
                b bVar = this.f7870g.get(next);
                if (bVar != null) {
                    bVar.f7879a.mo2449d(bVar.f7880b);
                }
                it.remove();
            }
        }
    }

    /* renamed from: e */
    public int m3539e() {
        return this.f7864a.size();
    }

    /* renamed from: f */
    public final void m3540f(c cVar) {
        if (cVar.f7886e && cVar.f7884c.isEmpty()) {
            b bVarRemove = this.f7870g.remove(cVar);
            Objects.requireNonNull(bVarRemove);
            bVarRemove.f7879a.mo2446a(bVarRemove.f7880b);
            bVarRemove.f7879a.mo2448c(bVarRemove.f7881c);
            bVarRemove.f7879a.mo2452g(bVarRemove.f7881c);
            this.f7871h.remove(cVar);
        }
    }

    /* renamed from: g */
    public final void m3541g(c cVar) {
        MaskingMediaSource maskingMediaSource = cVar.f7882a;
        C2826n0 c2826n0 = new C2826n0(this);
        a aVar = new a(cVar);
        this.f7870g.put(cVar, new b(maskingMediaSource, c2826n0, aVar));
        Handler handler = new Handler(Util2.m3007o(), null);
        Objects.requireNonNull(maskingMediaSource);
        MediaSourceEventListener.a aVar2 = maskingMediaSource.f5635c;
        Objects.requireNonNull(aVar2);
        aVar2.f5483c.add(new MediaSourceEventListener.a.C13222a(handler, aVar));
        Handler handler2 = new Handler(Util2.m3007o(), null);
        DrmSessionEventListener.a aVar3 = maskingMediaSource.f5636d;
        Objects.requireNonNull(aVar3);
        aVar3.f8014c.add(new DrmSessionEventListener.a.C13226a(handler2, aVar));
        maskingMediaSource.mo2457l(c2826n0, this.f7874k);
    }

    /* renamed from: h */
    public void m3542h(MediaPeriod mediaPeriod) {
        c cVarRemove = this.f7865b.remove(mediaPeriod);
        Objects.requireNonNull(cVarRemove);
        cVarRemove.f7882a.mo2455j(mediaPeriod);
        cVarRemove.f7884c.remove(((MaskingMediaPeriod) mediaPeriod).f5705j);
        if (!this.f7865b.isEmpty()) {
            m3538d();
        }
        m3540f(cVarRemove);
    }

    /* renamed from: i */
    public final void m3543i(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVarRemove = this.f7864a.remove(i3);
            this.f7866c.remove(cVarRemove.f7883b);
            m3536b(i3, -cVarRemove.f7882a.f5716n.mo2557p());
            cVarRemove.f7886e = true;
            if (this.f7873j) {
                m3540f(cVarRemove);
            }
        }
    }
}
