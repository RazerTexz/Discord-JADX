package p007b.p008a.p036n.p038h;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.overlay.C5570R;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.reflect.KProperty;
import p007b.p008a.p036n.TrashEventListener;
import p007b.p008a.p036n.p037g.TrashWrapBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: OverlayTrashWrap.kt */
/* renamed from: b.a.n.h.a, reason: use source file name */
/* loaded from: classes.dex */
public final class OverlayTrashWrap extends FrameLayout implements TrashEventListener {

    /* renamed from: j */
    public final TrashWrapBinding f1561j;

    /* renamed from: k */
    public WindowManager.LayoutParams f1562k;

    /* renamed from: l */
    public final Animator f1563l;

    /* renamed from: m */
    public final Animator f1564m;

    /* renamed from: n */
    public final Rect f1565n;

    /* renamed from: o */
    public final int[] f1566o;

    /* renamed from: p */
    public OverlayBubbleWrap f1567p;

    /* compiled from: Animator.kt */
    /* renamed from: b.a.n.h.a$a */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
            OverlayTrashWrap.this.setVisibility(0);
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: b.a.n.h.a$b */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
            OverlayTrashWrap.this.setVisibility(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayTrashWrap(Context context) throws Resources.NotFoundException {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5570R.e.trash_wrap, this);
        int i = C5570R.d.trash_wrap_icon;
        ImageView imageView = (ImageView) findViewById(i);
        if (imageView != null) {
            i = C5570R.d.trash_wrap_target_container;
            FrameLayout frameLayout = (FrameLayout) findViewById(i);
            if (frameLayout != null) {
                i = C5570R.d.trash_wrap_target_zone;
                FrameLayout frameLayout2 = (FrameLayout) findViewById(i);
                if (frameLayout2 != null) {
                    TrashWrapBinding trashWrapBinding = new TrashWrapBinding(this, imageView, frameLayout, frameLayout2);
                    Intrinsics3.checkNotNullExpressionValue(trashWrapBinding, "TrashWrapBinding.inflate…ater.from(context), this)");
                    this.f1561j = trashWrapBinding;
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT <= 25 ? 2007 : 2038, 16777768, -3);
                    layoutParams.width = -1;
                    layoutParams.gravity = 81;
                    Intrinsics3.checkNotNullParameter(layoutParams, "$this$addFlag");
                    layoutParams.flags = 16 | layoutParams.flags;
                    this.f1562k = layoutParams;
                    setBackgroundResource(C5570R.c.trash_bg);
                    setVisibility(4);
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), C5570R.a.fade_in);
                    animatorLoadAnimator.setTarget(this);
                    Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), C5570R.a.slide_in_bottom);
                    animatorLoadAnimator2.setTarget(frameLayout2);
                    animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
                    animatorSet.addListener(new a());
                    this.f1563l = animatorSet;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    Animator animatorLoadAnimator3 = AnimatorInflater.loadAnimator(getContext(), C5570R.a.fade_out);
                    animatorLoadAnimator3.setTarget(this);
                    Animator animatorLoadAnimator4 = AnimatorInflater.loadAnimator(getContext(), C5570R.a.slide_out_bottom);
                    animatorLoadAnimator4.setTarget(frameLayout2);
                    animatorSet2.playTogether(animatorLoadAnimator3, animatorLoadAnimator4);
                    animatorSet2.addListener(new b());
                    this.f1564m = animatorSet2;
                    this.f1565n = new Rect();
                    this.f1566o = new int[]{0, 0};
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // p007b.p008a.p036n.TrashEventListener
    /* renamed from: a */
    public void mo227a(OverlayBubbleWrap overlayBubbleWrap) {
        if (overlayBubbleWrap != null) {
            FrameLayout frameLayout = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetContainer");
            frameLayout.setActivated(true);
            int iMax = Math.max(overlayBubbleWrap.getWidth(), overlayBubbleWrap.getHeight());
            FrameLayout frameLayout2 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetContainer");
            float fMax = Math.max(iMax, frameLayout2.getWidth());
            Intrinsics3.checkNotNullExpressionValue(this.f1561j.f1559c, "binding.trashWrapTargetContainer");
            float width = (fMax / r6.getWidth()) + 0.5f;
            FrameLayout frameLayout3 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.trashWrapTargetContainer");
            float scaleX = frameLayout3.getScaleX();
            FrameLayout frameLayout4 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout4, "binding.trashWrapTargetContainer");
            float scaleY = frameLayout4.getScaleY();
            FrameLayout frameLayout5 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout5, "binding.trashWrapTargetContainer");
            float pivotX = frameLayout5.getPivotX();
            FrameLayout frameLayout6 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout6, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation = new ScaleAnimation(scaleX, width, scaleY, width, pivotX, frameLayout6.getPivotY());
            scaleAnimation.setDuration(200L);
            scaleAnimation.setInterpolator(getContext(), R.interpolator.overshoot);
            scaleAnimation.setFillAfter(true);
            this.f1561j.f1559c.startAnimation(scaleAnimation);
        } else {
            FrameLayout frameLayout7 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout7, "binding.trashWrapTargetContainer");
            frameLayout7.setActivated(false);
            setActivated(false);
            FrameLayout frameLayout8 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout8, "binding.trashWrapTargetContainer");
            float scaleX2 = frameLayout8.getScaleX();
            FrameLayout frameLayout9 = this.f1561j.f1559c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout9, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(scaleX2, 1.0f, frameLayout9.getScaleY(), 1.0f);
            scaleAnimation2.setDuration(200L);
            scaleAnimation2.setInterpolator(getContext(), R.interpolator.anticipate);
            scaleAnimation2.setFillAfter(true);
            this.f1561j.f1559c.startAnimation(scaleAnimation2);
        }
        if (!Intrinsics3.areEqual(overlayBubbleWrap, this.f1567p)) {
            if (overlayBubbleWrap != null) {
                ImageView imageView = this.f1561j.f1558b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.trashWrapIcon");
                overlayBubbleWrap.mo390b(imageView);
            }
            performHapticFeedback(Build.VERSION.SDK_INT >= 23 ? 6 : 0);
            OverlayBubbleWrap overlayBubbleWrap2 = this.f1567p;
            if (overlayBubbleWrap2 != null) {
                KProperty[] kPropertyArr = OverlayBubbleWrap.f18620j;
                overlayBubbleWrap2.mo389a(false);
            }
            this.f1567p = overlayBubbleWrap;
        }
    }

    @Override // p007b.p008a.p036n.TrashEventListener
    /* renamed from: b */
    public void mo228b(OverlayBubbleWrap overlayBubbleWrap) {
        Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
        Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
    }

    public final WindowManager.LayoutParams getWindowLayoutParams() {
        return this.f1562k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (z2) {
            this.f1561j.f1560d.getLocationOnScreen(this.f1566o);
            int[] iArr = this.f1566o;
            int i5 = iArr[0];
            int i6 = iArr[1];
            Rect rect = this.f1565n;
            FrameLayout frameLayout = this.f1561j.f1560d;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetZone");
            int width = frameLayout.getWidth() + i5;
            FrameLayout frameLayout2 = this.f1561j.f1560d;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetZone");
            rect.set(i5, i6, width, frameLayout2.getHeight() + i6);
        }
    }

    public final void setWindowLayoutParams(WindowManager.LayoutParams layoutParams) {
        Intrinsics3.checkNotNullParameter(layoutParams, "<set-?>");
        this.f1562k = layoutParams;
    }
}
