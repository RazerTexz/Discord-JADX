package com.discord.widgets.chat.input.expression;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetExpressionTrayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerMode;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.input.emoji.WidgetEmojiPicker;
import com.discord.widgets.chat.input.expression.ExpressionDetailPage;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import com.discord.widgets.chat.input.gifpicker.WidgetGifCategory;
import com.discord.widgets.chat.input.gifpicker.WidgetGifPicker;
import com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet;
import com.discord.widgets.chat.input.sticker.StickerPickerListener;
import com.discord.widgets.chat.input.sticker.StickerPickerMode;
import com.discord.widgets.chat.input.sticker.WidgetStickerPicker;
import com.discord.widgets.chat.input.sticker.WidgetStickerPickerSheet;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p076b.p077a.FlexInputExpressionTrayStateChangeListener;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: WidgetExpressionTray.kt */
/* loaded from: classes2.dex */
public final class WidgetExpressionTray extends AppFragment implements FlexInputExpressionTrayStateChangeListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetExpressionTray.class, "binding", "getBinding()Lcom/discord/databinding/WidgetExpressionTrayBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BehaviorSubject<Boolean> isExpressionTrayActiveSubject;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetEmojiPicker emojiPickerFragment;
    private boolean emojiPickerInitialized;
    private EmojiPickerListener emojiPickerListener;
    private Map<ExpressionTrayTab, ? extends View> expressionTabToContentViewsMap;

    /* renamed from: expressionTrayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy expressionTrayViewModel;

    /* renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private WidgetGifPicker gifPickerFragment;
    private boolean gifPickerInitialized;
    private final BehaviorSubject<Boolean> isAtInitialScrollPositionSubject;
    private OnBackspacePressedListener onBackspacePressedListener;
    private Function0<Unit> onEmojiSearchOpenedListener;
    private WidgetStickerPicker stickerPickerFragment;
    private boolean stickerPickerInitialized;
    private StickerPickerListener stickerPickerListener;
    private boolean wasActive;

    /* compiled from: WidgetExpressionTray.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BehaviorSubject<Boolean> isExpressionTrayActiveSubject() {
            return WidgetExpressionTray.access$isExpressionTrayActiveSubject$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            ExpressionTrayTab.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.EMOJI;
            iArr[expressionTrayTab.ordinal()] = 1;
            ExpressionTrayTab expressionTrayTab2 = ExpressionTrayTab.GIF;
            iArr[expressionTrayTab2.ordinal()] = 2;
            ExpressionTrayTab expressionTrayTab3 = ExpressionTrayTab.STICKER;
            iArr[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[expressionTrayTab.ordinal()] = 1;
            iArr2[expressionTrayTab2.ordinal()] = 2;
            iArr2[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr3 = new int[3];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[expressionTrayTab.ordinal()] = 1;
            iArr3[expressionTrayTab2.ordinal()] = 2;
            iArr3[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr4 = new int[3];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[expressionTrayTab.ordinal()] = 1;
            iArr4[expressionTrayTab2.ordinal()] = 2;
            iArr4[expressionTrayTab3.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$1 */
    public static final /* synthetic */ class C78501 extends FunctionReferenceImpl implements Function0<Unit> {
        public C78501(WidgetExpressionTray widgetExpressionTray) {
            super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSelected", "onGifSelected()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$onGifSelected((WidgetExpressionTray) this.receiver);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$2 */
    public static final /* synthetic */ class C78512 extends FunctionReferenceImpl implements Function0<Unit> {
        public C78512(WidgetExpressionTray widgetExpressionTray) {
            super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSearchSheetCanceled", "onGifSearchSheetCanceled()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$onGifSearchSheetCanceled((WidgetExpressionTray) this.receiver);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$3 */
    public static final class C78523 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ ExpressionTrayViewModel.Event $event;
        public final /* synthetic */ WidgetStickerPickerSheet $pickerSheet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C78523(WidgetStickerPickerSheet widgetStickerPickerSheet, ExpressionTrayViewModel.Event event) {
            super(1);
            this.$pickerSheet = widgetStickerPickerSheet;
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$pickerSheet.scrollToPack(((ExpressionTrayViewModel.Event.ShowStickerPicker) this.$event).getStickerPackId());
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBound$1 */
    public static final class ViewOnClickListenerC78531 implements View.OnClickListener {
        public ViewOnClickListenerC78531() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ExpressionTrayViewModel expressionTrayViewModelAccess$getExpressionTrayViewModel$p = WidgetExpressionTray.access$getExpressionTrayViewModel$p(WidgetExpressionTray.this);
            TextView textView = WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16611j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            expressionTrayViewModelAccess$getExpressionTrayViewModel$p.clickSearch(textView.getText().toString());
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBound$2 */
    public static final class C78542 implements AppBarLayout.OnOffsetChangedListener {
        public C78542() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            WidgetExpressionTray.access$isAtInitialScrollPositionSubject$p(WidgetExpressionTray.this).onNext(Boolean.valueOf(i == 0));
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBoundOrOnResume$1 */
    public static final class C78551 extends Lambda implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public C78551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetExpressionTray.access$handleViewState(WidgetExpressionTray.this, viewState);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBoundOrOnResume$2 */
    public static final class C78562 extends Lambda implements Function1<ExpressionTrayViewModel.Event, Unit> {
        public C78562() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetExpressionTray.access$handleEvent(WidgetExpressionTray.this, event);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpGifPicker$1 */
    public static final /* synthetic */ class C78571 extends FunctionReferenceImpl implements Function1<GifCategoryItem, Unit> {
        public C78571(ExpressionTrayViewModel expressionTrayViewModel) {
            super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "selectGifCategory", "selectGifCategory(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifCategoryItem gifCategoryItem) {
            invoke2(gifCategoryItem);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifCategoryItem gifCategoryItem) {
            Intrinsics3.checkNotNullParameter(gifCategoryItem, "p1");
            ((ExpressionTrayViewModel) this.receiver).selectGifCategory(gifCategoryItem);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpStickerPicker$1 */
    public static final /* synthetic */ class C78581 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public C78581(WidgetExpressionTray widgetExpressionTray) {
            super(1, widgetExpressionTray, WidgetExpressionTray.class, "showStickersSearchBar", "showStickersSearchBar(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetExpressionTray.access$showStickersSearchBar((WidgetExpressionTray) this.receiver, z2);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpStickerPicker$2 */
    public static final class C78592 extends Lambda implements Function0<Unit> {
        public C78592() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16615n.scrollTo(0, 0);
            WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16615n.setExpanded(true, false);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpTabs$1 */
    public static final class C78601 extends Lambda implements Function1<Integer, Unit> {
        public C78601() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.values()[i];
            TextView textView = WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16611j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText("");
            if (WidgetExpressionTray.access$getStickerPickerInitialized$p(WidgetExpressionTray.this) && WidgetExpressionTray.access$getStickerPickerFragment$p(WidgetExpressionTray.this).isVisible()) {
                WidgetExpressionTray.access$getStickerPickerFragment$p(WidgetExpressionTray.this).clearSearchInput();
            }
            WidgetExpressionTray.access$getExpressionTrayViewModel$p(WidgetExpressionTray.this).selectTab(expressionTrayTab);
            WidgetExpressionTray.access$trackExpressionPickerTabClicked(WidgetExpressionTray.this, expressionTrayTab);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setWindowInsetsListeners$1 */
    public static final class C78611 implements OnApplyWindowInsetsListener {
        public C78611() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16606e, windowInsetsCompat);
            ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16608g, windowInsetsCompat);
            return ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16614m, windowInsetsCompat);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setWindowInsetsListeners$2 */
    public static final class C78622 implements OnApplyWindowInsetsListener {
        public C78622() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).f16604c, windowInsetsCompat);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$trackExpressionPickerOpened$1 */
    public static final class C78631 extends Lambda implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public static final C78631 INSTANCE = new C78631();

        public C78631() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.ViewState viewState) {
            String str;
            int iOrdinal = viewState.getSelectedExpressionTab().ordinal();
            if (iOrdinal == 0) {
                str = "emoji";
            } else if (iOrdinal == 1) {
                str = IconUtils.ANIMATED_IMAGE_EXTENSION;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "sticker";
            }
            AnalyticsTracker.INSTANCE.expressionPickerOpened(str, false);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$trackExpressionPickerTabClicked$1 */
    public static final class C78641 extends Lambda implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public final /* synthetic */ ExpressionTrayTab $clickedTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C78641(ExpressionTrayTab expressionTrayTab) {
            super(1);
            this.$clickedTab = expressionTrayTab;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.ViewState viewState) {
            String str;
            int iOrdinal = this.$clickedTab.ordinal();
            if (iOrdinal == 0) {
                str = "emoji";
            } else if (iOrdinal == 1) {
                str = IconUtils.ANIMATED_IMAGE_EXTENSION;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "sticker";
            }
            AnalyticsTracker.INSTANCE.expressionPickerTabClicked(str, false);
        }
    }

    static {
        BehaviorSubject<Boolean> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(Boolean.FALSE);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(false)");
        isExpressionTrayActiveSubject = behaviorSubjectM11130l0;
    }

    public WidgetExpressionTray() {
        super(C5419R.layout.widget_expression_tray);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetExpressionTray2.INSTANCE, null, 2, null);
        this.expressionTrayViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ExpressionTrayViewModel.class), new C7846xbf25c4f1(this), new AppViewModelDelegates2(WidgetExpressionTray4.INSTANCE));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new C7848xbf25c4f3(this), new AppViewModelDelegates2(new WidgetExpressionTray5(this)));
        this.isAtInitialScrollPositionSubject = BehaviorSubject.m11130l0(Boolean.TRUE);
    }

    public static final /* synthetic */ WidgetExpressionTrayBinding access$getBinding$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.getBinding();
    }

    public static final /* synthetic */ ExpressionTrayViewModel access$getExpressionTrayViewModel$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.getExpressionTrayViewModel();
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.getFlexInputViewModel();
    }

    public static final /* synthetic */ WidgetStickerPicker access$getStickerPickerFragment$p(WidgetExpressionTray widgetExpressionTray) {
        WidgetStickerPicker widgetStickerPicker = widgetExpressionTray.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        return widgetStickerPicker;
    }

    public static final /* synthetic */ boolean access$getStickerPickerInitialized$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.stickerPickerInitialized;
    }

    public static final /* synthetic */ void access$handleEvent(WidgetExpressionTray widgetExpressionTray, ExpressionTrayViewModel.Event event) {
        widgetExpressionTray.handleEvent(event);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetExpressionTray widgetExpressionTray, ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
        widgetExpressionTray.handleViewState(viewState);
    }

    public static final /* synthetic */ BehaviorSubject access$isAtInitialScrollPositionSubject$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.isAtInitialScrollPositionSubject;
    }

    public static final /* synthetic */ BehaviorSubject access$isExpressionTrayActiveSubject$cp() {
        return isExpressionTrayActiveSubject;
    }

    public static final /* synthetic */ void access$onGifSearchSheetCanceled(WidgetExpressionTray widgetExpressionTray) {
        widgetExpressionTray.onGifSearchSheetCanceled();
    }

    public static final /* synthetic */ void access$onGifSelected(WidgetExpressionTray widgetExpressionTray) {
        widgetExpressionTray.onGifSelected();
    }

    public static final /* synthetic */ void access$setStickerPickerFragment$p(WidgetExpressionTray widgetExpressionTray, WidgetStickerPicker widgetStickerPicker) {
        widgetExpressionTray.stickerPickerFragment = widgetStickerPicker;
    }

    public static final /* synthetic */ void access$setStickerPickerInitialized$p(WidgetExpressionTray widgetExpressionTray, boolean z2) {
        widgetExpressionTray.stickerPickerInitialized = z2;
    }

    public static final /* synthetic */ void access$showStickersSearchBar(WidgetExpressionTray widgetExpressionTray, boolean z2) {
        widgetExpressionTray.showStickersSearchBar(z2);
    }

    public static final /* synthetic */ void access$trackExpressionPickerTabClicked(WidgetExpressionTray widgetExpressionTray, ExpressionTrayTab expressionTrayTab) {
        widgetExpressionTray.trackExpressionPickerTabClicked(expressionTrayTab);
    }

    private final void configureDetailPage(ExpressionTrayViewModel.ViewState viewState) {
        Fragment fragmentFindFragmentById;
        ExpressionDetailPage expressionDetailPage = viewState.getExpressionDetailPage();
        if (!(expressionDetailPage instanceof ExpressionDetailPage.GifCategoryPage)) {
            if (expressionDetailPage != null || (fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C5419R.id.expression_tray_detail_page)) == null) {
                return;
            }
            getChildFragmentManager().beginTransaction().remove(fragmentFindFragmentById).commit();
            return;
        }
        WidgetGifCategory widgetGifCategory = new WidgetGifCategory();
        Bundle bundle = new Bundle();
        bundle.putSerializable(WidgetGifCategory.ARG_GIF_CATEGORY_ITEM, ((ExpressionDetailPage.GifCategoryPage) expressionDetailPage).getGifCategoryItem());
        widgetGifCategory.setArguments(bundle);
        widgetGifCategory.setOnGifSelected(new WidgetExpressionTray3(this));
        String simpleName = WidgetGifCategory.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "gifCategoryFragment.javaClass.simpleName");
        setupTabFragment(C5419R.id.expression_tray_detail_page, widgetGifCategory, simpleName);
    }

    private final void configureLandingPage(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
        int i;
        ExpressionTrayTab selectedExpressionTab = viewState.getSelectedExpressionTab();
        int iOrdinal = selectedExpressionTab.ordinal();
        if (iOrdinal == 0) {
            setUpEmojiPicker();
        } else if (iOrdinal == 1) {
            setUpGifPicker();
        } else if (iOrdinal == 2) {
            setUpStickerPicker();
        }
        getBinding().f16612k.setSelectedIndex(getTabIndexFromTabType(selectedExpressionTab));
        Map<ExpressionTrayTab, ? extends View> map = this.expressionTabToContentViewsMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expressionTabToContentViewsMap");
        }
        for (Map.Entry<ExpressionTrayTab, ? extends View> entry : map.entrySet()) {
            ExpressionTrayTab key = entry.getKey();
            View value = entry.getValue();
            int i2 = 0;
            if (!(key == selectedExpressionTab)) {
                i2 = 8;
            }
            value.setVisibility(i2);
        }
        int iOrdinal2 = selectedExpressionTab.ordinal();
        if (iOrdinal2 == 0) {
            i = C5419R.string.search_for_emoji;
        } else if (iOrdinal2 == 1) {
            i = C5419R.string.search_tenor;
        } else {
            if (iOrdinal2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.string.search_for_stickers;
        }
        String string = getResources().getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(searchTextStringRes)");
        TextView textView = getBinding().f16611j;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
        textView.setHint(string);
        RoundedRelativeLayout roundedRelativeLayout = getBinding().f16610i;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.expressionTraySearchBar");
        roundedRelativeLayout.setContentDescription(string);
    }

    private final void fetchDataForTrayOpen() {
        StoreStream.INSTANCE.getStickers().fetchEnabledStickerDirectory();
    }

    private final WidgetExpressionTrayBinding getBinding() {
        return (WidgetExpressionTrayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ExpressionTrayViewModel getExpressionTrayViewModel() {
        return (ExpressionTrayViewModel) this.expressionTrayViewModel.getValue();
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    private final int getTabIndexFromTabType(ExpressionTrayTab tab) {
        Map<ExpressionTrayTab, ? extends View> map = this.expressionTabToContentViewsMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expressionTabToContentViewsMap");
        }
        return _Collections.indexOf(map.keySet(), tab);
    }

    private final void handleEvent(ExpressionTrayViewModel.Event event) {
        if (Intrinsics3.areEqual(event, ExpressionTrayViewModel.Event.HideExpressionTray.INSTANCE)) {
            getFlexInputViewModel().hideExpressionTray();
            return;
        }
        if (Intrinsics3.areEqual(event, ExpressionTrayViewModel.Event.ShowEmojiPickerSheet.INSTANCE)) {
            Function0<Unit> function0 = this.onEmojiSearchOpenedListener;
            if (function0 != null) {
                function0.invoke();
            }
            AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.EMOJI_SEARCH);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, this.emojiPickerListener, EmojiPickerContextType.Chat.INSTANCE, null, 8, null);
            return;
        }
        if (Intrinsics3.areEqual(event, ExpressionTrayViewModel.Event.ShowGifPickerSheet.INSTANCE)) {
            AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.GIF_SEARCH);
            WidgetGifPickerSheet.Companion companion = WidgetGifPickerSheet.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion.show(parentFragmentManager2, new C78501(this), new C78512(this));
            return;
        }
        if (event instanceof ExpressionTrayViewModel.Event.ShowStickerPicker) {
            ExpressionTrayViewModel.Event.ShowStickerPicker showStickerPicker = (ExpressionTrayViewModel.Event.ShowStickerPicker) event;
            if (!showStickerPicker.getInline()) {
                AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.STICKER_SEARCH);
                WidgetStickerPickerSheet.Companion companion2 = WidgetStickerPickerSheet.INSTANCE;
                FragmentManager parentFragmentManager3 = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
                WidgetStickerPickerSheet widgetStickerPickerSheetShow = companion2.show(parentFragmentManager3, this.stickerPickerListener, showStickerPicker.getStickerPackId(), showStickerPicker.getSearchText(), new WidgetExpressionTray6(this));
                Observable<T> observableM11111q = new ScalarSynchronousObservable(Unit.f27425a).m11111q(500L, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableM11111q, "Observable.just(Unit)\n  …0, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11111q, this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78523(widgetStickerPickerSheetShow, event), 62, (Object) null);
                return;
            }
            AnalyticsTracker.INSTANCE.chatInputComponentViewed("sticker");
            setUpStickerPicker();
            getFlexInputViewModel().showExpressionTray();
            TextView textView = getBinding().f16611j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText(showStickerPicker.getSearchText());
            hideKeyboard(getView());
            WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
            if (widgetStickerPicker == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
            }
            String searchText = showStickerPicker.getSearchText();
            if (searchText == null) {
                searchText = "";
            }
            Long stickerPackId = showStickerPicker.getStickerPackId();
            widgetStickerPicker.setupForInlineSearchAndScroll(searchText, stickerPackId != null ? stickerPackId.longValue() : -1L);
        }
    }

    private final void handleViewState(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
        configureLandingPage(viewState);
        configureDetailPage(viewState);
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = getBinding().f16609h;
        Intrinsics3.checkNotNullExpressionValue(contentResizingCoordinatorLayout, "binding.expressionTrayLandingPage");
        contentResizingCoordinatorLayout.setVisibility(viewState.getShowLandingPage() ? 0 : 8);
        FragmentContainerView fragmentContainerView = getBinding().f16605d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.expressionTrayDetailPage");
        boolean z2 = true;
        fragmentContainerView.setVisibility(viewState.getShowLandingPage() ^ true ? 0 : 8);
        RoundedRelativeLayout roundedRelativeLayout = getBinding().f16610i;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.expressionTraySearchBar");
        roundedRelativeLayout.setVisibility(viewState.getShowSearchBar() ? 0 : 8);
        boolean showGifsAndStickers = viewState.getShowGifsAndStickers();
        boolean showGifsAndStickers2 = viewState.getShowGifsAndStickers();
        CardSegment cardSegment = getBinding().f16613l;
        Intrinsics3.checkNotNullExpressionValue(cardSegment, "binding.expressionTrayStickerCard");
        if ((cardSegment.getVisibility() == 0) && !showGifsAndStickers && viewState.getSelectedExpressionTab() == ExpressionTrayTab.STICKER) {
            getExpressionTrayViewModel().selectTab(ExpressionTrayTab.EMOJI);
        }
        CardSegment cardSegment2 = getBinding().f16607f;
        Intrinsics3.checkNotNullExpressionValue(cardSegment2, "binding.expressionTrayGifCard");
        if ((cardSegment2.getVisibility() == 0) && !showGifsAndStickers2 && viewState.getSelectedExpressionTab() == ExpressionTrayTab.GIF) {
            getExpressionTrayViewModel().selectTab(ExpressionTrayTab.EMOJI);
        }
        CardSegment cardSegment3 = getBinding().f16613l;
        Intrinsics3.checkNotNullExpressionValue(cardSegment3, "binding.expressionTrayStickerCard");
        cardSegment3.setVisibility(showGifsAndStickers ? 0 : 8);
        CardSegment cardSegment4 = getBinding().f16607f;
        Intrinsics3.checkNotNullExpressionValue(cardSegment4, "binding.expressionTrayGifCard");
        cardSegment4.setVisibility(showGifsAndStickers2 ? 0 : 8);
        SegmentedControlContainer segmentedControlContainer = getBinding().f16612k;
        Intrinsics3.checkNotNullExpressionValue(segmentedControlContainer, "binding.expressionTraySegmentedControl");
        if (!showGifsAndStickers2 && !showGifsAndStickers) {
            z2 = false;
        }
        segmentedControlContainer.setVisibility(z2 ? 0 : 8);
    }

    private final void initializeExpressionTabToViewsMap() {
        this.expressionTabToContentViewsMap = Maps6.linkedMapOf(Tuples.m10073to(ExpressionTrayTab.EMOJI, getBinding().f16606e), Tuples.m10073to(ExpressionTrayTab.GIF, getBinding().f16608g), Tuples.m10073to(ExpressionTrayTab.STICKER, getBinding().f16614m));
    }

    private final void onGifSearchSheetCanceled() {
        if (isAdded()) {
            getFlexInputViewModel().showKeyboardAndHideExpressionTray();
        }
    }

    private final void onGifSelected() {
        if (isAdded()) {
            getFlexInputViewModel().showKeyboardAndHideExpressionTray();
        }
    }

    private final void setUpEmojiPicker() {
        if (this.emojiPickerInitialized) {
            return;
        }
        this.emojiPickerInitialized = true;
        WidgetEmojiPicker widgetEmojiPicker = new WidgetEmojiPicker();
        widgetEmojiPicker.setListener(this.emojiPickerListener);
        widgetEmojiPicker.setOnBackspacePressedListener(this.onBackspacePressedListener);
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", EmojiPickerMode.INLINE);
        bundle.putSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE, EmojiPickerContextType.Chat.INSTANCE);
        widgetEmojiPicker.setArguments(bundle);
        String simpleName = WidgetEmojiPicker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "emojiPickerFragment.javaClass.simpleName");
        setupTabFragment(C5419R.id.expression_tray_emoji_picker_content, widgetEmojiPicker, simpleName);
        this.emojiPickerFragment = widgetEmojiPicker;
    }

    private final void setUpGifPicker() {
        if (this.gifPickerInitialized) {
            return;
        }
        this.gifPickerInitialized = true;
        WidgetGifPicker widgetGifPicker = new WidgetGifPicker();
        widgetGifPicker.setOnSelectGifCategory(new C78571(getExpressionTrayViewModel()));
        String simpleName = WidgetGifPicker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "gifPickerFragment.javaClass.simpleName");
        setupTabFragment(C5419R.id.expression_tray_gif_picker_content, widgetGifPicker, simpleName);
        this.gifPickerFragment = widgetGifPicker;
    }

    private final void setUpStickerPicker() {
        if (this.stickerPickerInitialized) {
            return;
        }
        this.stickerPickerInitialized = true;
        WidgetStickerPicker widgetStickerPicker = new WidgetStickerPicker();
        widgetStickerPicker.setListener(this.stickerPickerListener);
        widgetStickerPicker.setOnBackspacePressedListener(this.onBackspacePressedListener);
        widgetStickerPicker.setShowSearchBar(new C78581(this));
        widgetStickerPicker.setScrollExpressionPickerToTop(new C78592());
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", StickerPickerMode.INLINE);
        widgetStickerPicker.setArguments(bundle);
        String simpleName = WidgetStickerPicker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "stickerPickerFragment.javaClass.simpleName");
        setupTabFragment(C5419R.id.expression_tray_sticker_picker_content, widgetStickerPicker, simpleName);
        this.stickerPickerFragment = widgetStickerPicker;
    }

    private final void setUpTabs() {
        getBinding().f16612k.m8607a(getTabIndexFromTabType(ExpressionTrayTab.EMOJI));
        getBinding().f16612k.setOnSegmentSelectedChangeListener(new C78601());
    }

    private final void setWindowInsetsListeners() {
        FragmentContainerView fragmentContainerView = getBinding().f16606e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.expressionTrayEmojiPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView);
        FragmentContainerView fragmentContainerView2 = getBinding().f16608g;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.expressionTrayGifPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView2);
        FragmentContainerView fragmentContainerView3 = getBinding().f16614m;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.expressionTrayStickerPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView3);
        FragmentContainerView fragmentContainerView4 = getBinding().f16605d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.expressionTrayDetailPage");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView4);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16604c, new C78611());
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16609h, new C78622());
        FrameLayout frameLayout = getBinding().f16603b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
    }

    private final void setupTabFragment(int fragmentId, AppFragment fragment, String fragmentName) {
        if (isStateSaved()) {
            return;
        }
        getChildFragmentManager().beginTransaction().replace(fragmentId, fragment, fragmentName).commit();
    }

    private final void showStickersSearchBar(boolean show) {
        getExpressionTrayViewModel().showStickersSearchBar(show);
    }

    private final void trackExpressionPickerOpened() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(getExpressionTrayViewModel().observeViewState(), 0L, false, 3, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C78631.INSTANCE, 62, (Object) null);
    }

    private final void trackExpressionPickerTabClicked(ExpressionTrayTab clickedTab) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(getExpressionTrayViewModel().observeViewState(), 0L, false, 3, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78641(clickedTab), 62, (Object) null);
    }

    @Override // p007b.p076b.p077a.FlexInputExpressionTrayStateChangeListener
    public void isShown(boolean isActive) {
        getExpressionTrayViewModel().handleIsActive(isActive);
        isExpressionTrayActiveSubject.onNext(Boolean.valueOf(isActive));
        if (isActive && !this.wasActive) {
            getBinding().f16615n.setExpanded(true);
            if (this.emojiPickerInitialized) {
                WidgetEmojiPicker widgetEmojiPicker = this.emojiPickerFragment;
                if (widgetEmojiPicker == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
                }
                widgetEmojiPicker.scrollToTop();
            }
            if (this.gifPickerInitialized) {
                WidgetGifPicker widgetGifPicker = this.gifPickerFragment;
                if (widgetGifPicker == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
                }
                widgetGifPicker.scrollToTop();
            }
            if (this.stickerPickerInitialized) {
                WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
                if (widgetStickerPicker == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                widgetStickerPicker.scrollToTop();
            }
            fetchDataForTrayOpen();
            trackExpressionPickerOpened();
        } else if (!isActive && this.wasActive) {
            getExpressionTrayViewModel().clickBack();
        }
        if (!isActive) {
            TextView textView = getBinding().f16611j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText("");
            if (this.stickerPickerInitialized) {
                WidgetStickerPicker widgetStickerPicker2 = this.stickerPickerFragment;
                if (widgetStickerPicker2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                if (widgetStickerPicker2.isVisible()) {
                    WidgetStickerPicker widgetStickerPicker3 = this.stickerPickerFragment;
                    if (widgetStickerPicker3 == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                    }
                    widgetStickerPicker3.clearSearchInput();
                }
            }
        }
        if (this.stickerPickerInitialized) {
            WidgetStickerPicker widgetStickerPicker4 = this.stickerPickerFragment;
            if (widgetStickerPicker4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
            }
            if (widgetStickerPicker4.getCanHandleIsShown()) {
                WidgetStickerPicker widgetStickerPicker5 = this.stickerPickerFragment;
                if (widgetStickerPicker5 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                widgetStickerPicker5.isShown(isActive);
            }
        }
        this.wasActive = isActive;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        initializeExpressionTabToViewsMap();
        setUpTabs();
        getBinding().f16610i.setOnClickListener(new ViewOnClickListenerC78531());
        setWindowInsetsListeners();
        getBinding().f16615n.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C78542());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getExpressionTrayViewModel().observeViewState(), this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78551(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getExpressionTrayViewModel().observeEvents(), this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78562(), 62, (Object) null);
    }

    public final void setEmojiPickerListener(EmojiPickerListener emojiPickerListener) {
        Intrinsics3.checkNotNullParameter(emojiPickerListener, "emojiPickerListener");
        this.emojiPickerListener = emojiPickerListener;
    }

    public final void setOnBackspacePressedListener(OnBackspacePressedListener onBackspacePressedListener) {
        this.onBackspacePressedListener = onBackspacePressedListener;
    }

    public final void setOnEmojiSearchOpenedListener(Function0<Unit> callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.onEmojiSearchOpenedListener = callback;
    }

    public final void setStickerPickerListener(StickerPickerListener stickerPickerListener) {
        Intrinsics3.checkNotNullParameter(stickerPickerListener, "stickerPickerListener");
        this.stickerPickerListener = stickerPickerListener;
    }
}
