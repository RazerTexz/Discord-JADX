package b.o.a.v;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.l;
import b.o.a.u.a;
import b.o.a.v.d;
import java.util.Objects;

/* compiled from: SnapshotGlPictureRecorder.java */
/* loaded from: classes3.dex */
public class g extends i {
    public b.o.a.w.e n;
    public b.o.a.x.a o;
    public b.o.a.u.a p;
    public boolean q;
    public b.o.a.u.b r;

    /* renamed from: s, reason: collision with root package name */
    public b.o.a.r.c f1956s;

    /* compiled from: SnapshotGlPictureRecorder.java */
    public class a implements b.o.a.w.f {
        public a() {
        }

        @Override // b.o.a.w.f
        public void a(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2) {
            g.this.n.d(this);
            g gVar = g.this;
            Objects.requireNonNull(gVar);
            b.o.a.r.g.a(new h(gVar, surfaceTexture, i, f, f2, EGL14.eglGetCurrentContext()));
        }

        @Override // b.o.a.w.f
        public void b(int i) {
            g gVar = g.this;
            Objects.requireNonNull(gVar);
            gVar.f1956s = new b.o.a.r.c(new b.o.b.f.b(33984, 36197, Integer.valueOf(i)));
            Rect rectL = b.i.a.f.e.o.f.L(gVar.j.d, gVar.o);
            gVar.j.d = new b.o.a.x.b(rectL.width(), rectL.height());
            if (gVar.q) {
                gVar.r = new b.o.a.u.b(gVar.p, gVar.j.d);
            }
        }

        @Override // b.o.a.w.f
        public void c(@NonNull b.o.a.o.b bVar) {
            g.this.f1956s.d = bVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g(@NonNull l.a aVar, @Nullable d.a aVar2, @NonNull b.o.a.w.e eVar, @NonNull b.o.a.x.a aVar3, @Nullable b.o.a.u.a aVar4) {
        boolean z2;
        super(aVar, aVar2);
        this.n = eVar;
        this.o = aVar3;
        this.p = aVar4;
        if (aVar4 != null) {
            z2 = ((b.o.a.u.c) aVar4).b(a.EnumC0177a.PICTURE_SNAPSHOT);
        }
        this.q = z2;
    }

    @Override // b.o.a.v.d
    public void b() {
        this.o = null;
        super.b();
    }

    @Override // b.o.a.v.d
    @TargetApi(19)
    public void c() {
        this.n.b(new a());
    }
}
