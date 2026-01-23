package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.s, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaMethod extends ReflectJavaMember2 implements InterfaceC11585r {

    /* JADX INFO: renamed from: a */
    public final Method f23061a;

    public ReflectJavaMethod(Method method) {
        Intrinsics3.checkNotNullParameter(method, "member");
        this.f23061a = method;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public annotationArguments getAnnotationParameterDefaultValue() {
        Object defaultValue = getMember().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return ReflectJavaAnnotationArguments.f23039a.create(defaultValue, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public boolean getHasAnnotationParameterDefaultValue() {
        return InterfaceC11585r.a.getHasAnnotationParameterDefaultValue(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaMember2
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public /* bridge */ /* synthetic */ javaTypes5 getReturnType() {
        return getReturnType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = getMember().getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public List<InterfaceC11565a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        Intrinsics3.checkNotNullExpressionValue(parameterAnnotations, "member.parameterAnnotations");
        return m9436a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaMember2
    public Method getMember() {
        return this.f23061a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public ReflectJavaType getReturnType() {
        ReflectJavaType.a aVar = ReflectJavaType.f23065a;
        Type genericReturnType = getMember().getGenericReturnType();
        Intrinsics3.checkNotNullExpressionValue(genericReturnType, "member.genericReturnType");
        return aVar.create(genericReturnType);
    }
}
