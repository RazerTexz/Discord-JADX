package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11578k;
import p507d0.p580t.Collections2;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.m, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember2 implements InterfaceC11578k {

    /* JADX INFO: renamed from: a */
    public final Constructor<?> f23057a;

    public ReflectJavaConstructor(Constructor<?> constructor) {
        Intrinsics3.checkNotNullParameter(constructor, "member");
        this.f23057a = constructor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaMember2
    public Constructor<?> getMember() {
        return this.f23057a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11578k
    public List<InterfaceC11565a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return Collections2.emptyList();
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) _ArraysJvm.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Illegal generic signature: ", getMember()));
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            Intrinsics3.checkNotNullExpressionValue(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) _ArraysJvm.copyOfRange(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "realTypes");
        Intrinsics3.checkNotNullExpressionValue(parameterAnnotations, "realAnnotations");
        return m9436a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaMember2
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }
}
