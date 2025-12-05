package p630i0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* compiled from: KotlinExtensions.kt */
/* renamed from: i0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinExtensions2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Call3 $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinExtensions2(Call3 call3) {
        super(1);
        this.$this_await$inlined = call3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.$this_await$inlined.cancel();
        return Unit.f27425a;
    }
}
