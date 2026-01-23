package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.k, reason: use source file name */
/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class predefinedEnhancementInfo2 {

    /* JADX INFO: renamed from: a */
    public final predefinedEnhancementInfo4 f23470a;

    /* JADX INFO: renamed from: b */
    public final List<predefinedEnhancementInfo4> f23471b;

    public predefinedEnhancementInfo2() {
        this(null, null, 3, null);
    }

    public predefinedEnhancementInfo2(predefinedEnhancementInfo4 predefinedenhancementinfo4, List<predefinedEnhancementInfo4> list) {
        Intrinsics3.checkNotNullParameter(list, "parametersInfo");
        this.f23470a = predefinedenhancementinfo4;
        this.f23471b = list;
    }

    public final List<predefinedEnhancementInfo4> getParametersInfo() {
        return this.f23471b;
    }

    public final predefinedEnhancementInfo4 getReturnTypeInfo() {
        return this.f23470a;
    }

    public /* synthetic */ predefinedEnhancementInfo2(predefinedEnhancementInfo4 predefinedenhancementinfo4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : predefinedenhancementinfo4, (i & 2) != 0 ? Collections2.emptyList() : list);
    }
}
