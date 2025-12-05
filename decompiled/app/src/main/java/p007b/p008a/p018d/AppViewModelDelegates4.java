package p007b.p008a.p018d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AppViewModelDelegates.kt */
/* renamed from: b.a.d.h0, reason: use source file name */
/* loaded from: classes.dex */
public final class AppViewModelDelegates4 implements ViewModelProvider.Factory {

    /* renamed from: a */
    public final /* synthetic */ AppViewModelDelegates5 f516a;

    public AppViewModelDelegates4(AppViewModelDelegates5 appViewModelDelegates5) {
        this.f516a = appViewModelDelegates5;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics3.checkNotNullParameter(cls, "modelClass");
        return (T) this.f516a.$viewModelProducer.invoke();
    }
}
