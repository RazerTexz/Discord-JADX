package b.a.d;

import com.discord.R;
import com.discord.app.AppFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AppFragment.kt */
/* loaded from: classes.dex */
public final class e extends d0.z.d.o implements Function1<Exception, Unit> {
    public final /* synthetic */ AppFragment.d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AppFragment.d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        d0.z.d.m.checkNotNullParameter(exc2, "e");
        AppFragment appFragment = AppFragment.this;
        m.j(appFragment, b.a.k.b.k(appFragment, R.string.unable_to_open_media_chooser, new Object[]{exc2.getMessage()}, null, 4), 0, 4);
        return Unit.a;
    }
}
