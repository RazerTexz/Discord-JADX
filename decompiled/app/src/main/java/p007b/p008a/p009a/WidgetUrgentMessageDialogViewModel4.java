package p007b.p008a.p009a;

import com.discord.api.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.WidgetUrgentMessageDialogViewModel3;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.y, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel4 extends Lambda implements Function1<User, Unit> {
    public final /* synthetic */ WidgetUrgentMessageDialogViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrgentMessageDialogViewModel4(WidgetUrgentMessageDialogViewModel3 widgetUrgentMessageDialogViewModel3) {
        super(1);
        this.this$0 = widgetUrgentMessageDialogViewModel3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
        PublishSubject<WidgetUrgentMessageDialogViewModel3.b> publishSubject = this.this$0.f447k;
        publishSubject.f27650k.onNext(WidgetUrgentMessageDialogViewModel3.b.a.f449a);
        return Unit.f27425a;
    }
}
