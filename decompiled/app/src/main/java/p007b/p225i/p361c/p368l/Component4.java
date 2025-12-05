package p007b.p225i.p361c.p368l;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* compiled from: Component.java */
/* renamed from: b.i.c.l.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Component4<T> {

    /* renamed from: a */
    public final Set<Class<? super T>> f12175a;

    /* renamed from: b */
    public final Set<Dependency2> f12176b;

    /* renamed from: c */
    public final int f12177c;

    /* renamed from: d */
    public final int f12178d;

    /* renamed from: e */
    public final ComponentFactory<T> f12179e;

    /* renamed from: f */
    public final Set<Class<?>> f12180f;

    /* compiled from: Component.java */
    /* renamed from: b.i.c.l.d$b */
    public static class b<T> {

        /* renamed from: a */
        public final Set<Class<? super T>> f12181a;

        /* renamed from: b */
        public final Set<Dependency2> f12182b;

        /* renamed from: c */
        public int f12183c;

        /* renamed from: d */
        public int f12184d;

        /* renamed from: e */
        public ComponentFactory<T> f12185e;

        /* renamed from: f */
        public Set<Class<?>> f12186f;

        public b(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.f12181a = hashSet;
            this.f12182b = new HashSet();
            this.f12183c = 0;
            this.f12184d = 0;
            this.f12186f = new HashSet();
            Objects.requireNonNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                Objects.requireNonNull(cls2, "Null interface");
            }
            Collections.addAll(this.f12181a, clsArr);
        }

        /* renamed from: a */
        public b<T> m6351a(Dependency2 dependency2) {
            if (!(!this.f12181a.contains(dependency2.f12201a))) {
                throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
            }
            this.f12182b.add(dependency2);
            return this;
        }

        /* renamed from: b */
        public Component4<T> m6352b() {
            if (this.f12185e != null) {
                return new Component4<>(new HashSet(this.f12181a), new HashSet(this.f12182b), this.f12183c, this.f12184d, this.f12185e, this.f12186f, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        /* renamed from: c */
        public b<T> m6353c(ComponentFactory<T> componentFactory) {
            this.f12185e = componentFactory;
            return this;
        }

        /* renamed from: d */
        public final b<T> m6354d(int i) {
            if (!(this.f12183c == 0)) {
                throw new IllegalStateException("Instantiation type has already been set.");
            }
            this.f12183c = i;
            return this;
        }
    }

    public Component4(Set set, Set set2, int i, int i2, ComponentFactory componentFactory, Set set3, a aVar) {
        this.f12175a = Collections.unmodifiableSet(set);
        this.f12176b = Collections.unmodifiableSet(set2);
        this.f12177c = i;
        this.f12178d = i2;
        this.f12179e = componentFactory;
        this.f12180f = Collections.unmodifiableSet(set3);
    }

    /* renamed from: a */
    public static <T> b<T> m6348a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    /* renamed from: c */
    public static <T> Component4<T> m6349c(T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.m6353c(new Component2(t));
        return bVar.m6352b();
    }

    /* renamed from: b */
    public boolean m6350b() {
        return this.f12178d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f12175a.toArray()) + ">{" + this.f12177c + ", type=" + this.f12178d + ", deps=" + Arrays.toString(this.f12176b.toArray()) + "}";
    }
}
