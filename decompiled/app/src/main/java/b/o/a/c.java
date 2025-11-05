package b.o.a;

import androidx.annotation.NonNull;
import b.o.a.m.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CameraOptions.java */
/* loaded from: classes3.dex */
public abstract class c {
    public Set<m> a = new HashSet(5);

    /* renamed from: b, reason: collision with root package name */
    public Set<b.o.a.m.e> f1911b = new HashSet(2);
    public Set<b.o.a.m.f> c = new HashSet(4);
    public Set<b.o.a.m.h> d = new HashSet(2);
    public Set<b.o.a.x.b> e = new HashSet(15);
    public Set<b.o.a.x.b> f = new HashSet(5);
    public Set<b.o.a.x.a> g = new HashSet(4);
    public Set<b.o.a.x.a> h = new HashSet(3);
    public Set<b.o.a.m.j> i = new HashSet(2);
    public Set<Integer> j = new HashSet(2);
    public boolean k;
    public boolean l;
    public float m;
    public float n;
    public boolean o;
    public float p;
    public float q;

    @NonNull
    public final Collection<b.o.a.m.e> a() {
        return Collections.unmodifiableSet(this.f1911b);
    }

    @NonNull
    public final Collection<b.o.a.m.f> b() {
        return Collections.unmodifiableSet(this.c);
    }

    public final boolean c(@NonNull b.o.a.m.c cVar) {
        Class<?> cls = cVar.getClass();
        return (cls.equals(b.o.a.m.a.class) ? Arrays.asList(b.o.a.m.a.values()) : cls.equals(b.o.a.m.e.class) ? a() : cls.equals(b.o.a.m.f.class) ? b() : cls.equals(b.o.a.m.g.class) ? Arrays.asList(b.o.a.m.g.values()) : cls.equals(b.o.a.m.h.class) ? Collections.unmodifiableSet(this.d) : cls.equals(b.o.a.m.i.class) ? Arrays.asList(b.o.a.m.i.values()) : cls.equals(b.o.a.m.l.class) ? Arrays.asList(b.o.a.m.l.values()) : cls.equals(b.o.a.m.b.class) ? Arrays.asList(b.o.a.m.b.values()) : cls.equals(m.class) ? Collections.unmodifiableSet(this.a) : cls.equals(b.o.a.m.d.class) ? Arrays.asList(b.o.a.m.d.values()) : cls.equals(b.o.a.m.k.class) ? Arrays.asList(b.o.a.m.k.values()) : cls.equals(b.o.a.m.j.class) ? Collections.unmodifiableSet(this.i) : Collections.emptyList()).contains(cVar);
    }
}
