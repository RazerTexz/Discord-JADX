package b.i.a.c.a3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0;
import b.i.a.c.a3.b0;
import b.i.a.c.o2;
import b.i.a.c.w2.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: BaseMediaSource.java */
/* loaded from: classes3.dex */
public abstract class l implements a0 {
    public final ArrayList<a0.b> a = new ArrayList<>(1);

    /* renamed from: b, reason: collision with root package name */
    public final HashSet<a0.b> f827b = new HashSet<>(1);
    public final b0.a c = new b0.a();
    public final s.a d = new s.a();

    @Nullable
    public Looper e;

    @Nullable
    public o2 f;

    @Override // b.i.a.c.a3.a0
    public final void a(a0.b bVar) {
        this.a.remove(bVar);
        if (!this.a.isEmpty()) {
            d(bVar);
            return;
        }
        this.e = null;
        this.f = null;
        this.f827b.clear();
        s();
    }

    @Override // b.i.a.c.a3.a0
    public final void b(Handler handler, b0 b0Var) {
        b0.a aVar = this.c;
        Objects.requireNonNull(aVar);
        aVar.c.add(new b0.a.C0092a(handler, b0Var));
    }

    @Override // b.i.a.c.a3.a0
    public final void c(b0 b0Var) {
        b0.a aVar = this.c;
        Iterator<b0.a.C0092a> it = aVar.c.iterator();
        while (it.hasNext()) {
            b0.a.C0092a next = it.next();
            if (next.f808b == b0Var) {
                aVar.c.remove(next);
            }
        }
    }

    @Override // b.i.a.c.a3.a0
    public final void d(a0.b bVar) {
        boolean z2 = !this.f827b.isEmpty();
        this.f827b.remove(bVar);
        if (z2 && this.f827b.isEmpty()) {
            o();
        }
    }

    @Override // b.i.a.c.a3.a0
    public final void f(Handler handler, b.i.a.c.w2.s sVar) {
        s.a aVar = this.d;
        Objects.requireNonNull(aVar);
        aVar.c.add(new s.a.C0101a(handler, sVar));
    }

    @Override // b.i.a.c.a3.a0
    public final void g(b.i.a.c.w2.s sVar) {
        s.a aVar = this.d;
        Iterator<s.a.C0101a> it = aVar.c.iterator();
        while (it.hasNext()) {
            s.a.C0101a next = it.next();
            if (next.f1157b == sVar) {
                aVar.c.remove(next);
            }
        }
    }

    @Override // b.i.a.c.a3.a0
    public /* synthetic */ boolean i() {
        return z.b(this);
    }

    @Override // b.i.a.c.a3.a0
    public /* synthetic */ o2 k() {
        return z.a(this);
    }

    @Override // b.i.a.c.a3.a0
    public final void l(a0.b bVar, @Nullable b.i.a.c.e3.a0 a0Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.e;
        b.c.a.a0.d.j(looper == null || looper == looperMyLooper);
        o2 o2Var = this.f;
        this.a.add(bVar);
        if (this.e == null) {
            this.e = looperMyLooper;
            this.f827b.add(bVar);
            q(a0Var);
        } else if (o2Var != null) {
            m(bVar);
            bVar.a(this, o2Var);
        }
    }

    @Override // b.i.a.c.a3.a0
    public final void m(a0.b bVar) {
        Objects.requireNonNull(this.e);
        boolean zIsEmpty = this.f827b.isEmpty();
        this.f827b.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    public void o() {
    }

    public void p() {
    }

    public abstract void q(@Nullable b.i.a.c.e3.a0 a0Var);

    public final void r(o2 o2Var) {
        this.f = o2Var;
        Iterator<a0.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this, o2Var);
        }
    }

    public abstract void s();
}
