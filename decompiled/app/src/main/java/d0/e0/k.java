package d0.e0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
public final class k implements ParameterizedType, Type {
    public final Type[] j;
    public final Class<?> k;
    public final Type l;

    /* compiled from: TypesJVM.kt */
    public static final /* synthetic */ class a extends d0.z.d.k implements Function1<Type, String> {
        public static final a j = new a();

        public a() {
            super(1, n.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Type type) {
            return invoke2(type);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Type type) {
            d0.z.d.m.checkNotNullParameter(type, "p1");
            return n.access$typeToString(type);
        }
    }

    public k(Class<?> cls, Type type, List<? extends Type> list) {
        d0.z.d.m.checkNotNullParameter(cls, "rawType");
        d0.z.d.m.checkNotNullParameter(list, "typeArguments");
        this.k = cls;
        this.l = type;
        Object[] array = list.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.j = (Type[]) array;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (d0.z.d.m.areEqual(this.k, parameterizedType.getRawType()) && d0.z.d.m.areEqual(this.l, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.j;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.l;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.k;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Type type = this.l;
        if (type != null) {
            sb.append(n.access$typeToString(type));
            sb.append("$");
            sb.append(this.k.getSimpleName());
        } else {
            sb.append(n.access$typeToString(this.k));
        }
        Type[] typeArr = this.j;
        if (!(typeArr.length == 0)) {
            d0.t.k.joinTo$default(typeArr, sb, null, "<", ">", 0, null, a.j, 50, null);
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.k.hashCode();
        Type type = this.l;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
