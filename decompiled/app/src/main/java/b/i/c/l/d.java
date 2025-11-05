package b.i.c.l;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* compiled from: Component.java */
/* loaded from: classes3.dex */
public final class d<T> {
    public final Set<Class<? super T>> a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<o> f1662b;
    public final int c;
    public final int d;
    public final f<T> e;
    public final Set<Class<?>> f;

    /* compiled from: Component.java */
    public static class b<T> {
        public final Set<Class<? super T>> a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<o> f1663b;
        public int c;
        public int d;
        public f<T> e;
        public Set<Class<?>> f;

        public b(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.f1663b = new HashSet();
            this.c = 0;
            this.d = 0;
            this.f = new HashSet();
            Objects.requireNonNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                Objects.requireNonNull(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }

        public b<T> a(o oVar) {
            if (!(!this.a.contains(oVar.a))) {
                throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
            }
            this.f1663b.add(oVar);
            return this;
        }

        public d<T> b() {
            if (this.e != null) {
                return new d<>(new HashSet(this.a), new HashSet(this.f1663b), this.c, this.d, this.e, this.f, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public b<T> c(f<T> fVar) {
            this.e = fVar;
            return this;
        }

        public final b<T> d(int i) {
            if (!(this.c == 0)) {
                throw new IllegalStateException("Instantiation type has already been set.");
            }
            this.c = i;
            return this;
        }
    }

    public d(Set set, Set set2, int i, int i2, f fVar, Set set3, a aVar) {
        this.a = Collections.unmodifiableSet(set);
        this.f1662b = Collections.unmodifiableSet(set2);
        this.c = i;
        this.d = i2;
        this.e = fVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> d<T> c(T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.c(new b.i.c.l.b(t));
        return bVar.b();
    }

    public boolean b() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.f1662b.toArray()) + "}";
    }
}
