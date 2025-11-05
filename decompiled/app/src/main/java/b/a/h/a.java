package b.a.h;

import android.content.Context;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: CustomTabs.kt */
/* loaded from: classes.dex */
public final class a extends o implements Function1<String, Boolean> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        m.checkNotNullParameter(str, "it");
        return Boolean.valueOf(!m.areEqual(r2, this.$context.getPackageName()));
    }
}
