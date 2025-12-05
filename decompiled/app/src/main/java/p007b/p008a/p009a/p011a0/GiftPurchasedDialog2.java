package p007b.p008a.p009a.p011a0;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p011a0.GiftPurchasedDialog;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: GiftPurchasedDialog.kt */
/* renamed from: b.a.a.a0.b, reason: use source file name */
/* loaded from: classes.dex */
public final class GiftPurchasedDialog2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ GiftPurchasedDialog.d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftPurchasedDialog2(GiftPurchasedDialog.d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        GiftPurchasedDialog giftPurchasedDialog = GiftPurchasedDialog.this;
        KProperty[] kPropertyArr = GiftPurchasedDialog.f224j;
        giftPurchasedDialog.m103g().f1170f.callOnClick();
        return Unit.f27425a;
    }
}
