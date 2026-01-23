package p007b.p008a.p024h;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.h.a, reason: use source file name */
/* JADX INFO: compiled from: CustomTabs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabs extends Lambda implements Function1<String, Boolean> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabs(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        return Boolean.valueOf(!Intrinsics3.areEqual(r2, this.$context.getPackageName()));
    }
}
