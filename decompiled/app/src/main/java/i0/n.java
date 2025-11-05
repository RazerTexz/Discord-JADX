package i0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: KotlinExtensions.kt */
/* loaded from: classes3.dex */
public final class n extends d0.z.d.o implements Function1<Throwable, Unit> {
    public final /* synthetic */ d $this_awaitResponse$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(d dVar) {
        super(1);
        this.$this_awaitResponse$inlined = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.$this_awaitResponse$inlined.cancel();
        return Unit.a;
    }
}
