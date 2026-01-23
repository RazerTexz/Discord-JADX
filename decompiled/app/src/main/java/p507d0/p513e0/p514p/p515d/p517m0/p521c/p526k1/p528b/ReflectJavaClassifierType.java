package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11576i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.l, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaClassifierType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClassifierType extends ReflectJavaType implements javaTypes3 {

    /* JADX INFO: renamed from: b */
    public final Type f23055b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11576i f23056c;

    public ReflectJavaClassifierType(Type type) {
        InterfaceC11576i reflectJavaClass;
        Intrinsics3.checkNotNullParameter(type, "reflectType");
        this.f23055b = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            reflectJavaClass = new ReflectJavaTypeParameter((TypeVariable) reflectType);
        } else {
            if (!(reflectType instanceof ParameterizedType)) {
                StringBuilder sbM833U = outline.m833U("Not a classifier type (");
                sbM833U.append(reflectType.getClass());
                sbM833U.append("): ");
                sbM833U.append(reflectType);
                throw new IllegalStateException(sbM833U.toString());
            }
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            reflectJavaClass = new ReflectJavaClass((Class) rawType);
        }
        this.f23056c = reflectJavaClass;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType, p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public InterfaceC11564a findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3
    public InterfaceC11576i getClassifier() {
        return this.f23056c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException(Intrinsics3.stringPlus("Type not found: ", getReflectType()));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType
    public Type getReflectType() {
        return this.f23055b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3
    public List<javaTypes5> getTypeArguments() {
        List<Type> parameterizedTypeArguments = reflectClassUtil.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.a aVar = ReflectJavaType.f23065a;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        Iterator<T> it = parameterizedTypeArguments.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.create((Type) it.next()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3
    public boolean isRaw() {
        Type reflectType = getReflectType();
        if (!(reflectType instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) reflectType).getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }
}
