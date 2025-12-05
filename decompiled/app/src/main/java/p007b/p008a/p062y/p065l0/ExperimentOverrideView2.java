package p007b.p008a.p062y.p065l0;

import android.view.View;
import android.widget.AdapterView;
import kotlin.jvm.functions.Function1;

/* compiled from: ExperimentOverrideView.kt */
/* renamed from: b.a.y.l0.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class ExperimentOverrideView2 implements AdapterView.OnItemSelectedListener {

    /* renamed from: j */
    public final /* synthetic */ Function1 f2046j;

    public ExperimentOverrideView2(Function1 function1) {
        this.f2046j = function1;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (j != -1) {
            this.f2046j.invoke(Integer.valueOf((int) j));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
