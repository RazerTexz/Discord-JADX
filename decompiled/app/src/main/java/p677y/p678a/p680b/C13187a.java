package p677y.p678a.p680b;

import androidx.browser.trusted.ConnectionHolder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: renamed from: y.a.b.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C13187a implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ConnectionHolder f27952a;

    public /* synthetic */ C13187a(ConnectionHolder connectionHolder) {
        this.f27952a = connectionHolder;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f27952a.m77a(completer);
    }
}
