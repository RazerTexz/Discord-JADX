package p007b.p008a.p062y;

import android.view.View;

/* compiled from: SelectorBottomSheet.kt */
/* renamed from: b.a.y.d0, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectorBottomSheet3 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ SelectorBottomSheet4 f2016j;

    public SelectorBottomSheet3(SelectorBottomSheet4 selectorBottomSheet4) {
        this.f2016j = selectorBottomSheet4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SelectorBottomSheet4 selectorBottomSheet4 = this.f2016j;
        selectorBottomSheet4.f2018a.mo376c(selectorBottomSheet4.getAdapterPosition());
        this.f2016j.f2019b.dismiss();
    }
}
