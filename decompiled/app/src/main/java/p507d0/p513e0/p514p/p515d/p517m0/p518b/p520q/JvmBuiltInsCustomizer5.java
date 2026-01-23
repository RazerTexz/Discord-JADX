package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaClassDescriptor;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.j, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer5 extends Lambda implements Function0<ClassDescriptor> {
    public final /* synthetic */ LazyJavaClassDescriptor $javaAnalogueDescriptor;
    public final /* synthetic */ ClassDescriptor $kotlinMutableClassIfContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer5(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        super(0);
        this.$javaAnalogueDescriptor = lazyJavaClassDescriptor;
        this.$kotlinMutableClassIfContainer = classDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ClassDescriptor invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ClassDescriptor invoke() {
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.$javaAnalogueDescriptor;
        JavaResolverCache javaResolverCache = JavaResolverCache.f23244a;
        Intrinsics3.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        return lazyJavaClassDescriptor.copy$descriptors_jvm(javaResolverCache, this.$kotlinMutableClassIfContainer);
    }
}
