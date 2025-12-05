package p007b.p008a.p021f;

import android.view.View;
import com.discord.chips_view.ChipsView;

/* compiled from: ChipsView.kt */
/* renamed from: b.a.f.f, reason: use source file name */
/* loaded from: classes.dex */
public final class ChipsView2 implements View.OnFocusChangeListener {

    /* renamed from: j */
    public final /* synthetic */ ChipsView f621j;

    public ChipsView2(ChipsView chipsView) {
        this.f621j = chipsView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            ChipsView chipsView = this.f621j;
            int i = ChipsView.f14975j;
            chipsView.m8380f(null);
        }
    }
}
