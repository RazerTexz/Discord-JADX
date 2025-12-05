package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaTypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: resolvers.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class resolvers implements resolvers2 {

    /* renamed from: a */
    public final context4 f23315a;

    /* renamed from: b */
    public final DeclarationDescriptor f23316b;

    /* renamed from: c */
    public final int f23317c;

    /* renamed from: d */
    public final Map<InterfaceC11592y, Integer> f23318d;

    /* renamed from: e */
    public final storage4<InterfaceC11592y, LazyJavaTypeParameterDescriptor> f23319e;

    /* compiled from: resolvers.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.h$a */
    public static final class a extends Lambda implements Function1<InterfaceC11592y, LazyJavaTypeParameterDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyJavaTypeParameterDescriptor invoke(InterfaceC11592y interfaceC11592y) {
            return invoke2(interfaceC11592y);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyJavaTypeParameterDescriptor invoke2(InterfaceC11592y interfaceC11592y) {
            Intrinsics3.checkNotNullParameter(interfaceC11592y, "typeParameter");
            Integer num = (Integer) resolvers.access$getTypeParameters$p(resolvers.this).get(interfaceC11592y);
            if (num == null) {
                return null;
            }
            resolvers resolversVar = resolvers.this;
            return new LazyJavaTypeParameterDescriptor(context.copyWithNewDefaultTypeQualifiers(context.child(resolvers.access$getC$p(resolversVar), resolversVar), resolvers.access$getContainingDeclaration$p(resolversVar).getAnnotations()), interfaceC11592y, resolvers.access$getTypeParametersIndexOffset$p(resolversVar) + num.intValue(), resolvers.access$getContainingDeclaration$p(resolversVar));
        }
    }

    public resolvers(context4 context4Var, DeclarationDescriptor declarationDescriptor, InterfaceC11593z interfaceC11593z, int i) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(interfaceC11593z, "typeParameterOwner");
        this.f23315a = context4Var;
        this.f23316b = declarationDescriptor;
        this.f23317c = i;
        this.f23318d = collections.mapToIndex(interfaceC11593z.getTypeParameters());
        this.f23319e = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    public static final /* synthetic */ context4 access$getC$p(resolvers resolversVar) {
        return resolversVar.f23315a;
    }

    public static final /* synthetic */ DeclarationDescriptor access$getContainingDeclaration$p(resolvers resolversVar) {
        return resolversVar.f23316b;
    }

    public static final /* synthetic */ Map access$getTypeParameters$p(resolvers resolversVar) {
        return resolversVar.f23318d;
    }

    public static final /* synthetic */ int access$getTypeParametersIndexOffset$p(resolvers resolversVar) {
        return resolversVar.f23317c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.resolvers2
    public TypeParameterDescriptor resolveTypeParameter(InterfaceC11592y interfaceC11592y) {
        Intrinsics3.checkNotNullParameter(interfaceC11592y, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptorInvoke = this.f23319e.invoke(interfaceC11592y);
        return lazyJavaTypeParameterDescriptorInvoke == null ? this.f23315a.getTypeParameterResolver().resolveTypeParameter(interfaceC11592y) : lazyJavaTypeParameterDescriptorInvoke;
    }
}
