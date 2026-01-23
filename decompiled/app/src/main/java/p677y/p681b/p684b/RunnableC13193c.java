package p677y.p681b.p684b;

import androidx.core.widget.ContentLoadingProgressBar;

/* JADX INFO: renamed from: y.b.b.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC13193c implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ContentLoadingProgressBar f27958j;

    public /* synthetic */ RunnableC13193c(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f27958j = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f27958j;
        contentLoadingProgressBar.mPostedShow = false;
        if (contentLoadingProgressBar.mDismissed) {
            return;
        }
        contentLoadingProgressBar.mStartTime = System.currentTimeMillis();
        contentLoadingProgressBar.setVisibility(0);
    }
}
