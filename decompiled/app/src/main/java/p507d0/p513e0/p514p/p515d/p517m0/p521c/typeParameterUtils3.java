package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.l0, reason: use source file name */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeParameterUtils3 {

    /* JADX INFO: renamed from: a */
    public final ClassifierDescriptorWithTypeParameters f23073a;

    /* JADX INFO: renamed from: b */
    public final List<TypeProjection> f23074b;

    /* JADX INFO: renamed from: c */
    public final typeParameterUtils3 f23075c;

    /* JADX WARN: Multi-variable type inference failed */
    public typeParameterUtils3(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, List<? extends TypeProjection> list, typeParameterUtils3 typeparameterutils3) {
        Intrinsics3.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        this.f23073a = classifierDescriptorWithTypeParameters;
        this.f23074b = list;
        this.f23075c = typeparameterutils3;
    }

    public final List<TypeProjection> getArguments() {
        return this.f23074b;
    }

    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.f23073a;
    }

    public final typeParameterUtils3 getOuterType() {
        return this.f23075c;
    }
}
