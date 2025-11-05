package b.p.a;

import android.view.View;
import com.tapadoo.alerter.R;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* compiled from: Alert.kt */
/* loaded from: classes3.dex */
public final class c extends o implements Function0<View> {
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar) {
        super(0);
        this.this$0 = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public View invoke() {
        return this.this$0.findViewById(R.d.vAlertContentContainer);
    }
}
