package androidx.view;

import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;
import s.a.h1;

/* compiled from: ViewModel.kt */
/* renamed from: androidx.lifecycle.ViewModelKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewModel3 {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final CoroutineScope getViewModelScope(ViewModel viewModel) {
        Intrinsics3.checkNotNullParameter(viewModel, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag(JOB_KEY);
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Job jobD = f.d(null, 1);
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new ViewModel2(CoroutineContext.Element.a.plus((h1) jobD, MainDispatchers.f3830b.H())));
        Intrinsics3.checkNotNullExpressionValue(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }
}
