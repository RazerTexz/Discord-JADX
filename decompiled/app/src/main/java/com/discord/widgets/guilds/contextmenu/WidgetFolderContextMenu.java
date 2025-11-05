package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.WidgetGuildFolderSettings;
import com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel;
import d0.d0.f;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetFolderContextMenu.kt */
/* loaded from: classes2.dex */
public final class WidgetFolderContextMenu extends AppFragment {
    private static final String FRAGMENT_TAG = "WidgetFolderContextMenu";
    private static final String VIEW_CONTAINER_TAG = "WidgetFolderContextMenuViewContainer";
    private static boolean isShowingContextMenu;
    private AnimationState animationState;
    private Animator animator;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFolderContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SCREEN_BOTTOM_BUFFER = DimenUtils.dpToPixels(96);

    /* compiled from: WidgetFolderContextMenu.kt */
    public enum AnimationState {
        ANIMATING_IN,
        ANIMATING_OUT
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    public static final class Companion {
        private Companion() {
        }

        private final int computeMaxContextMenuHeight(Context context) {
            WidgetFolderContextMenuBinding widgetFolderContextMenuBindingA = WidgetFolderContextMenuBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_folder_context_menu, (ViewGroup) null, false));
            m.checkNotNullExpressionValue(widgetFolderContextMenuBindingA, "WidgetFolderContextMenuB…om(context), null, false)");
            CardView cardView = widgetFolderContextMenuBindingA.a;
            m.checkNotNullExpressionValue(cardView, "WidgetFolderContextMenuB…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetFolderContextMenu newInstance(long folderId) {
            Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId);
            WidgetFolderContextMenu widgetFolderContextMenu = new WidgetFolderContextMenu();
            widgetFolderContextMenu.setArguments(bundleT);
            return widgetFolderContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(WidgetFolderContextMenu.FRAGMENT_TAG);
            if (!(fragmentFindFragmentByTag instanceof WidgetFolderContextMenu)) {
                fragmentFindFragmentByTag = null;
            }
            WidgetFolderContextMenu widgetFolderContextMenu = (WidgetFolderContextMenu) fragmentFindFragmentByTag;
            if (widgetFolderContextMenu != null) {
                if (animate) {
                    WidgetFolderContextMenu.access$doCircularRemove(widgetFolderContextMenu);
                    return;
                }
                activity.getSupportFragmentManager().beginTransaction().remove(widgetFolderContextMenu).commitAllowingStateLoss();
                Window window = activity.getWindow();
                m.checkNotNullExpressionValue(window, "activity.window");
                View decorView = window.getDecorView();
                m.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                View rootView = decorView.getRootView();
                Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) rootView;
                Window window2 = activity.getWindow();
                m.checkNotNullExpressionValue(window2, "activity.window");
                View decorView2 = window2.getDecorView();
                m.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetFolderContextMenu.access$setShowingContextMenu$cp(false);
            }
        }

        public final void show(FragmentActivity activity, PointF absolutePosition, long folderId) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            m.checkNotNullParameter(absolutePosition, "absolutePosition");
            if (WidgetFolderContextMenu.access$isShowingContextMenu$cp()) {
                return;
            }
            WidgetFolderContextMenu.access$setShowingContextMenu$cp(true);
            computeMaxContextMenuHeight(activity);
            hide(activity, false);
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
            Window window = activity.getWindow();
            m.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            m.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            View rootView = decorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) rootView).addView(frameLayout);
            frameLayout.setOnClickListener(new WidgetFolderContextMenu$Companion$show$1(activity));
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setId(View.generateViewId());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            frameLayout.addView(frameLayout2);
            frameLayout2.setX(absolutePosition.x);
            frameLayout2.setY(f.coerceAtMost(absolutePosition.y, (r1.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetFolderContextMenu.access$getSCREEN_BOTTOM_BUFFER$cp()));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(folderId), WidgetFolderContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$configureValidUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFolderContextMenu.access$doCircularRemove(WidgetFolderContextMenu.this);
            WidgetFolderContextMenu.access$getViewModel$p(WidgetFolderContextMenu.this).onMarkAsReadClicked();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$configureValidUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ FolderContextMenuViewModel.ViewState.Valid $viewState;

        public AnonymousClass2(FolderContextMenuViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFolderContextMenu.access$doCircularRemove(WidgetFolderContextMenu.this);
            Long id2 = this.$viewState.getFolder().getId();
            if (id2 != null) {
                WidgetGuildFolderSettings.INSTANCE.create(a.I(WidgetFolderContextMenu.access$getBinding$p(WidgetFolderContextMenu.this).e, "binding.folderContextMenuSettings", "binding.folderContextMenuSettings.context"), id2.longValue());
            }
            WidgetFolderContextMenu.access$getViewModel$p(WidgetFolderContextMenu.this).onSettingsClicked();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$doCircularRemove$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            FragmentActivity activity = WidgetFolderContextMenu.this.getActivity();
            if (activity != null) {
                Companion companion = WidgetFolderContextMenu.INSTANCE;
                m.checkNotNullExpressionValue(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                companion.hide(activity, false);
            }
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$doCircularReveal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            WidgetFolderContextMenu.access$setAnimationState$p(WidgetFolderContextMenu.this, null);
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<FolderContextMenuViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetFolderContextMenu.access$configureUI((WidgetFolderContextMenu) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<FolderContextMenuViewModel.Event, Unit> {
        public AnonymousClass2(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetFolderContextMenu.access$handleEvent((WidgetFolderContextMenu) this.receiver, event);
        }
    }

    public WidgetFolderContextMenu() {
        super(R.layout.widget_folder_context_menu);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFolderContextMenu$binding$2.INSTANCE, null, 2, null);
        WidgetFolderContextMenu$viewModel$2 widgetFolderContextMenu$viewModel$2 = new WidgetFolderContextMenu$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(FolderContextMenuViewModel.class), new WidgetFolderContextMenu$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetFolderContextMenu$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetFolderContextMenu widgetFolderContextMenu, FolderContextMenuViewModel.ViewState viewState) {
        widgetFolderContextMenu.configureUI(viewState);
    }

    public static final /* synthetic */ void access$doCircularRemove(WidgetFolderContextMenu widgetFolderContextMenu) {
        widgetFolderContextMenu.doCircularRemove();
    }

    public static final /* synthetic */ AnimationState access$getAnimationState$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.animationState;
    }

    public static final /* synthetic */ WidgetFolderContextMenuBinding access$getBinding$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.getBinding();
    }

    public static final /* synthetic */ int access$getSCREEN_BOTTOM_BUFFER$cp() {
        return SCREEN_BOTTOM_BUFFER;
    }

    public static final /* synthetic */ FolderContextMenuViewModel access$getViewModel$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFolderContextMenu widgetFolderContextMenu, FolderContextMenuViewModel.Event event) {
        widgetFolderContextMenu.handleEvent(event);
    }

    public static final /* synthetic */ boolean access$isShowingContextMenu$cp() {
        return isShowingContextMenu;
    }

    public static final /* synthetic */ void access$setAnimationState$p(WidgetFolderContextMenu widgetFolderContextMenu, AnimationState animationState) {
        widgetFolderContextMenu.animationState = animationState;
    }

    public static final /* synthetic */ void access$setShowingContextMenu$cp(boolean z2) {
        isShowingContextMenu = z2;
    }

    private final void configureUI(FolderContextMenuViewModel.ViewState viewState) {
        if (viewState instanceof FolderContextMenuViewModel.ViewState.Valid) {
            configureValidUI((FolderContextMenuViewModel.ViewState.Valid) viewState);
        } else if (m.areEqual(viewState, FolderContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(FolderContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.folderContextMenuHeader");
        CharSequence name = viewState.getFolder().getName();
        if (name == null) {
            name = b.k(this, R.string.guild_folder_unnamed, new Object[0], null, 4);
        }
        textView.setText(name);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        getBinding().e.setOnClickListener(new AnonymousClass2(viewState));
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.folderContextMenuMarkAsRead");
        textView2.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f2386b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (cardView.getVisibility() == 0) {
            return;
        }
        doCircularReveal();
    }

    private final void doCircularRemove() {
        AnimationState animationState = this.animationState;
        if (animationState == AnimationState.ANIMATING_IN) {
            Animator animator = this.animator;
            if (animator != null) {
                animator.cancel();
            }
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
            return;
        }
        AnimationState animationState2 = AnimationState.ANIMATING_OUT;
        if (animationState == animationState2) {
            return;
        }
        CardView cardView = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
        int width = cardView2.getWidth();
        m.checkNotNullExpressionValue(getBinding().f2386b, "binding.folderContextMenuCard");
        float fHypot = (float) Math.hypot(width, r5.getHeight() / 2);
        CardView cardView3 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        if (!cardView3.isAttachedToWindow()) {
            CardView cardView4 = getBinding().f2386b;
            m.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
            cardView4.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnonymousClass1());
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f2386b;
            m.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        int width = cardView4.getWidth();
        m.checkNotNullExpressionValue(getBinding().f2386b, "binding.folderContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, 0.0f, (float) Math.hypot(width, r4.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnonymousClass1());
        CardView cardView5 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
        cardView5.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    private final WidgetFolderContextMenuBinding getBinding() {
        return (WidgetFolderContextMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FolderContextMenuViewModel getViewModel() {
        return (FolderContextMenuViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(FolderContextMenuViewModel.Event event) {
        if (m.areEqual(event, FolderContextMenuViewModel.Event.Dismiss.INSTANCE)) {
            doCircularRemove();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        isShowingContextMenu = false;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
