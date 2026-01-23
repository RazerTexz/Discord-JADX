package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.functions.Function1;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.m, reason: use source file name */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class signatureEnhancement2 extends Lambda implements Function1<Integer, typeQualifiers> {
    public final /* synthetic */ typeQualifiers[] $computedResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public signatureEnhancement2(typeQualifiers[] typequalifiersArr) {
        super(1);
        this.$computedResult = typequalifiersArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ typeQualifiers invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final typeQualifiers invoke(int i) {
        typeQualifiers[] typequalifiersArr = this.$computedResult;
        return (i < 0 || i > _Arrays.getLastIndex(typequalifiersArr)) ? typeQualifiers.f23450a.getNONE() : typequalifiersArr[i];
    }
}
