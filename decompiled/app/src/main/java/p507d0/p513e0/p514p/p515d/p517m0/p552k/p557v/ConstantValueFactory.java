package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h, reason: use source file name */
/* JADX INFO: compiled from: ConstantValueFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstantValueFactory {

    /* JADX INFO: renamed from: a */
    public static final ConstantValueFactory f24439a = new ConstantValueFactory();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h$a */
    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {
        public final /* synthetic */ KotlinType $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KotlinType kotlinType) {
            super(1);
            this.$type = kotlinType;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            return invoke2(moduleDescriptor2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType invoke2(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "it");
            return this.$type;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h$b */
    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    public static final class b extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {
        public final /* synthetic */ PrimitiveType $componentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PrimitiveType primitiveType) {
            super(1);
            this.$componentType = primitiveType;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            return invoke2(moduleDescriptor2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType invoke2(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            KotlinType4 primitiveArrayKotlinType = moduleDescriptor2.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
            Intrinsics3.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
            return primitiveArrayKotlinType;
        }
    }

    /* JADX INFO: renamed from: a */
    public final C11809b m9942a(List<?> list, PrimitiveType primitiveType) {
        List list2 = _Collections.toList(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            AbstractC11815g<?> abstractC11815gCreateConstantValue = createConstantValue(it.next());
            if (abstractC11815gCreateConstantValue != null) {
                arrayList.add(abstractC11815gCreateConstantValue);
            }
        }
        return new C11809b(arrayList, new b(primitiveType));
    }

    public final C11809b createArrayValue(List<? extends AbstractC11815g<?>> list, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(list, "value");
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        return new C11809b(list, new a(kotlinType));
    }

    public final AbstractC11815g<?> createConstantValue(Object obj) {
        if (obj instanceof Byte) {
            return new C11812d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new C11830v(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new C11821m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new C11827s(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new C11813e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new C11820l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new C11817i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new C11811c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new C11831w((String) obj);
        }
        if (obj instanceof byte[]) {
            return m9942a(_Arrays.toList((byte[]) obj), PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return m9942a(_Arrays.toList((short[]) obj), PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return m9942a(_Arrays.toList((int[]) obj), PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return m9942a(_Arrays.toList((long[]) obj), PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return m9942a(_Arrays.toList((char[]) obj), PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return m9942a(_Arrays.toList((float[]) obj), PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return m9942a(_Arrays.toList((double[]) obj), PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return m9942a(_Arrays.toList((boolean[]) obj), PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new C11828t();
        }
        return null;
    }
}
