package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* compiled from: BaseMediaSource.java */
/* renamed from: b.i.a.c.a3.l, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseMediaSource implements MediaSource2 {

    /* renamed from: a */
    public final ArrayList<MediaSource2.b> f5633a = new ArrayList<>(1);

    /* renamed from: b */
    public final HashSet<MediaSource2.b> f5634b = new HashSet<>(1);

    /* renamed from: c */
    public final MediaSourceEventListener.a f5635c = new MediaSourceEventListener.a();

    /* renamed from: d */
    public final DrmSessionEventListener.a f5636d = new DrmSessionEventListener.a();

    /* renamed from: e */
    @Nullable
    public Looper f5637e;

    /* renamed from: f */
    @Nullable
    public Timeline f5638f;

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: a */
    public final void mo2446a(MediaSource2.b bVar) {
        this.f5633a.remove(bVar);
        if (!this.f5633a.isEmpty()) {
            mo2449d(bVar);
            return;
        }
        this.f5637e = null;
        this.f5638f = null;
        this.f5634b.clear();
        mo2510s();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: b */
    public final void mo2447b(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        MediaSourceEventListener.a aVar = this.f5635c;
        Objects.requireNonNull(aVar);
        aVar.f5483c.add(new MediaSourceEventListener.a.C13222a(handler, mediaSourceEventListener));
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: c */
    public final void mo2448c(MediaSourceEventListener mediaSourceEventListener) {
        MediaSourceEventListener.a aVar = this.f5635c;
        for (MediaSourceEventListener.a.C13222a c13222a : aVar.f5483c) {
            if (c13222a.f5486b == mediaSourceEventListener) {
                aVar.f5483c.remove(c13222a);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: d */
    public final void mo2449d(MediaSource2.b bVar) {
        boolean z2 = !this.f5634b.isEmpty();
        this.f5634b.remove(bVar);
        if (z2 && this.f5634b.isEmpty()) {
            mo2551o();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: f */
    public final void mo2451f(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        DrmSessionEventListener.a aVar = this.f5636d;
        Objects.requireNonNull(aVar);
        aVar.f8014c.add(new DrmSessionEventListener.a.C13226a(handler, drmSessionEventListener));
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: g */
    public final void mo2452g(DrmSessionEventListener drmSessionEventListener) {
        DrmSessionEventListener.a aVar = this.f5636d;
        for (DrmSessionEventListener.a.C13226a c13226a : aVar.f8014c) {
            if (c13226a.f8016b == drmSessionEventListener) {
                aVar.f8014c.remove(c13226a);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: i */
    public /* synthetic */ boolean mo2454i() {
        return MediaSource3.m2595b(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: k */
    public /* synthetic */ Timeline mo2456k() {
        return MediaSource3.m2594a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: l */
    public final void mo2457l(MediaSource2.b bVar, @Nullable TransferListener transferListener) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f5637e;
        AnimatableValueParser.m531j(looper == null || looper == looperMyLooper);
        Timeline timeline = this.f5638f;
        this.f5633a.add(bVar);
        if (this.f5637e == null) {
            this.f5637e = looperMyLooper;
            this.f5634b.add(bVar);
            mo2509q(transferListener);
        } else if (timeline != null) {
            mo2458m(bVar);
            bVar.mo2445a(this, timeline);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: m */
    public final void mo2458m(MediaSource2.b bVar) {
        Objects.requireNonNull(this.f5637e);
        boolean zIsEmpty = this.f5634b.isEmpty();
        this.f5634b.add(bVar);
        if (zIsEmpty) {
            mo2552p();
        }
    }

    /* renamed from: o */
    public void mo2551o() {
    }

    /* renamed from: p */
    public void mo2552p() {
    }

    /* renamed from: q */
    public abstract void mo2509q(@Nullable TransferListener transferListener);

    /* renamed from: r */
    public final void m2553r(Timeline timeline) {
        this.f5638f = timeline;
        Iterator<MediaSource2.b> it = this.f5633a.iterator();
        while (it.hasNext()) {
            it.next().mo2445a(this, timeline);
        }
    }

    /* renamed from: s */
    public abstract void mo2510s();
}
