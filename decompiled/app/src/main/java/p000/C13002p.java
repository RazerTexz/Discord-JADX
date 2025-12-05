package p000;

import com.discord.views.OverlayMenuBubbleDialog;
import com.discord.views.SearchInputView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: kotlin-style lambda group */
/* renamed from: p */
/* loaded from: classes2.dex */
public final class C13002p extends Lambda implements Function0<Unit> {

    /* renamed from: j */
    public final /* synthetic */ int f27623j;

    /* renamed from: k */
    public final /* synthetic */ Object f27624k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13002p(int i, Object obj) {
        super(0);
        this.f27623j = i;
        this.f27624k = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.f27623j;
        if (i == 0) {
            ((OverlayMenuBubbleDialog) this.f27624k).m387g();
            return Unit.f27425a;
        }
        if (i != 1) {
            throw null;
        }
        ((SearchInputView) this.f27624k).binding.f971c.setText("");
        return Unit.f27425a;
    }
}
