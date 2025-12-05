package p007b.p008a.p009a;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.SelectorDialog;

/* compiled from: SelectorDialog.kt */
/* renamed from: b.a.a.o, reason: use source file name */
/* loaded from: classes.dex */
public final class SelectorDialog2 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ SelectorDialog.b f418j;

    public SelectorDialog2(SelectorDialog.b bVar) {
        this.f418j = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SelectorDialog.b bVar = this.f418j;
        Function1<? super Integer, Unit> function1 = bVar.f415b.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(bVar.getAdapterPosition()));
        }
        this.f418j.f415b.dismiss();
    }
}
