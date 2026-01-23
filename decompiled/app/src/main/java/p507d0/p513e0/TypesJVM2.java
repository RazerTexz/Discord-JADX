package p507d0.p513e0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.k, reason: use source file name */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypesJVM2 implements ParameterizedType, Type {

    /* JADX INFO: renamed from: j */
    public final Type[] f22308j;

    /* JADX INFO: renamed from: k */
    public final Class<?> f22309k;

    /* JADX INFO: renamed from: l */
    public final Type f22310l;

    /* JADX INFO: renamed from: d0.e0.k$a */
    /* JADX INFO: compiled from: TypesJVM.kt */
    public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Type, String> {

        /* JADX INFO: renamed from: j */
        public static final a f22311j = new a();

        public a() {
            super(1, TypesJVM5.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Type type) {
            return invoke2(type);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Type type) {
            Intrinsics3.checkNotNullParameter(type, "p1");
            return TypesJVM5.access$typeToString(type);
        }
    }

    public TypesJVM2(Class<?> cls, Type type, List<? extends Type> list) {
        Intrinsics3.checkNotNullParameter(cls, "rawType");
        Intrinsics3.checkNotNullParameter(list, "typeArguments");
        this.f22309k = cls;
        this.f22310l = type;
        Object[] array = list.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.f22308j = (Type[]) array;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics3.areEqual(this.f22309k, parameterizedType.getRawType()) && Intrinsics3.areEqual(this.f22310l, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f22308j;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f22310l;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f22309k;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Type type = this.f22310l;
        if (type != null) {
            sb.append(TypesJVM5.access$typeToString(type));
            sb.append("$");
            sb.append(this.f22309k.getSimpleName());
        } else {
            sb.append(TypesJVM5.access$typeToString(this.f22309k));
        }
        Type[] typeArr = this.f22308j;
        if (!(typeArr.length == 0)) {
            _Arrays.joinTo$default(typeArr, sb, null, "<", ">", 0, null, a.f22311j, 50, null);
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.f22309k.hashCode();
        Type type = this.f22310l;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
