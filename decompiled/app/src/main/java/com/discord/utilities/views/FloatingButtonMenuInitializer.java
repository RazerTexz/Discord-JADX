package com.discord.utilities.views;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.TableRow;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer {
    private final AnimatorFactory<View> animatorFactoryFadeIn;
    private final AnimatorFactory<View> animatorFactorySlideUp;
    private final Context context;
    private final Map<Integer, View.OnClickListener> onClickListenerMap;

    /* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
    public interface AnimatorFactory<T extends View> {
        Animator createAnimator(T view);
    }

    /* JADX INFO: renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1 */
    /* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
    public static final class C70241 implements AnimatorFactory<ViewGroup> {
        public final /* synthetic */ View $mainFab;

        public C70241(View view) {
            this.$mainFab = view;
        }

        @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
        public /* bridge */ /* synthetic */ Animator createAnimator(View view) {
            return createAnimator((ViewGroup) view);
        }

        public Animator createAnimator(ViewGroup view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.$mainFab, (Property<View, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.$mainFab, (Property<View, Float>) View.SCALE_Y, 0.0f, 1.0f));
            return animatorSet;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$getMenuAnimators$1 */
    /* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
    public static final class C70251 extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup $row;

        public C70251(ViewGroup viewGroup) {
            this.$row = viewGroup;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics3.checkNotNullParameter(animation, "animation");
            this.$row.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$initialize$1 */
    /* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC70261 implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View $mainFab;
        public final /* synthetic */ ViewGroup $menuContainer;

        public ViewTreeObserverOnGlobalLayoutListenerC70261(ViewGroup viewGroup, View view) {
            this.$menuContainer = viewGroup;
            this.$mainFab = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FloatingButtonMenuInitializer floatingButtonMenuInitializer = FloatingButtonMenuInitializer.this;
            FloatingButtonMenuInitializer.access$configureEntranceAnimator(floatingButtonMenuInitializer, FloatingButtonMenuInitializer.access$getMenuAnimators(floatingButtonMenuInitializer, this.$menuContainer, this.$mainFab)).start();
            this.$menuContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingButtonMenuInitializer(Context context, Map<Integer, ? extends View.OnClickListener> map) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(map, "onClickListenerMap");
        this.context = context;
        this.onClickListenerMap = map;
        this.animatorFactoryFadeIn = new FloatingButtonMenuInitializer2(this);
        this.animatorFactorySlideUp = new FloatingButtonMenuInitializer3();
    }

    public static final /* synthetic */ Animator access$configureEntranceAnimator(FloatingButtonMenuInitializer floatingButtonMenuInitializer, Animator[] animatorArr) {
        return floatingButtonMenuInitializer.configureEntranceAnimator(animatorArr);
    }

    public static final /* synthetic */ Context access$getContext$p(FloatingButtonMenuInitializer floatingButtonMenuInitializer) {
        return floatingButtonMenuInitializer.context;
    }

    public static final /* synthetic */ Animator[] access$getMenuAnimators(FloatingButtonMenuInitializer floatingButtonMenuInitializer, ViewGroup viewGroup, View view) {
        return floatingButtonMenuInitializer.getMenuAnimators(viewGroup, view);
    }

    private final Animator configureEntranceAnimator(Animator[] menuRowAnimators) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether((Animator[]) Arrays.copyOf(menuRowAnimators, menuRowAnimators.length));
        animatorSet.setInterpolator(AnimationUtils.loadInterpolator(this.context, R.interpolator.accelerate_decelerate));
        AnimatorSet duration = animatorSet.setDuration(this.context.getResources().getInteger(R.integer.config_shortAnimTime));
        Intrinsics3.checkNotNullExpressionValue(duration, "animatorEntrance.setDura…n(totalDuration.toLong())");
        return duration;
    }

    private final Animator createDefaultMenuRowAnimation(ViewGroup row, View mainFab) {
        return row.getId() == C5419R.id.fab_menu_main ? this.animatorFactoryFadeIn.createAnimator(row) : createMenuRowAnimation(row, this.animatorFactoryFadeIn, getAnimatorFactoryScaleUp(mainFab), this.animatorFactorySlideUp);
    }

    private final Animator createMenuRowAnimation(ViewGroup row, AnimatorFactory<? super ViewGroup>... factories) {
        ArrayList arrayList = new ArrayList(factories.length);
        for (AnimatorFactory<? super ViewGroup> animatorFactory : factories) {
            Animator animatorCreateAnimator = animatorFactory.createAnimator(row);
            if (animatorCreateAnimator != null) {
                arrayList.add(animatorCreateAnimator);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    private final C70241 getAnimatorFactoryScaleUp(View mainFab) {
        return new C70241(mainFab);
    }

    private final Animator[] getMenuAnimators(ViewGroup menuContainer, View mainFab) {
        int childCount = menuContainer.getChildCount();
        Animator[] animatorArr = new Animator[childCount];
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) childAt;
            viewGroup.setVisibility(4);
            Animator animatorCreateDefaultMenuRowAnimation = createDefaultMenuRowAnimation(viewGroup, mainFab);
            if (animatorCreateDefaultMenuRowAnimation != null) {
                animatorCreateDefaultMenuRowAnimation.addListener(new C70251(viewGroup));
            }
            animatorArr[(childCount - 1) - i] = animatorCreateDefaultMenuRowAnimation;
        }
        return animatorArr;
    }

    private final void setFabMenuOnClickListener(TableRow row, View.OnClickListener listener) {
        int childCount = row.getChildCount();
        for (int i = 0; i < childCount; i++) {
            row.getChildAt(i).setOnClickListener(listener);
        }
    }

    public final FloatingButtonMenuInitializer initialize(ViewGroup menuContainer, View mainFab, View.OnClickListener defaultRowOnClickListener) {
        Intrinsics3.checkNotNullParameter(menuContainer, "menuContainer");
        Intrinsics3.checkNotNullParameter(mainFab, "mainFab");
        Intrinsics3.checkNotNullParameter(defaultRowOnClickListener, "defaultRowOnClickListener");
        int childCount = menuContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TableRow");
            TableRow tableRow = (TableRow) childAt;
            tableRow.setOnClickListener(defaultRowOnClickListener);
            setFabMenuOnClickListener(tableRow, this.onClickListenerMap.get(Integer.valueOf(tableRow.getId())));
        }
        menuContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC70261(menuContainer, mainFab));
        return this;
    }
}
