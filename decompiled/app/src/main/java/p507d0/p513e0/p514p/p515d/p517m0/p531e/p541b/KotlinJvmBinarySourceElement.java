package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMetadataVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.IncompatibleVersionErrorData;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.r, reason: use source file name */
/* JADX INFO: compiled from: KotlinJvmBinarySourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinJvmBinarySourceElement implements DeserializedContainerSource2 {

    /* JADX INFO: renamed from: b */
    public final KotlinJvmBinaryClass f23632b;

    public KotlinJvmBinarySourceElement(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z2, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "binaryClass");
        Intrinsics3.checkNotNullParameter(deserializedContainerSource, "abiStability");
        this.f23632b = kotlinJvmBinaryClass;
    }

    public final KotlinJvmBinaryClass getBinaryClass() {
        return this.f23632b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement
    public InterfaceC11469v0 getContainingFile() {
        InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
        Intrinsics3.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
        return interfaceC11469v0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2
    public String getPresentableString() {
        StringBuilder sbM833U = outline.m833U("Class '");
        sbM833U.append(this.f23632b.getClassId().asSingleFqName().asString());
        sbM833U.append('\'');
        return sbM833U.toString();
    }

    public String toString() {
        return ((Object) KotlinJvmBinarySourceElement.class.getSimpleName()) + ": " + this.f23632b;
    }
}
