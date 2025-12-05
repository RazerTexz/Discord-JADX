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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.WidgetGuildFolderSettings;
import com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetFolderContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0)};

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
            WidgetFolderContextMenuBinding widgetFolderContextMenuBindingM8414a = WidgetFolderContextMenuBinding.m8414a(LayoutInflater.from(context).inflate(C5419R.layout.widget_folder_context_menu, (ViewGroup) null, false));
            Intrinsics3.checkNotNullExpressionValue(widgetFolderContextMenuBindingM8414a, "WidgetFolderContextMenuB…om(context), null, false)");
            CardView cardView = widgetFolderContextMenuBindingM8414a.f16628a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "WidgetFolderContextMenuB…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetFolderContextMenu newInstance(long folderId) {
            Bundle bundleM832T = outline.m832T("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId);
            WidgetFolderContextMenu widgetFolderContextMenu = new WidgetFolderContextMenu();
            widgetFolderContextMenu.setArguments(bundleM832T);
            return widgetFolderContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
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
                Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
                View decorView = window.getDecorView();
                Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                View rootView = decorView.getRootView();
                Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) rootView;
                Window window2 = activity.getWindow();
                Intrinsics3.checkNotNullExpressionValue(window2, "activity.window");
                View decorView2 = window2.getDecorView();
                Intrinsics3.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetFolderContextMenu.access$setShowingContextMenu$cp(false);
            }
        }

        public final void show(FragmentActivity activity, PointF absolutePosition, long folderId) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(absolutePosition, "absolutePosition");
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
            Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            View rootView = decorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) rootView).addView(frameLayout);
            frameLayout.setOnClickListener(new WidgetFolderContextMenu2(activity));
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setId(View.generateViewId());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            frameLayout.addView(frameLayout2);
            frameLayout2.setX(absolutePosition.x);
            frameLayout2.setY(_Ranges.coerceAtMost(absolutePosition.y, (r1.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetFolderContextMenu.access$getSCREEN_BOTTOM_BUFFER$cp()));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(folderId), WidgetFolderContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$configureValidUI$1 */
    public static final class ViewOnClickListenerC85871 implements View.OnClickListener {
        public ViewOnClickListenerC85871() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFolderContextMenu.access$doCircularRemove(WidgetFolderContextMenu.this);
            WidgetFolderContextMenu.access$getViewModel$p(WidgetFolderContextMenu.this).onMarkAsReadClicked();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$configureValidUI$2 */
    public static final class ViewOnClickListenerC85882 implements View.OnClickListener {
        public final /* synthetic */ FolderContextMenuViewModel.ViewState.Valid $viewState;

        public ViewOnClickListenerC85882(FolderContextMenuViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFolderContextMenu.access$doCircularRemove(WidgetFolderContextMenu.this);
            Long id2 = this.$viewState.getFolder().getId();
            if (id2 != null) {
                WidgetGuildFolderSettings.INSTANCE.create(outline.m821I(WidgetFolderContextMenu.access$getBinding$p(WidgetFolderContextMenu.this).f16632e, "binding.folderContextMenuSettings", "binding.folderContextMenuSettings.context"), id2.longValue());
            }
            WidgetFolderContextMenu.access$getViewModel$p(WidgetFolderContextMenu.this).onSettingsClicked();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$doCircularRemove$1 */
    public static final class C85891 extends AnimatorListenerAdapter {
        public C85891() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            FragmentActivity activity = WidgetFolderContextMenu.this.getActivity();
            if (activity != null) {
                Companion companion = WidgetFolderContextMenu.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                companion.hide(activity, false);
            }
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$doCircularReveal$1 */
    public static final class C85901 extends AnimatorListenerAdapter {
        public C85901() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            WidgetFolderContextMenu.access$setAnimationState$p(WidgetFolderContextMenu.this, null);
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$1 */
    public static final /* synthetic */ class C85911 extends FunctionReferenceImpl implements Function1<FolderContextMenuViewModel.ViewState, Unit> {
        public C85911(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetFolderContextMenu.access$configureUI((WidgetFolderContextMenu) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$2 */
    public static final /* synthetic */ class C85922 extends FunctionReferenceImpl implements Function1<FolderContextMenuViewModel.Event, Unit> {
        public C85922(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetFolderContextMenu.access$handleEvent((WidgetFolderContextMenu) this.receiver, event);
        }
    }

    public WidgetFolderContextMenu() {
        super(C5419R.layout.widget_folder_context_menu);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFolderContextMenu3.INSTANCE, null, 2, null);
        WidgetFolderContextMenu4 widgetFolderContextMenu4 = new WidgetFolderContextMenu4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(FolderContextMenuViewModel.class), new WidgetFolderContextMenu$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFolderContextMenu4));
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
        } else if (Intrinsics3.areEqual(viewState, FolderContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(FolderContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().f16630c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.folderContextMenuHeader");
        CharSequence name = viewState.getFolder().getName();
        if (name == null) {
            name = FormatUtils.m219k(this, C5419R.string.guild_folder_unnamed, new Object[0], null, 4);
        }
        textView.setText(name);
        getBinding().f16631d.setOnClickListener(new ViewOnClickListenerC85871());
        getBinding().f16632e.setOnClickListener(new ViewOnClickListenerC85882(viewState));
        TextView textView2 = getBinding().f16631d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.folderContextMenuMarkAsRead");
        textView2.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f16629b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
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
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
            return;
        }
        AnimationState animationState2 = AnimationState.ANIMATING_OUT;
        if (animationState == animationState2) {
            return;
        }
        CardView cardView = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
        int width = cardView2.getWidth();
        Intrinsics3.checkNotNullExpressionValue(getBinding().f16629b, "binding.folderContextMenuCard");
        float fHypot = (float) Math.hypot(width, r5.getHeight() / 2);
        CardView cardView3 = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        if (!cardView3.isAttachedToWindow()) {
            CardView cardView4 = getBinding().f16629b;
            Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
            cardView4.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f16629b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new C85891());
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f16629b;
            Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        int width = cardView4.getWidth();
        Intrinsics3.checkNotNullExpressionValue(getBinding().f16629b, "binding.folderContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f16629b, 0, height, 0.0f, (float) Math.hypot(width, r4.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new C85901());
        CardView cardView5 = getBinding().f16629b;
        Intrinsics3.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
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
        if (Intrinsics3.areEqual(event, FolderContextMenuViewModel.Event.Dismiss.INSTANCE)) {
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85911(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85922(this), 62, (Object) null);
    }
}
