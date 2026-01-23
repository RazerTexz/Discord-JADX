package p007b.p008a.p009a.p013d;

import com.discord.C5419R;
import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p013d.UserActionsDialogViewModel5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.h, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel7 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ UserActionsDialogViewModel5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserActionsDialogViewModel7(UserActionsDialogViewModel5 userActionsDialogViewModel5) {
        super(1);
        this.this$0 = userActionsDialogViewModel5;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        PublishSubject<UserActionsDialogViewModel5.b> publishSubject = this.this$0.f330k;
        publishSubject.f27650k.onNext(new UserActionsDialogViewModel5.b.a(C5419R.string.default_failure_to_perform_action_message));
        return Unit.f27425a;
    }
}
