package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AnnotationCollector.java */
/* loaded from: classes3.dex */
public abstract class o {
    public static final b.g.a.c.i0.a a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final Object f692b;

    /* compiled from: AnnotationCollector.java */
    public static class a extends o {
        public static final a c = new a(null);

        public a(Object obj) {
            super(null);
        }

        @Override // b.g.a.c.c0.o
        public o a(Annotation annotation) {
            return new e(this.f692b, annotation.annotationType(), annotation);
        }

        @Override // b.g.a.c.c0.o
        public p b() {
            return new p();
        }

        @Override // b.g.a.c.c0.o
        public b.g.a.c.i0.a c() {
            return o.a;
        }

        @Override // b.g.a.c.c0.o
        public boolean d(Annotation annotation) {
            return false;
        }
    }

    /* compiled from: AnnotationCollector.java */
    public static class b extends o {
        public final HashMap<Class<?>, Annotation> c;

        public b(Object obj, Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            super(obj);
            HashMap<Class<?>, Annotation> map = new HashMap<>();
            this.c = map;
            map.put(cls, annotation);
            map.put(cls2, annotation2);
        }

        @Override // b.g.a.c.c0.o
        public o a(Annotation annotation) {
            this.c.put(annotation.annotationType(), annotation);
            return this;
        }

        @Override // b.g.a.c.c0.o
        public p b() {
            p pVar = new p();
            for (Annotation annotation : this.c.values()) {
                if (pVar.j == null) {
                    pVar.j = new HashMap<>();
                }
                Annotation annotationPut = pVar.j.put(annotation.annotationType(), annotation);
                if (annotationPut != null) {
                    annotationPut.equals(annotation);
                }
            }
            return pVar;
        }

        @Override // b.g.a.c.c0.o
        public b.g.a.c.i0.a c() {
            if (this.c.size() != 2) {
                return new p(this.c);
            }
            Iterator<Map.Entry<Class<?>, Annotation>> it = this.c.entrySet().iterator();
            Map.Entry<Class<?>, Annotation> next = it.next();
            Map.Entry<Class<?>, Annotation> next2 = it.next();
            return new f(next.getKey(), next.getValue(), next2.getKey(), next2.getValue());
        }

        @Override // b.g.a.c.c0.o
        public boolean d(Annotation annotation) {
            return this.c.containsKey(annotation.annotationType());
        }
    }

    /* compiled from: AnnotationCollector.java */
    public static class c implements b.g.a.c.i0.a, Serializable {
        private static final long serialVersionUID = 1;

        @Override // b.g.a.c.i0.a
        public <A extends Annotation> A a(Class<A> cls) {
            return null;
        }

        @Override // b.g.a.c.i0.a
        public int size() {
            return 0;
        }
    }

    /* compiled from: AnnotationCollector.java */
    public static class d implements b.g.a.c.i0.a, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _type;
        private final Annotation _value;

        public d(Class<?> cls, Annotation annotation) {
            this._type = cls;
            this._value = annotation;
        }

        @Override // b.g.a.c.i0.a
        public <A extends Annotation> A a(Class<A> cls) {
            if (this._type == cls) {
                return (A) this._value;
            }
            return null;
        }

        @Override // b.g.a.c.i0.a
        public int size() {
            return 1;
        }
    }

    /* compiled from: AnnotationCollector.java */
    public static class e extends o {
        public Class<?> c;
        public Annotation d;

        public e(Object obj, Class<?> cls, Annotation annotation) {
            super(obj);
            this.c = cls;
            this.d = annotation;
        }

        @Override // b.g.a.c.c0.o
        public o a(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<?> cls = this.c;
            if (cls != clsAnnotationType) {
                return new b(this.f692b, cls, this.d, clsAnnotationType, annotation);
            }
            this.d = annotation;
            return this;
        }

        @Override // b.g.a.c.c0.o
        public p b() {
            Class<?> cls = this.c;
            Annotation annotation = this.d;
            HashMap map = new HashMap(4);
            map.put(cls, annotation);
            return new p(map);
        }

        @Override // b.g.a.c.c0.o
        public b.g.a.c.i0.a c() {
            return new d(this.c, this.d);
        }

        @Override // b.g.a.c.c0.o
        public boolean d(Annotation annotation) {
            return annotation.annotationType() == this.c;
        }
    }

    /* compiled from: AnnotationCollector.java */
    public static class f implements b.g.a.c.i0.a, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _type1;
        private final Class<?> _type2;
        private final Annotation _value1;
        private final Annotation _value2;

        public f(Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            this._type1 = cls;
            this._value1 = annotation;
            this._type2 = cls2;
            this._value2 = annotation2;
        }

        @Override // b.g.a.c.i0.a
        public <A extends Annotation> A a(Class<A> cls) {
            if (this._type1 == cls) {
                return (A) this._value1;
            }
            if (this._type2 == cls) {
                return (A) this._value2;
            }
            return null;
        }

        @Override // b.g.a.c.i0.a
        public int size() {
            return 2;
        }
    }

    public o(Object obj) {
        this.f692b = obj;
    }

    public abstract o a(Annotation annotation);

    public abstract p b();

    public abstract b.g.a.c.i0.a c();

    public abstract boolean d(Annotation annotation);
}
