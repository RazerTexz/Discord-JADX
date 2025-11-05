package b.a.d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;

/* compiled from: AppViewModelDelegates.kt */
/* loaded from: classes.dex */
public final class e0 implements ViewModelProvider.Factory {
    public final /* synthetic */ f0 a;

    public e0(f0 f0Var) {
        this.a = f0Var;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "modelClass");
        return (T) this.a.$viewModelProducer.invoke();
    }
}
