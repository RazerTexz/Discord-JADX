package b.a.a;

import b.a.a.x;
import com.discord.models.user.User;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* loaded from: classes.dex */
public final class v extends d0.z.d.o implements Function1<x.c, Unit> {
    public final /* synthetic */ x this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(x xVar) {
        super(1);
        this.this$0 = xVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(x.c cVar) {
        x.c cVar2 = cVar;
        d0.z.d.m.checkNotNullParameter(cVar2, "storeState");
        x xVar = this.this$0;
        Objects.requireNonNull(xVar);
        User user = cVar2.a;
        x.d viewState = xVar.getViewState();
        xVar.updateViewState(new x.d(Integer.valueOf(user.getFlags()), viewState == null ? false : viewState.f50b));
        return Unit.a;
    }
}
