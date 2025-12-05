package p007b.p008a.p062y.p063j0;

import org.webrtc.RendererCommon;
import p007b.p100d.p104b.p105a.outline;
import p658rx.subjects.BehaviorSubject;

/* compiled from: RxRendererEvents.kt */
/* renamed from: b.a.y.j0.e, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxRendererEvents implements RendererCommon.RendererEvents {

    /* renamed from: j */
    public final BehaviorSubject<a> f2030j = BehaviorSubject.m11129k0();

    /* compiled from: RxRendererEvents.kt */
    /* renamed from: b.a.y.j0.e$a */
    public static final class a {

        /* renamed from: a */
        public final int f2031a;

        /* renamed from: b */
        public final int f2032b;

        /* renamed from: c */
        public final int f2033c;

        public a(int i, int i2, int i3) {
            this.f2031a = i;
            this.f2032b = i2;
            this.f2033c = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2031a == aVar.f2031a && this.f2032b == aVar.f2032b && this.f2033c == aVar.f2033c;
        }

        public int hashCode() {
            return (((this.f2031a * 31) + this.f2032b) * 31) + this.f2033c;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Resolution(width=");
            sbM833U.append(this.f2031a);
            sbM833U.append(", height=");
            sbM833U.append(this.f2032b);
            sbM833U.append(", rotation=");
            return outline.m814B(sbM833U, this.f2033c, ")");
        }
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
        this.f2030j.onNext(new a(i, i2, i3));
    }
}
