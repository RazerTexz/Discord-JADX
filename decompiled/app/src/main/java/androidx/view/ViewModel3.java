package androidx.view;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.C13116h1;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: renamed from: androidx.lifecycle.ViewModelKt, reason: use source file name */
/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModel3 {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final CoroutineScope getViewModelScope(ViewModel viewModel) {
        Intrinsics3.checkNotNullParameter(viewModel, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag(JOB_KEY);
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Job jobM4279d = C3404f.m4279d(null, 1);
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new ViewModel2(CoroutineContext.Element.C12790a.plus((C13116h1) jobM4279d, MainDispatchers.f27700b.mo11194H())));
        Intrinsics3.checkNotNullExpressionValue(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }
}
