package com.discord.widgets.settings.profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsUserProfileBinding;
import com.discord.simpleast.core.node.Node;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.file.FileUtils2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.MultiValuePropPremiumUpsellDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.SelectorBottomSheet;
import p007b.p008a.p062y.SelectorBottomSheet2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func0;
import p658rx.subjects.BehaviorSubject;

/* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetEditUserOrGuildMemberProfile.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_AVATAR_SIZE = 1024;
    public static final int MAX_BANNER_FILE_SIZE_MB = 30;
    public static final int MAX_BANNER_IMAGE_SIZE = 1080;
    private final BehaviorSubject<String> avatarRepresentativeColorHexSubject;
    private Function1<? super String, Unit> avatarSelectedResult;
    private Function1<? super String, Unit> bannerSelectedResult;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicBoolean discardConfirmed;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private Function1<? super String, Unit> imageSelectedResult;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, AppTransitionActivity.Transition transition, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                transition = null;
            }
            if ((i & 4) != 0) {
                l = null;
            }
            companion.launch(context, transition, l);
        }

        public final void launch(Context context, AppTransitionActivity.Transition transition, Long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (transition != null) {
                intent.putExtra("transition", transition);
            }
            if (guildId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            AppScreen2.m156d(context, WidgetEditUserOrGuildMemberProfile.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "User Profile", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$1 */
    public static final class C99691 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99691(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            if (this.$viewState.getCanHaveAnimatedAvatars() || !IconUtils.INSTANCE.isDataUrlForGif(str)) {
                WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateAvatar(str);
                return;
            }
            MultiValuePropPremiumUpsellDialog.Companion companion = MultiValuePropPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            MultiValuePropPremiumUpsellDialog.Companion.m114a(companion, parentFragmentManager, 4, WidgetEditUserOrGuildMemberProfile.this.getString(C5419R.string.premium_upsell_animated_avatar_active_mobile), null, Traits.Location.Page.USER_SETTINGS, "User Profile", null, null, false, false, 968);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2 */
    public static final class C99702 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $avatarSheetOptions;

        /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f27425a;
            }

            public final void invoke(int i) {
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateAvatar(null);
                } else {
                    WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
                    WidgetEditUserOrGuildMemberProfile.access$setImageSelectedResult$p(widgetEditUserOrGuildMemberProfile, WidgetEditUserOrGuildMemberProfile.access$getAvatarSelectedResult$p(widgetEditUserOrGuildMemberProfile));
                    WidgetEditUserOrGuildMemberProfile.this.openMediaChooser();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99702(List list) {
            super(0);
            this.$avatarSheetOptions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            SelectorBottomSheet.Companion aVar = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            aVar.m379a(childFragmentManager, "", this.$avatarSheetOptions, false, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$1 */
    public static final class C99711 extends Lambda implements Function1<String, Unit> {
        public C99711() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateBannerImage(str);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2 */
    public static final class C99722 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState;

        /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {

            /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132931 extends Lambda implements Function0<Unit> {
                public C132931() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
                    WidgetEditUserOrGuildMemberProfile.access$setImageSelectedResult$p(widgetEditUserOrGuildMemberProfile, WidgetEditUserOrGuildMemberProfile.access$getBannerSelectedResult$p(widgetEditUserOrGuildMemberProfile));
                    WidgetEditUserOrGuildMemberProfile.this.openMediaChooser();
                }
            }

            /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateBannerImage(null);
                }
            }

            /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$3, reason: invalid class name */
            public static final class AnonymousClass3 extends Lambda implements Function1<Integer, Unit> {
                public AnonymousClass3() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    String colorHexFromColorInt;
                    if (num != null) {
                        colorHexFromColorInt = ColorCompat.INSTANCE.getColorHexFromColorInt(num.intValue());
                    } else {
                        colorHexFromColorInt = null;
                    }
                    WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateBannerColor(colorHexFromColorInt);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                WidgetEditProfileBannerSheet.Companion companion = WidgetEditProfileBannerSheet.INSTANCE;
                Long lAccess$getGuildId$p = WidgetEditUserOrGuildMemberProfile.access$getGuildId$p(WidgetEditUserOrGuildMemberProfile.this);
                Intrinsics3.checkNotNullExpressionValue(str, "avatarRepresentativeColorHex");
                String nonDefaultColorPreviewHex = C99722.this.$viewState.getNonDefaultColorPreviewHex();
                boolean hasBannerImageForDisplay = C99722.this.$viewState.getHasBannerImageForDisplay();
                FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(lAccess$getGuildId$p, str, nonDefaultColorPreviewHex, hasBannerImageForDisplay, parentFragmentManager, new C132931(), new AnonymousClass2(), new AnonymousClass3());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99722(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Observable observableM11086L = WidgetEditUserOrGuildMemberProfile.access$getAvatarRepresentativeColorHexSubject$p(WidgetEditUserOrGuildMemberProfile.this).m11100Z(1).m11086L();
            Intrinsics3.checkNotNullExpressionValue(observableM11086L, "avatarRepresentativeColo…  .onBackpressureLatest()");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11086L, WidgetEditUserOrGuildMemberProfile.this, null, 2, null), WidgetEditUserOrGuildMemberProfile.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureUI$3 */
    public static final class C99753<R> implements Func0<Boolean> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState $viewState;

        public C99753(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.valueOf(WidgetEditUserOrGuildMemberProfile.access$handleBackPressed(WidgetEditUserOrGuildMemberProfile.this, (EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) this.$viewState));
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$handleBackPressed$1 */
    public static final class ViewOnClickListenerC99761 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public ViewOnClickListenerC99761(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$handleBackPressed$2 */
    public static final class ViewOnClickListenerC99772 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public ViewOnClickListenerC99772(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditUserOrGuildMemberProfile.access$getDiscardConfirmed$p(WidgetEditUserOrGuildMemberProfile.this).set(true);
            this.$dialog.dismiss();
            FragmentActivity activity = WidgetEditUserOrGuildMemberProfile.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$1 */
    public static final class ViewOnClickListenerC99781 implements View.OnClickListener {
        public final /* synthetic */ View $view;

        public ViewOnClickListenerC99781(View view) {
            this.$view = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2Access$getViewModel$p = WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this);
            Context context = this.$view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            editUserOrGuildMemberProfileViewModel2Access$getViewModel$p.saveChanges(context);
            DimmerView.setDimmed$default(WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).f18084i, true, false, 2, null);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$2 */
    public static final class C99792 extends Lambda implements Function1<MotionEvent, Boolean> {
        public C99792() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(MotionEvent motionEvent) {
            return Boolean.valueOf(invoke2(motionEvent));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                TextInputLayout textInputLayout = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).f18079d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
                int width = textInputLayout.getWidth();
                TextInputLayout textInputLayout2 = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).f18079d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
                int height = textInputLayout2.getHeight();
                int[] iArr = new int[2];
                WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).f18079d.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                if (rawX < ((float) i) || rawX > ((float) (i + width)) || rawY < ((float) i2) || rawY > ((float) (i2 + height))) {
                    CardView cardView = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).f18077b;
                    Intrinsics3.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
                    if (cardView.getVisibility() == 0) {
                        WidgetEditUserOrGuildMemberProfile.access$setCurrentBioFromEditor(WidgetEditUserOrGuildMemberProfile.this);
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$3 */
    public static final class ViewOnClickListenerC99803 implements View.OnClickListener {
        public ViewOnClickListenerC99803() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateIsEditingBio(true);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$4 */
    public static final class C99814 extends Lambda implements Function1<Integer, Unit> {
        public C99814() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetEditUserOrGuildMemberProfile.access$getAvatarRepresentativeColorHexSubject$p(WidgetEditUserOrGuildMemberProfile.this).onNext(ColorCompat.INSTANCE.getColorHexFromColorInt(i));
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$5 */
    public static final class C99825 extends Lambda implements Function1<Badge, Unit> {
        public C99825() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
            invoke2(badge);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Badge badge) {
            Intrinsics3.checkNotNullParameter(badge, "it");
            Badge.Companion companion = Badge.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.onBadgeClick(parentFragmentManager, WidgetEditUserOrGuildMemberProfile.this.requireContext());
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$1 */
    public static final class C99831 extends Lambda implements Function1<EditUserOrGuildMemberProfileViewModel2.ViewState, Unit> {
        public C99831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetEditUserOrGuildMemberProfile.access$configureUI(widgetEditUserOrGuildMemberProfile, viewState);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$2 */
    public static final class C99842 extends Lambda implements Function1<EditUserOrGuildMemberProfileViewModel2.Event, Unit> {
        public C99842() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditUserOrGuildMemberProfileViewModel2.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditUserOrGuildMemberProfileViewModel2.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetEditUserOrGuildMemberProfile.access$handleEvent(WidgetEditUserOrGuildMemberProfile.this, event);
        }
    }

    public WidgetEditUserOrGuildMemberProfile() {
        super(C5419R.layout.widget_settings_user_profile);
        this.avatarSelectedResult = WidgetEditUserOrGuildMemberProfile$avatarSelectedResult$1.INSTANCE;
        this.bannerSelectedResult = WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1.INSTANCE;
        this.imageSelectedResult = WidgetEditUserOrGuildMemberProfile$imageSelectedResult$1.INSTANCE;
        this.guildId = LazyJVM.lazy(new WidgetEditUserOrGuildMemberProfile$guildId$2(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEditUserOrGuildMemberProfile$binding$2.INSTANCE, null, 2, null);
        WidgetEditUserOrGuildMemberProfile$viewModel$2 widgetEditUserOrGuildMemberProfile$viewModel$2 = new WidgetEditUserOrGuildMemberProfile$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EditUserOrGuildMemberProfileViewModel2.class), new C9968xa4470a79(appViewModelDelegates3), new AppViewModelDelegates5(widgetEditUserOrGuildMemberProfile$viewModel$2));
        this.discardConfirmed = new AtomicBoolean(false);
        this.avatarRepresentativeColorHexSubject = BehaviorSubject.m11129k0();
    }

    public static final /* synthetic */ void access$configureUI(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
        widgetEditUserOrGuildMemberProfile.configureUI(viewState);
    }

    public static final /* synthetic */ BehaviorSubject access$getAvatarRepresentativeColorHexSubject$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.avatarRepresentativeColorHexSubject;
    }

    public static final /* synthetic */ Function1 access$getAvatarSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.avatarSelectedResult;
    }

    public static final /* synthetic */ Function1 access$getBannerSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.bannerSelectedResult;
    }

    public static final /* synthetic */ WidgetSettingsUserProfileBinding access$getBinding$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getBinding();
    }

    public static final /* synthetic */ AtomicBoolean access$getDiscardConfirmed$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.discardConfirmed;
    }

    public static final /* synthetic */ Long access$getGuildId$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getGuildId();
    }

    public static final /* synthetic */ Function1 access$getImageSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.imageSelectedResult;
    }

    public static final /* synthetic */ EditUserOrGuildMemberProfileViewModel2 access$getViewModel$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getViewModel();
    }

    public static final /* synthetic */ boolean access$handleBackPressed(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
        return widgetEditUserOrGuildMemberProfile.handleBackPressed(loaded);
    }

    public static final /* synthetic */ void access$handleEvent(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.Event event) {
        widgetEditUserOrGuildMemberProfile.handleEvent(event);
    }

    public static final /* synthetic */ void access$setAvatarSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.avatarSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setBannerSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.bannerSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setCurrentBioFromEditor(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        widgetEditUserOrGuildMemberProfile.setCurrentBioFromEditor();
    }

    public static final /* synthetic */ void access$setImageSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.imageSelectedResult = function1;
    }

    private final void configureAvatarSelect(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        this.avatarSelectedResult = new C99691(viewState);
        SelectorBottomSheet2[] selectorBottomSheet2Arr = new SelectorBottomSheet2[1];
        selectorBottomSheet2Arr[0] = new SelectorBottomSheet2(viewState.getMeMember() != null ? viewState.getHasAvatarForDisplay() ? getString(C5419R.string.change_guild_member_avatar) : getString(C5419R.string.upload_guild_member_avatar) : viewState.getHasAvatarForDisplay() ? getString(C5419R.string.user_settings_change_avatar) : getString(C5419R.string.user_settings_upload_avatar), null, null, null, null, null, null, 116);
        List listMutableListOf = Collections2.mutableListOf(selectorBottomSheet2Arr);
        if (viewState.getHasAvatarForDisplay()) {
            listMutableListOf.add(new SelectorBottomSheet2(viewState.getMeMember() != null ? getString(C5419R.string.change_identity_modal_reset_primary_avatar) : getString(C5419R.string.user_settings_remove_avatar), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_red_500)), null, 84));
        }
        getBinding().f18090o.setOnAvatarEdit(new C99702(listMutableListOf));
    }

    private final void configureBannerSelect(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        this.bannerSelectedResult = new C99711();
        getBinding().f18090o.setOnBannerPress(new C99722(viewState));
    }

    private final void configureBio(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        Drawable drawable;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        boolean showBioEditor = viewState.getShowBioEditor();
        CardView cardView = getBinding().f18077b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
        boolean z2 = cardView.getVisibility() == 0;
        TextView textView = getBinding().f18081f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.bioHelpText");
        textView.setVisibility(viewState.getMeMember() != null ? 0 : 8);
        TextView textView2 = getBinding().f18080e;
        Drawable drawable2 = null;
        textView2.setText(viewState.getMeMember() != null ? FormatUtils.m218j(textView2, C5419R.string.change_identity_bio_header, new Object[0], null, 4) : FormatUtils.m218j(textView2, C5419R.string.user_profile_about_me, new Object[0], null, 4));
        if (viewState.getMeMember() != null && (drawable = ContextCompat.getDrawable(textView2.getContext(), C5419R.drawable.ic_nitro_wheel_16dp)) != null) {
            TextView textView3 = getBinding().f18080e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.bioHeader");
            DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(textView3, C5419R.attr.colorHeaderSecondary));
            drawable2 = drawable;
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(textView2, (Drawable) null, (Drawable) null, drawable2, (Drawable) null, 11, (Object) null);
        CardView cardView2 = getBinding().f18082g;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.bioPreviewCard");
        cardView2.setVisibility(showBioEditor ^ true ? 0 : 8);
        CardView cardView3 = getBinding().f18077b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.bioEditorCard");
        cardView3.setVisibility(showBioEditor ? 0 : 8);
        if (!showBioEditor) {
            if (bioAst != null) {
                LinkifiedTextView linkifiedTextView = getBinding().f18083h;
                Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.bioPreviewText");
                Context context = linkifiedTextView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.bioPreviewText.context");
                getBinding().f18083h.setDraweeSpanStringBuilder(AstRenderer.render(bioAst, new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1(getViewModel()), null, null, 14328, null)));
                return;
            }
            return;
        }
        TextInputLayout textInputLayout = getBinding().f18079d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.setText(textInputLayout, viewState.getCurrentBio());
        if (z2) {
            return;
        }
        getBinding().f18079d.requestFocus();
        TextInputLayout textInputLayout2 = getBinding().f18079d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.moveCursorToEnd(textInputLayout2);
        TextInputLayout textInputLayout3 = getBinding().f18079d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.bioEditorTextInputFieldWrap");
        showKeyboard(textInputLayout3);
    }

    private final void configureFab(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().f18088m;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
        floatingActionButton.setVisibility(viewState.getShowSaveFab() ? 0 : 8);
    }

    private final void configureNick(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        boolean z2 = viewState.getGuild() != null;
        LinearLayout linearLayout = getBinding().f18087l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.nickContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().f18089n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanEditNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanEditNickname() ? getString(C5419R.string.nickname) : getString(C5419R.string.change_identity_modal_change_nickname_disabled));
        textInputLayout.setPlaceholderText(viewState.getUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C9973x9758651b(this, viewState));
        textInputLayout.setEndIconOnClickListener(new ViewOnClickListenerC9974x9758651c(this, viewState));
        TextInputLayout textInputLayout2 = getBinding().f18089n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.setNicknameText");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        if (!Intrinsics3.areEqual(viewState.getCurrentNickname(), textOrEmpty)) {
            ViewExtensions.setText(textInputLayout, viewState.getCurrentNickname());
            if (textOrEmpty.length() == 0) {
                EditText editText = textInputLayout.getEditText();
                Selection.setSelection(editText != null ? editText.getText() : null, ViewExtensions.getTextOrEmpty(textInputLayout).length());
            }
        }
    }

    private final void configureUI(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
        if (viewState instanceof EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) {
            EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded = (EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) viewState;
            if (loaded.getGuild() != null) {
                setActionBarSubtitle(loaded.getGuild().getName());
            }
            configureNick(loaded);
            getBinding().f18086k.setVisibility(loaded.getGuild() != null ? 0 : 8);
            if (loaded.getGuild() != null) {
                TextView textView = getBinding().f18085j;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildMemberProfileHelpTextOverall");
                textView.setText(FormatUtils.m219k(this, C5419R.string.change_identity_help_text_overall, new Object[]{loaded.getGuild().getName()}, null, 4));
            }
            configureBio(loaded);
            configureAvatarSelect(loaded);
            configureBannerSelect(loaded);
            configureFab(loaded);
            AppFragment.setOnBackPressed$default(this, new C99753(viewState), 0, 2, null);
        }
    }

    private final WidgetSettingsUserProfileBinding getBinding() {
        return (WidgetSettingsUserProfileBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getGuildId() {
        return (Long) this.guildId.getValue();
    }

    private final EditUserOrGuildMemberProfileViewModel2 getViewModel() {
        return (EditUserOrGuildMemberProfileViewModel2) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        if (viewState.isEditingBio()) {
            setCurrentBioFromEditor();
            return true;
        }
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingM8394b = ViewDialogConfirmationBinding.m8394b(LayoutInflater.from(getActivity()));
        Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingM8394b, "ViewDialogConfirmationBi…tInflater.from(activity))");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewDialogConfirmationBindingM8394b.f15420a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingM8394b.f15423d.setText(C5419R.string.discard_changes);
        viewDialogConfirmationBindingM8394b.f15424e.setText(C5419R.string.discard_changes_description);
        viewDialogConfirmationBindingM8394b.f15421b.setOnClickListener(new ViewOnClickListenerC99761(alertDialogCreate));
        viewDialogConfirmationBindingM8394b.f15422c.setText(C5419R.string.okay);
        viewDialogConfirmationBindingM8394b.f15422c.setOnClickListener(new ViewOnClickListenerC99772(alertDialogCreate));
        alertDialogCreate.show();
        return true;
    }

    private final void handleEvent(EditUserOrGuildMemberProfileViewModel2.Event event) {
        if (Intrinsics3.areEqual(event, EditUserOrGuildMemberProfileViewModel2.Event.UserUpdateRequestCompleted.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().f18084i, false, false, 2, null);
        }
    }

    private final void setCurrentBioFromEditor() {
        TextInputEditText textInputEditText = getBinding().f18078c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.bioEditorTextInputField");
        getViewModel().updateBio(String.valueOf(textInputEditText.getText()));
        getViewModel().updateIsEditingBio(false);
        getBinding().f18079d.clearFocus();
        hideKeyboard(getBinding().f18079d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0] */
    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!StringsJVM.startsWith$default(mimeType, "image", false, 2, null)) {
            AppToast.m169g(getContext(), C5419R.string.user_settings_image_upload_filetype_error, 0, null, 12);
            return;
        }
        if (!Intrinsics3.areEqual(mimeType, "image/gif")) {
            MGImages.requestImageCrop(requireContext(), this, uri, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 5.0f : 1.0f, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 2.0f : 1.0f, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? MAX_BANNER_IMAGE_SIZE : 1024);
            return;
        }
        Long fileSizeBytes = FileUtils2.getFileSizeBytes(requireContext(), uri);
        if (fileSizeBytes != null && fileSizeBytes.longValue() >= 31457280) {
            AppToast.m170h(requireContext(), FormatUtils.m219k(this, C5419R.string.user_settings_image_upload_file_too_large, new Object[]{30}, null, 4), 0, null, 12);
            return;
        }
        Context context = getContext();
        Function1<? super String, Unit> widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = this.imageSelectedResult;
        if (widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0] */
    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = this.imageSelectedResult;
        if (widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getGuildId() != null) {
            setActionBarTitle(C5419R.string.change_identity);
        } else {
            setActionBarTitle(C5419R.string.user_settings_user_profile);
            setActionBarSubtitle(C5419R.string.user_settings);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f18088m.setOnClickListener(new ViewOnClickListenerC99781(view));
        ((TouchInterceptingCoordinatorLayout) view).setOnInterceptTouchEvent(new C99792());
        getBinding().f18078c.setRawInputType(1);
        getBinding().f18082g.setOnClickListener(new ViewOnClickListenerC99803());
        getBinding().f18090o.setOnAvatarRepresentativeColorUpdated(new C99814());
        getBinding().f18090o.setOnBadgeClick(new C99825());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<EditUserOrGuildMemberProfileViewModel2.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetEditUserOrGuildMemberProfile.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C99831(), 62, (Object) null);
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().f18090o;
        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModel().observeHeaderViewState());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetEditUserOrGuildMemberProfile.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C99842(), 62, (Object) null);
    }
}
