package p007b.p008a.p018d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.d.e0, reason: use source file name */
/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppViewModelDelegates implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AppViewModelDelegates2 f506a;

    public AppViewModelDelegates(AppViewModelDelegates2 appViewModelDelegates2) {
        this.f506a = appViewModelDelegates2;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics3.checkNotNullParameter(cls, "modelClass");
        return (T) this.f506a.$viewModelProducer.invoke();
    }
}
