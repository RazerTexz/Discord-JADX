package d0.e0.p.d.m0.c.k1.b;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: classes3.dex */
public abstract class d implements d0.e0.p.d.m0.e.a.k0.b {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.g.e f3292b;

    /* compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d create(Object obj, d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(obj, "value");
            return b.isEnumClassOrSpecializedEnumEntryClass(obj.getClass()) ? new o(eVar, (Enum) obj) : obj instanceof Annotation ? new e(eVar, (Annotation) obj) : obj instanceof Object[] ? new h(eVar, (Object[]) obj) : obj instanceof Class ? new k(eVar, (Class) obj) : new q(eVar, obj);
        }
    }

    public d(d0.e0.p.d.m0.g.e eVar) {
        this.f3292b = eVar;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.b
    public d0.e0.p.d.m0.g.e getName() {
        return this.f3292b;
    }
}
