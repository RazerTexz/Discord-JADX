package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.b.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* loaded from: classes3.dex */
public final class c extends d0.e0.p.d.m0.e.b.a<d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.k.v.g<?>> {
    public final c0 c;
    public final d0 d;
    public final d0.e0.p.d.m0.l.b.e e;

    /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    public static final class a implements p.a {
        public final HashMap<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0.e0.p.d.m0.c.e f3373b;
        public final /* synthetic */ c c;
        public final /* synthetic */ List<d0.e0.p.d.m0.c.g1.c> d;
        public final /* synthetic */ u0 e;

        /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        /* renamed from: d0.e0.p.d.m0.e.b.c$a$a, reason: collision with other inner class name */
        public static final class C0536a implements p.a {
            public final /* synthetic */ p.a a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p.a f3374b;
            public final /* synthetic */ a c;
            public final /* synthetic */ d0.e0.p.d.m0.g.e d;
            public final /* synthetic */ ArrayList<d0.e0.p.d.m0.c.g1.c> e;

            public C0536a(p.a aVar, a aVar2, d0.e0.p.d.m0.g.e eVar, ArrayList<d0.e0.p.d.m0.c.g1.c> arrayList) {
                this.f3374b = aVar;
                this.c = aVar2;
                this.d = eVar;
                this.e = arrayList;
                this.a = aVar;
            }

            @Override // d0.e0.p.d.m0.e.b.p.a
            public void visit(d0.e0.p.d.m0.g.e eVar, Object obj) {
                this.a.visit(eVar, obj);
            }

            @Override // d0.e0.p.d.m0.e.b.p.a
            public p.a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar) {
                d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
                d0.z.d.m.checkNotNullParameter(aVar, "classId");
                return this.a.visitAnnotation(eVar, aVar);
            }

            @Override // d0.e0.p.d.m0.e.b.p.a
            public p.b visitArray(d0.e0.p.d.m0.g.e eVar) {
                d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return this.a.visitArray(eVar);
            }

            @Override // d0.e0.p.d.m0.e.b.p.a
            public void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar) {
                d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
                d0.z.d.m.checkNotNullParameter(fVar, "value");
                this.a.visitClassLiteral(eVar, fVar);
            }

            @Override // d0.e0.p.d.m0.e.b.p.a
            public void visitEnd() {
                this.f3374b.visitEnd();
                a.access$getArguments$p(this.c).put(this.d, new d0.e0.p.d.m0.k.v.a((d0.e0.p.d.m0.c.g1.c) d0.t.u.single((List) this.e)));
            }

            @Override // d0.e0.p.d.m0.e.b.p.a
            public void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2) {
                d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
                d0.z.d.m.checkNotNullParameter(aVar, "enumClassId");
                d0.z.d.m.checkNotNullParameter(eVar2, "enumEntryName");
                this.a.visitEnum(eVar, aVar, eVar2);
            }
        }

        /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class b implements p.b {
            public final ArrayList<d0.e0.p.d.m0.k.v.g<?>> a = new ArrayList<>();
            public final /* synthetic */ d0.e0.p.d.m0.g.e c;
            public final /* synthetic */ d0.e0.p.d.m0.c.e d;

            public b(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2) {
                this.c = eVar;
                this.d = eVar2;
            }

            @Override // d0.e0.p.d.m0.e.b.p.b
            public void visit(Object obj) {
                this.a.add(a.access$createConstant(a.this, this.c, obj));
            }

            @Override // d0.e0.p.d.m0.e.b.p.b
            public void visitClassLiteral(d0.e0.p.d.m0.k.v.f fVar) {
                d0.z.d.m.checkNotNullParameter(fVar, "value");
                this.a.add(new d0.e0.p.d.m0.k.v.r(fVar));
            }

            @Override // d0.e0.p.d.m0.e.b.p.b
            public void visitEnd() {
                c1 annotationParameterByName = d0.e0.p.d.m0.e.a.g0.a.getAnnotationParameterByName(this.c, this.d);
                if (annotationParameterByName != null) {
                    HashMap mapAccess$getArguments$p = a.access$getArguments$p(a.this);
                    d0.e0.p.d.m0.g.e eVar = this.c;
                    d0.e0.p.d.m0.k.v.h hVar = d0.e0.p.d.m0.k.v.h.a;
                    List<? extends d0.e0.p.d.m0.k.v.g<?>> listCompact = d0.e0.p.d.m0.p.a.compact(this.a);
                    d0.e0.p.d.m0.n.c0 type = annotationParameterByName.getType();
                    d0.z.d.m.checkNotNullExpressionValue(type, "parameter.type");
                    mapAccess$getArguments$p.put(eVar, hVar.createArrayValue(listCompact, type));
                }
            }

            @Override // d0.e0.p.d.m0.e.b.p.b
            public void visitEnum(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar) {
                d0.z.d.m.checkNotNullParameter(aVar, "enumClassId");
                d0.z.d.m.checkNotNullParameter(eVar, "enumEntryName");
                this.a.add(new d0.e0.p.d.m0.k.v.j(aVar, eVar));
            }
        }

        public a(d0.e0.p.d.m0.c.e eVar, c cVar, List<d0.e0.p.d.m0.c.g1.c> list, u0 u0Var) {
            this.f3373b = eVar;
            this.c = cVar;
            this.d = list;
            this.e = u0Var;
        }

        public static final /* synthetic */ d0.e0.p.d.m0.k.v.g access$createConstant(a aVar, d0.e0.p.d.m0.g.e eVar, Object obj) {
            return aVar.a(eVar, obj);
        }

        public static final /* synthetic */ HashMap access$getArguments$p(a aVar) {
            return aVar.a;
        }

        public final d0.e0.p.d.m0.k.v.g<?> a(d0.e0.p.d.m0.g.e eVar, Object obj) {
            d0.e0.p.d.m0.k.v.g<?> gVarCreateConstantValue = d0.e0.p.d.m0.k.v.h.a.createConstantValue(obj);
            return gVarCreateConstantValue == null ? d0.e0.p.d.m0.k.v.k.f3474b.create(d0.z.d.m.stringPlus("Unsupported annotation argument: ", eVar)) : gVarCreateConstantValue;
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visit(d0.e0.p.d.m0.g.e eVar, Object obj) {
            if (eVar != null) {
                this.a.put(eVar, a(eVar, obj));
            }
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public p.a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(aVar, "classId");
            ArrayList arrayList = new ArrayList();
            c cVar = this.c;
            u0 u0Var = u0.a;
            d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
            p.a aVarH = cVar.h(aVar, u0Var, arrayList);
            d0.z.d.m.checkNotNull(aVarH);
            return new C0536a(aVarH, this, eVar, arrayList);
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public p.b visitArray(d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new b(eVar, this.f3373b);
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(fVar, "value");
            this.a.put(eVar, new d0.e0.p.d.m0.k.v.r(fVar));
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitEnd() {
            this.d.add(new d0.e0.p.d.m0.c.g1.d(this.f3373b.getDefaultType(), this.a, this.e));
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(aVar, "enumClassId");
            d0.z.d.m.checkNotNullParameter(eVar2, "enumEntryName");
            this.a.put(eVar, new d0.e0.p.d.m0.k.v.j(aVar, eVar2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, d0 d0Var, d0.e0.p.d.m0.m.o oVar, n nVar) {
        super(oVar, nVar);
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(nVar, "kotlinClassFinder");
        this.c = c0Var;
        this.d = d0Var;
        this.e = new d0.e0.p.d.m0.l.b.e(c0Var, d0Var);
    }

    @Override // d0.e0.p.d.m0.e.b.a
    public p.a h(d0.e0.p.d.m0.g.a aVar, u0 u0Var, List<d0.e0.p.d.m0.c.g1.c> list) {
        d0.z.d.m.checkNotNullParameter(aVar, "annotationClassId");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        d0.z.d.m.checkNotNullParameter(list, "result");
        return new a(d0.e0.p.d.m0.c.w.findNonGenericClassAcrossDependencies(this.c, aVar, this.d), this, list, u0Var);
    }
}
