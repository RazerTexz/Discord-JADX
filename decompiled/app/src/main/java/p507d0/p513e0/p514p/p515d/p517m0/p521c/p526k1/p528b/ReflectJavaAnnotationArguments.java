package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.d, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaAnnotationArguments implements annotationArguments {

    /* JADX INFO: renamed from: a */
    public static final a f23039a = new a(null);

    /* JADX INFO: renamed from: b */
    public final Name f23040b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.d$a */
    /* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ReflectJavaAnnotationArguments create(Object obj, Name name) {
            Intrinsics3.checkNotNullParameter(obj, "value");
            return reflectClassUtil.isEnumClassOrSpecializedEnumEntryClass(obj.getClass()) ? new ReflectJavaAnnotationArguments5(name, (Enum) obj) : obj instanceof Annotation ? new ReflectJavaAnnotationArguments2(name, (Annotation) obj) : obj instanceof Object[] ? new ReflectJavaAnnotationArguments3(name, (Object[]) obj) : obj instanceof Class ? new ReflectJavaAnnotationArguments4(name, (Class) obj) : new ReflectJavaAnnotationArguments6(name, obj);
        }
    }

    public ReflectJavaAnnotationArguments(Name name) {
        this.f23040b = name;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments
    public Name getName() {
        return this.f23040b;
    }
}
