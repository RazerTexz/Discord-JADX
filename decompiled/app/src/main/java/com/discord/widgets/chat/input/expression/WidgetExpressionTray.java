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
import b.a.d.f0;
import b.b.a.c;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetExpressionTrayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
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
import d0.t.h0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetExpressionTray.kt */
/* loaded from: classes2.dex */
public final class WidgetExpressionTray extends AppFragment implements c {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetExpressionTray.class, "binding", "getBinding()Lcom/discord/databinding/WidgetExpressionTrayBinding;", 0)};

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
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function0<Unit> {
        public AnonymousClass1(WidgetExpressionTray widgetExpressionTray) {
            super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSelected", "onGifSelected()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$onGifSelected((WidgetExpressionTray) this.receiver);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function0<Unit> {
        public AnonymousClass2(WidgetExpressionTray widgetExpressionTray) {
            super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSearchSheetCanceled", "onGifSearchSheetCanceled()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$onGifSearchSheetCanceled((WidgetExpressionTray) this.receiver);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Unit, Unit> {
        public final /* synthetic */ ExpressionTrayViewModel.Event $event;
        public final /* synthetic */ WidgetStickerPickerSheet $pickerSheet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetStickerPickerSheet widgetStickerPickerSheet, ExpressionTrayViewModel.Event event) {
            super(1);
            this.$pickerSheet = widgetStickerPickerSheet;
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$pickerSheet.scrollToPack(((ExpressionTrayViewModel.Event.ShowStickerPicker) this.$event).getStickerPackId());
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ExpressionTrayViewModel expressionTrayViewModelAccess$getExpressionTrayViewModel$p = WidgetExpressionTray.access$getExpressionTrayViewModel$p(WidgetExpressionTray.this);
            TextView textView = WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).j;
            m.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            expressionTrayViewModelAccess$getExpressionTrayViewModel$p.clickSearch(textView.getText().toString());
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements AppBarLayout.OnOffsetChangedListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            WidgetExpressionTray.access$isAtInitialScrollPositionSubject$p(WidgetExpressionTray.this).onNext(Boolean.valueOf(i == 0));
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetExpressionTray.access$handleViewState(WidgetExpressionTray.this, viewState);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ExpressionTrayViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.Event event) {
            m.checkNotNullParameter(event, "event");
            WidgetExpressionTray.access$handleEvent(WidgetExpressionTray.this, event);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpGifPicker$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<GifCategoryItem, Unit> {
        public AnonymousClass1(ExpressionTrayViewModel expressionTrayViewModel) {
            super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "selectGifCategory", "selectGifCategory(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifCategoryItem gifCategoryItem) {
            invoke2(gifCategoryItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifCategoryItem gifCategoryItem) {
            m.checkNotNullParameter(gifCategoryItem, "p1");
            ((ExpressionTrayViewModel) this.receiver).selectGifCategory(gifCategoryItem);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpStickerPicker$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetExpressionTray widgetExpressionTray) {
            super(1, widgetExpressionTray, WidgetExpressionTray.class, "showStickersSearchBar", "showStickersSearchBar(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetExpressionTray.access$showStickersSearchBar((WidgetExpressionTray) this.receiver, z2);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpStickerPicker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).n.scrollTo(0, 0);
            WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).n.setExpanded(true, false);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpTabs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.values()[i];
            TextView textView = WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).j;
            m.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText("");
            if (WidgetExpressionTray.access$getStickerPickerInitialized$p(WidgetExpressionTray.this) && WidgetExpressionTray.access$getStickerPickerFragment$p(WidgetExpressionTray.this).isVisible()) {
                WidgetExpressionTray.access$getStickerPickerFragment$p(WidgetExpressionTray.this).clearSearchInput();
            }
            WidgetExpressionTray.access$getExpressionTrayViewModel$p(WidgetExpressionTray.this).selectTab(expressionTrayTab);
            WidgetExpressionTray.access$trackExpressionPickerTabClicked(WidgetExpressionTray.this, expressionTrayTab);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setWindowInsetsListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).e, windowInsetsCompat);
            ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).g, windowInsetsCompat);
            return ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).m, windowInsetsCompat);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setWindowInsetsListeners$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnApplyWindowInsetsListener {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).c, windowInsetsCompat);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$trackExpressionPickerOpened$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
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
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$trackExpressionPickerTabClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public final /* synthetic */ ExpressionTrayTab $clickedTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ExpressionTrayTab expressionTrayTab) {
            super(1);
            this.$clickedTab = expressionTrayTab;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
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
        BehaviorSubject<Boolean> behaviorSubjectL0 = BehaviorSubject.l0(Boolean.FALSE);
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(false)");
        isExpressionTrayActiveSubject = behaviorSubjectL0;
    }

    public WidgetExpressionTray() {
        super(R.layout.widget_expression_tray);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetExpressionTray$binding$2.INSTANCE, null, 2, null);
        this.expressionTrayViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ExpressionTrayViewModel.class), new WidgetExpressionTray$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetExpressionTray$expressionTrayViewModel$2.INSTANCE));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetExpressionTray$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(new WidgetExpressionTray$flexInputViewModel$2(this)));
        this.isAtInitialScrollPositionSubject = BehaviorSubject.l0(Boolean.TRUE);
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
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
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
            if (expressionDetailPage != null || (fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.expression_tray_detail_page)) == null) {
                return;
            }
            getChildFragmentManager().beginTransaction().remove(fragmentFindFragmentById).commit();
            return;
        }
        WidgetGifCategory widgetGifCategory = new WidgetGifCategory();
        Bundle bundle = new Bundle();
        bundle.putSerializable(WidgetGifCategory.ARG_GIF_CATEGORY_ITEM, ((ExpressionDetailPage.GifCategoryPage) expressionDetailPage).getGifCategoryItem());
        widgetGifCategory.setArguments(bundle);
        widgetGifCategory.setOnGifSelected(new WidgetExpressionTray$configureDetailPage$gifCategoryFragment$1$2(this));
        String simpleName = WidgetGifCategory.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "gifCategoryFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_detail_page, widgetGifCategory, simpleName);
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
        getBinding().k.setSelectedIndex(getTabIndexFromTabType(selectedExpressionTab));
        Map<ExpressionTrayTab, ? extends View> map = this.expressionTabToContentViewsMap;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("expressionTabToContentViewsMap");
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
            i = R.string.search_for_emoji;
        } else if (iOrdinal2 == 1) {
            i = R.string.search_tenor;
        } else {
            if (iOrdinal2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.search_for_stickers;
        }
        String string = getResources().getString(i);
        m.checkNotNullExpressionValue(string, "resources.getString(searchTextStringRes)");
        TextView textView = getBinding().j;
        m.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
        textView.setHint(string);
        RoundedRelativeLayout roundedRelativeLayout = getBinding().i;
        m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.expressionTraySearchBar");
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
            m.throwUninitializedPropertyAccessException("expressionTabToContentViewsMap");
        }
        return u.indexOf(map.keySet(), tab);
    }

    private final void handleEvent(ExpressionTrayViewModel.Event event) {
        if (m.areEqual(event, ExpressionTrayViewModel.Event.HideExpressionTray.INSTANCE)) {
            getFlexInputViewModel().hideExpressionTray();
            return;
        }
        if (m.areEqual(event, ExpressionTrayViewModel.Event.ShowEmojiPickerSheet.INSTANCE)) {
            Function0<Unit> function0 = this.onEmojiSearchOpenedListener;
            if (function0 != null) {
                function0.invoke();
            }
            AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.EMOJI_SEARCH);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, this.emojiPickerListener, EmojiPickerContextType.Chat.INSTANCE, null, 8, null);
            return;
        }
        if (m.areEqual(event, ExpressionTrayViewModel.Event.ShowGifPickerSheet.INSTANCE)) {
            AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.GIF_SEARCH);
            WidgetGifPickerSheet.Companion companion = WidgetGifPickerSheet.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion.show(parentFragmentManager2, new AnonymousClass1(this), new AnonymousClass2(this));
            return;
        }
        if (event instanceof ExpressionTrayViewModel.Event.ShowStickerPicker) {
            ExpressionTrayViewModel.Event.ShowStickerPicker showStickerPicker = (ExpressionTrayViewModel.Event.ShowStickerPicker) event;
            if (!showStickerPicker.getInline()) {
                AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.STICKER_SEARCH);
                WidgetStickerPickerSheet.Companion companion2 = WidgetStickerPickerSheet.INSTANCE;
                FragmentManager parentFragmentManager3 = getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
                WidgetStickerPickerSheet widgetStickerPickerSheetShow = companion2.show(parentFragmentManager3, this.stickerPickerListener, showStickerPicker.getStickerPackId(), showStickerPicker.getSearchText(), new WidgetExpressionTray$handleEvent$pickerSheet$1(this));
                Observable<T> observableQ = new j0.l.e.k(Unit.a).q(500L, TimeUnit.MILLISECONDS);
                m.checkNotNullExpressionValue(observableQ, "Observable.just(Unit)\n  …0, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableQ, this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(widgetStickerPickerSheetShow, event), 62, (Object) null);
                return;
            }
            AnalyticsTracker.INSTANCE.chatInputComponentViewed("sticker");
            setUpStickerPicker();
            getFlexInputViewModel().showExpressionTray();
            TextView textView = getBinding().j;
            m.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText(showStickerPicker.getSearchText());
            hideKeyboard(getView());
            WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
            if (widgetStickerPicker == null) {
                m.throwUninitializedPropertyAccessException("stickerPickerFragment");
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
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = getBinding().h;
        m.checkNotNullExpressionValue(contentResizingCoordinatorLayout, "binding.expressionTrayLandingPage");
        contentResizingCoordinatorLayout.setVisibility(viewState.getShowLandingPage() ? 0 : 8);
        FragmentContainerView fragmentContainerView = getBinding().d;
        m.checkNotNullExpressionValue(fragmentContainerView, "binding.expressionTrayDetailPage");
        boolean z2 = true;
        fragmentContainerView.setVisibility(viewState.getShowLandingPage() ^ true ? 0 : 8);
        RoundedRelativeLayout roundedRelativeLayout = getBinding().i;
        m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.expressionTraySearchBar");
        roundedRelativeLayout.setVisibility(viewState.getShowSearchBar() ? 0 : 8);
        boolean showGifsAndStickers = viewState.getShowGifsAndStickers();
        boolean showGifsAndStickers2 = viewState.getShowGifsAndStickers();
        CardSegment cardSegment = getBinding().l;
        m.checkNotNullExpressionValue(cardSegment, "binding.expressionTrayStickerCard");
        if ((cardSegment.getVisibility() == 0) && !showGifsAndStickers && viewState.getSelectedExpressionTab() == ExpressionTrayTab.STICKER) {
            getExpressionTrayViewModel().selectTab(ExpressionTrayTab.EMOJI);
        }
        CardSegment cardSegment2 = getBinding().f;
        m.checkNotNullExpressionValue(cardSegment2, "binding.expressionTrayGifCard");
        if ((cardSegment2.getVisibility() == 0) && !showGifsAndStickers2 && viewState.getSelectedExpressionTab() == ExpressionTrayTab.GIF) {
            getExpressionTrayViewModel().selectTab(ExpressionTrayTab.EMOJI);
        }
        CardSegment cardSegment3 = getBinding().l;
        m.checkNotNullExpressionValue(cardSegment3, "binding.expressionTrayStickerCard");
        cardSegment3.setVisibility(showGifsAndStickers ? 0 : 8);
        CardSegment cardSegment4 = getBinding().f;
        m.checkNotNullExpressionValue(cardSegment4, "binding.expressionTrayGifCard");
        cardSegment4.setVisibility(showGifsAndStickers2 ? 0 : 8);
        SegmentedControlContainer segmentedControlContainer = getBinding().k;
        m.checkNotNullExpressionValue(segmentedControlContainer, "binding.expressionTraySegmentedControl");
        if (!showGifsAndStickers2 && !showGifsAndStickers) {
            z2 = false;
        }
        segmentedControlContainer.setVisibility(z2 ? 0 : 8);
    }

    private final void initializeExpressionTabToViewsMap() {
        this.expressionTabToContentViewsMap = h0.linkedMapOf(d0.o.to(ExpressionTrayTab.EMOJI, getBinding().e), d0.o.to(ExpressionTrayTab.GIF, getBinding().g), d0.o.to(ExpressionTrayTab.STICKER, getBinding().m));
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
        m.checkNotNullExpressionValue(simpleName, "emojiPickerFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_emoji_picker_content, widgetEmojiPicker, simpleName);
        this.emojiPickerFragment = widgetEmojiPicker;
    }

    private final void setUpGifPicker() {
        if (this.gifPickerInitialized) {
            return;
        }
        this.gifPickerInitialized = true;
        WidgetGifPicker widgetGifPicker = new WidgetGifPicker();
        widgetGifPicker.setOnSelectGifCategory(new AnonymousClass1(getExpressionTrayViewModel()));
        String simpleName = WidgetGifPicker.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "gifPickerFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_gif_picker_content, widgetGifPicker, simpleName);
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
        widgetStickerPicker.setShowSearchBar(new AnonymousClass1(this));
        widgetStickerPicker.setScrollExpressionPickerToTop(new AnonymousClass2());
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", StickerPickerMode.INLINE);
        widgetStickerPicker.setArguments(bundle);
        String simpleName = WidgetStickerPicker.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "stickerPickerFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_sticker_picker_content, widgetStickerPicker, simpleName);
        this.stickerPickerFragment = widgetStickerPicker;
    }

    private final void setUpTabs() {
        getBinding().k.a(getTabIndexFromTabType(ExpressionTrayTab.EMOJI));
        getBinding().k.setOnSegmentSelectedChangeListener(new AnonymousClass1());
    }

    private final void setWindowInsetsListeners() {
        FragmentContainerView fragmentContainerView = getBinding().e;
        m.checkNotNullExpressionValue(fragmentContainerView, "binding.expressionTrayEmojiPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView);
        FragmentContainerView fragmentContainerView2 = getBinding().g;
        m.checkNotNullExpressionValue(fragmentContainerView2, "binding.expressionTrayGifPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView2);
        FragmentContainerView fragmentContainerView3 = getBinding().m;
        m.checkNotNullExpressionValue(fragmentContainerView3, "binding.expressionTrayStickerPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView3);
        FragmentContainerView fragmentContainerView4 = getBinding().d;
        m.checkNotNullExpressionValue(fragmentContainerView4, "binding.expressionTrayDetailPage");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView4);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, new AnonymousClass1());
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().h, new AnonymousClass2());
        FrameLayout frameLayout = getBinding().f2383b;
        m.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(getExpressionTrayViewModel().observeViewState(), 0L, false, 3, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    private final void trackExpressionPickerTabClicked(ExpressionTrayTab clickedTab) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(getExpressionTrayViewModel().observeViewState(), 0L, false, 3, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(clickedTab), 62, (Object) null);
    }

    @Override // b.b.a.c
    public void isShown(boolean isActive) {
        getExpressionTrayViewModel().handleIsActive(isActive);
        isExpressionTrayActiveSubject.onNext(Boolean.valueOf(isActive));
        if (isActive && !this.wasActive) {
            getBinding().n.setExpanded(true);
            if (this.emojiPickerInitialized) {
                WidgetEmojiPicker widgetEmojiPicker = this.emojiPickerFragment;
                if (widgetEmojiPicker == null) {
                    m.throwUninitializedPropertyAccessException("emojiPickerFragment");
                }
                widgetEmojiPicker.scrollToTop();
            }
            if (this.gifPickerInitialized) {
                WidgetGifPicker widgetGifPicker = this.gifPickerFragment;
                if (widgetGifPicker == null) {
                    m.throwUninitializedPropertyAccessException("gifPickerFragment");
                }
                widgetGifPicker.scrollToTop();
            }
            if (this.stickerPickerInitialized) {
                WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
                if (widgetStickerPicker == null) {
                    m.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                widgetStickerPicker.scrollToTop();
            }
            fetchDataForTrayOpen();
            trackExpressionPickerOpened();
        } else if (!isActive && this.wasActive) {
            getExpressionTrayViewModel().clickBack();
        }
        if (!isActive) {
            TextView textView = getBinding().j;
            m.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText("");
            if (this.stickerPickerInitialized) {
                WidgetStickerPicker widgetStickerPicker2 = this.stickerPickerFragment;
                if (widgetStickerPicker2 == null) {
                    m.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                if (widgetStickerPicker2.isVisible()) {
                    WidgetStickerPicker widgetStickerPicker3 = this.stickerPickerFragment;
                    if (widgetStickerPicker3 == null) {
                        m.throwUninitializedPropertyAccessException("stickerPickerFragment");
                    }
                    widgetStickerPicker3.clearSearchInput();
                }
            }
        }
        if (this.stickerPickerInitialized) {
            WidgetStickerPicker widgetStickerPicker4 = this.stickerPickerFragment;
            if (widgetStickerPicker4 == null) {
                m.throwUninitializedPropertyAccessException("stickerPickerFragment");
            }
            if (widgetStickerPicker4.getCanHandleIsShown()) {
                WidgetStickerPicker widgetStickerPicker5 = this.stickerPickerFragment;
                if (widgetStickerPicker5 == null) {
                    m.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                widgetStickerPicker5.isShown(isActive);
            }
        }
        this.wasActive = isActive;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        initializeExpressionTabToViewsMap();
        setUpTabs();
        getBinding().i.setOnClickListener(new AnonymousClass1());
        setWindowInsetsListeners();
        getBinding().n.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getExpressionTrayViewModel().observeViewState(), this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getExpressionTrayViewModel().observeEvents(), this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public final void setEmojiPickerListener(EmojiPickerListener emojiPickerListener) {
        m.checkNotNullParameter(emojiPickerListener, "emojiPickerListener");
        this.emojiPickerListener = emojiPickerListener;
    }

    public final void setOnBackspacePressedListener(OnBackspacePressedListener onBackspacePressedListener) {
        this.onBackspacePressedListener = onBackspacePressedListener;
    }

    public final void setOnEmojiSearchOpenedListener(Function0<Unit> callback) {
        m.checkNotNullParameter(callback, "callback");
        this.onEmojiSearchOpenedListener = callback;
    }

    public final void setStickerPickerListener(StickerPickerListener stickerPickerListener) {
        m.checkNotNullParameter(stickerPickerListener, "stickerPickerListener");
        this.stickerPickerListener = stickerPickerListener;
    }
}
