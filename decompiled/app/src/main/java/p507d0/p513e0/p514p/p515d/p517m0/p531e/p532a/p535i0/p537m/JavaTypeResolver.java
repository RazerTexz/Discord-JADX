package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.a, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeResolver {

    /* JADX INFO: renamed from: a */
    public final TypeUsage f23421a;

    /* JADX INFO: renamed from: b */
    public final JavaTypeResolver2 f23422b;

    /* JADX INFO: renamed from: c */
    public final boolean f23423c;

    /* JADX INFO: renamed from: d */
    public final TypeParameterDescriptor f23424d;

    public JavaTypeResolver(TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics3.checkNotNullParameter(javaTypeResolver2, "flexibility");
        this.f23421a = typeUsage;
        this.f23422b = javaTypeResolver2;
        this.f23423c = z2;
        this.f23424d = typeParameterDescriptor;
    }

    public static /* synthetic */ JavaTypeResolver copy$default(JavaTypeResolver javaTypeResolver, TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeResolver.f23421a;
        }
        if ((i & 2) != 0) {
            javaTypeResolver2 = javaTypeResolver.f23422b;
        }
        if ((i & 4) != 0) {
            z2 = javaTypeResolver.f23423c;
        }
        if ((i & 8) != 0) {
            typeParameterDescriptor = javaTypeResolver.f23424d;
        }
        return javaTypeResolver.copy(typeUsage, javaTypeResolver2, z2, typeParameterDescriptor);
    }

    public final JavaTypeResolver copy(TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics3.checkNotNullParameter(javaTypeResolver2, "flexibility");
        return new JavaTypeResolver(typeUsage, javaTypeResolver2, z2, typeParameterDescriptor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeResolver)) {
            return false;
        }
        JavaTypeResolver javaTypeResolver = (JavaTypeResolver) obj;
        return this.f23421a == javaTypeResolver.f23421a && this.f23422b == javaTypeResolver.f23422b && this.f23423c == javaTypeResolver.f23423c && Intrinsics3.areEqual(this.f23424d, javaTypeResolver.f23424d);
    }

    public final JavaTypeResolver2 getFlexibility() {
        return this.f23422b;
    }

    public final TypeUsage getHowThisTypeIsUsed() {
        return this.f23421a;
    }

    public final TypeParameterDescriptor getUpperBoundOfTypeParameter() {
        return this.f23424d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int iHashCode = (this.f23422b.hashCode() + (this.f23421a.hashCode() * 31)) * 31;
        boolean z2 = this.f23423c;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode + r0) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.f23424d;
        return i + (typeParameterDescriptor == null ? 0 : typeParameterDescriptor.hashCode());
    }

    public final boolean isForAnnotationParameter() {
        return this.f23423c;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("JavaTypeAttributes(howThisTypeIsUsed=");
        sbM833U.append(this.f23421a);
        sbM833U.append(", flexibility=");
        sbM833U.append(this.f23422b);
        sbM833U.append(", isForAnnotationParameter=");
        sbM833U.append(this.f23423c);
        sbM833U.append(", upperBoundOfTypeParameter=");
        sbM833U.append(this.f23424d);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    public final JavaTypeResolver withFlexibility(JavaTypeResolver2 javaTypeResolver2) {
        Intrinsics3.checkNotNullParameter(javaTypeResolver2, "flexibility");
        return copy$default(this, null, javaTypeResolver2, false, null, 13, null);
    }

    public /* synthetic */ JavaTypeResolver(TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeResolver2.INFLEXIBLE : javaTypeResolver2, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : typeParameterDescriptor);
    }
}
