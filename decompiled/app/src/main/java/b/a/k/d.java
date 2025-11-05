package b.a.k;

import android.view.View;
import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: RenderContext.kt */
/* loaded from: classes.dex */
public final class d extends o implements Function2<String, View, Unit> {
    public final /* synthetic */ RenderContext.a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(RenderContext.a aVar) {
        super(2);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, View view) {
        View view2 = view;
        m.checkNotNullParameter(str, "<anonymous parameter 0>");
        m.checkNotNullParameter(view2, "view");
        this.this$0.$onClick.invoke(view2);
        return Unit.a;
    }
}
