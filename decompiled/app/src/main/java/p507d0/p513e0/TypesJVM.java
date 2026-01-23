package p507d0.p513e0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.a, reason: use source file name */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypesJVM implements GenericArrayType, Type {

    /* JADX INFO: renamed from: j */
    public final Type f22295j;

    public TypesJVM(Type type) {
        Intrinsics3.checkNotNullParameter(type, "elementType");
        this.f22295j = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && Intrinsics3.areEqual(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.f22295j;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return TypesJVM5.access$typeToString(this.f22295j) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
