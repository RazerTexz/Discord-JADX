package p007b.p008a.p018d;

import android.util.TypedValue;
import com.discord.app.AppActivity;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.d.c, reason: use source file name */
/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity3 extends Lambda implements Function2<Integer, Boolean, TypedValue> {
    public final /* synthetic */ AppActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppActivity3(AppActivity appActivity) {
        super(2);
        this.this$0 = appActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public TypedValue invoke(Integer num, Boolean bool) {
        int iIntValue = num.intValue();
        boolean zBooleanValue = bool.booleanValue();
        TypedValue typedValue = new TypedValue();
        this.this$0.getTheme().resolveAttribute(iIntValue, typedValue, zBooleanValue);
        return typedValue;
    }
}
