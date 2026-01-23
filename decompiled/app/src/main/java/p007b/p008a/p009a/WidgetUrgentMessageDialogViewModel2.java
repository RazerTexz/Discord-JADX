package p007b.p008a.p009a;

import com.discord.models.user.MeUser;
import p007b.p008a.p009a.WidgetUrgentMessageDialogViewModel3;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: b.a.a.w, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel2<T, R> implements Func1<MeUser, WidgetUrgentMessageDialogViewModel3.c> {

    /* JADX INFO: renamed from: j */
    public static final WidgetUrgentMessageDialogViewModel2 f445j = new WidgetUrgentMessageDialogViewModel2();

    @Override // p637j0.p641k.Func1
    public WidgetUrgentMessageDialogViewModel3.c call(MeUser meUser) {
        MeUser meUser2 = meUser;
        Intrinsics3.checkNotNullExpressionValue(meUser2, "meUser");
        return new WidgetUrgentMessageDialogViewModel3.c(meUser2);
    }
}
