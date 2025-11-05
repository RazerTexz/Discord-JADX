package b.a.a;

import android.view.View;
import b.a.a.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SelectorDialog.kt */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ n.b j;

    public o(n.b bVar) {
        this.j = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        n.b bVar = this.j;
        Function1<? super Integer, Unit> function1 = bVar.f49b.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(bVar.getAdapterPosition()));
        }
        this.j.f49b.dismiss();
    }
}
