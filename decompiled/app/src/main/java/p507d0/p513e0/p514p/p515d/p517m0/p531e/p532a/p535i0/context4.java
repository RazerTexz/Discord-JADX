package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import kotlin.Lazy;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaTypeQualifiersByElementType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver4;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: context.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class context4 {

    /* renamed from: a */
    public final context2 f23310a;

    /* renamed from: b */
    public final resolvers2 f23311b;

    /* renamed from: c */
    public final Lazy<JavaTypeQualifiersByElementType> f23312c;

    /* renamed from: d */
    public final Lazy f23313d;

    /* renamed from: e */
    public final JavaTypeResolver4 f23314e;

    public context4(context2 context2Var, resolvers2 resolvers2Var, Lazy<JavaTypeQualifiersByElementType> lazy) {
        Intrinsics3.checkNotNullParameter(context2Var, "components");
        Intrinsics3.checkNotNullParameter(resolvers2Var, "typeParameterResolver");
        Intrinsics3.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.f23310a = context2Var;
        this.f23311b = resolvers2Var;
        this.f23312c = lazy;
        this.f23313d = lazy;
        this.f23314e = new JavaTypeResolver4(this, resolvers2Var);
    }

    public final context2 getComponents() {
        return this.f23310a;
    }

    public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return (JavaTypeQualifiersByElementType) this.f23313d.getValue();
    }

    public final Lazy<JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.f23312c;
    }

    public final ModuleDescriptor2 getModule() {
        return this.f23310a.getModule();
    }

    public final StorageManager getStorageManager() {
        return this.f23310a.getStorageManager();
    }

    public final resolvers2 getTypeParameterResolver() {
        return this.f23311b;
    }

    public final JavaTypeResolver4 getTypeResolver() {
        return this.f23314e;
    }
}
