package p677y.p681b.p684b;

import androidx.core.widget.ContentLoadingProgressBar;

/* compiled from: lambda */
/* renamed from: y.b.b.a */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC13191a implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ContentLoadingProgressBar f27956j;

    public /* synthetic */ RunnableC13191a(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f27956j = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f27956j;
        contentLoadingProgressBar.mPostedHide = false;
        contentLoadingProgressBar.mStartTime = -1L;
        contentLoadingProgressBar.setVisibility(8);
    }
}
