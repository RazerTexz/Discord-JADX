package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.z0;
import d0.t.s;
import java.util.ArrayList;

/* compiled from: ClassifierNamePolicy.kt */
/* loaded from: classes3.dex */
public interface b {

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class a implements b {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.j.b
        public String renderClassifier(d0.e0.p.d.m0.c.h hVar, d0.e0.p.d.m0.j.c cVar) {
            d0.z.d.m.checkNotNullParameter(hVar, "classifier");
            d0.z.d.m.checkNotNullParameter(cVar, "renderer");
            if (hVar instanceof z0) {
                d0.e0.p.d.m0.g.e name = ((z0) hVar).getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "classifier.name");
                return cVar.renderName(name, false);
            }
            d0.e0.p.d.m0.g.c fqName = d0.e0.p.d.m0.k.e.getFqName(hVar);
            d0.z.d.m.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return cVar.renderFqName(fqName);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    /* renamed from: d0.e0.p.d.m0.j.b$b, reason: collision with other inner class name */
    public static final class C0560b implements b {
        public static final C0560b a = new C0560b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [d0.e0.p.d.m0.c.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [d0.e0.p.d.m0.c.m] */
        @Override // d0.e0.p.d.m0.j.b
        public String renderClassifier(d0.e0.p.d.m0.c.h hVar, d0.e0.p.d.m0.j.c cVar) {
            d0.z.d.m.checkNotNullParameter(hVar, "classifier");
            d0.z.d.m.checkNotNullParameter(cVar, "renderer");
            if (hVar instanceof z0) {
                d0.e0.p.d.m0.g.e name = ((z0) hVar).getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "classifier.name");
                return cVar.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(hVar.getName());
                hVar = hVar.getContainingDeclaration();
            } while (hVar instanceof d0.e0.p.d.m0.c.e);
            return q.renderFqName(s.asReversedMutable(arrayList));
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class c implements b {
        public static final c a = new c();

        public final String a(d0.e0.p.d.m0.c.h hVar) {
            String strRender;
            d0.e0.p.d.m0.g.e name = hVar.getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "descriptor.name");
            String strRender2 = q.render(name);
            if (hVar instanceof z0) {
                return strRender2;
            }
            d0.e0.p.d.m0.c.m containingDeclaration = hVar.getContainingDeclaration();
            d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof d0.e0.p.d.m0.c.e) {
                strRender = a((d0.e0.p.d.m0.c.h) containingDeclaration);
            } else if (containingDeclaration instanceof e0) {
                d0.e0.p.d.m0.g.c unsafe = ((e0) containingDeclaration).getFqName().toUnsafe();
                d0.z.d.m.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
                strRender = q.render(unsafe);
            } else {
                strRender = null;
            }
            if (strRender == null || d0.z.d.m.areEqual(strRender, "")) {
                return strRender2;
            }
            return ((Object) strRender) + '.' + strRender2;
        }

        @Override // d0.e0.p.d.m0.j.b
        public String renderClassifier(d0.e0.p.d.m0.c.h hVar, d0.e0.p.d.m0.j.c cVar) {
            d0.z.d.m.checkNotNullParameter(hVar, "classifier");
            d0.z.d.m.checkNotNullParameter(cVar, "renderer");
            return a(hVar);
        }
    }

    String renderClassifier(d0.e0.p.d.m0.c.h hVar, d0.e0.p.d.m0.j.c cVar);
}
