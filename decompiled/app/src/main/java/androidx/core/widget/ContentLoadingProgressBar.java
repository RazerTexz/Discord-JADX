package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import p677y.p681b.p684b.RunnableC13191a;
import p677y.p681b.p684b.RunnableC13192b;
import p677y.p681b.p684b.RunnableC13193c;
import p677y.p681b.p684b.RunnableC13194d;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    public boolean mDismissed;
    public boolean mPostedHide;
    public boolean mPostedShow;
    public long mStartTime;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m93a(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.hideOnUiThread();
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m94b(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.showOnUiThread();
    }

    @UiThread
    private void hideOnUiThread() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.mStartTime;
        long j2 = jCurrentTimeMillis - j;
        if (j2 >= 500 || j == -1) {
            setVisibility(8);
        } else {
            if (this.mPostedHide) {
                return;
            }
            postDelayed(this.mDelayedHide, 500 - j2);
            this.mPostedHide = true;
        }
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    @UiThread
    private void showOnUiThread() {
        this.mStartTime = -1L;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (this.mPostedShow) {
            return;
        }
        postDelayed(this.mDelayedShow, 500L);
        this.mPostedShow = true;
    }

    public void hide() {
        post(new RunnableC13192b(this));
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public void show() {
        post(new RunnableC13194d(this));
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mStartTime = -1L;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new RunnableC13191a(this);
        this.mDelayedShow = new RunnableC13193c(this);
    }
}
