package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypeSubstitution.kt */
/* renamed from: d0.e0.p.d.m0.n.v0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class TypeSubstitution3 extends TypeSubstitution5 {

    /* renamed from: b */
    public static final a f24889b = new a(null);

    /* compiled from: TypeSubstitution.kt */
    /* renamed from: d0.e0.p.d.m0.n.v0$a */
    public static final class a {

        /* compiled from: TypeSubstitution.kt */
        /* renamed from: d0.e0.p.d.m0.n.v0$a$a, reason: collision with other inner class name */
        public static final class C13339a extends TypeSubstitution3 {

            /* renamed from: c */
            public final /* synthetic */ Map<TypeConstructor, TypeProjection> f24890c;

            /* renamed from: d */
            public final /* synthetic */ boolean f24891d;

            /* JADX WARN: Multi-variable type inference failed */
            public C13339a(Map<TypeConstructor, ? extends TypeProjection> map, boolean z2) {
                this.f24890c = map;
                this.f24891d = z2;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
            public boolean approximateCapturedTypes() {
                return this.f24891d;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution3
            public TypeProjection get(TypeConstructor typeConstructor) {
                Intrinsics3.checkNotNullParameter(typeConstructor, "key");
                return this.f24890c.get(typeConstructor);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
            public boolean isEmpty() {
                return this.f24890c.isEmpty();
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ TypeSubstitution3 createByConstructorsMap$default(a aVar, Map map, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return aVar.createByConstructorsMap(map, z2);
        }

        public final TypeSubstitution5 create(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        public final TypeSubstitution3 createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
            Intrinsics3.checkNotNullParameter(map, "map");
            return createByConstructorsMap$default(this, map, false, 2, null);
        }

        public final TypeSubstitution3 createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map, boolean z2) {
            Intrinsics3.checkNotNullParameter(map, "map");
            return new C13339a(map, z2);
        }

        public final TypeSubstitution5 create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "typeConstructor");
            Intrinsics3.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) _Collections.lastOrNull((List) parameters);
            if (!Intrinsics3.areEqual(typeParameterDescriptor == null ? null : Boolean.valueOf(typeParameterDescriptor.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
                return new TypeSubstitution4(parameters, list);
            }
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters2, 10));
            Iterator<T> it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
            }
            return createByConstructorsMap$default(this, Maps6.toMap(_Collections.zip(arrayList, list)), false, 2, null);
        }
    }

    public static final TypeSubstitution5 create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
        return f24889b.create(typeConstructor, list);
    }

    public static final TypeSubstitution3 createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
        return f24889b.createByConstructorsMap(map);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        return get(kotlinType.getConstructor());
    }

    public abstract TypeProjection get(TypeConstructor typeConstructor);
}
