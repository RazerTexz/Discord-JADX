package b.g.a.c.g0.t;

import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Arrays;

/* compiled from: PropertySerializerMap.java */
/* loaded from: classes3.dex */
public abstract class l {
    public final boolean a;

    /* compiled from: PropertySerializerMap.java */
    public static final class a extends l {

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f705b;
        public final Class<?> c;
        public final b.g.a.c.n<Object> d;
        public final b.g.a.c.n<Object> e;

        public a(l lVar, Class<?> cls, b.g.a.c.n<Object> nVar, Class<?> cls2, b.g.a.c.n<Object> nVar2) {
            super(lVar);
            this.f705b = cls;
            this.d = nVar;
            this.c = cls2;
            this.e = nVar2;
        }

        @Override // b.g.a.c.g0.t.l
        public l b(Class<?> cls, b.g.a.c.n<Object> nVar) {
            return new c(this, new f[]{new f(this.f705b, this.d), new f(this.c, this.e), new f(cls, nVar)});
        }

        @Override // b.g.a.c.g0.t.l
        public b.g.a.c.n<Object> c(Class<?> cls) {
            if (cls == this.f705b) {
                return this.d;
            }
            if (cls == this.c) {
                return this.e;
            }
            return null;
        }
    }

    /* compiled from: PropertySerializerMap.java */
    public static final class b extends l {

        /* renamed from: b, reason: collision with root package name */
        public static final b f706b = new b(false);

        public b(boolean z2) {
            super(z2);
        }

        @Override // b.g.a.c.g0.t.l
        public l b(Class<?> cls, b.g.a.c.n<Object> nVar) {
            return new e(this, cls, nVar);
        }

        @Override // b.g.a.c.g0.t.l
        public b.g.a.c.n<Object> c(Class<?> cls) {
            return null;
        }
    }

    /* compiled from: PropertySerializerMap.java */
    public static final class c extends l {

        /* renamed from: b, reason: collision with root package name */
        public final f[] f707b;

        public c(l lVar, f[] fVarArr) {
            super(lVar);
            this.f707b = fVarArr;
        }

        @Override // b.g.a.c.g0.t.l
        public l b(Class<?> cls, b.g.a.c.n<Object> nVar) {
            f[] fVarArr = this.f707b;
            int length = fVarArr.length;
            if (length == 8) {
                return this.a ? new e(this, cls, nVar) : this;
            }
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
            fVarArr2[length] = new f(cls, nVar);
            return new c(this, fVarArr2);
        }

        @Override // b.g.a.c.g0.t.l
        public b.g.a.c.n<Object> c(Class<?> cls) {
            f[] fVarArr = this.f707b;
            f fVar = fVarArr[0];
            if (fVar.a == cls) {
                return fVar.f710b;
            }
            f fVar2 = fVarArr[1];
            if (fVar2.a == cls) {
                return fVar2.f710b;
            }
            f fVar3 = fVarArr[2];
            if (fVar3.a == cls) {
                return fVar3.f710b;
            }
            switch (fVarArr.length) {
                case 8:
                    f fVar4 = fVarArr[7];
                    if (fVar4.a == cls) {
                        return fVar4.f710b;
                    }
                case 7:
                    f fVar5 = fVarArr[6];
                    if (fVar5.a == cls) {
                        return fVar5.f710b;
                    }
                case 6:
                    f fVar6 = fVarArr[5];
                    if (fVar6.a == cls) {
                        return fVar6.f710b;
                    }
                case 5:
                    f fVar7 = fVarArr[4];
                    if (fVar7.a == cls) {
                        return fVar7.f710b;
                    }
                case 4:
                    f fVar8 = fVarArr[3];
                    if (fVar8.a == cls) {
                        return fVar8.f710b;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* compiled from: PropertySerializerMap.java */
    public static final class d {
        public final b.g.a.c.n<Object> a;

        /* renamed from: b, reason: collision with root package name */
        public final l f708b;

        public d(b.g.a.c.n<Object> nVar, l lVar) {
            this.a = nVar;
            this.f708b = lVar;
        }
    }

    /* compiled from: PropertySerializerMap.java */
    public static final class e extends l {

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f709b;
        public final b.g.a.c.n<Object> c;

        public e(l lVar, Class<?> cls, b.g.a.c.n<Object> nVar) {
            super(lVar);
            this.f709b = cls;
            this.c = nVar;
        }

        @Override // b.g.a.c.g0.t.l
        public l b(Class<?> cls, b.g.a.c.n<Object> nVar) {
            return new a(this, this.f709b, this.c, cls, nVar);
        }

        @Override // b.g.a.c.g0.t.l
        public b.g.a.c.n<Object> c(Class<?> cls) {
            if (cls == this.f709b) {
                return this.c;
            }
            return null;
        }
    }

    /* compiled from: PropertySerializerMap.java */
    public static final class f {
        public final Class<?> a;

        /* renamed from: b, reason: collision with root package name */
        public final b.g.a.c.n<Object> f710b;

        public f(Class<?> cls, b.g.a.c.n<Object> nVar) {
            this.a = cls;
            this.f710b = nVar;
        }
    }

    public l(boolean z2) {
        this.a = z2;
    }

    public final d a(b.g.a.c.j jVar, x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<Object> nVarM = xVar.m(jVar, dVar);
        return new d(nVarM, b(jVar._class, nVarM));
    }

    public abstract l b(Class<?> cls, b.g.a.c.n<Object> nVar);

    public abstract b.g.a.c.n<Object> c(Class<?> cls);

    public l(l lVar) {
        this.a = lVar.a;
    }
}
