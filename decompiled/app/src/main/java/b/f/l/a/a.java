package b.f.l.a;

import b.f.l.a.b;
import b.f.l.b.c;

/* compiled from: MultiPointerGestureDetector.java */
/* loaded from: classes3.dex */
public class a {
    public boolean a;

    /* renamed from: b, reason: collision with root package name */
    public int f647b;
    public final int[] c = new int[2];
    public final float[] d = new float[2];
    public final float[] e = new float[2];
    public final float[] f = new float[2];
    public final float[] g = new float[2];
    public InterfaceC0076a h = null;

    /* compiled from: MultiPointerGestureDetector.java */
    /* renamed from: b.f.l.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0076a {
    }

    public a() {
        a();
    }

    public void a() {
        this.a = false;
        this.f647b = 0;
        for (int i = 0; i < 2; i++) {
            this.c[i] = -1;
        }
    }

    public final void b() {
        b bVar;
        b.a aVar;
        if (this.a) {
            return;
        }
        InterfaceC0076a interfaceC0076a = this.h;
        if (interfaceC0076a != null && (aVar = (bVar = (b) interfaceC0076a).f648b) != null) {
            aVar.c(bVar);
        }
        this.a = true;
    }

    public final void c() {
        b.a aVar;
        if (this.a) {
            this.a = false;
            InterfaceC0076a interfaceC0076a = this.h;
            if (interfaceC0076a == null || (aVar = ((b) interfaceC0076a).f648b) == null) {
                return;
            }
            b.f.d.e.a.i(c.class, "onGestureEnd");
        }
    }
}
